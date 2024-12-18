package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.CSTModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class CstDAO {

    public CSTModel obterPeloCodigo(CSTModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OTSC.\"CodeOut\" FROM " + model.getEmpresaModel().getDbInstancia() + ".OTSC WHERE OTSC.\"CodeOut\"= ? AND OTSC.\"Category\" = ?", model.getCodigo(), model.getCategoriaModel().getId());

        return (CSTModel) broker.getObjectBean(CSTModel.class, "codigo");
    }

}
