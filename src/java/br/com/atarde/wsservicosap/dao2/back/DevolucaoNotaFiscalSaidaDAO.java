/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.DevolucaoNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.sql.Timestamp;

/**
 *
 * @author mroland
 */
public class DevolucaoNotaFiscalSaidaDAO {

    public DevolucaoNotaFiscalSaidaDAO() {
    }

    public DevolucaoNotaFiscalSaidaModel inserir(DevolucaoNotaFiscalSaidaModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("devolucaonotafiscalsaidadao.inserir", model.getNotaFiscalSaidaModel().getId(), new Timestamp(System.currentTimeMillis()), model.getStatusModel().getId());

        broker.execute();

        return model;

    }

    public DevolucaoNotaFiscalSaidaModel obter(DevolucaoNotaFiscalSaidaModel model){

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("devolucaonotafiscalsaidadao.obter", model.getNotaFiscalSaidaModel().getId());

        return (DevolucaoNotaFiscalSaidaModel) broker.getObjectBean(DevolucaoNotaFiscalSaidaModel.class, "id");

    }
    
}
