package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.EstadoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class EstadoDAO {

	public EstadoModel obter(EstadoModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

		broker.setSQL("SELECT OCST.\"Code\" AS ID FROM " + model.getEmpresaModel().getDbInstancia() + ".OCST WHERE OCST.\"Code\" = ?", model.getId());

		return (EstadoModel) broker.getObjectBean(EstadoModel.class, "id");

	}

}
