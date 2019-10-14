package view;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import model.TurmaProfessor;
import utils.FuctionsUtils;

public class TransferToProf extends javax.swing.JDialog {

    private DefaultTableModel modelatual, modelopc, modelrs;
    private Connection con = null;
    private List<Integer> turmaProf = null, turmaId = null;
    private List<TurmaProfessor> lista = null;

    public TransferToProf() {
        this.con = new ConnectionFactory().getConnection();
        this.turmaProf = new ArrayList<>();
        this.lista = new ArrayList<>();
        this.turmaId = new ArrayList<>();

        initComponents();
        this.setModal(true);
        modelopc = (DefaultTableModel) dispo.getModel();
        modelrs = (DefaultTableModel) result.getModel();
        modelatual = (DefaultTableModel) atual.getModel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        transfer = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cpf = new javax.swing.JFormattedTextField();
        pesquisar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nome = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        dispo = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        atual = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        result = new javax.swing.JTable();
        add = new javax.swing.JButton();
        manter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Resetar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("Transferir Professor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(355, 355, 355))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        transfer.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        transfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Sync_132655.png"))); // NOI18N
        transfer.setText("Transferir");
        transfer.setEnabled(false);
        transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(transfer)
                .addGap(55, 55, 55)
                .addComponent(cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("CPF do Professor:");

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        pesquisar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nome:");

        nome.setEditable(false);
        nome.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        nome.setEnabled(false);
        jScrollPane1.setViewportView(nome);

        dispo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Turma", "Curso", "Série", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dispo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dispo);

        atual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Turma", "Curso", "Série", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        atual.getTableHeader().setResizingAllowed(false);
        atual.getTableHeader().setReorderingAllowed(false);
        atual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atualMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(atual);

        result.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Turma", "Curso", "Série", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        result.getTableHeader().setResizingAllowed(false);
        result.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(result);

        add.setText("Adicionar");
        add.setEnabled(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        manter.setText("Manter");
        manter.setEnabled(false);
        manter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manterActionPerformed(evt);
            }
        });

        jLabel3.setText("Atual");

        jLabel5.setText("Disponíveis");

        jLabel6.setText("Resultado");

        Resetar.setText("Resetar");
        Resetar.setEnabled(false);
        Resetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(335, 335, 335))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(manter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add)
                .addGap(245, 245, 245))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Resetar)
                .addGap(220, 220, 220)
                .addComponent(jLabel5)
                .addGap(256, 256, 256))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(87, 87, 87)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(525, 525, 525)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Resetar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(manter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferActionPerformed
        try {
            for (int i = 0; i < modelrs.getRowCount(); i++) {
                turmaId.add((int) modelrs.getValueAt(i, 0));
            }
            for (int i = 0; i < turmaProf.size(); i++) {
                TurmaProfessor tp = new TurmaProfessor();
                tp.setIntTurmaProfId(turmaProf.get(i));
                tp.setIntTurmaId(turmaId.get(i));
                lista.add(tp);
            }
            FuctionsUtils fu = new FuctionsUtils();
            fu.transferProfToTurma(lista);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error ao transferir Professor!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        cpf.setText("");
        ClearFull();
        JOptionPane.showMessageDialog(null, "Professor Transferido com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_transferActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        try {

            String query = "SELECT *"
                    + " FROM pessoa INNER JOIN professor ON professor.intPessoaId = pessoa.intPessoaId"
                    + " INNER JOIN turma_professor ON turma_professor.intProfId = professor.intProfId"
                    + " INNER JOIN turma ON turma.intTurmaId = turma_professor.intTurmaId"
                    + " INNER JOIN curso ON curso.intCursoId = turma.intCursoId"
                    + " WHERE pessoa.strCpfPessoa = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, cpf.getText());
            ResultSet rs = pst.executeQuery();
            modelatual.setNumRows(0);
            while (rs.next()) {
                nome.setText(rs.getString("strNomePessoa"));
                turmaProf.add(rs.getInt("intTurmaProfId"));
                modelatual.addRow(new Object[]{
                    rs.getInt("intTurmaId"),
                    rs.getString("strDscTurma"),
                    rs.getString("strNomeCurso"),
                    rs.getInt("intSerie"),
                    rs.getString("strTurno")
                });
            }
            rs.last();
            int countRows = rs.getRow();
            rs.beforeFirst();

            if (countRows == 0) {
                JOptionPane.showMessageDialog(null, "Nada foi encontrado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                tableDispo();
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_pesquisarActionPerformed

    private void atualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualMouseClicked
        manter.setEnabled(true);
    }//GEN-LAST:event_atualMouseClicked

    private void dispoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dispoMouseClicked
        add.setEnabled(true);
    }//GEN-LAST:event_dispoMouseClicked

    private void manterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manterActionPerformed

        if (modelrs.getRowCount() < modelatual.getRowCount()) {
            try {
                Object[] obj = {modelatual.getValueAt(atual.getSelectedRow(), 0),
                    modelatual.getValueAt(atual.getSelectedRow(), 1),
                    modelatual.getValueAt(atual.getSelectedRow(), 2),
                    modelatual.getValueAt(atual.getSelectedRow(), 3),
                    modelatual.getValueAt(atual.getSelectedRow(), 4)};
                modelrs.addRow(obj);
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Selecione a turma que deseja manter!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você não pode adicionar mais turma, porque excedeu o limite atual!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        if (modelrs.getRowCount() > 0) {
            Resetar.setEnabled(true);
            transfer.setEnabled(true);
        } else {
            Resetar.setEnabled(false);
            transfer.setEnabled(false);
        }
    }//GEN-LAST:event_manterActionPerformed

    private void ResetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetarActionPerformed
        for (int i = 0; i < modelrs.getRowCount(); i++) {
            modelrs.removeRow(i);
        }
        Resetar.setEnabled(false);
        transfer.setEnabled(false);
    }//GEN-LAST:event_ResetarActionPerformed
    private void ClearFull() {
        nome.setText("");
        for (int i = 0; i < modelrs.getRowCount(); i++) {
            modelrs.removeRow(i);
        }
        for (int i = 0; i < modelatual.getRowCount(); i++) {
            modelatual.removeRow(i);
        }
        for (int j = 0; j < modelopc.getRowCount(); j++) {
            modelopc.removeRow(j);
        }
        Resetar.setEnabled(false);
        transfer.setEnabled(false);
    }
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if (modelrs.getRowCount() < modelatual.getRowCount()) {
            try {
                Object[] obj = {modelopc.getValueAt(dispo.getSelectedRow(), 0),
                    modelopc.getValueAt(dispo.getSelectedRow(), 1),
                    modelopc.getValueAt(dispo.getSelectedRow(), 2),
                    modelopc.getValueAt(dispo.getSelectedRow(), 3),
                    modelopc.getValueAt(dispo.getSelectedRow(), 4)};
                modelrs.addRow(obj);
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Selecione a turma que deseja adicionar!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você não pode adicionar mais turma, porque excedeu o limite atual!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        if (modelrs.getRowCount() > 0) {
            Resetar.setEnabled(true);
            transfer.setEnabled(true);
        } else {
            Resetar.setEnabled(false);
            transfer.setEnabled(false);
        }
    }//GEN-LAST:event_addActionPerformed

    public void tableDispo() {
        try {
            String query = "SELECT *"
                    + " FROM turma INNER JOIN curso ON curso.intCursoId = turma.intCursoId";
            PreparedStatement pst = this.con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            modelopc = (DefaultTableModel) dispo.getModel();
            modelopc.setNumRows(0);
            while (rs.next()) {
                modelopc.addRow(new Object[]{
                    rs.getInt("intTurmaId"),
                    rs.getString("strDscTurma"),
                    rs.getString("strNomeCurso"),
                    rs.getInt("intSerie"),
                    rs.getString("strTurno")
                });
            }
            rs.close();
            pst.close();
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
            java.util.logging.Logger.getLogger(TransferToProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransferToProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransferToProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransferToProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransferToProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Resetar;
    private javax.swing.JButton add;
    private javax.swing.JTable atual;
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JTable dispo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton manter;
    private javax.swing.JTextPane nome;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTable result;
    private javax.swing.JButton transfer;
    // End of variables declaration//GEN-END:variables
}
