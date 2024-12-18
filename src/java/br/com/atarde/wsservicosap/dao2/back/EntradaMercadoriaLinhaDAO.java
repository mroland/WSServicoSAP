/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.EntradaMercadoriaLinhaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.exception.TSApplicationException;

/**
 *
 * @author mroland
 */
public class EntradaMercadoriaLinhaDAO {

    public EntradaMercadoriaLinhaDAO() {
    }

    public EntradaMercadoriaLinhaModel inserir(EntradaMercadoriaLinhaModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {
             
        broker.setPropertySQL("entradamercadorialinhadao.inserirComBroker", model.getItemModel().getId(), model.getQuantidade(), model.getEntradaMercadoriaModel().getId(), model.getDimensao1Model().getRegraDistribuicaoModel().getId());
        
        model.setId(broker.executeIdentity());
        
        return model;
        
        
    }
    
}
