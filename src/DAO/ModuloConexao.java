/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import UTIL.LerConfigUTIL;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class ModuloConexao {

    public static Connection conectar() throws FileNotFoundException {
        LerConfigUTIL objLerConfigUTIL = new LerConfigUTIL();
        String Servidor = objLerConfigUTIL.configuracoes().get(0);
        String Banco = objLerConfigUTIL.configuracoes().get(3);
        Connection conexao;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://"+Servidor+":3306/"+Banco+"?characterEncoding=utf-8";
        String user = objLerConfigUTIL.configuracoes().get(1);
        String password = objLerConfigUTIL.configuracoes().get(2);
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
