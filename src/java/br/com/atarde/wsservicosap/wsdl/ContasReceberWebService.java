/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.wsdl;

import br.com.atarde.wsservicosap.business.ContasReceberBusiness;
import br.com.atarde.wsservicosap.business.ParcelaNotaFiscalSaidaBusiness;
import br.com.atarde.wsservicosap.business.PrincipalBusiness;
import br.com.atarde.wsservicosap.model.ContaContabilModel;
import br.com.atarde.wsservicosap.model.ContasReceberModel;
import br.com.atarde.wsservicosap.model.FormaPagamentoModel;
import br.com.atarde.wsservicosap.model.ModalidadePagamentoBoletoModel;
import br.com.atarde.wsservicosap.model.ModalidadePagamentoModel;
import br.com.atarde.wsservicosap.model.ModalidadePagamentoTransferenciaModel;
import br.com.atarde.wsservicosap.model.ParcelaNotaFiscalSaidaModel;
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
public class ContasReceberWebService {

    private String retorno;

    @WebMethod(operationName = "inserirBoleto")
    public String inserirBoleto(@WebParam(name = "contasReceber") final ContasReceberModel contasReceber) {

        return new PrincipalBusiness().inserirBoleto(contasReceber);

    }

    @WebMethod(operationName = "inserirDebitoConta")
    public String inserirDebitoConta(@WebParam(name = "contasReceber") final ContasReceberModel contasReceber) {

        return new PrincipalBusiness().inserirDebitoConta(contasReceber);

    }

    @WebMethod(operationName = "inserirTransferencia")
    public String inserirTransferencia(@WebParam(name = "contasReceber") final ContasReceberModel contasReceber) {

        return new PrincipalBusiness().inserirTransferencia(contasReceber);

    }

    @WebMethod(operationName = "pesquisarParcelaAberta")
    public List<ParcelaNotaFiscalSaidaModel> pesquisarParcelaAberta(@WebParam(name = "parcelaNotaFiscal") final ParcelaNotaFiscalSaidaModel parcelaNotaFiscal) {

        try {

            this.retorno = null;

            return new ParcelaNotaFiscalSaidaBusiness().pesquisarParcelaAberta(parcelaNotaFiscal);

        } catch (TSApplicationException e) {

            e.printStackTrace();

            retorno = e.getMessage();

        }

        return null;

    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "pesquisarParcelaPaga")
    public List<ParcelaNotaFiscalSaidaModel> pesquisarParcelaPaga(@WebParam(name = "parcela") ParcelaNotaFiscalSaidaModel model) {

        try {

            return new PrincipalBusiness().pesquisarParcelaPaga(model);

        } catch (TSApplicationException ex) {

            ex.printStackTrace();

            retorno = ex.getMessage();
        }

        return null;

    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "metodo2")
    @Oneway
    public void metodo2(@WebParam(name = "parameter3") ContaContabilModel parameter3) {
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "metodo3")
    @Oneway
    public void metodo3(@WebParam(name = "t1") ModalidadePagamentoModel t1, @WebParam(name = "t2") ModalidadePagamentoBoletoModel t2, @WebParam(name = "t3") ModalidadePagamentoTransferenciaModel t3, @WebParam(name = "t4") FormaPagamentoModel t4, @WebParam(name = "t5") ContaContabilModel t5) {
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
    @WebMethod(operationName = "pesquisarPorNotaFiscalSaidaIdExterno")
    public List<ContasReceberModel> pesquisarPorNotaFiscalSaidaIdExterno(@WebParam(name = "contasReceberModel") ContasReceberModel model) {

        List<ContasReceberModel> list;

        try {

            list = new ContasReceberBusiness().pesquisarPorNotaFiscalSaidaIdExterno(model);

            retorno = null;

            return list;

        } catch (TSApplicationException e) {

            retorno = e.getMessage();

        }

        return null;


    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "cancelar")
    public String cancelar(@WebParam(name = "contasReceber") ContasReceberModel model) {

        return new ContasReceberBusiness().inserirCancelamento(model);

    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "obterPorBoletoNossoNumero")
    public ContasReceberModel obterPorBoletoNossoNumero(@WebParam(name = "contasReceberModel") ContasReceberModel model) {

        //ContasReceberModel contasReceberModel;

        //try {

            throw new UnsupportedOperationException("Not yet implemented");

            //contasReceberModel = new ContasReceberBusiness().obterPorBoletoNossoNumero(model);

            //retorno = null;

            //return contasReceberModel;

        //} catch (TSApplicationException e) {

        //    e.printStackTrace();

        //    retorno = e.getMessage();

        //}

        //return null;
    }
}
