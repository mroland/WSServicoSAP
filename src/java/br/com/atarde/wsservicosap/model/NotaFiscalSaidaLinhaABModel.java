package br.com.atarde.wsservicosap.model;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public abstract class NotaFiscalSaidaLinhaABModel implements Serializable {

    private Long id;
    private Long interfaceId;
    private ItemModel itemModel;
    private Double quantidade;
    private BigDecimal valor;
    private CodigoImpostoModel codigoImpostoModel;
    private NotaFiscalSaidaABModel notaFiscalSaidaModel;
    private CSTModel cstICMSModel;
    private CSTModel cstPISModel;
    private EmpresaModel empresaModel;

    private CSTModel cstIPIModel;
    private CSTModel cstCOFINSModel;
    private UtilizacaoModel utilizacaoModel;
    private EstoqueModel estoqueModel;

    public UtilizacaoModel getUtilizacaoModel() {
        return utilizacaoModel;
    }

    public void setUtilizacaoModel(UtilizacaoModel utilizacaoModel) {
        this.utilizacaoModel = utilizacaoModel;
    }

    public CodigoImpostoModel getCodigoImpostoModel() {
        return codigoImpostoModel;
    }

    public void setCodigoImpostoModel(CodigoImpostoModel codigoImpostoModel) {
        this.codigoImpostoModel = codigoImpostoModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemModel getItemModel() {
        return itemModel;
    }

    public void setItemModel(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

    public NotaFiscalSaidaABModel getNotaFiscalSaidaModel() {
        return notaFiscalSaidaModel;
    }

    public void setNotaFiscalSaidaModel(NotaFiscalSaidaABModel notaFiscalSaidaModel) {
        this.notaFiscalSaidaModel = notaFiscalSaidaModel;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public CSTModel getCstCOFINSModel() {
        return cstCOFINSModel;
    }

    public void setCstCOFINSModel(CSTModel cstCOFINSModel) {
        this.cstCOFINSModel = cstCOFINSModel;
    }

    public CSTModel getCstICMSModel() {
        return cstICMSModel;
    }

    public void setCstICMSModel(CSTModel cstICMSModel) {
        this.cstICMSModel = cstICMSModel;
    }

    public CSTModel getCstIPIModel() {
        return cstIPIModel;
    }

    public void setCstIPIModel(CSTModel cstIPIModel) {
        this.cstIPIModel = cstIPIModel;
    }

    public CSTModel getCstPISModel() {
        return cstPISModel;
    }

    public void setCstPISModel(CSTModel cstPISModel) {
        this.cstPISModel = cstPISModel;
    }

    public EmpresaModel getEmpresaModel() {
        return empresaModel;
    }

    public void setEmpresaModel(EmpresaModel empresaModel) {
        this.empresaModel = empresaModel;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public EstoqueModel getEstoqueModel() {
        return estoqueModel;
    }

    public void setEstoqueModel(EstoqueModel estoqueModel) {
        this.estoqueModel = estoqueModel;
    }

}
