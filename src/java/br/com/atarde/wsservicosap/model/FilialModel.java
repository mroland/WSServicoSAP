package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FilialModel implements Serializable {

    private Integer id;
    private String descricao;
    private Boolean flagAtivo;
    private Boolean flagPrincipal;
    private EmpresaModel empresa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public Boolean getFlagPrincipal() {
        return flagPrincipal;
    }

    public void setFlagPrincipal(Boolean flagPrincipal) {
        this.flagPrincipal = flagPrincipal;
    }

}
