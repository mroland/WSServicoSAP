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
public class SaidaMercadoriaLinhaModel implements Serializable {
    
    //Tabela IGE1

    private Long id;
    private SaidaMercadoriaModel saidaMercadoriaModel;
    private ItemModel itemModel;
    private Double quantidade;
    private DimensaoModel dimensao1Model;
    private DimensaoModel dimensao2Model;
    private DimensaoModel dimensao3Model;

    public DimensaoModel getDimensao1Model() {
        return dimensao1Model;
    }

    public void setDimensao1Model(DimensaoModel dimensao1Model) {
        this.dimensao1Model = dimensao1Model;
    }

    public DimensaoModel getDimensao2Model() {
        return dimensao2Model;
    }

    public void setDimensao2Model(DimensaoModel dimensao2Model) {
        this.dimensao2Model = dimensao2Model;
    }

    public DimensaoModel getDimensao3Model() {
        return dimensao3Model;
    }

    public void setDimensao3Model(DimensaoModel dimensao3Model) {
        this.dimensao3Model = dimensao3Model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemModel getItemModel() {
        return itemModel;
    }

    public void setItemModel(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public SaidaMercadoriaModel getSaidaMercadoriaModel() {
        return saidaMercadoriaModel;
    }

    public void setSaidaMercadoriaModel(SaidaMercadoriaModel saidaMercadoriaModel) {
        this.saidaMercadoriaModel = saidaMercadoriaModel;
    }
}
