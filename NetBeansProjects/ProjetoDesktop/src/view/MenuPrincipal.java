package view;

import java.awt.BorderLayout;
import model.ConnectionFactory;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LogUsr;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();

        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("SMT - Student Manager Tools");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int answer = JOptionPane.showConfirmDialog(null, "Deseja Fechar o Programa?", null, JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {

                    try {
                        LogUsr log = new LogUsr();
                        log.truncateLog();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                    }
                    System.exit(0);
                }
            }
        });
        try {
            LogUsr log = new LogUsr();
            JNomeUsu.setText(log.getLogUser());

            if (log.getTipoTmp().equalsIgnoreCase("usuario")) {
                textUsu.setText("");
                btnCadastrarUsuario.setVisible(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        }

        DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
        modelo.setNumRows(0);

        try {
            Connection con = new ConnectionFactory().getConnection();
            String query = "SELECT COUNT(CASE WHEN m.strStatusMatricula = 'Matriculado' THEN intMatriculaId END) AS matriculado, COUNT(CASE WHEN m.strStatusMatricula = 'Pendente' THEN intMatriculaId END) AS pendente, t.strDscTurma, t.intCapacidade, t.intVagasOcupadas FROM matricula AS m INNER JOIN turma AS t ON t.intTurmaId = m.intTurmaId GROUP BY m.intTurmaId";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("matriculado"), rs.getInt("pendente"), rs.getString("strDscTurma"), rs.getInt("intCapacidade"), rs.getInt("intVagasOcupadas")});
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        }

        GerarGraphTurma ggt = new GerarGraphTurma("Quantidade de alunos por turma");
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(ggt.getPanel(), BorderLayout.CENTER);
        panel.validate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGerenciarAluno = new javax.swing.JButton();
        textUsu = new javax.swing.JLabel();
        btnGerenciarTurma = new javax.swing.JButton();
        btnGerenciarProfessor = new javax.swing.JButton();
        btnGerenciarCurso = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panelusu = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnCadastrarUsuario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        JNomeUsu = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorio = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(" SMT - Student Manager Tools");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGerenciarAluno.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnGerenciarAluno.setForeground(new java.awt.Color(204, 204, 204));
        btnGerenciarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Table.png"))); // NOI18N
        btnGerenciarAluno.setText("Gerenciar Aluno");
        btnGerenciarAluno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGerenciarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarAlunoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGerenciarAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 281, 42));

        textUsu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        textUsu.setForeground(new java.awt.Color(204, 204, 204));
        textUsu.setText("Usuário");
        jPanel1.add(textUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        btnGerenciarTurma.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnGerenciarTurma.setForeground(new java.awt.Color(204, 204, 204));
        btnGerenciarTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Table.png"))); // NOI18N
        btnGerenciarTurma.setText("Gerenciar Turma");
        btnGerenciarTurma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGerenciarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarTurmaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGerenciarTurma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 281, 40));

        btnGerenciarProfessor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnGerenciarProfessor.setForeground(new java.awt.Color(204, 204, 204));
        btnGerenciarProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Table.png"))); // NOI18N
        btnGerenciarProfessor.setText("Gerenciar Professor");
        btnGerenciarProfessor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGerenciarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarProfessorActionPerformed(evt);
            }
        });
        jPanel1.add(btnGerenciarProfessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 281, 40));

        btnGerenciarCurso.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnGerenciarCurso.setForeground(new java.awt.Color(204, 204, 204));
        btnGerenciarCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Table.png"))); // NOI18N
        btnGerenciarCurso.setText("Gerenciar Curso");
        btnGerenciarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGerenciarCurso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGerenciarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarCursoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGerenciarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 281, 41));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Gestão Escolar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 30));

        panelusu.setBackground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Informações");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Info.png"))); // NOI18N
        jButton1.setText("Sobre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelusuLayout = new javax.swing.GroupLayout(panelusu);
        panelusu.setLayout(panelusuLayout);
        panelusuLayout.setHorizontalGroup(
            panelusuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelusuLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelusuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelusuLayout.setVerticalGroup(
            panelusuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelusuLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel1.add(panelusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 521, 281, -1));
        panelusu.getAccessibleContext().setAccessibleParent(this);

        btnCadastrarUsuario.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCadastrarUsuario.setForeground(new java.awt.Color(204, 204, 204));
        btnCadastrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Table.png"))); // NOI18N
        btnCadastrarUsuario.setText("Gerenciar Usuário");
        btnCadastrarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 281, 41));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        JNomeUsu.setBackground(new java.awt.Color(204, 204, 204));
        JNomeUsu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JNomeUsu.setForeground(new java.awt.Color(51, 51, 255));
        JNomeUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Person.png"))); // NOI18N
        JNomeUsu.setText("jLabel2");
        JNomeUsu.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JNomeUsuAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnSair.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnSair.setForeground(new java.awt.Color(204, 204, 204));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/design (5).png"))); // NOI18N
        jLabel6.setText("STMT - STUDENT MANAGER TOOL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JNomeUsu)
                .addGap(26, 26, 26)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNomeUsu)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("DASHBOARD");

        jTableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Matriculado", "Pendente", "Turma", "Capacidade", "Vagas Ocupadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRelatorio.getTableHeader().setResizingAllowed(false);
        jTableRelatorio.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableRelatorio);
        if (jTableRelatorio.getColumnModel().getColumnCount() > 0) {
            jTableRelatorio.getColumnModel().getColumn(0).setResizable(false);
            jTableRelatorio.getColumnModel().getColumn(1).setResizable(false);
            jTableRelatorio.getColumnModel().getColumn(2).setResizable(false);
            jTableRelatorio.getColumnModel().getColumn(3).setResizable(false);
            jTableRelatorio.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1059, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Relátorio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(457, 457, 457)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(512, 512, 512)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JNomeUsuAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JNomeUsuAncestorAdded

    }//GEN-LAST:event_JNomeUsuAncestorAdded

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int answer = JOptionPane.showConfirmDialog(null, "Deseja realizar o logout?", null, JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            try {
                LogUsr log = new LogUsr();
                log.truncateLog();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
            TelaLogin tl = new TelaLogin();
            tl.setVisible(true);
            tl.setLocationRelativeTo(null);
            tl.setResizable(false);

        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGerenciarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarAlunoActionPerformed
        dispose();
        GerenciarAluno ga = new GerenciarAluno();
        ga.setVisible(true);
        ga.setLocationRelativeTo(null);
        ga.setTitle("Gerenciar Aluno");
    }//GEN-LAST:event_btnGerenciarAlunoActionPerformed

    private void btnGerenciarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarProfessorActionPerformed
        dispose();
        GerenciarProf gf = new GerenciarProf();
        gf.setVisible(true);
        gf.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnGerenciarProfessorActionPerformed

    private void btnGerenciarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarCursoActionPerformed
        dispose();
        GerenciarCurso c = new GerenciarCurso();
        c.setVisible(true);
        c.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnGerenciarCursoActionPerformed

    private void btnGerenciarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarTurmaActionPerformed
        dispose();
        GerenciarTurma gt = new GerenciarTurma();
        gt.setVisible(true);
        gt.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnGerenciarTurmaActionPerformed

    private void btnCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarUsuarioActionPerformed
        dispose();
        GerenciarUsuario gu = new GerenciarUsuario();
        gu.setVisible(true);
        gu.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCadastrarUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Sobre sobre = new Sobre();
        sobre.setVisible(true);
        sobre.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JNomeUsu;
    private javax.swing.JButton btnCadastrarUsuario;
    private javax.swing.JButton btnGerenciarAluno;
    private javax.swing.JButton btnGerenciarCurso;
    private javax.swing.JButton btnGerenciarProfessor;
    private javax.swing.JButton btnGerenciarTurma;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorio;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelusu;
    private javax.swing.JLabel textUsu;
    // End of variables declaration//GEN-END:variables

    private void setContentPane(GerarGraphAluno graph) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
