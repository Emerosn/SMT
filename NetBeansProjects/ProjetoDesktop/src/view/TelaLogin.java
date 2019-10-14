package view;

import com.bulenkov.darcula.DarculaLaf;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;
import model.LogUsr;
import model.AutenticarUsu;

public class TelaLogin extends javax.swing.JFrame {
    
    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JCampoNome = new javax.swing.JTextField();
        JPasswd = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JTituloLogin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSair = new javax.swing.JButton();
        JEntrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Person.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Lock_132673.png"))); // NOI18N

        JCampoNome.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        JCampoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JCampoNomeFocusGained(evt);
            }
        });
        JCampoNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCampoNomeMouseClicked(evt);
            }
        });
        JCampoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCampoNomeActionPerformed(evt);
            }
        });

        JPasswd.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        JPasswd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JPasswdFocusGained(evt);
            }
        });
        JPasswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPasswdMouseClicked(evt);
            }
        });
        JPasswd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JPasswdKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Bem-Vindo(a)");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        JTituloLogin.setBackground(new java.awt.Color(51, 51, 51));
        JTituloLogin.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        JTituloLogin.setForeground(new java.awt.Color(153, 153, 153));
        JTituloLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/design (5).png"))); // NOI18N
        JTituloLogin.setText("    SMT - STUDENT MANAGER TOOL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(JTituloLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JTituloLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jSair.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Turn off.png"))); // NOI18N
        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });

        JEntrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Unlock.png"))); // NOI18N
        JEntrar.setText("Entrar");
        JEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSair, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(JCampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)
                        .addGap(67, 67, 67)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSair, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCampoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCampoNomeActionPerformed

    }//GEN-LAST:event_JCampoNomeActionPerformed

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jSairActionPerformed

    private void JEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEntrarActionPerformed
      
        AutenticarUsu autenticar = new AutenticarUsu();
        
        if(JCampoNome.getText().trim().equals("") || JPasswd.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Você não digitou seu Usuário/Senha!", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else{
            if(autenticar.autenticar(JCampoNome.getText(), JPasswd.getText())){
                try {
                   LogUsr log = new LogUsr();
                   log.setLogNome(JCampoNome.getText());
                   log.setLogUser();
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                }
         
                dispose();
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(null, "Senha ou Usuário, Incorreto, Tente Novamente!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_JEntrarActionPerformed

    private void JPasswdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPasswdKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            AutenticarUsu autenticar = new AutenticarUsu();
        
            if(JCampoNome.getText().trim().equals("") || JPasswd.getText().trim().equals("")){
               JOptionPane.showMessageDialog(null, "Você não digitou seu Usuário/Senha!", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else{
                if(autenticar.autenticar(JCampoNome.getText(), JPasswd.getText())){
                   try {
                      LogUsr log = new LogUsr();
                      log.setLogNome(JCampoNome.getText());
                      log.setLogUser();
                   } catch(SQLException e){
                      JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                   }
         
                   dispose();
                   MenuPrincipal menu = new MenuPrincipal();
                   menu.setVisible(true);
                   menu.setLocationRelativeTo(null);
                } else {
                   JOptionPane.showMessageDialog(null, "Senha ou Usuário, Incorreto, Tente Novamente!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_JPasswdKeyPressed

    private void JCampoNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCampoNomeFocusGained
        
    }//GEN-LAST:event_JCampoNomeFocusGained

    private void JPasswdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPasswdFocusGained
        
    }//GEN-LAST:event_JPasswdFocusGained

    private void JCampoNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCampoNomeMouseClicked
 
    }//GEN-LAST:event_JCampoNomeMouseClicked

    private void JPasswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPasswdMouseClicked

    }//GEN-LAST:event_JPasswdMouseClicked
   
    public static void main(String args[]) {
        
        
       BasicLookAndFeel darcula = new DarculaLaf();
        try {
            UIManager.setLookAndFeel(darcula);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JCampoNome;
    private javax.swing.JButton JEntrar;
    private javax.swing.JPasswordField JPasswd;
    private javax.swing.JLabel JTituloLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jSair;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
