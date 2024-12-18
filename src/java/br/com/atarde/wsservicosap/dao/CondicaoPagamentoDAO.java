package br.com.atarde.wsservicosap.dao;

import java.util.List;

import br.com.atarde.wsservicosap.model.CondicaoPagamentoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class CondicaoPagamentoDAO {

	public CondicaoPagamentoModel obter(CondicaoPagamentoModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

		broker.setSQL("SELECT OCTG.\"GroupNum\", OCTG.\"InstNum\" FROM " + model.getEmpresaModel().getDbInstancia() + ".OCTG WHERE OCTG.\"GroupNum\" = ?", model.getId());

		return (CondicaoPagamentoModel) broker.getObjectBean(CondicaoPagamentoModel.class, "id", "quantidadeParcelas");
	}

	@SuppressWarnings("unchecked")
	public List<CondicaoPagamentoModel> pesquisar(CondicaoPagamentoModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

		broker.setPropertySQL("SELECT OCTG.\"GroupNum\", OCTG.\"PymntGroup\", CASE WHEN COALESCE((SELECT MAX(CTG1.\"InstDays\") FROM " + model.getEmpresaModel().getDbInstancia() + ".CTG1 WHERE CTG1.\"CTGCode\"=OCTG.\"GroupNum\"),'0') = '0' THEN OCTG.\"ExtraDays\" ELSE (SELECT MAX(CTG1.\"InstDays\") FROM " + model.getEmpresaModel().getDbInstancia() + ".CTG1 WHERE CTG1.\"CTGCode\"=OCTG.\"GroupNum\") END AS DIASVENCIMENTO FROM " + model.getEmpresaModel().getDbInstancia() + ".OCTG");// WHERE OCTG.\"U_EXPORTAR\" = 1");

		return broker.getCollectionBean(CondicaoPagamentoModel.class, "id", "descricao", "diasVencimento");

	}

}
