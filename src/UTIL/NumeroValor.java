/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

/**
 *
 * @author mardio
 */
public class NumeroValor {

    public static boolean validar(String text) {
        try {

            Double.parseDouble(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
