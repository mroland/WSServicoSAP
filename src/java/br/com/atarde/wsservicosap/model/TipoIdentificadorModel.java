package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TipoIdentificadorModel implements Serializable{
	
	private Long id;
	
	private String descricao;

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
	
	

}
