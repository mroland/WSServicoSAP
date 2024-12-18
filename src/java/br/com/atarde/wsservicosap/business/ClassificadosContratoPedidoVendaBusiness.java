package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.ClassificadosContratoNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.dao.ClassificadosContratoPedidoVendaDAO;
import br.com.atarde.wsservicosap.model.ClassificadosContratoNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.ClassificadosContratoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.atarde.wsservicosap.model.FilialModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.model.UtilizacaoModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.math.BigDecimal;
import java.util.List;

public class ClassificadosContratoPedidoVendaBusiness extends NotaFiscalSaidaBusiness {

    private StringBuilder info;

    private ClassificadosContratoNotaFiscalSaidaModel nota;

    public ClassificadosContratoPedidoVendaBusiness() {
    }

    public ClassificadosContratoPedidoVendaBusiness(ClassificadosContratoNotaFiscalSaidaModel model) {

        super(model);

    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();

        ClassificadosContratoNotaFiscalSaidaLinhaModel linha;

        this.nota = (ClassificadosContratoNotaFiscalSaidaModel) super.getDocumento();

        if (TSUtil.isEmpty(this.nota)) {

            return Constantes.NOTAFISCAL;

        } else {

            retorno.append(this.validarGlobal(this.nota));

            if ("".equals(retorno.toString())) {

                if (!TSUtil.isEmpty(new ClassificadosContratoPedidoVendaDAO().obterIdExternoInterface(nota))) {

                    retorno.append(Constantes.NOTAFISCALEXPORTADA + "\n");

                    return retorno.toString();

                }

                this.nota.setFilialModel(new FilialModel());

                this.nota.getFilialModel().setId(1);

                if (!TSUtil.isEmpty(this.nota.getClienteModel())) {

                    this.nota.getClienteModel().setEmpresaModel(this.nota.getEmpresaModel());

                }

                retorno.append(this.validaCliente(this.nota.getClienteModel()));

                if (this.nota.getOrigemModel().getId() != 8) {

                    retorno.append(Constantes.OBJETO_ORIGEM_CLASSIFICADOS + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getUComissaoAgencia())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_COMISSAO_AGENCIA + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getUDataPublicacaoFinal())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_DATA_PUBLICACAO_FINAL + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getUDiasPublicacao()) || (this.nota.getUDiasPublicacao().equals(""))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_DIAS_PUBLICACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getUTituloPublicacao()) || (this.nota.getUTituloPublicacao().equals(""))) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_TITULO_PUBLICACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (TSUtil.isEmpty(this.nota.getUDataPublicacaoInicial())) {

                    retorno.append(Constantes.OBJETO_OBRIGATORIO_U_DATA_PUBLICACAO_INICIAL + Constantes.CAMPO_OBRIGATORIO + "\n");

                }

                if (!TSUtil.isEmpty(this.nota.getNotaFiscalSaidaLinhaModelList())) {

                    for (NotaFiscalSaidaLinhaABModel item : this.nota.getNotaFiscalSaidaLinhaModelList()) {

                        linha = (ClassificadosContratoNotaFiscalSaidaLinhaModel) item;

                        linha.setCodigoImpostoModel(new CodigoImpostoModel());

                        // linha.getCodigoImpostoModel().setId("5933-001"); colocavam fixo
                        linha.getCodigoImpostoModel().setId("5102-001"); //teste apenas

                        linha.setUtilizacaoModel(new UtilizacaoModel());

                        //linha.getUtilizacaoModel().setId(19L); colocavam fixo
                        linha.getUtilizacaoModel().setId(10L); //teste apenas
                        
                        if (TSUtil.isEmpty(linha.getValorUnitario()) || (linha.getValorUnitario().equals(BigDecimal.ZERO))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_VALOR_UNITARIO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }

                        if (TSUtil.isEmpty(linha.getUValorUnitario()) || (linha.getUValorUnitario().equals(BigDecimal.ZERO))) {

                            retorno.append(Constantes.OBJETO_OBRIGATORIO_LINHA_U_VALOR_UNITARIO + Constantes.CAMPO_OBRIGATORIO + "\n");

                        }

                        if (TSUtil.isEmpty(linha.getUTotalCmXCol()) || (linha.getUTotalCmXCol().equals(BigDecimal.ZERO))) {

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

        new ClassificadosContratoNotaFiscalSaidaDAO().inserirInterface(this.nota);

        retorno = null;

        return retorno;

    }

    public List<ClassificadosContratoNotaFiscalSaidaModel> pesquisar(ClassificadosContratoNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new ClassificadosContratoNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

    }

    private Boolean validarPesquisar(ClassificadosContratoNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.CLASSIFICADOSCONTRATONOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

            retorno = false;

        } else {

            if (TSUtil.isEmpty(model.getOrigemModel())) {

                if (!TSUtil.isEmpty(model.getOrigemModel().getId())) {

                    if (model.getOrigemModel().getId() != 8) {

                        this.info.append(Constantes.OBJETO_ORIGEM_CLASSIFICADOS + Constantes.CAMPO_OBRIGATORIO + "\n");

                        retorno = false;

                    }

                }

            }
        }

        return retorno;

    }

}
