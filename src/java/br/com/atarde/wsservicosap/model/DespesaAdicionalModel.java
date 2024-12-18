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
public class DespesaAdicionalModel implements Serializable {

    private Long id;
    private Long interfaceId;
    private NotaFiscalSaidaABModel notaFiscalSaidaModel;
    private Integer codigo;
    private BigDecimal valor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotaFiscalSaidaABModel getNotaFiscalSaidaModel() {
        return notaFiscalSaidaModel;
    }

    public void setNotaFiscalSaidaModel(NotaFiscalSaidaABModel notaFiscalSaidaModel) {
        this.notaFiscalSaidaModel = notaFiscalSaidaModel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }
    
    
}
