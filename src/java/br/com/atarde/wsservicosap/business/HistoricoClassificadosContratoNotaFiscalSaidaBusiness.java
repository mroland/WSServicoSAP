/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.HistoricoClassificadosContratoNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.HistoricoClassificadosContratoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoClassificadosContratoNotaFiscalSaidaBusiness {

    private StringBuilder info;

    public HistoricoClassificadosContratoNotaFiscalSaidaBusiness() {
    }

    public List<HistoricoClassificadosContratoNotaFiscalSaidaModel> pesquisar(HistoricoClassificadosContratoNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new HistoricoClassificadosContratoNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }


    }

    private Boolean validarPesquisar(HistoricoClassificadosContratoNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.HISTORICOCLASSIFICADOSCONTRATONOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 8) {

                        this.info.append(Constantes.OBJETO_ORIGEM_CLASSIFICADOS + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
