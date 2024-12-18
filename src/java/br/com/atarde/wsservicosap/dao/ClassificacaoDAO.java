/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.ClassificacaoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mroland
 */
public class ClassificacaoDAO {

    public ClassificacaoModel obter(ClassificacaoModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OCRG.\"GroupCode\" GROUPCODE FROM " + model.getEmpresaModel().getDbInstancia() + ".OCRG WHERE OCRG.\"GroupCode\" = ? AND OCRG.\"GroupType\"  = ?", model.getId(), model.getParceiroNegocioModel().getTipo());

        return (ClassificacaoModel) broker.getObjectBean(ClassificacaoModel.class, "id");

    }
}
