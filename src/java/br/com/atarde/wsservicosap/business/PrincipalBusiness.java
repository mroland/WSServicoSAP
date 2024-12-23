/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atarde.wsservicosap.business;

import br.com.atarde.wsservicosap.model.AssinaturaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.AtolNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.ClassificadosContratoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.ClassificadosExecucaoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.ContasReceberModel;
import br.com.atarde.wsservicosap.model.EasyclassNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.FotografiaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoAssinaturaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoAtolNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoEasyclassNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoFotografiaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoSvgNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoVendaAvulsaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.NotaFiscalSaidaABModel;
import br.com.atarde.wsservicosap.model.ParcelaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.SaidaMercadoriaModel;
import br.com.atarde.wsservicosap.model.SvgNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.VendaAvulsaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.CobrancaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoClassificadosContratoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoClassificadosExecucaoNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.HistoricoCobrancaNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.model.RadioNotaFiscalSaidaModel;
import br.com.atarde.wsservicosap.util.Constantes;
import br.com.topsys.exception.TSApplicationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mroland
 */
public class PrincipalBusiness {

    public String inserirEasyclassNotaFiscalSaida(EasyclassNotaFiscalSaidaModel model) {

        try {

            return new EasyclassNotaFiscalSaidaBusiness(model).insertEvent();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public String inserirRadioNotaFiscalSaida(RadioNotaFiscalSaidaModel model) {

        try {

            return new RadioNotaFiscalSaidaBusiness(model).insertEvent();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }
   
    public String inserirClassificadosNotaFiscalSaida(NotaFiscalSaidaABModel model) {

        try {

            if (model instanceof ClassificadosContratoNotaFiscalSaidaModel) {

                return new ClassificadosContratoNotaFiscalSaidaBusiness((ClassificadosContratoNotaFiscalSaidaModel)model).insertEvent();

            } else {

                if (model instanceof ClassificadosExecucaoNotaFiscalSaidaModel) {

                    return new ClassificadosExecucaoNotaFiscalSaidaBusiness((ClassificadosExecucaoNotaFiscalSaidaModel)model).insertEvent();
                    
                }else{
                    
                    return Constantes.CLASSE_INVALIDA;
                    
                }

            }

            
        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public String inserirVendaAvulsaNotaFiscalSaida(VendaAvulsaNotaFiscalSaidaModel model) {

        try {

            return new VendaAvulsaNotaFiscalSaidaBusiness(model).insertEvent();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;


    }

    public String inserirAssinaturaNotaFiscalSaida(AssinaturaNotaFiscalSaidaModel model) {

        try {

            return new AssinaturaNotaFiscalSaidaBusiness(model).insertEvent();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;

    }

    public String inserirFotografiaNotaFiscalSaida(FotografiaNotaFiscalSaidaModel model) {

        try {

            return new FotografiaNotaFiscalSaidaBusiness(model).insertEvent();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;

    }

    public String inserirAtolNotaFiscalSaida(AtolNotaFiscalSaidaModel model) {

        try {

            return new AtolNotaFiscalSaidaBusiness(model).insertEvent();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public String inserirSvgNotaFiscalSaida(SvgNotaFiscalSaidaModel model) {

        try {

            return new SvgNotaFiscalSaidaBusiness(model).insertEvent();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public List<NotaFiscalSaidaABModel> pesquisarNotaFiscalSaidaInterface(NotaFiscalSaidaABModel model) throws TSApplicationException {

        List<NotaFiscalSaidaABModel> notaFiscalSaidaModelList = new ArrayList<NotaFiscalSaidaABModel>();

        if (model instanceof EasyclassNotaFiscalSaidaModel) {

            notaFiscalSaidaModelList.addAll(new EasyclassNotaFiscalSaidaBusiness().pesquisar((EasyclassNotaFiscalSaidaModel) model));

        } else {

            if (model instanceof AtolNotaFiscalSaidaModel) {

                notaFiscalSaidaModelList.addAll(new AtolNotaFiscalSaidaBusiness().pesquisar((AtolNotaFiscalSaidaModel) model));

            } else {

                if (model instanceof AssinaturaNotaFiscalSaidaModel) {

                    notaFiscalSaidaModelList.addAll(new AssinaturaNotaFiscalSaidaBusiness().pesquisar((AssinaturaNotaFiscalSaidaModel) model));

                } else {

                    if (model instanceof FotografiaNotaFiscalSaidaModel) {

                        notaFiscalSaidaModelList.addAll(new FotografiaNotaFiscalSaidaBusiness().pesquisar((FotografiaNotaFiscalSaidaModel) model));

                    } else {

                        if (model instanceof SvgNotaFiscalSaidaModel) {

                            notaFiscalSaidaModelList.addAll(new SvgNotaFiscalSaidaBusiness().pesquisar((SvgNotaFiscalSaidaModel) model));

                        } else {

                            if (model instanceof VendaAvulsaNotaFiscalSaidaModel) {

                                notaFiscalSaidaModelList.addAll(new VendaAvulsaNotaFiscalSaidaBusiness().pesquisar((VendaAvulsaNotaFiscalSaidaModel) model));

                            } else {

                                if (model instanceof CobrancaNotaFiscalSaidaModel) {

                                    notaFiscalSaidaModelList.addAll(new CobrancaNotaFiscalSaidaBusiness().pesquisar((CobrancaNotaFiscalSaidaModel) model));

                                }else{
                                    
                                    if (model instanceof ClassificadosContratoNotaFiscalSaidaModel){
                                        
                                        notaFiscalSaidaModelList.addAll(new ClassificadosContratoNotaFiscalSaidaBusiness().pesquisar((ClassificadosContratoNotaFiscalSaidaModel)model));
                                        
                                    }else{
                                        
                                        if (model instanceof ClassificadosExecucaoNotaFiscalSaidaModel){
                                            
                                            notaFiscalSaidaModelList.addAll(new ClassificadosExecucaoNotaFiscalSaidaBusiness().pesquisar((ClassificadosExecucaoNotaFiscalSaidaModel)model));
                                            
                                        }
                                        
                                    }
                                    
                                    
                                    
                                }


                            }

                        }

                    }
                }
            }

        }

        return notaFiscalSaidaModelList;

    }

    public List<NotaFiscalSaidaABModel> pesquisarHistoricoNotaFiscalSaidaInterface(NotaFiscalSaidaABModel model) throws TSApplicationException {

        List<NotaFiscalSaidaABModel> notaFiscalSaidaModelList = new ArrayList<NotaFiscalSaidaABModel>();


        if (model instanceof HistoricoEasyclassNotaFiscalSaidaModel) {

            notaFiscalSaidaModelList.addAll(new HistoricoEasyclassNotaFiscalSaidaBusiness().pesquisar((HistoricoEasyclassNotaFiscalSaidaModel) model));

        } else {

            if (model instanceof HistoricoAtolNotaFiscalSaidaModel) {

                notaFiscalSaidaModelList.addAll(new HistoricoAtolNotaFiscalSaidaBusiness().pesquisar((HistoricoAtolNotaFiscalSaidaModel) model));

            } else {

                if (model instanceof HistoricoAssinaturaNotaFiscalSaidaModel) {

                    notaFiscalSaidaModelList.addAll(new HistoricoAssinaturaNotaFiscalSaidaBusiness().pesquisar((HistoricoAssinaturaNotaFiscalSaidaModel) model));

                } else {

                    if (model instanceof HistoricoFotografiaNotaFiscalSaidaModel) {

                        notaFiscalSaidaModelList.addAll(new HistoricoFotografiaNotaFiscalSaidaBusiness().pesquisar((HistoricoFotografiaNotaFiscalSaidaModel) model));

                    } else {

                        if (model instanceof HistoricoSvgNotaFiscalSaidaModel) {

                            notaFiscalSaidaModelList.addAll(new HistoricoSvgNotaFiscalSaidaBusiness().pesquisar((HistoricoSvgNotaFiscalSaidaModel) model));

                        } else {

                            if (model instanceof HistoricoVendaAvulsaNotaFiscalSaidaModel) {

                                notaFiscalSaidaModelList.addAll(new HistoricoVendaAvulsaNotaFiscalSaidaBusiness().pesquisar((HistoricoVendaAvulsaNotaFiscalSaidaModel) model));

                            } else {

                                if (model instanceof HistoricoCobrancaNotaFiscalSaidaModel) {

                                    notaFiscalSaidaModelList.addAll(new HistoricoCobrancaNotaFiscalSaidaBusiness().pesquisar((HistoricoCobrancaNotaFiscalSaidaModel) model));

                                }else{
                                    
                                    if (model instanceof HistoricoClassificadosContratoNotaFiscalSaidaModel){
                                        
                                        notaFiscalSaidaModelList.addAll(new HistoricoClassificadosContratoNotaFiscalSaidaBusiness().pesquisar((HistoricoClassificadosContratoNotaFiscalSaidaModel)model));
                                        
                                    }else{
                                        
                                        if (model instanceof HistoricoClassificadosExecucaoNotaFiscalSaidaModel){
                                            
                                            notaFiscalSaidaModelList.addAll(new HistoricoClassificadosExecucaoNotaFiscalSaidaBusiness().pesquisar((HistoricoClassificadosExecucaoNotaFiscalSaidaModel)model));
                                            
                                        }
                                        
                                    }
                                    
                                    
                                    
                                }


                            }

                        }

                    }
                }
            }

        }


        return notaFiscalSaidaModelList;

    }

    public String inserirBoleto(ContasReceberModel model) {

        return new ContasReceberBusiness(model).inserirBoleto();

    }

    public String inserirTransferencia(ContasReceberModel model) {

        return new ContasReceberBusiness(model).inserirTransferencia();

    }

    public List<ParcelaNotaFiscalSaidaModel> pesquisarParcelaAberta(ParcelaNotaFiscalSaidaModel model) throws TSApplicationException {

        return new ParcelaNotaFiscalSaidaBusiness().pesquisarParcelaAberta(model);

    }

    public List<ParcelaNotaFiscalSaidaModel> pesquisarParcelaPaga(ParcelaNotaFiscalSaidaModel model) throws TSApplicationException {

        return new ParcelaNotaFiscalSaidaBusiness().pesquisarParcelaPaga(model);

    }

    public String inserirDebitoConta(ContasReceberModel model) {

        return new ContasReceberBusiness(model).inserirDebitoConta();

    }

    public String inserirCobrancaNotaFiscalSaida(CobrancaNotaFiscalSaidaModel model) {

        try {

            return new CobrancaNotaFiscalSaidaBusiness(model).insertEvent();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

    public String inserirSaidaMercadoria(SaidaMercadoriaModel model) {

        return new SaidaMercadoriaBusiness(model).insertEvent();

    }

    public String cancelarSaidaMercadoria(SaidaMercadoriaModel model) {

        return new SaidaMercadoriaBusiness(model).deleteEvent();

    }
}
