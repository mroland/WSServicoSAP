/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

/**
 *
 * @author mroland
 */
public class DevolucaoNotaFiscalSaidaModel implements Serializable {

    private Long id;
    private NotaFiscalSaidaABModel notaFiscalSaidaModel;
    private StatusModel statusModel;

    public DevolucaoNotaFiscalSaidaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotaFiscalSaidaABModel getNotaFiscalSaidaModel() {
        return notaFiscalSaidaModel;
    }

    public void setNotaFiscalSaidaModel(NotaFiscalSaidaABModel notaFiscalSaidaModel) {
        this.notaFiscalSaidaModel = notaFiscalSaidaModel;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }
}
