package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VendedorModel extends PessoaABModel implements Serializable {

    private GrupoComissaoModel grupoComissaoModel;
    private String uCga;
    private EmpresaModel empresaModel;

    public GrupoComissaoModel getGrupoComissaoModel() {
        return grupoComissaoModel;
    }

    public void setGrupoComissaoModel(GrupoComissaoModel grupoComissaoModel) {
        this.grupoComissaoModel = grupoComissaoModel;
    }

    public String getUCga() {
        return uCga;
    }

    public void setUCga(String uCga) {
        this.uCga = uCga;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

}
