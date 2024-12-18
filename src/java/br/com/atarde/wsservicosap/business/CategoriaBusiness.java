/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.CategoriaDAO;
import br.com.atarde.wsservicosap.model.CategoriaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.util.TSUtil;

/**
 *
 * @author mroland
 */
public class CategoriaBusiness {

    private String jndi;

    public CategoriaBusiness(String jndi) {

        this.jndi = jndi;
    }

    public CategoriaModel obterPeloCodigo(CategoriaModel model) {

        return new CategoriaDAO().obterPeloCodigo(model, this.jndi);

    }
}
