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
public class OpenMensagem implements ProcessaMensagem {

    private final List<Sala> salas;

    public OpenMensagem(List<Sala> salas) {
        this.salas = salas;
    }

    public String toJson() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        salas.forEach((sala) -> {
            arrayBuilder.add(Json.createObjectBuilder().add("numero", sala.getNumero()).add("nome", sala.getNome()));
        });
        return Json.createObjectBuilder()
                .add("salas", arrayBuilder)
                .build().toString();
    }

    @Override
    public void processar(JsonObject object) {

    }

}
