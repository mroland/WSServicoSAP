/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ContasReceberBoletoRejeitadoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ContasReceberBoletoRejeitadoDAO {

    public ContasReceberBoletoRejeitadoDAO() {
    }
    
    @SuppressWarnings("unchecked")
    public List<ContasReceberBoletoRejeitadoModel> pesquisar(ContasReceberBoletoRejeitadoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("contasreceberboletorejeitadodao.pesquisar",model.getContasReceberModel().getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getOrigemModel().getId(),
                                 model.getContasReceberModel().getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getIdExterno());

        return broker.getCollectionBean(ContasReceberBoletoRejeitadoModel.class, "id", "contasReceberModel.id", "contasReceberModel.parcelaNotaFiscalSaidaModel.id", "contasReceberModel.parcelaNotaFiscalSaidaModel.numero");
    }

    public ContasReceberBoletoRejeitadoModel excluir(ContasReceberBoletoRejeitadoModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("contasreceberboletorejeitadodao.excluir", model.getId());

        broker.execute();

        return model;

    }

}
