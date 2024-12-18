package br.com.atarde.wsservicosap.dao;


import br.com.atarde.wsservicosap.model.BoletoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class BoletoDAO {
	
	public BoletoModel obter(BoletoModel model) {
		
		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());
		
		broker.setSQL("SELECT OBOE.\"BoeNum\", OBOE.\"BoeStatus\" FROM " + model.getEmpresaModel().getDbInstancia() + ".OBOE WHERE OBOE.\"BoeNum\" = ?", model.getId());

		return (BoletoModel) broker.getObjectBean(BoletoModel.class, "id", "statusModel.id");
	}

}
