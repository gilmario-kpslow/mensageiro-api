package br.gov.ce.caucaia.mensagerapi;

import javax.json.JsonObject;

/**
 *
 * @author gilmario
 */
public interface ProcessaMensagem {

    public void processar(JsonObject object);

}
