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
public class MunicipioModel implements Serializable {

    private Long id;

    private String codigo;

    private String codigoIBGE;

    private EnderecoABModel enderecoABModel;

    private EmpresaModel empresaModel;

    public MunicipioModel() {

    }

    public MunicipioModel(EnderecoABModel enderecoABModel) {

        this.enderecoABModel = enderecoABModel;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public EnderecoABModel getEnderecoABModel() {
        return enderecoABModel;
    }

    public void setEnderecoABModel(EnderecoABModel enderecoABModel) {
        this.enderecoABModel = enderecoABModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

}
