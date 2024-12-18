package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao.ClassificadosExecucaoNotaFiscalSaidaDAO;
import br.com.atarde.wsservicosap.model.ClassificadosExecucaoNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.ClassificadosExecucaoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.CodigoImpostoModel;
import br.com.atarde.wsservicosap.model.EstoqueModel;
import br.com.atarde.wsservicosap.model.FilialModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.StatusModel;
import br.com.atarde.wsservicosap.model.UtilizacaoModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.util.List;

public class ClassificadosExecucaoNotaFiscalSaidaBusiness extends NotaFiscalSaidaBusiness {

    private StringBuilder info;

    private ClassificadosExecucaoNotaFiscalSaidaModel nota;

    public ClassificadosExecucaoNotaFiscalSaidaBusiness() {
    }

    public ClassificadosExecucaoNotaFiscalSaidaBusiness(ClassificadosExecucaoNotaFiscalSaidaModel model) {

        super(model);

    }

    @Override
    public String validar() {

        StringBuilder retorno = new StringBuilder();

        ClassificadosExecucaoNotaFiscalSaidaLinhaModel linha;

        this.nota = (ClassificadosExecucaoNotaFiscalSaidaModel) super.getDocumento();

        if (TSUtil.isEmpty(this.nota)) {

            return Constantes.NOTAFISCAL;

        } else {

            retorno.append(this.validarGlobal(this.nota));

            if ("".equals(retorno.toString())) {

                if (!TSUtil.isEmpty(new ClassificadosExecucaoNotaFiscalSaidaDAO().obterIdExternoInterface(nota))) {

                    retorno.append(Constantes.NOTAFISCALEXPORTADA + "\n");

                    return retorno.toString();

                }

                this.nota.setFilialModel(new FilialModel());

                if (this.nota.getOrigemModel().getId() != 8 && this.nota.getOrigemModel().getId() != 14) {

                    retorno.append(Constantes.OBJETO_ORIGEM_CLASSIFICADOS + "\n");

                } else {

                    if (this.nota.getOrigemModel().getId().equals(14L)) { //ATN

                        this.nota.getFilialModel().setId(3);

                    } else {

                        this.nota.getFilialModel().setId(1);

                    }

                }

            }

            if (!TSUtil.isEmpty(this.nota.getNotaFiscalSaidaLinhaModelList())) {

                for (NotaFiscalSaidaLinhaABModel item : this.nota.getNotaFiscalSaidaLinhaModelList()) {

                    linha = (ClassificadosExecucaoNotaFiscalSaidaLinhaModel) item;

                    // linha.getCodigoImpostoModel().setId("5933-001"); colocavam fixo
                    //linha.getCodigoImpostoModel().setId("5102-001"); //teste apenas
                    linha.setCodigoImpostoModel(new CodigoImpostoModel());

                    linha.setUtilizacaoModel(new UtilizacaoModel());

                    //linha.getUtilizacaoModel().setId(19L); colocavam fixo
                    linha.getUtilizacaoModel().setId(9L); //teste apenas

                    linha.setEstoqueModel(new EstoqueModel());

                    if (this.nota.getFilialModel().getId().equals(3)) { //ATN

                        linha.getEstoqueModel().setId("399");

                    } else {

                        linha.getEstoqueModel().setId("199");

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

        new ClassificadosExecucaoNotaFiscalSaidaDAO().inserirInterface(this.nota);

        retorno = null;

        return retorno;

    }

    public List<ClassificadosExecucaoNotaFiscalSaidaModel> pesquisar(ClassificadosExecucaoNotaFiscalSaidaModel model) throws TSApplicationException {

        this.info = new StringBuilder();

        if (this.validarPesquisar(model)) {

            return new ClassificadosExecucaoNotaFiscalSaidaDAO().pesquisar(model);

        } else {

            throw new TSApplicationException(this.info.toString());

        }

    }

    private Boolean validarPesquisar(ClassificadosExecucaoNotaFiscalSaidaModel model) {

        Boolean retorno = true;

        if (TSUtil.isEmpty(model)) {

            this.info.append(Constantes.CLASSIFICADOSEXECUCAONOTAFISCALSAIDAMODEL + Constantes.CAMPO_OBRIGATORIO + "\n");

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
