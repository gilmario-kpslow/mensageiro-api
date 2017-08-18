/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.mensagerapi;

import javax.json.JsonObject;

/**
 *
 * @author gilmario
 */
public class LoginMensagem {

    private Integer numero;
    private String nome;

    public void restore(JsonObject object) {
        numero = object.getInt("numero");
        nome = object.getString("nome");
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

}
