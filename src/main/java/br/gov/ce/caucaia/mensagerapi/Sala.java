package br.gov.ce.caucaia.mensagerapi;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author gilmario
 */
public class Sala implements Serializable {

    private Integer numero;
    private String nome;
    private final Map<String, Usuario> usuarios = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(Sala.class.getName());

    public Sala() {

    }

    public Sala(Integer numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.put(usuario.getSession().getId(), usuario);
    }

    public void removeUsuario(String sessionID) {
        usuarios.remove(sessionID);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public Map<String, Usuario> getUsuarios() {
        return Collections.unmodifiableMap(usuarios);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.numero);
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
        final Sala other = (Sala) obj;
        return Objects.equals(this.numero, other.numero);
    }

}
