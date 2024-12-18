package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EstadoModel implements Serializable {

    private String id;

    private String descricao;

    private PaisModel paisModel;

    private EmpresaModel empresaModel;

    public EstadoModel() {

    }

    public EstadoModel(String id, EmpresaModel empresaModel) {

        this.id = id;

        this.empresaModel = empresaModel;

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

    public PaisModel getPaisModel() {
        return paisModel;
    }

    public void setPaisModel(PaisModel paisModel) {
        this.paisModel = paisModel;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

}
