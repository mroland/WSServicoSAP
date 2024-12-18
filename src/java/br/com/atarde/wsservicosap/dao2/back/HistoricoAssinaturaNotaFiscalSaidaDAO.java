/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.HistoricoAssinaturaNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoAssinaturaNotaFiscalSaidaDAO {

    public HistoricoAssinaturaNotaFiscalSaidaDAO() {
    }

    @SuppressWarnings("unchecked")
    public List<HistoricoAssinaturaNotaFiscalSaidaModel> pesquisar(HistoricoAssinaturaNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("historicoassinaturanotafiscalsaidadao.pesquisar", model.getIdExterno(), model.getOrigemModel().getId());

        return broker.getCollectionBean(HistoricoAssinaturaNotaFiscalSaidaModel.class, "id", "idExterno", "statusModel.id", "statusModel.descricao", "mensagemErroImportacao", "dataExportacao", "dataImportacao");

    }
}
