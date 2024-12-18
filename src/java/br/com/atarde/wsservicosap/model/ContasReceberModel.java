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
public class ContasReceberModel implements Serializable {

    private Long id;
    private ParceiroNegocioModel parceiroNegocioModel;
    private ModalidadePagamentoModel modalidadePagamentoModel;
    private BigDecimal valor;
    private List<ParcelaNotaFiscalSaidaModel> parcelaNotaFiscalSaidaModelList;
    private ParcelaNotaFiscalSaidaModel parcelaNotaFiscalSaidaModel;
    private Date dataVencimento;
    private Date dataDocumento;
    private Date dataLancamento;
    private Date dataPagamento;
    private Date dataCriacao;
    private StatusModel statusModel;
    private String tipoModalidade;
    private Date dataExportacao;
    private ContasReceberInterfaceModel contasReceberInterfaceModel;
    private ContasReceberBoletoRejeitadoModel contasReceberBoletoRejeitadoModel;

    public ContasReceberModel() {
    }

    public ContasReceberModel(ParcelaNotaFiscalSaidaModel parcela) {
        this.parcelaNotaFiscalSaidaModel = parcela;
    }

    public Date getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(Date dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
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

    public ModalidadePagamentoModel getModalidadePagamentoModel() {
        return modalidadePagamentoModel;
    }

    public void setModalidadePagamentoModel(ModalidadePagamentoModel modalidadePagamentoModel) {
        this.modalidadePagamentoModel = modalidadePagamentoModel;
    }

    public ParceiroNegocioModel getParceiroNegocioModel() {
        return parceiroNegocioModel;
    }

    public void setParceiroNegocioModel(ParceiroNegocioModel parceiroNegocioModel) {
        this.parceiroNegocioModel = parceiroNegocioModel;
    }

    public List<ParcelaNotaFiscalSaidaModel> getParcelaNotaFiscalSaidaModelList() {
        return parcelaNotaFiscalSaidaModelList;
    }

    public void setParcelaNotaFiscalSaidaModelList(List<ParcelaNotaFiscalSaidaModel> parcelaNotaFiscalSaidaModelList) {
        this.parcelaNotaFiscalSaidaModelList = parcelaNotaFiscalSaidaModelList;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipoModalidade() {
        return tipoModalidade;
    }

    public void setTipoModalidade(String tipoModalidade) {
        this.tipoModalidade = tipoModalidade;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public ParcelaNotaFiscalSaidaModel getParcelaNotaFiscalSaidaModel() {
        return parcelaNotaFiscalSaidaModel;
    }

    public void setParcelaNotaFiscalSaidaModel(ParcelaNotaFiscalSaidaModel parcelaNotaFiscalSaidaModel) {
        this.parcelaNotaFiscalSaidaModel = parcelaNotaFiscalSaidaModel;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataExportacao() {
        return dataExportacao;
    }

    public void setDataExportacao(Date dataExportacao) {
        this.dataExportacao = dataExportacao;
    }

    public ContasReceberInterfaceModel getContasReceberInterfaceModel() {
        return contasReceberInterfaceModel;
    }

    public void setContasReceberInterfaceModel(ContasReceberInterfaceModel contasReceberInterfaceModel) {
        this.contasReceberInterfaceModel = contasReceberInterfaceModel;
    }

    public ContasReceberBoletoRejeitadoModel getContasReceberBoletoRejeitadoModel() {
        return contasReceberBoletoRejeitadoModel;
    }

    public void setContasReceberBoletoRejeitadoModel(ContasReceberBoletoRejeitadoModel contasReceberBoletoRejeitadoModel) {
        this.contasReceberBoletoRejeitadoModel = contasReceberBoletoRejeitadoModel;
    }
}
