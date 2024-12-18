package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.SequenciaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class SequenciaDAO {

    public SequenciaModel obter(SequenciaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT NFN1.\"SeqCode\" FROM " + model.getEmpresaModel().getDbInstancia() + ".NFN1 WHERE NFN1.\"SeqCode\" = ?", model.getId());

        return (SequenciaModel) broker.getObjectBean(SequenciaModel.class, "id");
    }

}
