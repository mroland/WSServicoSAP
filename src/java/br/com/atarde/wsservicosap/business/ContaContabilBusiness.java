/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.ContaContabilDAO;
import br.com.atarde.wsservicosap.model.ContaContabilModel;

/**
 *
 * @author mroland
 */
public class ContaContabilBusiness {
    
    private String jndi;

    public ContaContabilBusiness(String jndi) {
        
        this.jndi = jndi;
        
    }

    public ContaContabilModel obter(ContaContabilModel model){      

        return new ContaContabilDAO().obter(model, this.jndi);
        
    }

}
