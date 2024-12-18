package br.com.atarde.wsservicosap.dao;


import br.com.atarde.wsservicosap.model.CategoriaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class CategoriaDAO {

	public CategoriaModel obterPeloCodigo(CategoriaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT ONFT.\"AbsId\" ABSID FROM " + model.getEmpresaModel().getDbInstancia() +".ONFT WHERE ONFT.\"Code\"= ?", model.getCodigo());

        return (CategoriaModel) broker.getObjectBean(CategoriaModel.class, "id");
	}

}
