/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.ContasReceberModel;
import br.com.atarde.wsservicosap.model.ModalidadePagamentoBoletoModel;
import br.com.atarde.wsservicosap.model.ModalidadePagamentoTransferenciaModel;
import br.com.atarde.wsservicosap.model.ParcelaNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ContasReceberDAO {

    public ContasReceberDAO() {
    }

    public void inserirBoleto(ContasReceberModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.beginTransaction();

            this.inserir(model, broker);

            for (ParcelaNotaFiscalSaidaModel parcela : model.getParcelaNotaFiscalSaidaModelList()) {

                parcela.setContasReceberModel(model);

                new ParcelaNotaFiscalSaidaDAO().inserir(parcela,broker);
                
            }

            model.getModalidadePagamentoModel().setContasReceberModel(model);

            new ModalidadePagamentoBoletoDAO().inserir((ModalidadePagamentoBoletoModel)model.getModalidadePagamentoModel(), broker);

        broker.endTransaction();

    }

    public void inserirTransferencia(ContasReceberModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.beginTransaction();

            this.inserir(model, broker);
            
            for (ParcelaNotaFiscalSaidaModel parcela : model.getParcelaNotaFiscalSaidaModelList()) {

                parcela.setContasReceberModel(model);

                new ParcelaNotaFiscalSaidaDAO().inserir(parcela, broker);

            }

            model.getModalidadePagamentoModel().setContasReceberModel(model);

            new ModalidadePagamentoTransferenciaDAO().inserir((ModalidadePagamentoTransferenciaModel)model.getModalidadePagamentoModel(), broker);

        broker.endTransaction();

    }

    @SuppressWarnings("unchecked")
    public List<ContasReceberModel> pesquisarPorNotaFiscalSaidaIdExterno(ContasReceberModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("contasreceberdao.pesquisarPorNotaFiscalSaidaIdExterno",model.getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getIdExterno(), model.getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getOrigemModel().getId());

        return broker.getCollectionBean(ContasReceberModel.class, "id", "tipoModalidade", "parcelaNotaFiscalSaidaModel.id");
        
    }

    public void inserirDebitoConta(ContasReceberModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.beginTransaction();

            this.inserir(model, broker);
            
            for (ParcelaNotaFiscalSaidaModel parcela : model.getParcelaNotaFiscalSaidaModelList()) {

                parcela.setContasReceberModel(model);

                new ParcelaNotaFiscalSaidaDAO().inserir(parcela, broker);

            }

            model.getModalidadePagamentoModel().setContasReceberModel(model);

            new ModalidadePagamentoBoletoDAO().inserir((ModalidadePagamentoBoletoModel)model.getModalidadePagamentoModel(), broker);
            
            model.getParceiroNegocioModel().setContasReceberModel(model);
            
            model.getParceiroNegocioModel().getParceiroNegocioContaBancoModel().setParceiroNegocioModel(model.getParceiroNegocioModel());

            new ParceiroNegocioContaBancoDAO().inserir(model.getParceiroNegocioModel().getParceiroNegocioContaBancoModel(), broker);            


        broker.endTransaction();

    }

    private ContasReceberModel inserir(ContasReceberModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        broker.setPropertySQL("contasreceberdao.inserir", model.getParceiroNegocioModel().getId(), model.getDataLancamento(),
                                                          model.getDataDocumento(), model.getDataVencimento(), model.getValor(),
                                                          model.getStatusModel().getId(), model.getTipoModalidade(), new Timestamp(System.currentTimeMillis()));

        model.setId(broker.executeIdentity());

        return model;

    }

    @SuppressWarnings("unchecked")
    public List<ContasReceberModel> pesquisarPorParcelaNotaFiscalSaida(ContasReceberModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("contasreceberdao.pesquisarPorParcelaNotaFiscalSaida", model.getParcelaNotaFiscalSaidaModel().getId(), model.getParcelaNotaFiscalSaidaModel().getNumero());

        return broker.getCollectionBean(ContasReceberModel.class, "id");
    }

    public ContasReceberModel obterPorBoletoNossoNumero(ContasReceberModel model) {
        
        ModalidadePagamentoBoletoModel modalidadePagamentoBoletoModel = (ModalidadePagamentoBoletoModel)model.getModalidadePagamentoModel();

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();
        
        broker.setPropertySQL("contasreceberdao.obterPorBoletoNossoNumero", modalidadePagamentoBoletoModel.getBoletoModel().getNossoNumero());
        
        return (ContasReceberModel) broker.getObjectBean(ContasReceberModel.class, "id", "valor");
    }



}
