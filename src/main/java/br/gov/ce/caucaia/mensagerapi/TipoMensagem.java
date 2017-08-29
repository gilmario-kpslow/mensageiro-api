/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.mensagerapi;

/**
 *
 * @author gilmario
 */
public enum TipoMensagem {

    OPEN_MENSAGEM(new OpenMensagem()), /*IN_SALA()*/ LOGIN(new LoginMensagem());

    private final ProcessaMensagem processaMensagem;

    private TipoMensagem(ProcessaMensagem processaMensagem) {
        this.processaMensagem = processaMensagem;
    }

    public ProcessaMensagem getProcessaMensagem() {
        return processaMensagem;
    }

}
