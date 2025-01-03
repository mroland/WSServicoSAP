/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.SaidaMercadoriaDAO;
import br.com.atarde.wsservicosap.model.EntradaMercadoriaModel;
import br.com.atarde.wsservicosap.model.SaidaMercadoriaLinhaModel;
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
public class SaidaMercadoriaBusiness extends DocumentoABBusiness {

    private SaidaMercadoriaModel saidaMercadoriaModel;

    public SaidaMercadoriaBusiness() {
    }

    public SaidaMercadoriaBusiness(SaidaMercadoriaModel model) {
        super(model);
    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();
        
        this.saidaMercadoriaModel = (SaidaMercadoriaModel) super.getDocumento();

        if (TSUtil.isEmpty(this.saidaMercadoriaModel)) {

            return Constantes.SAIDAMERCADORIA;

        } else {

            retorno.append(super.validarGlobal(this.saidaMercadoriaModel));

            if (TSUtil.isEmpty(new SaidaMercadoriaDAO().obter(this.saidaMercadoriaModel))) {
                
                
            } else {

                if (TSUtil.isEmpty(this.saidaMercadoriaModel.getSaidaMercadoriaLinhaModelList()) || (this.saidaMercadoriaModel.getSaidaMercadoriaLinhaModelList().size() == 0)) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_SAIDAMERCADORIA_LINHA + Constantes.CAMPO_OBRIGATORIO + "\n");

                } else {

                    for (SaidaMercadoriaLinhaModel item : this.saidaMercadoriaModel.getSaidaMercadoriaLinhaModelList()) {

                        retorno.append(this.validarLinha(item));

                    }

                }


            }


            return retorno.toString();


        }

    }

    @Override
    public String inserir() throws TSApplicationException {

        String retorno;

        this.saidaMercadoriaModel.setStatusModel(new StatusModel(0L));

        this.saidaMercadoriaModel.setDataExportacao(new Date(System.currentTimeMillis()));

        new SaidaMercadoriaDAO().inserir(this.saidaMercadoriaModel);

        retorno = null;

        return retorno;
    }

    private String validarLinha(SaidaMercadoriaLinhaModel model) {

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

        EntradaMercadoriaModel entradaMercadoriaModel;

        this.saidaMercadoriaModel.setStatusModel(new StatusModel(0L));

        this.saidaMercadoriaModel.setDataExportacao(new Date(System.currentTimeMillis()));

        entradaMercadoriaModel = this.carregarEntradaMercadoria(this.saidaMercadoriaModel);

        new EntradaMercadoriaBusiness(entradaMercadoriaModel).insertEvent();

        retorno = null;

        return retorno;

    }

    @Override
    public String validarExcluir() {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(this.saidaMercadoriaModel)) {

            return Constantes.SAIDAMERCADORIA;

        } else {

            if (TSUtil.isEmpty(this.saidaMercadoriaModel.getIdExterno())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_ID_EXTERNO + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {
            }

            return retorno.toString();

        }

    }

    private EntradaMercadoriaModel carregarEntradaMercadoria(SaidaMercadoriaModel model) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
