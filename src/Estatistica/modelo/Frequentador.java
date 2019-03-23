/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.modelo;

/**
 * Modelo da entidade Frequentador
 * @author User
 */
public class Frequentador extends ModeloFrequentadorBanco{

    private int id = 0;
    private String sexo;
    private int idade = 0;
    private int frequenciaSemanal = 0;
    private String estadoCivil;
    private String meioDeTransporte;
    private int tempoPermanencia = 0;
    private float rendaFamiliar = 0;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getMeioDeTransporte() {
        return meioDeTransporte;
    }

    public void setMeioDeTransporte(String meioDeTransporte) {
        this.meioDeTransporte = meioDeTransporte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }

    public int getFrequenciaSemanal() {
        return frequenciaSemanal;
    }

    public void setFrequenciaSemanal(int frequenciaSemanal) {
        if (frequenciaSemanal >= 0) {
            this.frequenciaSemanal = frequenciaSemanal;
        }
    }

    public int getTempoPermanencia() {
        return tempoPermanencia;
    }

    public void setTempoPermanencia(int tempoPermanencia) {
        if (tempoPermanencia >= 0) {
            this.tempoPermanencia = tempoPermanencia;
        }
    }

    public float getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(float rendaFamiliar) {
        if (rendaFamiliar >= 0) {
            this.rendaFamiliar = rendaFamiliar;
        }
    }

    /**
     * Preenche o objeto com o Array seguindo o padrão do FrequentadorDAO.
     *
     * @param vars - Array baseado Modelo do Banco (CAMPOS)
     */
    public void preencherSemID(Object vars[]) {
        setSexo(String.valueOf(vars[SEXO]));
        setIdade(Integer.parseInt(vars[IDADE].toString()));
        setFrequenciaSemanal((Integer.parseInt( vars[FREQUENCIA_SEMANAL].toString())));
        setEstadoCivil(String.valueOf(vars[ESTADO_CIVIL]));
        setMeioDeTransporte(String.valueOf(vars[MEIO_DE_TRANSPORTE]));
        setTempoPermanencia((Integer.parseInt( vars[TEMPO_PERMANENCIA].toString())));
        setRendaFamiliar(Float.parseFloat(vars[RENDA_FAMILIAR].toString()));
    }
    
    /**
     * Preenche o objeto com o Array seguindo o padrão do FrequentadorDAO.
     *
     * @param vars - Array baseado no Modelo do Banco (CAMPOS)
     */
    public void preencherPorCompleto(Object vars[]) {
        setId(Integer.parseInt(vars[ID].toString()));
        setSexo(String.valueOf(vars[SEXO]));
        setIdade(Integer.parseInt(vars[IDADE].toString()));
        setFrequenciaSemanal(Integer.parseInt( vars[FREQUENCIA_SEMANAL].toString()));
        setEstadoCivil(String.valueOf(vars[ESTADO_CIVIL]));
        setMeioDeTransporte(String.valueOf(vars[MEIO_DE_TRANSPORTE]));
        setTempoPermanencia((Integer.parseInt( vars[TEMPO_PERMANENCIA].toString())));
        setRendaFamiliar(Float.parseFloat(vars[RENDA_FAMILIAR].toString()));
    }


    /**
     * Pega todos os campos do objeto em um Array seguindo o padrão do
     * FrequentadorDAO.
     *
     * @param vars - Array baseado no Modelo do Banco (CAMPOS)
     */
    public void getPorCompleto(Object vars[]) {
        vars[ID] = getId();
        vars[SEXO] = getSexo();
        vars[IDADE] = getIdade();
        vars[FREQUENCIA_SEMANAL] = getFrequenciaSemanal();
        vars[ESTADO_CIVIL] = getEstadoCivil();
        vars[MEIO_DE_TRANSPORTE] = getMeioDeTransporte();
        vars[TEMPO_PERMANENCIA] = getTempoPermanencia();
        vars[RENDA_FAMILIAR] = getRendaFamiliar();
    }

}
