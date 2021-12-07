/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class Tipo_produtoDAO {

    Connection Conn;
    PreparedStatement pstm;

    public ResultSet listarTipo() throws FileNotFoundException {
        Conn = new ModuloConexao().conectar();
        String sql = "SELECT * FROM `tbl_tipo_produto` ORDER BY tip_descricao;";
        try {
            pstm = Conn.prepareStatement(sql);
            return pstm.executeQuery();
        } catch (SQLException erro) {
            //System.out.println(erro.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ListarTipo() TipoDAO: " + erro.getMessage());
            return null;
        }

    }
}
