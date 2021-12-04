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
public class Saida_produtoDTO {

    private int sai_id;
    private int sai_id_produto;
    private int sai_qtde;
    private Double sai_valor_unitario;
    private Date sai_data_saida;

    /**
     * @return the sai_id
     */
    public int getSai_id() {
        return sai_id;
    }

    /**
     * @param sai_id the sai_id to set
     */
    public void setSai_id(int sai_id) {
        this.sai_id = sai_id;
    }

    /**
     * @return the sai_id_produto
     */
    public int getSai_id_produto() {
        return sai_id_produto;
    }

    /**
     * @param sai_id_produto the sai_id_produto to set
     */
    public void setSai_id_produto(int sai_id_produto) {
        this.sai_id_produto = sai_id_produto;
    }

    /**
     * @return the sai_qtde
     */
    public int getSai_qtde() {
        return sai_qtde;
    }

    /**
     * @param sai_qtde the sai_qtde to set
     */
    public void setSai_qtde(int sai_qtde) {
        this.sai_qtde = sai_qtde;
    }

    /**
     * @return the sai_valor_unitario
     */
    public Double getSai_valor_unitario() {
        return sai_valor_unitario;
    }

    /**
     * @param sai_valor_unitario the sai_valor_unitario to set
     */
    public void setSai_valor_unitario(Double sai_valor_unitario) {
        this.sai_valor_unitario = sai_valor_unitario;
    }

    /**
     * @return the sai_data_saida
     */
    public Date getSai_data_saida() {
        return sai_data_saida;
    }

    /**
     * @param sai_data_saida the sai_data_saida to set
     */
    public void setSai_data_saida(Date sai_data_saida) {
        this.sai_data_saida = sai_data_saida;
    }
    
}
