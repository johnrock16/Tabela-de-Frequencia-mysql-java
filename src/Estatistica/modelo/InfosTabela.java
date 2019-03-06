/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.modelo;

/**
 *
 * @author User
 */
public class InfosTabela {
    private String intervalo,campo1,campo2,campoNumero;
    private double ki,fr,frPCento,facPCento;
    private double menorValor,maiorValor;
    private int fa,fac;

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampoNumero() {
        return campoNumero;
    }

    public void setCampoNumero(String campoNumero) {
        this.campoNumero = campoNumero;
    }
    
    

    public double getKi() {
        return ki;
    }

    public void setKi(double ki) {
        this.ki = ki;
    }

    public double getFr() {
        return fr;
    }

    public void setFr(double fr) {
        this.fr = fr;
    }

    public double getFrPCento() {
        return frPCento;
    }

    public void setFrPCento(double frPCento) {
        this.frPCento = frPCento;
    }

    public double getFacPCento() {
        return facPCento;
    }

    public void setFacPCento(double facPCento) {
        this.facPCento = facPCento;
    }

    public double getMenorValor() {
        return menorValor;
    }

    public void setMenorValor(double menorValor) {
        this.menorValor = menorValor;
    }

    public double getMaiorValor() {
        return maiorValor;
    }

    public void setMaiorValor(double maiorValor) {
        this.maiorValor = maiorValor;
    }

    public int getFa() {
        return fa;
    }

    public void setFa(int fa) {
        this.fa = fa;
    }

    public int getFac() {
        return fac;
    }

    public void setFac(int fac) {
        this.fac = fac;
    }
    
    
}
