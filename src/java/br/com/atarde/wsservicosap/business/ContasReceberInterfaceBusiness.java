/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.ContasReceberInterfaceDAO;
import br.com.atarde.wsservicosap.dao.SapNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.ContasReceberInterfaceModel;
import br.com.atarde.wsservicosap.model.SapNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ContasReceberInterfaceBusiness {

    private StringBuilder info;

    public ContasReceberInterfaceBusiness() {
    }

    public List<ContasReceberInterfaceModel> pesquisar(ContasReceberInterfaceModel model) throws TSApplicationException {

        List<ContasReceberInterfaceModel> contasReceberInterfaceModelList;

        if (this.validarPesquisa(model)) {

            contasReceberInterfaceModelList = new ContasReceberInterfaceDAO().pesquisar(model);

            for (ContasReceberInterfaceModel item : contasReceberInterfaceModelList) {
                
                item.getContasReceberModel().setContasReceberInterfaceModel(item);

                item.getContasReceberModel().getParcelaNotaFiscalSaidaModel().setContasReceberModel(item.getContasReceberModel());

                item.getContasReceberModel().getParcelaNotaFiscalSaidaModel().setNotaFiscalSaidaModel(new SapNotaFiscalSaidaDAO().obterContasReceberInterface(new SapNotaFiscalSaidaModel(item.getContasReceberModel().getParcelaNotaFiscalSaidaModel())));

                item.getContasReceberModel().setContasReceberInterfaceModel(null);

                item.getContasReceberModel().getParcelaNotaFiscalSaidaModel().setContasReceberModel(null);

            }

            return contasReceberInterfaceModelList;
            
        } else {

            throw new TSApplicationException(this.info.toString());
        }

    }

    private Boolean validarPesquisa(ContasReceberInterfaceModel model) {

        Boolean retorno = true;

        this.info = new StringBuilder();

        if (TSUtil.isEmpty(model)) {

            info.append("LA");

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

    public String excluir(ContasReceberInterfaceModel model) {

        String retorno = null;

        try {

            retorno = this.validarExcluir(model);

            if (TSUtil.isEmpty(retorno)) {

                new ContasReceberInterfaceDAO().excluir(model);

            }
        } catch (TSApplicationException ex) {

            retorno = "ERRO-->" + ex.getMessage();

        }

        return retorno;

    }

    private String validarExcluir(ContasReceberInterfaceModel model) {

        StringBuilder retorno = new StringBuilder();

        if(TSUtil.isEmpty(model)){

            retorno.append(Constantes.CANCELACONTASRECEBER + Constantes.CAMPO_OBRIGATORIO + "\n");

        }else{

            if(TSUtil.isEmpty(model.getId()) || (model.getId()==0)){

                retorno.append(Constantes.CANCELACONTASRECEBER_ID + Constantes.CAMPO_OBRIGATORIO + "\n");
            }

        }

        return retorno.toString();

    }

}
