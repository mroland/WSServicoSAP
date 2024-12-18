package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.PaisModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class PaisDAO {

    public PaisModel obter(PaisModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OCRY.\"Code\" AS ID FROM " + model.getEmpresaModel().getDbInstancia() + ".OCRY WHERE OCRY.\"Code\" = ?", model.getId());

        return (PaisModel) broker.getObjectBean(PaisModel.class, "id");

    }

}
