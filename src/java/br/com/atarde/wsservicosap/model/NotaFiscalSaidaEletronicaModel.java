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
@SuppressWarnings("serial")
public class NotaFiscalSaidaEletronicaModel implements Serializable {

    private Long id;
    private Date dataCriacao;
    private String chaveNfe;
    private NotaFiscalSaidaModel notaFiscalSaidaModel;
    private Long empresaOobjID;

    public NotaFiscalSaidaEletronicaModel() {

    }

    public NotaFiscalSaidaEletronicaModel(NotaFiscalSaidaModel notaFiscalSaida) {

        this.notaFiscalSaidaModel = notaFiscalSaida;
    }

    public String getChaveNfe() {
        return chaveNfe;
    }

    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotaFiscalSaidaModel getNotaFiscalSaidaModel() {
        return notaFiscalSaidaModel;
    }

    public void setNotaFiscalSaidaModel(NotaFiscalSaidaModel notaFiscalSaidaModel) {
        this.notaFiscalSaidaModel = notaFiscalSaidaModel;
    }

    public Long getEmpresaOobjID() {
        return empresaOobjID;
    }

    public void setEmpresaOobjID(Long empresaOobjID) {
        this.empresaOobjID = empresaOobjID;
    }

}
