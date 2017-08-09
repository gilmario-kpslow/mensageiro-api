package br.gov.ce.caucaia.mensagerapi;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author gilmario
 */
@ServerEndpoint(value = "/mensagem")
public class EndpointWebservice implements Serializable {

    @OnMessage
    public void onMensagem(Session session, String mensagem) {
        session.getOpenSessions().forEach((s) -> {
            s.getAsyncRemote().sendText(mensagem + " - " + LocalDateTime.now().getSecond());
        });
    }

    @OnOpen
    public void onOpenSession(Session session, String mensagem) {
        System.out.println("Conectou: " + mensagem);
    }

    public void onClose(Session session) {
        System.out.println("Desconectou: " + session.getId());
    }
}
