/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.CodigoImpostoDAO;
import br.com.atarde.wsservicosap.model.CodigoImpostoModel;

/**
 *
 * @author mroland
 */
public class CodigoImpostoBusiness {

    private String jndi;
    
    public CodigoImpostoBusiness(String jndi) {

        this.jndi = jndi;
    }

    public CodigoImpostoModel obter(CodigoImpostoModel model) {

        return new CodigoImpostoDAO().obter(model, this.jndi);

    }
}
