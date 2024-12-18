package br.com.atarde.wsservicosap.model;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class EasyclassPedidoVendaModel extends NotaFiscalSaidaABModel {

    private ParceiroNegocioModel clienteModel;
    private BigDecimal uComissaoAgencia;
    private String uDiasPublicacao;
    private Date uDataPublicacaoFinal;
    private String uTituloPublicacao;
    private String uNumeroPI;
    private String uTipoTransacao;
    private String uPeriodo;
    private String uFormato;
    private BigDecimal uPageViews;
    private String uEntregaVendedor;
    private String uProduto;
    private String uCampanha;
    private String uPostoId;
    private Date uDataPublicacaoInicial;
    private String uObservacao;
    private Integer uPermuta;

    public EasyclassPedidoVendaModel() {

    }

    public EasyclassPedidoVendaModel(String tipo, Long interfaceId) {

        if (tipo.equals("interfaceId")) {
            this.setInterfaceId(interfaceId);
        }

    }

    public Integer getUPermuta() {
        return uPermuta;
    }

    public void setUPermuta(Integer uPermuta) {
        this.uPermuta = uPermuta;
    }

    public String getUObservacao() {
        return uObservacao;
    }

    public void setUObservacao(String uObservacao) {
        this.uObservacao = uObservacao;
    }

    public BigDecimal getUComissaoAgencia() {
        return uComissaoAgencia;
    }

    public void setUComissaoAgencia(BigDecimal uComissaoAgencia) {
        this.uComissaoAgencia = uComissaoAgencia;
    }

    public Date getUDataPublicacaoFinal() {
        return uDataPublicacaoFinal;
    }

    public void setUDataPublicacaoFinal(Date uDataPublicacaoFinal) {
        this.uDataPublicacaoFinal = uDataPublicacaoFinal;
    }

    public String getUDiasPublicacao() {
        return uDiasPublicacao;
    }

    public void setUDiasPublicacao(String uDiasPublicacao) {
        this.uDiasPublicacao = uDiasPublicacao;
    }

    public ParceiroNegocioModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ParceiroNegocioModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public String getUTituloPublicacao() {
        return uTituloPublicacao;
    }

    public void setUTituloPublicacao(String uTituloPublicacao) {
        this.uTituloPublicacao = uTituloPublicacao;
    }

    public String getUNumeroPI() {
        return uNumeroPI;
    }

    public void setUNumeroPI(String uNumeroPI) {
        this.uNumeroPI = uNumeroPI;
    }

    public String getUTipoTransacao() {
        return uTipoTransacao;
    }

    public void setUTipoTransacao(String uTipoTransacao) {
        this.uTipoTransacao = uTipoTransacao;
    }

    public String getUFormato() {
        return uFormato;
    }

    public void setUFormato(String uFormato) {
        this.uFormato = uFormato;
    }

    public BigDecimal getUPageViews() {
        return uPageViews;
    }

    public void setUPageViews(BigDecimal uPageViews) {
        this.uPageViews = uPageViews;
    }

    public String getUPeriodo() {
        return uPeriodo;
    }

    public void setUPeriodo(String uPeriodo) {
        this.uPeriodo = uPeriodo;
    }

    public String getUEntregaVendedor() {
        return uEntregaVendedor;
    }

    public void setUEntregaVendedor(String uEntregaVendedor) {
        this.uEntregaVendedor = uEntregaVendedor;
    }

    public String getUProduto() {
        return uProduto;
    }

    public void setUProduto(String uProduto) {
        this.uProduto = uProduto;
    }

    public String getUCampanha() {
        return uCampanha;
    }

    public void setUCampanha(String uCampanha) {
        this.uCampanha = uCampanha;
    }

    public String getUPostoId() {
        return uPostoId;
    }

    public void setUPostoId(String uPostoId) {
        this.uPostoId = uPostoId;
    }

    public Date getUDataPublicacaoInicial() {
        return uDataPublicacaoInicial;
    }

    public void setUDataPublicacaoInicial(Date uDataPublicacaoInicial) {
        this.uDataPublicacaoInicial = uDataPublicacaoInicial;
    }

}
