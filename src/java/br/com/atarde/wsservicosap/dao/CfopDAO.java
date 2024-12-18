package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.CFOPModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class CfopDAO {

	public CFOPModel obterPeloCodigo(CFOPModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

		broker.setSQL("SELECT OCFP.\"Code\" CODE FROM " + model.getEmpresaModel().getDbInstancia() + ".OCFP WHERE OCFP.\"Code\" = ?", model.getCodigo());

		return (CFOPModel) broker.getObjectBean(CFOPModel.class, "codigo");

	}

}
