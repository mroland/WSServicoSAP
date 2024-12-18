/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.CFOPModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class CFOPDAO {

    public CFOPDAO() {
    }

    public CFOPModel obterPeloCodigo(CFOPModel model, String jndi) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);

        broker.setPropertySQL("cfopdao.obterpelocodigo", model.getCodigo());

        return (CFOPModel) broker.getObjectBean(CFOPModel.class, "codigo");

    }

}
