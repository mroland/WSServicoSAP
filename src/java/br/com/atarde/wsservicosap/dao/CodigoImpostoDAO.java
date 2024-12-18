package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class CodigoImpostoDAO {

    public CodigoImpostoModel obter(CodigoImpostoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OSTC.\"Code\" FROM " + model.getEmpresaModel().getDbInstancia() + ".OSTC WHERE OSTC.\"Code\" = ?", model.getId());

        return (CodigoImpostoModel) broker.getObjectBean(CodigoImpostoModel.class, "id");

    }

}
