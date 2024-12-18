/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.CategoriaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class CategoriaDAO {

    public CategoriaDAO() {
    }

    public CategoriaModel obterPeloCodigo(CategoriaModel model, String jndi) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);

        broker.setPropertySQL("categoriadao.obterpelocodigo", model.getCodigo());

        return (CategoriaModel) broker.getObjectBean(CategoriaModel.class, "id");


    }

}
