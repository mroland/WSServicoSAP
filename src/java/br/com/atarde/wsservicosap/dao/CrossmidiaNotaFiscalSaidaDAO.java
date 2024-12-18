/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.CrossmidiaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.CrossmidiaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.sql.Timestamp;

/**
 *
 * @author mroland
 */
public class CrossmidiaNotaFiscalSaidaDAO {

    public CrossmidiaNotaFiscalSaidaDAO() {
    }

    public void inserir(CrossmidiaNotaFiscalSaidaModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.beginTransaction();

        broker.setPropertySQL("crossmidianotafiscalsaidadao.inserir", model.getClienteCobrancaModel().getIdentificadorFiscalModel().getTipoIdentificador(),
                model.getClienteCobrancaModel().getIdentificadorFiscalModel().getIdentificador(),
                model.getClienteCobrancaModel().getNome(),
                model.getClienteCobrancaModel().getNomeFantasia(),
                model.getClienteCobrancaModel().getTelefoneResidencial(),
                model.getClienteCobrancaModel().getTelefoneCelular(),
                model.getClienteCobrancaModel().getFax(),
                model.getClienteCobrancaModel().getEmail(),
                model.getClienteCobrancaModel().getObservacao(),
                model.getClienteCobrancaModel().getEnderecoModel().getLogradouro(),
                model.getClienteCobrancaModel().getEnderecoModel().getNumero(),
                model.getClienteCobrancaModel().getEnderecoModel().getComplemento(),
                model.getClienteCobrancaModel().getEnderecoModel().getBairro(),
                model.getClienteCobrancaModel().getEnderecoModel().getCidade(),
                model.getClienteCobrancaModel().getEnderecoModel().getEstado(),
                model.getClienteCobrancaModel().getEnderecoModel().getCep(),
                model.getClienteCobrancaModel().getEnderecoModel().getPais(),
                model.getClienteCobrancaModel().getEnderecoModel().getMunicipioModel().getId(),
                model.getClienteCobrancaModel().getIdentificadorFiscalModel().getInscricaoEstadual(),
                model.getClienteCobrancaModel().getIdentificadorFiscalModel().getInscricaoEstadualSubstitutoTributaria(),
                model.getClienteCobrancaModel().getIdentificadorFiscalModel().getInscricaoMunicipal(),
                model.getClienteCobrancaModel().getIdentificadorFiscalModel().getInscricaoINSS(),
                model.getClienteCobrancaModel().getDataAtualizacao(),
                model.getClienteCobrancaModel().getClassificacaoModel().getId(),
                model.getVendedorModel().getIdentificadorFiscalModel().getTipoIdentificador(),
                model.getVendedorModel().getIdentificadorFiscalModel().getIdentificador(),
                model.getVendedorModel().getNome(),
                model.getVendedorModel().getDataAtualizacao(),
                model.getVendedorModel().getGrupoComissaoModel().getId(),
                model.getIdExterno(),
                model.getOrigemModel().getId(),
                model.getDataLancamento(),
                model.getDataDocumento(),
                model.getDataVencimento(),
                model.getCondicaoPagamentoModel().getId(),
                model.getuValorBruto(),
                model.getValorLiquido(),
                model.getDataCriacao(),
                model.getDataAtualizacao(),
                model.getCriadoPor(),
                model.getAtualizadoPor(),
                new Timestamp(System.currentTimeMillis()),
                model.getuEnderecoEntrega(),
                model.getSequenciaModel().getId(),
                model.getStatusModel().getId());

        model.setId(broker.executeIdentity());

        for (NotaFiscalSaidaLinhaABModel item : model.getNotaFiscalSaidaLinhaModelList()) {

            CrossmidiaNotaFiscalSaidaLinhaModel linha = (CrossmidiaNotaFiscalSaidaLinhaModel) item;

            linha.setNotaFiscalSaidaModel(model);

            this.CrossmidiaNotaFiscalSaidaLinhaInserir(linha, broker);

        }


        broker.endTransaction();
    }

    private void CrossmidiaNotaFiscalSaidaLinhaInserir(CrossmidiaNotaFiscalSaidaLinhaModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        broker.setPropertySQL("crossmidianotafiscalsaidalinhadao.inserir", model.getItemModel().getId(),
                model.getQuantidade(),
                model.getValor(),
                model.getCodigoImpostoModel().getId(),
                model.getNotaFiscalSaidaModel().getId());

        broker.execute();


    }
}
