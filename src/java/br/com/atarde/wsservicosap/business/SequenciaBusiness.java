/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.SequenciaDAO;
import br.com.atarde.wsservicosap.model.SequenciaModel;

/**
 *
 * @author mroland
 */
public class SequenciaBusiness {
    
    private String jndi;

    public SequenciaBusiness(String jndi) {

        this.jndi = jndi;

    }

    public SequenciaModel obter(SequenciaModel model) {

        return new SequenciaDAO().obter(model, this.jndi);
    }
}
