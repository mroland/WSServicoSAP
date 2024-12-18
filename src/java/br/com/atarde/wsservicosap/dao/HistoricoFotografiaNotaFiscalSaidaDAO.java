/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.HistoricoFotografiaNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoFotografiaNotaFiscalSaidaDAO {

    public HistoricoFotografiaNotaFiscalSaidaDAO() {
    }

    @SuppressWarnings("unchecked")
    public List<HistoricoFotografiaNotaFiscalSaidaModel> pesquisar(HistoricoFotografiaNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("historicofotografianotafiscalsaidadao.pesquisar", model.getIdExterno(), model.getOrigemModel().getId());

        return broker.getCollectionBean(HistoricoFotografiaNotaFiscalSaidaModel.class, "id", "idExterno", "statusModel.id", "statusModel.descricao", "mensagemErroImportacao", "dataExportacao", "dataImportacao");

    }

}
