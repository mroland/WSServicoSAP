package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.ItemModel;
import java.util.List;

import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class ItemDAO {

    public ItemModel obter(ItemModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT OITM.\"ItemCode\", CASE WHEN OITM.\"InvntItem\" = 'Y' THEN TRUE ELSE FALSE END, CASE WHEN OITM.\"SellItem\" = 'Y' THEN TRUE ELSE FALSE END, CASE WHEN OITM.\"PrchseItem\" = 'Y' THEN TRUE ELSE FALSE END FROM " + model.getEmpresaModel().getDbInstancia() + ".OITM WHERE OITM.\"ItemCode\" = ?", model.getId());

        return (ItemModel) broker.getObjectBean(ItemModel.class, "id", "flagControleEstoque", "flgItemVenda", "flagItemCompra");

    }

    @SuppressWarnings("unchecked")
    public List<ItemModel> pesquisar(ItemModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf(model.getEmpresaModel().getJndi());

        broker.setSQL("SELECT ITEM.\"ItemCode\" AS ID_EXTERNO, ITEM.\"ItemName\" AS DESCRICAO, PRECO.\"Price\" AS VALOR_UNITARIO , LINHA.\"OnHand\" AS QTD_DISPONIVEL FROM " + model.getEmpresaModel().getDbInstancia() + ".OITM ITEM , " + model.getEmpresaModel().getDbInstancia() + ".ITM1 PRECO, " + model.getEmpresaModel().getDbInstancia() + ".OITW AS LINHA WHERE ITEM.\"ItemCode\" = PRECO.\"ItemCode\" AND LINHA.\"ItemCode\" = ITEM.\"ItemCode\" AND PRECO.\"PriceList\" = 3 AND LINHA.\"OnHand\" > 0 AND LINHA.\"WhsCode\" = ? ", model.getEstoqueModel().getId());

        return broker.getCollectionBean(ItemModel.class, "id", "descricao", "preco", "estoqueModel.quantidadeDisponivel");
    }

}
