/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nextlevel.view;

import java.sql.*;
import br.com.nextlevel.jdbc.ConnectionFactory;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrey Gheno Piekas
 */
public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    //

    public void logar() {
        String sql = "select * from funcionarios where usuario=? and senha=?";
        try {
            //preparacao para consulta ao banco de dados  em relacao ao que sera digitado nas caixas de texto
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaLoginLOGIN.getText());
            pst.setString(2, TelaLoginSENHA.getText());
            //preparacao para executar a query
            rs = pst.executeQuery();
            //caso usuario existir o usuario
            if (rs.next()) {
                //a linha abaixo obter o conteudo do campo perfil da tabela usuario
                String perfil = rs.getString(9);
                //System.out.println(perfil);
                //tratamento de pefil de funcionario
                if (perfil.equals("admin")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    this.dispose(); /// fecha o formulario de login ao abrir a tela principal
                    TelaPrincipal.TelaPrincipalRELATORIOS.setEnabled(true);
                    TelaPrincipal.TelaPrincipalCADASTROFUNCIONARIOS.setEnabled(true);
                    TelaPrincipal.TelaPrincipalUSUARIO.setText(rs.getString(2));
                    TelaPrincipal.TelaPrincipalUSUARIO.setForeground(Color.red);
                } else {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    this.dispose(); /// fecha o formulario de login ao abrir a tela principal
                    TelaPrincipal.TelaPrincipalUSUARIO.setText(rs.getString(2));
                }
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senhas Inválido");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form TelaClientes2
     */
    public TelaLogin() {
        initComponents();
        conexao = ConnectionFactory.getConnection();
        //a linha abaixo ser de status de conexão
        //System.out.println(conexao);
        if (conexao != null) {
            TelaLoginSTATUSBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/DBOK.png"))); ///dbok
        } else {
            TelaLoginSTATUSBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/DBerro.png"))); ///dberro
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TelaLoginLOGIN = new javax.swing.JTextField();
        TelaLoginSENHA = new javax.swing.JPasswordField();
        TelaLoginButtonLOGIN = new javax.swing.JButton();
        TelaLoginSTATUSBD = new javax.swing.JLabel();
        TelaLoginButtonFECHAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nextlevel - Login");
        setResizable(false);

        jLabel1.setText("Login");

        jLabel2.setText("Senha");

        TelaLoginButtonLOGIN.setText("Login");
        TelaLoginButtonLOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaLoginButtonLOGINActionPerformed(evt);
            }
        });

        TelaLoginSTATUSBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/DBerro.png"))); // NOI18N

        TelaLoginButtonFECHAR.setText("Fechar");
        TelaLoginButtonFECHAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaLoginButtonFECHARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TelaLoginSTATUSBD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(TelaLoginButtonFECHAR)
                        .addGap(27, 27, 27)
                        .addComponent(TelaLoginButtonLOGIN))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TelaLoginSENHA, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(TelaLoginLOGIN))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TelaLoginLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TelaLoginSENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TelaLoginButtonLOGIN)
                        .addComponent(TelaLoginButtonFECHAR))
                    .addComponent(TelaLoginSTATUSBD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TelaLoginButtonLOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaLoginButtonLOGINActionPerformed
        // TODO add your handling code here:
        //chamar metodo logar
        logar();
    }//GEN-LAST:event_TelaLoginButtonLOGINActionPerformed

    private void TelaLoginButtonFECHARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaLoginButtonFECHARActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_TelaLoginButtonFECHARActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TelaLoginButtonFECHAR;
    private javax.swing.JButton TelaLoginButtonLOGIN;
    private javax.swing.JTextField TelaLoginLOGIN;
    private javax.swing.JPasswordField TelaLoginSENHA;
    private javax.swing.JLabel TelaLoginSTATUSBD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
