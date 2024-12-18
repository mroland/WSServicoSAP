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
public class CategoriaModel implements Serializable {

    // tabela ONFT
    private Long id;                // referente a absid

    private String codigo;          // referente a code

    private String status;          // referente a locked

    private EmpresaModel empresaModel;

    public CategoriaModel() {

    }

    public CategoriaModel(String tipo, String valor, EmpresaModel empresaModel) {

        if (tipo.equals("codigo")) {

            this.codigo = valor;
        }

        this.empresaModel = empresaModel;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

}
