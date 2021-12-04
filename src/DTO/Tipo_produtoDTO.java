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
public class Tipo_produtoDTO {

    private int tip_id;
    private String tip_descricao;

    /**
     * @return the tip_id
     */
    public int getTip_id() {
        return tip_id;
    }

    /**
     * @param tip_id the tip_id to set
     */
    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    /**
     * @return the tip_descricao
     */
    public String getTip_descricao() {
        return tip_descricao;
    }

    /**
     * @param tip_descricao the tip_descricao to set
     */
    public void setTip_descricao(String tip_descricao) {
        this.tip_descricao = tip_descricao;
    }
}
