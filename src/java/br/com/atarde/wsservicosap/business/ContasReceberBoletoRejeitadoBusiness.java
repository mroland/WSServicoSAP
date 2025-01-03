/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.BoletoDAO;
import br.com.atarde.wsservicosap.dao2.back.ContasReceberBoletoRejeitadoDAO;
import br.com.atarde.wsservicosap.dao.SapNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.BoletoModel;
import br.com.atarde.wsservicosap.model.ContasReceberBoletoRejeitadoModel;
import br.com.atarde.wsservicosap.model.ModalidadePagamentoBoletoModel;
import br.com.atarde.wsservicosap.model.SapNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ContasReceberBoletoRejeitadoBusiness {

    private StringBuilder info;

    public ContasReceberBoletoRejeitadoBusiness() {
    }

    public List<ContasReceberBoletoRejeitadoModel> pesquisar(ContasReceberBoletoRejeitadoModel model) throws TSApplicationException {
        
        ModalidadePagamentoBoletoModel modalidadePagamentoBoletoModel;

        List<ContasReceberBoletoRejeitadoModel> contasReceberBoletoRejeitadoModelList;

        if (this.validarPesquisa(model)) {

            contasReceberBoletoRejeitadoModelList = new ContasReceberBoletoRejeitadoDAO().pesquisar(model);

            for (ContasReceberBoletoRejeitadoModel item : contasReceberBoletoRejeitadoModelList) {
                            
                item.getContasReceberModel().setContasReceberBoletoRejeitadoModel(item);

                item.getContasReceberModel().getParcelaNotaFiscalSaidaModel().setContasReceberModel(item.getContasReceberModel());               
                
                item.getContasReceberModel().getParcelaNotaFiscalSaidaModel().setNotaFiscalSaidaModel(new SapNotaFiscalSaidaDAO().obterContasReceberBoletoRejeitado(new SapNotaFiscalSaidaModel(item.getContasReceberModel().getParcelaNotaFiscalSaidaModel())));
                
                modalidadePagamentoBoletoModel = new ModalidadePagamentoBoletoModel(item.getContasReceberModel());
                
                modalidadePagamentoBoletoModel.setBoletoModel(new BoletoDAO().obterPeloContasReceber(new BoletoModel(modalidadePagamentoBoletoModel)));
                               
                item.getContasReceberModel().setModalidadePagamentoModel(modalidadePagamentoBoletoModel);               
                
                modalidadePagamentoBoletoModel.getBoletoModel().setModalidadePagamentoBoletoModel(null);                

                item.getContasReceberModel().setContasReceberBoletoRejeitadoModel(null);

                item.getContasReceberModel().getParcelaNotaFiscalSaidaModel().setContasReceberModel(null);
                
                item.getContasReceberModel().getModalidadePagamentoModel().setContasReceberModel(null);

            }

            return contasReceberBoletoRejeitadoModelList;
            
        } else {

            throw new TSApplicationException(this.info.toString());
        }

    }

    private Boolean validarPesquisa(ContasReceberBoletoRejeitadoModel model) {

        Boolean retorno = true;

        this.info = new StringBuilder();

        if (TSUtil.isEmpty(model)) {

            info.append(Constantes.CONTAS_RECEBER_BOLETO_REJEITADO_MODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getContasReceberModel())) {

                info.append(Constantes.CONTAS_RECEBER + Constantes.CAMPO_OBRIGATORIO + "\n");

                retorno = false;

            } else {

                if (TSUtil.isEmpty(model.getContasReceberModel().getParcelaNotaFiscalSaidaModel())) {

                    info.append(Constantes.PARCELA_ID + Constantes.CAMPO_OBRIGATORIO + "\n");

                    retorno = false;

                } else {

                    if (TSUtil.isEmpty(model.getContasReceberModel().getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel())) {

                        info.append(Constantes.NOTAFISCAL_ID + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    } else {

                        if (TSUtil.isEmpty(model.getContasReceberModel().getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getOrigemModel())
                                || (TSUtil.isEmpty(model.getContasReceberModel().getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getOrigemModel().getId()))
                                || (model.getContasReceberModel().getParcelaNotaFiscalSaidaModel().getNotaFiscalSaidaModel().getOrigemModel().getId() == 0)) {

                            info.append(Constantes.OBJETO_OBRIGATORIO_ORIGEM + Constantes.CAMPO_OBRIGATORIO + "\n");

                            retorno = false;


                        }


                    }

                }


            }

        }



        return retorno;

    }

    public String excluir(ContasReceberBoletoRejeitadoModel model) {

        String retorno = null;

        try {

            retorno = this.validarExcluir(model);

            if (TSUtil.isEmpty(retorno)) {

                new ContasReceberBoletoRejeitadoDAO().excluir(model);

            }
        } catch (TSApplicationException ex) {

            retorno = "ERRO-->" + ex.getMessage();

        }

        return retorno;

    }

    private String validarExcluir(ContasReceberBoletoRejeitadoModel model) {

        StringBuilder retorno = new StringBuilder();

        if(TSUtil.isEmpty(model)){

            retorno.append(Constantes.CONTAS_RECEBER_BOLETO_REJEITADO_MODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

        }else{

            if(TSUtil.isEmpty(model.getId()) || (model.getId()==0)){

                retorno.append(Constantes.CONTAS_RECEBER_BOLETO_REJEITADO_MODEL_ID + Constantes.CAMPO_OBRIGATORIO + "\n");
            }

        }

        return retorno.toString();

    }

}
