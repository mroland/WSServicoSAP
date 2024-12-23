/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.VendaAvulsaNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.CSTModel;
import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.model.UtilizacaoModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaRomaneioModel;
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
public class VendaAvulsaNotaFiscalSaidaBusiness extends NotaFiscalSaidaBusiness {

    private StringBuilder info;
    private VendaAvulsaNotaFiscalSaidaModel nota;

    public VendaAvulsaNotaFiscalSaidaBusiness() {
    }

    public VendaAvulsaNotaFiscalSaidaBusiness(VendaAvulsaNotaFiscalSaidaModel model) {

        super(model);

    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();

        VendaAvulsaNotaFiscalSaidaLinhaModel linha;

        this.nota = (VendaAvulsaNotaFiscalSaidaModel) super.getDocumento();

        if (TSUtil.isEmpty(this.nota)) {

            return Constantes.NOTAFISCAL;

        } else {

            retorno.append(this.validarGlobal(this.nota));

            if ("".equals(retorno.toString())) {
                /*
                 if (this.nota.getSequenciaModel().getId() == 28) {

                 ParceiroNegocioModel parceiro = new ParceiroNegocioDAO().obterPeloIdentificador(this.nota.getClienteCobrancaModel());

                 if (!TSUtil.isEmpty(parceiro)) {

                 if (TSUtil.isEmpty(parceiro.getEmail())) {

                 retorno.append(Constantes.PARCEIRO_NEGOCIO_SAP_EMAIL + parceiro.getId() + "\n");

                 }

                 } else {

                 if (TSUtil.isEmpty(this.nota.getClienteCobrancaModel().getEmail()) || (!TSUtil.isEmailValid(this.nota.getClienteCobrancaModel().getEmail()))) {

                 retorno.append(Constantes.OBJETO_OBRIGATORIO_EMAIL + Constantes.CAMPO_OBRIGATORIO + "\n");

                 }


                 }

                 }
                 */

                if ((this.nota.getClienteCobrancaModel().getIdentificadorFiscalModel().getTipoIdentificador() == 0) && (TSUtil.isEmpty(this.nota.getClienteCobrancaModel().getIdentificadorFiscalModel().getInscricaoEstadual()))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_INSCRICAO_ESTADUAL + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (this.nota.getOrigemModel().getId() != 2) {

                    retorno.append(Constantes.OBJETO_ORIGEM_VENDAAVULSA + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getObservacao())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_OBSERVACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getuBanca())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_U_BANCA + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getuLote())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_U_LOTE + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getuRdj())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_RDJ + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getuTipoBanca())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_TIPOBANCA + "\n");
                }

                if (TSUtil.isEmpty(this.nota.getuTipoFaturamento())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_TIPOFATURAMENTO + "\n");

                }

                if ((this.nota.getSequenciaModel().getId() == 28) && ((TSUtil.isEmpty(this.nota.getuObservacao()))) || (!TSUtil.isEmpty(this.nota.getuObservacao()) && this.nota.getuObservacao().length() > 250)) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_OBSERVACAO + "\n");

                }

                if (!TSUtil.isEmpty(this.nota.getRomaneioModelList())) {

                    for (VendaAvulsaRomaneioModel romaneio : this.nota.getRomaneioModelList()) {

                        //System.out.println(TSParseUtil.dateToString(romaneio.getData()));
                        retorno.append(this.validarVendaAvulsaRomaneioModel(romaneio));

                    }

                }

                if (!TSUtil.isEmpty(this.nota.getNotaFiscalSaidaLinhaModelList())) {

                    for (NotaFiscalSaidaLinhaABModel item : this.nota.getNotaFiscalSaidaLinhaModelList()) {

                        linha = (VendaAvulsaNotaFiscalSaidaLinhaModel) item;

                        linha.setCodigoImpostoModel(new CodigoImpostoModel());

                        linha.getCodigoImpostoModel().setId("5101-006");

                        linha.setUtilizacaoModel(new UtilizacaoModel());

                        if (this.nota.getSequenciaModel().getId().equals(26L)) {

                            linha.getUtilizacaoModel().setId(16L);

                        } else {

                            linha.getUtilizacaoModel().setId(21L);
                        }

                        linha.setCstCOFINSModel(new CSTModel());

                        linha.setCstICMSModel(new CSTModel());

                        linha.setCstIPIModel(new CSTModel());

                        linha.setCstPISModel(new CSTModel());

                        /*
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

        new VendaAvulsaNotaFiscalSaidaDAO().inserir(this.nota);

        retorno = null;

        return retorno;

    }

    private String validarVendaAvulsaRomaneioModel(VendaAvulsaRomaneioModel model) {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ROMANEIO + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            if (TSUtil.isEmpty(model.getIdExterno())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_ID_EXTERNO + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getRoteiro())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_ROTEIRO + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getDescricao())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_DESCRICAO_ITEM + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getData())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_VENDA + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getReparte())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_REPARTE + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getEncalhe())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_ENCALHE + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getVenda())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_VENDA + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getPreco()) || (model.getPreco().equals(BigDecimal.ZERO))) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_PRECO_UNITARIO + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getValor()) || (model.getValor().equals(BigDecimal.ZERO))) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_VALOR_TOTAL + Constantes.CAMPO_OBRIGATORIO + "\n");

            }

            if (TSUtil.isEmpty(model.getRdj())) {

                retorno.append(Constantes.OBJETO_OBRIGATORIO_ROMANEIORDJ + Constantes.CAMPO_OBRIGATORIO + "\n");
            }

        }

        return retorno.toString();
    }

    public List<VendaAvulsaNotaFiscalSaidaModel> pesquisar(VendaAvulsaNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new VendaAvulsaNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

    }

    private Boolean validarPesquisar(VendaAvulsaNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.VENDAAVULSANOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 1) {

                        this.info.append(Constantes.OBJETO_ORIGEM_VENDAAVULSA + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }

}
