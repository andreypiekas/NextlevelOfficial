/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nextlevel.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author andrey.piekas
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        java.sql.Connection conexao = null;
        //Chamando Driver
        String driver = "com.mysql.jdbc.Driver";

        //Informacoes referente ao banco de dados
        final String url = "jdbc:mysql: //localhost:3306/nextlevelpiekas?verifyServerCertificate=false&useSSL=true";
        final String user = "andreypiekas";
        final String password = "piekas123";

        //Estabelecendo a conexao com o banco de dados
        try {

            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (SQLException ex) {
            //a linha abaixo retorna erro na conexao caso a mesma nao de certo e caso de certo, a string de conexao
            //System.out.println(ex);
            
            
            //throw new RuntimeException(ex);
            return null;

            //Lançar um erro na tela do usuário quando o programa executa
//                
//                
//                System.out.println("SQLException: " + ex.getMessage());
//                System.out.println("SQLState: " + ex.getSQLState());
//                System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}
