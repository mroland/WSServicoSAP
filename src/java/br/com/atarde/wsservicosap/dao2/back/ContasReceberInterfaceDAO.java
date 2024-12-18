/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ContasReceberInterfaceModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ContasReceberInterfaceDAO {

    public ContasReceberInterfaceDAO() {
    }

    @SuppressWarnings("unchecked")
    public List<ContasReceberInterfaceModel> pesquisar(ContasReceberInterfaceModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("contasreceberinterfacedao.pesquisar",model.getContasReceberModel().getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getOrigemModel().getId(),
                                 model.getContasReceberModel().getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getIdExterno());

        return broker.getCollectionBean(ContasReceberInterfaceModel.class, "id", "contasReceberModel.id", "status", "contasReceberModel.parcelaNotaFiscalSaidaModel.id", "contasReceberModel.parcelaNotaFiscalSaidaModel.numero",
                                                                            "contasReceberModel.dataPagamento");
    }

    public ContasReceberInterfaceModel excluir(ContasReceberInterfaceModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("contasreceberinterfacedao.excluir", model.getId());

        broker.execute();

        return model;

    }

}
