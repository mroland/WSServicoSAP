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
public class ContabilidadeLinhaModel implements Serializable {

    private Long id;
    private ContaContabilModel contaContabilModel;
    private BigDecimal valorDebito;
    private BigDecimal valorCredito;

    public ContaContabilModel getContaContabilModel() {
        return contaContabilModel;
    }

    public void setContaContabilModel(ContaContabilModel contaContabilModel) {
        this.contaContabilModel = contaContabilModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public BigDecimal getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(BigDecimal valorDebito) {
        this.valorDebito = valorDebito;
    }
}
