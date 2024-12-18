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
public class CodigoImpostoModel implements Serializable {

    // tabela OSTC
    private String id;          //equivalente a code

    private String descricao;   //equivalente a name

    private EmpresaModel empresaModel;
    
    public CodigoImpostoModel (){
        
    }

    public CodigoImpostoModel(String atributo, String valor, EmpresaModel empresaModel) {

        if ("id".equals(atributo)) {

            this.id = valor;

            this.empresaModel = empresaModel;

        }

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

}
