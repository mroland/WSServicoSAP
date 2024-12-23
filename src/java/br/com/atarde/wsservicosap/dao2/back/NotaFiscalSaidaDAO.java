/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.AssinaturaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.AtolNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.EasyclassNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.FotografiaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaABModel;
import br.com.atarde.wsservicosap.model.SvgNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaNotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import java.util.List;

/**
 *
 * @author mroland
 */
public class NotaFiscalSaidaDAO {

    public NotaFiscalSaidaDAO() {
    }

    public NotaFiscalSaidaABModel obter(NotaFiscalSaidaABModel model, String jndi){

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(jndi);

        broker.setPropertySQL("notafiscalsaidadao.obter", model.getIdExterno(), model.getOrigemModel().getId(),
                                                          model.getIdExterno(), model.getOrigemModel().getId(),
                                                          model.getIdExterno(), model.getOrigemModel().getId(),
                                                          model.getIdExterno(), model.getOrigemModel().getId(),
                                                          model.getIdExterno(), model.getOrigemModel().getId(),
                                                          model.getIdExterno(), model.getOrigemModel().getId(),
                                                          model.getIdExterno(), model.getOrigemModel().getId(),                                                          
                                                          model.getIdExterno(), model.getOrigemModel().getId(),
                                                          model.getIdExterno(), model.getOrigemModel().getId(),
                                                          model.getIdExterno(), model.getOrigemModel().getId(),
                                                          model.getIdExterno(), model.getOrigemModel().getId());

        return (NotaFiscalSaidaABModel) broker.getObjectBean(NotaFiscalSaidaABModel.class, "id");

    }

    @SuppressWarnings("unchecked")
    public List<NotaFiscalSaidaABModel> pesquisarTotalmenteAberta(NotaFiscalSaidaABModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("notafiscalsaidadao.pesquisarNotaFiscalSaidaTotalmenteAberta",model.getOrigemModel().getId(), model.getIdExterno());

        return this.retorno(model, broker);
        
    }

    @SuppressWarnings("unchecked")
    private List<NotaFiscalSaidaABModel> retorno(NotaFiscalSaidaABModel model, TSDataBaseBrokerIf broker) {

        if (model instanceof EasyclassNotaFiscalSaidaModel){

            return broker.getCollectionBean(EasyclassNotaFiscalSaidaModel.class, "id");

        }

        if (model instanceof FotografiaNotaFiscalSaidaModel){

            return broker.getCollectionBean(FotografiaNotaFiscalSaidaModel.class, "id");

        }
        
        if (model instanceof VendaAvulsaNotaFiscalSaidaModel){

            return broker.getCollectionBean(VendaAvulsaNotaFiscalSaidaModel.class, "id");

        }  
        
        if (model instanceof AssinaturaNotaFiscalSaidaModel){

            return broker.getCollectionBean(AssinaturaNotaFiscalSaidaModel.class, "id");

        }

        if (model instanceof SvgNotaFiscalSaidaModel){

            return broker.getCollectionBean(SvgNotaFiscalSaidaModel.class, "id");

        }

        if (model instanceof AtolNotaFiscalSaidaModel){

            return broker.getCollectionBean(AtolNotaFiscalSaidaModel.class, "id");

        }

        return null;

    }

}
