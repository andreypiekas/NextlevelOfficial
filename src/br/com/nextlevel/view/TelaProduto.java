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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author andrey.piekas
 */
public class TelaProduto extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

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
                    JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
                    limpadados();
                    pesquisar_produto();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void pesquisar_produto() {
        // String sql = "select * from clientes where nome like ?";
        String sql = "select id as ID, nome as Nome, descricao as Descricao, valor as valor, peso as Peso, categoria as categoria from produto where nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            // passando o conteudo da caixa de pesquisa para o ?
            //o % é a continuacao da string sql
            pst.setString(1, TelaProdutoPESQUISAR.getText() + "%");
            rs = pst.executeQuery();

            ///utilizando a bliblioteca rs2xml.jar para preencher a tabela
            TelaProdutoTABELAPRODUTO.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void pesquisar_produto_categoria() {
        // String sql = "select * from clientes where nome like ?";
        String sql = "select id as ID, nome as Nome, descricao as Descricao, valor as valor, peso as Peso, categoria as categoria from produto where categoria like ?";

        try {
            pst = conexao.prepareStatement(sql);
            // passando o conteudo da caixa de pesquisa para o ?
            //o % é a continuacao da string sql
            pst.setString(1, TelaProdutoCOMBOPESQUISACATEGORIA.getSelectedItem().toString());
            rs = pst.executeQuery();

            ///utilizando a bliblioteca rs2xml.jar para preencher a tabela
            TelaProdutoTABELAPRODUTO.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void setar_campos() {
        int setar = TelaProdutoTABELAPRODUTO.getSelectedRow();
        TelaProdutoID.setText(TelaProdutoTABELAPRODUTO.getModel().getValueAt(setar, 0).toString());
        TelaProdutoNOME.setText(TelaProdutoTABELAPRODUTO.getModel().getValueAt(setar, 1).toString());
        TelaProdutoDESCRICAO.setText(TelaProdutoTABELAPRODUTO.getModel().getValueAt(setar, 2).toString());
        TelaProdutoVALOR.setText(TelaProdutoTABELAPRODUTO.getModel().getValueAt(setar, 3).toString());
        TelaProdutoPESO.setText(TelaProdutoTABELAPRODUTO.getModel().getValueAt(setar, 4).toString());
        TelaProdutoCOMBOCATEGORIA.setSelectedItem(TelaProdutoTABELAPRODUTO.getModel().getValueAt(setar, 5).toString());

        ///
        TelaProdutoButtonNOVO.setEnabled(false);

    }

    private void alterar() {
        String sql = "update produto set nome=?, descricao=?, valor=?, peso=?, categoria=? where id=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaProdutoNOME.getText());
            pst.setString(2, TelaProdutoDESCRICAO.getText());
            pst.setString(3, TelaProdutoVALOR.getText());
            pst.setString(4, TelaProdutoPESO.getText());
            pst.setString(5, TelaProdutoCOMBOCATEGORIA.getSelectedItem().toString());

            if (TelaProdutoNOME.getText().isEmpty() || TelaProdutoDESCRICAO.getText().isEmpty() || TelaProdutoVALOR.getText().isEmpty()
                    || TelaProdutoPESO.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

                //atualizando a tabela clientes com os dados novos do formulario
                //tela de confirmação de alteracao de dados
                int adicionado = pst.executeUpdate();
                //teste para verificaer se a variavel está retornando valor
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                    limpadados();
                    pesquisar_produto();
                    TelaProdutoButtonNOVO.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
        //confirmação de remocao
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma remoção do Produto?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from produto where id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TelaProdutoID.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                    limpadados();
                    pesquisar_produto();
                    TelaProdutoButtonNOVO.setEnabled(true);
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
        jPanel1 = new javax.swing.JPanel();
        TelaProdutoPESQUISAR = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TelaProdutoTABELAPRODUTO = new javax.swing.JTable();
        TelaProdutoCOMBOPESQUISACATEGORIA = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

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
        TelaProdutoButtonPESQUISAR.setEnabled(false);
        TelaProdutoButtonPESQUISAR.setPreferredSize(new java.awt.Dimension(60, 60));

        TelaProdutoButtonEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/delete.png"))); // NOI18N
        TelaProdutoButtonEXCLUIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TelaProdutoButtonEXCLUIR.setPreferredSize(new java.awt.Dimension(60, 60));
        TelaProdutoButtonEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaProdutoButtonEXCLUIRActionPerformed(evt);
            }
        });

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
        TelaProdutoButtonEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaProdutoButtonEDITARActionPerformed(evt);
            }
        });

        TelaProdutoPESO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TelaProdutoPESQUISAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelaProdutoPESQUISARMouseClicked(evt);
            }
        });
        TelaProdutoPESQUISAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaProdutoPESQUISARActionPerformed(evt);
            }
        });
        TelaProdutoPESQUISAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TelaProdutoPESQUISARKeyReleased(evt);
            }
        });

        jLabel7.setText("Nome");

        TelaProdutoTABELAPRODUTO = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TelaProdutoTABELAPRODUTO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descricao", "Valor", "Peso", "Categoria"
            }
        ));
        TelaProdutoTABELAPRODUTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelaProdutoTABELAPRODUTOMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TelaProdutoTABELAPRODUTO);

        TelaProdutoCOMBOPESQUISACATEGORIA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monitores", "Mouse", "Teclado", "CPU", "GPU", "Gabinetes", "Fans", "Coolers", " " }));
        TelaProdutoCOMBOPESQUISACATEGORIA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelaProdutoCOMBOPESQUISACATEGORIAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TelaProdutoCOMBOPESQUISACATEGORIAMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TelaProdutoCOMBOPESQUISACATEGORIAMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TelaProdutoCOMBOPESQUISACATEGORIAMouseReleased(evt);
            }
        });

        jLabel8.setText("Categoria");

        jLabel9.setText("Pesquisa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(TelaProdutoPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(TelaProdutoCOMBOPESQUISACATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelaProdutoPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(TelaProdutoCOMBOPESQUISACATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TelaProdutoCOMBOCATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelaProdutoPESO, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addComponent(TelaProdutoButtonNOVO, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(TelaProdutoButtonEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(TelaProdutoButtonEXCLUIR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(TelaProdutoButtonPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TelaProdutoID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelaProdutoNOME, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelaProdutoDESCRICAO, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelaProdutoVALOR, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TelaProdutoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TelaProdutoNOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(TelaProdutoDESCRICAO, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TelaProdutoVALOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TelaProdutoPESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TelaProdutoCOMBOCATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TelaProdutoButtonNOVO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TelaProdutoButtonEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TelaProdutoButtonEXCLUIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TelaProdutoButtonPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        setBounds(0, 0, 761, 462);
    }// </editor-fold>//GEN-END:initComponents

    private void TelaProdutoCOMBOCATEGORIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaProdutoCOMBOCATEGORIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaProdutoCOMBOCATEGORIAActionPerformed

    private void TelaProdutoButtonNOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaProdutoButtonNOVOActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_TelaProdutoButtonNOVOActionPerformed

    private void TelaProdutoButtonEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaProdutoButtonEDITARActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_TelaProdutoButtonEDITARActionPerformed

    private void TelaProdutoButtonEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaProdutoButtonEXCLUIRActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_TelaProdutoButtonEXCLUIRActionPerformed

    private void TelaProdutoTABELAPRODUTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaProdutoTABELAPRODUTOMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_TelaProdutoTABELAPRODUTOMouseClicked

    private void TelaProdutoPESQUISARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaProdutoPESQUISARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaProdutoPESQUISARActionPerformed

    private void TelaProdutoPESQUISARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelaProdutoPESQUISARKeyReleased
        // TODO add your handling code here:
        pesquisar_produto();
    }//GEN-LAST:event_TelaProdutoPESQUISARKeyReleased

    private void TelaProdutoCOMBOPESQUISACATEGORIAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaProdutoCOMBOPESQUISACATEGORIAMouseClicked
        // TODO add your handling code here:
        pesquisar_produto_categoria();
    }//GEN-LAST:event_TelaProdutoCOMBOPESQUISACATEGORIAMouseClicked

    private void TelaProdutoPESQUISARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaProdutoPESQUISARMouseClicked
        // TODO add your handling code here:
        pesquisar_produto();
    }//GEN-LAST:event_TelaProdutoPESQUISARMouseClicked

    private void TelaProdutoCOMBOPESQUISACATEGORIAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaProdutoCOMBOPESQUISACATEGORIAMouseEntered
        // TODO add your handling code here:
        pesquisar_produto_categoria();
    }//GEN-LAST:event_TelaProdutoCOMBOPESQUISACATEGORIAMouseEntered

    private void TelaProdutoCOMBOPESQUISACATEGORIAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaProdutoCOMBOPESQUISACATEGORIAMousePressed
        // TODO add your handling code here:
        pesquisar_produto_categoria();
    }//GEN-LAST:event_TelaProdutoCOMBOPESQUISACATEGORIAMousePressed

    private void TelaProdutoCOMBOPESQUISACATEGORIAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaProdutoCOMBOPESQUISACATEGORIAMouseReleased
        // TODO add your handling code here:
        pesquisar_produto_categoria();
    }//GEN-LAST:event_TelaProdutoCOMBOPESQUISACATEGORIAMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TelaProdutoButtonEDITAR;
    private javax.swing.JButton TelaProdutoButtonEXCLUIR;
    private javax.swing.JButton TelaProdutoButtonNOVO;
    private javax.swing.JButton TelaProdutoButtonPESQUISAR;
    private javax.swing.JComboBox<String> TelaProdutoCOMBOCATEGORIA;
    private javax.swing.JComboBox<String> TelaProdutoCOMBOPESQUISACATEGORIA;
    private javax.swing.JTextField TelaProdutoDESCRICAO;
    private javax.swing.JTextField TelaProdutoID;
    private javax.swing.JTextField TelaProdutoNOME;
    private javax.swing.JFormattedTextField TelaProdutoPESO;
    private javax.swing.JTextField TelaProdutoPESQUISAR;
    private javax.swing.JTable TelaProdutoTABELAPRODUTO;
    private javax.swing.JFormattedTextField TelaProdutoVALOR;
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
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
