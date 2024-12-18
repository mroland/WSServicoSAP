/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

/**
 *
 * @author mroland
 */
public class SvgNotaFiscalSaidaModel extends NotaFiscalSaidaABModel {

    private Integer numeroNF;
    private String serie;
    private String modelo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getNumeroNF() {
        return numeroNF;
    }

    public void setNumeroNF(Integer numeroNF) {
        this.numeroNF = numeroNF;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

}
