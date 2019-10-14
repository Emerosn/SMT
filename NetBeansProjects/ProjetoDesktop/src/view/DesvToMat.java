package view;

import java.sql.*;
import javax.swing.JOptionPane;
import model.ConnectionFactory;
import utils.FuctionsUtils;

public class DesvToMat extends javax.swing.JDialog {

    public Connection con = null;

    public DesvToMat() {
        initComponents();
        this.setModal(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        desvincular = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        cpf = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        pesquisar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        nome = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        turma = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        turno = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        mat = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        curso = new javax.swing.JTextPane();

        jTextPane4.setEditable(false);
        jTextPane4.setEnabled(false);
        jScrollPane4.setViewportView(jTextPane4);

        jTextPane5.setEditable(false);
        jTextPane5.setEnabled(false);
        jScrollPane5.setViewportView(jTextPane5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("Desvincular Aluno");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(192, 192, 192))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        desvincular.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        desvincular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Forbidden_132577.png"))); // NOI18N
        desvincular.setText("Desvincular");
        desvincular.setEnabled(false);
        desvincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desvincularActionPerformed(evt);
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
                .addGap(167, 167, 167)
                .addComponent(desvincular)
                .addGap(56, 56, 56)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desvincular, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nome:");

        pesquisar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Cpf:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Turno:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Matrícula:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Turma:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Curso:");

        nome.setEditable(false);
        nome.setEnabled(false);
        jScrollPane2.setViewportView(nome);

        turma.setEditable(false);
        turma.setEnabled(false);
        jScrollPane3.setViewportView(turma);

        turno.setEditable(false);
        turno.setEnabled(false);
        jScrollPane6.setViewportView(turno);

        mat.setEditable(false);
        mat.setEnabled(false);
        jScrollPane7.setViewportView(mat);

        curso.setEditable(false);
        curso.setEnabled(false);
        jScrollPane8.setViewportView(curso);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cpf)
                        .addGap(4, 4, 4)))
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void desvincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desvincularActionPerformed
        FuctionsUtils fu = new FuctionsUtils();
        fu.deleteAlunoToTurma(cpf.getText());
        JOptionPane.showMessageDialog(null, "Aluno Desvinculado com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        nome.setText("");
        mat.setText("");
        turma.setText("");
        turno.setText("");
        curso.setText("");
        cpf.setText("");
        desvincular.setEnabled(false);
    }//GEN-LAST:event_desvincularActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        try {
            this.con = new ConnectionFactory().getConnection();
            String query = "SELECT *"
                    + " FROM pessoa INNER JOIN aluno ON aluno.intPessoaId = pessoa.intPessoaId"
                    + " INNER JOIN matricula ON matricula.intAlunoId = aluno.intAlunoId"
                    + " INNER JOIN turma ON turma.intTurmaId = matricula.intTurmaId"
                    + " INNER JOIN curso ON curso.intCursoId = turma.intCursoId"
                    + " WHERE pessoa.strCpfPessoa = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, cpf.getText());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                nome.setText(rs.getString("strNomePessoa"));
                mat.setText(rs.getString("strMatricula"));
                turma.setText(rs.getString("strDscTurma"));
                turno.setText(rs.getString("strTurno"));
                curso.setText(rs.getString("strNomeCurso"));
            }
            rs.last();
            int countRows = rs.getRow();
            rs.beforeFirst();

            if (countRows == 0) {
                JOptionPane.showMessageDialog(null, "Aluno não está veiculado a nenhuma turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                nome.setText("");
                mat.setText("");
                turma.setText("");
                turno.setText("");
                curso.setText("");
                desvincular.setEnabled(false);
            } else {
                desvincular.setEnabled(true);
            }
            rs.close();
            pst.close();
            this.con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_pesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(DesvToMat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesvToMat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesvToMat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesvToMat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesvToMat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JTextPane curso;
    private javax.swing.JButton desvincular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane mat;
    private javax.swing.JTextPane nome;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTextPane turma;
    private javax.swing.JTextPane turno;
    // End of variables declaration//GEN-END:variables
}
