package br.com.atarde.servicosaphana.sap.model;

import br.com.atarde.wsservicosap.model.EmpresaModel;
import java.io.Serializable;

@SuppressWarnings("serial")
public class CodigoInternoModel implements Serializable {

    private String id;
    private String descricao;
    private EmpresaModel empresaModel;

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

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

    public String getDescricaoFormatada() {

        return this.id + " - " + this.descricao;

    }

}
