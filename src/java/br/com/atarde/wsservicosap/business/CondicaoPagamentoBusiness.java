/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.CondicaoPagamentoDAO;
import br.com.atarde.wsservicosap.model.CondicaoPagamentoModel;

/**
 *
 * @author mroland
 */
public class CondicaoPagamentoBusiness {
    
    private String jndi;

    public CondicaoPagamentoBusiness(String jndi) {
        
        this.jndi = jndi;

    }

    public CondicaoPagamentoModel obter(CondicaoPagamentoModel model) {

        return new CondicaoPagamentoDAO().obter(model, this.jndi);

    }
}
