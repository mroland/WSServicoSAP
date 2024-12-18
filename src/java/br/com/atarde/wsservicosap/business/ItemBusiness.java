/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.ItemDAO;
import br.com.atarde.wsservicosap.model.ItemModel;

/**
 *
 * @author mroland
 */
public class ItemBusiness {

    private String jndi;

    public ItemBusiness(String jndi) {

        this.jndi = jndi;

    }

    public ItemModel obter(ItemModel model) {

        return new ItemDAO().obter(model, jndi);

    }
}
