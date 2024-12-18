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
public class BoletoModel implements Serializable {

    // Tabela OBOE
    private Long id;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private ContabilidadeModel contabilidadeAcrescimoModel;
    private ContabilidadeModel contabilidadeDescontoModel;
    private StatusModel statusModel;
    private String nossoNumero;
    private ArquivoRetornoLinhaModel arquivoRetornoLinhaModel;
    private ModalidadePagamentoBoletoModel modalidadePagamentoBoletoModel;
    private EmpresaModel empresaModel;

    public BoletoModel() {

    }

    public BoletoModel(ModalidadePagamentoBoletoModel modalidadePagamentoBoletoModel) {
        this.modalidadePagamentoBoletoModel = modalidadePagamentoBoletoModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }

    public ContabilidadeModel getContabilidadeAcrescimoModel() {
        return contabilidadeAcrescimoModel;
    }

    public void setContabilidadeAcrescimoModel(ContabilidadeModel contabilidadeAcrescimoModel) {
        this.contabilidadeAcrescimoModel = contabilidadeAcrescimoModel;
    }

    public ContabilidadeModel getContabilidadeDescontoModel() {
        return contabilidadeDescontoModel;
    }

    public void setContabilidadeDescontoModel(ContabilidadeModel contabilidadeDescontoModel) {
        this.contabilidadeDescontoModel = contabilidadeDescontoModel;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public ArquivoRetornoLinhaModel getArquivoRetornoLinhaModel() {
        return arquivoRetornoLinhaModel;
    }

    public void setArquivoRetornoLinhaModel(ArquivoRetornoLinhaModel arquivoRetornoLinhaModel) {
        this.arquivoRetornoLinhaModel = arquivoRetornoLinhaModel;
    }

    public ModalidadePagamentoBoletoModel getModalidadePagamentoBoletoModel() {
        return modalidadePagamentoBoletoModel;
    }

    public void setModalidadePagamentoBoletoModel(ModalidadePagamentoBoletoModel modalidadePagamentoBoletoModel) {
        this.modalidadePagamentoBoletoModel = modalidadePagamentoBoletoModel;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

}
