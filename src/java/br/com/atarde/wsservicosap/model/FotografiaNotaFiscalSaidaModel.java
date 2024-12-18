/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

/**
 *
 * @author mroland
 */
public class FotografiaNotaFiscalSaidaModel extends NotaFiscalSaidaABModel {

    private String observacao;      // referente a comments
    private String uObservacao;
    private String uLimitacaoUso;

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

    public String getuLimitacaoUso() {
        return uLimitacaoUso;
    }

    public void setuLimitacaoUso(String uLimitacaoUso) {
        this.uLimitacaoUso = uLimitacaoUso;
    }
}
