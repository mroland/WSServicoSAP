/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.model.ContasReceberModel;
import br.com.atarde.wsservicosap.model.ParcelaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.util.TSUtil;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mroland
 */
public abstract class ContasReceberABBusiness {

    protected abstract String validarBoleto();

    protected abstract String validarTransferencia();

    protected String validarGlobal(ContasReceberModel model){

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model.getParceiroNegocioModel())){

            retorno.append(Constantes.OBJETO_OBRIGATORIO_PARCEIRO_NEGOCIO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (TSUtil.isEmpty(model.getValor()) || (model.getValor().equals(new BigDecimal(BigInteger.ZERO)))){

            retorno.append(Constantes.OBJETO_OBRIGATORIO_CONTASRECEBER_VALOR + Constantes.CAMPO_OBRIGATORIO + "\n");

        }else{

            model.getModalidadePagamentoModel().setValor(model.getValor());
            
        }


        if (!TSUtil.isEmpty(model.getParcelaNotaFiscalSaidaModelList())){

            for (ParcelaNotaFiscalSaidaModel parcela : model.getParcelaNotaFiscalSaidaModelList()) {

                if(TSUtil.isEmpty(parcela.getId())){

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_PARCELA_ID + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if(TSUtil.isEmpty(parcela.getNumero())){

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_PARCELA_NUMERO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if(TSUtil.isEmpty(parcela.getValorAberto())){

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_PARCELA_VALORABERTO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

            }
        }

        return retorno.toString();
    }

}
