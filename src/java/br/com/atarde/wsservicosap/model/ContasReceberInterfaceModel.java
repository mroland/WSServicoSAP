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
public class ContasReceberInterfaceModel implements Serializable {

    private Long id;
    private ContasReceberModel contasReceberModel;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
