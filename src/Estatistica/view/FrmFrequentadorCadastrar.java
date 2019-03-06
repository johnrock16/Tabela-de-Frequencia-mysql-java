/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.view;

import Estatistica.dao.FrequentadorDAO;
import Estatistica.modelo.Frequentador;

/**
 *
 * @author User
 */
public class FrmFrequentadorCadastrar extends javax.swing.JFrame {

    /**
     * Creates new form FrmFrequentadorCadastrar
     */
    public FrmFrequentadorCadastrar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btncadastrar = new javax.swing.JButton();
        txttempodepermanencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfreqsemanal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtestadocivil = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtmeiotransporte = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtsexo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtrendafamiliar = new javax.swing.JTextField();
        btnalterar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Sexo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 82, -1, -1));

        btncadastrar.setText("cadastrar");
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btncadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));
        getContentPane().add(txttempodepermanencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 100, -1));

        jLabel2.setText("Cadastrar Frequentador");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel3.setText("Idade");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 122, -1, -1));
        getContentPane().add(txtidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 119, 100, -1));

        jLabel4.setText("Frequencia Semanal");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 168, -1, -1));
        getContentPane().add(txtfreqsemanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 165, 100, -1));

        jLabel5.setText("Estado Civil");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 217, -1, -1));
        getContentPane().add(txtestadocivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 214, 100, -1));

        jLabel6.setText("Meio de Transporte");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));
        getContentPane().add(txtmeiotransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 100, -1));

        jLabel7.setText("Tempo de permanencia");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));
        getContentPane().add(txtsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 79, 100, -1));

        jLabel8.setText("Renda familiar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));
        getContentPane().add(txtrendafamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 100, -1));

        btnalterar.setText("alterar");
        btnalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnalterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jLabel9.setText("ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        Frequentador fr= new Frequentador();
        FrequentadorDAO frdao= new FrequentadorDAO();
        try{
            fr.setSexo(txtsexo.getText());
            fr.setIdade(Integer.parseInt(txtidade.getText()));
            fr.setFrequenciaSemanal(Integer.parseInt(txtfreqsemanal.getText()));
            fr.setEstadoCivil(txtestadocivil.getText());
            fr.setMeioDeTransporte(txtmeiotransporte.getText());
            fr.setTempoPermanencia(Integer.parseInt(txttempodepermanencia.getText()));
            fr.setRendaFamiliar(Float.parseFloat(txtrendafamiliar.getText()));

            frdao.cadastrarFrequentador(fr);
        }
        catch(Exception e){
            System.out.println("erro ao cadastrar na hora de passa valor");
        }
        
        
        
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void btnalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarActionPerformed
        Frequentador fr= new Frequentador();
        FrequentadorDAO frdao= new FrequentadorDAO();
        try{
            fr.setSexo(txtsexo.getText());
            fr.setIdade(Integer.parseInt(txtidade.getText()));
            fr.setFrequenciaSemanal(Integer.parseInt(txtfreqsemanal.getText()));
            fr.setEstadoCivil(txtestadocivil.getText());
            fr.setMeioDeTransporte(txtmeiotransporte.getText());
            fr.setTempoPermanencia(Integer.parseInt(txttempodepermanencia.getText()));
            fr.setRendaFamiliar(Float.parseFloat(txtrendafamiliar.getText()));
            fr.setId(Integer.parseInt(txtid.getText()));
            frdao.alterarFrequentador(fr);
        }
        catch(Exception e){
            System.out.println("erro ao cadastrar na hora de passa valor");
        }
    }//GEN-LAST:event_btnalterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmFrequentadorCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFrequentadorCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFrequentadorCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFrequentadorCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFrequentadorCadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnalterar;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtestadocivil;
    private javax.swing.JTextField txtfreqsemanal;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidade;
    private javax.swing.JTextField txtmeiotransporte;
    private javax.swing.JTextField txtrendafamiliar;
    private javax.swing.JTextField txtsexo;
    private javax.swing.JTextField txttempodepermanencia;
    // End of variables declaration//GEN-END:variables
}