/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.CondicaoPagamentoModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class CondicaoPagamentoRadioDAO {

    public CondicaoPagamentoRadioDAO() {
    }

    public CondicaoPagamentoModel obter(CondicaoPagamentoModel model) {
        
        StringBuilder sql = new StringBuilder();
        
        //sql.append("SELECT GROUPNUM FROM ").append(Constantes.BANCO_RADIO2).append(".DBO.OCTG WITH(NOLOCK) WHERE GROUPNUM = ? ");
        
        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setSQL(sql.toString(), model.getId());

        return (CondicaoPagamentoModel) broker.getObjectBean(CondicaoPagamentoModel.class, "id");
    }
    
}
