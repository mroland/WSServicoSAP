/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.util;

/**
 *
 * @author mroland
 */
public class Constantes {

    public static final String JNDI_RADIO = "java:comp/env/jdbc/SAPRadioDS";
    public static final String JNDI_JORNAL = "java:comp/env/jdbc/SAPJornalDS";

    public static final String JNDI_SABWEB = "java:comp/env/jdbc/SapWebHanaDS";

    public static Long EMPRESA = 4L;

    public static final String CAMPO_OBRIGATORIO = "Campo Obrigatorio";
    public static final String OBJETO_OBRIGATORIO_CLIENTE = "favor inserir objeto Cliente|ClienteCobranca.";
    public static final String OBJETO_OBRIGATORIO_TIPO_IDENTIFICADOR = "favor inserir objeto IdentificadorFiscalModel ou atributo tipoIdentificador.";
    public static final String OBJETO_OBRIGATORIO_IDENTIFICADOR = "favor inserir objeto IdentificadorFiscalModel ou atributo identificador.";
    public static final String OBJETO_OBRIGATORIO_INSCRICAO_ESTADUAL = "favor inserir atributo inscricaoEstadual ao objeto IdentificadorFiscalModel.";
    public static final String OBJETO_OBRIGATORIO_NOME_PARCEIRO = "favor inserir atributo parceiroNegocio.nome com tamanho limite: 100 caracteres.";
    public static final String OBJETO_OBRIGATORIO_NOME_VENDEDOR = "favor inserir atributo vendedor.nome com tamanho limite: 100 caracteres.";
    public static final String OBJETO_OBRIGATORIO_VENDEDOR = "favor inserir objeto Vendedor.";
    public static final String OBJETO_OBRIGATORIO_GRUPO_COMISSAO = "favor inserir objeto GrupoComissaoModel ou atributo id.";
    public static final String OBJETO_OBRIGATORIO_ENDERECO = "favor inserir Objeto Endereco do Objeto Cliente";
    public static final String OBJETO_OBRIGATORIO_ENDERECO_LOGRADOURO = "favor inserir atributo logradouro do objeto Endereco com tamanho limite: 100 caracteres.";
    public static final String OBJETO_OBRIGATORIO_ENDERECO_NUMERO = "favor inserir atributo número do objeto Endereco com tamanho limite: 20 caracteres.";
    public static final String OBJETO_OBRIGATORIO_ENDERECO_BAIRRO = "favor inserir atributo bairro do objeto Endereco com tamanho limite: 100 caracteres.";
    public static final String OBJETO_OBRIGATORIO_ENDERECO_CIDADE = "favor inserir atributo cidade do objeto Endereco com tamanho limite: 100 caracteres.";
    public static final String OBJETO_OBRIGATORIO_ENDERECO_ESTADO = "favor inserir atributo estado do objeto Endereco válido com tamanho limite: 3 caracteres.";
    public static final String OBJETO_OBRIGATORIO_ENDERECO_CEP = "favor inserir atributo cep do objeto Endereco com tamanho limite: 20 caracteres.";
    public static final String OBJETO_OBRIGATORIO_ENDERECO_PAIS = "favor inserir atributo país do objeto Endereco válido com tamanho limite: 3 caracteres.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCAL = "favor inserir objeto NotaFiscal.";
    public static final String OBJETO_OBRIGATORIO_ORIGEM = "favor inserir objeto Origem ou atributo Origem.id do Objeto NotaFiscal | PedidoVenda.";
    public static final String OBJETO_OBRIGATORIO_DATA_LANCAMENTO = "favor inserir atributo dataLancamento.";
    public static final String OBJETO_OBRIGATORIO_DATA_DOCUMENTO = "favor inserir atributo dataDocumento do Objeto NotaFiscal | PedidoVenda.";
    public static final String OBJETO_OBRIGATORIO_VALOR_BRUTO = "favor inserir atributo valorBruto do Objeto NotaFiscal | PedidoVenda.";
    public static final String OBJETO_OBRIGATORIO_VALOR_LIQUIDO = "favor inserir atributo valorLiquido do Objeto NotaFiscal | PedidoVenda.";
    public static final String OBJETO_OBRIGATORIO_DATA_CRIACAO = "favor inserir atributo dataCriacao.";
    public static final String OBJETO_OBRIGATORIO_DATA_ATUALIZACAO = "favor inserir atributo dataAtualizacao.";
    public static final String OBJETO_OBRIGATORIO_CRIADO_POR = "favor inserir atributo criadoPor.";
    public static final String OBJETO_OBRIGATORIO_ATUALIZADO_POR = "favor inserir atributo atualizadoPor.";
    public static final String OBJETO_OBRIGATORIO_DATA_EXPORTACAO = "favor inserir atributo dataExportacao.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCAL_STATUS = "favor inserir atributo status do Objeto NotaFiscal.";
    public static final String OBJETO_OBRIGATORIO_LINHA = "favor inserir objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_ITEM = "favor inserir objeto Item ou atributo Item.id do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_QUANTIDADE = "favor inserir atributo quantidade do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_VALOR = "favor inserir atributo valor do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_CODIGO_IMPOSTO = "favor inserir atributo códigoImposto do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_SERVICO = "favor inserir atributo serviço do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCAL_CONDICAO_PAGAMENTO_DATA_VENCIMENTO = "favor inserir atributo dataVencimento ou Objeto CondicaoPagamento ou atributo CondicaoPagamento.id válido.";
    public static final String OBJETO_OBRIGATORIO_U_DATA_PUBLICACAO_FINAL = "favor inserir atributo uDataPublicacaoFinal do Objeto NotaFiscal | PedidoVenda.";
    public static final String OBJETO_OBRIGATORIO_U_DATA_PUBLICACAO_INICIAL = "favor inserir atributo uDataPublicacaoInicial do Objeto NotaFiscal | PedidoVenda.";
    public static final String OBJETO_OBRIGATORIO_U_DIAS_PUBLICACAO = "favor inserir atributo uDiasPublicacao do Objeto NotaFiscal | PedidoVenda.";
    public static final String OBJETO_OBRIGATORIO_LINHA_VALOR_UNITARIO = "favor inserir atributo valorUnitario do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_U_AREA = "favor inserir atributo uArea do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_U_CMXCOL = "favor inserir atributo uCmXCol do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_U_VALOR_UNITARIO = "favor inserir atributo uValorUnitario do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_U_QUANTIDADE_INSERCOES = "favor inserir atributo uQuantidadeInsercoes do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_U_TOTAL_CMXCOL = "favor inserir atributo uTotalCmXCol do Objeto NotaFiscalSaidaLinha | PedidoVendaLinha.";
    public static final String OBJETO_OBRIGATORIO_LINHA_CONTACONTABIL = "favor inserir atributo contaContabilModel.id do objeto NotaFiscalSaidaLinha | PedidoVendaLinha. ou valor inexistente.";
    public static final String OBJETO_OBRIGATORIO_U_ENDERECO_ENTREGA = "favor inserir atributo uEnderecoEntrega do Objeto NotaFiscalSaida | PedidoVenda.";
    public static final String OBJETO_OBRIGATORIO_CLASSIFICACAO = "favor inserir objeto Classificacao ou Classificacao.id.";
    public static final String ITEM_INEXISTENTE = "favor informar um item válido.";
    public static final String CODIGO_IMPOSTO_INEXISTENTE = "favor informar um codigo de imposto válido.";
    public static final String SEQUENCIA_INEXISTENTE = "favor informar uma sequencia válida.";
    public static final String MUNICIPIO_INEXISTENTE = "favor informar o pais/estado/cidade válido´s.";
    public static final String OBJETO_OBRIGATORIO_COMISSAO_AGENCIA = "favor inserir comissaoAgencia do objeto NotaFiscal | Pedido de venda.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CFOPCODE = "favor inserir Objeto CFOPModel para NotaFiscalSaidaLinha.";
    public static final String CFOP_INEXISTENTE = "favor informar CFOP válido.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CSTCOFINS = "favor inserir objeto cstCOFINSModel para NotaFiscalSaidaLinha.";
    public static final String CSTCOFINS_INEXISTENTE = "favor informar CSTCOFINS válido.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CSTICMS = "favor inserir objeto cstICMSModel para NotaFiscalSaidaLinha.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CSTIPI = "favor inserir objeto cstIPIModel para NotaFiscalSaidaLinha.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_CSTPIS = "favor inserir objeto cstPISModel para NotaFiscalSaidaLinha.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_SECUNDAGEM = "favor informar objeto uSecundagem para NotaFiscalSaidaLinha.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_DESCRICAO = "favor informar objeto descricao para NotaFiscalSaidaLinha.";
    public static final String CSTICMS_INEXISTENTE = "favor informar CSTICMS válido.";
    public static final String CSTIPI_INEXISTENTE = "favor informar CSTIPI válido.";
    public static final String CSTPIS_INEXISTENTE = "favor informar CSTPIS válido.";
    public static final String OBJETO_OBRIGATORIO_U_CONTRATO = "favor informar objeto uContrato para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_U_MES_REFERENCIA = "favor informar objeto uMEsReferencia para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_OBSERVACAO = "favor informar objeto observacao para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_U_OBSERVACAO = "favor informar objeto uObservacao para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_U_ROTEIRO = "favor informar objeto uRoteiro para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_U_BANCA = "favor informar objeto uBanca para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_U_LOTE = "favor informar objeto uLote para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_NUMERONF = "favor informar objeto numeroNF para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_SERIE = "favor informar objeto serie para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_MODELO = "favor informar objeto modelo para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_PERIODO_VEICULACAO = "favor informar objeto periodoVeiculacao para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_DATA_CONTRATO = "favor informar objeto dataContrato para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_ROMANEIO = "favor informar objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_OBRIGATORIO_ID_EXTERNO = "favor informar atributo idExterno.";
    public static final String OBJETO_OBRIGATORIO_ROTEIRO = "favor informar atributo roteiro do objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_OBRIGATORIO_DESCRICAO_ITEM = "favor informar atributo descricao do objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_OBRIGATORIO_DATA_VENDA = "favor informar atributo data do objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_OBRIGATORIO_REPARTE = "favor informar atributo reparte do objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_OBRIGATORIO_ENCALHE = "favor informar atributo encalhe do objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_OBRIGATORIO_VENDA = "favor informar atributo venda do objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_OBRIGATORIO_PRECO_UNITARIO = "favor informar atributo preco do objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_OBRIGATORIO_VALOR_TOTAL = "favor informar atributo valor do objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_ORIGEM_EASYCLASS = "favor informar no atributo id do objeto Origem o valor = 1 ou = 12.";
    public static final String OBJETO_ORIGEM_CLASSIFICADOS = "favor informar no atributo id do objeto Origem o valor=8.";
    public static final String OBJETO_ORIGEM_VENDAAVULSA = "favor informar no atributo id do objeto Origem o valor=2.";
    public static final String OBJETO_ORIGEM_ASSINATURA = "favor informar no atributo id do objeto Origem o valor=3.";
    public static final String OBJETO_ORIGEM_CROSSMIDIA = "favor informar no atributo id do objeto Origem o valor=12.";
    public static final String OBJETO_ORIGEM_FOTOGRAFIA = "favor informar no atributo id do objeto Origem o valor=4.";
    public static final String OBJETO_ORIGEM_ATARDEONLINE = "favor informar no atributo id do objeto Origem o valor=5.";
    public static final String OBJETO_ORIGEM_SVG = "favor informar no atributo id do objeto Origem o valor=6.";
    public static final String OBJETO_ORIGEM_RADIO = "favor informar no atributo id do objeto Origem o valor=99.";
    public static final String OBJETO_OBRIGATORIO_RDJ = "favor informar objeto uRdj para NotaFiscalSaida.";
    public static final String OBJETO_OBRIGATORIO_CONTASRECEBER_VALOR = "favor informar atributo valor para objeto ContasReceberModel.";
    public static final String OBJETO_OBRIGATORIO_DATA_VENCIMENTO = "favor informar atributo dataVencimento.";
    public static final String OBJETO_OBRIGATORIO_PARCELA_ID = "favor informar atributo id do objeto ParcelaNotaFiscalSaidaModel";
    public static final String OBJETO_OBRIGATORIO_PARCELA_NUMERO = "favor informar atributo numero do objeto ParcelaNotaFiscalSaidaModel";
    public static final String OBJETO_OBRIGATORIO_PARCELA_VALORABERTO = "favor informar atributo valorAberto do objeto ParcelaNotaFiscalSaidaModel";
    public static final String OBJETO_OBRIGATORIO_PARCELA_DATAVENCIMENTO = "favor informar atributo dataVencimento do objeto ParcelaNotaFiscalSaidaModel";
    public static final String OBJETO_OBRIGATORIO_BOLETO = "favor informar para o atributo modalidadePagamentoModel o objeto ModalidadePagamentoBoleto.";
    public static final String OBJETO_OBRIGATORIO_FORMAPAGAMENTO = "favor informar formaPagamentoModel ou atributo formaPagamentoModel.id válido.";
    public static final String OBJETO_OBRIGATORIO_DATA_TRANSFERENCIA = "favor informar atributo dataTransferencia.";
    public static final String OBJETO_OBRIGATORIO_CONTACONTABIL = "favor informar objeto contaContabilModel ou contaContabilModel.id válido.";
    public static final String OBJETO_OBRIGATORIO_TRANSFERENCIA = "favor informar para o atributo modalidadePagamentoModel o objeto modalidadePagamentoTransferenciaModel.";
    public static final String OBJETO_OBRIGATORIO_U_TITULO_PUBLICACAO = "favor inserir atributo uTituloPublicacao do Objeto NotaFiscal | PedidoVenda.";
    public static final String OBJETO_OBRIGATORIO_ROMANEIORDJ = "favor informar atributo rdj do objeto VendaAvulsaRomaneioModel.";
    public static final String OBJETO_OBRIGATORIO_TIPOBANCA = "favor informar objeto tipoBanca para NotaFiscalSaida | PedidoVenda. ";
    public static final String OBJETO_OBRIGATORIO_TIPOFATURAMENTO = "favor informar objeto tipoFaturamento para NotaFiscalSaida | PedidoVenda. ";
    public static final String OBJETO_OBRIGATORIO_U_OBSERVACAO = "favor informar objeto uObservacao para NotaFiscalSaida|PedidoVenda com tamanho maximo de 250 caracteres.";
    public static final String ERRO_TI = "Nff nao inserida. Favor contactar a TI.";
    public static final String NOTAFISCAL = "Favor instanciar Nff de Saida. ";
    public static final String PEDIDOVENDA = "Favor instanciar Pedido de venda. ";
    public static final String OBJETO_OBSERVACAO_FOTOGRAFIA = "Favor informar atributo observacao do objeto NotaFiscal. ";
    public static final String NOTAFISCALEXPORTADA = "Nota Fiscal ja existe na base Produção. Favor cancelar antes de exportar novamente.";
    public static final String PEDIDOVENDAEXPORTADA = "Pedido de venda ja existe na base Produção. Favor cancelar antes de exportar novamente.";
    public static final String OBJETO_UOBSERVACAO_FOTOGRAFIA = "Favor informar atributo uObservacao do objeto NotaFiscal. ";
    public static final String OBJETO_OBRIGATORIO_EMAIL = "Favor informar atributo email do objeto ClienteCobranca. ";
    public static final String NOTAFISCAL_ID = "Favor informar id ao Objeto NotaFiscalSaida.";
    public static final String DEVOLUCAONOTAFISCAL = "Favor instanciar DevolucaoNotaFiscalSaida.";
    public static final String PARCEIRO_NEGOCIO_CONTA_BANCO = "Favor informar objeto ClienteContaBanco ao ClienteModel.";
    public static final String PARCEIRO_NEGOCIO_CODIGO_BANCO = "Favor informar atributo codigoBanco ao objeto ClienteContaBancoModel.";
    public static final String PARCEIRO_NEGOCIO_DIGITO_AGENCIA = "Favor informar atributo digitoAgencia ao objeto ClienteContaBancoModel.";
    public static final String PARCEIRO_NEGOCIO_DIGITO_CONTA = "Favor informar atributo digitoConta ao objeto ClienteContaBancoModel.";
    public static final String PARCEIRO_NEGOCIO_NUMERO_AGENCIA = "Favor informar atributo numeroAgencia ao objeto ClienteContaBancoModel.";
    public static final String PARCEIRO_NEGOCIO_NUMERO_CONTA = "Favor informar atributo numeroConta ao objeto ClienteContaBancoModel.";
    public static final String PARCEIRO_NEGOCIO_TIPO_CONTA = "Favor informar atributo tipoConta(ContaCorrente=1 / Poupanca=2) ao objeto ClienteContaBancoModel.";
    public static final String PARCEIRO_NEGOCIO_SAP_EMAIL = "Favor atribuir email ao parceiro no SAP. Cardcode=";
    public static final String CONTAS_RECEBER = "Favor instanciar objeto ContasReceber.";
    public static final String CONTAS_RECEBER_ID = "Favor instanciar atributo id do objeto ContasReceber atribuir valor diferente de 0(zero).";
    public static final String CODIGO_ASSINANTE = "Favor informar atributo uCodigoAssinante.";
    public static final String PONTO_REFERENCIA = "Favor informar atributo uPontoReferencia.";
    public static final String PARCELA_ID = "Favor informar objeto ParcelaNotaFiscalSaidaModel ao objeto ContasReceberNodel ou um valor valido.";
    public static final String CANCELACONTASRECEBER = "Favor informar objeto CancelaContasReceberModel.";
    public static final String CANCELACONTASRECEBER_ID = "Favor informar atributo id do objeto  CancelaContasReceberModel ou valor é invalido.";
    public static final String HISTORICOATOLNOTAFISCALSAIDAMODEL = "Favor instanciar objeto HistoricoAtolNotaFiscalSaidaModel.";
    public static final String HISTORICOEASYCLASSNOTAFISCALSAIDAMODEL = "Favor instanciar objeto HistoricoEasyclassNotaFiscalSaidaModel.";
    public static final String HISTORICOCLASSIFICADOSCONTRATONOTAFISCALSAIDAMODEL = "Favor instanciar objeto HistoricoClassificadosContratoNotaFiscalSaidaModel.";
    public static final String HISTORICOCLASSIFICADOSEXECUCAONOTAFISCALSAIDAMODEL = "Favor instanciar objeto HistoricoClassificadosExecucaoNotaFiscalSaidaModel.";
    public static final String HISTORICOCOBRANCANOTAFISCALSAIDAMODEL = "Favor instanciar objeto HistoricoCobrancaNotaFiscalSaidaModel.";
    public static final String HISTORICOASSINATURANOTAFISCALSAIDAMODEL = "Favor instanciar objeto HistoricoAssinaturaNotaFiscalSaidaModel.";
    public static final String HISTORICOFOTOGRAFIANOTAFISCALSAIDAMODEL = "Favor instanciar objeto HistoricoFotografiaNotaFiscalSaidaModel.";
    public static final String HISTORICOSVGNOTAFISCALSAIDAMODEL = "Favor instanciar objeto HistoricoSvgNotaFiscalSaidaModel.";
    public static final String HISTORICOVENDAAVULSANOTAFISCALSAIDAMODEL = "Favor instanciar objeto HistoricoVendaAvulsaNotaFiscalSaidaModel.";
    public static final String ATOLNOTAFISCALSAIDAMODEL = "Favor instanciar objeto AtolNotaFiscalSaidaModel.";
    public static final String EASYCLASSNOTAFISCALSAIDAMODEL = "Favor instanciar objeto EasyclassNotaFiscalSaidaModel.";
    public static final String RADIONOTAFISCALSAIDAMODEL = "Favor instanciar objeto RadioNotaFiscalSaidaModel.";
    public static final String CLASSIFICADOSCONTRATONOTAFISCALSAIDAMODEL = "Favor instanciar objeto ClassificadosContratoNotaFiscalSaidaModel.";
    public static final String CLASSIFICADOSEXECUCAONOTAFISCALSAIDAMODEL = "Favor instanciar objeto ClassificadosExecucaoNotaFiscalSaidaModel.";
    public static final String ASSINATURANOTAFISCALSAIDAMODEL = "Favor instanciar objeto AssinaturaNotaFiscalSaidaModel.";
    public static final String FOTOGRAFIANOTAFISCALSAIDAMODEL = "Favor instanciar objeto FotografiaNotaFiscalSaidaModel.";
    public static final String SVGNOTAFISCALSAIDAMODEL = "Favor instanciar objeto SVGNotaFiscalSaidaModel.";
    public static final String VENDAAVULSANOTAFISCALSAIDAMODEL = "Favor instanciar objeto VendaAvulsaNotaFiscalSaidaModel.";
    public static final String OBJETO_ORIGEM_COBRANCA = "favor informar no atributo id do objeto Origem o valor=10.";
    public static final String COBRANCANOTAFISCALSAIDAMODEL = "Favor instanciar objeto CobrancaNotaFiscalSaidaModel.";
    public static final String SAIDAMERCADORIA = "Favor instanciar objeto SaidaMercadoriaModel.";
    public static final String OBJETO_OBRIGATORIO_SAIDAMERCADORIA_LINHA = "Favor instanciar Lista SaidaMercadoriaLinhaModel. ";
    public static final String OBJETO_OBRIGATORIO_REGRA_DISTRIBUICAO = "Favor instanciar objeto RegraDistribuicaoModel ou regraDistribuicaoModdel.id invalido para dimensao desejada.";
    public static final String OBJETO_OBRIGATORIO_DIMENSAO = "Favor instanciar objeto DimensaoModel ou dimensao invalida.";
    public static final String QUANTIDADE = "Favor informar quantidade > 0.";
    public static final String DESPESA_ADICIONAL_LIST = "Favor instanciar Lista DespesaAdicionalModel ou adicionar um objeto do tipo DespesaAdicionalModel a esta lista.";
    public static final String DESPESA_ADICIONAL_CODIGO = "Favor informar atributo codigo(para Juros=2).";
    public static final String DESPESA_ADICIONAL_VALOR = "Favor informar atributo valor do Objeto DespesaAdicionalModel.";
    public static final String OBJETO_OBRIGATORIO_NOTAFISCAL_U_NUMERO_PI = "Favor informar atributo uNumeroPI ao objeto NotaFiscalSaida.";
    public static final String CLASSE_INVALIDA = " Classe instanciada invalida.";
    public static final String CONTAS_RECEBER_BOLETO_REJEITADO_MODEL = "Favor instanciar objeto ContasReceberBoletoRejeitadoModel. ";
    public static final String CONTAS_RECEBER_BOLETO_REJEITADO_MODEL_ID = "Favor informar atributo id.";

