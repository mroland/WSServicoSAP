/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ParcelaNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ParcelaNotaFiscalSaidaDAO {


    public ParcelaNotaFiscalSaidaDAO() {
    }

    @SuppressWarnings("unchecked")
    public List<ParcelaNotaFiscalSaidaModel> pesquisarParcelaAberta(ParcelaNotaFiscalSaidaModel model) {
        
        StringBuilder sql = new StringBuilder();

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        sql.append("SELECT INV6.DOCENTRY ID, (INV6.INSTOTALSY - INV6.PAIDSYS) VALORABERTO, INV6.INSTLMNTID NUMERO, INV6.DUEDATE DATAVENCIMENTO FROM DBO.INV6 INV6 WITH(NOLOCK) INNER JOIN DBO.OINV OINV WITH(NOLOCK) ON (OINV.DOCENTRY = INV6.DOCENTRY) INNER JOIN DBO.CRD7 WITH(NOLOCK) ON (CRD7.CARDCODE = OINV.CARDCODE) WHERE INV6.STATUS ='O' AND (CRD7.ADDRESS = '' OR CRD7.Address IS NULL) ");

        sql.append(" AND OINV.U_ATRD_Origem = ? ");

        sql.append(" AND OINV.NUMATCARD = ISNULL(?, OINV.NUMATCARD) ");

        sql.append(" AND NOT EXISTS (SELECT 'X' FROM INTEGRACAOSISTEMALEGADO.DBO.CONTAS_RECEBER C WITH(NOLOCK) INNER JOIN INTEGRACAOSISTEMALEGADO.DBO.PARCELA_NOTA_FISCAL_SAIDA P WITH(NOLOCK) ON (C.ID = P.CONTAS_RECEBER_ID) WHERE C.STATUS_ID IN (0,2) AND P.ID = INV6.DOCENTRY AND P.NUMERO = INV6.InstlmntID) ");

        switch (model.getNotaFiscalSaidaModel().getClienteCobrancaModel().getIdentificadorFiscalModel().getTipoIdentificador().intValue()){

            case 0://CNPJ

                sql.append(" AND CRD7.TAXID0 = ?");

                break;

            case 1://CPF

                sql.append(" AND CRD7.TAXID4 = ?");

                break;

            case 2://OUTROS

                sql.append(" AND CRD7.TAXID5 = ?");

                break;

        }

        broker.setSQL(sql.toString());

        broker.set(model.getNotaFiscalSaidaModel().getOrigemModel().getId());

        broker.set(model.getNotaFiscalSaidaModel().getIdExterno());

        broker.set(model.getNotaFiscalSaidaModel().getClienteCobrancaModel().getIdentificadorFiscalModel().getIdentificador());

        return broker.getCollectionBean(ParcelaNotaFiscalSaidaModel.class, "id","valorAberto","numero","dataVencimento");

    }

    @SuppressWarnings("unchecked")
    public List<ParcelaNotaFiscalSaidaModel> pesquisarParcelaPaga(ParcelaNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("parcelanotafiscalsaidadao.pesquisarParcelaPaga", model.getContasReceberModel().getDataCriacao(), model.getNotaFiscalSaidaModel().getIdExterno(), model.getNotaFiscalSaidaModel().getOrigemModel().getId());

        return broker.getCollectionBean(ParcelaNotaFiscalSaidaModel.class, "numero", "id", "valorPago", "contasReceberModel.id", "contasReceberModel.dataPagamento");
    }

    public ParcelaNotaFiscalSaidaModel inserir(ParcelaNotaFiscalSaidaModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        broker.setPropertySQL("parcelanotafiscalsaidadao.inserir", model.getId(), model.getContasReceberModel().getId(),
                                                                   model.getNumero(), model.getValorAberto());

        model.setId(broker.executeIdentity());

        return model;
    }

    @SuppressWarnings("unchecked")
    public List<ParcelaNotaFiscalSaidaModel> pesquisarPorNotaFiscalSaida(ParcelaNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("parcelanotafiscalsaidadao.pesquisarPorNotaFiscalSaida", model.getNotaFiscalSaidaModel().getId());

        return broker.getCollectionBean(ParcelaNotaFiscalSaidaModel.class, "id", "numero");
    }

}
