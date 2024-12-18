package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemModel implements Serializable {

    private String id;
    private String descricao;
    private OrigemModel origemModel;
    private String detalhe;
    private EstoqueModel estoqueModel;

    private EmpresaModel empresaModel;
    
    private Boolean flagControleEstoque;
    private Boolean flgItemVenda;
    private Boolean flagItemCompra;

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

    public OrigemModel getOrigemModel() {
        return origemModel;
    }

    public void setOrigemModel(OrigemModel origemModel) {
        this.origemModel = origemModel;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

    public EstoqueModel getEstoqueModel() {
        return estoqueModel;
    }

    public void setEstoqueModel(EstoqueModel estoqueModel) {
        this.estoqueModel = estoqueModel;
    }

    public Boolean getFlagControleEstoque() {
        return flagControleEstoque;
    }

    public void setFlagControleEstoque(Boolean flagControleEstoque) {
        this.flagControleEstoque = flagControleEstoque;
    }

    public Boolean getFlgItemVenda() {
        return flgItemVenda;
    }

    public void setFlgItemVenda(Boolean flgItemVenda) {
        this.flgItemVenda = flgItemVenda;
    }

    public Boolean getFlagItemCompra() {
        return flagItemCompra;
    }

    public void setFlagItemCompra(Boolean flagItemCompra) {
        this.flagItemCompra = flagItemCompra;
    }
    
    

}
