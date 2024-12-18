/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao;

import java.util.List;

import br.com.atarde.wsservicosap.model.FormaPagamentoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class FormaPagamentoDAO {

    @SuppressWarnings("unchecked")
    public List<FormaPagamentoModel> pesquisar(FormaPagamentoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT PG.\"PayMethCod\" FROM " + model.getEmpresaModel().getDbInstancia() + ".OPYM PG WHERE PG.\"Type\" = ?", model.getTipo());

        return broker.getCollectionBean(FormaPagamentoModel.class, "id");

    }

    public FormaPagamentoModel obter(FormaPagamentoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setPropertySQL("SELECT OPYM.PayMethCod ID, OPYM.Descript DESCRICAO FROM" + model.getEmpresaModel().getDbInstancia() + ".OPYM WHERE OPYM.PayMethCod = ? AND OPYM.[Type] = ?", model.getId(), model.getTipo());

        return (FormaPagamentoModel) broker.getObjectBean(FormaPagamentoModel.class, "id", "descricao");
    }

}
