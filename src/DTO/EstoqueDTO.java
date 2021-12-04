/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mardio
 */
public class EstoqueDTO {

    private int est_id;
    private int est_id_produto;
    private int est_qtde;
    private Double est_valor_unitario;

    /**
     * @return the est_id
     */
    public int getEst_id() {
        return est_id;
    }

    /**
     * @param est_id the est_id to set
     */
    public void setEst_id(int est_id) {
        this.est_id = est_id;
    }

    /**
     * @return the est_id_produto
     */
    public int getEst_id_produto() {
        return est_id_produto;
    }

    /**
     * @param est_id_produto the est_id_produto to set
     */
    public void setEst_id_produto(int est_id_produto) {
        this.est_id_produto = est_id_produto;
    }

    /**
     * @return the est_qtde
     */
    public int getEst_qtde() {
        return est_qtde;
    }

    /**
     * @param est_qtde the est_qtde to set
     */
    public void setEst_qtde(int est_qtde) {
        this.est_qtde = est_qtde;
    }

    /**
     * @return the est_valor_unitario
     */
    public Double getEst_valor_unitario() {
        return est_valor_unitario;
    }

    /**
     * @param est_valor_unitario the est_valor_unitario to set
     */
    public void setEst_valor_unitario(Double est_valor_unitario) {
        this.est_valor_unitario = est_valor_unitario;
    }
}
