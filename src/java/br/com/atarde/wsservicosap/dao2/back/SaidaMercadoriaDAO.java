/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.SaidaMercadoriaLinhaModel;
import br.com.atarde.wsservicosap.model.SaidaMercadoriaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.sql.Timestamp;

/**
 *
 * @author mroland
 */
public class SaidaMercadoriaDAO {

    public SaidaMercadoriaDAO() {
    }

    public SaidaMercadoriaModel inserir(SaidaMercadoriaModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();
        
        broker.beginTransaction();
        
        broker.setPropertySQL("saidamercadoriadao.inserir", model.getAtualizadoPor(), model.getCriadoPor(), model.getDataAtualizacao(),
                                  model.getDataCriacao(), model.getIdExterno(), model.getDataDocumento(),model.getDataLancamento(), 
                                  new Timestamp(System.currentTimeMillis()), model.getStatusModel().getId(),
                                  model.getObservacao());
        
        model.setId(broker.executeIdentity());
        
        for (SaidaMercadoriaLinhaModel item : model.getSaidaMercadoriaLinhaModelList()) {
            
            item.setSaidaMercadoriaModel(model);
            
            new SaidaMercadoriaLinhaDAO().inserir(item,broker);
            
        }
        
        broker.endTransaction();
        
        return model;
        
    }

    public SaidaMercadoriaModel obter(SaidaMercadoriaModel model){
        return null;
        
    }
    
}

