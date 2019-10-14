package view;

import model.ConnectionFactory;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AlunoDAO;
import model.LogUsr;
import utils.FuctionsUtils;

public class GerenciarAluno extends javax.swing.JFrame {

    private DefaultTableModel modelo;

    public GerenciarAluno() {
        initComponents();
        getContentPane().setBackground(Color.DARK_GRAY);
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

        try {
            LogUsr log = new LogUsr();
            usu.setText(log.getLogUser());

            if (log.getTipoTmp().equalsIgnoreCase("usuario")) {
                excluir.setVisible(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        }

        modelo = (DefaultTableModel) TableRelatorioAluno.getModel();
        modelo.setNumRows(0);
        TableRelatorioAluno.setFont(new Font("Dialog", Font.PLAIN, 15));
        try {
            Connection con = new ConnectionFactory().getConnection();
            String queryTable = "SELECT * FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId ";
            PreparedStatement stmtTable = con.prepareStatement(queryTable);
            ResultSet rsTable = stmtTable.executeQuery();

            while (rsTable.next()) {

                modelo.addRow(new Object[]{
                    rsTable.getInt("intPessoaId"),
                    rsTable.getString("strNomePessoa"),
                    rsTable.getString("strMatricula"),
                    rsTable.getString("strEmailPessoa")});
            }
            stmtTable.close();
            rsTable.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pesquisar = new javax.swing.JTextField();
        comprovante = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRelatorioAluno = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        usu = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(297, 843));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNovo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(204, 204, 204));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 133, 44));

        btnAlterar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(204, 204, 204));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Modify.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 120, 42));

        btnPesquisar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(204, 204, 204));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/List.png"))); // NOI18N
        btnPesquisar.setText("Detalhar");
        btnPesquisar.setEnabled(false);
        btnPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 120, 45));

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
        jPanel1.add(excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 130, 45));

        btnFiltrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(204, 204, 204));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        btnFiltrar.setText("Pesquisar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Nome do Aluno");

        comprovante.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comprovante.setForeground(new java.awt.Color(204, 204, 204));
        comprovante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pdf-icon.png"))); // NOI18N
        comprovante.setText("Comprovante");
        comprovante.setEnabled(false);
        comprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprovanteActionPerformed(evt);
            }
        });

        TableRelatorioAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Matrícula", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableRelatorioAluno.getTableHeader().setResizingAllowed(false);
        TableRelatorioAluno.getTableHeader().setReorderingAllowed(false);
        TableRelatorioAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableRelatorioAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableRelatorioAluno);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

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

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/design (3).png"))); // NOI18N
        jLabel4.setText("Gerenciar Aluno");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usu)
                .addGap(46, 46, 46)
                .addComponent(home)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(usu))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(home))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comprovante)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comprovante)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        FormAluno fa = new FormAluno();
        fa.setVisible(true);
        fa.setLocationRelativeTo(null);
        refreshTable();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            AlterarAluno aa = new AlterarAluno(Integer.parseInt(TableRelatorioAluno.getValueAt(TableRelatorioAluno.getSelectedRow(), 0).toString()));
            aa.setVisible(true);
            aa.setLocationRelativeTo(null);
            refreshTable();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou o Aluno!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        try {
            DetalharAluno listar = new DetalharAluno(Integer.parseInt(TableRelatorioAluno.getValueAt(TableRelatorioAluno.getSelectedRow(), 0).toString()));
            listar.setVisible(true);
            listar.setLocationRelativeTo(null);

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou o Aluno!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        modelo = (DefaultTableModel) TableRelatorioAluno.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = new ConnectionFactory().getConnection();
            String queryTable = "SELECT * FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId "
                    + " WHERE p.strNomePessoa LIKE ? ";
            PreparedStatement stmtTable = con.prepareStatement(queryTable);
            stmtTable.setString(1, "%" + pesquisar.getText() + "%");
            ResultSet rsTable = stmtTable.executeQuery();

            while (rsTable.next()) {

                modelo.addRow(new Object[]{
                    rsTable.getInt("intPessoaId"),
                    rsTable.getString("strMatricula"),
                    rsTable.getString("strNomePessoa"),
                    rsTable.getString("strEmailPessoa")
                });
            }
            stmtTable.close();
            rsTable.close();
            con.close();
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhuma aluno(a) foi encontrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                pesquisar.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void comprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprovanteActionPerformed
        try {
            Desktop.getDesktop().open(new File("comprovante" + Integer.parseInt(TableRelatorioAluno.getValueAt(TableRelatorioAluno.getSelectedRow(), 0).toString()) + ".pdf"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou o Aluno!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_comprovanteActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        try {
            FuctionsUtils fu = new FuctionsUtils();
            int cod = Integer.parseInt(TableRelatorioAluno.getValueAt(TableRelatorioAluno.getSelectedRow(), 0).toString());
            if (!fu.isExistMatInTurma(cod)) {

                int answer = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o aluno?", null, JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    AlunoDAO dao = new AlunoDAO();

                    dao.excluirAluno(cod);
                    File file = new File("comprovante" + Integer.parseInt(TableRelatorioAluno.getValueAt(TableRelatorioAluno.getSelectedRow(), 0).toString()) + ".pdf");
                    file.delete();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não e possivel excluir o Aluno, pois o mesmo está veinculado a uma turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou o Aluno!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        refreshTable();
        if (modelo.getRowCount() == 0) {
            btnPesquisar.setEnabled(false);
            btnAlterar.setEnabled(false);
            comprovante.setEnabled(false);
            excluir.setEnabled(false);
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        dispose();
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
    }//GEN-LAST:event_homeMouseClicked

    private void TableRelatorioAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableRelatorioAlunoMouseClicked
        btnPesquisar.setEnabled(true);
        btnAlterar.setEnabled(true);
        comprovante.setEnabled(true);
        excluir.setEnabled(true);
    }//GEN-LAST:event_TableRelatorioAlunoMouseClicked
    public void refreshTable() {
        modelo = (DefaultTableModel) TableRelatorioAluno.getModel();
        modelo.setNumRows(0);
        TableRelatorioAluno.setFont(new Font("Dialog", Font.PLAIN, 15));
        try {
            Connection con = new ConnectionFactory().getConnection();
            String queryTable = "SELECT * FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId ";
            PreparedStatement stmtTable = con.prepareStatement(queryTable);
            ResultSet rsTable = stmtTable.executeQuery();

            while (rsTable.next()) {

                modelo.addRow(new Object[]{
                    rsTable.getInt("intPessoaId"),
                    rsTable.getString("strNomePessoa"),
                    rsTable.getString("strMatricula"),
                    rsTable.getString("strEmailPessoa")});
            }
            stmtTable.close();
            rsTable.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(GerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableRelatorioAluno;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton comprovante;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pesquisar;
    private javax.swing.JLabel usu;
    // End of variables declaration//GEN-END:variables
}
