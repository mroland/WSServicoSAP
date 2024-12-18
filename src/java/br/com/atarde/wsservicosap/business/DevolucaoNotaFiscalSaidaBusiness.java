/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.CancelaContasReceberDAO;
import br.com.atarde.wsservicosap.dao2.back.DevolucaoNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.CancelaContasReceberModel;
import br.com.atarde.wsservicosap.model.ContasReceberModel;
import br.com.atarde.wsservicosap.model.DevolucaoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.ParcelaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.sql.Timestamp;

/**
 *
 * @author mroland
 */
public class DevolucaoNotaFiscalSaidaBusiness {

    private StringBuilder info;

    public DevolucaoNotaFiscalSaidaBusiness() {
    }

    public String inserir(DevolucaoNotaFiscalSaidaModel model) {

        CancelaContasReceberModel cancelaContasReceberModel;

        if (this.validar(model)) {

            try {

                model.getNotaFiscalSaidaModel().setParcelaNotaFiscalSaidaModelList(new ParcelaNotaFiscalSaidaBusiness().pesquisarPorNotaFiscalSaida(new ParcelaNotaFiscalSaidaModel(model.getNotaFiscalSaidaModel())));

                for (ParcelaNotaFiscalSaidaModel parcela : model.getNotaFiscalSaidaModel().getParcelaNotaFiscalSaidaModelList()) {

                    parcela.setContasReceberModelList(new ContasReceberBusiness().pesquisarPorParcelaNotaFiscalSaida(new ContasReceberModel(parcela)));

                }

                for (ParcelaNotaFiscalSaidaModel parcela : model.getNotaFiscalSaidaModel().getParcelaNotaFiscalSaidaModelList()) {

                    if (!TSUtil.isEmpty(parcela.getContasReceberModelList())) {

                        for (ContasReceberModel contasReceberModel : parcela.getContasReceberModelList()) {

                            contasReceberModel.setParcelaNotaFiscalSaidaModel(parcela);

                            cancelaContasReceberModel = new CancelaContasReceberModel(contasReceberModel);

                            cancelaContasReceberModel.setStatusModel(new StatusModel(0L));

                            cancelaContasReceberModel.setDataExportacao(new Timestamp(System.currentTimeMillis()));

                            if (TSUtil.isEmpty(new CancelaContasReceberDAO().obter(cancelaContasReceberModel))) {

                                new CancelaContasReceberDAO().inserir(cancelaContasReceberModel);

                            }

                        }
                    }
                }

                model.setStatusModel(new StatusModel(0L));

                if (TSUtil.isEmpty(new DevolucaoNotaFiscalSaidaDAO().obter(model))) {

                    new DevolucaoNotaFiscalSaidaDAO().inserir(model);

                } else {

                    this.info.append("A Nota ja se encontra na tabela de interface para ser cancelada.");

                }

            } catch (TSApplicationException ex) {

                this.info.append(Constantes.ERRO_TI + "\n");

                ex.printStackTrace();

            }

        }

        return this.info.toString();
    }

    private boolean validar(DevolucaoNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        this.info = new StringBuilder();

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.DEVOLUCAONOTAFISCAL + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel())) {

                this.info.append(Constantes.NOTAFISCAL + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {

                if (TSUtil.isEmpty(model.getNotaFiscalSaidaModel().getId()) || model.getNotaFiscalSaidaModel().getId() == 0) {

                    this.info.append(Constantes.NOTAFISCAL_ID + Constantes.CAMPO_OBRIGATORIO + "\n");

                }


            }


        }

        return retorno;


    }
}
