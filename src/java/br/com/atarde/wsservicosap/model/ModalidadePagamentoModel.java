/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author mroland
 */
public abstract class ModalidadePagamentoModel implements Serializable {

    private Long id;
    private BigDecimal valor;
    private ContasReceberModel contasReceberModel;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ContasReceberModel getContasReceberModel() {
        return contasReceberModel;
    }

    public void setContasReceberModel(ContasReceberModel contasReceberModel) {
        this.contasReceberModel = contasReceberModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
