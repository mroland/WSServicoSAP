/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.VendedorModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author mroland
 */
public class VendedorDAO {

    public VendedorDAO() {
    }

    public VendedorModel obterPeloIdentificador(VendedorModel model) {

        TSDataBaseBrokerIf brokerIf = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        brokerIf.setSQL("SELECT OSLP.\"SlpCode\" CODE FROM " + model.getEmpresaModel().getDbInstancia() + ".OSLP WHERE OSLP.\"Memo\"= ? AND OSLP.\"Active\" = 'Y'", model.getIdentificadorFiscalModel().getIdentificador());

        return (VendedorModel) brokerIf.getObjectBean(VendedorModel.class, "id");

    }

    public VendedorModel obterPeloNome(VendedorModel model) {

        TSDataBaseBrokerIf brokerIf = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        brokerIf.setSQL("SELECT OSLP.\"SlpCode\" CODE FROM " + model.getEmpresaModel().getDbInstancia() + ".OSLP WHERE OSLP.\"SlpName\" = ? AND OSLP.\"Active\" = 'Y'", model.getNome());

        return (VendedorModel) brokerIf.getObjectBean(VendedorModel.class, "id");

    }

    public VendedorModel obter(VendedorModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OSLP.\"SlpCode\" AS ID FROM " + model.getEmpresaModel().getDbInstancia() + ".OSLP WHERE OSLP.\"SlpCode\" = ?", model.getId());

        return (VendedorModel) broker.getObjectBean(VendedorModel.class, "id");

    }

}
