/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.CobrancaNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.CobrancaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.DespesaAdicionalModel;
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
public class CobrancaPedidoVendaDAO {

    public CobrancaPedidoVendaDAO() {
    }

    public void inserirInterface(CobrancaNotaFiscalSaidaModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.beginTransaction();

        model.setInterfaceId(broker.getSequenceNextValue("cobranca_pedidovenda_id_seq"));

        broker.setSQL("INSERT INTO COBRANCA_PEDIDOVENDA (ID, CLIENTE_COBRANCA_ID, CLIENTE_COBRANCA_TIPO_IDENTIFICADOR,CLIENTE_COBRANCA_IDENTIFICADOR,CLIENTE_COBRANCA_NOME,CLIENTE_COBRANCA_NOME_FANTASIA,CLIENTE_COBRANCA_TELEFONE_RESIDENCIAL,CLIENTE_COBRANCA_TELEFONE_CELULAR,CLIENTE_COBRANCA_FAX,CLIENTE_COBRANCA_EMAIL,CLIENTE_COBRANCA_OBSERVACAO,CLIENTE_COBRANCA_ENDERECO_LOGRADOURO,CLIENTE_COBRANCA_ENDERECO_NUMERO,CLIENTE_COBRANCA_ENDERECO_COMPLEMENTO,CLIENTE_COBRANCA_ENDERECO_BAIRRO,CLIENTE_COBRANCA_ENDERECO_CIDADE,CLIENTE_COBRANCA_ENDERECO_ESTADO,CLIENTE_COBRANCA_ENDERECO_CEP,CLIENTE_COBRANCA_ENDERECO_PAIS, CLIENTE_COBRANCA_ENDERECO_MUNICIPIO,CLIENTE_COBRANCA_INSCRICAO_ESTADUAL,CLIENTE_COBRANCA_INSCRICAO_ESTADUAL_SUBTRIB,CLIENTE_COBRANCA_INSCRICAO_MUNICIPAL,CLIENTE_COBRANCA_INSCRICAO_INSS,CLIENTE_COBRANCA_DATA_ATUALIZACAO,CLIENTE_COBRANCA_CLASSIFICACAO_ID,VENDEDOR_TIPO_IDENTIFICADOR,VENDEDOR_IDENTIFICADOR,VENDEDOR_NOME,VENDEDOR_DATA_ATUALIZACAO,VENDEDOR_GRUPO_COMISSAO_ID,ID_EXTERNO,ORIGEM_ID,DATA_LANCAMENTO,DATA_DOCUMENTO,DATA_VENCIMENTO,CONDICAO_PAGAMENTO,U_VALOR_BRUTO,VALOR_LIQUIDO,DATA_CRIACAO,DATA_ATUALIZACAO,CRIADO_POR,ATUALIZADO_POR,DATA_EXPORTACAO, U_ENDERECO_ENTREGA,SEQUENCIA, STATUS_ID, U_VENDEDOR_CGA, EMPRESA_ID, FILIAL_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                model.getInterfaceId(),
                model.getClienteCobrancaModel().getId(),
                model.getClienteCobrancaModel().getIdentificadorFiscalModel().getTipoIdentificador(),
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
                new Timestamp(model.getDataCriacao().getTime()),
                new Timestamp(model.getDataAtualizacao().getTime()),
                model.getCriadoPor(),
                model.getAtualizadoPor(),
                new Timestamp(System.currentTimeMillis()),
                model.getuEnderecoEntrega(),
                model.getSequenciaModel().getId(),
                model.getStatusModel().getId(),
                model.getVendedorModel().getUCga(),
                model.getEmpresaModel().getId(),
                model.getFilialModel().getId());

        broker.execute();

        for (NotaFiscalSaidaLinhaABModel item : model.getNotaFiscalSaidaLinhaModelList()) {

            CobrancaNotaFiscalSaidaLinhaModel linha = (CobrancaNotaFiscalSaidaLinhaModel) item;

            linha.setNotaFiscalSaidaModel(model);

            this.inserirInterface(linha, broker);

        }

        /*

        for (DespesaAdicionalModel item : model.getDespesaAdicionalModelList()) {

            item.setNotaFiscalSaidaModel(model);

            this.cobrancaNotaFiscalSaidaDespesaAdicionalInserir(item, broker);

        }

         */
        broker.endTransaction();

    }

    @SuppressWarnings("unchecked")
    public List<CobrancaNotaFiscalSaidaModel> pesquisar(CobrancaNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("atolnotafiscalsaidadao.pesquisar", model.getIdExterno(), model.getOrigemModel().getId());

        return broker.getCollectionBean(CobrancaNotaFiscalSaidaModel.class, "id", "idExterno", "origemModel.id", "statusModel.id", "statusModel.descricao", "mensagemErroImportacao", "dataExportacao", "dataImportacao");

    }

    private void inserirInterface(CobrancaNotaFiscalSaidaLinhaModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        model.setInterfaceId(broker.getSequenceNextValue("cobranca_pedidovenda_linha_id_seq"));

        broker.setSQL("INSERT INTO COBRANCA_PEDIDOVENDA_LINHA (ID, ITEM,QUANTIDADE, VALOR, CODIGO_IMPOSTO, COBRANCA_PEDIDOVENDA_ID) VALUES (?,?,?,?,?,?)",
                model.getInterfaceId(),
                model.getItemModel().getId(),
                model.getQuantidade(),
                model.getValor(),
                model.getCodigoImpostoModel().getId(),
                model.getNotaFiscalSaidaModel().getInterfaceId());
        broker.execute();
    }

    public CobrancaNotaFiscalSaidaModel obterIdExternoInterface(CobrancaNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setSQL("SELECT ID FROM COBRANCA_PEDIDOVENDA WHERE ID_EXTERNO = ? AND EMPRESA_ID = ?", model.getIdExterno(), model.getEmpresaModel().getId());

        return (CobrancaNotaFiscalSaidaModel) broker.getObjectBean(CobrancaNotaFiscalSaidaModel.class, "interfaceId");

    }

    private void cobrancaNotaFiscalSaidaDespesaAdicionalInserir(DespesaAdicionalModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        model.setInterfaceId(broker.getSequenceNextValue("cobranca_nff_saida_despesa_adicional_id_seq"));

        broker.setSQL("INSERT INTO COBRANCA_NFF_SAIDA_DESPESA_ADICIONAL(ID, CODIGO, COBRANCA_NFF_SAIDA_ID, VALOR) VALUES (?,?,?,?)",
                model.getInterfaceId(), model.getCodigo(), model.getNotaFiscalSaidaModel().getId(), model.getValor());

        broker.execute();
    }
}
