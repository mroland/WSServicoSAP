/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author mroland
 */
public class EntradaMercadoriaModel extends DocumentoABModel implements Serializable {

    // Tabela OIGN
    
    private List<EntradaMercadoriaLinhaModel> entradaMercadoriaLinhaModelList;
    private String observacao;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<EntradaMercadoriaLinhaModel> getEntradaMercadoriaLinhaModelList() {
        return entradaMercadoriaLinhaModelList;
    }

    public void setEntradaMercadoriaLinhaModelList(List<EntradaMercadoriaLinhaModel> entradaMercadoriaLinhaModelList) {
        this.entradaMercadoriaLinhaModelList = entradaMercadoriaLinhaModelList;
    }
}
