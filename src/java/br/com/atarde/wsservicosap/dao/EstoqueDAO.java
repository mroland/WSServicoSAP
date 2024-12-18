package br.com.atarde.wsservicosap.dao;

import java.util.List;

import br.com.atarde.wsservicosap.model.EstoqueModel;
import br.com.atarde.wsservicosap.util.Utilitarios;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.util.TSUtil;

public class EstoqueDAO {

    @SuppressWarnings("unchecked")
    public List<EstoqueModel> pesquisar(EstoqueModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT ESTOQUE.\"WhsCode\" AS ID, ESTOQUE.\"WhsName\" AS NOME FROM " + model.getEmpresaModel().getDbInstancia() + ".OWHS ESTOQUE WHERE EXISTS (SELECT 1 FROM " + model.getEmpresaModel().getDbInstancia() + ".OITM ITEM, " + model.getEmpresaModel().getDbInstancia() + ".OITW LINHA WHERE LINHA.\"ItemCode\" = ITEM.\"ItemCode\" AND ESTOQUE.\"WhsCode\" = LINHA.\"WhsCode\" AND LINHA.\"OnHand\" > 0 ");

        if (!TSUtil.isEmpty(model.getItemModel()) && !TSUtil.isEmpty(Utilitarios.tratarString(model.getItemModel().getId()))) {

            sql.append(" AND ITEM.\"ItemCode\" = ? )");

        } else {

            sql.append(" )");
        }

        broker.setSQL(sql.toString());

        if (!TSUtil.isEmpty(model.getItemModel()) && !TSUtil.isEmpty(Utilitarios.tratarString(model.getItemModel().getId()))) {

            broker.set(model.getItemModel().getId());

        }

        return broker.getCollectionBean(EstoqueModel.class, "id", "descricao");

    }

    public EstoqueModel obter2(EstoqueModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT ESTOQUE.\"WhsCode\" AS ID, ESTOQUE.\"WhsName\" AS NOME FROM " + model.getEmpresaModel().getDbInstancia() + ".OWHS ESTOQUE WHERE EXISTS (SELECT 1 FROM " + model.getEmpresaModel().getDbInstancia() + ".OITM ITEM, " + model.getEmpresaModel().getDbInstancia() + ".OITW LINHA WHERE LINHA.\"ItemCode\" = ITEM.\"ItemCode\" AND ESTOQUE.\"WhsCode\" = LINHA.\"WhsCode\" AND LINHA.\"OnHand\" > 0 ");

        if (!TSUtil.isEmpty(model.getItemModel()) && !TSUtil.isEmpty(Utilitarios.tratarString(model.getItemModel().getId()))) {

            sql.append(" AND ITEM.\"ItemCode\" = ? )");

        } else {

            sql.append(" )");
        }

        broker.setSQL(sql.toString());

        if (!TSUtil.isEmpty(model.getItemModel()) && !TSUtil.isEmpty(Utilitarios.tratarString(model.getItemModel().getId()))) {

            broker.set(model.getItemModel().getId());

        }

        return (EstoqueModel) broker.getObjectBean(EstoqueModel.class, "id", "descricao");

    }

    public EstoqueModel obter(EstoqueModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT ESTOQUE.\"WhsCode\" AS ID, ESTOQUE.\"WhsName\" AS NOME FROM " + model.getEmpresaModel().getDbInstancia() + ".OWHS ESTOQUE WHERE ESTOQUE.\"WhsCode\" = ?");

        broker.setSQL(sql.toString(), model.getId());

        return (EstoqueModel) broker.getObjectBean(EstoqueModel.class, "id", "descricao");

    }

}
