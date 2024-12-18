/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ContaContabilModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class ContaContabilDAO {

    public ContaContabilDAO() {
    }

    public ContaContabilModel obter(ContaContabilModel model, String jndi) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);

        broker.setPropertySQL("contacontabildao.obter", model.getId());

        return (ContaContabilModel) broker.getObjectBean(ContaContabilModel.class, "id");
    }

}
