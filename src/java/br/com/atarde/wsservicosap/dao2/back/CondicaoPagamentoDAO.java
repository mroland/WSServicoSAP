/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.CondicaoPagamentoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class CondicaoPagamentoDAO {

    public CondicaoPagamentoDAO() {
    }

    public CondicaoPagamentoModel obter(CondicaoPagamentoModel model, String jndi) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);

        broker.setPropertySQL("condicaopagamentodao.obter", model.getId());

        return (CondicaoPagamentoModel) broker.getObjectBean(CondicaoPagamentoModel.class, "id");
        
    }

}
