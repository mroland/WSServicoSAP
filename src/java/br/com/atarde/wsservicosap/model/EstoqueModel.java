package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class EstoqueModel implements Serializable {

    //Tabela OWHS
    private String id;
    private String descricao;
    private ItemModel itemModel;
    private List<ItemModel> itens;
    private EmpresaModel empresaModel;
    private Integer quantidadeDisponivel;
    private Integer quantidadeLiberada;
    private String mensagemErro;

    public EstoqueModel() {

    }

    public EstoqueModel(String id, EmpresaModel empresa) {

        this.id = id;

        this.empresaModel = empresa;

    }

    public EstoqueModel(ItemModel item, EmpresaModel empresa) {

        this.itemModel = item;

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

    public ItemModel getItemModel() {
        return itemModel;
    }

    public void setItemModel(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

    public List<ItemModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemModel> itens) {
        this.itens = itens;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Integer getQuantidadeLiberada() {
        return quantidadeLiberada;
    }

    public void setQuantidadeLiberada(Integer quantidadeLiberada) {
        this.quantidadeLiberada = quantidadeLiberada;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

}
