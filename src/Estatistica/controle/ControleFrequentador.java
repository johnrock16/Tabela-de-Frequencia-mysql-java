/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.controle;

import Estatistica.dao.FrequentadorDAO;
import Estatistica.modelo.Frequentador;
import Estatistica.modelo.InfosTabela;
import Estatistica.modelo.ModeloFrequentadorBanco;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Classe de controle indireto de ações relacionadas ao Frequentador (Com tratamento)
 * @author User
 */
public class ControleFrequentador extends ModeloFrequentadorBanco {

    public FrequentadorDAO DAO;

    /**
     * Emite os erros de acordo com as constantes do modelo do banco.
     *
     * @param - Campo ao qual percernce orro.
     */
    private static void errosDosCampos(int i) throws Exception {
        switch (i) {
            case ID:
                throw new NumberFormatException("!!ID inválido!!");
            case SEXO:
                throw new Exception("!!Sexo inválido!!");
            case IDADE:
                throw new NumberFormatException("!!Idade inválida!!");
            case FREQUENCIA_SEMANAL:
                System.err.println("3");
                throw new NumberFormatException("!!Frequência semanal inválida!!");
            case ESTADO_CIVIL:
                throw new Exception("!!Estado civíl inválido!!");
            case MEIO_DE_TRANSPORTE:
                throw new Exception("!!Meio de transporte inválido!!");
            case TEMPO_PERMANENCIA:
                throw new NumberFormatException("!!Frequência semanal inválida!!");
            case RENDA_FAMILIAR:
                throw new NumberFormatException("!!Renda Familiar inválida!!");
        }
    }

