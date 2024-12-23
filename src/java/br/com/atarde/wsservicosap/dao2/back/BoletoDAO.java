/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.BoletoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class BoletoDAO {

    public BoletoDAO() {
    }

    public BoletoModel obterPeloContasReceber(BoletoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();
        
        broker.setPropertySQL("boletodao.obterPeloContasReceber", model.getModalidadePagamentoBoletoModel().getContasReceberModel().getId());
        
        return (BoletoModel) broker.getObjectBean(BoletoModel.class, "id", "arquivoRetornoLinhaModel.descricao", "arquivoRetornoLinhaModel.arquivoRetornoModel.data");
    }
    
}
