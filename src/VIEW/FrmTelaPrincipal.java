/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.ModuloConexao;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mardio
 */
public class FrmTelaPrincipal extends javax.swing.JFrame {

    Connection conexao = null;

    /**
     * Creates new form FrmTelaPrincipal
     */
    public FrmTelaPrincipal() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmProduto = new javax.swing.JMenuItem();
        jmUsuario = new javax.swing.JMenuItem();
        jmEntradaProduto = new javax.swing.JMenuItem();
        jmSaidaProduto = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmProdutopTipo = new javax.swing.JMenuItem();
        jmEntrada = new javax.swing.JMenuItem();
        jmSaidap = new javax.swing.JMenuItem();
        jmRelEstoque = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmSuporte = new javax.swing.JMenuItem();
        jmSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/backgroudInterno.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastro");

        jmProduto.setText("Produto");
        jmProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jmProduto);

        jmUsuario.setText("Usuario");
        jmUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jmUsuario);

        jmEntradaProduto.setText("Entrada de Produto");
        jmEntradaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEntradaProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jmEntradaProduto);

        jmSaidaProduto.setText("Sa??da de Produto");
        jmSaidaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSaidaProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jmSaidaProduto);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Relatorio");

        jmProdutopTipo.setText("Produto");
        jmProdutopTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProdutopTipoActionPerformed(evt);
            }
        });
        jMenu3.add(jmProdutopTipo);

        jmEntrada.setText("Entrada");
        jmEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEntradaActionPerformed(evt);
            }
        });
        jMenu3.add(jmEntrada);

        jmSaidap.setText("Sa??da");
        jmSaidap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSaidapActionPerformed(evt);
            }
        });
        jMenu3.add(jmSaidap);

        jmRelEstoque.setText("Estoque");
        jmRelEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelEstoqueActionPerformed(evt);
            }
        });
        jMenu3.add(jmRelEstoque);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Ajuda");

        jmSuporte.setText("Suporte");
        jmSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSuporteActionPerformed(evt);
            }
        });
        jMenu2.add(jmSuporte);

        jmSair.setText("Sair");
        jmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSairActionPerformed(evt);
            }
        });
        jMenu2.add(jmSair);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSairActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jmSairActionPerformed

    private void jmProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProdutoActionPerformed
        FrmProdutoVIEW objFrmProdutoVIEW;
        try {
            objFrmProdutoVIEW = new FrmProdutoVIEW();
            objFrmProdutoVIEW.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jmProdutoActionPerformed

    private void jmUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmUsuarioActionPerformed
        FrmCadastroUsuarioVIEW objFrmCadastroUsuarioVIEW = new FrmCadastroUsuarioVIEW();
        objFrmCadastroUsuarioVIEW.setVisible(true);
    }//GEN-LAST:event_jmUsuarioActionPerformed

    private void jmEntradaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEntradaProdutoActionPerformed
        FrmEntradaProdutoVIEW objFrmEntradaProdutoVIEW = new FrmEntradaProdutoVIEW();
        objFrmEntradaProdutoVIEW.setVisible(true);
    }//GEN-LAST:event_jmEntradaProdutoActionPerformed

    private void jmSaidaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSaidaProdutoActionPerformed
        FrmSaidaProdutoVIEW objFrmSaidaProdutoVIEW = new FrmSaidaProdutoVIEW();
        objFrmSaidaProdutoVIEW.setVisible(true);
    }//GEN-LAST:event_jmSaidaProdutoActionPerformed

    private void jmSuporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSuporteActionPerformed
        FrmEmailVIEW objFrmEmailVIEW = new FrmEmailVIEW();
        objFrmEmailVIEW.setVisible(true);
    }//GEN-LAST:event_jmSuporteActionPerformed

    private void jmSaidapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSaidapActionPerformed
        ModuloConexao objModuloConexao = new ModuloConexao();
        try {
            conexao = objModuloConexao.conectar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impress??o do Relat??rio?", "Aten????o", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_NO_OPTION) {
            //imorimindo relat??rio com o framework JasperReport
            try {
                //Usando a lasse JasperPrint para preparar a impress??o
                JasperPrint print = JasperFillManager.fillReport("saidap.jasper", null, conexao);
                //a linha abaixo exibe o relatorio atrave??s da Classe JasperVIEW
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_jmSaidapActionPerformed

    private void jmEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEntradaActionPerformed
        ModuloConexao objModuloConexao = new ModuloConexao();
        try {
            conexao = objModuloConexao.conectar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impress??o do Relat??rio?", "Aten????o", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_NO_OPTION) {
            //imorimindo relat??rio com o framework JasperReport
            try {
                //Usando a lasse JasperPrint para preparar a impress??o
                JasperPrint print = JasperFillManager.fillReport("entradap.jasper", null, conexao);
                //a linha abaixo exibe o relatorio atrave??s da Classe JasperVIEW
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jmEntradaActionPerformed

    private void jmProdutopTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProdutopTipoActionPerformed
        ModuloConexao objModuloConexao = new ModuloConexao();
        try {
            conexao = objModuloConexao.conectar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impress??o do Relat??rio?", "Aten????o", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_NO_OPTION) {
            //imorimindo relat??rio com o framework JasperReport
            try {
                //Usando a lasse JasperPrint para preparar a impress??o
                JasperPrint print = JasperFillManager.fillReport("produtoPorTipo.jasper", null, conexao);
                //a linha abaixo exibe o relatorio atrave??s da Classe JasperVIEW
                JasperViewer.viewReport(print, false);
            } catch (JRException erro) {
                System.out.println(erro);
            }
        }
    }//GEN-LAST:event_jmProdutopTipoActionPerformed

    private void jmRelEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelEstoqueActionPerformed
        // Estoque.jasper
                ModuloConexao objModuloConexao = new ModuloConexao();
        try {
            conexao = objModuloConexao.conectar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impress??o do Relat??rio?", "Aten????o", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_NO_OPTION) {
            //imorimindo relat??rio com o framework JasperReport
            try {
                //Usando a lasse JasperPrint para preparar a impress??o
                JasperPrint print = JasperFillManager.fillReport("Estoque.jasper", null, conexao);
                //a linha abaixo exibe o relatorio atrave??s da Classe JasperVIEW
                JasperViewer.viewReport(print, false);
            } catch (JRException erro) {
                System.out.println(erro);
            }
        }
    }//GEN-LAST:event_jmRelEstoqueActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmEntrada;
    private javax.swing.JMenuItem jmEntradaProduto;
    private javax.swing.JMenuItem jmProduto;
    private javax.swing.JMenuItem jmProdutopTipo;
    private javax.swing.JMenuItem jmRelEstoque;
    private javax.swing.JMenuItem jmSaidaProduto;
    private javax.swing.JMenuItem jmSaidap;
    private javax.swing.JMenuItem jmSair;
    private javax.swing.JMenuItem jmSuporte;
    private javax.swing.JMenuItem jmUsuario;
    // End of variables declaration//GEN-END:variables
}
