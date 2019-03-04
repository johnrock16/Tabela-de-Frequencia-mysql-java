/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.dao;

import Estatica.conexao.ConnectionFactory;
import Estatistica.modelo.Frequentador;
import Estatistica.modelo.InfosTabela;
import IEstatistica.IFrequentador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FrequentadorDAO implements IFrequentador {

    public Connection connection;

    public FrequentadorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public void cadastrarFrequentador(Frequentador frequentador) {
        String sql = "insert into tb_frequentador"
                + "(TB_FREQUENTADOR_SEXO,TB_FREQUENTADOR_IDADE,TB_FREQUENTADOR_FREQUENCIA_SEMANAL,TB_FREQUENTADOR_ESTADO_CIVIL,"
                + "TB_FREQUENTADOR_MEIO_DE_TRANSPORTE,TB_FREQUENTADOR_TEMPO_PERMANENCIA_MINUTOS,TB_FREQUENTADOR_RENDA_FAMILIAR)"
                + " values (?,?,?,?,?,?,?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, frequentador.getSexo());
            stmt.setInt(2, frequentador.getIdade());
            stmt.setInt(3, frequentador.getFrequenciaSemanal());
            stmt.setString(4, frequentador.getEstadoCivil());
            stmt.setString(5, frequentador.getMeioDeTransporte());
            stmt.setInt(6, frequentador.getTempoPermanencia());
            stmt.setFloat(7, frequentador.getRendaFamiliar());
            System.out.println("ass");
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
            throw new RuntimeException(e);
        }

    }

    public void alterarFrequentador(Frequentador frequentador) {
        try {
            String sql = "Update tb_frequentador set "
                    + "TB_FREQUENTADOR_SEXO=?, "
                    + "TB_FREQUENTADOR_IDADE=?, "
                    + "TB_FREQUENTADOR_FREQUENCIA_SEMANAL=?, "
                    + "TB_FREQUENTADOR_ESTADO_CIVIL=?, "
                    + "TB_FREQUENTADOR_MEIO_DE_TRANSPORTE=?, "
                    + "TB_FREQUENTADOR_TEMPO_PERMANENCIA_MINUTOS=?, "
                    + "TB_FREQUENTADOR_RENDA_FAMILIAR=? "
                    + "where TB_FREQUENTADOR_ID=? ";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, frequentador.getSexo());
            stmt.setInt(2, frequentador.getIdade());
            stmt.setInt(3, frequentador.getFrequenciaSemanal());
            stmt.setString(4, frequentador.getEstadoCivil());
            stmt.setString(5, frequentador.getMeioDeTransporte());
            stmt.setInt(6, frequentador.getTempoPermanencia());
            stmt.setFloat(7, frequentador.getRendaFamiliar());
            stmt.setInt(8, frequentador.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
            throw new RuntimeException(ex);
        }
    }
    
    //pesquisa normal

    public List<Frequentador> getListFrequentadorPorInfo(String campo, String info) {
        PreparedStatement stbd = null;
        ResultSet rs = null;
        List objts = new ArrayList<>();
        try {
            stbd = connection.prepareStatement("SELECT "
                    + "TB_FREQUENTADOR_ID,"
                    + "TB_FREQUENTADOR_SEXO,"
                    + "TB_FREQUENTADOR_IDADE,"
                    + "TB_FREQUENTADOR_FREQUENCIA_SEMANAL,"
                    + "TB_FREQUENTADOR_ESTADO_CIVIL,"
                    + "TB_FREQUENTADOR_MEIO_DE_TRANSPORTE,"
                    + "TB_FREQUENTADOR_TEMPO_PERMANENCIA_MINUTOS,"
                    + "TB_FREQUENTADOR_RENDA_FAMILIAR "
                    + "FROM tb_frequentador where " + campo + " like '%" + info + "%'");

            rs = stbd.executeQuery();

            while (rs.next()) {
                Frequentador fr = new Frequentador();

                fr.setId(rs.getInt("TB_FREQUENTADOR_ID"));
                fr.setSexo(rs.getString("TB_FREQUENTADOR_SEXO"));
                fr.setIdade(rs.getInt("TB_FREQUENTADOR_IDADE"));
                fr.setFrequenciaSemanal(rs.getInt("TB_FREQUENTADOR_FREQUENCIA_SEMANAL"));
                fr.setEstadoCivil(rs.getString("TB_FREQUENTADOR_ESTADO_CIVIL"));
                fr.setMeioDeTransporte(rs.getString("TB_FREQUENTADOR_MEIO_DE_TRANSPORTE"));
                fr.setTempoPermanencia(rs.getInt("TB_FREQUENTADOR_TEMPO_PERMANENCIA_MINUTOS"));
                fr.setRendaFamiliar(rs.getFloat("TB_FREQUENTADOR_RENDA_FAMILIAR"));
                objts.add(fr);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }
        return objts;
    }
    
    //pegar infos por coluna

    public List<Frequentador> pegarInfo(int coluna) {

        List infoLista = new ArrayList<>();
        List<Frequentador> lista = this.getListFrequentadorPorInfo("TB_FREQUENTADOR_ID", "");
        switch (coluna) {
            case 1:
                for (Frequentador f : lista) {
                    infoLista.add(f.getId());
                }
                break;

            case 2:
                for (Frequentador f : lista) {
                    infoLista.add(f.getSexo());
                }
                break;

            case 3:
                for (Frequentador f : lista) {
                    infoLista.add(f.getIdade());
                }
                break;

            case 4:
                for (Frequentador f : lista) {
                    infoLista.add(f.getFrequenciaSemanal());
                }
                break;

            case 5:
                for (Frequentador f : lista) {
                    infoLista.add(f.getEstadoCivil());
                }
                break;

            case 6:
                for (Frequentador f : lista) {
                    infoLista.add(f.getMeioDeTransporte());
                }
                break;

            case 7:
                for (Frequentador f : lista) {
                    infoLista.add(f.getTempoPermanencia());
                }
                break;

            case 8:
                for (Frequentador f : lista) {
                    infoLista.add(f.getRendaFamiliar());
                }
                break;

            default:
                System.out.println("erro");
        }

        return infoLista;
    }
    
    //arrancar infos repetidas

    public List<Frequentador> filtrarInfo(List<Frequentador> listaInfo) {

        boolean existe = false;
        List filtrarLista = new ArrayList<>();

        for (int i = 0; i < listaInfo.size(); i++) {
            if (i == 0) {
                filtrarLista.add(listaInfo.get(i));
            }
            existe = false;
            for (int j = 0; j < filtrarLista.size(); j++) {
                if (existe == false) {
                    if (filtrarLista.get(j).equals(listaInfo.get(i))) {

                        existe = true;
                    }
                }
            }
            if (existe == false) {
                filtrarLista.add(listaInfo.get(i));
            }
        }

        return filtrarLista;
    }
    
    //criar tabela com 2 infos

    public List<Frequentador> criarTabela2infos(String campo1, String campo2, List<Frequentador> listaRefinada1, List<Frequentador> listaRefinada2) {

        PreparedStatement stbd = null;
        ResultSet rs = null;
        List objts = new ArrayList<>();
        try {
            for (int i = 0; i < listaRefinada1.size(); i++) {
                for (int j = 0; j < listaRefinada2.size(); j++) {
                    stbd = connection.prepareStatement("SELECT "
                            + campo1 + ","
                            + campo2 + " "
                            + "FROM tb_frequentador where " + campo1 + " like '" + listaRefinada1.get(i) + "' "
                            + "and " + campo2 + " like '" + listaRefinada2.get(j) + "' ");

                    rs = stbd.executeQuery();

                    while (rs.next()) {
                        Frequentador fr = new Frequentador();

                        fr.setCampo1(rs.getString(campo1));
                        fr.setCampo2(rs.getString(campo2));

                        objts.add(fr);

                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }

        return objts;

    }

    // tabela com 2 infos completa
    
    public List<Frequentador> tabela2InfosNumeros(List<Frequentador> tabela2infos) {

        List tabela = new ArrayList<>();
        String[][] verifica = new String[tabela2infos.size()][2];
        int vezes = 0;
        int start = 0;
        int pos = 0;

        for (Frequentador f : tabela2infos) {

            verifica[pos][0] = f.getCampo1();
            verifica[pos][1] = f.getCampo2();
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
                Frequentador fr = new Frequentador();
                fr.setCampo1(campo1);
                fr.setCampo2(campo2);
                fr.setCampoNumero("" + cont);
                tabela.add(fr);
                espera = 0;
            }

        }

        return tabela;
    }

    // tabela de frequencias sobre 1 coluna
    
    public List<InfosTabela> tabelaFrequenciaIntervalos(String campo,int coluna) {
        InfosTabela inf = new InfosTabela();
        List tabela = new ArrayList<>();
        double qtdItens=qtdItens(campo);
        double k = Math.ceil(Math.sqrt(qtdItens));
        double at,h;
        double InicioIntervalo,FimIntervalo;
        int acumulada=0;
        
        
        pegarMenorEMaiorValor(inf, campo);
        
        
        
        at=inf.getMaiorValor()-inf.getMenorValor();
        h=Math.ceil(at/k);
        
        System.out.println(k);
        System.out.println(inf.getMenorValor());
        System.out.println(inf.getMaiorValor());
        System.out.println(at);
        System.out.println(h);
        
        InicioIntervalo=inf.getMenorValor();
        FimIntervalo=InicioIntervalo+h;
        
        for(int i=0;i<k;i++){
            InfosTabela infos=new InfosTabela();            
            infos.setIntervalo(InicioIntervalo+"|-------"+FimIntervalo);           
            infos.setKi((InicioIntervalo+FimIntervalo)/2); 
            infos.setFa(pegarFa(inf, campo, InicioIntervalo, FimIntervalo));
            infos.setFr(infos.getFa()/qtdItens);
            infos.setFrPCento(infos.getFr()*100);
            acumulada+=infos.getFa();
            infos.setFac(acumulada);
            infos.setFacPCento((infos.getFac()/qtdItens)*100);
            tabela.add(infos);
            InicioIntervalo+=h;
            FimIntervalo+=h;
        }
        

        System.out.println(qtdItens);

        return tabela;
    }
    
    // infos da tabela retirando do banco de dados
    
    public int qtdItens(String campo){
        PreparedStatement stbd = null;
        ResultSet rs = null;
        int qtd=0;
        //pegar o menor valor
        try {
            stbd = connection.prepareStatement("select COUNT("+campo+") from tb_frequentador ");

            rs = stbd.executeQuery();

            while (rs.next()) {
                qtd=rs.getInt("COUNT("+campo+")");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }
        return qtd;
    }
    
    public void pegarMenorEMaiorValor(InfosTabela inf,String campo){
        PreparedStatement stbd = null;
        ResultSet rs = null;
        
        //pegar o menor valor
        try {
            stbd = connection.prepareStatement("SELECT MIN("+campo+") from tb_frequentador");

            rs = stbd.executeQuery();

            while (rs.next()) {
                inf.setMenorValor(rs.getInt("MIN("+campo+")"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }
        
        //pegar o maior valor
        try {
            stbd = connection.prepareStatement("SELECT MAX("+campo+") from tb_frequentador");

            rs = stbd.executeQuery();

            while (rs.next()) {
                inf.setMaiorValor(rs.getInt("MAX("+campo+")"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }
    }

    public int pegarFa(InfosTabela inf,String campo,double inicio,double fim){
        PreparedStatement stbd = null;
        ResultSet rs = null;
        int fa=0;
        //pegar o menor valor
        try {
            stbd = connection.prepareStatement("select COUNT("+campo+") from tb_frequentador "
                    + "where "+campo+">="+inicio+" and "+campo+"<"+fim+" ");

            rs = stbd.executeQuery();

            while (rs.next()) {
                fa=rs.getInt("COUNT("+campo+")");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }
        return fa;
    }
}
