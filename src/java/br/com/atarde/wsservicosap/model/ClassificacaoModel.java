package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ClassificacaoModel implements Serializable {

    private Long id;

    private String descricao;

    private ParceiroNegocioModel parceiroNegocioModel;

    private EmpresaModel empresaModel;

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

    public ClassificacaoModel() {

    }

    public ClassificacaoModel(Long id) {
        this.id = id;
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

    public ParceiroNegocioModel getParceiroNegocioModel() {
        return parceiroNegocioModel;
    }

    public void setParceiroNegocioModel(ParceiroNegocioModel parceiroNegocioModel) {
        this.parceiroNegocioModel = parceiroNegocioModel;
    }

}
