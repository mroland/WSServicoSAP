/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.MunicipioModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class MunicipioDAO {

    public MunicipioModel obter(MunicipioModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OCNT.\"AbsId\" FROM " + model.getEmpresaModel().getDbInstancia() + ".OCNT WHERE OCNT.\"Country\" = ? AND OCNT.\"State\" = ? AND UPPER(OCNT.\"Name\") = UPPER(?)", model.getEnderecoABModel().getPaisModel().getId(), model.getEnderecoABModel().getEstadoModel().getId(), model.getEnderecoABModel().getCidade());

        return (MunicipioModel) broker.getObjectBean(MunicipioModel.class, "id");
    }

}
