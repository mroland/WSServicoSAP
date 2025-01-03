/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.ClassificacaoDAO;
import br.com.atarde.wsservicosap.dao.CodigoImpostoDAO;
import br.com.atarde.wsservicosap.dao.CondicaoPagamentoDAO;
import br.com.atarde.wsservicosap.dao.EstadoDAO;
import br.com.atarde.wsservicosap.dao.EstoqueDAO;
import br.com.atarde.wsservicosap.dao.GrupoComissaoDAO;
import br.com.atarde.wsservicosap.dao.ItemDAO;
import br.com.atarde.wsservicosap.dao.MunicipioDAO;
import br.com.atarde.wsservicosap.dao.NotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.dao.PaisDAO;
import br.com.atarde.wsservicosap.dao.ParceiroNegocioDAO;
import br.com.atarde.wsservicosap.dao.ParceiroNegocioEnderecoDAO;
import br.com.atarde.wsservicosap.dao.SequenciaDAO;
import br.com.atarde.wsservicosap.dao.UtilizacaoDAO;
import br.com.atarde.wsservicosap.dao.VendedorDAO;
import br.com.atarde.wsservicosap.model.ClassificacaoModel;
import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.atarde.wsservicosap.model.CondicaoPagamentoModel;
import br.com.atarde.wsservicosap.model.EnderecoABModel;
import br.com.atarde.wsservicosap.model.EstadoModel;
import br.com.atarde.wsservicosap.model.EstoqueModel;
import br.com.atarde.wsservicosap.model.GrupoComissaoModel;
import br.com.atarde.wsservicosap.model.IdentificadorFiscalModel;
import br.com.atarde.wsservicosap.model.MunicipioModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaABModel;
import br.com.atarde.wsservicosap.model.PaisModel;
import br.com.atarde.wsservicosap.model.ParceiroNegocioEnderecoModel;
import br.com.atarde.wsservicosap.model.ParceiroNegocioModel;
import br.com.atarde.wsservicosap.model.SequenciaModel;
import br.com.atarde.wsservicosap.model.UtilizacaoModel;
import br.com.atarde.wsservicosap.model.VendedorModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.atarde.wsservicosap.util.Utilitarios;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mroland
 */
public class NotaFiscalSaidaBusiness extends DocumentoABBusiness {

    private StringBuilder info;

    public NotaFiscalSaidaBusiness() {
    }

    public NotaFiscalSaidaBusiness(NotaFiscalSaidaABModel model) {

        super(model);

    }

    protected String validarGlobal(NotaFiscalSaidaABModel model) {

        StringBuilder retorno = new StringBuilder();

        retorno.append(super.validarGlobal(model));

        if (!TSUtil.isEmpty(model.getClienteCobrancaModel())) {

            model.getClienteCobrancaModel().setEmpresaModel(model.getEmpresaModel());

        }

        if (!TSUtil.isEmpty(model.getVendedorModel())) {

            model.getVendedorModel().setEmpresaModel(model.getEmpresaModel());

        }

        retorno.append(this.validaCliente(model.getClienteCobrancaModel()));

        retorno.append(this.validaVendedor(model.getVendedorModel()));

        retorno.append(this.validaNFF(model));

        return retorno.toString();

    }

