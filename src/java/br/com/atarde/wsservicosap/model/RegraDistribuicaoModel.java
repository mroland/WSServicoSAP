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
public class RegraDistribuicaoModel implements Serializable {

    //Tabela OOCR
    private String id;
    private String descricao;
    private DimensaoModel dimensaoModel;
    private EmpresaModel empresaModel;
    private String mensagemErro;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public DimensaoModel getDimensaoModel() {
        return dimensaoModel;
    }

    public void setDimensaoModel(DimensaoModel dimensaoModel) {
        this.dimensaoModel = dimensaoModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

}