    public static final String PARCEIRO_NEGOCIO_ENDERECO_ID = "Favor inserir atributo parceiroNegocio.endereco.id válido.";
    public static final String PARCEIRO_NEGOCIO_TELEFONE_CELULAR = "Favor inserir atributo parceiroNegocio.celular com tamanho limite: 15 caracteres.";

    public static final String PARCEIRO_NEGOCIO_TELEFONE_OBRIGATORIO = "Favor inserir atributo parceiroNegocio.celular ou parceiroNegocio.telefoneResidencial.";

    public static final String PARCEIRO_NEGOCIO_TELEFONE_RESIDENCIAL = "Favor inserir atributo parceiroNegocio.telefoneResidencial com tamanho limite: 15 caracteres.";

    public static final String PARCEIRO_NEGOCIO_INSCRICAO_INSS = "Favor inserir atributo parceiroNegocio.identificadorFiscal.inscricaoINSS com tamanho limite: 15 caracteres.";

    public static final String PARCEIRO_NEGOCIO_INSCRICAO_MUNICIPAL = "Favor inserir atributo parceiroNegocio.identificadorFiscal.inscricaoMunicipal com tamanho limite: 15 caracteres.";

    public static final String PARCEIRO_NEGOCIO_INSCRICAO_ESTADUAL_SUBSTITUTO_TRIBUTARIA = "Favor inserir atributo parceiroNegocio.identificadorFiscal.inscricaoEstadualSubstitutoTributaria com tamanho limite: 15 caracteres.";

