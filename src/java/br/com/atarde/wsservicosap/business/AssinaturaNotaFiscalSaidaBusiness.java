/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.AssinaturaNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.AssinaturaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.AssinaturaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.CFOPModel;
import br.com.atarde.wsservicosap.model.CSTModel;
import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.model.UtilizacaoModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mroland
 */
public class AssinaturaNotaFiscalSaidaBusiness extends NotaFiscalSaidaBusiness {

    private StringBuilder info;

    private AssinaturaNotaFiscalSaidaModel nota;

    public AssinaturaNotaFiscalSaidaBusiness() {

    }

    public AssinaturaNotaFiscalSaidaBusiness(AssinaturaNotaFiscalSaidaModel model) {
        super(model);
    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();

        this.nota = (AssinaturaNotaFiscalSaidaModel) super.getDocumento();

        AssinaturaNotaFiscalSaidaLinhaModel linha;

        if (TSUtil.isEmpty(this.nota)) {

            return Constantes.NOTAFISCAL;

        } else {

            retorno.append(this.validarGlobal(this.nota));

            if ("".equals(retorno.toString())) {

                if ((this.nota.getClienteCobrancaModel().getIdentificadorFiscalModel().getTipoIdentificador() == 0) && (TSUtil.isEmpty(this.nota.getClienteCobrancaModel().getIdentificadorFiscalModel().getInscricaoEstadual()))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_INSCRICAO_ESTADUAL + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (this.nota.getOrigemModel().getId() != 3) {

                    retorno.append(Constantes.OBJETO_ORIGEM_ASSINATURA + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getObservacao())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_OBSERVACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getuObservacao())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_U_OBSERVACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (!TSUtil.isEmpty(this.nota.getNotaFiscalSaidaLinhaModelList())) {

                    for (NotaFiscalSaidaLinhaABModel item : this.nota.getNotaFiscalSaidaLinhaModelList()) {

                        linha = (AssinaturaNotaFiscalSaidaLinhaModel) item;
                        
                        linha.setCodigoImpostoModel(new CodigoImpostoModel());
                        
                        linha.getCodigoImpostoModel().setId("5101-006");
                        
                        linha.setUtilizacaoModel(new UtilizacaoModel());
                        
                        linha.getUtilizacaoModel().setId(16L);
                        
                        linha.setCfopModel(new CFOPModel());
                        
                        linha.setCstCOFINSModel(new CSTModel());
                        
                        linha.setCstICMSModel(new CSTModel());
                        
                        linha.setCstIPIModel(new CSTModel());
                        
                        linha.setCstPISModel(new CSTModel());
                                               
/*
                        if (TSUtil.isEmpty(linha.getCodigoImpostoModel()) || (TSUtil.isEmpty(linha.getCodigoImpostoModel().getId())) || (linha.getCodigoImpostoModel().getId().equals(""))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CODIGO_IMPOSTO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        } else {

                            if (TSUtil.isEmpty(new CodigoImpostoBusiness(this.getJndi()).obter(linha.getCodigoImpostoModel()))) {

                                retorno.append(Constantes.CODIGO_IMPOSTO_INEXISTENTE + Constantes.CAMPO_OBRIGATORIO + "\n");

                            }

                        }

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

                        if (TSUtil.isEmpty(linha.getContaContabilModel()) || (TSUtil.isEmpty(new ContaContabilBusiness(this.getJndi()).obter(linha.getContaContabilModel())))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CONTACONTABIL + Constantes.CAMPO_OBRIGATORIO + "\n");

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

        new AssinaturaNotaFiscalSaidaDAO().inserir(this.nota);

        retorno = null;

        return retorno;

    }

    public List<AssinaturaNotaFiscalSaidaModel> pesquisar(AssinaturaNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new AssinaturaNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

    }

    private Boolean validarPesquisar(AssinaturaNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.ASSINATURANOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 3) {

                        this.info.append(Constantes.OBJETO_ORIGEM_ASSINATURA + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }

}
