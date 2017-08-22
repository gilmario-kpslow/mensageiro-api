package br.gov.ce.caucaia.mensagerapi;

import java.io.Serializable;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author gilmario
 *
 */
public class Mensagem implements Serializable {

    private TipoMensagem tipo;
    private String conteudo;

    public Mensagem() {
    }

    Mensagem(TipoMensagem tipo) {
        this.tipo = tipo;
    }

    public TipoMensagem getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensagem tipo) {
        this.tipo = tipo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
