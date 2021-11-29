/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.nextlevel.view;

import java.sql.*;
import br.com.nextlevel.jdbc.ConnectionFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author andrey gheno piekas
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

//    public String pegarID() {
//        return TelaClientesID.getText();
//
//    }
    private void limpadados() {
        TelaClientesPESQUISAR.setText(null);
        TelaClientesID.setText(null);
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
        ((DefaultTableModel) TelaClientesTABELACLIENTES.getModel()).setRowCount(0);

    }

    private void adicionar() {
        String sql = "insert into clientes (nome, email, cpf, telefone, entrega, cep, rua, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaClientesNOME.getText());
            pst.setString(2, TelaClientesEMAIL.getText());
            pst.setString(3, TelaClientesCPF.getText());
            pst.setString(4, TelaClientesTELEFONE.getText());
            pst.setString(5, TelaClientesENTREGA.getText());
            pst.setString(6, TelaClientesCEP.getText());
            pst.setString(7, TelaClientesRUA.getText());
            pst.setString(8, TelaClientesNUMEROENDERECO.getText());
            pst.setString(9, TelaClientesCOMPLEMENTO.getText());
            pst.setString(10, TelaClientesBAIRRO.getText());
            pst.setString(11, TelaClientesCIDADE.getText());
            pst.setString(12, TelaClientesComboESTADO.getSelectedItem().toString());

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
        // String sql = "select * from clientes where nome like ?";
        String sql = "select idClientes as ID, nome as Nome, email as Email, cpf as CPF, telefone as Telefone, entrega as Entrega, cep as CEP, rua as Rua, numero as Numero, complemento as Compl, bairro as Bairro, cidade as Cidade, estado as Estado from clientes where nome like ?";

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
    public void setar_campos() {
        int setar = TelaClientesTABELACLIENTES.getSelectedRow();
        TelaClientesID.setText(TelaClientesTABELACLIENTES.getModel().getValueAt(setar, 0).toString());
        //return TelaClientesID;
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

        ///
        TelaClientesButtonADICIONAR.setEnabled(false);

    }

    private void alterar() {
        String sql = "update clientes set nome=?, email=?, cpf=?, telefone=?, entrega=?, cep=?, rua=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where idClientes=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaClientesNOME.getText());
            pst.setString(2, TelaClientesEMAIL.getText());
            pst.setString(3, TelaClientesCPF.getText());
            pst.setString(4, TelaClientesTELEFONE.getText());
            pst.setString(5, TelaClientesENTREGA.getText());
            pst.setString(6, TelaClientesCEP.getText());
            pst.setString(7, TelaClientesRUA.getText());
            pst.setString(8, TelaClientesNUMEROENDERECO.getText());
            pst.setString(9, TelaClientesCOMPLEMENTO.getText());
            pst.setString(10, TelaClientesBAIRRO.getText());
            pst.setString(11, TelaClientesCIDADE.getText());
            pst.setString(12, TelaClientesComboESTADO.getSelectedItem().toString());
            pst.setString(13, TelaClientesID.getText());

            if (TelaClientesNOME.getText().isEmpty() || TelaClientesTELEFONE.getText().isEmpty() || TelaClientesEMAIL.getText().isEmpty()
                    || TelaClientesCPF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {
                //atualizando a tabela clientes com os dados novos do formulario
                //tela de confirmação de alteracao de dados
                int adicionado = pst.executeUpdate();
                //teste para verificaer se a variavel está retornando valor
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                    limpadados();
                    TelaClientesButtonADICIONAR.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
        //confirmação de remocao
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma remoção do Cliente?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String endereco = "delete from endereco where Clientes_idClientes = ?";
            String sql = "delete from clientes where idClientes=?";
            try {
                pst = conexao.prepareStatement(endereco);
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TelaClientesID.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                    limpadados();
                    TelaClientesButtonADICIONAR.setEnabled(true);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } else {
        }
    }

    ////////////////////// enderecos
    private void adicionar_endereco() {
        String sql = "insert into endereco (Clientes_idClientes, cep, rua, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?)";
        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaClientesID.getText());
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

    private void pesquisar_cliente_endereco() {
        // String sql = "select * from clientes where nome like ?";
        String sql = "select idEndereco as ID, Clientes_idClientes as Cliente, cep as CEP, rua as RUA, numero as NUMERO ,complemento as Compl, bairro as Bairro, cidade as Cidade, estado as Estado from endereco where Clientes_idClientes like ?";

        try {
            pst = conexao.prepareStatement(sql);
            // passando o conteudo da caixa de pesquisa para o ?
            //o % é a continuacao da string sql
            // pst.setString(1, TelaClientesID.getText());
            pst.setString(1, TelaClientesID.getText() + "%");

            rs = pst.executeQuery();

            ///utilizando a bliblioteca rs2xml.jar para preencher a tabela
            TelaClientesEnderecosTABELA.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void setar_campos_endereco() {
        int setar = TelaClientesEnderecosTABELA.getSelectedRow();
        TelaClientesEnderecosIDENDERECO.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 0).toString());
        TelaClientesID.setText(TelaClientesEnderecosTABELA.getModel().getValueAt(setar, 1).toString());
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

    private void alterar_endereco() {
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

    private void remover_endereco() {
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
        TelaClienteesButtonENDERECOS = new javax.swing.JButton();
        TelaClientesID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TelaClientesEnderecosCEP = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TelaClientesEnderecosRUA = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TelaClientesEnderecosNUMERO = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TelaClientesEnderecosCOMPLEMENTO = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TelaClientesEnderecosBAIRRO = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        TelaClientesEnderecosCIDADE = new javax.swing.JTextField();
        TelaClientesEnderecosCOMBOESTADO = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        TelaClientesEnderecosButtonEXCLUIR = new javax.swing.JButton();
        TelaClientesEnderecosButtonEDITAR = new javax.swing.JButton();
        TelaClientesEnderecosButtonADICIONAR = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        TelaClientesEnderecosTABELA = new javax.swing.JTable();
        TelaClientesEnderecosIDENDERECO = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();

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

        TelaClientesPESQUISAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelaClientesPESQUISARMouseClicked(evt);
            }
        });
        TelaClientesPESQUISAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesPESQUISARActionPerformed(evt);
            }
        });
        TelaClientesPESQUISAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TelaClientesPESQUISARKeyReleased(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/pesquisar.png"))); // NOI18N

        jLabel16.setText("Rua");

        TelaClientesTABELACLIENTES = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TelaClientesTABELACLIENTES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email", "CPF", "Telefone", "Entrega", "CEP", "Rua", "Número", "Compl", "Bairro", "Cidade", "Estado"
            }
        ));
        TelaClientesTABELACLIENTES.setFocusable(false);
        TelaClientesTABELACLIENTES.getTableHeader().setReorderingAllowed(false);
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
        TelaClientesButtonREMOVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesButtonREMOVERActionPerformed(evt);
            }
        });

        TelaClientesButtonEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/edit.png"))); // NOI18N
        TelaClientesButtonEDITAR.setPreferredSize(new java.awt.Dimension(60, 60));
        TelaClientesButtonEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesButtonEDITARActionPerformed(evt);
            }
        });

        TelaClienteesButtonENDERECOS.setText("Endereços");
        TelaClienteesButtonENDERECOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClienteesButtonENDERECOSActionPerformed(evt);
            }
        });

        TelaClientesID.setEnabled(false);
        TelaClientesID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesIDActionPerformed(evt);
            }
        });

        jLabel14.setText("ID");

        jLabel15.setText("Pesquisar");

        TelaClientesEnderecosCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesEnderecosCEPActionPerformed(evt);
            }
        });

        jLabel17.setText("CEP");

        jLabel18.setText("RUA");

        jLabel19.setText("N°");

        jLabel20.setText("Complemento");

        jLabel21.setText("Bairro");

        jLabel22.setText("Cidade");

        TelaClientesEnderecosCOMBOESTADO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "" }));

        jLabel23.setText("Estado");

        TelaClientesEnderecosButtonEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/delete.png"))); // NOI18N
        TelaClientesEnderecosButtonEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesEnderecosButtonEXCLUIRActionPerformed(evt);
            }
        });

        TelaClientesEnderecosButtonEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/edit.png"))); // NOI18N
        TelaClientesEnderecosButtonEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesEnderecosButtonEDITARActionPerformed(evt);
            }
        });

        TelaClientesEnderecosButtonADICIONAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/create.png"))); // NOI18N
        TelaClientesEnderecosButtonADICIONAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaClientesEnderecosButtonADICIONARActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        TelaClientesEnderecosTABELA = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TelaClientesEnderecosTABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CEP", "RUA", "NUMERO", "COMPLEMENTO", "BAIRRO", "CIDADE", "ESTADO"
            }
        ));
        jScrollPane3.setViewportView(TelaClientesEnderecosTABELA);

        jLabel24.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(TelaClientesPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TelaClientesID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(TelaClientesButtonADICIONAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TelaClientesButtonREMOVER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TelaClientesButtonEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TelaClientesEMAIL, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TelaClientesCOMPLEMENTO, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(TelaClientesRUA, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(TelaClientesNUMEROENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(TelaClientesCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TelaClientesComboESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TelaClienteesButtonENDERECOS))
                            .addComponent(TelaClientesCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelaClientesTELEFONE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(TelaClientesCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TelaClientesENTREGA, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TelaClientesBAIRRO, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TelaClientesNOME)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(43, 43, 43)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(18, 18, 18)
                                        .addComponent(TelaClientesEnderecosBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(TelaClientesEnderecosCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(TelaClientesEnderecosCOMBOESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(18, 18, 18)
                                                .addComponent(TelaClientesEnderecosCOMPLEMENTO))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(18, 18, 18)
                                                .addComponent(TelaClientesEnderecosCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel24)
                                                .addGap(18, 18, 18)
                                                .addComponent(TelaClientesEnderecosIDENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(18, 18, 18)
                                                .addComponent(TelaClientesEnderecosRUA, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(119, 119, 119)
                                                .addComponent(jLabel19)
                                                .addGap(18, 18, 18)
                                                .addComponent(TelaClientesEnderecosNUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TelaClientesEnderecosButtonADICIONAR)
                        .addGap(18, 18, 18)
                        .addComponent(TelaClientesEnderecosButtonEXCLUIR)
                        .addGap(30, 30, 30)
                        .addComponent(TelaClientesEnderecosButtonEDITAR)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TelaClientesPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TelaClientesID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(TelaClientesEnderecosIDENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(TelaClientesEnderecosCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
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
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(TelaClientesTELEFONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TelaClientesCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(TelaClientesENTREGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(10, 10, 10)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(TelaClientesBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(TelaClientesCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(TelaClientesComboESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TelaClienteesButtonENDERECOS))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TelaClientesButtonADICIONAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TelaClientesButtonREMOVER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TelaClientesButtonEDITAR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 8, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TelaClientesEnderecosButtonEDITAR, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TelaClientesEnderecosButtonEXCLUIR, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TelaClientesEnderecosButtonADICIONAR, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(TelaClientesEnderecosRUA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelaClientesEnderecosNUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(TelaClientesEnderecosCOMPLEMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(TelaClientesEnderecosBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(TelaClientesEnderecosCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelaClientesEnderecosCOMBOESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addContainerGap())))
            .addComponent(jSeparator1)
        );

        setBounds(0, 0, 1256, 603);
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

    private void TelaClienteesButtonENDERECOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClienteesButtonENDERECOSActionPerformed
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


    }//GEN-LAST:event_TelaClienteesButtonENDERECOSActionPerformed

    private void TelaClientesButtonEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesButtonEDITARActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_TelaClientesButtonEDITARActionPerformed

    private void TelaClientesButtonREMOVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesButtonREMOVERActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_TelaClientesButtonREMOVERActionPerformed

    private void TelaClientesIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaClientesIDActionPerformed

    private void TelaClientesPESQUISARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesPESQUISARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaClientesPESQUISARActionPerformed

    private void TelaClientesEnderecosCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesEnderecosCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelaClientesEnderecosCEPActionPerformed

    private void TelaClientesEnderecosButtonEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesEnderecosButtonEXCLUIRActionPerformed
        // TODO add your handling code here:
        remover_endereco();
    }//GEN-LAST:event_TelaClientesEnderecosButtonEXCLUIRActionPerformed

    private void TelaClientesEnderecosButtonEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesEnderecosButtonEDITARActionPerformed
        // TODO add your handling code here:
        alterar_endereco();
    }//GEN-LAST:event_TelaClientesEnderecosButtonEDITARActionPerformed

    private void TelaClientesEnderecosButtonADICIONARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelaClientesEnderecosButtonADICIONARActionPerformed
        // TODO add your handling code here:
        adicionar_endereco();
    }//GEN-LAST:event_TelaClientesEnderecosButtonADICIONARActionPerformed

    private void TelaClientesPESQUISARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaClientesPESQUISARMouseClicked
        // TODO add your handling code here:
        pesquisar_cliente();
        pesquisar_cliente_endereco();
    }//GEN-LAST:event_TelaClientesPESQUISARMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TelaClienteesButtonENDERECOS;
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
    private javax.swing.JTextField TelaClientesEnderecosBAIRRO;
    private javax.swing.JButton TelaClientesEnderecosButtonADICIONAR;
    private javax.swing.JButton TelaClientesEnderecosButtonEDITAR;
    private javax.swing.JButton TelaClientesEnderecosButtonEXCLUIR;
    private javax.swing.JTextField TelaClientesEnderecosCEP;
    private javax.swing.JTextField TelaClientesEnderecosCIDADE;
    private javax.swing.JComboBox<String> TelaClientesEnderecosCOMBOESTADO;
    private javax.swing.JTextField TelaClientesEnderecosCOMPLEMENTO;
    private javax.swing.JTextField TelaClientesEnderecosIDENDERECO;
    private javax.swing.JTextField TelaClientesEnderecosNUMERO;
    private javax.swing.JTextField TelaClientesEnderecosRUA;
    private javax.swing.JTable TelaClientesEnderecosTABELA;
    private javax.swing.JTextField TelaClientesID;
    private javax.swing.JTextField TelaClientesNOME;
    private javax.swing.JTextField TelaClientesNUMEROENDERECO;
    private javax.swing.JTextField TelaClientesPESQUISAR;
    private javax.swing.JTextField TelaClientesRUA;
    private javax.swing.JTable TelaClientesTABELACLIENTES;
    private javax.swing.JFormattedTextField TelaClientesTELEFONE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
