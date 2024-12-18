/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.HistoricoClassificadosExecucaoNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoClassificadosExecucaoNotaFiscalSaidaDAO {

    public HistoricoClassificadosExecucaoNotaFiscalSaidaDAO() {
    }

    @SuppressWarnings("unchecked")
    public List<HistoricoClassificadosExecucaoNotaFiscalSaidaModel> pesquisar(HistoricoClassificadosExecucaoNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("historicoClassificadosExecucaonotafiscalsaidadao.pesquisar", model.getIdExterno(), model.getOrigemModel().getId());

        return broker.getCollectionBean(HistoricoClassificadosExecucaoNotaFiscalSaidaModel.class, "id", "idExterno", "statusModel.id", "statusModel.descricao", "mensagemErroImportacao", "dataExportacao", "dataImportacao");


    }

}
