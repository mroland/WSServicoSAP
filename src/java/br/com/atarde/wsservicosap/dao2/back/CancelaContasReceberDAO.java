/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.CancelaContasReceberModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;

/**
 *
 * @author mroland
 */
public class CancelaContasReceberDAO {

    public CancelaContasReceberDAO() {
    }

    public CancelaContasReceberModel obter(CancelaContasReceberModel model){

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("cancelacontasreceberdao.obter", model.getContasReceberModel().getId());

        return (CancelaContasReceberModel) broker.getObjectBean(CancelaContasReceberModel.class, "id", "contasReceberModel.id");

    }

    public CancelaContasReceberModel inserir(CancelaContasReceberModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("cancelacontasreceberdao.inserir", model.getContasReceberModel().getId(), model.getDataExportacao(), model.getStatusModel().getId(),model.getContasReceberModel().getParcelaNotaFiscalSaidaModel().getId());

        broker.execute();

        return model;

    }

}
