/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.controle;

import Estatistica.modelo.InfosTabela;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ControleFrequentador {
    
    

    public DefaultTableModel preencherJTableIntervalo(List<InfosTabela> info, JTable tabela) {
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
    
    

}
