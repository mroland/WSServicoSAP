/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

/**
 *
 * @author marcu
 */
public class EmpresaModel implements Serializable {

    private Long id;

    private String descricao;

    private Boolean flagAtivo;

    private String jndi;

    private String servidor;

    private String dbInstancia;

    private String dbUsuario;

    private String dbSenha;

    private String appUsuario;

    private String appSenha;

    private String servidorLicenca;

    private String portaLicenca;

    private String cnpj;

    private String urlSapHana;

    public EmpresaModel() {
    }

    public EmpresaModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public String getJndi() {
        return jndi;
    }

    public void setJndi(String jndi) {
        this.jndi = jndi;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getDbInstancia() {
        return dbInstancia;
    }

    public void setDbInstancia(String dbInstancia) {
        this.dbInstancia = dbInstancia;
    }

    public String getDbUsuario() {
        return dbUsuario;
    }

    public void setDbUsuario(String dbUsuario) {
        this.dbUsuario = dbUsuario;
    }

    public String getDbSenha() {
        return dbSenha;
    }

    public void setDbSenha(String dbSenha) {
        this.dbSenha = dbSenha;
    }

    public String getAppUsuario() {
        return appUsuario;
    }

    public void setAppUsuario(String appUsuario) {
        this.appUsuario = appUsuario;
    }

    public String getAppSenha() {
        return appSenha;
    }

    public void setAppSenha(String appSenha) {
        this.appSenha = appSenha;
    }

    public String getServidorLicenca() {
        return servidorLicenca;
    }

    public void setServidorLicenca(String servidorLicenca) {
        this.servidorLicenca = servidorLicenca;
    }

    public String getPortaLicenca() {
        return portaLicenca;
    }

    public void setPortaLicenca(String portaLicenca) {
        this.portaLicenca = portaLicenca;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getUrlSapHana() {
        return urlSapHana;
    }

    public void setUrlSapHana(String urlSapHana) {
        this.urlSapHana = urlSapHana;
    }

}
