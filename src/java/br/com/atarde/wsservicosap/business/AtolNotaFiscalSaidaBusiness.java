/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.AtolNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.AtolNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.AtolNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.CFOPModel;
import br.com.atarde.wsservicosap.model.CSTModel;
import br.com.atarde.wsservicosap.model.CategoriaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
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
public class AtolNotaFiscalSaidaBusiness extends NotaFiscalSaidaBusiness {

    private StringBuilder info;
    private AtolNotaFiscalSaidaModel nota;

    public AtolNotaFiscalSaidaBusiness() {
    }

    public AtolNotaFiscalSaidaBusiness(AtolNotaFiscalSaidaModel model) {
        super(model);
    }

    @Override
    public String validar() {

        AtolNotaFiscalSaidaLinhaModel linha;

        StringBuilder retorno = new StringBuilder();

        this.nota = (AtolNotaFiscalSaidaModel) super.getDocumento();

        if (TSUtil.isEmpty(this.nota)) {

            return Constantes.NOTAFISCAL;

        } else {

            retorno.append(this.validarGlobal(this.nota));
            /*
            if ("".equals(retorno.toString())) {

                if (TSUtil.isEmpty(this.nota.getClienteCobrancaModel().getEmail()) || (!TSUtil.isEmailValid(this.nota.getClienteCobrancaModel().getEmail()))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_EMAIL + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (this.nota.getOrigemModel().getId() != 5) {

                    retorno.append(Constantes.OBJETO_ORIGEM_ATARDEONLINE + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getuContrato())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_CONTRATO + Constantes.CAMPO_OBRIGATORIO + "\n");
                }

                if (TSUtil.isEmpty(this.nota.getuMesReferencia())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_MES_REFERENCIA + Constantes.CAMPO_OBRIGATORIO + "\n");
                }

                if (TSUtil.isEmpty(this.nota.getuPontoReferencia())) {

                    retorno.append(Constantes.PONTO_REFERENCIA + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (!TSUtil.isEmpty(this.nota.getNotaFiscalSaidaLinhaModelList())) {

                    for (NotaFiscalSaidaLinhaABModel item : this.nota.getNotaFiscalSaidaLinhaModelList()) {

                        linha = (AtolNotaFiscalSaidaLinhaModel) item;

                        if (!TSUtil.isEmpty(linha.getCfopModel())) {

                            if ((!TSUtil.isEmpty(linha.getCfopModel().getCodigo())) && (TSUtil.isEmpty(new CFOPBusiness(this.getJndi()).obterPeloCodigo(linha.getCfopModel())))) {

                                retorno.append(Constantes.CFOP_INEXISTENTE + "\n");

                            }

                        } else {

                            linha.setCfopModel(new CFOPModel());

                        }

                        if (!TSUtil.isEmpty(linha.getCstICMSModel())) {

                            linha.getCstICMSModel().setCategoriaModel(new CategoriaBusiness(this.getJndi()).obterPeloCodigo(new CategoriaModel("codigo", "ICMS")));

                            if ((!TSUtil.isEmpty(linha.getCstICMSModel().getCodigo())) && (TSUtil.isEmpty(new CSTBusiness(this.getJndi()).obterPeloCodigo(linha.getCstICMSModel())))) {

                                retorno.append(Constantes.CSTICMS_INEXISTENTE + "\n");

                            }

                        } else {

                            linha.setCstICMSModel(new CSTModel());

                        }

                        if (!TSUtil.isEmpty(linha.getCstCOFINSModel())) {

                            linha.getCstCOFINSModel().setCategoriaModel(new CategoriaBusiness(this.getJndi()).obterPeloCodigo(new CategoriaModel("codigo", "COFINS")));

                            if ((!TSUtil.isEmpty(linha.getCstCOFINSModel().getCodigo())) && (TSUtil.isEmpty(new CSTBusiness(this.getJndi()).obterPeloCodigo(linha.getCstCOFINSModel())))) {

                                retorno.append(Constantes.CSTCOFINS_INEXISTENTE + "\n");

                            }

                        } else {

                            linha.setCstCOFINSModel(new CSTModel());

                        }

                        if (!TSUtil.isEmpty(linha.getCstIPIModel())) {

                            linha.getCstIPIModel().setCategoriaModel(new CategoriaBusiness(this.getJndi()).obterPeloCodigo(new CategoriaModel("codigo", "IPI")));

                            if ((!TSUtil.isEmpty(linha.getCstIPIModel().getCodigo())) && (TSUtil.isEmpty(new CSTBusiness(this.getJndi()).obterPeloCodigo(linha.getCstIPIModel())))) {

                                retorno.append(Constantes.CSTIPI_INEXISTENTE + "\n");

                            }

                        } else {

                            linha.setCstIPIModel(new CSTModel());

                        }

                        if (!TSUtil.isEmpty(linha.getCstPISModel())) {

                            linha.getCstPISModel().setCategoriaModel(new CategoriaBusiness(this.getJndi()).obterPeloCodigo(new CategoriaModel("codigo", "PIS")));

                            if ((!TSUtil.isEmpty(linha.getCstPISModel().getCodigo())) && (TSUtil.isEmpty(new CSTBusiness(this.getJndi()).obterPeloCodigo(linha.getCstPISModel())))) {

                                retorno.append(Constantes.CSTPIS_INEXISTENTE + "\n");

                            }

                        } else {

                            linha.setCstPISModel(new CSTModel());

                        }


                    }


                }

            }
             */

            return retorno.toString();

        }

    }

    @Override
    public String inserir() throws TSApplicationException {

        String retorno;

        this.nota.setStatusModel(new StatusModel(0L));

        this.nota.setDataExportacao(new Date(System.currentTimeMillis()));

        new AtolNotaFiscalSaidaDAO().inserir(this.nota);

        retorno = null;

        return retorno;

    }

    public List<AtolNotaFiscalSaidaModel> pesquisar(AtolNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new AtolNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

    }

    private Boolean validarPesquisar(AtolNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.ATOLNOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 5) {

                        this.info.append(Constantes.OBJETO_ORIGEM_ATARDEONLINE + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
