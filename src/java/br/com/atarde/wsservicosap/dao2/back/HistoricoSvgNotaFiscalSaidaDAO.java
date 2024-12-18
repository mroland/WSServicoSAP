/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.HistoricoSvgNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoSvgNotaFiscalSaidaDAO {

    public HistoricoSvgNotaFiscalSaidaDAO() {
    }

    @SuppressWarnings("unchecked")
    public List<HistoricoSvgNotaFiscalSaidaModel> pesquisar(HistoricoSvgNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("historicosvgnotafiscalsaidadao.pesquisar", model.getIdExterno(), model.getOrigemModel().getId());

        return broker.getCollectionBean(HistoricoSvgNotaFiscalSaidaModel.class, "id", "idExterno", "statusModel.id", "statusModel.descricao", "mensagemErroImportacao", "dataExportacao", "dataImportacao");

    }
}
