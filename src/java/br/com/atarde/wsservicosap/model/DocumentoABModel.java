/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mroland
 */
public abstract class DocumentoABModel implements Serializable {

    private Long id;
    private String idExterno;
    private Date dataDocumento;
    private String mensagemErroImportacao;
    private StatusModel statusModel;
    private Date dataImportacao;
    private Date dataExportacao;
    private Date dataLancamento;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private String criadoPor;
    private String atualizadoPor;
    private OrigemModel origemModel;
    private EmpresaModel empresaModel;
    private FilialModel filialModel;

    public Date getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(Date dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public String getMensagemErroImportacao() {
        return mensagemErroImportacao;
    }

    public void setMensagemErroImportacao(String mensagemErroImportacao) {
        this.mensagemErroImportacao = mensagemErroImportacao;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }

    public Date getDataImportacao() {
        return dataImportacao;
    }

    public void setDataImportacao(Date dataImportacao) {
        this.dataImportacao = dataImportacao;
    }

    public Date getDataExportacao() {
        return dataExportacao;
    }

    public void setDataExportacao(Date dataExportacao) {
        this.dataExportacao = dataExportacao;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getAtualizadoPor() {
        return atualizadoPor;
    }

    public void setAtualizadoPor(String atualizadoPor) {
        this.atualizadoPor = atualizadoPor;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public OrigemModel getOrigemModel() {
        return origemModel;
    }

    public void setOrigemModel(OrigemModel origemModel) {
        this.origemModel = origemModel;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

    public FilialModel getFilialModel() {
        return filialModel;
    }

    public void setFilialModel(FilialModel filialModel) {
        this.filialModel = filialModel;
    }

}
