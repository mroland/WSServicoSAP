package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class RadioNotaFiscalSaidaModel extends NotaFiscalSaidaABModel implements Serializable {

    private ParceiroNegocioModel clienteModel;
    private BigDecimal uComissaoAgencia;
    private String uNumeroPI;
    private Date uDataContrato;
    private String uPeriodoVeiculacao;
    private String uTipoTransacao;
    private String uEntregaVendedor;
    private String uPostoId;
    private Date uDataPublicacaoInicial;
    private String uObservacao;
    private Integer uPermuta;

    public RadioNotaFiscalSaidaModel() {

    }

    public RadioNotaFiscalSaidaModel(String tipo, Long interfaceId) {

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

    public BigDecimal getuComissaoAgencia() {
        return uComissaoAgencia;
    }

    public void setuComissaoAgencia(BigDecimal uComissaoAgencia) {
        this.uComissaoAgencia = uComissaoAgencia;
    }

    public ParceiroNegocioModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ParceiroNegocioModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public String getUNumeroPI() {
        return uNumeroPI;
    }

    public void setUNumeroPI(String uNumeroPI) {
        this.uNumeroPI = uNumeroPI;
    }

    public Date getuDataContrato() {
        return uDataContrato;
    }

    public void setuDataContrato(Date uDataContrato) {
        this.uDataContrato = uDataContrato;
    }

    public String getuPeriodoVeiculacao() {
        return uPeriodoVeiculacao;
    }

    public void setuPeriodoVeiculacao(String uPeriodoVeiculacao) {
        this.uPeriodoVeiculacao = uPeriodoVeiculacao;
    }

    public String getUTipoTransacao() {
        return uTipoTransacao;
    }

    public void setUTipoTransacao(String uTipoTransacao) {
        this.uTipoTransacao = uTipoTransacao;
    }

    public String getUEntregaVendedor() {
        return uEntregaVendedor;
    }

    public void setUEntregaVendedor(String uEntregaVendedor) {
        this.uEntregaVendedor = uEntregaVendedor;
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
