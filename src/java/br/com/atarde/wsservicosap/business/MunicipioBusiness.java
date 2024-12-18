/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.MunicipioDAO;
import br.com.atarde.wsservicosap.model.MunicipioModel;

/**
 *
 * @author mroland
 */
public class MunicipioBusiness {

    private String jndi;

    public MunicipioBusiness(String jndi) {

        this.jndi= jndi;

    }

    public MunicipioModel obter(MunicipioModel model) {

        return new MunicipioDAO().obter(model, this.jndi);

    }
}
