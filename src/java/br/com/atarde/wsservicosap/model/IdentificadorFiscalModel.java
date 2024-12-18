package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IdentificadorFiscalModel implements Serializable {

    //Tabela CRD7
    private String id; 													//equivalente a CardCode(PrimaryKey)
    private String enderecoId; 											//equivalente a Address(PrimaryKey)
    private String enderecoTipoId; 										//equivalente a AddrType(Primary)
    private ParceiroNegocioModel parceiroNegocioModel;  				//equivalente a CardCode(ForeignKey para OCRD)
    private ParceiroNegocioEnderecoModel parceiroNegocioEnderecoModel; 	//equivalente a Address(ForeignKey para CRD1)
    private String identificador;                                       //equivalente a Taxid0 , taxId4;
    private Integer tipoIdentificador;                                   //nao tem equivalencia;
    private String inscricaoEstadual;
    private String inscricaoEstadualSubstitutoTributaria;
    private String inscricaoMunicipal;
    private String inscricaoINSS;

    private EmpresaModel empresaModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(String enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getEnderecoTipoId() {
        return enderecoTipoId;
    }

    public void setEnderecoTipoId(String enderecoTipoId) {
        this.enderecoTipoId = enderecoTipoId;
    }

    public ParceiroNegocioModel getParceiroNegocioModel() {
        return parceiroNegocioModel;
    }

    public void setParceiroNegocioModel(ParceiroNegocioModel parceiroNegocioModel) {
        this.parceiroNegocioModel = parceiroNegocioModel;
    }

    public ParceiroNegocioEnderecoModel getParceiroNegocioEnderecoModel() {
        return parceiroNegocioEnderecoModel;
    }

    public void setParceiroNegocioEnderecoModel(
            ParceiroNegocioEnderecoModel parceiroNegocioEnderecoModel) {
        this.parceiroNegocioEnderecoModel = parceiroNegocioEnderecoModel;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoEstadualSubstitutoTributaria() {
        return inscricaoEstadualSubstitutoTributaria;
    }

    public void setInscricaoEstadualSubstitutoTributaria(
            String inscricaoEstadualSubstitutoTributaria) {
        this.inscricaoEstadualSubstitutoTributaria = inscricaoEstadualSubstitutoTributaria;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getInscricaoINSS() {
        return inscricaoINSS;
    }

    public void setInscricaoINSS(String inscricaoINSS) {
        this.inscricaoINSS = inscricaoINSS;
    }

    public Integer getTipoIdentificador() {
        return tipoIdentificador;
    }

    public void setTipoIdentificador(Integer tipoIdentificador) {
        this.tipoIdentificador = tipoIdentificador;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

}
