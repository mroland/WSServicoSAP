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
public class RadioNotaFiscalSaidaLinhaModel extends NotaFiscalSaidaLinhaABModel implements Serializable{

    private Integer uSegundagem;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getuSegundagem() {
        return uSegundagem;
    }

    public void setuSegundagem(Integer uSegundagem) {
        this.uSegundagem = uSegundagem;
    }
}
