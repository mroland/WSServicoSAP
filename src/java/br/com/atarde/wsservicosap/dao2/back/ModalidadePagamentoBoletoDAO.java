/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ModalidadePagamentoBoletoModel;
import br.com.atarde.wsservicosap.model.ModalidadePagamentoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.exception.TSApplicationException;

/**
 *
 * @author mroland
 */
public class ModalidadePagamentoBoletoDAO {

    public ModalidadePagamentoBoletoDAO() {
    }
/*
    public ModalidadePagamentoBoletoModel obterPorContasReceberSAP(ModalidadePagamentoBoletoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("modalidadepagamentoboletodao.obterPorContasRecebersap", model.getContasReceberModel().getId());

        return (ModalidadePagamentoBoletoModel) broker.getObjectBean(ModalidadePagamentoBoletoModel.class, "formaPagamentoModel");

    }
*/
    public void inserir(ModalidadePagamentoBoletoModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        broker.setPropertySQL("modalidadepagamentoboletodao.inserir", model.getContasReceberModel().getId(), model.getValor(), model.getFormaPagamentoModel().getId(),
                                                                      model.getReferencia(), model.getDataVencimento());

        model.setId(broker.executeIdentity());
    }

    public ModalidadePagamentoModel obterPorContasReceber(ModalidadePagamentoBoletoModel modalidadePagamentoBoletoModel) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
