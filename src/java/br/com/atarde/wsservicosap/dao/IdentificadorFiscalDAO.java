/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.IdentificadorFiscalModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class IdentificadorFiscalDAO {

    public IdentificadorFiscalDAO() {
    }

    public IdentificadorFiscalModel obterEnderecoNulo(IdentificadorFiscalModel model){

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT CRD7.\"Address\" FROM " + model.getEmpresaModel().getDbInstancia() +  ".CRD7 CRD7 WHERE CRD7.\"CardCode\" = ? AND CRD7.\"Address\" = ?", model.getParceiroNegocioModel().getId(),model.getEnderecoId());

        return (IdentificadorFiscalModel) broker.getObjectBean(IdentificadorFiscalModel.class, "enderecoId");
        
    }

}
