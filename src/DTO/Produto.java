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
public class Produto {

    private int pro_id;
    private int pro_fkidtipo;
    private String pro_status;
    private String pro_descricao;
    private int pro_estoque_minimo;
    private int pro_estoque_maximo;

    /**
     * @return the pro_id
     */
    public int getPro_id() {
        return pro_id;
    }

    /**
     * @param pro_id the pro_id to set
     */
    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    /**
     * @return the pro_fkidtipo
     */
    public int getPro_fkidtipo() {
        return pro_fkidtipo;
    }

    /**
     * @param pro_fkidtipo the pro_fkidtipo to set
     */
    public void setPro_fkidtipo(int pro_fkidtipo) {
        this.pro_fkidtipo = pro_fkidtipo;
    }

    /**
     * @return the pro_status
     */
    public String getPro_status() {
        return pro_status;
    }

    /**
     * @param pro_status the pro_status to set
     */
    public void setPro_status(String pro_status) {
        this.pro_status = pro_status;
    }

    /**
     * @return the pro_descricao
     */
    public String getPro_descricao() {
        return pro_descricao;
    }

    /**
     * @param pro_descricao the pro_descricao to set
     */
    public void setPro_descricao(String pro_descricao) {
        this.pro_descricao = pro_descricao;
    }

    /**
     * @return the pro_estoque_minimo
     */
    public int getPro_estoque_minimo() {
        return pro_estoque_minimo;
    }

    /**
     * @param pro_estoque_minimo the pro_estoque_minimo to set
     */
    public void setPro_estoque_minimo(int pro_estoque_minimo) {
        this.pro_estoque_minimo = pro_estoque_minimo;
    }

    /**
     * @return the pro_estoque_maximo
     */
    public int getPro_estoque_maximo() {
        return pro_estoque_maximo;
    }

    /**
     * @param pro_estoque_maximo the pro_estoque_maximo to set
     */
    public void setPro_estoque_maximo(int pro_estoque_maximo) {
        this.pro_estoque_maximo = pro_estoque_maximo;
    }
}
