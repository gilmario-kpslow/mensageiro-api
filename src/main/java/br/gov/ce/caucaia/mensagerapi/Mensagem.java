package br.gov.ce.caucaia.mensagerapi;

import java.io.Serializable;

/**
 *
 * @author gilmario
 *
 */
public class Mensagem implements Serializable {

    private Usuario emissor;
    private Integer numeroSala;
    private Usuario destinatario;
    private String mensagem;

    public Mensagem() {
    }

    public Usuario getEmissor() {
        return emissor;
    }

    public void setEmissor(Usuario emissor) {
        this.emissor = emissor;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
