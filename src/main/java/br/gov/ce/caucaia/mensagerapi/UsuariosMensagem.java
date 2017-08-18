/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.mensagerapi;

import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

/**
 *
 * @author gilmario
 */
public class UsuariosMensagem implements ProcessaMensagem {

    private final List<Usuario> salas;

    public UsuariosMensagem(List<Usuario> salas) {
        this.salas = salas;
    }

    public String toJson() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        salas.forEach((u) -> {
            arrayBuilder.add(Json.createObjectBuilder().add("nome", u.getNome()));
        });
        return Json.createObjectBuilder()
                .add("usuario", arrayBuilder)
                .build().toString();
    }

    @Override
    public void processar(JsonObject object) {

    }

}
