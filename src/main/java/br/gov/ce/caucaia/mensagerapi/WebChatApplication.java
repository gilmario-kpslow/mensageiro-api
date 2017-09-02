package br.gov.ce.caucaia.mensagerapi;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Singleton;
//import javax.ejb.Singleton;
import javax.websocket.CloseReason;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author gilmario
 */
@ServerEndpoint(value = "/chat/{usuario}")
@Singleton
public class WebChatApplication implements Serializable {

    private final Map<Integer, Sala> salas = new HashMap<>();
    private final Map<String, Usuario> usuarios = new HashMap<>();

    public void novaSala(String nome) {
        salas.put(salas.size() + 1, new Sala(salas.size() + 1, nome));
    }

    public void novoUsuario(String nome, Session session) {
        usuarios.put(session.getId(), new Usuario(nome, session));
    }

    public void removeUsuario(String sessionId) {
        salas.forEach((a, s) -> {
            s.removeUsuario(sessionId);
        });
    }

    @OnMessage
    public void onMensagem(Session session, String mensagemTexto) throws IOException {
        processaTipo(mensagemTexto).getProcessaMensagem().processar(mensagemTexto);
    }

    @OnOpen
    public void onOpenSession(Session session, @PathParam(value = "usuario") String nome) throws IOException {
        novoUsuario(nome, session);
        session.getBasicRemote().sendText(JsonConverter.converter(new ArrayList<>(salas.values())));
    }

    public void onClose(Session session, CloseReason closeReason) throws IOException {
        removeUsuario(session.getId());
    }

    private TipoMensagem processaTipo(String mensagemTexto) {
        Matcher matcher = Pattern.compile("\"TIPO\":\"[A-Z]\"").matcher(mensagemTexto);
        return TipoMensagem.valueOf(mensagemTexto.substring(matcher.start(), matcher.end()));
    }

}
