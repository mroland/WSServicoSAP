/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mroland
 */
public class ArquivoRetornoModel implements Serializable {

    private Long id;
    private Date data;
    private ArquivoRetornoLinhaModel arquivoRetornoLinhaModel;

    public ArquivoRetornoLinhaModel getArquivoRetornoLinhaModel() {
        return arquivoRetornoLinhaModel;
    }

    public void setArquivoRetornoLinhaModel(ArquivoRetornoLinhaModel arquivoRetornoLinhaModel) {
        this.arquivoRetornoLinhaModel = arquivoRetornoLinhaModel;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
