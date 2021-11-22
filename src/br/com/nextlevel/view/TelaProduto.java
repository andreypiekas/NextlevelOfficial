/*
 * The MIT License
 *
 * Copyright 2021 andrey.piekas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.nextlevel.view;

import br.com.nextlevel.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andrey.piekas
 */
public class TelaProduto extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaProduto
     */
    public TelaProduto() {
        initComponents();
        conexao = ConnectionFactory.getConnection();
    }

    private void limpadados() {
        TelaProdutoID.setText(null);
        TelaProdutoNOME.setText(null);
        TelaProdutoDESCRICAO.setText(null);
        TelaProdutoVALOR.setText(null);
        TelaProdutoPESO.setText(null);

    }

    private void adicionar() {
        String sql = "insert into produto (nome, descricao, valor, peso, categoria) values (?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaProdutoNOME.getText());
            pst.setString(2, TelaProdutoDESCRICAO.getText());
            pst.setString(3, TelaProdutoVALOR.getText());
            
            pst.setString(4, TelaProdutoPESO.getText());
            pst.setString(5, TelaProdutoCOMBOCATEGORIA.getSelectedItem().toString());

            //verificando se os campos obrigatorios estao preenchidos
            if (TelaProdutoNOME.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

                //atualizando a tabela funcionarios com os dados novos do formulario
                //tela de confirmação de inserção de dados
                int adicionado = pst.executeUpdate();
                //teste para verificaer se a variavel está retornando valor
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
                    limpadados();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        TelaProdutoID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TelaProdutoNOME = new javax.swing.JTextField();
        TelaProdutoDESCRICAO = new javax.swing.JTextField();
        TelaProdutoVALOR = new javax.swing.JFormattedTextField();
        TelaProdutoCOMBOCATEGORIA = new javax.swing.JComboBox<>();
        TelaProdutoButtonPESQUISAR = new javax.swing.JButton();
        TelaProdutoButtonEXCLUIR = new javax.swing.JButton();
        TelaProdutoButtonNOVO = new javax.swing.JButton();
        TelaProdutoButtonEDITAR = new javax.swing.JButton();
        TelaProdutoPESO = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("ID");

        TelaProdutoID.setEditable(false);

        jLabel2.setText("Nome");

        jLabel3.setText("Descrição");

        jLabel4.setText("Valor");

        jLabel5.setText("Peso");

        jLabel6.setText("Categoria");

        TelaProdutoVALOR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        TelaProdutoCOMBOCATEGORIA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monitores", "Mouse", "Teclado", "CPU", "GPU", "Gabinetes", "Fans", "Coolers", " " }));
        TelaProdutoCOMBOCATEGORIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaProdutoCOMBOCATEGORIAActionPerformed(evt);
            }
        });

        TelaProdutoButtonPESQUISAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/search.png"))); // NOI18N
        TelaProdutoButtonPESQUISAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TelaProdutoButtonPESQUISAR.setPreferredSize(new java.awt.Dimension(60, 60));

        TelaProdutoButtonEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/delete.png"))); // NOI18N
        TelaProdutoButtonEXCLUIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TelaProdutoButtonEXCLUIR.setPreferredSize(new java.awt.Dimension(60, 60));

        TelaProdutoButtonNOVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/create.png"))); // NOI18N
        TelaProdutoButtonNOVO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TelaProdutoButtonNOVO.setPreferredSize(new java.awt.Dimension(60, 60));
        TelaProdutoButtonNOVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaProdutoButtonNOVOActionPerformed(evt);
            }
        });

        TelaProdutoButtonEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/edit.png"))); // NOI18N
        TelaProdutoButtonEDITAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TelaProdutoButtonEDITAR.setPreferredSize(new java.awt.Dimension(60, 60));

        TelaProdutoPESO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TelaProdutoDESCRICAO)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TelaProdutoNOME, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TelaProdutoID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TelaProdutoCOMBOCATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TelaProdutoVALOR, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TelaProdutoPESO, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(TelaProdutoButtonNOVO, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(TelaProdutoButtonEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(TelaProdutoButtonEXCLUIR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(TelaProdutoButtonPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TelaProdutoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TelaProdutoNOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(TelaProdutoDESCRICAO, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TelaProdutoVALOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TelaProdutoPESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TelaProdutoCOMBOCATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelaProdutoButtonNOVO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaProdutoButtonEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaProdutoButtonEXCLUIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaProdutoButtonPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        setBounds(0, 0, 631, 482);
    }// </editor-fold>//GEN-END:initComponents

    private void TelaProdutoCOMBOCATEGORIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaProdutoCOMBOCATEGORIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaProdutoCOMBOCATEGORIAActionPerformed

    private void TelaProdutoButtonNOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaProdutoButtonNOVOActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_TelaProdutoButtonNOVOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TelaProdutoButtonEDITAR;
    private javax.swing.JButton TelaProdutoButtonEXCLUIR;
    private javax.swing.JButton TelaProdutoButtonNOVO;
    private javax.swing.JButton TelaProdutoButtonPESQUISAR;
    private javax.swing.JComboBox<String> TelaProdutoCOMBOCATEGORIA;
    private javax.swing.JTextField TelaProdutoDESCRICAO;
    private javax.swing.JTextField TelaProdutoID;
    private javax.swing.JTextField TelaProdutoNOME;
    private javax.swing.JFormattedTextField TelaProdutoPESO;
    private javax.swing.JFormattedTextField TelaProdutoVALOR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
