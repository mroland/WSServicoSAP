package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.UtilizacaoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class UtilizacaoDAO {

    public UtilizacaoModel obter(UtilizacaoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OUSG.ID FROM " + model.getEmpresaModel().getDbInstancia() + ".OUSG WHERE OUSG.ID = ?", model.getId());

        return (UtilizacaoModel) broker.getObjectBean(UtilizacaoModel.class, "id");
    }

}
