package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.CategoriaDAO;
import br.com.atarde.wsservicosap.dao.EasyclassNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.dao.RadioNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.CSTModel;
import br.com.atarde.wsservicosap.model.CategoriaModel;
import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.atarde.wsservicosap.model.EstoqueModel;
import br.com.atarde.wsservicosap.model.FilialModel;
import br.com.atarde.wsservicosap.model.RadioNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.RadioNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.model.UtilizacaoModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.Arrays;
import java.util.List;

public class RadioNotaFiscalSaidaBusiness extends NotaFiscalSaidaBusiness {
    
    private StringBuilder info;
    
    private RadioNotaFiscalSaidaModel nota;
    
    public RadioNotaFiscalSaidaBusiness() {
    }
    
    public RadioNotaFiscalSaidaBusiness(RadioNotaFiscalSaidaModel model) {
        
        super(model);
    }
    
    @Override
    public String validar() {
        
        StringBuilder retorno = new StringBuilder();
        
        RadioNotaFiscalSaidaLinhaModel linha;
        
        this.nota = (RadioNotaFiscalSaidaModel) super.getDocumento();
        
        if (TSUtil.isEmpty(this.nota)) {
            
            return Constantes.NOTAFISCAL;
            
        } else {

            //super.setOrigem();
            retorno.append(this.validarGlobal(this.nota));
            
            if ("".equals(retorno.toString())) {
                
                if (!TSUtil.isEmpty(new RadioNotaFiscalSaidaDAO().obterIdExternoInterface(nota))) {
                    
                    retorno.append(Constantes.NOTAFISCALEXPORTADA + "\n");
                    
                    return retorno.toString();
                    
                }
                
                this.nota.setFilialModel(new FilialModel());
                
                this.nota.getFilialModel().setId(2);
                
                if (!TSUtil.isEmpty(this.nota.getClienteModel())) {
                    
                    this.nota.getClienteModel().setEmpresaModel(this.nota.getEmpresaModel());
                    
                }
                
                retorno.append(this.validaCliente(this.nota.getClienteModel()));
                
                if (this.nota.getOrigemModel().getId() != 99) {
                    
                    retorno.append(Constantes.OBJETO_ORIGEM_RADIO + "\n");
                    
                }
                
                if (TSUtil.isEmpty(this.nota.getuComissaoAgencia())) {
                    
                    retorno.append(Constantes.OBJETO_OBRIGATORIO_COMISSAO_AGENCIA + Constantes.CAMPO_OBRIGATORIO + "\n");
                    
                }
                
                if (TSUtil.isEmpty(this.nota.getuDataContrato())) {
                    
                    retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_CONTRATO + Constantes.CAMPO_OBRIGATORIO + "\n");
                    
                }
                
                if (TSUtil.isEmpty(this.nota.getuPeriodoVeiculacao())) {
                    
                    retorno.append(Constantes.OBJETO_OBRIGATORIO_PERIODO_VEICULACAO + Constantes.CAMPO_OBRIGATORIO + "\n");
                    
                }
                
                if (TSUtil.isEmpty(this.nota.getUDataPublicacaoInicial())) {
                    
                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_DATA_PUBLICACAO_INICIAL + Constantes.CAMPO_OBRIGATORIO + "\n");
                    
                }
                
                if (!TSUtil.isEmpty(this.nota.getUObservacao()) && this.nota.getUObservacao().length() > 250) {
                    
                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_OBSERVACAO + "\n");
                    
                }
                
                if (!TSUtil.isEmpty(this.nota.getUTipoTransacao()) && Arrays.asList("1250", "1251", "1600", "1290", "1374", "1448").contains(this.nota.getUTipoTransacao())) {
                    this.nota.setUPermuta(1);
                } else {
                    this.nota.setUPermuta(0);
                }
                
