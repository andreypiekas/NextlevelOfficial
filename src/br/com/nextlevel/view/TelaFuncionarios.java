/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.nextlevel.view;

/**
 *
 * @author andrey piekas
 */
import java.sql.*;
import br.com.nextlevel.jdbc.ConnectionFactory;
import javax.swing.JOptionPane;

public class TelaFuncionarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaFuncionarios
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaFuncionarios() {
        initComponents();
        conexao = ConnectionFactory.getConnection();
    }

    private void limpadados() {
        TelaFuncionariosID.setText(null);
        TelaFuncionariosNOME.setText(null);
        TelaFuncionariosEMAIL.setText(null);
        TelaFuncionariosENDERECO.setText(null);
        TelaFuncionariosBAIRRO.setText(null);
        TelaFuncionariosCIDADE.setText(null);
        TelaFuncionariosUSUARIO.setText(null);
        TelaFuncionariosSENHA.setText(null);
    }

    private void consultar() {
        String sql = "select * from funcionarios where idFuncionarios=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaFuncionariosID.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                TelaFuncionariosNOME.setText(rs.getString(2));
                TelaFuncionariosEMAIL.setText(rs.getString(3));
                TelaFuncionariosENDERECO.setText(rs.getString(4));
                TelaFuncionariosBAIRRO.setText(rs.getString(5));
                TelaFuncionariosCIDADE.setText(rs.getString(6));
                TelaFuncionariosUSUARIO.setText(rs.getString(7));
                TelaFuncionariosSENHA.setText(rs.getString(8));
                TelaFuncionariosCOMBOPERFIL.setSelectedItem(rs.getString(9));

            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
                //limpa o preenchimento dos campos
                limpadados();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void adicionar() {
        String sql = "insert into funcionarios (idFuncionarios, nome, email, endereco, bairro, cidade, usuario, senha, perfil) values (?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaFuncionariosID.getText());
            pst.setString(2, TelaFuncionariosNOME.getText());
            pst.setString(3, TelaFuncionariosEMAIL.getText());
            pst.setString(4, TelaFuncionariosENDERECO.getText());
            pst.setString(5, TelaFuncionariosBAIRRO.getText());
            pst.setString(6, TelaFuncionariosCIDADE.getText());
            pst.setString(7, TelaFuncionariosUSUARIO.getText());
            pst.setString(8, TelaFuncionariosSENHA.getText());
            pst.setString(9, TelaFuncionariosCOMBOPERFIL.getSelectedItem().toString());

            //verificando se os campos obrigatorios estao preenchidos
            if (TelaFuncionariosID.getText().isEmpty() || TelaFuncionariosNOME.getText().isEmpty() || TelaFuncionariosEMAIL.getText().isEmpty()
                    || TelaFuncionariosUSUARIO.getText().isEmpty() || TelaFuncionariosSENHA.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

                //atualizando a tabela funcionarios com os dados novos do formulario
                //tela de confirmação de inserção de dados
                int adicionado = pst.executeUpdate();
                //teste para verificaer se a variavel está retornando valor
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso!");
                    limpadados();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update funcionarios set nome=?, email=?, endereco=?, bairro=?, cidade=?, usuario=?, senha=?, perfil=? where idFuncionarios=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaFuncionariosNOME.getText());
            pst.setString(2, TelaFuncionariosEMAIL.getText());
            pst.setString(3, TelaFuncionariosENDERECO.getText());
            pst.setString(4, TelaFuncionariosBAIRRO.getText());
            pst.setString(5, TelaFuncionariosCIDADE.getText());
            pst.setString(6, TelaFuncionariosUSUARIO.getText());
            pst.setString(7, TelaFuncionariosSENHA.getText());
            pst.setString(8, TelaFuncionariosCOMBOPERFIL.getSelectedItem().toString());
            pst.setString(9, TelaFuncionariosID.getText());

            if (TelaFuncionariosID.getText().isEmpty() || TelaFuncionariosNOME.getText().isEmpty() || TelaFuncionariosEMAIL.getText().isEmpty()
                    || TelaFuncionariosUSUARIO.getText().isEmpty() || TelaFuncionariosSENHA.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

                //atualizando a tabela funcionarios com os dados novos do formulario
                //tela de confirmação de alteracao de dados
                int adicionado = pst.executeUpdate();
                //teste para verificaer se a variavel está retornando valor
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso!");
                    limpadados();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
        //confirmação de remocao
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma remoção do funcionário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from funcionarios where idFuncionarios=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TelaFuncionariosID.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    limpadados();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TelaFuncionariosID = new javax.swing.JTextField();
        TelaFuncionariosNOME = new javax.swing.JTextField();
        TelaFuncionariosEMAIL = new javax.swing.JTextField();
        TelaFuncionariosBAIRRO = new javax.swing.JTextField();
        TelaFuncionariosCIDADE = new javax.swing.JTextField();
        TelaFuncionariosUSUARIO = new javax.swing.JTextField();
        TelaFuncionariosSENHA = new javax.swing.JTextField();
        TelaFuncionariosENDERECO = new javax.swing.JTextField();
        TelaFuncionariosCOMBOPERFIL = new javax.swing.JComboBox<>();
        TelaFuncionarioButtonCREATE = new javax.swing.JButton();
        TelaFuncionarioButtonSEARCH = new javax.swing.JButton();
        TelaFuncionarioButtonUPDATE = new javax.swing.JButton();
        TelaFuncionarioButtonDELETE = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Funcionários");

        jLabel1.setText("* ID");

        jLabel2.setText("* Nome");

        jLabel3.setText("Cidade");

        jLabel4.setText("* Email");

        jLabel5.setText("Endereço");

        jLabel6.setText("Bairro");

        jLabel7.setText("* Usuário");

        jLabel8.setText("* Senha");

        jLabel9.setText("* Perfil");

        TelaFuncionariosID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaFuncionariosIDActionPerformed(evt);
            }
        });

        TelaFuncionariosCOMBOPERFIL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        TelaFuncionariosCOMBOPERFIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaFuncionariosCOMBOPERFILActionPerformed(evt);
            }
        });

        TelaFuncionarioButtonCREATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/create.png"))); // NOI18N
        TelaFuncionarioButtonCREATE.setToolTipText("Adicionar");
        TelaFuncionarioButtonCREATE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TelaFuncionarioButtonCREATE.setPreferredSize(new java.awt.Dimension(60, 60));
        TelaFuncionarioButtonCREATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaFuncionarioButtonCREATEActionPerformed(evt);
            }
        });

        TelaFuncionarioButtonSEARCH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/search.png"))); // NOI18N
        TelaFuncionarioButtonSEARCH.setToolTipText("Consultar");
        TelaFuncionarioButtonSEARCH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TelaFuncionarioButtonSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaFuncionarioButtonSEARCHActionPerformed(evt);
            }
        });

        TelaFuncionarioButtonUPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/edit.png"))); // NOI18N
        TelaFuncionarioButtonUPDATE.setToolTipText("Editar");
        TelaFuncionarioButtonUPDATE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TelaFuncionarioButtonUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaFuncionarioButtonUPDATEActionPerformed(evt);
            }
        });

        TelaFuncionarioButtonDELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/delete.png"))); // NOI18N
        TelaFuncionarioButtonDELETE.setToolTipText("Deletar");
        TelaFuncionarioButtonDELETE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TelaFuncionarioButtonDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaFuncionarioButtonDELETEActionPerformed(evt);
            }
        });

        jLabel10.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addGap(25, 25, 25))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(40, 40, 40)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TelaFuncionariosUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TelaFuncionariosENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TelaFuncionariosCOMBOPERFIL, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TelaFuncionariosNOME, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addComponent(TelaFuncionariosEMAIL)
                                        .addComponent(TelaFuncionariosID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TelaFuncionariosCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TelaFuncionarioButtonCREATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(TelaFuncionarioButtonSEARCH)
                                .addGap(70, 70, 70)
                                .addComponent(TelaFuncionarioButtonUPDATE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TelaFuncionariosSENHA, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(TelaFuncionariosBAIRRO)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(TelaFuncionarioButtonDELETE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18))))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TelaFuncionarioButtonCREATE, TelaFuncionarioButtonDELETE, TelaFuncionarioButtonSEARCH, TelaFuncionarioButtonUPDATE});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TelaFuncionariosID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelaFuncionariosNOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TelaFuncionariosEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TelaFuncionariosBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaFuncionariosENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TelaFuncionariosCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TelaFuncionariosUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaFuncionariosSENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelaFuncionariosCOMBOPERFIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TelaFuncionarioButtonCREATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaFuncionarioButtonSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaFuncionarioButtonUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaFuncionarioButtonDELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TelaFuncionarioButtonCREATE, TelaFuncionarioButtonDELETE, TelaFuncionarioButtonSEARCH, TelaFuncionarioButtonUPDATE});

        setBounds(0, 0, 751, 583);
    }// </editor-fold>//GEN-END:initComponents

    private void TelaFuncionariosCOMBOPERFILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaFuncionariosCOMBOPERFILActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaFuncionariosCOMBOPERFILActionPerformed

    private void TelaFuncionariosIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaFuncionariosIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaFuncionariosIDActionPerformed

    private void TelaFuncionarioButtonSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaFuncionarioButtonSEARCHActionPerformed
        // TODO add your handling code here:
        consultar();

    }//GEN-LAST:event_TelaFuncionarioButtonSEARCHActionPerformed

    private void TelaFuncionarioButtonCREATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaFuncionarioButtonCREATEActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_TelaFuncionarioButtonCREATEActionPerformed

    private void TelaFuncionarioButtonUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaFuncionarioButtonUPDATEActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_TelaFuncionarioButtonUPDATEActionPerformed

    private void TelaFuncionarioButtonDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaFuncionarioButtonDELETEActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_TelaFuncionarioButtonDELETEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TelaFuncionarioButtonCREATE;
    private javax.swing.JButton TelaFuncionarioButtonDELETE;
    private javax.swing.JButton TelaFuncionarioButtonSEARCH;
    private javax.swing.JButton TelaFuncionarioButtonUPDATE;
    private javax.swing.JTextField TelaFuncionariosBAIRRO;
    private javax.swing.JTextField TelaFuncionariosCIDADE;
    private javax.swing.JComboBox<String> TelaFuncionariosCOMBOPERFIL;
    private javax.swing.JTextField TelaFuncionariosEMAIL;
    private javax.swing.JTextField TelaFuncionariosENDERECO;
    private javax.swing.JTextField TelaFuncionariosID;
    private javax.swing.JTextField TelaFuncionariosNOME;
    private javax.swing.JTextField TelaFuncionariosSENHA;
    private javax.swing.JTextField TelaFuncionariosUSUARIO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
