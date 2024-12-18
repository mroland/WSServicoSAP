package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ParceiroNegocioModel extends PessoaABModel implements Serializable {

    //tabela OCRD
    private String tipoParceiroNegocio;									//equivalente ao cardType
    private String observacao;
    private ParceiroNegocioContaBancoModel parceiroNegocioContaBancoModel;
    private ContasReceberModel contasReceberModel;
    private String enderecoCobrancaDefault;
    private String enderecoEntregaDefault;
    private Boolean flagEndereco;
    private EmpresaModel empresaModel;
    private Boolean flagAtivo;

    public String getTipoParceiroNegocio() {
        return tipoParceiroNegocio;
    }

    public void setTipoParceiroNegocio(String tipoParceiroNegocio) {
        this.tipoParceiroNegocio = tipoParceiroNegocio;
    }

    public ParceiroNegocioContaBancoModel getParceiroNegocioContaBancoModel() {
        return parceiroNegocioContaBancoModel;
    }

    public void setParceiroNegocioContaBancoModel(ParceiroNegocioContaBancoModel parceiroNegocioContaBancoModel) {
        this.parceiroNegocioContaBancoModel = parceiroNegocioContaBancoModel;
    }

    public ContasReceberModel getContasReceberModel() {
        return contasReceberModel;
    }

    public void setContasReceberModel(ContasReceberModel contasReceberModel) {
        this.contasReceberModel = contasReceberModel;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEnderecoCobrancaDefault() {
        return enderecoCobrancaDefault;
    }

    public void setEnderecoCobrancaDefault(String enderecoCobrancaDefault) {
        this.enderecoCobrancaDefault = enderecoCobrancaDefault;
    }

    public String getEnderecoEntregaDefault() {
        return enderecoEntregaDefault;
    }

    public void setEnderecoEntregaDefault(String enderecoEntregaDefault) {
        this.enderecoEntregaDefault = enderecoEntregaDefault;
    }

    public Boolean getFlagEndereco() {
        return flagEndereco;
    }

    public void setFlagEndereco(Boolean flagEndereco) {
        this.flagEndereco = flagEndereco;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

}
