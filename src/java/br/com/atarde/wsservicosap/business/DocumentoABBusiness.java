/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.dao2.back.EmpresaDAO;
import br.com.atarde.wsservicosap.model.DocumentoABModel;
import br.com.atarde.wsservicosap.model.EmpresaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;

/**
 *
 * @author mroland
 */
public abstract class DocumentoABBusiness {

    private DocumentoABModel documento;

    public DocumentoABBusiness() {

    }

    public DocumentoABBusiness(DocumentoABModel documento) {

        this.documento = documento;

    }

    public String insertEvent() {

        String retorno;

        try {

            retorno = this.validar();

            if ("".equals(retorno)) {

                return this.inserir();

            } else {

                return retorno;

            }

        } catch (TSApplicationException e) {

            e.printStackTrace();

            if (TSUtil.isEmpty(e.getMessage())) {

                return Constantes.ERRO_TI;

            } else {

                return Constantes.ERRO_TI + "ERRO: " + e.getMessage();
            }

        }

    }

    public String deleteEvent() {

        String retorno;

        try {

            retorno = this.validarExcluir();

            if ("".equals(retorno)) {

                return this.excluir();

            } else {

                return retorno;

            }

        } catch (TSApplicationException e) {

            e.printStackTrace();

            if (TSUtil.isEmpty(e.getMessage())) {

                return Constantes.ERRO_TI;

            } else {

                return Constantes.ERRO_TI + "ERRO: " + e.getMessage();
            }

        }

    }

    public abstract String validar();

    public abstract String validarExcluir();

    public abstract String inserir() throws TSApplicationException;

    public abstract String excluir() throws TSApplicationException;

    protected String validarGlobal(DocumentoABModel model) {

        StringBuilder retorno = new StringBuilder();

        if (TSUtil.isEmpty(model.getOrigemModel()) || TSUtil.isEmpty(model.getOrigemModel().getId()) || (model.getOrigemModel().getId() == 0)) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ORIGEM + Constantes.CAMPO_OBRIGATORIO + "\n");

        } else {

            model.setEmpresaModel(new EmpresaDAO().obter(new EmpresaModel(Constantes.EMPRESA)));

        }

        if (TSUtil.isEmpty(model.getIdExterno())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ID_EXTERNO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (TSUtil.isEmpty(model.getDataLancamento())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_LANCAMENTO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (TSUtil.isEmpty(model.getDataDocumento())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_DOCUMENTO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (TSUtil.isEmpty(model.getDataCriacao())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_CRIACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (TSUtil.isEmpty(model.getDataAtualizacao())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_ATUALIZACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (TSUtil.isEmpty(model.getCriadoPor())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_CRIADO_POR + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (TSUtil.isEmpty(model.getAtualizadoPor())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_ATUALIZADO_POR + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        if (TSUtil.isEmpty(model.getDataExportacao())) {

            retorno.append(Constantes.OBJETO_OBRIGATORIO_DATA_EXPORTACAO + Constantes.CAMPO_OBRIGATORIO + "\n");

        }

        return retorno.toString();

    }

    protected DocumentoABModel getDocumento() {
        return documento;
    }

    protected void setDocumento(DocumentoABModel documento) {
        this.documento = documento;
    }

}
