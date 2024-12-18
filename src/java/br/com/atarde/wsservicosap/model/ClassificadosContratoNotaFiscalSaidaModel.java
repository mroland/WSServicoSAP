package br.com.atarde.wsservicosap.model;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class ClassificadosContratoNotaFiscalSaidaModel extends NotaFiscalSaidaABModel{

    private ParceiroNegocioModel clienteModel;
    private BigDecimal uComissaoAgencia;
    private String uDiasPublicacao;
    private Date uDataPublicacaoFinal;
    private String uTituloPublicacao;
    private String uNumeroPI;
    private String uPostoId;
    private Date uDataPublicacaoInicial;    

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
