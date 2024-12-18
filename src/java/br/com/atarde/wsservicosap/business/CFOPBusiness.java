/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.CFOPDAO;
import br.com.atarde.wsservicosap.model.CFOPModel;

/**
 *
 * @author mroland
 */
public class CFOPBusiness {

    private String jndi;

    public CFOPBusiness(String jndi) {

        this.jndi = jndi;

    }

    public CFOPModel obterPeloCodigo(CFOPModel model) {

        return new CFOPDAO().obterPeloCodigo(model, this.jndi);

    }
}
