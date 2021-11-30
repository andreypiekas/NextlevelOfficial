/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nextlevel.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author Andrey Gheno Piekas
 * 
 */

// Nesta classe, é somente fornecido uma forma de teste para o banco de dados.
// Ela deve ser executada caso o usuário esteja enfrentando algum problema com a conexão, para verificar o erro que está ocorrendo
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
