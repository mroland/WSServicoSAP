/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class CodigoImpostoDAO {

    public CodigoImpostoModel obter(CodigoImpostoModel model, String jndi){

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);

        broker.setPropertySQL("codigoimpostodao.obter", model.getId());

        return (CodigoImpostoModel) broker.getObjectBean(CodigoImpostoModel.class, "id");
    }

}
