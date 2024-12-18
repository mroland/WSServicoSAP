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
public class CancelaContasReceberModel implements Serializable {

    private Long id;
    private ContasReceberModel contasReceberModel;
    private Date dataExportacao;
    private Date dataImportacao;
    private StatusModel statusModel;
    private String mensagemErroImportacao;

    public CancelaContasReceberModel(){

    }

    public CancelaContasReceberModel(ContasReceberModel contasReceberModel) {
        this.contasReceberModel = contasReceberModel;
    }

    public ContasReceberModel getContasReceberModel() {
        return contasReceberModel;
    }

    public void setContasReceberModel(ContasReceberModel contasReceberModel) {
        this.contasReceberModel = contasReceberModel;
    }

    public Date getDataExportacao() {
        return dataExportacao;
    }

    public void setDataExportacao(Date dataExportacao) {
        this.dataExportacao = dataExportacao;
    }

    public Date getDataImportacao() {
        return dataImportacao;
    }

    public void setDataImportacao(Date dataImportacao) {
        this.dataImportacao = dataImportacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
