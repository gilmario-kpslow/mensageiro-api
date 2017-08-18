package br.gov.ce.caucaia.mensagerapi;

import java.io.Serializable;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author gilmario
 *
 */
public class Mensagem implements Serializable {

    private TipoMensagem tipo;
    private JsonObject conteudo;

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

    public JsonObject toJson() {
        return Json.createObjectBuilder().add("tipo", tipo.toString())
                .add("conteudo", conteudo)
                .build();
    }

    public void restore(JsonObject object) {
        this.tipo = TipoMensagem.valueOf(object.getString("tipo"));
        object.getJsonObject("conteudo");
    }

    public void restore(String object) {
        JsonReader reader = Json.createReader(new StringReader(object));
        restore(reader.readObject());
    }

    public JsonObject getConteudo() {
        return conteudo;
    }

}
