/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ContabilidadeModel implements Serializable {

    private Long id;
    private Integer numero;
    private Date dataLancamento;
    private Date dataVencimento;
    private Date dataDocumento;
    private String observacao;
    private String referencia1;
    private String referencia2;
    private List<ContabilidadeLinhaModel> contabilidadeLinhaModelList;
    private ContabilidadeLinhaModel contabilidadeLinhaModel;

    public ContabilidadeLinhaModel getContabilidadeLinhaModel() {
        return contabilidadeLinhaModel;
    }

    public void setContabilidadeLinhaModel(ContabilidadeLinhaModel contabilidadeLinhaModel) {
        this.contabilidadeLinhaModel = contabilidadeLinhaModel;
    }

    public List<ContabilidadeLinhaModel> getContabilidadeLinhaModelList() {
        return contabilidadeLinhaModelList;
    }

    public void setContabilidadeLinhaModelList(List<ContabilidadeLinhaModel> contabilidadeLinhaModelList) {
        this.contabilidadeLinhaModelList = contabilidadeLinhaModelList;
    }

    public Date getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(Date dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

}
