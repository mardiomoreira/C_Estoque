/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class EscreverConfigUTIL {
    
    public void escreverConfig(String servidor, String usuario, String senhaUser, String banco ) throws IOException {
        //Fluxo de saida de um arquivo
        OutputStream os;
        try {
            os = new FileOutputStream("conexao.config"); // nome do arquivo que será escrito
            Writer wr = new OutputStreamWriter(os); // criação de um escritor
            BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

            br.write(servidor);
            br.newLine();
            br.write(usuario);
            br.newLine();
            br.write(senhaUser);
            br.newLine();
            br.write(banco);
//            br.write("Vamos escrever outra linha aqui embaixo hahaha!!!");
            br.close();
            JOptionPane.showMessageDialog(null, "Configurações Salvas com Sucesso!!!");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Configuraçoes, favor entrar em contato com o administrador do Sistema");
            Logger.getLogger(EscreverConfigUTIL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
