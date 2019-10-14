package view;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import utils.FuctionsUtils;

public class DesTurmaToProf extends javax.swing.JDialog {

    private Connection con = null;
    private DefaultTableModel model = null;

    public DesTurmaToProf() {
        initComponents();
        this.setModal(true);
        this.model = (DefaultTableModel) tabela.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        desvincular = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        pesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nome = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("Desvincular Professor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("CPF:");

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });

        pesquisar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nome:");

        nome.setEditable(false);
        nome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nome.setEnabled(false);
        jScrollPane1.setViewportView(nome);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Turma", "Inicio", "Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Turmas Vinculadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 303, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void desvincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desvincularActionPerformed
        FuctionsUtils fu = new FuctionsUtils();
        fu.deleteProfToTurma(cpf.getText());
        JOptionPane.showMessageDialog(null, "Professor Desvinculado com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        clearToTable();
        nome.setText("");
        cpf.setText("");
        desvincular.setEnabled(false);
    }//GEN-LAST:event_desvincularActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        try {
            this.con = new ConnectionFactory().getConnection();
            String query = "SELECT *"
                    + " FROM pessoa INNER JOIN professor ON professor.intPessoaId = pessoa.intPessoaId"
                    + " INNER JOIN turma_professor ON turma_professor.intProfId = professor.intProfId"
                    + " INNER JOIN turma ON turma.intTurmaId = turma_professor.intTurmaId"
                    + " WHERE pessoa.strCpfPessoa = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, cpf.getText());
            ResultSet rs = pst.executeQuery();
            model.setNumRows(0);
            while (rs.next()) {
                nome.setText(rs.getString("strNomePessoa"));
                model.addRow(new Object[]{
                    rs.getInt("intTurmaId"),
                    rs.getString("strDscTurma"),
                    rs.getString("strHorarioInicio"),
                    rs.getString("strHorarioFinal")
                });
            }

            rs.last();
            int countRows = rs.getRow();
            rs.beforeFirst();

            rs.close();
            pst.close();
            this.con.close();

            if (countRows == 0) {
                JOptionPane.showMessageDialog(null, "Professor não está veinculado a nenhuma turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                desvincular.setEnabled(false);
                clearToTable();
            } else {
                desvincular.setEnabled(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_pesquisarActionPerformed

    public void clearToTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
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
            java.util.logging.Logger.getLogger(DesTurmaToProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesTurmaToProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesTurmaToProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesTurmaToProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesTurmaToProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JButton desvincular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane nome;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
