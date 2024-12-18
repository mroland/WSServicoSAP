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
public class ModalidadePagamentoTransferenciaModel extends ModalidadePagamentoModel{

    private Date dataTransferencia;

    private String referencia;

    private ContaContabilModel contaContabilModel;

    public ModalidadePagamentoTransferenciaModel(){

    }

    public ModalidadePagamentoTransferenciaModel(ContasReceberModel contasReceberModel) {
        this.setContasReceberModel(contasReceberModel);
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public ContaContabilModel getContaContabilModel() {
        return contaContabilModel;
    }

    public void setContaContabilModel(ContaContabilModel contaContabilModel) {
        this.contaContabilModel = contaContabilModel;
    }


}
