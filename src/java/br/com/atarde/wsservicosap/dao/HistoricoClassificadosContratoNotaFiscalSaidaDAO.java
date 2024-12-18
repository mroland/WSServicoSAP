/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.HistoricoClassificadosContratoNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoClassificadosContratoNotaFiscalSaidaDAO {

    public HistoricoClassificadosContratoNotaFiscalSaidaDAO() {
    }

    @SuppressWarnings("unchecked")
    public List<HistoricoClassificadosContratoNotaFiscalSaidaModel> pesquisar(HistoricoClassificadosContratoNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("historicoClassificadosContratonotafiscalsaidadao.pesquisar", model.getIdExterno(), model.getOrigemModel().getId());

        return broker.getCollectionBean(HistoricoClassificadosContratoNotaFiscalSaidaModel.class, "id", "idExterno", "statusModel.id", "statusModel.descricao", "mensagemErroImportacao", "dataExportacao", "dataImportacao");


    }

}
