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
public class SvgNotaFiscalSaidaLinhaModel extends NotaFiscalSaidaLinhaABModel{

    private BigDecimal valorUnitario;

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }


}
