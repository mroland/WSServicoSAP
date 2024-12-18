/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao2.back;

import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaRomaneioModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author mroland
 */
public class VendaAvulsaNotaFiscalSaidaDAO {

    public VendaAvulsaNotaFiscalSaidaDAO() {
    }

    public void inserir(VendaAvulsaNotaFiscalSaidaModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.beginTransaction();

        broker.setPropertySQL("vendaavulsanotafiscalsaidadao.inserir", model.getClienteCobrancaModel().getIdentificadorFiscalModel().getTipoIdentificador(),
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
                model.getObservacao(),
                model.getuBanca(),
                model.getuLote(),
                model.getuRdj(),
                model.getStatusModel().getId(),
                model.getuTipoBanca(),
                model.getuTipoFaturamento(),
                model.getuObservacao(),
                model.getVendedorModel().getUCga());

        model.setId(broker.executeIdentity());

        for (NotaFiscalSaidaLinhaABModel item : model.getNotaFiscalSaidaLinhaModelList()) {

            VendaAvulsaNotaFiscalSaidaLinhaModel linha = (VendaAvulsaNotaFiscalSaidaLinhaModel) item;

            linha.setNotaFiscalSaidaModel(model);

            this.VendaAvulsaNotaFiscalSaidaLinhaInserir(linha, broker);

        }

        if (!TSUtil.isEmpty(model.getRomaneioModelList()) && model.getRomaneioModelList().size() != 0) {
            for (VendaAvulsaRomaneioModel romaneio : model.getRomaneioModelList()) {

                this.VendaAvulsaNotaFiscalSaidaRomaneio(romaneio, broker);

            }

        }

        broker.endTransaction();
    }

    private void VendaAvulsaNotaFiscalSaidaLinhaInserir(VendaAvulsaNotaFiscalSaidaLinhaModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        broker.setPropertySQL("vendaavulsanotafiscalsaidalinhadao.inserir", model.getItemModel().getId(),
                model.getQuantidade(),
                model.getValor(),
                model.getCodigoImpostoModel().getId(),
                model.getNotaFiscalSaidaModel().getId(),
                model.getCfopModel().getCodigo(),
                model.getCstCOFINSModel().getCodigo(),
                model.getCstICMSModel().getCodigo(),
                model.getCstIPIModel().getCodigo(),
                model.getCstPISModel().getCodigo(),
                model.getContaContabilModel().getId(),
                model.getUtilizacaoModel().getId());

        broker.execute();

    }

    private void VendaAvulsaNotaFiscalSaidaRomaneio(VendaAvulsaRomaneioModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        broker.setPropertySQL("vendaavulsanotafiscalsaidaromaneiodao.inserir", model.getIdExterno(),
                model.getRoteiro(),
                model.getDescricao(),
                model.getData(),
                model.getReparte(),
                model.getEncalhe(),
                model.getVenda(),
                model.getPreco(),
                model.getValor(),
                model.getRdj());

        broker.execute();

    }

    @SuppressWarnings("unchecked")
    public List<VendaAvulsaNotaFiscalSaidaModel> pesquisar(VendaAvulsaNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("vendaavulsanotafiscalsaidadao.pesquisar", model.getIdExterno(), model.getOrigemModel().getId());

        return broker.getCollectionBean(VendaAvulsaNotaFiscalSaidaModel.class, "id", "idExterno", "origemModel.id", "statusModel.id", "statusModel.descricao", "mensagemErroImportacao", "dataExportacao", "dataImportacao");

    }
}
