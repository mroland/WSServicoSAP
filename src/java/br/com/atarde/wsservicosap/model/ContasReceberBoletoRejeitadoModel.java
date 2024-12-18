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
public class ContasReceberBoletoRejeitadoModel implements Serializable {

    private Long id;
    private ContasReceberModel contasReceberModel;

    public ContasReceberModel getContasReceberModel() {
        return contasReceberModel;
    }

    public void setContasReceberModel(ContasReceberModel contasReceberModel) {
        this.contasReceberModel = contasReceberModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
