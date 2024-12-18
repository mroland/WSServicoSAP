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
public class EasyclassPedidoVendaLinhaModel extends NotaFiscalSaidaLinhaABModel {

    private String uCmXCol;
    private BigDecimal uArea;
    private Integer uQuantidadeInsercoes;
    private BigDecimal uTotalCmXCol;
    private BigDecimal uValorUnitario;
    private BigDecimal valorUnitario;

    public BigDecimal getuArea() {
        return uArea;
    }

    public void setuArea(BigDecimal uArea) {
        this.uArea = uArea;
    }

    public String getuCmXCol() {
        return uCmXCol;
    }

    public void setuCmXCol(String uCmXCol) {
        this.uCmXCol = uCmXCol;
    }

    public BigDecimal getuValorUnitario() {
        return uValorUnitario;
    }

    public void setuValorUnitario(BigDecimal uValorUnitario) {
        this.uValorUnitario = uValorUnitario;
    }

    public Integer getuQuantidadeInsercoes() {
        return uQuantidadeInsercoes;
    }

    public void setuQuantidadeInsercoes(Integer uQuantidadeInsercoes) {
        this.uQuantidadeInsercoes = uQuantidadeInsercoes;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getuTotalCmXCol() {
        return uTotalCmXCol;
    }

    public void setuTotalCmXCol(BigDecimal uTotalCmXCol) {
        this.uTotalCmXCol = uTotalCmXCol;
    }
}
