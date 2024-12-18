/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.MunicipioModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class MunicipioDAO {

    public MunicipioModel obter(MunicipioModel model,String jndi){

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);

        broker.setPropertySQL("municipiodao.obter", model.getEnderecoABModel().getPais(), model.getEnderecoABModel().getEstado(), model.getEnderecoABModel().getCidade());

        return (MunicipioModel) broker.getObjectBean(MunicipioModel.class, "id");
    }

}
