package br.com.atarde.wsservicosap.dao;

import java.util.List;

import br.com.atarde.wsservicosap.model.EmpresaModel;
import br.com.atarde.wsservicosap.model.FilialModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class FilialDAO {

    @SuppressWarnings("unchecked")
    public List<FilialModel> pesquisar(EmpresaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getJndi());

        broker.setSQL("SELECT OBPL.\"BPLId\" id, OBPL.\"BPLName\" descricao, OBPL.\"MainBPL\" as flag_principal FROM " + model.getDbInstancia() + ".OBPL WHERE OBPL.\"Disabled\" = 'N'");

        return broker.getCollectionBean(FilialModel.class, "id", "descricao", "flagPrincipal");

    }

    @SuppressWarnings("unchecked")
    public FilialModel obter(FilialModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresa().getJndi());

        broker.setSQL("SELECT OBPL.\"BPLId\" id, OBPL.\"BPLName\" descricao, OBPL.\"MainBPL\" as flag_principal, CASE OBPL.\"Disabled\" WHEN 'N' THEN TRUE ELSE FALSE END FROM " + model.getEmpresa().getDbInstancia() + ".OBPL WHERE OBPL.\"BPLId\" = ? ");

        return (FilialModel) broker.getObjectBean(FilialModel.class, "id", "descricao", "flagPrincipal", "flagAtivo");

    }

    @SuppressWarnings("unchecked")
    public FilialModel obterInterface(FilialModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(Constantes.JNDI_SABWEB);

        broker.setSQL("SELECT ID, DESCRICAO, ID_EXTERNO FROM FILIAL WHERE EMPRESA_ID = ? ", model.getEmpresa().getId());

        return (FilialModel) broker.getObjectBean(FilialModel.class, "id", "descricao", "idExterno");

    }

}
