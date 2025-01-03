/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.SaidaMercadoriaLinhaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.exception.TSApplicationException;

/**
 *
 * @author mroland
 */
public class SaidaMercadoriaLinhaDAO {

    public SaidaMercadoriaLinhaDAO() {
    }

    public SaidaMercadoriaLinhaModel inserir(SaidaMercadoriaLinhaModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {
             
        broker.setPropertySQL("saidamercadorialinhadao.inserirComBroker", model.getItemModel().getId(), model.getQuantidade(), model.getSaidaMercadoriaModel().getId(), model.getDimensao1Model().getRegraDistribuicaoModel().getId());
        
        model.setId(broker.executeIdentity());
        
        return model;
        
        
    }
    
}
