package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.GrupoComissaoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class GrupoComissaoDAO {

    public GrupoComissaoModel obter(GrupoComissaoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OCOG.\"GroupCode\" AS ID, OCOG.\"GroupName\" AS DESCRICAO FROM " + model.getEmpresaModel().getDbInstancia() + ".OCOG WHERE OCOG.\"GroupCode\" = ?", model.getId());

        return (GrupoComissaoModel) broker.getObjectBean(GrupoComissaoModel.class, "id", "descricao");

    }

}
