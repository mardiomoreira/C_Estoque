/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Entrada_produtoDTO;
import DTO.ProdutoDTO;
import java.io.FileNotFoundException;
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
public class ProdutoDAO {

    Connection Conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProdutoDTO> lista = new ArrayList<>();
    ArrayList<ProdutoDTO> listaProduto = new ArrayList<>();
    ArrayList<Entrada_produtoDTO> listaEntrada_produtoDTO = new ArrayList<>();

    public void cadastrarUsuario(ProdutoDTO objProdutoDTO) throws FileNotFoundException {
        Conn = new ModuloConexao().conectar();
        String sql = "INSERT INTO tbl_produto(`pro_fkidtipo`,`pro_status`,`pro_descricao`,`pro_estoque_minimo`,`pro_estoque_maximo`)VALUES(?,?,?,?,?);";
        try {
            pstm = Conn.prepareStatement(sql);
            pstm.setInt(1, objProdutoDTO.getPro_fkidtipo());
            pstm.setString(2, objProdutoDTO.getPro_status());
            pstm.setString(3, objProdutoDTO.getPro_descricao());
            pstm.setInt(4, objProdutoDTO.getPro_estoque_minimo());
            pstm.setInt(5, objProdutoDTO.getPro_estoque_maximo());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!!");
        } catch (SQLException erro) {
            System.out.println("ProdutoDAO: " + erro);
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Produto, favor contactar o administrador do sistema!!!");
        }
    }

    public ArrayList<ProdutoDTO> PesquisarProduto() throws FileNotFoundException {
        String sql = "SELECT * FROM `tbl_produto` WHERE `pro_status`='Ativado';";
        Conn = new ModuloConexao().conectar();
        try {
            pstm = Conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                objProdutoDTO.setPro_id(rs.getInt("pro_id"));
                objProdutoDTO.setPro_status(rs.getString("pro_status"));
                objProdutoDTO.setPro_descricao(rs.getString("pro_descricao"));
                objProdutoDTO.setPro_estoque_minimo(rs.getInt("pro_estoque_minimo"));
                objProdutoDTO.setPro_estoque_maximo(rs.getInt("pro_estoque_maximo"));
                listaProduto.add(objProdutoDTO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO: " + erro);
        }
        return listaProduto;
    }

    public void cadastrarEntradaProduto(Entrada_produtoDTO objEntrada_produtoDTO) throws FileNotFoundException {
        Conn = new ModuloConexao().conectar();
        String sql = "INSERT INTO tbl_entrada_produto(`ent_id_produto`,`ent_qtde`,`ent_valor_unitario`,`ent_data_entrada`)VALUES(?,?,?,?);";
        try {
            pstm = Conn.prepareStatement(sql);
            pstm.setInt(1, objEntrada_produtoDTO.getEnt_id_produto());
            pstm.setInt(2, objEntrada_produtoDTO.getEnt_qtde());
            pstm.setDouble(3, objEntrada_produtoDTO.getEnt_valor_unitario());
            pstm.setDate(4, objEntrada_produtoDTO.getEnt_data_entrada());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Entrada Cadastrado com Sucesso!!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Entrada, favor contactar o administrador do sistema!!!");
            System.out.println("ProdutoDAO: "+erro);
        }
    }
}
