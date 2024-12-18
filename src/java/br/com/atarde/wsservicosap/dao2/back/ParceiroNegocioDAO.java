/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ParceiroNegocioModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class ParceiroNegocioDAO {

    public ParceiroNegocioDAO() {
    }

    public ParceiroNegocioModel obterPeloIdentificador(ParceiroNegocioModel model) {

        StringBuilder sql = new StringBuilder();

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        sql.append("SELECT CARDCODE AS ID FROM CRD7 WITH(NOLOCK) WHERE (CRD7.ADDRESS IS NULL OR CRD7.ADDRESS = '') AND CRD7.CARDCODE = ? ");

        if (model.getIdentificadorFiscalModel().getTipoIdentificador() == 0) {
            //cnpj
            sql.append(" AND CRD7.TAXID0 = ? ");

        } else {

            if (model.getIdentificadorFiscalModel().getTipoIdentificador() == 1) {
                //cpf
                sql.append(" AND CRD7.TAXID4 = ? ");

            } else {

                if (model.getIdentificadorFiscalModel().getTipoIdentificador() == 2) {

                    //passaporte
                    sql.append(" AND CRD7.TAXID5 = ? ");

                }

            }

        }

        broker.setSQL(sql.toString());

        broker.set(model.getIdentificadorFiscalModel().getIdentificador());

        broker.set(model.getIdentificadorFiscalModel().getTipoIdentificador());

        return (ParceiroNegocioModel) broker.getObjectBean(ParceiroNegocioModel.class, "id");


    }
}
