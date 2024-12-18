/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao;

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

    public ParceiroNegocioModel obterPorIdentificador(ParceiroNegocioModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT CRD7.\"CardCode\", OCRD.\"UpdateDate\", OCRD.\"ShipToDef\", OCRD.\"BillToDef\"  ");

        sql.append(" FROM " + model.getEmpresaModel().getDbInstancia() + ".CRD7, " + model.getEmpresaModel().getDbInstancia() + ".OCRD");

        sql.append(" WHERE (CRD7.\"CardCode\" = OCRD.\"CardCode\") AND (CRD7.\"Address\" = '' OR CRD7.\"Address\" IS NULL) ");

        sql.append(" AND OCRD.\"CardType\" = 'C'");

        switch (model.getIdentificadorFiscalModel().getTipoIdentificador().intValue()) {

            case 0: // CNPJ

                sql.append(" AND CRD7.\"TaxId0\"= ?");

                break;

            case 1: // CPF

                sql.append(" AND CRD7.\"TaxId4\"= ?");

                break;

            case 2: // OUTROS

                sql.append(" AND CRD7.\"TaxId5\"= ?");

                break;

        }

        broker.setSQL(sql.toString());

        broker.set(model.getIdentificadorFiscalModel().getIdentificador());

        return (ParceiroNegocioModel) broker.getObjectBean(ParceiroNegocioModel.class, "id", "dataAtualizacao", "enderecoEntregaDefault", "enderecoCobrancaDefault");

    }

    public ParceiroNegocioModel obter(ParceiroNegocioModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OCRD.\"CardCode\", OCRD.\"ShipToDef\" AS ENDERECO_ENTREGA, OCRD.\"BillToDef\" AS ENDERECO_COBRANCA, CASE WHEN (OCRD.\"validFor\"='Y' OR (OCRD.\"validFor\"='N' AND OCRD.\"frozenFor\"='N')) THEN TRUE ELSE FALSE END AS FLAG_ATIVO FROM " + model.getEmpresaModel().getDbInstancia() + ".OCRD WHERE OCRD.\"CardCode\" = ?", model.getId());

        return (ParceiroNegocioModel) broker.getObjectBean(ParceiroNegocioModel.class, "id", "enderecoEntregaDefault", "enderecoCobrancaDefault", "flagAtivo");
    }

    public ParceiroNegocioModel obterTesteSAP() {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf("java:comp/env/jdbc/SAPJornalDS");

        broker.setSQL("SELECT \"CardCode\" , \"CardName\"  FROM SBODEMOBR.OCRD o LIMIT 1 ");

        return (ParceiroNegocioModel) broker.getObjectBean(ParceiroNegocioModel.class, "id", "nome");

    }

}
