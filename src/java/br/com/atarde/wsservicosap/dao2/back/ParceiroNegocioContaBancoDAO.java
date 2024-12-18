/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ParceiroNegocioContaBancoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.exception.TSApplicationException;

/**
 *
 * @author mroland
 */
class ParceiroNegocioContaBancoDAO {

    public ParceiroNegocioContaBancoDAO() {
    }

    public ParceiroNegocioContaBancoModel inserir(ParceiroNegocioContaBancoModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        broker.setPropertySQL("parceironegociocontabancodao.inserir", model.getCodigoBanco(),model.getDigitoAgencia(),
                                                                      model.getDigitoConta(), model.getNumeroAgencia(),
                                                                      model.getNumeroConta(), model.getTipoConta(),
                                                                      model.getParceiroNegocioModel().getId(),
                                                                      model.getParceiroNegocioModel().getContasReceberModel().getId());

        model.setId(broker.executeIdentity());

        return model;

    }

}
