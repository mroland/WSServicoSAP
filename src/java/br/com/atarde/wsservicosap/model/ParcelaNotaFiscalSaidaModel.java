/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ParcelaNotaFiscalSaidaModel implements Serializable {

    private Long id;
    private Integer numero;
    private NotaFiscalSaidaABModel notaFiscalSaidaModel;
    private Date dataVencimento;
    private BigDecimal valorAberto;
    private BigDecimal valorPago;
    private BigDecimal valorTotal;
    private ContasReceberModel contasReceberModel;
    private List<ContasReceberModel> contasReceberModelList;

    public ParcelaNotaFiscalSaidaModel() {
    }
    
    public ParcelaNotaFiscalSaidaModel(ContasReceberModel contasReceberModel){
        
        this.contasReceberModel = contasReceberModel;
        
    }

    public ParcelaNotaFiscalSaidaModel(NotaFiscalSaidaABModel notaFiscalSaidaModel) {
        this.notaFiscalSaidaModel = notaFiscalSaidaModel;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
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

    public BigDecimal getValorAberto() {
        return valorAberto;
    }

    public void setValorAberto(BigDecimal valorAberto) {
        this.valorAberto = valorAberto;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public ContasReceberModel getContasReceberModel() {
        return contasReceberModel;
    }

    public void setContasReceberModel(ContasReceberModel contasReceberModel) {
        this.contasReceberModel = contasReceberModel;
    }

    public List<ContasReceberModel> getContasReceberModelList() {
        return contasReceberModelList;
    }

    public void setContasReceberModelList(List<ContasReceberModel> contasReceberModelList) {
        this.contasReceberModelList = contasReceberModelList;
    }
}
