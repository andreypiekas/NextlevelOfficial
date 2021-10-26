/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nextlevel.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author andrey.piekas
 */
public class TestaConexao {

    public static void main(String[] args) {

        try {
            ConnectionFactory.getConnection();
            //tela com uma mensagem
            JOptionPane.showMessageDialog(null, "CONEXÃO BEM SUCEDIDA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
