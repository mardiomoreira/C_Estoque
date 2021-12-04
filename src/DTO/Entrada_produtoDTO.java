/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author mardio
 */
public class Entrada_produtoDTO {
private int ent_id;
private int ent_id_produto;
private int ent_qtde;
private Double ent_valor_unitario;
private Date ent_data_entrada;    

    /**
     * @return the ent_id
     */
    public int getEnt_id() {
        return ent_id;
    }

    /**
     * @param ent_id the ent_id to set
     */
    public void setEnt_id(int ent_id) {
        this.ent_id = ent_id;
    }

    /**
     * @return the ent_id_produto
     */
    public int getEnt_id_produto() {
        return ent_id_produto;
    }

    /**
     * @param ent_id_produto the ent_id_produto to set
     */
    public void setEnt_id_produto(int ent_id_produto) {
        this.ent_id_produto = ent_id_produto;
    }

    /**
     * @return the ent_qtde
     */
    public int getEnt_qtde() {
        return ent_qtde;
    }

    /**
     * @param ent_qtde the ent_qtde to set
     */
    public void setEnt_qtde(int ent_qtde) {
        this.ent_qtde = ent_qtde;
    }

    /**
     * @return the ent_valor_unitario
     */
    public Double getEnt_valor_unitario() {
        return ent_valor_unitario;
    }

    /**
     * @param ent_valor_unitario the ent_valor_unitario to set
     */
    public void setEnt_valor_unitario(Double ent_valor_unitario) {
        this.ent_valor_unitario = ent_valor_unitario;
    }

    /**
     * @return the ent_data_entrada
     */
    public Date getEnt_data_entrada() {
        return ent_data_entrada;
    }

    /**
     * @param ent_data_entrada the ent_data_entrada to set
     */
    public void setEnt_data_entrada(Date ent_data_entrada) {
        this.ent_data_entrada = ent_data_entrada;
    }
}
