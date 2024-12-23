/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.wsdl;

import br.com.atarde.wsservicosap.business.ContasReceberInterfaceBusiness;
import br.com.atarde.wsservicosap.model.ContasReceberInterfaceModel;
import br.com.topsys.exception.TSApplicationException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

/**
 *
 * @author mroland
 */
@WebService()
@BindingType(value="http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class ContasReceberInterfaceWebService {

    private String retorno;

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "pesquisarContasReceberInterface")
    public List<ContasReceberInterfaceModel> pesquisarContasReceberInterface(@WebParam(name = "interface") ContasReceberInterfaceModel model) {

        try {

            return new ContasReceberInterfaceBusiness().pesquisar(model);

        } catch (TSApplicationException ex) {

            ex.printStackTrace();

            retorno = ex.getMessage();
        }

        return null;

    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "retorno")
    public String retorno() {

        return this.retorno;

    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "excluir")
    public String excluirContasReceberInterface(@WebParam(name = "contasReceberInterfaceModel")
    ContasReceberInterfaceModel model) {

        return new ContasReceberInterfaceBusiness().excluir(model);
    }


}
