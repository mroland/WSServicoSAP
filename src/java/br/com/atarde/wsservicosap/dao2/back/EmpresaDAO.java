/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.EmpresaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

/**
 *
 * @author marcu
 */
public class EmpresaDAO {

    public EmpresaModel obter(EmpresaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(Constantes.JNDI_SABWEB);

        broker.setSQL("SELECT ID, DESCRICAO, FLAG_ATIVO, JNDI, SERVIDOR, DB_INSTANCIA, DB_USUARIO, DB_SENHA, APP_USUARIO, APP_SENHA, SERVIDOR_LICENCA, PORTA_LICENCA, CNPJ, URL_SAP_HANA FROM EMPRESAS WHERE ID= ?", model.getId());

        return (EmpresaModel) broker.getObjectBean(EmpresaModel.class, "id", "descricao", "flagAtivo", "jndi", "servidor", "dbInstancia", "dbUsuario", "dbSenha", "appUsuario", "appSenha", "servidorLicenca", "portaLicenca", "cnpj", "urlSapHana");

    }

}
