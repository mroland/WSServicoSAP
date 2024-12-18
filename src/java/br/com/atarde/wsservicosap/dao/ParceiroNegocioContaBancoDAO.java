/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.ParceiroNegocioContaBancoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class ParceiroNegocioContaBancoDAO {

    public ParceiroNegocioContaBancoDAO() {
    }

    public ParceiroNegocioContaBancoModel obterPorContasReceber(ParceiroNegocioContaBancoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("parceironegociocontabancodao.obterPorContasReceber", model.getParceiroNegocioModel().getContasReceberModel().getId());

        return (ParceiroNegocioContaBancoModel) broker.getObjectBean(ParceiroNegocioContaBancoModel.class, "id", "parceiroNegocioModel.contasReceberModel.id", "parceiroNegocioModel.id",
                                                                                                           "codigoBanco","numeroConta","digitoConta", "numeroAgencia", "digitoAgencia", "tipoConta");
        
    }

    public ParceiroNegocioContaBancoModel obterPorParceiroNegocio(ParceiroNegocioContaBancoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("parceironegociocontabancodao.obterPorParceiroNegocio", model.getParceiroNegocioModel().getId());

        return (ParceiroNegocioContaBancoModel) broker.getObjectBean(ParceiroNegocioContaBancoModel.class, "id");

    }

}
