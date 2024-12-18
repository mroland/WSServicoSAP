/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.wsdl;

import br.com.atarde.wsservicosap.business.DevolucaoNotaFiscalSaidaBusiness;
import br.com.atarde.wsservicosap.model.DevolucaoNotaFiscalSaidaModel;
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
public class DevolucaoNotaFiscalSaidaWebService {

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "inserirCancelamento")
    public String inserir(@WebParam(name = "devolucao")
    DevolucaoNotaFiscalSaidaModel model) {

        return new DevolucaoNotaFiscalSaidaBusiness().inserir(model);
    }
}
