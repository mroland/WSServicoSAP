/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.HistoricoCobrancaNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.HistoricoCobrancaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoCobrancaNotaFiscalSaidaBusiness {

    private StringBuilder info;

    public HistoricoCobrancaNotaFiscalSaidaBusiness() {
    }

    public List<HistoricoCobrancaNotaFiscalSaidaModel> pesquisar(HistoricoCobrancaNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new HistoricoCobrancaNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }


    }

    private Boolean validarPesquisar(HistoricoCobrancaNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.HISTORICOCOBRANCANOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 10) {

                        this.info.append(Constantes.OBJETO_ORIGEM_CLASSIFICADOS + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
