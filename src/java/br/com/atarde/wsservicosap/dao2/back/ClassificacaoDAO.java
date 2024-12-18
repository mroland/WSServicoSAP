/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ClassificacaoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class ClassificacaoDAO {

    public ClassificacaoDAO() {
    }

    public ClassificacaoModel obter(ClassificacaoModel model){

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("classificacaodao.obter", model.getId());

        return (ClassificacaoModel) broker.getObjectBean(ClassificacaoModel.class, "id");


    }

}
