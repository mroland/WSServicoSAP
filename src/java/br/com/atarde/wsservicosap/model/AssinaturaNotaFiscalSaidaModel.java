/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

/**
 *
 * @author mroland
 */
public class AssinaturaNotaFiscalSaidaModel extends NotaFiscalSaidaABModel {

    private String uObservacao;
    private String observacao;  // referente a comments

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getuObservacao() {
        return uObservacao;
    }

    public void setuObservacao(String uObservacao) {
        this.uObservacao = uObservacao;
    }

}
