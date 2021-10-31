/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.nextlevel.view;

/**
 *
 * @author andre
 */
public class TelaFuncionarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaFuncionarios
     */
    public TelaFuncionarios() {
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Funcionários");

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel3.setText("Cidade");

        jLabel4.setText("Email");

        jLabel5.setText("Endereço");

        jLabel6.setText("Bairro");

        jLabel7.setText("Usuário");

        jLabel8.setText("Senha");

        jLabel9.setText("Perfil");

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

        TelaFuncionarioButtonSEARCH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/search.png"))); // NOI18N
        TelaFuncionarioButtonSEARCH.setToolTipText("Consultar");
        TelaFuncionarioButtonSEARCH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TelaFuncionarioButtonUPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/edit.png"))); // NOI18N
        TelaFuncionarioButtonUPDATE.setToolTipText("Editar");
        TelaFuncionarioButtonUPDATE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TelaFuncionarioButtonDELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/nextlevel/icones/delete.png"))); // NOI18N
        TelaFuncionarioButtonDELETE.setToolTipText("Deletar");
        TelaFuncionarioButtonDELETE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
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
                                .addGap(42, 42, 42)
                                .addComponent(TelaFuncionarioButtonDELETE)))))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TelaFuncionarioButtonCREATE, TelaFuncionarioButtonDELETE, TelaFuncionarioButtonSEARCH, TelaFuncionarioButtonUPDATE});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TelaFuncionariosID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
