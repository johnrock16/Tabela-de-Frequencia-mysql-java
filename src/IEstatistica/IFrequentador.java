/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEstatistica;

import Estatistica.modelo.Frequentador;
import java.util.List;

/**
 *
 * @author User
 */
public interface IFrequentador {
    
    public abstract void cadastrarFrequentador(Frequentador frequentador);
    
    public abstract void alterarFrequentador(Frequentador frequentador);
    
    public abstract List<Frequentador> getListFrequentadorPorInfo(String campo, String info);
    
}
