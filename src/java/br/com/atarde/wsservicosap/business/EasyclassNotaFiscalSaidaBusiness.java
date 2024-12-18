package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.UtilizacaoDAO;
import br.com.atarde.wsservicosap.dao.EasyclassNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.dao.EstoqueDAO;
import br.com.atarde.wsservicosap.model.CSTModel;
import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.atarde.wsservicosap.model.EasyclassNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.EasyclassNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.EstoqueModel;
import br.com.atarde.wsservicosap.model.FilialModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.model.UtilizacaoModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.atarde.wsservicosap.util.Utilitarios;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class EasyclassNotaFiscalSaidaBusiness extends NotaFiscalSaidaBusiness {

    private StringBuilder info;

    private EasyclassNotaFiscalSaidaModel nota;

    public EasyclassNotaFiscalSaidaBusiness() {
    }

    public EasyclassNotaFiscalSaidaBusiness(EasyclassNotaFiscalSaidaModel model) {

        super(model);
    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();

        EasyclassNotaFiscalSaidaLinhaModel linha;

        this.nota = (EasyclassNotaFiscalSaidaModel) super.getDocumento();

        if (TSUtil.isEmpty(this.nota)) {

            return Constantes.NOTAFISCAL;

        } else {

            retorno.append(this.validarGlobal(this.nota));

            if ("".equals(retorno.toString())) {

                if (!TSUtil.isEmpty(new EasyclassNotaFiscalSaidaDAO().obterIdExternoInterface(nota))) {

                    retorno.append(Constantes.NOTAFISCALEXPORTADA + "\n");

                    return retorno.toString();

                }

                this.nota.setFilialModel(new FilialModel());

                this.nota.getFilialModel().setEmpresa(this.nota.getEmpresaModel());

                //this.nota.setFilialModel(new FilialDAO().obterInterface(this.nota.getFilialModel()));
                if (this.nota.getOrigemModel().getId().equals(14L)) { //ATN

                    this.nota.getFilialModel().setId(3);

                } else {

                    this.nota.getFilialModel().setId(1);

                }

                if (!TSUtil.isEmpty(this.nota.getClienteModel())) {

                    this.nota.getClienteModel().setEmpresaModel(this.nota.getEmpresaModel());

                }

                retorno.append(this.validaCliente(this.nota.getClienteModel()));

                //retirado va validacao por causa da empresa ATN..
                //if ((this.nota.getOrigemModel().getId() != 1) && (this.nota.getOrigemModel().getId() != 12)) {
                //    retorno.append(Constantes.OBJETO_ORIGEM_EASYCLASS + "\n");
                //}
                if (TSUtil.isEmpty(this.nota.getUComissaoAgencia())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_COMISSAO_AGENCIA + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getUDataPublicacaoFinal())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_DATA_PUBLICACAO_FINAL + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getUDataPublicacaoInicial())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_DATA_PUBLICACAO_INICIAL + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getUDiasPublicacao()) || (this.nota.getUDiasPublicacao().equals(""))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_DIAS_PUBLICACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getUTituloPublicacao()) || (this.nota.getUTituloPublicacao().equals(""))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_TITULO_PUBLICACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                } else {

                    this.nota.setUTituloPublicacao(this.nota.getUTituloPublicacao().toUpperCase());

                }

                if (!TSUtil.isEmpty(this.nota.getUObservacao())) {

                    if (this.nota.getUObservacao().length() > 250) {

                        retorno.append(Constantes.OBJETO_OBRIGATORIO_U_OBSERVACAO + "\n");
                        
                    } else {

                        this.nota.setUObservacao(this.nota.getUObservacao().toUpperCase());

                    }

                }

                if (!TSUtil.isEmpty(this.nota.getUTipoTransacao()) && Arrays.asList("1250", "1251", "1600", "1290", "1374", "1448").contains(this.nota.getUTipoTransacao())) {
                    this.nota.setUPermuta(1);
                } else {
                    this.nota.setUPermuta(0);
                }

                if (!TSUtil.isEmpty(this.nota.getNotaFiscalSaidaLinhaModelList())) {

                    for (NotaFiscalSaidaLinhaABModel item : this.nota.getNotaFiscalSaidaLinhaModelList()) {

                        linha = (EasyclassNotaFiscalSaidaLinhaModel) item;

                        linha.setCodigoImpostoModel(new CodigoImpostoModel());

                        // linha.getCodigoImpostoModel().setId("5933-001"); colocavam fixo
                        //linha.getCodigoImpostoModel().setId("5102-001"); //teste apenas
                        linha.setUtilizacaoModel(new UtilizacaoModel());

                        //linha.getUtilizacaoModel().setId(19L); colocavam fixo
                        linha.getUtilizacaoModel().setId(9L); //teste apenas

                        linha.setEstoqueModel(new EstoqueModel());

                        if (this.nota.getFilialModel().getId().equals(3)) { //ATN

                            linha.getEstoqueModel().setId("399");

                        } else {

                            linha.getEstoqueModel().setId("199");

                        }

                        if ((!TSUtil.isEmpty(Utilitarios.tratarString(linha.getEstoqueModel().getId())) && TSUtil.isEmpty(new EstoqueDAO().obter(new EstoqueModel(linha.getEstoqueModel().getId(), linha.getEmpresaModel()))))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_ITEM_ESTOQUE + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }

                        if ((!TSUtil.isEmpty(Utilitarios.tratarLong(linha.getUtilizacaoModel().getId())) && TSUtil.isEmpty(new UtilizacaoDAO().obter(new UtilizacaoModel(linha.getUtilizacaoModel().getId(), linha.getEmpresaModel()))))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_UTILIZACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }

                        /*
                        if ((!TSUtil.isEmpty(Utilitarios.tratarString(linha.getCodigoImpostoModel().getId())) && TSUtil.isEmpty(new CodigoImpostoDAO().obter(new CodigoImpostoModel("id", linha.getCodigoImpostoModel().getId(), linha.getEmpresaModel()))))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_CODIGO_IMPOSTO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }
                         */
                        linha.setCstCOFINSModel(new CSTModel());

                        linha.setCstICMSModel(new CSTModel());

                        linha.setCstIPIModel(new CSTModel());

                        linha.setCstPISModel(new CSTModel());

                        if (TSUtil.isEmpty(linha.getValorUnitario()) || (linha.getValorUnitario().equals(BigDecimal.ZERO))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_VALOR_UNITARIO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }

                        if (TSUtil.isEmpty(linha.getuValorUnitario()) || (linha.getuValorUnitario().equals(BigDecimal.ZERO))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_U_VALOR_UNITARIO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }

                        if (TSUtil.isEmpty(linha.getuTotalCmXCol()) || (linha.getuTotalCmXCol().equals(BigDecimal.ZERO))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_U_TOTAL_CMXCOL + Constantes.CAMPO_OBRIGATORIO + "\n");

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

        new EasyclassNotaFiscalSaidaDAO().inserirInterface(this.nota);

        retorno = null;

        return retorno;

    }

    public List<EasyclassNotaFiscalSaidaModel> pesquisar(EasyclassNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new EasyclassNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

    }

    private Boolean validarPesquisar(EasyclassNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.EASYCLASSNOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

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
