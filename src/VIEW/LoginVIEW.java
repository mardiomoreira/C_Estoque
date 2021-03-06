/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VIEW;

import DAO.UsuarioDAO;
import java.awt.Cursor;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class LoginVIEW extends javax.swing.JFrame {

    /** Creates new form LoginVIEW */
    public LoginVIEW() {
        initComponents();
        btnLogar.requestFocus();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnBackGroud = new javax.swing.JPanel();
        jlbConfig = new javax.swing.JLabel();
        btnLogar = new javax.swing.JButton();
        jlbEmail = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jlbSenha = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jlbSair = new javax.swing.JLabel();
        jlbImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpnBackGroud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbConfig.setBackground(new java.awt.Color(255, 255, 255));
        jlbConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/config.png"))); // NOI18N
        jlbConfig.setOpaque(true);
        jlbConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbConfigMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbConfigMouseEntered(evt);
            }
        });
        jpnBackGroud.add(jlbConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 40, 40));

        btnLogar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogar.setForeground(new java.awt.Color(255, 51, 51));
        btnLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/login32.png"))); // NOI18N
        btnLogar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogarMouseEntered(evt);
            }
        });
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });
        jpnBackGroud.add(btnLogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 140, -1));

        jlbEmail.setBackground(new java.awt.Color(192, 192, 192));
        jlbEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbEmail.setText("Email:");
        jlbEmail.setOpaque(true);
        jpnBackGroud.add(jlbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 133, 50, 20));

        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
        });
        jpnBackGroud.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 100, -1));

        jlbSenha.setBackground(new java.awt.Color(192, 192, 192));
        jlbSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSenha.setText("Senha:");
        jlbSenha.setOpaque(true);
        jpnBackGroud.add(jlbSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 173, 60, 20));
        jpnBackGroud.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 220, -1));

        jlbSair.setBackground(new java.awt.Color(255, 255, 255));
        jlbSair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fechar32.png"))); // NOI18N
        jlbSair.setOpaque(true);
        jlbSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbSairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbSairMouseEntered(evt);
            }
        });
        jpnBackGroud.add(jlbSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 40, 40));

        jlbImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/backgroud.png"))); // NOI18N
        jpnBackGroud.add(jlbImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnBackGroud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnBackGroud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlbSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbSairMouseClicked
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jlbSairMouseClicked

    private void jlbSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbSairMouseEntered
jlbSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
jlbSair.setToolTipText("Fechar Tela");
    }//GEN-LAST:event_jlbSairMouseEntered

    private void btnLogarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogarMouseEntered
btnLogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
btnLogar.setToolTipText("Logar no Sistema");
    }//GEN-LAST:event_btnLogarMouseEntered

    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        txtSenha.setText("");
    }//GEN-LAST:event_txtSenhaFocusGained

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        String usuario = txtEmail.getText();
        String senha = String.valueOf(txtSenha.getPassword());
        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos s??o obrigat??rios!!!");
            
        } else {
            UsuarioDAO objUsuarioDAO = new UsuarioDAO();
            int resultado= -1;
            try {
                resultado = objUsuarioDAO.logar(usuario, senha);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LoginVIEW.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (resultado > 0) {
                FrmTelaPrincipal objFrmTelaPrincipal = new FrmTelaPrincipal();
                objFrmTelaPrincipal.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Problema Login");
            }
        }
    }//GEN-LAST:event_btnLogarActionPerformed

    private void jlbConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbConfigMouseEntered
jlbConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
jlbConfig.setToolTipText("Configurar Conexao com o Banco MYSQL");
    }//GEN-LAST:event_jlbConfigMouseEntered

    private void jlbConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbConfigMouseClicked
FrmConfiguracaoVIEW objFrmConfiguracaoVIEW = new FrmConfiguracaoVIEW();
objFrmConfiguracaoVIEW.setVisible(true);

    }//GEN-LAST:event_jlbConfigMouseClicked

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
            java.util.logging.Logger.getLogger(LoginVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel jlbConfig;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbImagem;
    private javax.swing.JLabel jlbSair;
    private javax.swing.JLabel jlbSenha;
    private javax.swing.JPanel jpnBackGroud;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

}
