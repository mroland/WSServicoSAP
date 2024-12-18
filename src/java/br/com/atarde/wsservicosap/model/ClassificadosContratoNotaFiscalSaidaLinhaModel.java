/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.math.BigDecimal;

/**
 *
 * @author mroland
 */
public class ClassificadosContratoNotaFiscalSaidaLinhaModel extends NotaFiscalSaidaLinhaABModel {

    private String uCmXCol;
    private BigDecimal uArea;
    private Integer uQuantidadeInsercoes;
    private BigDecimal uTotalCmXCol;
    private BigDecimal uValorUnitario;
    private BigDecimal valorUnitario;

    public BigDecimal getUArea() {
        return uArea;
    }

    public void setUArea(BigDecimal uArea) {
        this.uArea = uArea;
    }

    public String getUCmXCol() {
        return uCmXCol;
    }

    public void setUCmXCol(String uCmXCol) {
        this.uCmXCol = uCmXCol;
    }

    public BigDecimal getUValorUnitario() {
        return uValorUnitario;
    }

    public void setUValorUnitario(BigDecimal uValorUnitario) {
        this.uValorUnitario = uValorUnitario;
    }

    public Integer getUQuantidadeInsercoes() {
        return uQuantidadeInsercoes;
    }

    public void setUQuantidadeInsercoes(Integer uQuantidadeInsercoes) {
        this.uQuantidadeInsercoes = uQuantidadeInsercoes;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getUTotalCmXCol() {
        return uTotalCmXCol;
    }

    public void setUTotalCmXCol(BigDecimal uTotalCmXCol) {
        this.uTotalCmXCol = uTotalCmXCol;
    }
}