    public static final String PARCEIRO_NEGOCIO_INSCRICAO_ESTADUAL = "Favor inserir atributo parceiroNegocio.identificadorFiscal.inscricaoEstadual com tamanho limite: 15 caracteres.";

    public static final String OBJETO_OBRIGATORIO_PARCEIRO_NEGOCIO = "Favor inserir objeto ParceiroNegocio ou parceiroNegocio.id válido.";

    public static final String PARCEIRO_NEGOCIO_NOME_FANTASIA = "Favor inserir atributo parceiroNegocio.nomeFantasia com tamanho limite: 100 caracteres.";

    public static final String PARCEIRO_NEGOCIO_TELEFONE_EMAIL = "Favor inserir atributo parceiroNegocio.email com tamanho limite: 50 caracteres.";

    public static final String PARCEIRO_NEGOCIO_TELEFONE_FAX = "Favor inserir atributo parceiroNegocio.fax com tamanho limite: 15 caracteres.";

    public static final String PARCEIRO_NEGOCIO_OBSERVACAO = "Favor inserir atributo parceiroNegocio.observacao com tamanho limite: 100 caracteres.";

    public static final String OBJETO_OBRIGATORIO_NOTAFISCALSAIDA_LINHA_ITEM_ESTOQUE = "Favor inserir objeto Item.estoque ou atributo Item.estoque.id do Objeto DocumentoLinhaAB válido.";

    public static final String OBJETO_OBRIGATORIO_LINHA_UTILIZACAO = "Favor inserir atributo utilizacao do Objeto DocumentoLinhaAB ou utilizacao.id válido.";

    public static final String OBJETO_NOTAFISCAL_DATA_VENCIMENTO_MENOR_DATA_DOCUMENTO = "Data de vencimento não pode ser inferior a data de documento no Objeto DocumentoAB. ";
}
