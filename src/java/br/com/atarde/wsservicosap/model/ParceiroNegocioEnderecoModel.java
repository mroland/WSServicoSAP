package br.com.atarde.wsservicosap.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ParceiroNegocioEnderecoModel extends EnderecoABModel implements Serializable {

    //Tabela CRD1
    private String id; 					//equivalente a CardCode(PrimaryKey)
    private String enderecoId; 				//equivalente a Address(PrimaryKey)
    private String enderecoTipoId; 				//equivalente a AddrType(Primary)
    private ParceiroNegocioModel parceiroNegocioModel;	//equivalente a CardCode(ForeignKey para OCRD)
    private String tipoEndereco;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(String enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getEnderecoTipoId() {
        return enderecoTipoId;
    }

    public void setEnderecoTipoId(String enderecoTipoId) {
        this.enderecoTipoId = enderecoTipoId;
    }

    public ParceiroNegocioModel getParceiroNegocioModel() {
        return parceiroNegocioModel;
    }

    public void setParceiroNegocioModel(ParceiroNegocioModel parceiroNegocioModel) {
        this.parceiroNegocioModel = parceiroNegocioModel;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

}
