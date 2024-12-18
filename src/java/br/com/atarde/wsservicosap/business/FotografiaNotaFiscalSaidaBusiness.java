/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.FotografiaNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.CSTModel;
import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.atarde.wsservicosap.model.FilialModel;
import br.com.atarde.wsservicosap.model.FotografiaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.FotografiaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.model.UtilizacaoModel;
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
public class FotografiaNotaFiscalSaidaBusiness extends NotaFiscalSaidaBusiness {

    private StringBuilder info;
    private FotografiaNotaFiscalSaidaModel nota;

    public FotografiaNotaFiscalSaidaBusiness() {
    }

    public FotografiaNotaFiscalSaidaBusiness(FotografiaNotaFiscalSaidaModel model) {

        super(model);

    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();

        FotografiaNotaFiscalSaidaLinhaModel linha;

        this.nota = (FotografiaNotaFiscalSaidaModel) super.getDocumento();

        if (TSUtil.isEmpty(this.nota)) {

            return Constantes.NOTAFISCAL;

        } else {

            retorno.append(this.validarGlobal(this.nota));

            if ("".equals(retorno.toString())) {

                if (!TSUtil.isEmpty(new FotografiaNotaFiscalSaidaDAO().obterIdExternoInterface(nota))) {

                    retorno.append(Constantes.NOTAFISCALEXPORTADA + "\n");

                    return retorno.toString();

                }

                this.nota.setFilialModel(new FilialModel());

                this.nota.getFilialModel().setId(1);

                if ((this.nota.getClienteCobrancaModel().getIdentificadorFiscalModel().getTipoIdentificador() == 0) && (TSUtil.isEmpty(this.nota.getClienteCobrancaModel().getIdentificadorFiscalModel().getInscricaoEstadual()))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_INSCRICAO_ESTADUAL + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (this.nota.getOrigemModel().getId() != 4) {

                    retorno.append(Constantes.OBJETO_ORIGEM_FOTOGRAFIA + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getObservacao())) {

                    retorno.append(Constantes.OBJETO_OBSERVACAO_FOTOGRAFIA + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getuObservacao())) {

                    retorno.append(Constantes.OBJETO_UOBSERVACAO_FOTOGRAFIA + "\n");

                }

                if (!TSUtil.isEmpty(this.nota.getNotaFiscalSaidaLinhaModelList())) {

                    for (NotaFiscalSaidaLinhaABModel item : this.nota.getNotaFiscalSaidaLinhaModelList()) {

                        linha = (FotografiaNotaFiscalSaidaLinhaModel) item;

                        linha.setCodigoImpostoModel(new CodigoImpostoModel());

                        //linha.getCodigoImpostoModel().setId("5101-006");
                        linha.getCodigoImpostoModel().setId("5102-001"); //teste apenas

                        linha.setUtilizacaoModel(new UtilizacaoModel());

                        //linha.getUtilizacaoModel().setId(16L); colocavam fixo
                        linha.getUtilizacaoModel().setId(10L); //teste apenas

                        linha.setCstCOFINSModel(new CSTModel());

                        linha.setCstICMSModel(new CSTModel());

                        linha.setCstIPIModel(new CSTModel());

                        linha.setCstPISModel(new CSTModel());

                        if (TSUtil.isEmpty(linha.getValorUnitario()) || (linha.getValorUnitario().equals(BigDecimal.ZERO))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_VALOR_UNITARIO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }
                        /*
                         if (TSUtil.isEmpty(linha.getCfopModel())) {

                         retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CFOPCODE + Constantes.CAMPO_OBRIGATORIO + "\n");

                         } else {

                         if (TSUtil.isEmpty(new CFOPBusiness(this.getJndi()).obterPeloCodigo(linha.getCfopModel()))) {

                         retorno.append(Constantes.CFOP_INEXISTENTE + "\n");

                         }

                         }

                         if (TSUtil.isEmpty(linha.getCstICMSModel())) {

                         retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CSTICMS + Constantes.CAMPO_OBRIGATORIO + "\n");

                         } else {

                         linha.getCstICMSModel().setCategoriaModel(new CategoriaBusiness(this.getJndi()).obterPeloCodigo(new CategoriaModel("codigo", "ICMS")));

                         if (TSUtil.isEmpty(new CSTBusiness(this.getJndi()).obterPeloCodigo(linha.getCstICMSModel()))) {

                         retorno.append(Constantes.CSTICMS_INEXISTENTE + "\n");

                         }

                         }

                         if (TSUtil.isEmpty(linha.getCstCOFINSModel())) {

                         retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CSTCOFINS + Constantes.CAMPO_OBRIGATORIO + "\n");

                         } else {

                         linha.getCstCOFINSModel().setCategoriaModel(new CategoriaBusiness(this.getJndi()).obterPeloCodigo(new CategoriaModel("codigo", "COFINS")));

                         if (TSUtil.isEmpty(new CSTBusiness(this.getJndi()).obterPeloCodigo(linha.getCstCOFINSModel()))) {

                         retorno.append(Constantes.CSTCOFINS_INEXISTENTE + "\n");

                         }

                         }

                         if (TSUtil.isEmpty(linha.getCstIPIModel())) {

                         retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CSTIPI + Constantes.CAMPO_OBRIGATORIO + "\n");

                         } else {

                         linha.getCstIPIModel().setCategoriaModel(new CategoriaBusiness(this.getJndi()).obterPeloCodigo(new CategoriaModel("codigo", "IPI")));
                         if (TSUtil.isEmpty(new CSTBusiness(this.getJndi()).obterPeloCodigo(linha.getCstIPIModel()))) {

                         retorno.append(Constantes.CSTIPI_INEXISTENTE + "\n");

                         }

                         }

                         if (TSUtil.isEmpty(linha.getCstPISModel())) {

                         retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CSTPIS + Constantes.CAMPO_OBRIGATORIO + "\n");

                         } else {

                         linha.getCstPISModel().setCategoriaModel(new CategoriaBusiness(this.getJndi()).obterPeloCodigo(new CategoriaModel("codigo", "PIS")));
                         if (TSUtil.isEmpty(new CSTBusiness(this.getJndi()).obterPeloCodigo(linha.getCstPISModel()))) {

                         retorno.append(Constantes.CSTPIS_INEXISTENTE + "\n");

                         }

                         }
                         */

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

        new FotografiaNotaFiscalSaidaDAO().inserirInterface(this.nota);

        retorno = null;

        return retorno;

    }

    public List<FotografiaNotaFiscalSaidaModel> pesquisar(FotografiaNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new FotografiaNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

    }

    private Boolean validarPesquisar(FotografiaNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.FOTOGRAFIANOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 4) {

                        this.info.append(Constantes.OBJETO_ORIGEM_FOTOGRAFIA + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }
}
