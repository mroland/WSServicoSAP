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
public class DimensaoModel implements Serializable {

    //Tabela ODIM
    private Long id;
    private String descricao;
    private RegraDistribuicaoModel regraDistribuicaoModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegraDistribuicaoModel getRegraDistribuicaoModel() {
        return regraDistribuicaoModel;
    }

    public void setRegraDistribuicaoModel(RegraDistribuicaoModel regraDistribuicaoModel) {
        this.regraDistribuicaoModel = regraDistribuicaoModel;
    }
}
