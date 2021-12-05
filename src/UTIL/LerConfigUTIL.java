/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mardio
 */
public class LerConfigUTIL {

    /**
     * @param args the command line arguments
     */
    public ArrayList<String> configuracoes() throws FileNotFoundException {
        ArrayList<String> config = new ArrayList<>();
        config.clear();
        FileInputStream stream = new FileInputStream("config/conexao.config");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        try {
            String linha = br.readLine();
            while (linha != null) {
                config.add(linha);
                //System.out.println(linha);
                linha = br.readLine();

            }
            /*
            System.out.println("Servidor: " + config.get(0));
            System.out.println("Usuario: " + config.get(1));
            System.out.println("Senha: " + config.get(2));
            System.out.println("Banco: " + config.get(3));
*/
        } catch (IOException ex) {
            Logger.getLogger(LerConfigUTIL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return config;
    }

}
