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
public class Usuario {

    private int usu_id;
    private String usu_nome;
    private String usu_email;
    private String usu_senha;

    /**
     * @return the usu_id
     */
    public int getUsu_id() {
        return usu_id;
    }

    /**
     * @param usu_id the usu_id to set
     */
    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }

    /**
     * @return the usu_nome
     */
    public String getUsu_nome() {
        return usu_nome;
    }

    /**
     * @param usu_nome the usu_nome to set
     */
    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    /**
     * @return the usu_email
     */
    public String getUsu_email() {
        return usu_email;
    }

    /**
     * @param usu_email the usu_email to set
     */
    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    /**
     * @return the usu_senha
     */
    public String getUsu_senha() {
        return usu_senha;
    }

    /**
     * @param usu_senha the usu_senha to set
     */
    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }
}
