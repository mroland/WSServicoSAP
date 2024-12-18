package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class NotaFiscalSaidaABModel extends DocumentoABModel implements Serializable {

    private Long interfaceId;
    private ParceiroNegocioModel clienteCobrancaModel;
    private VendedorModel vendedorModel;
    private Date dataVencimento;
    private CondicaoPagamentoModel condicaoPagamentoModel;
    private BigDecimal uValorBruto;
    private BigDecimal valorLiquido;
    private String uEnderecoEntrega;
    private SequenciaModel sequenciaModel;
    private List<NotaFiscalSaidaLinhaABModel> notaFiscalSaidaLinhaModelList;
    private List<ParcelaNotaFiscalSaidaModel> parcelaNotaFiscalSaidaModelList;
    private ParcelaNotaFiscalSaidaModel parcelaNotaFiscalSaidaModel;
    private List<DespesaAdicionalModel> despesaAdicionalModelList;
    private BigDecimal percentualDesconto;

    public ParceiroNegocioModel getClienteCobrancaModel() {
        return clienteCobrancaModel;
    }

    public void setClienteCobrancaModel(ParceiroNegocioModel clienteCobrancaModel) {
        this.clienteCobrancaModel = clienteCobrancaModel;
    }

    public BigDecimal getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(BigDecimal valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public VendedorModel getVendedorModel() {
        return vendedorModel;
    }

    public void setVendedorModel(VendedorModel vendedorModel) {
        this.vendedorModel = vendedorModel;
    }

    public List<NotaFiscalSaidaLinhaABModel> getNotaFiscalSaidaLinhaModelList() {
        return notaFiscalSaidaLinhaModelList;
    }

    public void setNotaFiscalSaidaLinhaModelList(List<NotaFiscalSaidaLinhaABModel> notaFiscalSaidaLinhaModelList) {
        this.notaFiscalSaidaLinhaModelList = notaFiscalSaidaLinhaModelList;
    }

    public CondicaoPagamentoModel getCondicaoPagamentoModel() {
        return condicaoPagamentoModel;
    }

    public void setCondicaoPagamentoModel(CondicaoPagamentoModel condicaoPagamentoModel) {
        this.condicaoPagamentoModel = condicaoPagamentoModel;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getuValorBruto() {
        return uValorBruto;
    }

    public void setuValorBruto(BigDecimal uValorBruto) {
        this.uValorBruto = uValorBruto;
    }

    public String getuEnderecoEntrega() {
        return uEnderecoEntrega;
    }

    public void setuEnderecoEntrega(String uEnderecoEntrega) {
        this.uEnderecoEntrega = uEnderecoEntrega;
    }

    public SequenciaModel getSequenciaModel() {
        return sequenciaModel;
    }

    public void setSequenciaModel(SequenciaModel sequenciaModel) {
        this.sequenciaModel = sequenciaModel;
    }

    public List<ParcelaNotaFiscalSaidaModel> getParcelaNotaFiscalSaidaModelList() {
        return parcelaNotaFiscalSaidaModelList;
    }

    public void setParcelaNotaFiscalSaidaModelList(List<ParcelaNotaFiscalSaidaModel> parcelaNotaFiscalSaidaModelList) {
        this.parcelaNotaFiscalSaidaModelList = parcelaNotaFiscalSaidaModelList;
    }

    public ParcelaNotaFiscalSaidaModel getParcelaNotaFiscalSaidaModel() {
        return parcelaNotaFiscalSaidaModel;
    }

    public void setParcelaNotaFiscalSaidaModel(ParcelaNotaFiscalSaidaModel parcelaNotaFiscalSaidaModel) {
        this.parcelaNotaFiscalSaidaModel = parcelaNotaFiscalSaidaModel;
    }

    public List<DespesaAdicionalModel> getDespesaAdicionalModelList() {
        return despesaAdicionalModelList;
    }

    public void setDespesaAdicionalModelList(List<DespesaAdicionalModel> despesaAdicionalModelList) {
        this.despesaAdicionalModelList = despesaAdicionalModelList;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

}
