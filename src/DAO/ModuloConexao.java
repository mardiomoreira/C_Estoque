/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class ModuloConexao {

    public static Connection conectar() {
        Connection conexao;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/DB_Estoque2?characterEncoding=utf-8";
        String user = "root";
        String password = "1978";
        try {
            conexao = DriverManager.getConnection(url, user, password);
      //      JOptionPane.showMessageDialog(null, "Conectado!!");
            return conexao;
        } catch (SQLException e) {
            System.out.println(e);
        //    JOptionPane.showMessageDialog(null, "<html>Não Conectado!!<br>Erro: "+e);
            return null;
        }
    }
}
