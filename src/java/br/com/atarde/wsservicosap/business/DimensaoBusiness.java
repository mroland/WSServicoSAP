/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.DimensaoDAO;
import br.com.atarde.wsservicosap.model.DimensaoModel;

/**
 *
 * @author mroland
 */
public class DimensaoBusiness {
    
    private String jndi;

    public DimensaoBusiness(String jndi) {
        
        this.jndi = jndi;
        
    }
    
    public DimensaoModel obter(DimensaoModel model){
        
        return new DimensaoDAO().obter(model, this.jndi);
        
    }
    
}
