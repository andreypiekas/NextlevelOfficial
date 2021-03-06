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
 * @author Andrey Gheno Piekas
 */
public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaPrincipalUSUARIO = new javax.swing.JLabel();
        TelaPrincipalDATA = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        TelaPrincipalLOGO = new javax.swing.JLabel();
        TelaPrincipalMENU = new javax.swing.JMenuBar();
        TelaPrincipalCADASTRO = new javax.swing.JMenu();
        TelaPrincipalCADASTROMENU = new javax.swing.JMenu();
        TelaPrincipalCADASTROCLIENTE = new javax.swing.JMenuItem();
        TelaPrincipalCADASTROFUNCIONARIOSMENU = new javax.swing.JMenu();
        TelaPrincipalCADASTROFUNCIONARIOS = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        TelaPrincipalCADASTROPRODUTO = new javax.swing.JMenuItem();
        TelaPrincipalPEDIDOS = new javax.swing.JMenu();
        TelaPrincipalPEDIDOSPEDIDOS = new javax.swing.JMenuItem();
        TelaPrincipalPEDIDOSAPI = new javax.swing.JMenuItem();
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

        TelaPrincipalUSUARIO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TelaPrincipalUSUARIO.setText("Usu??rio");

        TelaPrincipalDATA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TelaPrincipalDATA.setText("Data");

        Desktop.setBackground(new java.awt.Color(102, 102, 102));
        Desktop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Desktop.setPreferredSize(new java.awt.Dimension(751, 583));

        TelaPrincipalLOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/8fb43566dc0e49c08c189576a3027a4e.png"))); // NOI18N

        Desktop.setLayer(TelaPrincipalLOGO, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                .addContainerGap(1201, Short.MAX_VALUE)
                .addComponent(TelaPrincipalLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                .addContainerGap(597, Short.MAX_VALUE)
                .addComponent(TelaPrincipalLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TelaPrincipalCADASTRO.setText("Cadastro/Funcion??rio");

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
        TelaPrincipalCADASTROFUNCIONARIOS.setText("Funcion??rios");
        TelaPrincipalCADASTROFUNCIONARIOS.setEnabled(false);
        TelaPrincipalCADASTROFUNCIONARIOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalCADASTROFUNCIONARIOSActionPerformed(evt);
            }
        });
        TelaPrincipalCADASTROFUNCIONARIOSMENU.add(TelaPrincipalCADASTROFUNCIONARIOS);

        TelaPrincipalCADASTRO.add(TelaPrincipalCADASTROFUNCIONARIOSMENU);

        TelaPrincipalMENU.add(TelaPrincipalCADASTRO);

        jMenu1.setText("Produto");

        TelaPrincipalCADASTROPRODUTO.setText("Cadastrar");
        TelaPrincipalCADASTROPRODUTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalCADASTROPRODUTOActionPerformed(evt);
            }
        });
        jMenu1.add(TelaPrincipalCADASTROPRODUTO);

        TelaPrincipalMENU.add(jMenu1);

        TelaPrincipalPEDIDOS.setText("Pedidos");
        TelaPrincipalPEDIDOS.setEnabled(false);

        TelaPrincipalPEDIDOSPEDIDOS.setText("Pedidos");
        TelaPrincipalPEDIDOSPEDIDOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalPEDIDOSPEDIDOSActionPerformed(evt);
            }
        });
        TelaPrincipalPEDIDOS.add(TelaPrincipalPEDIDOSPEDIDOS);

        TelaPrincipalPEDIDOSAPI.setText("Pedidos API");
        TelaPrincipalPEDIDOSAPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalPEDIDOSAPIActionPerformed(evt);
            }
        });
        TelaPrincipalPEDIDOS.add(TelaPrincipalPEDIDOSAPI);

        TelaPrincipalMENU.add(TelaPrincipalPEDIDOS);

        TelaPrincipalRELATORIOS.setText("Relat??rios");
        TelaPrincipalRELATORIOS.setEnabled(false);

        TelaPrincipalRELATORIOSSERVICOS.setText("Servi??os");
        TelaPrincipalRELATORIOSSERVICOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaPrincipalRELATORIOSSERVICOSActionPerformed(evt);
            }
        });
        TelaPrincipalRELATORIOS.add(TelaPrincipalRELATORIOSSERVICOS);

        TelaPrincipalMENU.add(TelaPrincipalRELATORIOS);

        TelaPrincipalOPCOES.setText("Op????es");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 1399, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TelaPrincipalUSUARIO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TelaPrincipalDATA)
                        .addGap(349, 349, 349))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelaPrincipalUSUARIO)
                    .addComponent(TelaPrincipalDATA))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1427, 745));
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
        //solicita ao usu??rio a confirma????o de sair ou n??o
        int sair = JOptionPane.showConfirmDialog(null, "Certeza que deseja sair?", "Aten????o", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_TelaPrincipalOPCOESSAIRActionPerformed

    private void TelaPrincipalCADASTROCLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalCADASTROCLIENTEActionPerformed
        // TODO add your handling code here:
        TelaClientes clientes = new TelaClientes();
        clientes.setVisible(true);
        Desktop.add(clientes);
    }//GEN-LAST:event_TelaPrincipalCADASTROCLIENTEActionPerformed

    private void TelaPrincipalPEDIDOSPEDIDOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalPEDIDOSPEDIDOSActionPerformed
        // TODO add your handling code here:
        TelaPedidos pedidos = new TelaPedidos();
        pedidos.setVisible(true);
        Desktop.add(pedidos);
    }//GEN-LAST:event_TelaPrincipalPEDIDOSPEDIDOSActionPerformed

    private void TelaPrincipalCADASTROPRODUTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalCADASTROPRODUTOActionPerformed
        // TODO add your handling code here:

        TelaProduto produto = new TelaProduto();
        produto.setVisible(true);
        Desktop.add(produto);
    }//GEN-LAST:event_TelaPrincipalCADASTROPRODUTOActionPerformed

    private void TelaPrincipalPEDIDOSAPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalPEDIDOSAPIActionPerformed
        // TODO add your handling code here:

        TelaPedidosAPI pedidosAPI = new TelaPedidosAPI();
        pedidosAPI.setVisible(true);
        Desktop.add(pedidosAPI);

    }//GEN-LAST:event_TelaPrincipalPEDIDOSAPIActionPerformed

    private void TelaPrincipalRELATORIOSSERVICOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaPrincipalRELATORIOSSERVICOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaPrincipalRELATORIOSSERVICOSActionPerformed

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
    private javax.swing.JMenuItem TelaPrincipalCADASTROPRODUTO;
    private javax.swing.JLabel TelaPrincipalDATA;
    private javax.swing.JLabel TelaPrincipalLOGO;
    private javax.swing.JMenuBar TelaPrincipalMENU;
    private javax.swing.JMenu TelaPrincipalOPCOES;
    private javax.swing.JMenuItem TelaPrincipalOPCOESSAIR;
    private javax.swing.JMenu TelaPrincipalPEDIDOS;
    private javax.swing.JMenuItem TelaPrincipalPEDIDOSAPI;
    private javax.swing.JMenuItem TelaPrincipalPEDIDOSPEDIDOS;
    private javax.swing.JMenuItem TelaPrincipalPEDIDOSSOBRE;
    public static javax.swing.JMenu TelaPrincipalRELATORIOS;
    private javax.swing.JMenuItem TelaPrincipalRELATORIOSSERVICOS;
    public static javax.swing.JLabel TelaPrincipalUSUARIO;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
