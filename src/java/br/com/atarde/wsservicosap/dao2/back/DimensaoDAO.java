/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.DimensaoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class DimensaoDAO {

    public DimensaoDAO() {
    }
    
    public DimensaoModel obter(DimensaoModel model, String jndi){
        
        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);
        
        broker.setPropertySQL("dimensaodao.obter", model.getId());
        
        return (DimensaoModel) broker.getObjectBean(DimensaoModel.class, "id");
        
        
        
    }
    
}
