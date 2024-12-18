/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.util.List;

/**
 *
 * @author mroland
 */
public class SaidaMercadoriaModel extends DocumentoABModel {

    // Tabela OIGE

    private List<SaidaMercadoriaLinhaModel> saidaMercadoriaLinhaModelList;
    private String observacao;

    public List<SaidaMercadoriaLinhaModel> getSaidaMercadoriaLinhaModelList() {
        return saidaMercadoriaLinhaModelList;
    }

    public void setSaidaMercadoriaLinhaModelList(List<SaidaMercadoriaLinhaModel> saidaMercadoriaLinhaModelList) {
        this.saidaMercadoriaLinhaModelList = saidaMercadoriaLinhaModelList;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
