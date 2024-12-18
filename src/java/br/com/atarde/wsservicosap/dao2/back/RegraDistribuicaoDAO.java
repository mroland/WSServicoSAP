/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.RegraDistribuicaoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class RegraDistribuicaoDAO {

    public RegraDistribuicaoDAO() {
    }

    public RegraDistribuicaoModel obter(RegraDistribuicaoModel model, String jndi) {
        
        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);
        
        broker.setPropertySQL("regradistribuicaodao.obter", model.getDimensaoModel().getId(), model.getId());
        
        return (RegraDistribuicaoModel) broker.getObjectBean(RegraDistribuicaoModel.class, "id");
             
    }
    
}
