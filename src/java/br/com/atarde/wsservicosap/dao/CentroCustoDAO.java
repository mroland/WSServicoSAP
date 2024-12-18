package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.CentroCustoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class CentroCustoDAO {

	public CentroCustoModel obter(CentroCustoModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

		broker.setSQL("SELECT OOCR.\"OcrCode\" OCRCODE AS ID FROM " + model.getEmpresaModel().getDbInstancia() + ".OOCR WHERE OOCR.\"DimCode\" = ? AND OOCR.\"OcrCode\" = ?", model.getDimensaoModel().getId(), model.getId());

		return (CentroCustoModel) broker.getObjectBean(CentroCustoModel.class, "id");
	}

}
