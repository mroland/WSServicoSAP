/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.SequenciaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class SequenciaDAO {

    public SequenciaModel obter(SequenciaModel model, String jndi){

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);

        broker.setPropertySQL("sequenciadao.obter", model.getId());

        return (SequenciaModel) broker.getObjectBean(SequenciaModel.class, "id");

    }

}
