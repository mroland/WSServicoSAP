/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.AtolNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.AtolNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.sql.Timestamp;
import java.util.List;


/**
 *
 * @author mroland
 */
public class AtolNotaFiscalSaidaDAO {

    public AtolNotaFiscalSaidaDAO() {
    }

    public void inserir(AtolNotaFiscalSaidaModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.beginTransaction();

        broker.setPropertySQL("atolnotafiscalsaidadao.inserir", model.getClienteCobrancaModel().getIdentificadorFiscalModel().getTipoIdentificador(),
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
                model.getuContrato(),
                model.getuMesReferencia(),
                model.getStatusModel().getId(),
                model.getuPontoReferencia(),
                model.getuDescricaoTaxa(),
                model.getPercentualDesconto(),
                model.getVendedorModel().getUCga());

        model.setId(broker.executeIdentity());

        for (NotaFiscalSaidaLinhaABModel item : model.getNotaFiscalSaidaLinhaModelList()) {

            AtolNotaFiscalSaidaLinhaModel linha = (AtolNotaFiscalSaidaLinhaModel) item;

            linha.setNotaFiscalSaidaModel(model);

            this.AtolNotaFiscalSaidaLinhaInserir(linha, broker);

        }


        broker.endTransaction();



    }

    private void AtolNotaFiscalSaidaLinhaInserir(AtolNotaFiscalSaidaLinhaModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        broker.setPropertySQL("atolnotafiscalsaidalinhadao.inserir", model.getItemModel().getId(),
                model.getQuantidade(),
                model.getValorUnitario(),
                model.getValor(),
                model.getCodigoImpostoModel().getId(),
                model.getNotaFiscalSaidaModel().getId(),
                model.getCstCOFINSModel().getCodigo(),
                model.getCstICMSModel().getCodigo(),
                model.getCstIPIModel().getCodigo(),
                model.getCstPISModel().getCodigo(),
                model.getCfopModel().getCodigo());
        broker.execute();

    }

    @SuppressWarnings("unchecked")
    public List<AtolNotaFiscalSaidaModel> pesquisar(AtolNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("atolnotafiscalsaidadao.pesquisar", model.getIdExterno(), model.getOrigemModel().getId());

        return broker.getCollectionBean(AtolNotaFiscalSaidaModel.class, "id", "idExterno","origemModel.id", "statusModel.id", "statusModel.descricao", "mensagemErroImportacao", "dataExportacao","dataImportacao");

    }
}
