/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nextlevel.view;

import br.com.nextlevel.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author andrey.piekas@gmail.com
 */
public class TelaClientesEnderecos extends javax.swing.JFrame {

    /**
     * Creates new form TelaClientesEnderecos
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    TelaClientes TelclienteN = new TelaClientes();

    public TelaClientesEnderecos() {
        initComponents();
        conexao = ConnectionFactory.getConnection();
    }

    private void adicionar() {
        String sql = "insert into endereco (Clientes_idClientes, cep, rua, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            // pst.setString(1, TelaClientesEnderecosIDENDERECO.getText());
            // pst.setString(1, TelclienteN. );
            //pst.getResultSet(TelclienteN.equals(TelclienteN.))
            //System.out.println(TelaClientes.);
            // System.out.println(TelaClientes.getTe);

            //System.out.println(((TelaClientes)TelclienteN.getComponent(TelclienteN.)));
            //TelclienteN.getComponent(TelclienteN.getHeight(TelaClientes.TelaClientesID));
            //System.out.println("SQLException: " + TelclienteN.toString(TelaClientes.));
            pst.setString(1, TelaClientesEnderecosIDCLIENTE.getText());
            pst.setString(2, TelaClientesEnderecosCEP.getText());
            pst.setString(3, TelaClientesEnderecosRUA.getText());
            pst.setString(4, TelaClientesEnderecosNUMERO.getText());
            pst.setString(5, TelaClientesEnderecosCOMPLEMENTO.getText());
            pst.setString(6, TelaClientesEnderecosBAIRRO.getText());
            pst.setString(7, TelaClientesEnderecosCIDADE.getText());
            pst.setString(8, TelaClientesEnderecosCOMBOESTADO.getSelectedItem().toString());

            if (TelaClientesEnderecosCEP.getText().isEmpty() || TelaClientesEnderecosRUA.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

                //atualizando a tabela funcionarios com os dados novos do formulario
                //tela de confirmação de inserção de dados
                int adicionado = pst.executeUpdate();
                //teste para verificaer se a variavel está retornando valor
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Endereço adicionado com sucesso!");
                    //limpadados();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!");
        }

    }

    private void pesquisar_cliente() {
        // String sql = "select * from clientes where nome like ?";
        String sql = "select idEndereco as ID, Clientes_idClientes as IDCLiente, cep as CEP, rua as RUA, numero as NUMERO ,complemento as Compl, bairro as Bairro, cidade as Cidade, estado as Estado from endereco where Clientes_idClientes like ?";

        try {
            pst = conexao.prepareStatement(sql);
            // passando o conteudo da caixa de pesquisa para o ?
            //o % é a continuacao da string sql
            pst.setString(1, TelaClientesEnderecosIDCLIENTE.getText() + "%");
            rs = pst.executeQuery();

            ///utilizando a bliblioteca rs2xml.jar para preencher a tabela
            TelaClientesEnderecosTABELA.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void setar_campos() {
        int setar = TelaClientesEnderecosTABELA.getSelectedRow();
        TelaClientesEnderecosIDENDERECO.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 0).toString());

        TelaClientesEnderecosIDCLIENTE.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 1).toString());
        TelaClientesEnderecosCEP.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 2).toString());
        TelaClientesEnderecosRUA.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 3).toString());
        TelaClientesEnderecosNUMERO.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 4).toString());
        TelaClientesEnderecosCOMPLEMENTO.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 5).toString());
        TelaClientesEnderecosBAIRRO.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 6).toString());
        TelaClientesEnderecosCIDADE.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 7).toString());
        TelaClientesEnderecosCOMBOESTADO.setSelectedItem(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 8).toString());

        ///
        //TelaClientesButtonADICIONAR.setEnabled(false);
    }

    private void alterar() {
        String sql = "update endereco set cep=?, rua=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where idEndereco=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaClientesEnderecosCEP.getText());
            pst.setString(2, TelaClientesEnderecosRUA.getText());
            pst.setString(3, TelaClientesEnderecosNUMERO.getText());
            pst.setString(4, TelaClientesEnderecosCOMPLEMENTO.getText());
            pst.setString(5, TelaClientesEnderecosBAIRRO.getText());
            pst.setString(6, TelaClientesEnderecosCIDADE.getText());
            pst.setString(7, TelaClientesEnderecosCOMBOESTADO.getSelectedItem().toString());

            if (TelaClientesEnderecosCEP.getText().isEmpty() || TelaClientesEnderecosRUA.getText().isEmpty() || TelaClientesEnderecosNUMERO.getText().isEmpty()
                    || TelaClientesEnderecosCOMPLEMENTO.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

                //atualizando a tabela clientes com os dados novos do formulario
                //tela de confirmação de alteracao de dados
                int adicionado = pst.executeUpdate();
                //teste para verificaer se a variavel está retornando valor
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                    // limpadados();
                    //  TelaClientesButtonADICIONAR.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
        //confirmação de remocao
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma remoção do Endereço?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from endereco where idEndereco=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TelaClientesEnderecosIDENDERECO.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                    //limpadados();
                    //    TelaClientesButtonADICIONAR.setEnabled(true);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } else {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TelaClientesEnderecosTABELA = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TelaClientesEnderecosCEP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TelaClientesEnderecosRUA = new javax.swing.JTextField();
        TelaClientesEnderecosNUMERO = new javax.swing.JTextField();
        TelaClientesEnderecosCOMPLEMENTO = new javax.swing.JTextField();
        TelaClientesEnderecosBAIRRO = new javax.swing.JTextField();
        TelaClientesEnderecosCIDADE = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TelaClientesEnderecosIDENDERECO = new javax.swing.JTextField();
        TelaClientesEnderecosButtonADICIONAR = new javax.swing.JButton();
        TelaClientesEnderecosButtonEDITAR = new javax.swing.JButton();
        TelaClientesEnderecosButtonEXCLUIR = new javax.swing.JButton();
        TelaClientesEnderecosCOMBOESTADO = new javax.swing.JComboBox<>();
        TelaClientesEnderecosIDCLIENTE = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TelaClientesEnderecosTABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CEP", "RUA", "NUMERO", "COMPLEMENTO", "BAIRRO", "CIDADE", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(TelaClientesEnderecosTABELA);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setText("CEP");

        TelaClientesEnderecosCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesEnderecosCEPActionPerformed(evt);
            }
        });

        jLabel2.setText("RUA");

        jLabel3.setText("N°");

        jLabel4.setText("Complemento");

        jLabel5.setText("Bairro");

        jLabel6.setText("Cidade");

        jLabel7.setText("Estado");

        jLabel8.setText("ID");

        TelaClientesEnderecosButtonADICIONAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/create.png"))); // NOI18N
        TelaClientesEnderecosButtonADICIONAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesEnderecosButtonADICIONARActionPerformed(evt);
            }
        });

        TelaClientesEnderecosButtonEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/edit.png"))); // NOI18N
        TelaClientesEnderecosButtonEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesEnderecosButtonEDITARActionPerformed(evt);
            }
        });

        TelaClientesEnderecosButtonEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/delete.png"))); // NOI18N
        TelaClientesEnderecosButtonEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesEnderecosButtonEXCLUIRActionPerformed(evt);
            }
        });

        TelaClientesEnderecosCOMBOESTADO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "" }));

        jLabel9.setText("IDCliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(TelaClientesEnderecosRUA, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(TelaClientesEnderecosBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(121, 121, 121)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(TelaClientesEnderecosNUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(TelaClientesEnderecosCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(TelaClientesEnderecosCOMBOESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(TelaClientesEnderecosIDENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TelaClientesEnderecosIDCLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TelaClientesEnderecosCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(TelaClientesEnderecosButtonADICIONAR)
                        .addGap(70, 70, 70)
                        .addComponent(TelaClientesEnderecosButtonEDITAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(TelaClientesEnderecosButtonEXCLUIR)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(TelaClientesEnderecosCOMPLEMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(TelaClientesEnderecosCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(TelaClientesEnderecosIDENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TelaClientesEnderecosButtonADICIONAR)
                        .addComponent(TelaClientesEnderecosButtonEDITAR)
                        .addComponent(jLabel9)
                        .addComponent(TelaClientesEnderecosIDCLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TelaClientesEnderecosButtonEXCLUIR))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(TelaClientesEnderecosRUA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaClientesEnderecosNUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TelaClientesEnderecosCOMPLEMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(TelaClientesEnderecosBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaClientesEnderecosCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaClientesEnderecosCOMBOESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TelaClientesEnderecosButtonADICIONARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesEnderecosButtonADICIONARActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_TelaClientesEnderecosButtonADICIONARActionPerformed

    private void TelaClientesEnderecosCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesEnderecosCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaClientesEnderecosCEPActionPerformed

    private void TelaClientesEnderecosButtonEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesEnderecosButtonEDITARActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_TelaClientesEnderecosButtonEDITARActionPerformed

    private void TelaClientesEnderecosButtonEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesEnderecosButtonEXCLUIRActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_TelaClientesEnderecosButtonEXCLUIRActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_jPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(TelaClientesEnderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaClientesEnderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaClientesEnderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaClientesEnderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaClientesEnderecos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TelaClientesEnderecosBAIRRO;
    private javax.swing.JButton TelaClientesEnderecosButtonADICIONAR;
    private javax.swing.JButton TelaClientesEnderecosButtonEDITAR;
    private javax.swing.JButton TelaClientesEnderecosButtonEXCLUIR;
    private javax.swing.JTextField TelaClientesEnderecosCEP;
    private javax.swing.JTextField TelaClientesEnderecosCIDADE;
    private javax.swing.JComboBox<String> TelaClientesEnderecosCOMBOESTADO;
    private javax.swing.JTextField TelaClientesEnderecosCOMPLEMENTO;
    private javax.swing.JTextField TelaClientesEnderecosIDCLIENTE;
    private javax.swing.JTextField TelaClientesEnderecosIDENDERECO;
    private javax.swing.JTextField TelaClientesEnderecosNUMERO;
    private javax.swing.JTextField TelaClientesEnderecosRUA;
    private javax.swing.JTable TelaClientesEnderecosTABELA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
