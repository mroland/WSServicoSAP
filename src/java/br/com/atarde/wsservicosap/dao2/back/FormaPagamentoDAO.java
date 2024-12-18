/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.FormaPagamentoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class FormaPagamentoDAO {

    public FormaPagamentoDAO() {
    }

    public FormaPagamentoModel obter(FormaPagamentoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("formapagamentodao.obter", model.getId(), model.getTipo());

        return (FormaPagamentoModel) broker.getObjectBean(FormaPagamentoModel.class, "id", "descricao");
    }

}
