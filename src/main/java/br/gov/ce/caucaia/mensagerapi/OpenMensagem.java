/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.mensagerapi;

import java.util.List;

/**
 *
 * @author gilmario
 */
public class OpenMensagem implements ProcessaMensagem {

    @Override
    public void processar(String mensagem) {

    }

    public String convertSalas(List<Sala> salas) {
        return JsonConverter.converter(salas);
    }

}
