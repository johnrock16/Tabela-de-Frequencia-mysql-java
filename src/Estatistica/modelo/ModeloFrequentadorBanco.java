/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.modelo;

/**
 * Modelo dos campos da tabela Frequentador fiel ao Banco.
 * @author Lucas Zingaro
 */
public class ModeloFrequentadorBanco {

    /**
     * Constante que representa o campo Frequentador_Id
     */
    public static final int ID = 0;

    /**
     * Constante que representa o campo Frequentador_Sexo
     */
    public static final int SEXO = 1;

    /**
     * Constante que representa o campo Frequentador_Idade
     */
    public static final int IDADE = 2;

    /**
     * Constante que representa o campo Frequentador_frequencia_senamal
     */
    public static final int FREQUENCIA_SEMANAL = 3;

    /**
     * Constante que representa o campo Frequentador_
     */
    public static final int ESTADO_CIVIL = 4;

    /**
     * Constante que representa o campo Frequentador_Meio_De_Transporte
     */
    public static final int MEIO_DE_TRANSPORTE = 5;

    /**
     * Constante que representa o campo Frequentador_Tempo_Permanencia
     */
    public static final int TEMPO_PERMANENCIA = 6;

    /**
     * Constante que representa o campo Frequentador_Renda_Familiar
     */
    public static final int RENDA_FAMILIAR = 7;

    /**
     * Constante de relaciona os campos com seus nomes no banco
     */
    public static final String CAMPOS[] = {
        "TB_FREQUENTADOR_ID",
        "TB_FREQUENTADOR_SEXO",
        "TB_FREQUENTADOR_IDADE",
        "TB_FREQUENTADOR_FREQUENCIA_SEMANAL",
        "TB_FREQUENTADOR_ESTADO_CIVIL",
        "TB_FREQUENTADOR_MEIO_DE_TRANSPORTE",
        "TB_FREQUENTADOR_TEMPO_PERMANENCIA_MINUTOS",
        "TB_FREQUENTADOR_RENDA_FAMILIAR"
    };
}
