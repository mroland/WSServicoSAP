/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.FormaPagamentoDAO;
import br.com.atarde.wsservicosap.model.FormaPagamentoModel;

/**
 *
 * @author mroland
 */
public class FormaPagamentoBusiness {

    public FormaPagamentoBusiness() {
    }

    public FormaPagamentoModel obter(FormaPagamentoModel model){

        model.setTipo("I"); //invoice

        return new FormaPagamentoDAO().obter(model);
    }

}
