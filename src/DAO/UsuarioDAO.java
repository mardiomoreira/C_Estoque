/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class UsuarioDAO {

    Connection Conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UsuarioDTO> lista = new ArrayList<>();

    public void cadastrarUsuario(UsuarioDTO objUsuarioDTO) {
        Conn = new ModuloConexao().conectar();
        String sql = "INSERT INTO tbl_usuario(`usu_nome`,`usu_email`,`usu_senha`)VALUES(?,?,?);";
        try {
            pstm = Conn.prepareStatement(sql);
            pstm.setString(1, objUsuarioDTO.getUsu_nome());
            pstm.setString(2, objUsuarioDTO.getUsu_email());
            pstm.setString(3, objUsuarioDTO.getUsu_senha());
            pstm.execute();
            pstm.close();
            //JOptionPane.showMessageDialog(null, "<html>O produto <b style='color:#35fc03'>" + objProdutoDTO.getDescricao() + "</b> foi cadastrato com Sucesso!!");
            JOptionPane.showMessageDialog(null, "<html>O usuário <b style='color:#35fc03'>" + objUsuarioDTO.getUsu_nome() + "</b> foi cadastrato com Sucesso!!");
        } catch (SQLException erro) {
            System.out.println("UsuarioDAO erro: " + erro);
            JOptionPane.showMessageDialog(null, "Usuario não Cadastrado, favor contactar o administrador do sistema");
        }
    }

    public int logar(String usuario, String senha) {
        Conn = new ModuloConexao().conectar();
        String sql = "SELECT COUNT(*) AS resultado FROM `tbl_usuario` WHERE usu_email =? AND usu_senha =?;";
        String resultado = null;
        int numero = -1;
        try {
            pstm = Conn.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            while (rs.next()) {
                numero = rs.getInt("resultado");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return numero;
    }
}