                if (!TSUtil.isEmpty(this.nota.getNotaFiscalSaidaLinhaModelList()) && TSUtil.isEmpty(retorno.toString())) {
                    
                    for (NotaFiscalSaidaLinhaABModel item : this.nota.getNotaFiscalSaidaLinhaModelList()) {
                        
                        linha = (RadioNotaFiscalSaidaLinhaModel) item;
                        
                        if (TSUtil.isEmpty(linha.getDescricao())) {
                            
                            retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_DESCRICAO + Constantes.CAMPO_OBRIGATORIO + "\n");
                            
                        }
                        
                        if (!TSUtil.isEmpty(linha.getCstICMSModel())) {
                            
                            linha.getCstICMSModel().setEmpresaModel(this.nota.getEmpresaModel());
                            
                            CategoriaModel categoriaModel = new CategoriaDAO().obterPeloCodigo(new CategoriaModel("codigo", "ICMS", this.nota.getEmpresaModel()));
                            
                            linha.getCstICMSModel().setCategoriaModel(categoriaModel);
                            
                            if ((!TSUtil.isEmpty(linha.getCstICMSModel().getCodigo())) && (TSUtil.isEmpty(linha.getCstICMSModel().getCategoriaModel()))) {
                                
                                retorno.append(Constantes.CSTICMS_INEXISTENTE + "\n");
                                
                            }
                            
                        } else {
                            
                            linha.setCstICMSModel(new CSTModel());
                            
                        }
                        
                        if (!TSUtil.isEmpty(linha.getCstCOFINSModel())) {
                            
                            linha.getCstCOFINSModel().setEmpresaModel(this.nota.getEmpresaModel());
                            
                            CategoriaModel categoriaModel = new CategoriaDAO().obterPeloCodigo(new CategoriaModel("codigo", "COFINS", this.nota.getEmpresaModel()));
                            
                            linha.getCstCOFINSModel().setCategoriaModel(categoriaModel);
                            
                            if ((!TSUtil.isEmpty(linha.getCstCOFINSModel().getCodigo())) && (TSUtil.isEmpty(linha.getCstCOFINSModel().getCategoriaModel()))) {
                                
                                retorno.append(Constantes.CSTCOFINS_INEXISTENTE + "\n");
                                
                            }
                            
                        } else {
                            
                            linha.setCstCOFINSModel(new CSTModel());
                            
                        }
                        
                        if (!TSUtil.isEmpty(linha.getCstIPIModel())) {
                            
                            linha.getCstIPIModel().setEmpresaModel(this.nota.getEmpresaModel());
                            
                            CategoriaModel categoriaModel = new CategoriaDAO().obterPeloCodigo(new CategoriaModel("codigo", "PIS", this.nota.getEmpresaModel()));
                            
                            linha.getCstIPIModel().setCategoriaModel(categoriaModel);
                            
                            if ((!TSUtil.isEmpty(linha.getCstIPIModel().getCodigo())) && (TSUtil.isEmpty(linha.getCstIPIModel().getCategoriaModel()))) {
                                
                                retorno.append(Constantes.CSTIPI_INEXISTENTE + "\n");
                                
                            }
                            
                        } else {
                            
                            linha.setCstIPIModel(new CSTModel());
                            
                        }
                        
                        if (!TSUtil.isEmpty(linha.getCstPISModel())) {
                            
                            linha.getCstPISModel().setEmpresaModel(this.nota.getEmpresaModel());
                            
                            CategoriaModel categoriaModel = new CategoriaDAO().obterPeloCodigo(new CategoriaModel("codigo", "PIS", this.nota.getEmpresaModel()));
                            
                            linha.getCstPISModel().setCategoriaModel(categoriaModel);
                            
                            if ((!TSUtil.isEmpty(linha.getCstPISModel().getCodigo())) && (TSUtil.isEmpty(linha.getCstPISModel().getCategoriaModel()))) {
                                
                                retorno.append(Constantes.CSTPIS_INEXISTENTE + "\n");
                                
                            }
                            
                        } else {
                            
                            linha.setCstPISModel(new CSTModel());
                            
                        }

                        //FIXO
                        linha.setCstPISModel(new CSTModel());
                        linha.setCstCOFINSModel(new CSTModel());
                        linha.setCstPISModel(new CSTModel());
                        linha.setCstICMSModel(new CSTModel());

                        //TERINA FIXO
                        linha.setCodigoImpostoModel(new CodigoImpostoModel());
                        
                        linha.setUtilizacaoModel(new UtilizacaoModel());

                        //linha.getUtilizacaoModel().setId(19L); colocavam fixo
                        linha.getUtilizacaoModel().setId(9L); //teste apenas

                        linha.setEstoqueModel(new EstoqueModel());
                        
                        linha.getEstoqueModel().setId("299");

                        // linha.getCodigoImpostoModel().setId("PUB-001"); colocavam fixo
                        // linha.getCodigoImpostoModel().setId("5102-001"); //teste apenas
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
        
        new RadioNotaFiscalSaidaDAO().inserirInterface(this.nota);
        
        retorno = null;
        
        return retorno;
        
    }
    
    public List<RadioNotaFiscalSaidaModel> pesquisar(RadioNotaFiscalSaidaModel model) throws TSApplicationException {
        
        this.info = new StringBuilder();
        
        if (this.validarPesquisar(model)) {
            
            return new RadioNotaFiscalSaidaDAO().pesquisarInterface(model);
            
        } else {
            
            throw new TSApplicationException(this.info.toString());
            
        }
        
    }
    
    private Boolean validarPesquisar(RadioNotaFiscalSaidaModel model) {
        
        Boolean retorno = true;
        
        if (TSUtil.isEmpty(model)) {
            
            this.info.append(Constantes.RADIONOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");
            
            retorno = false;
            
        } else {
            
            if (TSUtil.isEmpty(model.getOrigemModel())) {
                
                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {
                    
                    if (model.getOrigemModel().getId() != 1) {
                        
                        this.info.append(Constantes.OBJETO_ORIGEM_EASYCLASS + Constantes.CAMPO_OBRIGATORIO + "\n");
                        
                        retorno = false;
                        
                    }
                    
                }
                
            }
        }
        
        return retorno;
        
    }
    
}