    protected String validaCliente(ParceiroNegocioModel model) {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_CLIENTE + "\n");

        } else {

            model.setId(null);
            //colocado isso pois do easyclass esta vindo setado nao sei por que 

            if (!TSUtil.isEmpty(Utilitarios.tratarString(model.getId()))) {

                ParceiroNegocioModel parceiroBanco = new ParceiroNegocioDAO().obter(model);

                if (TSUtil.isEmpty(parceiroBanco)) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_PARCEIRO_NEGOCIO + "\n");

                } else {

                    if (!parceiroBanco.getFlagAtivo()) {

                        retorno.append("O parceiro de negócio " + parceiroBanco.getId() + " está inativo " + "\n");

                    }

                    model.setTipo("C");

                    model.setClassificacaoModel(new ClassificacaoModel());

                    model.setIdentificadorFiscalModel(new IdentificadorFiscalModel());

                    model.setEnderecoModel(new ParceiroNegocioEnderecoModel());

                    model.getEnderecoModel().setEstadoModel(new EstadoModel());

                    model.getEnderecoModel().setPaisModel(new PaisModel());

                    model.getEnderecoModel().setMunicipioModel(new MunicipioModel());

                    model.setFlagEndereco(Boolean.FALSE);

                    if (!TSUtil.isEmpty(model.getEnderecoEntregaDefault())) {

                        ParceiroNegocioEnderecoModel endereco = new ParceiroNegocioEnderecoModel();

                        endereco.setEmpresaModel(model.getEmpresaModel());

                        endereco.setTipoEndereco("S");

                        endereco.setParceiroNegocioModel(new ParceiroNegocioModel());

                        endereco.getParceiroNegocioModel().setId(model.getId());

                        endereco.setId(model.getEnderecoEntregaDefault());

                        if (TSUtil.isEmpty(new ParceiroNegocioEnderecoDAO().obter(endereco))) {

                            retorno.append(Constantes.PARCEIRO_NEGOCIO_ENDERECO_ID + "\n");

                        }

                    }

                    if (!TSUtil.isEmpty(model.getEnderecoCobrancaDefault())) {

                        ParceiroNegocioEnderecoModel endereco = new ParceiroNegocioEnderecoModel();

                        endereco.setEmpresaModel(model.getEmpresaModel());

                        endereco.setTipoEndereco("B");

                        endereco.setParceiroNegocioModel(new ParceiroNegocioModel());

                        endereco.getParceiroNegocioModel().setId(model.getId());

                        endereco.setId(model.getEnderecoCobrancaDefault());

                        if (TSUtil.isEmpty(new ParceiroNegocioEnderecoDAO().obter(endereco))) {

                            retorno.append(Constantes.PARCEIRO_NEGOCIO_ENDERECO_ID + "\n");

                        }

                    }

                }

            } else {

                model.setTipo("C");

                retorno.append(this.validaPessoa(model));

                if (TSUtil.isEmpty(model.getClassificacaoModel())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_CLASSIFICACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                } else {

                    model.getClassificacaoModel().setEmpresaModel(model.getEmpresaModel());

                    ParceiroNegocioModel parceiro = new ParceiroNegocioModel();

                    parceiro.setId(model.getId());

                    parceiro.setEmpresaModel(model.getEmpresaModel());

                    parceiro.setTipo(model.getTipo());

                    model.getClassificacaoModel().setParceiroNegocioModel(parceiro);

                    if (TSUtil.isEmpty(new ClassificacaoDAO().obter(model.getClassificacaoModel()))) {

                        retorno.append(Constantes.OBJETO_OBRIGATORIO_CLASSIFICACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                    }

                }

                if (TSUtil.isEmpty(model.getEnderecoModel())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_ENDERECO + "\n");

                } else {

                    model.getEnderecoModel().setEmpresaModel(model.getEmpresaModel());

                    retorno.append(this.validaEndereco(model.getEnderecoModel()));

                }

            }

        }

        return retorno.toString();

    }

    private String validaPessoa(ParceiroNegocioModel model) {

        StringBuilder retorno = new StringBuilder();

        if ((TSUtil.isEmpty(model.getIdentificadorFiscalModel())) || TSUtil.isEmpty(model.getIdentificadorFiscalModel().getTipoIdentificador())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_TIPO_IDENTIFICADOR + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if ((TSUtil.isEmpty(model.getIdentificadorFiscalModel())) || TSUtil.isEmpty(model.getIdentificadorFiscalModel().getIdentificador())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_IDENTIFICADOR + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.getIdentificadorFiscalModel().setIdentificador(model.getIdentificadorFiscalModel().getIdentificador().replace(".", "").replace("/", "").replace("-", ""));

            if (!TSUtil.isEmpty(Utilitarios.tratarString(model.getTipo()))) {

                ParceiroNegocioModel parceiroBanco = new ParceiroNegocioModel();

                parceiroBanco.setId(model.getTipo() + model.getIdentificadorFiscalModel().getIdentificador());

                parceiroBanco.setEmpresaModel(model.getEmpresaModel());

                parceiroBanco = new ParceiroNegocioDAO().obter(parceiroBanco);

                if (!TSUtil.isEmpty(parceiroBanco) && !parceiroBanco.getFlagAtivo()) {

                    retorno.append("O parceiro de negócio " + parceiroBanco.getId() + " está inativo " + "\n");

                }

            }
        }

        if (TSUtil.isEmpty(model.getDataAtualizacao())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_ATUALIZACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if ((TSUtil.isEmpty(model.getIdentificadorFiscalModel())) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getIdentificadorFiscalModel().getInscricaoEstadual())) && model.getIdentificadorFiscalModel().getInscricaoEstadual().length() > 15)) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_INSCRICAO_ESTADUAL + "\n");

        }

        if ((TSUtil.isEmpty(model.getIdentificadorFiscalModel())) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getIdentificadorFiscalModel().getInscricaoEstadualSubstitutoTributaria())) && model.getIdentificadorFiscalModel().getInscricaoEstadualSubstitutoTributaria().length() > 15)) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_INSCRICAO_ESTADUAL_SUBSTITUTO_TRIBUTARIA + "\n");

        }

        if ((TSUtil.isEmpty(model.getIdentificadorFiscalModel())) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getIdentificadorFiscalModel().getInscricaoMunicipal())) && model.getIdentificadorFiscalModel().getInscricaoMunicipal().length() > 15)) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_INSCRICAO_MUNICIPAL + "\n");

        }

        if ((TSUtil.isEmpty(model.getIdentificadorFiscalModel())) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getIdentificadorFiscalModel().getInscricaoINSS())) && model.getIdentificadorFiscalModel().getInscricaoINSS().length() > 15)) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_INSCRICAO_INSS + "\n");

        }

        if (TSUtil.isEmpty(model.getNome()) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getNome())) && model.getNome().length() > 100)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_NOME_PARCEIRO + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.setNome(model.getNome().toUpperCase());

        }

        if (TSUtil.isEmpty(model.getNomeFantasia()) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getNomeFantasia())) && model.getNomeFantasia().length() > 100)) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_NOME_FANTASIA + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.setNomeFantasia(model.getNomeFantasia().toUpperCase());

        }

        if ((!TSUtil.isEmpty(Utilitarios.tratarString(model.getTelefoneResidencial())) && model.getTelefoneResidencial().length() > 15)) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_TELEFONE_RESIDENCIAL + "\n");

        }

        if (!TSUtil.isEmpty(Utilitarios.tratarString(model.getTelefoneCelular()))) {

            if (model.getTelefoneCelular().length() > 15) {

                retorno.append(Constantes.PARCEIRO_NEGOCIO_TELEFONE_CELULAR + "\n");

            } else {

                model.setTelefoneCelular(model.getTelefoneCelular().replace(".", "").replace("/", "").replace("-", "").replace("|", "").replace("\\", "").replace("(", "").replace(")", "").replaceAll(" ", ""));

                if (model.getTelefoneCelular().length() == 11) {

                    model.setTelefoneCelular("(".concat(model.getTelefoneCelular().substring(0, 2)).concat(")").concat(model.getTelefoneCelular().substring(2, 7)).concat("-").concat(model.getTelefoneCelular().substring(7, 11)));

                }

            }

        }

        if (TSUtil.isEmpty(Utilitarios.tratarString(model.getTelefoneCelular())) && TSUtil.isEmpty(Utilitarios.tratarString(model.getTelefoneResidencial()))) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_TELEFONE_OBRIGATORIO + "\n");

        }

        if ((!TSUtil.isEmpty(Utilitarios.tratarString(model.getFax())) && model.getFax().length() > 15)) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_TELEFONE_FAX + "\n");

        }

        if (TSUtil.isEmpty(Utilitarios.tratarString(model.getEmail())) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getEmail())) && model.getEmail().length() > 50)) {

            retorno.append(Constantes.PARCEIRO_NEGOCIO_TELEFONE_EMAIL + "\n");

        }

        if ((!TSUtil.isEmpty(Utilitarios.tratarString(model.getObservacao())))) {

            if (model.getObservacao().length() > 100) {

                retorno.append(Constantes.PARCEIRO_NEGOCIO_OBSERVACAO + "\n");
            } else {

                model.setObservacao(model.getObservacao().toUpperCase());

            }

        }

        return retorno.toString();
    }

    private String validaVendedor(VendedorModel model) {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_VENDEDOR + "\n");

        } else {

            retorno.append(this.validaPessoa(model));

            if (TSUtil.isEmpty(new VendedorDAO().obter(model))) {

                if (TSUtil.isEmpty(model.getGrupoComissaoModel()) || (TSUtil.isEmpty(model.getGrupoComissaoModel().getId()))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_GRUPO_COMISSAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                } else {

                    model.getGrupoComissaoModel().setEmpresaModel(model.getEmpresaModel());

                    if (TSUtil.isEmpty(new GrupoComissaoDAO().obter(model.getGrupoComissaoModel()))) {

                        retorno.append(Constantes.OBJETO_OBRIGATORIO_GRUPO_COMISSAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                    }

                }

                if (!TSUtil.isEmpty(model.getUCga())) {

                    model.setUCga(model.getUCga().replace(".", "").replace("/", "").replace("\\", "").replace("-", ""));

                    if (model.getUCga().length() > 20) {

                        model.setUCga(model.getUCga().substring(0, 20));

                    }

                }

            } else {

                model.setGrupoComissaoModel(new GrupoComissaoModel());

            }

        }

        return retorno.toString();

    }

    private String validaEndereco(EnderecoABModel model) {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model.getLogradouro())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ENDERECO_LOGRADOURO + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.setLogradouro(model.getLogradouro().toUpperCase());

        }

        if (TSUtil.isEmpty(model.getNumero()) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getNumero())) && model.getNumero().length() > 20)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ENDERECO_NUMERO + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.setNumero(model.getNumero().toUpperCase());

        }

        if (TSUtil.isEmpty(model.getBairro()) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getBairro())) && model.getBairro().length() > 100)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ENDERECO_BAIRRO + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.setBairro(model.getBairro().toUpperCase());

        }

        if (TSUtil.isEmpty(model.getCidade()) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getCidade())) && model.getCidade().length() > 100)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ENDERECO_CIDADE + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.setCidade(model.getCidade().toUpperCase());

        }

        if (!TSUtil.isEmpty(Utilitarios.tratarString(model.getComplemento()))) {

            model.setComplemento(model.getComplemento().toUpperCase());

        }

        if (TSUtil.isEmpty(model.getPais()) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getPais())) && model.getPais().length() > 3) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getPais())) && TSUtil.isEmpty(new PaisDAO().obter(new PaisModel(model.getPais(), model.getEmpresaModel()))))) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ENDERECO_PAIS + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            if (TSUtil.isEmpty(model.getEstado()) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getEstado())) && model.getEstado().length() > 3) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getEstado())) && TSUtil.isEmpty(new EstadoDAO().obter(new EstadoModel(model.getEstado(), model.getEmpresaModel()))))) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_ENDERECO_ESTADO + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (!TSUtil.isEmpty(model.getEstado()) && (!TSUtil.isEmpty(model.getCidade())) && (!TSUtil.isEmpty(model.getPais()))) {

                model.setPaisModel(new PaisModel());

                model.getPaisModel().setId(model.getPais());

                model.setEstadoModel(new EstadoModel());

                model.getEstadoModel().setId(model.getEstado());

                MunicipioModel municipio = new MunicipioModel();

                municipio.setEnderecoABModel(model);

                municipio.setEmpresaModel(model.getEmpresaModel());

                municipio = new MunicipioDAO().obter(municipio);

                if (TSUtil.isEmpty(municipio)) {

                    retorno.append(Constantes.MUNICIPIO_INEXISTENTE + "\n");

                } else {

                    model.setMunicipioModel(municipio);

                }

            }

        }

        if (TSUtil.isEmpty(model.getCep()) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getCep())) && model.getCep().length() > 20)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ENDERECO_CEP + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.setCep(model.getCep().replace(".", "").replace("/", "").replace("-", "").replace("|", "").replace("\\", ""));

            if (model.getCep().length() == 8) {

                model.setCep(model.getCep().substring(0, 5).concat("-").concat(model.getCep().substring(5, 8)));

            }

        }

        return retorno.toString();
    }

    private String validaNFF(NotaFiscalSaidaABModel model) {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCAL + "\n");

        } else {

            if (TSUtil.isEmpty(model.getIdExterno())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_ID_EXTERNO + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {

                if (!TSUtil.isEmpty(new NotaFiscalSaidaDAO().obterIdExterno(model))) {

                    retorno.append(Constantes.NOTAFISCALEXPORTADA + "\n");

                } else {

                    if (TSUtil.isEmpty(model.getuValorBruto()) || (model.getuValorBruto().equals(BigDecimal.ZERO))) {

                        retorno.append(Constantes.OBJETO_OBRIGATORIO_VALOR_BRUTO + Constantes.CAMPO_OBRIGATORIO + "\n");

                    }

                    if (TSUtil.isEmpty(model.getValorLiquido()) || (model.getValorLiquido().equals(BigDecimal.ZERO))) {

                        retorno.append(Constantes.OBJETO_OBRIGATORIO_VALOR_LIQUIDO + Constantes.CAMPO_OBRIGATORIO + "\n");

                    }

                    if (TSUtil.isEmpty(model.getNotaFiscalSaidaLinhaModelList())) {

                        retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA + "\n");

                    } else {

                        for (NotaFiscalSaidaLinhaABModel item : model.getNotaFiscalSaidaLinhaModelList()) {

                            item.setEmpresaModel(model.getEmpresaModel());

                            retorno.append(this.validaLinhaNFF(item));

                        }

                    }

                    if (TSUtil.isEmpty(model.getDataVencimento())) {

                        if (TSUtil.isEmpty(model.getCondicaoPagamentoModel()) || (TSUtil.isEmpty(model.getCondicaoPagamentoModel().getId())) || (model.getCondicaoPagamentoModel().getId() == 0)) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCAL_CONDICAO_PAGAMENTO_DATA_VENCIMENTO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        } else {

                            model.getCondicaoPagamentoModel().setEmpresaModel(model.getEmpresaModel());

                            CondicaoPagamentoModel cond = new CondicaoPagamentoDAO().obter(model.getCondicaoPagamentoModel());

                            if (TSUtil.isEmpty(cond)) {

                                retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCAL_CONDICAO_PAGAMENTO_DATA_VENCIMENTO + Constantes.CAMPO_OBRIGATORIO + "\n");

                            }

                        }

                    } else {

                        if (!TSUtil.isEmpty(model.getDataDocumento()) && model.getDataDocumento().after(model.getDataVencimento())) {

                            retorno.append(Constantes.OBJETO_NOTAFISCAL_DATA_VENCIMENTO_MENOR_DATA_DOCUMENTO + "\n");

                        }

                        model.setCondicaoPagamentoModel(new CondicaoPagamentoModel());

                    }

                    if (TSUtil.isEmpty(model.getuEnderecoEntrega()) || (model.getuEnderecoEntrega().equals(""))) {

                        retorno.append(Constantes.OBJETO_OBRIGATORIO_U_ENDERECO_ENTREGA + Constantes.CAMPO_OBRIGATORIO + "\n");

                    } else {

                        model.setuEnderecoEntrega(model.getuEnderecoEntrega().toUpperCase());

                    }

                    model.setSequenciaModel(new SequenciaModel());
                    model.getSequenciaModel().setId(28L);
                    //feito isso pois nao sei de onde vem a sequencia

                    if (!TSUtil.isEmpty(model.getSequenciaModel())) {

                        model.getSequenciaModel().setEmpresaModel(model.getEmpresaModel());

                        if (TSUtil.isEmpty(new SequenciaDAO().obter(model.getSequenciaModel()))) {

                            retorno.append(Constantes.SEQUENCIA_INEXISTENTE + "\n");

                        }

                    } else {

                        retorno.append(Constantes.SEQUENCIA_INEXISTENTE + "\n");

                    }

                }

            }

        }

        return retorno.toString();

    }

    private String validaLinhaNFF(NotaFiscalSaidaLinhaABModel model) {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model.getItemModel()) || (TSUtil.isEmpty(model.getItemModel().getId()))) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_ITEM + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.getItemModel().setEmpresaModel(model.getEmpresaModel());

            if (TSUtil.isEmpty(new ItemDAO().obter(model.getItemModel()))) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_ITEM + Constantes.CAMPO_OBRIGATORIO + "\n");

            } else {

                if (TSUtil.isEmpty(model.getItemModel().getEstoqueModel())) {

                    model.getItemModel().setEstoqueModel(new EstoqueModel());

                } else {

                    if (TSUtil.isEmpty(new EstoqueDAO().obter(new EstoqueModel(model.getItemModel(), model.getEmpresaModel())))) {

                        retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_ITEM_ESTOQUE + "\n");

                    }

                }
            }
        }

        if (TSUtil.isEmpty(model.getQuantidade()) || (model.getQuantidade() == 0)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_QUANTIDADE + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (TSUtil.isEmpty(model.getValor()) || (model.getValor().equals(BigDecimal.ZERO))) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_VALOR + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (!TSUtil.isEmpty(model.getUtilizacaoModel()) && !TSUtil.isEmpty(Utilitarios.tratarLong(model.getUtilizacaoModel().getId())) && TSUtil.isEmpty(new UtilizacaoDAO().obter(new UtilizacaoModel(model.getUtilizacaoModel().getId(), model.getEmpresaModel())))) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_UTILIZACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        model.setCodigoImpostoModel(new CodigoImpostoModel());
        //colocado isso por que nao sei onde vem o JAT002

        if ((!TSUtil.isEmpty(Utilitarios.tratarString(model.getCodigoImpostoModel().getId())) && TSUtil.isEmpty(new CodigoImpostoDAO().obter(new CodigoImpostoModel("id", model.getCodigoImpostoModel().getId(), model.getEmpresaModel()))))) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_CODIGO_IMPOSTO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        return retorno.toString();
    }

    public List<NotaFiscalSaidaABModel> pesquisarTotalmenteAberta(NotaFiscalSaidaABModel model) throws TSApplicationException {

        List<NotaFiscalSaidaABModel> lista;

        if (this.validar(model)) {

            lista = new NotaFiscalSaidaDAO().pesquisarTotalmenteAberta(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

        return lista;
    }

    private Boolean validar(NotaFiscalSaidaABModel model) {

        Boolean retorno = true;

        info = new StringBuilder();

        if (TSUtil.isEmpty(model.getOrigemModel())) {

            info.append(Constantes.OBJETO_OBRIGATORIO_ORIGEM + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel().getId())) {

                info.append(Constantes.OBJETO_OBRIGATORIO_ORIGEM + Constantes.CAMPO_OBRIGATORIO + "\n");

                retorno = false;

            }

        }

        return retorno;

    }

    @Override
    public String validar() {
        return null;
    }

    @Override
    public String inserir() throws TSApplicationException {
        return null;
    }

    @Override
    public String validarExcluir() {
        return null;
    }

    @Override
    public String excluir() throws TSApplicationException {
        return null;
    }

    public NotaFiscalSaidaABModel obter(NotaFiscalSaidaABModel model) {

        return new NotaFiscalSaidaDAO().obterIdExterno(model);

    }

    private String validaPessoa(VendedorModel model) {

        StringBuilder retorno = new StringBuilder();

        if ((TSUtil.isEmpty(model.getIdentificadorFiscalModel())) || TSUtil.isEmpty(model.getIdentificadorFiscalModel().getTipoIdentificador())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_TIPO_IDENTIFICADOR + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if ((TSUtil.isEmpty(model.getIdentificadorFiscalModel())) || TSUtil.isEmpty(model.getIdentificadorFiscalModel().getIdentificador())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_IDENTIFICADOR + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.getIdentificadorFiscalModel().setIdentificador(model.getIdentificadorFiscalModel().getIdentificador().replace(".", "").replace("/", "").replace("-", ""));

        }

        if (TSUtil.isEmpty(model.getNome()) || (!TSUtil.isEmpty(Utilitarios.tratarString(model.getNome())) && model.getNome().length() > 100)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_NOME_VENDEDOR + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.setNome(model.getNome().toUpperCase());

        }

        return retorno.toString();

    }

}
