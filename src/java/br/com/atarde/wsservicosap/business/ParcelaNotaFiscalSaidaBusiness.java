/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.SapNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.dao2.back.ParcelaNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.ContasReceberModel;
import br.com.atarde.wsservicosap.model.ParcelaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.SapNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class ParcelaNotaFiscalSaidaBusiness {

    private StringBuilder info;

    public ParcelaNotaFiscalSaidaBusiness() {
    }

    public List<ParcelaNotaFiscalSaidaModel> pesquisarParcelaAberta(ParcelaNotaFiscalSaidaModel model) throws TSApplicationException {

        List<ParcelaNotaFiscalSaidaModel> lista;

        if (this.validar(model)) {

            lista = new ParcelaNotaFiscalSaidaDAO().pesquisarParcelaAberta(model);

            for (ParcelaNotaFiscalSaidaModel item : lista) {

                item.setNotaFiscalSaidaModel(new SapNotaFiscalSaidaDAO().obter(new SapNotaFiscalSaidaModel(item)));

            }

        } else {

            throw new TSApplicationException(this.info.toString());

        }

        return lista;

    }

    private Boolean validar(ParcelaNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        info = new StringBuilder();

        if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel())) {

            info.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCAL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel().getOrigemModel())) {

                info.append(Constantes.OBJETO_OBRIGATORIO_ORIGEM + Constantes.CAMPO_OBRIGATORIO + "\n");

                retorno = false;

            } else {

                if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel().getOrigemModel().getId())) {

                    info.append(Constantes.OBJETO_OBRIGATORIO_ORIGEM + Constantes.CAMPO_OBRIGATORIO + "\n");

                    retorno = false;

                }


            }

            if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel().getClienteCobrancaModel())) {

                info.append(Constantes.OBJETO_OBRIGATORIO_CLIENTE + Constantes.CAMPO_OBRIGATORIO + "\n");

                retorno = false;

            } else {

                if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel().getClienteCobrancaModel().getIdentificadorFiscalModel())) {

                    info.append(Constantes.OBJETO_OBRIGATORIO_IDENTIFICADOR + Constantes.CAMPO_OBRIGATORIO + "\n");

                    retorno = false;

                } else {

                    if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel().getClienteCobrancaModel().getIdentificadorFiscalModel().getIdentificador())) {

                        info.append(Constantes.OBJETO_OBRIGATORIO_IDENTIFICADOR + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                    if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel().getClienteCobrancaModel().getIdentificadorFiscalModel().getTipoIdentificador())) {

                        info.append(Constantes.OBJETO_OBRIGATORIO_TIPO_IDENTIFICADOR + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }

        }

        return retorno;

    }

    public List<ParcelaNotaFiscalSaidaModel> pesquisarParcelaPaga(ParcelaNotaFiscalSaidaModel model) throws TSApplicationException {

        String retorno = this.validarPago(model);
        
        List<ParcelaNotaFiscalSaidaModel> parcelaNotaFiscalSaidaModelList;

        if ("".equals(retorno)) {

            parcelaNotaFiscalSaidaModelList = new ParcelaNotaFiscalSaidaDAO().pesquisarParcelaPaga(model);

            for (ParcelaNotaFiscalSaidaModel item : parcelaNotaFiscalSaidaModelList) {

                item.setNotaFiscalSaidaModel(new SapNotaFiscalSaidaDAO().obter(new SapNotaFiscalSaidaModel(item)));

            }

            return parcelaNotaFiscalSaidaModelList;

        } else {

            throw new TSApplicationException(retorno);
        }

    }

    private String validarPago(ParcelaNotaFiscalSaidaModel model) {

        StringBuilder retorno = new StringBuilder();

        if(TSUtil.isEmpty(model.getContasReceberModel())){

            model.setContasReceberModel(new ContasReceberModel());
            
        }

        if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCAL + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel().getOrigemModel())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_ORIGEM + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {

                if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel().getOrigemModel().getId())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_ORIGEM + Constantes.CAMPO_OBRIGATORIO + "\n");

                }


            }

        }

        return retorno.toString();

    }

    public List<ParcelaNotaFiscalSaidaModel> pesquisarPorNotaFiscalSaida(ParcelaNotaFiscalSaidaModel model) {

        return new ParcelaNotaFiscalSaidaDAO().pesquisarPorNotaFiscalSaida(model);
    }

}
