/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.CancelaContasReceberDAO;
import br.com.atarde.wsservicosap.dao2.back.ContasReceberDAO;
import br.com.atarde.wsservicosap.dao2.back.ModalidadePagamentoBoletoDAO;
import br.com.atarde.wsservicosap.model.CancelaContasReceberModel;
import br.com.atarde.wsservicosap.model.ContasReceberModel;
import br.com.atarde.wsservicosap.model.ModalidadePagamentoBoletoModel;
import br.com.atarde.wsservicosap.model.ModalidadePagamentoTransferenciaModel;
import br.com.atarde.wsservicosap.model.ParceiroNegocioContaBancoModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ContasReceberBusiness extends ContasReceberABBusiness {

    private StringBuilder info;
    private ContasReceberModel contasReceberModel;

    public ContasReceberBusiness(ContasReceberModel model) {

        this.contasReceberModel = model;

    }

    public ContasReceberBusiness() {
    }

    public String inserirBoleto() {

        String retorno = null;

        contasReceberModel.setStatusModel(new StatusModel(0L));

        contasReceberModel.setTipoModalidade("B");

        try {

            retorno = this.validarBoleto();

            if ("".equals(retorno)) {

                new ContasReceberDAO().inserirBoleto(contasReceberModel);

                retorno = null;

            }

        } catch (Exception e) {

            retorno = Constantes.ERRO_TI + " ERRO: " + e.getMessage();

        }

        return retorno;

    }

    public String inserirTransferencia() {

        String retorno = null;

        contasReceberModel.setStatusModel(new StatusModel(0L));

        contasReceberModel.setTipoModalidade("T");

        try {

            retorno = this.validarTransferencia();

            if ("".equals(retorno)) {

                new ContasReceberDAO().inserirTransferencia(contasReceberModel);

                retorno = null;

            }

        } catch (TSApplicationException ex) {

            retorno = Constantes.ERRO_TI + " ERRO: " + ex.getMessage();

        } catch (Exception e) {

            retorno = Constantes.ERRO_TI + " ERRO: " + e.getMessage();
        }

        return retorno;

    }

    @Override
    protected String validarBoleto() {

        ModalidadePagamentoBoletoModel boleto;

        StringBuilder retorno = new StringBuilder();

        retorno.append(this.validarGlobal(this.contasReceberModel));

        if (TSUtil.isEmpty(this.contasReceberModel.getModalidadePagamentoModel())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_BOLETO + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            boleto = (ModalidadePagamentoBoletoModel) this.contasReceberModel.getModalidadePagamentoModel();

            if (TSUtil.isEmpty(boleto.getFormaPagamentoModel()) || (TSUtil.isEmpty(new FormaPagamentoBusiness().obter(boleto.getFormaPagamentoModel())))) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_FORMAPAGAMENTO + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(boleto.getDataVencimento())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_VENCIMENTO + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {

                //modificacao realizada 27/122013 para atender ContasReceberEmLote(sujeiras)
                if (TSUtil.isEmpty(this.contasReceberModel.getDataDocumento())) {

                    this.contasReceberModel.setDataDocumento(new Date());

                }

                if (TSUtil.isEmpty(this.contasReceberModel.getDataLancamento())) {

                    this.contasReceberModel.setDataLancamento(new Date());

                }

                this.contasReceberModel.setDataVencimento(boleto.getDataVencimento());

            }

        }

        return retorno.toString();
    }

    @Override
    protected String validarTransferencia() {

        ModalidadePagamentoTransferenciaModel transferencia;

        StringBuilder retorno = new StringBuilder();

        retorno.append(this.validarGlobal(this.contasReceberModel));

        if (TSUtil.isEmpty(this.contasReceberModel.getModalidadePagamentoModel())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_TRANSFERENCIA + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            transferencia = (ModalidadePagamentoTransferenciaModel) this.contasReceberModel.getModalidadePagamentoModel();

            if (TSUtil.isEmpty(transferencia.getContaContabilModel()) || (TSUtil.isEmpty(new ContaContabilBusiness(Constantes.JNDI_JORNAL).obter(transferencia.getContaContabilModel())))) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_CONTACONTABIL + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(transferencia.getDataTransferencia())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_TRANSFERENCIA + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {

                //modificacao realizada 27/122013 para atender ContasReceberEmLote(sujeiras)
                if (TSUtil.isEmpty(this.contasReceberModel.getDataDocumento())) {

                    this.contasReceberModel.setDataDocumento(new Date());

                }

                if (TSUtil.isEmpty(this.contasReceberModel.getDataLancamento())) {

                    this.contasReceberModel.setDataLancamento(new Date());

                }

                this.contasReceberModel.setDataVencimento(transferencia.getDataTransferencia());

            }

        }

        return retorno.toString();

    }

    public List<ContasReceberModel> pesquisarPorNotaFiscalSaidaIdExterno(ContasReceberModel model) throws TSApplicationException {

        List<ContasReceberModel> contasReceberModelList = null;

        if (this.validarPorNotaFiscalSaidaIdExterno(model)) {

            contasReceberModelList = new ContasReceberDAO().pesquisarPorNotaFiscalSaidaIdExterno(model);

        } else {

            throw new TSApplicationException(this.info.toString());
        }

        return contasReceberModelList;

    }

    public String inserirDebitoConta() {

        StringBuilder retorno = new StringBuilder();

        contasReceberModel.setStatusModel(new StatusModel(0L));

        contasReceberModel.setTipoModalidade("B");

        retorno.append(this.validarBoleto());

        retorno.append(this.validarContaBancaria(this.contasReceberModel.getParceiroNegocioModel().getParceiroNegocioContaBancoModel()));

        try {

            if ("".equals(retorno.toString())) {

                new ContasReceberDAO().inserirDebitoConta(this.contasReceberModel);

            }

        } catch (TSApplicationException e) {

            retorno.append(Constantes.ERRO_TI + " ERRO: ").append(e.getMessage());

            e.printStackTrace();

        } catch (Exception ex) {

            retorno.append(Constantes.ERRO_TI + " ERRO: ").append(ex.getMessage());

            ex.printStackTrace();

        }

        return retorno.toString();
    }

    private String validarContaBancaria(ParceiroNegocioContaBancoModel model) {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model)) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_CONTA_BANCO + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            if (TSUtil.isEmpty(model.getCodigoBanco())) {

                retorno.append(Constantes.PARCEIRO_NEGOCIO_CODIGO_BANCO + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getNumeroAgencia())) {

                retorno.append(Constantes.PARCEIRO_NEGOCIO_NUMERO_AGENCIA + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getNumeroConta())) {

                retorno.append(Constantes.PARCEIRO_NEGOCIO_NUMERO_CONTA + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getTipoConta())) {

                retorno.append(Constantes.PARCEIRO_NEGOCIO_TIPO_CONTA + Constantes.CAMPO_OBRIGATORIO + "\n");

            }
        }

        return retorno.toString();

    }

    public String inserirCancelamento(ContasReceberModel model) {

        StringBuilder retorno = new StringBuilder();

        CancelaContasReceberModel cancelaContasReceberModel = new CancelaContasReceberModel(model);

        cancelaContasReceberModel.setStatusModel(new StatusModel(0L));

        cancelaContasReceberModel.setDataExportacao(new Timestamp(System.currentTimeMillis()));

        retorno.append(this.validarCancelamento(model));

        if ("".equals(retorno.toString())) {

            try {

                if (TSUtil.isEmpty(new CancelaContasReceberDAO().obter(cancelaContasReceberModel))) {

                    new CancelaContasReceberDAO().inserir(cancelaContasReceberModel);

                }

            } catch (TSApplicationException e) {

                retorno.append(Constantes.ERRO_TI + " ERRO: ").append(e.getMessage());

                e.printStackTrace();

            } catch (Exception ex) {

                retorno.append(Constantes.ERRO_TI + " ERRO: ").append(ex.getMessage());

                ex.printStackTrace();

            }

        }

        return retorno.toString();

    }

    private String validarCancelamento(ContasReceberModel model) {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model)) {

            retorno.append(Constantes.CONTAS_RECEBER + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            if (TSUtil.isEmpty(model.getId()) || (model.getId() == 0)) {

                retorno.append(Constantes.CONTAS_RECEBER_ID + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getParcelaNotaFiscalSaidaModel()) || TSUtil.isEmpty(model.getParcelaNotaFiscalSaidaModel().getId()) || model.getParcelaNotaFiscalSaidaModel().getId() == 0) {

                retorno.append(Constantes.PARCELA_ID + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

        }

        return retorno.toString();

    }

    public List<ContasReceberModel> pesquisarPorParcelaNotaFiscalSaida(ContasReceberModel model) {

        return new ContasReceberDAO().pesquisarPorParcelaNotaFiscalSaida(model);

    }

    private Boolean validarPorNotaFiscalSaidaIdExterno(ContasReceberModel model) {

        this.info = new StringBuilder();

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.CONTAS_RECEBER + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getParcelaNotaFiscalSaidaModel())) {

                this.info.append(Constantes.PARCELA_ID + Constantes.CAMPO_OBRIGATORIO + "\n");

                retorno = false;

            } else {

                if (TSUtil.isEmpty(model.getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel())) {

                    this.info.append(Constantes.NOTAFISCAL_ID + Constantes.CAMPO_OBRIGATORIO + "\n");

                    retorno = false;

                } else {

                    if (TSUtil.isEmpty(model.getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getIdExterno())) {

                        this.info.append(Constantes.OBJETO_OBRIGATORIO_ID_EXTERNO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                    if (TSUtil.isEmpty(model.getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getOrigemModel()) || (model.getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getOrigemModel().getId() == 0L)) {

                        this.info.append(Constantes.OBJETO_OBRIGATORIO_ORIGEM + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }

        }

        return retorno;
    }

    public ContasReceberModel obterPorBoletoNossoNumero(ContasReceberModel model) throws TSApplicationException {

        contasReceberModel = null;

        if (this.validarPorNotaFiscalSaidaIdExterno(model)) {

            contasReceberModel = new ContasReceberDAO().obterPorBoletoNossoNumero(model);

            contasReceberModel.setModalidadePagamentoModel(new ModalidadePagamentoBoletoDAO().obterPorContasReceber(new ModalidadePagamentoBoletoModel()));

        } else {

            throw new TSApplicationException(this.info.toString());
        }

        return contasReceberModel;

    }
}
