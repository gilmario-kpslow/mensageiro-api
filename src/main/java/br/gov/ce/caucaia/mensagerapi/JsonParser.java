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
public interface JsonParser {

    public JsonObject toJson();

    public void restore(JsonObject object);

    public void restore(String object);
}
