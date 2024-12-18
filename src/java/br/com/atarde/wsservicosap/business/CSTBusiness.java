/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.CSTDAO;
import br.com.atarde.wsservicosap.model.CSTModel;

/**
 *
 * @author mroland
 */
public class CSTBusiness {

    private String jndi;

    public CSTBusiness(String jndi) {

        this.jndi = jndi;

    }

    public CSTModel obterPeloCodigo(CSTModel model) {

        return new CSTDAO().obterPeloCodigo(model, this.jndi);

    }
}
