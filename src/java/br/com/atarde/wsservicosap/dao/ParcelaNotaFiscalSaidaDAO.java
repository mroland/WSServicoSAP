package br.com.atarde.wsservicosap.dao;

import java.util.List;

import br.com.atarde.wsservicosap.model.ParcelaNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class ParcelaNotaFiscalSaidaDAO {

    @SuppressWarnings("unchecked")
    public List<ParcelaNotaFiscalSaidaModel> pesquisar(ParcelaNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        //broker.setPropertySQL("parcelanotafiscalsaidadao.pesquisar", model.getContasReceberLinha().getContasReceber().getId());

        return broker.getCollectionBean(ParcelaNotaFiscalSaidaModel.class, "id", "numero", "valorAberto");
    }

}
