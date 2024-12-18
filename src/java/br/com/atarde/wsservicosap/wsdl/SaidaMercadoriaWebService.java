/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.wsdl;

import br.com.atarde.wsservicosap.business.PrincipalBusiness;
import br.com.atarde.wsservicosap.model.SaidaMercadoriaModel;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.BindingType;

/**
 *
 * @author mroland
 */
@WebService(serviceName = "SaidaMercadoriaWebService")
@BindingType(value="http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class SaidaMercadoriaWebService {

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "inserir")
    public String inserirSaidaMercadoria(@WebParam(name = "saidaMercadoria")
    SaidaMercadoriaModel model) {

        return new PrincipalBusiness().inserirSaidaMercadoria(model);
        
    }
    
    @WebMethod(operationName = "cancelar")
    public String calcelarSaidaMercadoria(@WebParam(name = "saidaMercadoria")
    SaidaMercadoriaModel model) {

        return new PrincipalBusiness().cancelarSaidaMercadoria(model);
        
    }    
    
}
