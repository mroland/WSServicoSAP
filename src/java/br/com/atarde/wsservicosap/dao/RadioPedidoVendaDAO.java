package br.com.atarde.wsservicosap.dao;

import br.com.atarde.wsservicosap.model.RadioNotaFiscalSaidaLinhaModel;
import br.com.atarde.wsservicosap.model.RadioNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaLinhaABModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import java.sql.Timestamp;
import java.util.List;

public class RadioPedidoVendaDAO {

    public void inserirInterface(RadioNotaFiscalSaidaModel model) throws TSApplicationException {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.beginTransaction();

        model.setInterfaceId(broker.getSequenceNextValue("radio_pedidovenda_id_seq"));

        broker.setSQL("INSERT INTO RADIO_PEDIDOVENDA (ID, CLIENTE_ID, CLIENTE_TIPO_IDENTIFICADOR,CLIENTE_IDENTIFICADOR,CLIENTE_NOME,CLIENTE_NOME_FANTASIA,CLIENTE_TELEFONE_RESIDENCIAL,CLIENTE_TELEFONE_CELULAR,CLIENTE_FAX,CLIENTE_EMAIL,CLIENTE_OBSERVACAO,CLIENTE_ENDERECO_LOGRADOURO,CLIENTE_ENDERECO_NUMERO,CLIENTE_ENDERECO_COMPLEMENTO,CLIENTE_ENDERECO_BAIRRO,CLIENTE_ENDERECO_CIDADE,CLIENTE_ENDERECO_ESTADO,CLIENTE_ENDERECO_CEP,CLIENTE_ENDERECO_PAIS, CLIENTE_ENDERECO_MUNICIPIO, CLIENTE_INSCRICAO_ESTADUAL,CLIENTE_INSCRICAO_ESTADUAL_SUBTRIB,CLIENTE_INSCRICAO_MUNICIPAL,CLIENTE_INSCRICAO_INSS,CLIENTE_DATA_ATUALIZACAO,CLIENTE_CLASSIFICACAO_ID, CLIENTE_COBRANCA_ID, CLIENTE_COBRANCA_TIPO_IDENTIFICADOR,CLIENTE_COBRANCA_IDENTIFICADOR,CLIENTE_COBRANCA_NOME,CLIENTE_COBRANCA_NOME_FANTASIA,CLIENTE_COBRANCA_TELEFONE_RESIDENCIAL,CLIENTE_COBRANCA_TELEFONE_CELULAR,CLIENTE_COBRANCA_FAX,CLIENTE_COBRANCA_EMAIL,CLIENTE_COBRANCA_OBSERVACAO,CLIENTE_COBRANCA_ENDERECO_LOGRADOURO,CLIENTE_COBRANCA_ENDERECO_NUMERO,CLIENTE_COBRANCA_ENDERECO_COMPLEMENTO,CLIENTE_COBRANCA_ENDERECO_BAIRRO,CLIENTE_COBRANCA_ENDERECO_CIDADE,CLIENTE_COBRANCA_ENDERECO_ESTADO,CLIENTE_COBRANCA_ENDERECO_CEP,CLIENTE_COBRANCA_ENDERECO_PAIS, CLIENTE_COBRANCA_ENDERECO_MUNICIPIO,CLIENTE_COBRANCA_INSCRICAO_ESTADUAL,CLIENTE_COBRANCA_INSCRICAO_ESTADUAL_SUBTRIB,CLIENTE_COBRANCA_INSCRICAO_MUNICIPAL,CLIENTE_COBRANCA_INSCRICAO_INSS,CLIENTE_COBRANCA_DATA_ATUALIZACAO,CLIENTE_COBRANCA_CLASSIFICACAO_ID, VENDEDOR_ID, VENDEDOR_TIPO_IDENTIFICADOR,VENDEDOR_IDENTIFICADOR,VENDEDOR_NOME,VENDEDOR_DATA_ATUALIZACAO,VENDEDOR_GRUPO_COMISSAO_ID,ID_EXTERNO,ORIGEM_ID,DATA_LANCAMENTO,DATA_DOCUMENTO,DATA_VENCIMENTO,CONDICAO_PAGAMENTO,U_VALOR_BRUTO,U_COMISSAO_AGENCIA,VALOR_LIQUIDO,DATA_CRIACAO,DATA_ATUALIZACAO,CRIADO_POR,ATUALIZADO_POR,DATA_EXPORTACAO,U_ENDERECO_ENTREGA,SEQUENCIA, STATUS_ID, U_NUMERO_PI, U_PERIODO_VEICULACAO,U_DATA_CONTRATO,U_TIPO_TRANSACAO, U_ENTREGA_VENDEDOR, U_POSTO_ID, U_DATA_PUBLICACAO_INICIAL, U_VENDEDOR_CGA, U_OBSERVACAO, U_PERMUTA, EMPRESA_ID, CLIENTE_FLAG_ENDERECO, CLIENTE_ENDERECO_ENTREGA_DEFAULT, CLIENTE_ENDERECO_COBRANCA_DEFAULT, CLIENTE_COBRANCA_ENDERECO_ENTREGA_DEFAULT, CLIENTE_COBRANCA_ENDERECO_COBRANCA_DEFAULT, CLIENTE_COBRANCA_FLAG_ENDERECO, FILIAL_ID, SAP_PEDIOVENDA_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                model.getInterfaceId(),
                model.getClienteModel().getId(),
                model.getClienteModel().getIdentificadorFiscalModel().getTipoIdentificador(),
                model.getClienteModel().getIdentificadorFiscalModel().getIdentificador(),
                model.getClienteModel().getNome(),
                model.getClienteModel().getNomeFantasia(),
                model.getClienteModel().getTelefoneResidencial(),
                model.getClienteModel().getTelefoneCelular(),
                model.getClienteModel().getFax(),
                model.getClienteModel().getEmail(),
                model.getClienteModel().getObservacao(),
                model.getClienteModel().getEnderecoModel().getLogradouro(),
                model.getClienteModel().getEnderecoModel().getNumero(),
                model.getClienteModel().getEnderecoModel().getComplemento(),
                model.getClienteModel().getEnderecoModel().getBairro(),
                model.getClienteModel().getEnderecoModel().getCidade(),
                model.getClienteModel().getEnderecoModel().getEstado(),
                model.getClienteModel().getEnderecoModel().getCep(),
                model.getClienteModel().getEnderecoModel().getPais(),
                model.getClienteModel().getEnderecoModel().getMunicipioModel().getId(),
                model.getClienteModel().getIdentificadorFiscalModel().getInscricaoEstadual(),
                model.getClienteModel().getIdentificadorFiscalModel().getInscricaoEstadualSubstitutoTributaria(),
                model.getClienteModel().getIdentificadorFiscalModel().getInscricaoMunicipal(),
                model.getClienteModel().getIdentificadorFiscalModel().getInscricaoINSS(),
                model.getClienteModel().getDataAtualizacao(),
                model.getClienteModel().getClassificacaoModel().getId(),
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
                model.getVendedorModel().getId(),
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
                model.getuComissaoAgencia(),
                model.getValorLiquido(),
                new Timestamp(model.getDataCriacao().getTime()),
                new Timestamp(model.getDataAtualizacao().getTime()),
                model.getCriadoPor(),
                model.getAtualizadoPor(),
                new Timestamp(System.currentTimeMillis()),
                model.getuEnderecoEntrega(),
                model.getSequenciaModel().getId(),
                model.getStatusModel().getId(),
                model.getUNumeroPI(),
                model.getuPeriodoVeiculacao(),
                model.getuDataContrato(),
                model.getUTipoTransacao(),
                model.getUEntregaVendedor(),
                model.getUPostoId(),
                model.getUDataPublicacaoInicial(),
                model.getVendedorModel().getUCga(),
                model.getUObservacao(),
                model.getUPermuta(),
                model.getEmpresaModel().getId(),
                model.getClienteModel().getFlagEndereco(),
                model.getClienteModel().getEnderecoEntregaDefault(),
                model.getClienteModel().getEnderecoCobrancaDefault(),
                model.getClienteCobrancaModel().getEnderecoEntregaDefault(),
                model.getClienteCobrancaModel().getEnderecoCobrancaDefault(),
                model.getClienteCobrancaModel().getFlagEndereco(),
                model.getFilialModel().getId(),
                model.getId());

        broker.execute();

        for (NotaFiscalSaidaLinhaABModel item : model.getNotaFiscalSaidaLinhaModelList()) {

            RadioNotaFiscalSaidaLinhaModel radioNotaFiscalLinhaModel = (RadioNotaFiscalSaidaLinhaModel) item;

            radioNotaFiscalLinhaModel.setNotaFiscalSaidaModel(new RadioNotaFiscalSaidaModel("interfaceId", model.getInterfaceId()));

            this.inserirInterface(radioNotaFiscalLinhaModel, broker);

        }

        broker.endTransaction();

    }

