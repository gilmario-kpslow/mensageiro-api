package br.gov.ce.caucaia.mensagerapi;

import java.io.Serializable;
import java.util.Objects;
import javax.json.JsonObject;
import javax.websocket.Session;

/**
 *
 * @author gilmario
 */
public class Usuario implements Serializable {

    private String nome;
    private Session session;

    public Usuario() {
    }

    public void restore(JsonObject object) {
        nome = object.getString("nome");

    }

    public Usuario(String nome, Session session) {
        this.nome = nome;
        this.session = session;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Session getSession() {
        return session;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.nome, other.nome);
    }

}
