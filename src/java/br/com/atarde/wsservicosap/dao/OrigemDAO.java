package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.OrigemModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class OrigemDAO {

	public OrigemModel obter(OrigemModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

		broker.setSQL("SELECT UFD1.\"FldValue\" ID, UFD1.\"Descr\" FROM " + model.getEmpresaModel().getDbInstancia() + ".UFD1 WHERE UFD1.\"TableID\" = 'ODPI' AND UFD1.\"FieldID\" = 0 AND UFD1.\"FldValue\" = ? ", model.getId());

		return (OrigemModel) broker.getObjectBean(OrigemModel.class, "id", "descricao");

	}

}
