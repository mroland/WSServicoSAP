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
public class ArquivoRetornoLinhaModel implements Serializable {

    private Long id;
    private String descricao;
    private BoletoModel boletoModel;
    private ArquivoRetornoModel arquivoRetornoModel;

    public BoletoModel getBoletoModel() {
        return boletoModel;
    }

    public void setBoletoModel(BoletoModel boletoModel) {
        this.boletoModel = boletoModel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArquivoRetornoModel getArquivoRetornoModel() {
        return arquivoRetornoModel;
    }

    public void setArquivoRetornoModel(ArquivoRetornoModel arquivoRetornoModel) {
        this.arquivoRetornoModel = arquivoRetornoModel;
    }
}
