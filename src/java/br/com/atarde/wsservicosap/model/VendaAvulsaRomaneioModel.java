/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author mroland
 */
public class VendaAvulsaRomaneioModel implements Serializable {

    private Long id;
    private String idExterno;
    private String roteiro;
    private String descricao;
    private Date data;
    private Integer reparte;
    private Integer encalhe;
    private Integer venda;
    private BigDecimal preco;
    private BigDecimal valor;
    private String rdj;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEncalhe() {
        return encalhe;
    }

    public void setEncalhe(Integer encalhe) {
        this.encalhe = encalhe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getReparte() {
        return reparte;
    }

    public void setReparte(Integer reparte) {
        this.reparte = reparte;
    }

    public String getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(String roteiro) {
        this.roteiro = roteiro;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getVenda() {
        return venda;
    }

    public void setVenda(Integer venda) {
        this.venda = venda;
    }

    public String getRdj() {
        return rdj;
    }

    public void setRdj(String rdj) {
        this.rdj = rdj;
    }

}
