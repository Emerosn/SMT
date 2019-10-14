package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LogUsr;
import model.Usuario;
import model.UsuarioDAO;

public class GerenciarUsuario extends javax.swing.JFrame {

    private DefaultTableModel modelo = null;

    public GerenciarUsuario() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int answer = JOptionPane.showConfirmDialog(null, "Deseja Fechar a Janela Atual?", null, JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    dispose();
                    MenuPrincipal m = new MenuPrincipal();
                    m.setVisible(true);
                    m.setLocationRelativeTo(null);
                }
            }
        });
        initComponents();
        modelo = (DefaultTableModel) tabela.getModel();
        refreshToTable();
        
         try {
            LogUsr log = new LogUsr();
            usu.setText(log.getLogUser());
            
            if(log.getTipoTmp().equalsIgnoreCase("usuario")){
                excluir.setVisible(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usu = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnNovo1 = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/design (3).png"))); // NOI18N
        jLabel1.setText("Gerenciar Usuário");

        usu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        usu.setForeground(new java.awt.Color(51, 51, 255));
        usu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Person.png"))); // NOI18N
        usu.setText("jLabel2");

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Home.png"))); // NOI18N
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 760, Short.MAX_VALUE)
                .addComponent(usu)
                .addGap(46, 46, 46)
                .addComponent(home)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(home))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(usu))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "UserName", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(297, 843));

        btnNovo1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnNovo1.setForeground(new java.awt.Color(204, 204, 204));
        btnNovo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        btnNovo1.setText("Novo");
        btnNovo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovo1ActionPerformed(evt);
            }
        });

        alterar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        alterar.setForeground(new java.awt.Color(204, 204, 204));
        alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Modify.png"))); // NOI18N
        alterar.setText("Alterar");
        alterar.setEnabled(false);
        alterar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        excluir.setForeground(new java.awt.Color(204, 204, 204));
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Forbidden_132577.png"))); // NOI18N
        excluir.setText("Excluir");
        excluir.setEnabled(false);
        excluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(btnNovo1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Nome do Usuário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1386, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        dispose();
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
    }//GEN-LAST:event_homeMouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        alterar.setEnabled(true);
        excluir.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovo1ActionPerformed
        FormUsu usu = new FormUsu();
        usu.setVisible(true);
        refreshToTable();
    }//GEN-LAST:event_btnNovo1ActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        try {
            int cod = (int) modelo.getValueAt(tabela.getSelectedRow(), 0);
            if (modelo.getValueAt(tabela.getSelectedRow(), 1).toString().equalsIgnoreCase("admin")) {
                JOptionPane.showMessageDialog(null, "Nada e possivel alterar uma conta Admin!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                AlterarUsuario au = new AlterarUsuario(cod);
                au.setVisible(true);
                refreshToTable();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_alterarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        try {
            int cod = (int) modelo.getValueAt(tabela.getSelectedRow(), 0);
            if (modelo.getValueAt(tabela.getSelectedRow(), 1).toString().equalsIgnoreCase("admin")) {
                JOptionPane.showMessageDialog(null, "Nada e possivel deletar uma conta Admin!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int answer = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Usuário?", null, JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    UsuarioDAO dao = new UsuarioDAO();
                    dao.delete(cod);
                    refreshToTable();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UsuarioDAO dao = new UsuarioDAO();
        modelo.setNumRows(0);
        for (Usuario usu : dao.listarToSearch(nome.getText())) {
            modelo.addRow(new Object[]{
                usu.getIntUsuarioId(),
                usu.getStrUserName(),
                usu.getStrUsuarioTipo()
            });
        }
        nome.setText("");

        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Nada foi encontrado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
           alterar.setEnabled(false);
            excluir.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void refreshToTable() {
        UsuarioDAO dao = new UsuarioDAO();
        modelo.setNumRows(0);
        for (Usuario usu : dao.listar()) {
            modelo.addRow(new Object[]{
                usu.getIntUsuarioId(),
                usu.getStrUserName(),
                usu.getStrUsuarioTipo()
            });
        }
    }

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
            java.util.logging.Logger.getLogger(GerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JButton btnNovo1;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel usu;
    // End of variables declaration//GEN-END:variables
}
