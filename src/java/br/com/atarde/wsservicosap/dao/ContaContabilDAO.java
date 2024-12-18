package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.ContaContabilModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class ContaContabilDAO {

	public ContaContabilModel obter(ContaContabilModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());
		
		broker.setSQL("SELECT OACT.\"AcctCode\" AS ID FROM " + model.getEmpresaModel().getDbInstancia() + ".OACT WHERE OACT.\"AcctCode\" = ?", model.getId());
		
		return (ContaContabilModel) broker.getObjectBean(ContaContabilModel.class, "id");
	
	}

}
