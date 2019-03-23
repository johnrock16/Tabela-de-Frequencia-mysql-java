/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estatistica.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com o banco de dados
 * @author User
 */
public class ConnectionFactory {

    /**
     * @return Conexão com o banco de dados
     */
    public Connection getConnection() {
        System.out.println("Conectado ao banco de dados");
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/bd_parque", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
