/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.nextlevel.view;

import java.sql.*;
import br.com.nextlevel.jdbc.ConnectionFactory;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author andre
 */
public class TelaClientes extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaClientes
     */
    public TelaClientes() {
        initComponents();
        conexao = ConnectionFactory.getConnection();
    }

    private void limpadados() {
        TelaClientesNOME.setText(null);
        TelaClientesEMAIL.setText(null);
        TelaClientesCPF.setText(null);
        TelaClientesTELEFONE.setText(null);
        TelaClientesENTREGA.setText(null);
        TelaClientesCEP.setText(null);
        TelaClientesNUMEROENDERECO.setText(null);
        TelaClientesCOMPLEMENTO.setText(null);
        TelaClientesBAIRRO.setText(null);
        TelaClientesCIDADE.setText(null);

    }

    private void adicionar() {
        String sql = "insert into clientes (nome, email, cpf, telefone, entrega, cep, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaClientesNOME.getText());
            pst.setString(2, TelaClientesEMAIL.getText());
            pst.setString(3, TelaClientesCPF.getText());
            //  pst.setString(3, TelaClientesCPF.getValue().toString());

            pst.setString(4, TelaClientesTELEFONE.getText());
            //   pst.setString(4, TelaClientesTELEFONE.getValue().toString());
            pst.setString(5, TelaClientesENTREGA.getText());
            pst.setString(6, TelaClientesCEP.getText());
            pst.setString(7, TelaClientesNUMEROENDERECO.getText());
            pst.setString(8, TelaClientesCOMPLEMENTO.getText());
            pst.setString(9, TelaClientesBAIRRO.getText());
            pst.setString(10, TelaClientesCIDADE.getText());
            pst.setString(11, TelaClientesComboESTADO.getSelectedItem().toString());

            //verificando se os campos obrigatorios estao preenchidos
            if (TelaClientesNOME.getText().isEmpty() || TelaClientesCIDADE.getText().isEmpty()) {
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

    //metodo para pesquisar clinte + filtro por nome
    private void pesquisar_cliente() {
        String sql = "select * from clientes where nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            // passando o conteudo da caixa de pesquisa para o ?
            //o % é a continuacao da string sql
            pst.setString(1, TelaClientesPESQUISAR.getText() + "%");
            rs = pst.executeQuery();

            ///utilizando a bliblioteca rs2xml.jar para preencher a tabela
            TelaClientesTABELACLIENTES.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //metodo para setar os campos do formulario com o conteudo da tabela
    private void setar_campos() {
        int setar = TelaClientesTABELACLIENTES.getSelectedRow();
        TelaClientesNOME.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 1).toString());
        TelaClientesEMAIL.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 2).toString());
        TelaClientesCPF.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 3).toString());
        TelaClientesTELEFONE.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 4).toString());
        TelaClientesENTREGA.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 5).toString());
        TelaClientesCEP.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 6).toString());
        TelaClientesRUA.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 7).toString());
        TelaClientesNUMEROENDERECO.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 8).toString());
        TelaClientesCOMPLEMENTO.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 9).toString());
        TelaClientesBAIRRO.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 10).toString());
        TelaClientesCIDADE.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 11).toString());
        TelaClientesComboESTADO.setSelectedItem(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 12).toString());
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TelaClientesNOME = new javax.swing.JTextField();
        TelaClientesCPF = new javax.swing.JFormattedTextField();
        TelaClientesEMAIL = new javax.swing.JTextField();
        TelaClientesTELEFONE = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        TelaClientesCEP = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        TelaClientesNUMEROENDERECO = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TelaClientesCOMPLEMENTO = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TelaClientesBAIRRO = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TelaClientesCIDADE = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TelaClientesComboESTADO = new javax.swing.JComboBox<>();
        TelaClientesPESQUISAR = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TelaClientesRUA = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TelaClientesTABELACLIENTES = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        TelaClientesENTREGA = new javax.swing.JTextField();
        TelaClientesButtonADICIONAR = new javax.swing.JButton();
        TelaClientesButtonREMOVER = new javax.swing.JButton();
        TelaClientesButtonEDITAR = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(673, 583));
        setRequestFocusEnabled(false);

        jLabel1.setText("* Campos Obrigatórios");

        jLabel2.setText("Nome");

        jLabel3.setText("CPF");

        jLabel4.setText("Email");

        jLabel5.setText("Telefone");

        try {
            TelaClientesCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            TelaClientesTELEFONE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("CEP");

        try {
            TelaClientesCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("Numero");

        TelaClientesNUMEROENDERECO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesNUMEROENDERECOActionPerformed(evt);
            }
        });

        jLabel9.setText("Compl.");

        jLabel10.setText("Bairro");

        jLabel11.setText("Cidade");

        jLabel12.setText("Estado");

        TelaClientesComboESTADO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", " " }));

        TelaClientesPESQUISAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TelaClientesPESQUISARKeyReleased(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/pesquisar.png"))); // NOI18N

        jLabel16.setText("Rua");

        TelaClientesTABELACLIENTES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TelaClientesTABELACLIENTES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelaClientesTABELACLIENTESMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TelaClientesTABELACLIENTES);

        jLabel13.setText("Entrega");

        TelaClientesButtonADICIONAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/create.png"))); // NOI18N
        TelaClientesButtonADICIONAR.setPreferredSize(new java.awt.Dimension(60, 60));
        TelaClientesButtonADICIONAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesButtonADICIONARActionPerformed(evt);
            }
        });

        TelaClientesButtonREMOVER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/delete.png"))); // NOI18N
        TelaClientesButtonREMOVER.setPreferredSize(new java.awt.Dimension(60, 60));

        TelaClientesButtonEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/edit.png"))); // NOI18N
        TelaClientesButtonEDITAR.setPreferredSize(new java.awt.Dimension(60, 60));

        jButton1.setText("Endereços");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TelaClientesEMAIL)
                                    .addComponent(TelaClientesNOME)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TelaClientesCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TelaClientesCOMPLEMENTO)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TelaClientesRUA, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(TelaClientesNUMEROENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TelaClientesTELEFONE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TelaClientesENTREGA, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TelaClientesPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(TelaClientesBAIRRO, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TelaClientesCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TelaClientesComboESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TelaClientesButtonADICIONAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TelaClientesButtonREMOVER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TelaClientesButtonEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(TelaClientesCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(TelaClientesPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelaClientesNOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TelaClientesCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TelaClientesEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TelaClientesTELEFONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(TelaClientesENTREGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TelaClientesCEP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TelaClientesRUA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(TelaClientesNUMEROENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TelaClientesCOMPLEMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TelaClientesBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(TelaClientesCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(TelaClientesComboESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(TelaClientesButtonADICIONAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaClientesButtonREMOVER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelaClientesButtonEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setBounds(0, 0, 751, 583);
    }// </editor-fold>//GEN-END:initComponents

    private void TelaClientesNUMEROENDERECOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesNUMEROENDERECOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaClientesNUMEROENDERECOActionPerformed

    private void TelaClientesButtonADICIONARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesButtonADICIONARActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_TelaClientesButtonADICIONARActionPerformed

    private void TelaClientesPESQUISARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelaClientesPESQUISARKeyReleased
        // TODO add your handling code here:
        // o evento a baixo é do tipo enquanto for digitando em tempo real
        pesquisar_cliente();

    }//GEN-LAST:event_TelaClientesPESQUISARKeyReleased

    private void TelaClientesTABELACLIENTESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaClientesTABELACLIENTESMouseClicked
        // TODO add your handling code here:

        //evento que sera usado para setar os campos da tabela ao click do mouse
        setar_campos();
    }//GEN-LAST:event_TelaClientesTABELACLIENTESMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String sql = "select * from endereco where Clientes_idClientes = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaClientesPESQUISAR.getText());
            rs = pst.executeQuery();
            TelaClientesEnderecos enderecos = new TelaClientesEnderecos();
            enderecos.setVisible(true);
            

        } catch (Exception e) {
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TelaClientesBAIRRO;
    private javax.swing.JButton TelaClientesButtonADICIONAR;
    private javax.swing.JButton TelaClientesButtonEDITAR;
    private javax.swing.JButton TelaClientesButtonREMOVER;
    private javax.swing.JFormattedTextField TelaClientesCEP;
    private javax.swing.JTextField TelaClientesCIDADE;
    private javax.swing.JTextField TelaClientesCOMPLEMENTO;
    private javax.swing.JFormattedTextField TelaClientesCPF;
    private javax.swing.JComboBox<String> TelaClientesComboESTADO;
    private javax.swing.JTextField TelaClientesEMAIL;
    private javax.swing.JTextField TelaClientesENTREGA;
    private javax.swing.JTextField TelaClientesNOME;
    private javax.swing.JTextField TelaClientesNUMEROENDERECO;
    private javax.swing.JTextField TelaClientesPESQUISAR;
    private javax.swing.JTextField TelaClientesRUA;
    private javax.swing.JTable TelaClientesTABELACLIENTES;
    private javax.swing.JFormattedTextField TelaClientesTELEFONE;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
