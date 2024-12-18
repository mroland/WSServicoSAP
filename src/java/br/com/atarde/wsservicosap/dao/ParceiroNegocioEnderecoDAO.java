/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.ParceiroNegocioEnderecoModel;
import br.com.atarde.wsservicosap.model.ParceiroNegocioModel;
import java.util.List;

import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class ParceiroNegocioEnderecoDAO {

    public ParceiroNegocioEnderecoDAO() {
    }

    @SuppressWarnings("unchecked")
    public List<ParceiroNegocioEnderecoModel> pesquisar(ParceiroNegocioModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT CRD1.\"Address\" ADDRESS FROM " + model.getEmpresaModel().getDbInstancia() + ".CRD1 WHERE CRD1.\"CardCode\" = ?", model.getId());

        return broker.getCollectionBean(ParceiroNegocioEnderecoModel.class, "id");

    }

    public ParceiroNegocioEnderecoModel obter(ParceiroNegocioEnderecoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT CRD1.\"Address\" FROM " + model.getEmpresaModel().getDbInstancia() + ".CRD1 WHERE CRD1.\"CardCode\" =? AND CRD1.\"AdresType\" =? AND CRD1.\"Address\" = ?", model.getParceiroNegocioModel().getId(), model.getTipoEndereco(), model.getId());

        return (ParceiroNegocioEnderecoModel) broker.getObjectBean(ParceiroNegocioEnderecoModel.class, "id");
    }

}
