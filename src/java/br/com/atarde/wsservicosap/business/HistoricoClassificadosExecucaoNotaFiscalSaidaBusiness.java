/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.HistoricoClassificadosExecucaoNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.HistoricoClassificadosExecucaoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoClassificadosExecucaoNotaFiscalSaidaBusiness {

    private StringBuilder info;

    public HistoricoClassificadosExecucaoNotaFiscalSaidaBusiness() {
    }

    public List<HistoricoClassificadosExecucaoNotaFiscalSaidaModel> pesquisar(HistoricoClassificadosExecucaoNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new HistoricoClassificadosExecucaoNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }


    }

    private Boolean validarPesquisar(HistoricoClassificadosExecucaoNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.HISTORICOCLASSIFICADOSEXECUCAONOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 1) {

                        this.info.append(Constantes.OBJETO_ORIGEM_EASYCLASS + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
