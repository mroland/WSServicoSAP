/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.EntradaMercadoriaDAO;
import br.com.atarde.wsservicosap.model.EntradaMercadoriaLinhaModel;
import br.com.atarde.wsservicosap.model.EntradaMercadoriaModel;
import br.com.atarde.wsservicosap.model.SaidaMercadoriaModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.Date;

/**
 *
 * @author mroland
 */
public class EntradaMercadoriaBusiness extends DocumentoABBusiness {

    private EntradaMercadoriaModel entradaMercadoriaModel;

    public EntradaMercadoriaBusiness() {
    }

    public EntradaMercadoriaBusiness(EntradaMercadoriaModel model) {

        super(model);

    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();

        this.entradaMercadoriaModel = (EntradaMercadoriaModel) super.getDocumento();

        if (TSUtil.isEmpty(this.entradaMercadoriaModel)) {

            return Constantes.SAIDAMERCADORIA;

        } else {

            retorno.append(super.validarGlobal(this.entradaMercadoriaModel));

            if (TSUtil.isEmpty(this.entradaMercadoriaModel.getEntradaMercadoriaLinhaModelList()) || (this.entradaMercadoriaModel.getEntradaMercadoriaLinhaModelList().size() == 0)) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_SAIDAMERCADORIA_LINHA + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {

                for (EntradaMercadoriaLinhaModel item : this.entradaMercadoriaModel.getEntradaMercadoriaLinhaModelList()) {

                    retorno.append(this.validarLinha(item));

                }

            }

            return retorno.toString();

        }

    }

    @Override
    public String inserir() throws TSApplicationException {

        String retorno;

        this.entradaMercadoriaModel.setStatusModel(new StatusModel(0L));

        this.entradaMercadoriaModel.setDataExportacao(new Date(System.currentTimeMillis()));

        new EntradaMercadoriaDAO().inserir(this.entradaMercadoriaModel);

        retorno = null;

        return retorno;
    }

    private String validarLinha(EntradaMercadoriaLinhaModel model) {

        StringBuilder retorno = new StringBuilder();

        /*
        if (TSUtil.isEmpty(model.getDimensao1Model()) || TSUtil.isEmpty(model.getDimensao1Model().getId()) || (model.getDimensao1Model().getId() == 0) || (TSUtil.isEmpty(new DimensaoBusiness(this.getJndi()).obter(model.getDimensao1Model())))) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_DIMENSAO + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            if (TSUtil.isEmpty(model.getDimensao1Model().getRegraDistribuicaoModel())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_REGRA_DISTRIBUICAO + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {

                model.getDimensao1Model().getRegraDistribuicaoModel().setDimensaoModel(model.getDimensao1Model());

                if (TSUtil.isEmpty(model.getDimensao1Model().getRegraDistribuicaoModel().getId()) || TSUtil.isEmpty(new RegraDistribuicaoBusiness(this.getJndi()).obter(model.getDimensao1Model().getRegraDistribuicaoModel()))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_REGRA_DISTRIBUICAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

            }

            if (TSUtil.isEmpty(model.getItemModel()) || TSUtil.isEmpty(model.getItemModel().getId()) || (TSUtil.isEmpty(new ItemBusiness(this.getJndi()).obter(model.getItemModel())))) {

                retorno.append(Constantes.ITEM_INEXISTENTE + Constantes.CAMPO_OBRIGATORIO + "\n");
            }

            if (TSUtil.isEmpty(model.getQuantidade()) || (model.getQuantidade() == 0D)) {

                retorno.append(Constantes.QUANTIDADE + Constantes.CAMPO_OBRIGATORIO + "\n");
            }

         
    }
         */
        return retorno.toString();

    }

    @Override
    public String excluir() throws TSApplicationException {

        String retorno;

        SaidaMercadoriaModel saidaMercadoriaModel;

        this.entradaMercadoriaModel.setStatusModel(new StatusModel(0L));

        this.entradaMercadoriaModel.setDataExportacao(new Date(System.currentTimeMillis()));

        saidaMercadoriaModel = this.carregarSaidaMercadoria(this.entradaMercadoriaModel);

        new SaidaMercadoriaBusiness(saidaMercadoriaModel).insertEvent();

        retorno = null;

        return retorno;

    }

    @Override
    public String validarExcluir() {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(this.entradaMercadoriaModel)) {

            return Constantes.SAIDAMERCADORIA;

        } else {

            if (TSUtil.isEmpty(this.entradaMercadoriaModel.getIdExterno())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_ID_EXTERNO + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {

            }

            return retorno.toString();

        }

    }

    private SaidaMercadoriaModel carregarSaidaMercadoria(EntradaMercadoriaModel model) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
