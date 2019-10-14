package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Curso;
import model.CursoDAO;
import model.LogUsr;
import utils.FuctionsUtils;

public class GerenciarCurso extends javax.swing.JFrame {

    private DefaultTableModel model = null;

    public GerenciarCurso() {
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
        refreshTable();
        model = (DefaultTableModel) tabela.getModel();

        try {
            LogUsr log = new LogUsr();
            usu.setText(log.getLogUser());

            if (log.getTipoTmp().equalsIgnoreCase("usuario")) {
                excluir.setVisible(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        turno = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usu = new javax.swing.JLabel();
        home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gerenciar Curso");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(297, 843));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tabela.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Curso", "Duração", "Turno", "Série", "Ano Letivo"
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
        jScrollPane2.setViewportView(tabela);

        turno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        turno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Matutino", "Vespertino", "Noturno" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("Turno");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Filter.png"))); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/design (3).png"))); // NOI18N
        jLabel2.setText("Gerenciar Curso");

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
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
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
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(home))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(usu))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1386, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        FormCurso fc = new FormCurso();
        fc.setVisible(true);
        refreshTable();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        try {
            AlterarCurso ac = new AlterarCurso((int) model.getValueAt(tabela.getSelectedRow(), 0));
            ac.setVisible(true);
            refreshTable();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um curso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_alterarActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        dispose();
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
    }//GEN-LAST:event_homeMouseClicked

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        FuctionsUtils fu = new FuctionsUtils();
        try {
            int cod = (int) model.getValueAt(tabela.getSelectedRow(), 0);
            if (!fu.isExistCursoInTurma(cod)) {
                int answer = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o curso?", null, JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    CursoDAO dao = new CursoDAO();
                    Curso curso = new Curso();
                    curso.setIntCursoId(cod);
                    dao.delete(curso);
              
                    refreshTable();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não e possivel excluir o curso, pois o mesmo se encontra veiculado a uma turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um curso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

        if (model.getRowCount() == 0) {
            alterar.setEnabled(false);
            excluir.setEnabled(false);
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            CursoDAO curso = new CursoDAO();
            SimpleDateFormat df = new SimpleDateFormat("YYYY");
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setNumRows(0);

            for (Curso listar : curso.listarToFilter(turno.getSelectedItem().toString())) {
                model.addRow(new Object[]{
                    listar.getIntCursoId(),
                    listar.getStrNomeCurso(),
                    listar.getIntDurcao(),
                    listar.getStrTurno(),
                    listar.getIntSerie(),
                    df.format(listar.getAnoLetivo())});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum curso foi encontrado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                alterar.setEnabled(false);
                excluir.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        alterar.setEnabled(true);
        excluir.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    public void refreshTable() {
        try {
            CursoDAO curso = new CursoDAO();
            SimpleDateFormat df = new SimpleDateFormat("YYYY");
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setNumRows(0);
            for (Curso listar : curso.listar()) {
                model.addRow(new Object[]{
                    listar.getIntCursoId(),
                    listar.getStrNomeCurso(),
                    listar.getIntDurcao(),
                    listar.getStrTurno(),
                    listar.getIntSerie(),
                    df.format(listar.getAnoLetivo())});
            }
        } catch (Exception e) {
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
            java.util.logging.Logger.getLogger(GerenciarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox turno;
    private javax.swing.JLabel usu;
    // End of variables declaration//GEN-END:variables
}
