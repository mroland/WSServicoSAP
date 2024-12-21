package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.NotaFiscalSaidaABModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import java.util.List;

public class NotaFiscalSaidaDAO {

    public NotaFiscalSaidaModel obterIdExterno(NotaFiscalSaidaABModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OINV.\"DocEntry\" FROM " + model.getEmpresaModel().getDbInstancia() + ".OINV WHERE OINV.\"NumAtCard\" = ? AND OINV.\"U_ATRD_Origem\"= ? AND NOT EXISTS (SELECT 1 FROM " + model.getEmpresaModel().getDbInstancia() + ".ORIN, " + model.getEmpresaModel().getDbInstancia() + ".RIN1 WHERE ORIN.\"DocEntry\" = RIN1.\"DocEntry\" AND ORIN.\"SeqCode\" IN(1,27,28,29,31,32,33,35) AND RIN1.\"BaseEntry\" = OINV.\"DocEntry\") AND NOT EXISTS (SELECT 1 FROM " + model.getEmpresaModel().getDbInstancia() + ".OINV C, " + model.getEmpresaModel().getDbInstancia() + ".INV1 L WHERE C.\"DocEntry\" = L.\"DocEntry\" AND L.\"BaseEntry\" = OINV.\"DocEntry\" AND C.CANCELED = 'Y') AND OINV.CANCELED ='N' ", model.getIdExterno(), model.getOrigemModel().getId());

        return (NotaFiscalSaidaModel) broker.getObjectBean(NotaFiscalSaidaModel.class, "id");

    }

    public List<NotaFiscalSaidaABModel> pesquisarTotalmenteAberta(NotaFiscalSaidaABModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
