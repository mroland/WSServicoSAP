/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.CSTModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class CSTDAO {

    public CSTDAO() {
    }

    public CSTModel obterPeloCodigo(CSTModel model, String jndi) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);

        broker.setPropertySQL("cstdao.obterpelocodigo", model.getCodigo(), model.getCategoriaModel().getId());

        return (CSTModel) broker.getObjectBean(CSTModel.class, "codigo");

    }

}
