/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.mensagerapi;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;
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
    private ProcessaMensagem processaMensagem;

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
        Mensagem mensagem = new Mensagem();
        mensagem.restore(mensagemTexto);
        if (mensagem.getTipo().equals(TipoMensagem.LOGIN)) {
            LoginMensagem loginMensagem = new LoginMensagem();
            loginMensagem.restore(mensagem.getConteudo());
            Usuario u = usuarios.get(session.getId());
            Sala s = salas.get(loginMensagem.getNumero());
            s.addUsuario(u);
            session.getBasicRemote().sendText(new UsuariosMensagem(new ArrayList<>(s.getUsuarios().values())).toJson());
        } else if (mensagem.getTipo().equals(TipoMensagem.IN_SALA)) {
            // Retorna a lista de usuarios da sala
            NumeroSalaMensagem numeroSalaMensagem = new NumeroSalaMensagem();
            numeroSalaMensagem.restore(mensagem.getConteudo());
            Sala s = salas.get(numeroSalaMensagem.getNumero());
            session.getBasicRemote().sendText(new UsuariosMensagem(new ArrayList<>(s.getUsuarios().values())).toJson());
        }
    }

    @OnOpen
    public void onOpenSession(Session session, @PathParam(value = "usuario") String nome) throws IOException {
        novoUsuario(nome, session);
        session.getBasicRemote().sendText(new OpenMensagem(new ArrayList<>(salas.values())).toJson());
    }

    public void onClose(Session session, CloseReason closeReason) throws IOException {
        removeUsuario(session.getId());
    }

}
