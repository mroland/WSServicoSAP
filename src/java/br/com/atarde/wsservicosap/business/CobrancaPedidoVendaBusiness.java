/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.CobrancaNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.dao.CobrancaPedidoVendaDAO;
import br.com.atarde.wsservicosap.model.CobrancaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.DespesaAdicionalModel;
import br.com.atarde.wsservicosap.model.FilialModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mroland
 */
public class CobrancaPedidoVendaBusiness extends NotaFiscalSaidaBusiness {

    private StringBuilder info;
    private CobrancaNotaFiscalSaidaModel nota;

    public CobrancaPedidoVendaBusiness() {
    }

    public CobrancaPedidoVendaBusiness(CobrancaNotaFiscalSaidaModel model) {

        super(model);

    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();

        this.nota = (CobrancaNotaFiscalSaidaModel) super.getDocumento();

        if (TSUtil.isEmpty(this.nota)) {

            return Constantes.NOTAFISCAL;

        } else {

            retorno.append(this.validarGlobal(this.nota));

            if ("".equals(retorno.toString())) {

                if (!TSUtil.isEmpty(new CobrancaPedidoVendaDAO().obterIdExternoInterface(nota))) {

                    retorno.append(Constantes.NOTAFISCALEXPORTADA + "\n");

                    return retorno.toString();

                }

                this.nota.setFilialModel(new FilialModel());

                this.nota.getFilialModel().setId(1);

                if (TSUtil.isEmpty(this.nota.getDespesaAdicionalModelList()) || (this.nota.getDespesaAdicionalModelList().isEmpty())) {

                    retorno.append(Constantes.DESPESA_ADICIONAL_LIST + Constantes.CAMPO_OBRIGATORIO + "\n");

                } else {

                    for (DespesaAdicionalModel item : this.nota.getDespesaAdicionalModelList()) {

                        if (TSUtil.isEmpty(item.getCodigo())) {

                            retorno.append(Constantes.DESPESA_ADICIONAL_CODIGO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }

                        if (TSUtil.isEmpty(item.getValor())) {

                            retorno.append(Constantes.DESPESA_ADICIONAL_VALOR + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }

                    }

                }

                if (this.nota.getOrigemModel().getId() != 10) {

                    retorno.append(Constantes.OBJETO_ORIGEM_COBRANCA + "\n");

                }

            }

            return retorno.toString();

        }

    }

    @Override
    public String inserir() throws TSApplicationException {

        String retorno;

        this.nota.setStatusModel(new StatusModel(0L));

        this.nota.setDataExportacao(new Date(System.currentTimeMillis()));

        new CobrancaNotaFiscalSaidaDAO().inserirInterface(this.nota);

        retorno = null;

        return retorno;

    }

    public List<CobrancaNotaFiscalSaidaModel> pesquisar(CobrancaNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new CobrancaNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

    }

    private Boolean validarPesquisar(CobrancaNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.COBRANCANOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 10L) {

                        this.info.append(Constantes.OBJETO_ORIGEM_COBRANCA + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
