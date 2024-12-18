/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.HistoricoEasyclassNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.HistoricoEasyclassNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoEasyclassNotaFiscalSaidaBusiness {

    private StringBuilder info;

    public HistoricoEasyclassNotaFiscalSaidaBusiness() {
    }

    public List<HistoricoEasyclassNotaFiscalSaidaModel> pesquisar(HistoricoEasyclassNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new HistoricoEasyclassNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }


    }

    private Boolean validarPesquisar(HistoricoEasyclassNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.HISTORICOEASYCLASSNOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

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