    public RadioNotaFiscalSaidaModel obterIdExternoInterface(RadioNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setSQL("SELECT ID FROM RADIO_PEDIDOVENDA WHERE ID_EXTERNO = ? AND EMPRESA_ID = ?", model.getIdExterno(), model.getEmpresaModel().getId());

        return (RadioNotaFiscalSaidaModel) broker.getObjectBean(RadioNotaFiscalSaidaModel.class, "interfaceId");
    }

    private void inserirInterface(RadioNotaFiscalSaidaLinhaModel model, TSDataBaseBrokerIf broker) throws TSApplicationException {

        model.setInterfaceId(broker.getSequenceNextValue("radio_nff_pedidovenda_id_seq"));

        broker.setSQL("INSERT INTO RADIO_PEDIDOVENDA_LINHA (ID, ITEM, QUANTIDADE, VALOR, CODIGO_IMPOSTO, RADIO_PEDIDOVENDA_ID, CST_COFINS, CST_ICMS, CST_IPI, CST_PIS, U_SECUNDAGEM, DESCRICAO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
                model.getInterfaceId(),
                model.getItemModel().getId(),
                model.getQuantidade(),
                model.getValor(),
                model.getCodigoImpostoModel().getId(),
                model.getNotaFiscalSaidaModel().getInterfaceId(),
                model.getCstCOFINSModel().getCodigo(),
                model.getCstICMSModel().getCodigo(),
                model.getCstIPIModel().getCodigo(),
                model.getCstPISModel().getCodigo(),
                model.getuSegundagem(),
                model.getDescricao());

        broker.execute();

    }

    @SuppressWarnings("unchecked")
    public List<RadioNotaFiscalSaidaModel> pesquisarInterface(RadioNotaFiscalSaidaModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setSQL("radionotafiscalsaidadao.pesquisar", model.getIdExterno(), model.getOrigemModel().getId());

        return broker.getCollectionBean(RadioNotaFiscalSaidaModel.class, "id", "idExterno", "origemModel.id", "statusModel.id", "statusModel.descricao", "mensagemErroImportacao", "dataExportacao", "dataImportacao");

    }
}
