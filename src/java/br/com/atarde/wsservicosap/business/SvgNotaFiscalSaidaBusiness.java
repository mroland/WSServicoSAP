/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.SvgNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.SvgNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.SvgNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mroland
 */
public class SvgNotaFiscalSaidaBusiness extends NotaFiscalSaidaBusiness {

    private StringBuilder info;

    private SvgNotaFiscalSaidaModel nota;

    public SvgNotaFiscalSaidaBusiness() {
    }

    public SvgNotaFiscalSaidaBusiness(SvgNotaFiscalSaidaModel model) {

        this.nota = model;

    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();

        SvgNotaFiscalSaidaLinhaModel linha;

        if (TSUtil.isEmpty(this.nota)) {

            return Constantes.NOTAFISCAL;

        } else {

            retorno.append(this.validarGlobal(this.nota));

            if ("".equals(retorno.toString())) {

                if (this.nota.getOrigemModel().getId() != 6) {

                    retorno.append(Constantes.OBJETO_ORIGEM_SVG + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getNumeroNF()) || (this.nota.getNumeroNF() == 0)) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_NUMERONF + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getSerie()) || (this.nota.getSerie().equals(""))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_SERIE + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getModelo()) || (this.nota.getModelo().equals(""))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_MODELO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (!TSUtil.isEmpty(this.nota.getNotaFiscalSaidaLinhaModelList())) {

                    for (NotaFiscalSaidaLinhaABModel item : this.nota.getNotaFiscalSaidaLinhaModelList()) {

                        linha = (SvgNotaFiscalSaidaLinhaModel) item;

                        if (TSUtil.isEmpty(linha.getValorUnitario()) || (linha.getValorUnitario().equals(BigDecimal.ZERO))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_VALOR_UNITARIO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }


                    }


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

        new SvgNotaFiscalSaidaDAO().inserir(this.nota);

        retorno = null;

        return retorno;

    }

    public List<SvgNotaFiscalSaidaModel> pesquisar(SvgNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new SvgNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }



    }

    private Boolean validarPesquisar(SvgNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.SVGNOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 6) {

                        this.info.append(Constantes.OBJETO_ORIGEM_SVG + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
