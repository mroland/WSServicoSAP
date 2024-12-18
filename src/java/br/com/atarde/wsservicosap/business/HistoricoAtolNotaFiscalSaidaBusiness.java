/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.HistoricoAtolNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.HistoricoAtolNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

/**
 *
 * @author mroland
 */
public class HistoricoAtolNotaFiscalSaidaBusiness {

    private StringBuilder info;

    public HistoricoAtolNotaFiscalSaidaBusiness() {
    }

    public List<HistoricoAtolNotaFiscalSaidaModel> pesquisar(HistoricoAtolNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new HistoricoAtolNotaFiscalSaidaDAO().pesquisar(model);

        }else{

            throw  new TSApplicationException(this.info.toString());

        }


    }

    private Boolean validarPesquisar(HistoricoAtolNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)){

            this.info.append(Constantes.HISTORICOATOLNOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;
            
        }else{

            if (TSUtil.isEmpty(model.getOrigemModel())){

                if(!TSUtil.isEmpty(model.getOrigemModel().getId())){

                    if(model.getOrigemModel().getId()!=5){

                        this.info.append(Constantes.OBJETO_ORIGEM_ATARDEONLINE + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
