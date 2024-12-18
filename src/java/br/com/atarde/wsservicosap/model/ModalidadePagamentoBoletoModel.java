/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.util.Date;

/**
 *
 * @author mroland
 */
public class ModalidadePagamentoBoletoModel extends ModalidadePagamentoModel{

    private Date dataVencimento;
    private FormaPagamentoModel formaPagamentoModel;
    private String referencia;
    private BoletoModel boletoModel;

    public ModalidadePagamentoBoletoModel() {
    }

    public ModalidadePagamentoBoletoModel(ContasReceberModel contasReceberModel) {
        this.setContasReceberModel(contasReceberModel);
    }

    public FormaPagamentoModel getFormaPagamentoModel() {
        return formaPagamentoModel;
    }

    public void setFormaPagamentoModel(FormaPagamentoModel formaPagamentoModel) {
        this.formaPagamentoModel = formaPagamentoModel;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BoletoModel getBoletoModel() {
        return boletoModel;
    }

    public void setBoletoModel(BoletoModel boletoModel) {
        this.boletoModel = boletoModel;
    }
}
