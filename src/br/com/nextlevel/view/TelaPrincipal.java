/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.nextlevel.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
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

        TelaPrincipalLOGO = new javax.swing.JLabel();
        TelaPrincipalUSUARIO = new javax.swing.JLabel();
        TelaPrincipalDATA = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        TelaPrincipalMENU = new javax.swing.JMenuBar();
        TelaPrincipalCADASTRO = new javax.swing.JMenu();
        TelaPrincipalCADASTROMENU = new javax.swing.JMenu();
        TelaPrincipalCADASTROCLIENTE = new javax.swing.JMenuItem();
        TelaPrincipalCADASTROFUNCIONARIOSMENU = new javax.swing.JMenu();
        TelaPrincipalCADASTROFUNCIONARIOS = new javax.swing.JMenuItem();
        TelaPrincipalPEDIDOS = new javax.swing.JMenu();
        TelaPrincipalPEDIDOSPEDIDOS = new javax.swing.JMenuItem();
        TelaPrincipalRELATORIOS = new javax.swing.JMenu();
        TelaPrincipalRELATORIOSSERVICOS = new javax.swing.JMenuItem();
        TelaPrincipalOPCOES = new javax.swing.JMenu();
        TelaPrincipalOPCOESSAIR = new javax.swing.JMenuItem();
        TelaPrincipalAJUDA = new javax.swing.JMenu();
        TelaPrincipalPEDIDOSSOBRE = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NextLevel - Sistema de Controle");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        TelaPrincipalLOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/8fb43566dc0e49c08c189576a3027a4e.png"))); // NOI18N

        TelaPrincipalUSUARIO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TelaPrincipalUSUARIO.setText("Usuário");

        TelaPrincipalDATA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TelaPrincipalDATA.setText("Data");

        Desktop.setPreferredSize(new java.awt.Dimension(751, 583));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        TelaPrincipalCADASTRO.setText("Cadastro/Funcionário");

        TelaPrincipalCADASTROMENU.setText("Cliente");

        TelaPrincipalCADASTROCLIENTE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        TelaPrincipalCADASTROCLIENTE.setText("Cliente");
        TelaPrincipalCADASTROCLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalCADASTROCLIENTEActionPerformed(evt);
            }
        });
        TelaPrincipalCADASTROMENU.add(TelaPrincipalCADASTROCLIENTE);

        TelaPrincipalCADASTRO.add(TelaPrincipalCADASTROMENU);

        TelaPrincipalCADASTROFUNCIONARIOSMENU.setText("Funcionarios");

        TelaPrincipalCADASTROFUNCIONARIOS.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        TelaPrincipalCADASTROFUNCIONARIOS.setText("Funcionários");
        TelaPrincipalCADASTROFUNCIONARIOS.setEnabled(false);
        TelaPrincipalCADASTROFUNCIONARIOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalCADASTROFUNCIONARIOSActionPerformed(evt);
            }
        });
        TelaPrincipalCADASTROFUNCIONARIOSMENU.add(TelaPrincipalCADASTROFUNCIONARIOS);

        TelaPrincipalCADASTRO.add(TelaPrincipalCADASTROFUNCIONARIOSMENU);

        TelaPrincipalMENU.add(TelaPrincipalCADASTRO);

        TelaPrincipalPEDIDOS.setText("Pedidos");

        TelaPrincipalPEDIDOSPEDIDOS.setText("Pedidos");
        TelaPrincipalPEDIDOSPEDIDOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalPEDIDOSPEDIDOSActionPerformed(evt);
            }
        });
        TelaPrincipalPEDIDOS.add(TelaPrincipalPEDIDOSPEDIDOS);

        TelaPrincipalMENU.add(TelaPrincipalPEDIDOS);

        TelaPrincipalRELATORIOS.setText("Relatórios");
        TelaPrincipalRELATORIOS.setEnabled(false);

        TelaPrincipalRELATORIOSSERVICOS.setText("Serviços");
        TelaPrincipalRELATORIOS.add(TelaPrincipalRELATORIOSSERVICOS);

        TelaPrincipalMENU.add(TelaPrincipalRELATORIOS);

        TelaPrincipalOPCOES.setText("Opções");

        TelaPrincipalOPCOESSAIR.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        TelaPrincipalOPCOESSAIR.setText("Sair");
        TelaPrincipalOPCOESSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalOPCOESSAIRActionPerformed(evt);
            }
        });
        TelaPrincipalOPCOES.add(TelaPrincipalOPCOESSAIR);

        TelaPrincipalMENU.add(TelaPrincipalOPCOES);

        TelaPrincipalAJUDA.setText("Ajuda");

        TelaPrincipalPEDIDOSSOBRE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        TelaPrincipalPEDIDOSSOBRE.setText("Sobre");
        TelaPrincipalPEDIDOSSOBRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalPEDIDOSSOBREActionPerformed(evt);
            }
        });
        TelaPrincipalAJUDA.add(TelaPrincipalPEDIDOSSOBRE);

        TelaPrincipalMENU.add(TelaPrincipalAJUDA);

        setJMenuBar(TelaPrincipalMENU);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TelaPrincipalUSUARIO)
                        .addGap(713, 713, 713)
                        .addComponent(TelaPrincipalDATA))
                    .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(TelaPrincipalLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TelaPrincipalLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelaPrincipalDATA)
                    .addComponent(TelaPrincipalUSUARIO))
                .addGap(14, 14, 14))
        );

        setSize(new java.awt.Dimension(1085, 671));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TelaPrincipalCADASTROFUNCIONARIOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalCADASTROFUNCIONARIOSActionPerformed
        // TODO add your handling code here:
        TelaFuncionarios funcionarios = new TelaFuncionarios();
        funcionarios.setVisible(true);
        Desktop.add(funcionarios);

    }//GEN-LAST:event_TelaPrincipalCADASTROFUNCIONARIOSActionPerformed

    private void TelaPrincipalPEDIDOSSOBREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalPEDIDOSSOBREActionPerformed
        // solicitando a tela sobre
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
        
        
    }//GEN-LAST:event_TelaPrincipalPEDIDOSSOBREActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        //As linhas a baixo substituem a label data TELAPRINCIPALDATA pela data atual do sistema ao iniciar
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        TelaPrincipalDATA.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void TelaPrincipalOPCOESSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalOPCOESSAIRActionPerformed
        // TODO add your handling code here:
        //solicita ao usuário a confirmação de sair ou não
        int sair = JOptionPane.showConfirmDialog(null, "Certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_TelaPrincipalOPCOESSAIRActionPerformed

    private void TelaPrincipalCADASTROCLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalCADASTROCLIENTEActionPerformed
        // TODO add your handling code here:
        TelaClientes clientes = new TelaClientes();
        clientes.setVisible(true);
    }//GEN-LAST:event_TelaPrincipalCADASTROCLIENTEActionPerformed

    private void TelaPrincipalPEDIDOSPEDIDOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalPEDIDOSPEDIDOSActionPerformed
        // TODO add your handling code here:
        TelaPedidos pedidos = new TelaPedidos();
        pedidos.setVisible(true);
    }//GEN-LAST:event_TelaPrincipalPEDIDOSPEDIDOSActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenu TelaPrincipalAJUDA;
    private javax.swing.JMenu TelaPrincipalCADASTRO;
    private javax.swing.JMenuItem TelaPrincipalCADASTROCLIENTE;
    public static javax.swing.JMenuItem TelaPrincipalCADASTROFUNCIONARIOS;
    private javax.swing.JMenu TelaPrincipalCADASTROFUNCIONARIOSMENU;
    private javax.swing.JMenu TelaPrincipalCADASTROMENU;
    private javax.swing.JLabel TelaPrincipalDATA;
    private javax.swing.JLabel TelaPrincipalLOGO;
    private javax.swing.JMenuBar TelaPrincipalMENU;
    private javax.swing.JMenu TelaPrincipalOPCOES;
    private javax.swing.JMenuItem TelaPrincipalOPCOESSAIR;
    private javax.swing.JMenu TelaPrincipalPEDIDOS;
    private javax.swing.JMenuItem TelaPrincipalPEDIDOSPEDIDOS;
    private javax.swing.JMenuItem TelaPrincipalPEDIDOSSOBRE;
    public static javax.swing.JMenu TelaPrincipalRELATORIOS;
    private javax.swing.JMenuItem TelaPrincipalRELATORIOSSERVICOS;
    public static javax.swing.JLabel TelaPrincipalUSUARIO;
    // End of variables declaration//GEN-END:variables
}
