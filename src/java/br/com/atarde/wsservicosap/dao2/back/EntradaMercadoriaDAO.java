/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.EntradaMercadoriaLinhaModel;
import br.com.atarde.wsservicosap.model.EntradaMercadoriaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.sql.Timestamp;

/**
 *
 * @author mroland
 */
public class EntradaMercadoriaDAO {

    public EntradaMercadoriaDAO() {
    }

    public EntradaMercadoriaModel inserir(EntradaMercadoriaModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();
        
        broker.beginTransaction();
        
        broker.setPropertySQL("entradamercadoriadao.inserir", model.getAtualizadoPor(), model.getCriadoPor(), model.getDataAtualizacao(),
                                  model.getDataCriacao(), model.getIdExterno(), model.getDataDocumento(),model.getDataLancamento(), 
                                  new Timestamp(System.currentTimeMillis()), model.getStatusModel().getId(),
                                  model.getObservacao());
        
        model.setId(broker.executeIdentity());
        
        for (EntradaMercadoriaLinhaModel item : model.getEntradaMercadoriaLinhaModelList()) {
            
            item.setEntradaMercadoriaModel(model);
            
            new EntradaMercadoriaLinhaDAO().inserir(item,broker);
            
        }
        
        broker.endTransaction();
        
        return model;
        
    }
    
}