    /**
     * Controle de ação para cadastro de Frequentadores;
     *
     * @param vars - Array de componentes como no Modelo do Banco (CAMPOS)
     */
    public static void cadastrarFreq(Object vars[]) {
        try {
            Frequentador fr = new Frequentador();
            FrequentadorDAO frdao = new FrequentadorDAO();

            //Versão comprimirda
            for (int i = 0; i < CAMPOS.length; i++) {
                if (i == IDADE || i == FREQUENCIA_SEMANAL || i == TEMPO_PERMANENCIA) {
                    if (!Controle.isNumberInt(vars[i].toString())) {
                        errosDosCampos(i);
                    }
                    if (0 >= Integer.parseInt(vars[i].toString())) {
                        errosDosCampos(i);
                    }
                } else if (1 == RENDA_FAMILIAR) {
                    if (!Controle.isNumber(vars[i].toString())) {
                        errosDosCampos(i);
                    } else if (0 >= Float.parseFloat(vars[i].toString())) {
                        errosDosCampos(i);
                    }
                }
            }
            fr.preencherSemID(vars.clone());

            //Versão detalhada
            /*
            fr.setSexo(vars[SEXO].toString());
            try {
                fr.setIdade(Integer.parseInt(vars[IDADE].toString()));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("!!Idade inválida!!");
            }
            try {
                fr.setFrequenciaSemanal(Integer.parseInt(vars[FREQUENCIA_SEMANAL].toString()));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("!!Frequencia Semanal inválida!!");
            }
            fr.setEstadoCivil(vars[ESTADO_CIVIL].toString());
            fr.setMeioDeTransporte(vars[MEIO_DE_TRANSPORTE].toString());
            try {
                fr.setTempoPermanencia(Integer.parseInt(vars[TEMPO_PERMANENCIA].toString()));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("!!Tempo de permanencia inválido!!");
            }
            try {
                fr.setRendaFamiliar(Float.parseFloat(vars[RENDA_FAMILIAR].toString()));
            } catch (NumberFormatException numberFormatException) {
                throw new NumberFormatException("!!Renda Familiar inválida!!");
            }*/
            frdao.cadastrarFrequentador(fr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Controle de ação para Alteração de Frequentadores;
     *
     * @param vars - Array de componentes como no Modelo do Banco (CAMPOS)
     */
    public static void alterarFreq(Object vars[]) {
        try {
            Frequentador fr = new Frequentador();
            FrequentadorDAO frdao = new FrequentadorDAO();

            for (int i = 0; i < CAMPOS.length; i++) {
                if (i == ID || i == IDADE || i == FREQUENCIA_SEMANAL || i == TEMPO_PERMANENCIA) {
                    if (!Controle.isNumberInt(vars[i].toString())) {
                        errosDosCampos(i);
                    }
                    if (0 >= Integer.parseInt(vars[i].toString())) {
                        errosDosCampos(i);
                    }
                } else if (1 == RENDA_FAMILIAR) {
                    if (!Controle.isNumber(vars[i].toString())) {
                        errosDosCampos(i);
                    } else if (0 >= Float.parseFloat(vars[i].toString())) {
                        errosDosCampos(i);
                    }
                }
            }

            fr.preencherPorCompleto(vars);
            frdao.alterarFrequentador(fr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Controle de ação para pesquisar Frequentadores(Com Jtable e JComboBox)
     *
     * @param campo1 Primeiro campo
     * @param campo2 Segundo campo
     * @param info Informação pesquisada
     * @param tblInfos Tabela de Exibição
     * @param jCB Caixa de seleção de opções de pesquisa
     */
    public static void pesquisarFreq(String campo1, String campo2, String info, JTable tblInfos, JComboBox jCB) {
        try {
            List<InfosTabela> tabela;
            DecimalFormat df = new DecimalFormat("##.00");
            switch (jCB.getSelectedIndex()) {
                case 0:
                    break;
                case 2:
                    break;
                case 3:
                    tabela = tabelaFrequenciaIntervalos(campo1);
//                    //visualizar
//                    for (InfosTabela inf : tabela) {
//                        System.out.println(inf.getIntervalo() + "  " + df.format(inf.getKi()) + " " + inf.getFa() + "  " + inf.getFr()
//                                + " " + df.format(inf.getFrPCento()) + " " + inf.getFac() + " " + df.format(inf.getFacPCento()));
//                    }
                    tblInfos.setModel(preencherJTableIntervalo(tabela, tblInfos));
                    break;
                case 4:
                    tabela = tabelaFrequencia(campo1);
//                    //visualizar
//                    for (InfosTabela inf : tabela) {
//                        System.out.println(inf.getIntervalo() + " " + inf.getFa() + "  " + inf.getFr()
//                                + " " + df.format(inf.getFrPCento()) + " " + inf.getFac() + " " + df.format(inf.getFacPCento()));
//                    }
                    tblInfos.setModel(preencherJTableIntervalo(tabela, tblInfos));
                    break;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Controle de ação para pesquisar Frequentadores (Simples)
     *
     * @param campo Campo alvo da pesquisa
     * @param info Informação pesquisada
     */
    public static void pesquisarFreq(String campo, String info) {
        try {
            FrequentadorDAO frdao = new FrequentadorDAO();

            /*List frequentador=new ArrayList<Frequentador>();
            frequentador=frdao.getListFrequentadorPorInfo(txtcampo.getText(), txtinfo.getText());
        
            for(int i=0;i<frequentador.size();i++){
                System.out.println(frequentador.get(i));
            }
             */
            List<Frequentador> lista = frdao.getListFrequentadorPorInfo(campo, info);
            for (Frequentador f : lista) {
                System.out.println(f.getId() + "  " + f.getSexo() + " " + f.getIdade() + "  " + f.getFrequenciaSemanal()
                        + " " + f.getEstadoCivil() + " " + f.getMeioDeTransporte() + " " + f.getTempoPermanencia() + " " + f.getRendaFamiliar());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Preenche a Tabela usando o intervalo
     * @param info Lista de informações que serão inseridas
     * @param tabela Tabela alvo das informações
     * @return Modelo formatado para a tabela
     */
    public static DefaultTableModel preencherJTableIntervalo(List<InfosTabela> info, JTable tabela) {
        //Aqui carrego minha lista
        DefaultTableModel modeloTable = (DefaultTableModel) tabela.getModel();

        //Aqui verifico se a jTable tem algum registo se tiver eu deleto
        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }

        //Aqui eu adiciono cada linha da lista na jTable
        for (InfosTabela inf : info) {
            modeloTable.addRow(new Object[]{inf.getIntervalo(),
                inf.getKi(), inf.getFa(),
                inf.getFr(), inf.getFrPCento(),
                inf.getFac(), inf.getFrPCento()});
        }
        return modeloTable;
    }

    // tabela com 2 infos completa
    /**
     *  Faz a tabela com 2 infos completa
     * @param tabela2infos Lista de informações
     * @return Lista para tabela
     */
    public static List<InfosTabela> tabela2InfosNumeros(List<InfosTabela> tabela2infos) {

        List tabela = new ArrayList<>();
        String[][] verifica = new String[tabela2infos.size()][2];
        int vezes = 0;
        int start = 0;
        int pos = 0;

        for (InfosTabela inf : tabela2infos) {

            verifica[pos][0] = inf.getCampo1();
            verifica[pos][1] = inf.getCampo2();
            pos += 1;

        }
        System.out.println("novo");
        for (int i = 0; i < verifica.length - 1; i++) {
            System.out.println(verifica[i][0] + "  " + verifica[i][1]);
        }

        System.out.print("\n Frequencia dos numeros \n");
        int cont = 1;
        int espera = 0;
        String campo2 = "";
        String campo1 = "";
        for (int i = 0; i < verifica.length; i++) {
            cont = 0;
            for (int j = 0; j < verifica.length; j++) {
                if (verifica[i][0].equals(verifica[j][0])) {
                    if (verifica[i][1].equals(verifica[j][1])) {
                        cont++;
                    }
                    campo2 = verifica[i][1];
                    campo1 = verifica[i][0];

                }

            }
            espera += 1;
            if (espera == cont) {
                InfosTabela inf = new InfosTabela();
                inf.setCampo1(campo1);
                inf.setCampo2(campo2);
                inf.setCampoNumero("" + cont);
                tabela.add(inf);
                espera = 0;
            }

        }

        return tabela;
    }

    /**
     * Faz a tabela frequencia
     * @param campo Campo alvo da pesquisa
     * @return Lista de informações
     */
    public static List<InfosTabela> tabelaFrequencia(String campo) {
        InfosTabela inf = new InfosTabela();
        List tabela = new ArrayList<>();
        try {
            FrequentadorDAO fdao = new FrequentadorDAO();
            List<InfosTabela> intervalos = fdao.pegarStringIntervalo(campo);
            double qtdItens = fdao.qtdItens(campo);
            int acumulada = 0;

            for (InfosTabela infT : intervalos) {
                InfosTabela infos = new InfosTabela();
                infos.setIntervalo(infT.getIntervalo());
                infos.setFa(fdao.pegarFa(inf, campo, infos.getIntervalo()));
                infos.setFr(infos.getFa() / qtdItens);
                infos.setFrPCento(infos.getFr() * 100);

                acumulada += infos.getFa();

                infos.setFac(acumulada);
                infos.setFacPCento((infos.getFac() / qtdItens) * 100);

                tabela.add(infos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e, "Alert", JOptionPane.ERROR_MESSAGE);
        }
        return tabela;
    }

    // tabela de frequencias sobre 1 coluna
    /**
     * Faz a tabela de frequencias sobre 1 coluna
     * @param campo Campo alvo da pesquisa
     * @return Lista de informações
     */
    public static List<InfosTabela> tabelaFrequenciaIntervalos(String campo) {
        InfosTabela inf = new InfosTabela();
        List tabela = new ArrayList<>();
        try {
            FrequentadorDAO fdao = new FrequentadorDAO();
            double qtdItens = fdao.qtdItens(campo);
            double k = Math.ceil(Math.sqrt(qtdItens));
            double at, h;
            double InicioIntervalo, FimIntervalo;
            int acumulada = 0;

            fdao.pegarMenorEMaiorValor(inf, campo);

            at = inf.getMaiorValor() - inf.getMenorValor();
            h = Math.ceil(at / k);

            //System.out.println(k);
            //System.out.println(inf.getMenorValor());
            //System.out.println(inf.getMaiorValor());
            //System.out.println(at);
            //System.out.println(h);
            InicioIntervalo = inf.getMenorValor();
            FimIntervalo = InicioIntervalo + h;

            for (int i = 0; i < k; i++) {
                InfosTabela infos = new InfosTabela();
                infos.setIntervalo(InicioIntervalo + "|-------" + FimIntervalo);
                infos.setKi((InicioIntervalo + FimIntervalo) / 2);
                infos.setFa(fdao.pegarFa(inf, campo, InicioIntervalo, FimIntervalo));
                infos.setFr(infos.getFa() / qtdItens);
                infos.setFrPCento(infos.getFr() * 100);

                acumulada += infos.getFa();

                infos.setFac(acumulada);
                infos.setFacPCento((infos.getFac() / qtdItens) * 100);

                tabela.add(infos);
                InicioIntervalo += h;
                FimIntervalo += h;
            }

            //System.out.println(qtdItens);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e, "Alert", JOptionPane.ERROR_MESSAGE);
        }
        return tabela;
    }

}
