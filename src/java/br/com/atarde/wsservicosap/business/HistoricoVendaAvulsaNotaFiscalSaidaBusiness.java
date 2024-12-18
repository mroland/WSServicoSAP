/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.HistoricoVendaAvulsaNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.HistoricoVendaAvulsaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoVendaAvulsaNotaFiscalSaidaBusiness {

    private StringBuilder info;

    public HistoricoVendaAvulsaNotaFiscalSaidaBusiness() {
    }

    public List<HistoricoVendaAvulsaNotaFiscalSaidaModel> pesquisar(HistoricoVendaAvulsaNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new HistoricoVendaAvulsaNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

    }
    private Boolean validarPesquisar(HistoricoVendaAvulsaNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.HISTORICOVENDAAVULSANOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 2) {

                        this.info.append(Constantes.OBJETO_ORIGEM_VENDAAVULSA + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
