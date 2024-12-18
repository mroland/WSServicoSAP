package br.com.atarde.wsservicosap.dao;

import br.com.atarde.servicosaphana.sap.model.CodigoInternoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class CodigoInternoDAO {

	public CodigoInternoModel obter(CodigoInternoModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());
		
		broker.setSQL("SELECT CODE, NAME FROM \"@CODIGOINTERO\" WITH(NOLOCK) WHERE CODE = ?", model.getId());

		return (CodigoInternoModel) broker.getObjectBean(CodigoInternoModel.class, "id", "descricao");
	}

	
}
