package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public abstract class PessoaABModel implements Serializable {

    private String id;						//equivalente ao cardCode;
    private IdentificadorFiscalModel identificadorFiscalModel;	//equivalente a CardCode(ForeignKey para CRD7)
    private String nome;					//equivalente ao cardName
    private String nomeFantasia;
    private String telefoneResidencial;
    private String telefoneCelular;
    private String fax;
    private String email;
    private Date dataAtualizacao;
    private EnderecoABModel enderecoModel;
    private List<EnderecoABModel> enderecoModelList;
    private ClassificacaoModel classificacaoModel;
    private String mensagemErro;
    private String tipo;
    private String observacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IdentificadorFiscalModel getIdentificadorFiscalModel() {
        return identificadorFiscalModel;
    }

    public void setIdentificadorFiscalModel(
            IdentificadorFiscalModel identificadorFiscalModel) {
        this.identificadorFiscalModel = identificadorFiscalModel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public EnderecoABModel getEnderecoModel() {
        return enderecoModel;
    }

    public void setEnderecoModel(EnderecoABModel enderecoModel) {
        this.enderecoModel = enderecoModel;
    }

    public List<EnderecoABModel> getEnderecoModelList() {
        return enderecoModelList;
    }

    public void setEnderecoModelList(List<EnderecoABModel> enderecoModelList) {
        this.enderecoModelList = enderecoModelList;
    }

    public ClassificacaoModel getClassificacaoModel() {
        return classificacaoModel;
    }

    public void setClassificacaoModel(ClassificacaoModel classificacaoModel) {
        this.classificacaoModel = classificacaoModel;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
