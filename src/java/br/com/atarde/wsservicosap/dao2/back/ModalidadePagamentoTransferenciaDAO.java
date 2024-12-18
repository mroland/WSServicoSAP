/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ModalidadePagamentoTransferenciaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.exception.TSApplicationException;

/**
 *
 * @author mroland
 */
public class ModalidadePagamentoTransferenciaDAO {

    public ModalidadePagamentoTransferenciaDAO() {
    }
/*
    public ModalidadePagamentoTransferenciaModel obterPorContasReceberSAP(ModalidadePagamentoTransferenciaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("modalidadepagamentotransferenciadao.obterPorContasReceberSAP", model.getContasReceberModel().getId());

        return (ModalidadePagamentoTransferenciaModel) broker.getObjectBean(ModalidadePagamentoTransferenciaModel.class, "dataTransferencia");
    }
*/
    public ModalidadePagamentoTransferenciaModel inserir(ModalidadePagamentoTransferenciaModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        broker.setPropertySQL("modalidadepagamentotransferenciadao.inserir", model.getContasReceberModel().getId(), model.getValor(),model.getContaContabilModel().getId(),
                                                                             model.getReferencia(), model.getDataTransferencia());

        model.setId(broker.executeIdentity());

        return model;

    }

}
