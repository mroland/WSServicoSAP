/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.HistoricoFotografiaNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.HistoricoFotografiaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoFotografiaNotaFiscalSaidaBusiness {

    private StringBuilder info;

    public HistoricoFotografiaNotaFiscalSaidaBusiness() {
    }

    public List<HistoricoFotografiaNotaFiscalSaidaModel> pesquisar(HistoricoFotografiaNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new HistoricoFotografiaNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }



    }

    private Boolean validarPesquisar(HistoricoFotografiaNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.HISTORICOFOTOGRAFIANOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 4) {

                        this.info.append(Constantes.OBJETO_ORIGEM_FOTOGRAFIA + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
