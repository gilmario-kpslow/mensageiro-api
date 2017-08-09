package br.gov.ce.caucaia.mensagerapi;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author gilmario
 */
@ServerEndpoint(value = "/chat")
@Singleton
public class EndpointWebservice implements Serializable {

    private final Map<Session, String> sessions = new HashMap<>();

    @OnMessage
    public void onMensagem(Session session, String mensagem) {
        sessions.forEach((s, id) -> {
            try {
                s.getBasicRemote().sendText(mensagem);
                System.out.println("Enviando mensagem");
            } catch (IOException ex) {
                Logger.getLogger(EndpointWebservice.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @OnOpen
    public void onOpenSession(Session session) {
        sessions.put(session, session.getId());
        session.getOpenSessions().forEach((s) -> {
            try {
                s.getBasicRemote().sendText("Conectado " + " - " + LocalDateTime.now().getSecond());
                System.out.println("OK");
            } catch (IOException ex) {
                Logger.getLogger(EndpointWebservice.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        System.out.println(sessions.size());
    }

    public void onClose(Session session) {
        System.out.println("Desconectou: " + session.getId());
    }
}
