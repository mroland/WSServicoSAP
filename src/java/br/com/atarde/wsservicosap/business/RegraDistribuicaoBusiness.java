/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.RegraDistribuicaoDAO;
import br.com.atarde.wsservicosap.model.RegraDistribuicaoModel;

/**
 *
 * @author mroland
 */
public class RegraDistribuicaoBusiness {
    
    private String jndi;

    public RegraDistribuicaoBusiness(String jndi) {
        
        this.jndi = jndi;
        
    }
    
    public RegraDistribuicaoModel obter(RegraDistribuicaoModel model){
        
        return new RegraDistribuicaoDAO().obter(model, this.jndi);
        
    }
    
}
