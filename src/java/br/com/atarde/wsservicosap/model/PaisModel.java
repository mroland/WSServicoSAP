package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PaisModel implements Serializable {

    private String id;

    private String descricao;

    private EstadoModel estadoModel;

    private EmpresaModel empresaModel;

    public PaisModel() {

    }

    public PaisModel(String id, EmpresaModel empresa) {

        this.id = id;

        this.empresaModel = empresa;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

}
