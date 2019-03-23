/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEstatistica;

import Estatistica.modelo.Frequentador;
import java.util.List;

/**
 * Interface para modelagem inicial da classe FrequentadorDAO
 * @author User
 */
public interface IFrequentadorDAO {

    /**
     * Cadastro de Frequentador
     *
     * @param frequentador Objeto da classe Frequentador preenchido
     */
    public abstract void cadastrarFrequentador(Frequentador frequentador);

    /**
     * Ateração de Frequentador
     *
     * @param frequentador Objeto da classe Frequentador com ID
     */
    public abstract void alterarFrequentador(Frequentador frequentador);

    /**
     * Pesquisa de Frequentador
     *
     * @param campo Campo consultado da tabela
     * @param info Informação buscada no Campo
     * @return Lista do Objeto Frequentador
     */
    public abstract List<Frequentador> getListFrequentadorPorInfo(String campo, String info);

}
