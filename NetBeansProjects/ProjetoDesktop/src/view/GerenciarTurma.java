package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import model.LogUsr;
import model.Turma;
import model.TurmaDAO;
import utils.FuctionsUtils;

public class GerenciarTurma extends javax.swing.JFrame {

    private Connection con = null;
    private DefaultTableModel model = null;

    public GerenciarTurma() {
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
        this.con = new ConnectionFactory().getConnection();

        LogUsr log = new LogUsr();
        try {
            usu.setText(log.getLogUser());
            if (log.getTipoTmp().equalsIgnoreCase("usuario")) {
                daluno.setVisible(false);
                dprof.setVisible(false);
                excluir.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }

        refreshTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        alterar = new javax.swing.JButton();
        detalhar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usu = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        taluno = new javax.swing.JButton();
        tprof = new javax.swing.JButton();
        daluno = new javax.swing.JButton();
        dprof = new javax.swing.JButton();
        pesquisar = new javax.swing.JTextField();
        search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gerenciar Turma");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(297, 843));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 160, 42));

        detalhar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        detalhar.setForeground(new java.awt.Color(204, 204, 204));
        detalhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/List.png"))); // NOI18N
        detalhar.setText("Detalhar");
        detalhar.setEnabled(false);
        detalhar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        detalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalharActionPerformed(evt);
            }
        });
        jPanel1.add(detalhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 150, 40));

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
        jPanel1.add(excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 160, 40));

        novo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        novo.setForeground(new java.awt.Color(204, 204, 204));
        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        novo.setText("Novo");
        novo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });
        jPanel1.add(novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 160, 44));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/design (3).png"))); // NOI18N
        jLabel1.setText("Gerenciar Turma");

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
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usu)
                .addGap(46, 46, 46)
                .addComponent(home)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(home)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(usu)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabela.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Turma", "Inicio", "Fim", "Capacidade", "Vagas Ocupadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setResizingAllowed(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Opções");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 34, -1, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 92, 243, 10));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 243, 237, 10));

        taluno.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        taluno.setForeground(new java.awt.Color(204, 204, 204));
        taluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Sync_132655.png"))); // NOI18N
        taluno.setText("Transferir Aluno");
        taluno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        taluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                talunoActionPerformed(evt);
            }
        });
        jPanel3.add(taluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 250, 44));

        tprof.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        tprof.setForeground(new java.awt.Color(204, 204, 204));
        tprof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Sync_132655.png"))); // NOI18N
        tprof.setText("Transferir Professor");
        tprof.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tprof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tprofActionPerformed(evt);
            }
        });
        jPanel3.add(tprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 250, 44));

        daluno.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        daluno.setForeground(new java.awt.Color(204, 204, 204));
        daluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete.png"))); // NOI18N
        daluno.setText("Desvincular Aluno");
        daluno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        daluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dalunoActionPerformed(evt);
            }
        });
        jPanel3.add(daluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 240, 44));

        dprof.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        dprof.setForeground(new java.awt.Color(204, 204, 204));
        dprof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete.png"))); // NOI18N
        dprof.setText("Desvincular Professor");
        dprof.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dprof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dprofActionPerformed(evt);
            }
        });
        jPanel3.add(dprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 240, 44));

        pesquisar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pesquisar.setText("turma");
        pesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pesquisarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pesquisarFocusLost(evt);
            }
        });

        search.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        search.setText("Pesquisar");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pesquisar)
                            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dalunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dalunoActionPerformed
        DesvToMat dtm = new DesvToMat();
        dtm.setVisible(true);
        refreshTable();
    }//GEN-LAST:event_dalunoActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        try {
            AlterarTurma at = new AlterarTurma((int) model.getValueAt(tabela.getSelectedRow(), 0));
            at.setVisible(true);
            refreshTable();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_alterarActionPerformed

    private void detalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalharActionPerformed
        try {
            DetalharTurma t = new DetalharTurma((int) model.getValueAt(tabela.getSelectedRow(), 0));
            t.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_detalharActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        try {
            int cod = (int) model.getValueAt(tabela.getSelectedRow(), 0);
            FuctionsUtils fu = new FuctionsUtils();
            if (!fu.isExistTurmaInMat(cod)) {
                if (!fu.isExistTurmaInnerProf(cod)) {
                    TurmaDAO dao = new TurmaDAO();
                    int answer = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir a Turma?", "Excluir", JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        dao.delete(cod);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Existe professores Veinculadas a essa turma, antes de excluir"
                            + " desvincule o professores da turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                ExcluirTurma t = new ExcluirTurma(cod);
                t.setVisible(true);
            }
            refreshTable();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        FormTurma ft = new FormTurma();
        ft.setVisible(true);
        ft.setLocationRelativeTo(null);
        refreshTable();
    }//GEN-LAST:event_novoActionPerformed

    private void talunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_talunoActionPerformed
        TransferToAluno tta = new TransferToAluno();
        tta.setVisible(true);
        refreshTable();
    }//GEN-LAST:event_talunoActionPerformed

    private void tprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tprofActionPerformed
        TransferToProf ttp = new TransferToProf();
        ttp.setVisible(true);
        refreshTable();
    }//GEN-LAST:event_tprofActionPerformed

    private void dprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dprofActionPerformed
        DesTurmaToProf dttp = new DesTurmaToProf();
        dttp.setVisible(true);
        refreshTable();
    }//GEN-LAST:event_dprofActionPerformed

    private void pesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pesquisarFocusGained
        pesquisar.setText("");
    }//GEN-LAST:event_pesquisarFocusGained

    private void pesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pesquisarFocusLost

    }//GEN-LAST:event_pesquisarFocusLost

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        alterar.setEnabled(true);
        excluir.setEnabled(true);
        detalhar.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        dispose();
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
    }//GEN-LAST:event_homeMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        TurmaDAO dao = new TurmaDAO();

        for (Turma lista : dao.listaToSearch(pesquisar.getText())) {
            model.addRow(new Object[]{
                lista.getIntTurmaId(),
                lista.getStrDscTurma(),
                lista.getStrHorarioInicio(),
                lista.getStrHorarioFinal(),
                lista.getIntCapacidade(),
                lista.getIntVagasOcupadas()
            });
        }

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma turma foi encontrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            pesquisar.setText("");
        }
    }//GEN-LAST:event_searchActionPerformed

    public void refreshTable() {
        model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        TurmaDAO dao = new TurmaDAO();

        for (Turma lista : dao.lista()) {
            model.addRow(new Object[]{
                lista.getIntTurmaId(),
                lista.getStrDscTurma(),
                lista.getStrHorarioInicio(),
                lista.getStrHorarioFinal(),
                lista.getIntCapacidade(),
                lista.getIntVagasOcupadas()
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
            java.util.logging.Logger.getLogger(GerenciarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JButton daluno;
    private javax.swing.JButton detalhar;
    private javax.swing.JButton dprof;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton novo;
    private javax.swing.JTextField pesquisar;
    private javax.swing.JButton search;
    private javax.swing.JTable tabela;
    private javax.swing.JButton taluno;
    private javax.swing.JButton tprof;
    private javax.swing.JLabel usu;
    // End of variables declaration//GEN-END:variables
}
