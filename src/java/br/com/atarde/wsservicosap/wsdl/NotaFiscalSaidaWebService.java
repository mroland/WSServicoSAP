/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.wsdl;

import br.com.atarde.wsservicosap.model.CobrancaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.business.NotaFiscalSaidaBusiness;
import br.com.atarde.wsservicosap.business.PrincipalBusiness;
import br.com.atarde.wsservicosap.model.AssinaturaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.AssinaturaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.AtolNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.AtolNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.CFOPModel;
import br.com.atarde.wsservicosap.model.CSTModel;
import br.com.atarde.wsservicosap.model.ClassificadosContratoNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.ClassificadosContratoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.ClassificadosExecucaoNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.ClassificadosExecucaoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.CobrancaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.EasyclassNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.EasyclassNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.FotografiaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.FotografiaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoAssinaturaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoAtolNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoEasyclassNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoFotografiaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoSvgNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoVendaAvulsaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaABModel;
import br.com.atarde.wsservicosap.model.RadioNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.RadioNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.SvgNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.SvgNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaNotaFiscalSaidaModel;
import br.com.topsys.exception.TSApplicationException;
import java.util.List;
import javax.jws.Oneway;
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
public class NotaFiscalSaidaWebService {

    private String retorno;

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "inserirEasyclassNotaFiscalSaida")
    public String inserirEasyclassNotaFiscalSaida(@WebParam(name = "NotaFiscal") final EasyclassNotaFiscalSaidaModel NotaFiscal) {

        return new PrincipalBusiness().inserirEasyclassNotaFiscalSaida(NotaFiscal);

    }
       
    @WebMethod(operationName = "inserirClassificadosNotaFiscalSaida")
    public String inserirClassificadosNotaFiscalSaida(@WebParam(name = "NotaFiscal") final NotaFiscalSaidaABModel NotaFiscal) {

        return new PrincipalBusiness().inserirClassificadosNotaFiscalSaida(NotaFiscal);

    }    
    
    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "inserirCobrancaNotaFiscalSaida")
    public String inserirCobrancaNotaFiscalSaida(@WebParam(name = "NotaFiscal") final CobrancaNotaFiscalSaidaModel NotaFiscal) {

        return new PrincipalBusiness().inserirCobrancaNotaFiscalSaida(NotaFiscal);

    }    

    @WebMethod(operationName = "inserirVendaAvulsaNotaFiscalSaida")
    public String inserirVendaAvulsaNotaFiscalSaida(@WebParam(name = "NotaFiscal") final VendaAvulsaNotaFiscalSaidaModel NotaFiscal) {

        return new PrincipalBusiness().inserirVendaAvulsaNotaFiscalSaida(NotaFiscal);

    }

    @WebMethod(operationName = "inserirAssinaturaNotaFiscalSaida")
    public String inserirAssinaturaNotaFiscalSaida(@WebParam(name = "NotaFiscal") final AssinaturaNotaFiscalSaidaModel NotaFiscal) {

        return new PrincipalBusiness().inserirAssinaturaNotaFiscalSaida(NotaFiscal);

    }

    @WebMethod(operationName = "inserirFotografiaNotaFiscalSaida")
    public String inserirFotografiaNotaFiscalSaida(@WebParam(name = "NotaFiscal") final FotografiaNotaFiscalSaidaModel NotaFiscal) {

        return new PrincipalBusiness().inserirFotografiaNotaFiscalSaida(NotaFiscal);

    }

    @WebMethod(operationName = "inserirAtolNotaFiscalSaida")
    public String inserirAtolNotaFiscalSaida(@WebParam(name = "NotaFiscal") final AtolNotaFiscalSaidaModel NotaFiscal) {

        return new PrincipalBusiness().inserirAtolNotaFiscalSaida(NotaFiscal);

    }

    @WebMethod(operationName = "inserirSvgNotaFiscalSaida")
    public String inserirSvgNotaFiscalSaida(@WebParam(name = "NotaFiscal") final SvgNotaFiscalSaidaModel NotaFiscal) {

        return new PrincipalBusiness().inserirSvgNotaFiscalSaida(NotaFiscal);

    }
    
    @WebMethod(operationName = "inserirRadioNotaFiscalSaida")
    public String inserirRadioNotaFiscalSaida(@WebParam(name = "NotaFiscal1") final RadioNotaFiscalSaidaModel NotaFiscal) {

        return new PrincipalBusiness().inserirRadioNotaFiscalSaida(NotaFiscal);

    }       

    @WebMethod(operationName = "pesquisarNotaFiscalSaidaInterface")
    public List<NotaFiscalSaidaABModel> pesquisarNotaFiscalSaidaInterface(@WebParam(name = "nota") NotaFiscalSaidaABModel model) {

        try {

            return new PrincipalBusiness().pesquisarNotaFiscalSaidaInterface(model);

        } catch (TSApplicationException e) {

            e.printStackTrace();

            retorno = e.getMessage();

        }

        return null;



    }

    @WebMethod(operationName = "pesquisarHistoricoNotaFiscalSaidaInterface")
    public List<NotaFiscalSaidaABModel> pesquisarHistoricoNotaFiscalSaidaInterface(@WebParam(name = "historicoNota") NotaFiscalSaidaABModel model) {

        try {

            return new PrincipalBusiness().pesquisarHistoricoNotaFiscalSaidaInterface(model);

        } catch (TSApplicationException e) {

            e.printStackTrace();

            retorno = e.getMessage();

        }

        return null;

    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "metodo1")
    @Oneway
    public void metodo1(@WebParam(name = "parameter") AssinaturaNotaFiscalSaidaLinhaModel parameter, @WebParam(name = "parameter1") AtolNotaFiscalSaidaLinhaModel parameter1, @WebParam(name = "parameter2") CFOPModel parameter2, @WebParam(name = "parameter3") CSTModel parameter3, @WebParam(name = "parameter4") EasyclassNotaFiscalSaidaLinhaModel parameter4, @WebParam(name = "parameter5") FotografiaNotaFiscalSaidaLinhaModel parameter5, @WebParam(name = "parameter6") SvgNotaFiscalSaidaLinhaModel parameter6, @WebParam(name = "parameter7") VendaAvulsaNotaFiscalSaidaLinhaModel parameter7, @WebParam(name = "parameter8") HistoricoAssinaturaNotaFiscalSaidaModel parameter8, @WebParam(name = "parameter9") HistoricoVendaAvulsaNotaFiscalSaidaModel parameter9, @WebParam(name = "parameter10") HistoricoEasyclassNotaFiscalSaidaModel parameter10, @WebParam(name = "parameter11") HistoricoAtolNotaFiscalSaidaModel parameter11, @WebParam(name = "parameter12") HistoricoFotografiaNotaFiscalSaidaModel parameter12, @WebParam(name = "parameter13") HistoricoSvgNotaFiscalSaidaModel parameter13,@WebParam(name = "parameter14") CobrancaNotaFiscalSaidaLinhaModel parameter14, @WebParam(name = "parameter15") ClassificadosContratoNotaFiscalSaidaModel parameter15,@WebParam(name = "parameter16") ClassificadosContratoNotaFiscalSaidaLinhaModel parameter16,@WebParam(name = "parameter17") ClassificadosExecucaoNotaFiscalSaidaModel parameter17,@WebParam(name = "parameter18") ClassificadosExecucaoNotaFiscalSaidaLinhaModel parameter18,@WebParam(name = "parameter19") RadioNotaFiscalSaidaLinhaModel parameter19) {
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "pesquisarTotalmenteAberta")
    public List<br.com.atarde.wsservicosap.model.NotaFiscalSaidaABModel> pesquisarTotalmenteAberta(@WebParam(name = "Nota") NotaFiscalSaidaABModel model) {

        try {

            return new NotaFiscalSaidaBusiness().pesquisarTotalmenteAberta(model);

        } catch (TSApplicationException e) {

            e.printStackTrace();

            retorno = e.getMessage();

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
}
