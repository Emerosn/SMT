package view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import model.Turma;
import model.TurmaDAO;
import utils.FuctionsUtils;

public class ExcluirTurma extends javax.swing.JDialog {

    private static int cod = 0;
    private Connection con = null;
    private DefaultTableModel modeloAluno = null, modeloTurma = null;
    private String turno = null;
    private int serie = 0, qt = 0;
    private List<Turma> lista = null;
    private List<Integer> matId = null, turmaAnt=null;
    private boolean gatilho = false;

    public ExcluirTurma(int cod) {
        this.cod = cod;
        this.setModal(true);
        initComponents();
        this.con = new ConnectionFactory().getConnection();
        matId = new ArrayList<>();
        turmaAnt = new ArrayList<>();
        
        if (gatilho) {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    JOptionPane.showMessageDialog(null, "Clique em Excluir, para deletar a turma desejada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }

        try {
            String queryA = "SELECT *"
                    + " FROM pessoa INNER JOIN aluno ON aluno.intPessoaId = pessoa.intPessoaId"
                    + " INNER JOIN matricula ON matricula.intAlunoId = aluno.intAlunoId"
                    + " INNER JOIN turma ON turma.intTurmaId = matricula.intTurmaId"
                    + " INNER JOIN curso ON curso.intCursoId = turma.intCursoId"
                    + " WHERE turma.intTurmaId = ?";
            PreparedStatement pstA = this.con.prepareStatement(queryA);
            pstA.setInt(1, cod);
            ResultSet rs = pstA.executeQuery();

            modeloAluno = (DefaultTableModel) alunos.getModel();
            modeloAluno.setNumRows(0);

            while (rs.next()) {
                modeloAluno.addRow(new Object[]{
                    rs.getInt("intPessoaId"),
                    rs.getString("strNomePessoa"),
                    rs.getString("strMatricula")
                });
                matId.add(rs.getInt("intMatriculaId"));
                turmaAnt.add(rs.getInt("intTurmaId"));
                this.turno = rs.getString("strTurno");
                this.serie = rs.getInt("intSerie");
                this.qt = rs.getInt("intVagasOcupadas");
            }
            pstA.close();
            rs.close();
            this.con.close();
            
            FuctionsUtils fu = new FuctionsUtils();
            if (fu.turmasDisponiveis(this.turno, this.serie, this.qt).isEmpty()) {
                flag.setText("Não existe turma com vagas disponíveis!");
                flag.setForeground(Color.red);
            } else {
                transfer.setEnabled(true);
                modeloTurma = (DefaultTableModel) turmas.getModel();
                modeloTurma.setNumRows(0);
                for (Turma rsFetch : fu.turmasDisponiveis(this.turno, this.serie, this.qt)) {
                    modeloTurma.addRow(new Object[]{
                        rsFetch.getIntTurmaId(),
                        rsFetch.getStrDscTurma(),
                        rsFetch.getIntCapacidade(),
                        rsFetch.getIntVagasOcupadas()
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch(NullPointerException e){
             JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alunos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        turmas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        cancelar = new javax.swing.JButton();
        transfer = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        progress = new javax.swing.JProgressBar();
        flag = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alunos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N

        alunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Matrícula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        alunos.getTableHeader().setResizingAllowed(false);
        alunos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(alunos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Turmas Disponíveis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        turmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Turma", "Capacidade", "Vagas Ocupadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        turmas.getTableHeader().setResizingAllowed(false);
        turmas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(turmas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        cancelar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setPreferredSize(new java.awt.Dimension(105, 37));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        transfer.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        transfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Sync_132655.png"))); // NOI18N
        transfer.setText("Transferir");
        transfer.setEnabled(false);
        transfer.setPreferredSize(new java.awt.Dimension(105, 37));
        transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Forbidden_132577.png"))); // NOI18N
        excluir.setText("Excluir");
        excluir.setEnabled(false);
        excluir.setPreferredSize(new java.awt.Dimension(105, 37));
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Excluir Turma");

        progress.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(flag))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(92, 92, 92))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(flag))))
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferActionPerformed
        try {
            int cod = (int) modeloTurma.getValueAt(turmas.getSelectedRow(), 0);
            transfer.setEnabled(false);
            cancelar.setEnabled(false);
            FuctionsUtils fu = new FuctionsUtils();

            this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            this.gatilho = true;
            new Thread() {
                public void run() {
                    for (int i = 0; i < 101; i++) {
                        try {
                            sleep(30);
                            progress.setValue(i);

                            if (progress.getValue() < 100) {
                                flag.setText("Transferindo Alunos...");
                            } else {
                                flag.setText("Concluido");
                                excluir.setEnabled(true);
                            }
                        } catch (InterruptedException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }.start();

            for (int i = 0; i < matId.size(); i++) {
                fu.transferAlunoToTurma(matId.get(i), cod, turmaAnt.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_transferActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.gatilho = false;
        this.cancelar.setEnabled(true);
        TurmaDAO dao = new TurmaDAO();
        
        dao.delete(cod);
        JOptionPane.showMessageDialog(null, "Turma Excluida com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_excluirActionPerformed

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
            java.util.logging.Logger.getLogger(ExcluirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcluirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcluirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcluirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcluirTurma(cod).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alunos;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel flag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JProgressBar progress;
    private javax.swing.JButton transfer;
    private javax.swing.JTable turmas;
    // End of variables declaration//GEN-END:variables
}
