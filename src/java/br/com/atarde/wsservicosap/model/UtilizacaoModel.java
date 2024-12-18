/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

/**
 *
 * @author mroland
 */
public class UtilizacaoModel implements Serializable {

    //Tabela OUSG
    private Long id;
    private String descricao;

    private EmpresaModel empresaModel;
    
    public UtilizacaoModel(){
        
    }

    public UtilizacaoModel(Long id, EmpresaModel empresaModel) {

        this.id = id;

        this.empresaModel = empresaModel;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

}
