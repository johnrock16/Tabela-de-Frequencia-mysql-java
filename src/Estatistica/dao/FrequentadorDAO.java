/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.dao;

import Estatistica.conexao.ConnectionFactory;
import Estatistica.modelo.Frequentador;
import Estatistica.modelo.InfosTabela;
import Estatistica.modelo.ModeloFrequentadorBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import IEstatistica.IFrequentadorDAO;

/**
 * Classe de manipulação direta do banco de dados
 * @author User
 */
public class FrequentadorDAO extends ModeloFrequentadorBanco implements IFrequentadorDAO {
    
    protected Connection connection;
    
    public FrequentadorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public void cadastrarFrequentador(Frequentador frequentador) {
        String sql = "insert into tb_frequentador"
                + "(TB_FREQUENTADOR_SEXO,TB_FREQUENTADOR_IDADE,TB_FREQUENTADOR_FREQUENCIA_SEMANAL,TB_FREQUENTADOR_ESTADO_CIVIL,"
                + "TB_FREQUENTADOR_MEIO_DE_TRANSPORTE,TB_FREQUENTADOR_TEMPO_PERMANENCIA_MINUTOS,TB_FREQUENTADOR_RENDA_FAMILIAR)"
                + " values (?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, frequentador.getSexo());
            stmt.setInt(2, frequentador.getIdade());
            stmt.setInt(3, frequentador.getFrequenciaSemanal());
            stmt.setString(4, frequentador.getEstadoCivil());
            stmt.setString(5, frequentador.getMeioDeTransporte());
            stmt.setInt(6, frequentador.getTempoPermanencia());
            stmt.setFloat(7, frequentador.getRendaFamiliar());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterarFrequentador(Frequentador frequentador) {
        String sql = "Update tb_frequentador set "
                + "TB_FREQUENTADOR_SEXO=?, "
                + "TB_FREQUENTADOR_IDADE=?, "
                + "TB_FREQUENTADOR_FREQUENCIA_SEMANAL=?, "
                + "TB_FREQUENTADOR_ESTADO_CIVIL=?, "
                + "TB_FREQUENTADOR_MEIO_DE_TRANSPORTE=?, "
                + "TB_FREQUENTADOR_TEMPO_PERMANENCIA_MINUTOS=?, "
                + "TB_FREQUENTADOR_RENDA_FAMILIAR=? "
                + "where TB_FREQUENTADOR_ID=? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, frequentador.getSexo());
            stmt.setInt(2, frequentador.getIdade());
            stmt.setInt(3, frequentador.getFrequenciaSemanal());
            stmt.setString(4, frequentador.getEstadoCivil());
            stmt.setString(5, frequentador.getMeioDeTransporte());
            stmt.setInt(6, frequentador.getTempoPermanencia());
            stmt.setFloat(7, frequentador.getRendaFamiliar());
            stmt.setInt(8, frequentador.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
            throw new RuntimeException(ex);
        }
    }

//pesquisa normal
    @Override
    public List<Frequentador> getListFrequentadorPorInfo(String campo, String info) {
        List objts = new ArrayList<>();
        try {
            PreparedStatement stbd = connection.prepareStatement("SELECT "
                    + "TB_FREQUENTADOR_ID,"
                    + "TB_FREQUENTADOR_SEXO,"
                    + "TB_FREQUENTADOR_IDADE,"
                    + "TB_FREQUENTADOR_FREQUENCIA_SEMANAL,"
                    + "TB_FREQUENTADOR_ESTADO_CIVIL,"
                    + "TB_FREQUENTADOR_MEIO_DE_TRANSPORTE,"
                    + "TB_FREQUENTADOR_TEMPO_PERMANENCIA_MINUTOS,"
                    + "TB_FREQUENTADOR_RENDA_FAMILIAR "
                    + "FROM tb_frequentador where " + campo + " like '%" + info + "%'");

            ResultSet rs = stbd.executeQuery();

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
    /**
     * Selecionar coluna de informações
     *
     * @param coluna Numero da Coluna selecionada. Numero das colulas em
     * constantes nesta mesma classe (FrequentadorDAO)
     * @return Lista de Frequentadores
     */
    public List<Frequentador> pegarInfo(int coluna) {

        List infoLista = new ArrayList<>();
        List<Frequentador> lista;
        lista = this.getListFrequentadorPorInfo(CAMPOS[ID], "");
        switch (coluna) {
            case ID:
                for (Frequentador f : lista) {
                    infoLista.add(f.getId());
                }
                break;

            case SEXO:
                for (Frequentador f : lista) {
                    infoLista.add(f.getSexo());
                }
                break;

            case IDADE:
                for (Frequentador f : lista) {
                    infoLista.add(f.getIdade());
                }
                break;

            case FREQUENCIA_SEMANAL:
                for (Frequentador f : lista) {
                    infoLista.add(f.getFrequenciaSemanal());
                }
                break;

            case ESTADO_CIVIL:
                for (Frequentador f : lista) {
                    infoLista.add(f.getEstadoCivil());
                }
                break;

            case MEIO_DE_TRANSPORTE:
                for (Frequentador f : lista) {
                    infoLista.add(f.getMeioDeTransporte());
                }
                break;

            case TEMPO_PERMANENCIA:
                for (Frequentador f : lista) {
                    infoLista.add(f.getTempoPermanencia());
                }
                break;

            case RENDA_FAMILIAR:
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
    /**
     * Filtrar Informações repitidas
     *
     * @param listaInfo Lista de Frequentadores com informações repetidas
     * @return Lista de Frequentadores filtrada
     */
    public List<Frequentador> filtrarInfo(List<Frequentador> listaInfo) {
        List filtrarLista = new ArrayList<>();

        for (int i = 0; i < listaInfo.size(); i++) {
            if (i == 0) {
                filtrarLista.add(listaInfo.get(i));
            }

            boolean existe = false;

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
    /**
     * Criar tabela de 2 informações
     *
     * @param campo1 Primeiro campo/coluna consultado
     * @param campo2 Segundo campo/coluna consultado
     * @param listaRefinada1 Primeira lista de informações usadas
     * @param listaRefinada2 Segunda lista de informações usadas
     * @return Lista de Frequentadores em modo tabela de 2 colunas
     */
    public List<InfosTabela> criarTabela2infos(String campo1, String campo2, List<Frequentador> listaRefinada1, List<Frequentador> listaRefinada2) {
        List objts = new ArrayList<>();
        try {
            for (int i = 0; i < listaRefinada1.size(); i++) {
                for (int j = 0; j < listaRefinada2.size(); j++) {
                    PreparedStatement stbd = connection.prepareStatement("SELECT "
                            + campo1 + ","
                            + campo2 + " "
                            + "FROM tb_frequentador where " + campo1 + " like '" + listaRefinada1.get(i) + "' "
                            + "and " + campo2 + " like '" + listaRefinada2.get(j) + "' ");

                    ResultSet rs = stbd.executeQuery();

                    while (rs.next()) {
                        InfosTabela infos = new InfosTabela();

                        infos.setCampo1(rs.getString(campo1));
                        infos.setCampo2(rs.getString(campo2));

                        objts.add(infos);

                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }

        return objts;

    }

    // infos da tabela retirando do banco de dados
    /**
     * Contar quantidade de um campo
     *
     * @param campo Campo consultado
     * @return Quantidade de Itens do campo consultado
     */
    public int qtdItens(String campo) {
        int qtd = 0;
        //pegar o menor valor
        try {
            PreparedStatement stbd = connection.prepareStatement("select COUNT(" + campo + ") from tb_frequentador ");

            ResultSet rs = stbd.executeQuery();

            while (rs.next()) {
                qtd = rs.getInt("COUNT(" + campo + ")");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }
        return qtd;
    }

    /**
     * Pega o Menor e maior valor de um campo
     * @param inf Informação pesquisada
     * @param campo Campo alvo da pesquisa
     */
    public void pegarMenorEMaiorValor(InfosTabela inf, String campo) {
        //pegar o menor valor
        try {
            PreparedStatement stbd = connection.prepareStatement("SELECT MIN(" + campo + ") from tb_frequentador");

            ResultSet rs = stbd.executeQuery();

            while (rs.next()) {
                inf.setMenorValor(rs.getInt("MIN(" + campo + ")"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }

        //pegar o maior valor
        try {
            PreparedStatement stbd = connection.prepareStatement("SELECT MAX(" + campo + ") from tb_frequentador");

            ResultSet rs = stbd.executeQuery();

            while (rs.next()) {
                inf.setMaiorValor(rs.getInt("MAX(" + campo + ")"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }
    }

    /**
     * Pega a quantidade de uma informação nos dados do frequentador (Com intervalo)
     * @param inf Informação pesquisada
     * @param campo Campo alvo da pesquisa
     * @param inicio Inicio da seleção condicionda ao intervalo
     * @param fim Fim da condição condicionada ao intervalo
     * @return Quantidade da informação requerida
     */
    public int pegarFa(InfosTabela inf, String campo, double inicio, double fim) {
        int fa = 0;
        //pegar o menor valor
        try {
            PreparedStatement stbd = connection.prepareStatement("select COUNT(" + campo + ") from tb_frequentador "
                    + "where " + campo + ">=" + inicio + " and " + campo + "<" + fim + " ");

            ResultSet rs = stbd.executeQuery();

            while (rs.next()) {
                fa = rs.getInt("COUNT(" + campo + ")");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }
        return fa;
    }

    /**
     * Pega a quantidade de uma informação nos dados do frequentador (Simples)
     * @param inf Tabela de Informações
     * @param info Informação pesquisada
     * @param campo Campo alvo da pesquisa
     * @return Quantidade da informação requerida
     */
    public int pegarFa(InfosTabela inf, String campo, String info) {
        int fa = 0;
        //pegar o menor valor
        try {
            PreparedStatement stbd = connection.prepareStatement("select COUNT(" + campo + ") from tb_frequentador "
                    + "where " + campo + " like '" + info + "'");

            ResultSet rs = stbd.executeQuery();

            while (rs.next()) {
                fa = rs.getInt("COUNT(" + campo + ")");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }
        return fa;
    }

    /**
     * Pega uma lista de Informações de um campo do frequentador
     * @param campo Campo alvo da pesquisa
     * @return Lista de Informações do campo
     */
    public List<InfosTabela> pegarStringIntervalo(String campo) {
        List tabela = new ArrayList<>();
        //pegar o menor valor
        try {
            PreparedStatement stbd = connection.prepareStatement("select distinct " + campo + " from tb_frequentador ");

            ResultSet rs = stbd.executeQuery();

            while (rs.next()) {
                InfosTabela infos = new InfosTabela();
                infos.setIntervalo(rs.getString(campo));
                tabela.add(infos);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Busca!");
            throw new RuntimeException(ex);
        }

        return tabela;
    }

}
