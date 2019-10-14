package view;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import model.Turma;
import utils.FuctionsUtils;

public class TransferToAluno extends javax.swing.JDialog {

    private Connection con = null;
    private String turnoTmp = null;
    private int serieTmp = 0, codMat=0, codTurmaAnt=0;
    private DefaultTableModel modelo = null;

    public TransferToAluno() {
        this.setModal(true);
        initComponents();
        this.con = new ConnectionFactory().getConnection();
        modelo = (DefaultTableModel) table.getModel();
        modelo.setNumRows(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        transfer = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        turma = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        pesquisar = new javax.swing.JButton();
        flag = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        nome = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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
                .addGap(196, 196, 196)
                .addComponent(transfer)
                .addGap(110, 110, 110)
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

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("Transferir Aluno");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("CPF do Aluno");

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        turma.setEditable(false);
        turma.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        turma.setEnabled(false);
        jScrollPane1.setViewportView(turma);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Turmas Disponíveis");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Nome:");

        pesquisar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        flag.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Turma", "Horário Final", "Horário de Inicio", "Capacidade", "Vagas Ocupadas"
            }
        ));
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        nome.setEditable(false);
        nome.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        nome.setEnabled(false);
        jScrollPane3.setViewportView(nome);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Turma Atual:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(pesquisar)))
                        .addContainerGap(352, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(flag)
                .addContainerGap(538, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(flag)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferActionPerformed
        try{
            FuctionsUtils fu = new FuctionsUtils();
            fu.transferAlunoToTurma(codMat, (int)modelo.getValueAt(table.getSelectedRow(), 0), codTurmaAnt);
            JOptionPane.showMessageDialog(null, "Aluno Transferido com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            clearFull();
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Selecione uma Turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_transferActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        try {
            String buscar = "SELECT *"
                    + " FROM pessoa INNER JOIN aluno ON aluno.intPessoaId = pessoa.intPessoaId"
                    + " INNER JOIN matricula ON matricula.intAlunoId = aluno.intAlunoId"
                    + " INNER JOIN turma ON turma.intTurmaId = matricula.intTurmaId"
                    + " INNER JOIN curso ON curso.intCursoId = turma.intCursoId"
                    + " WHERE pessoa.strCpfPessoa = ?";
            PreparedStatement pst = this.con.prepareStatement(buscar);
            pst.setString(1, cpf.getText());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                turma.setText(rs.getString("strDscTurma"));
                turnoTmp = rs.getString("strTurno");
                serieTmp = rs.getInt("intSerie");
                codMat = rs.getInt("intMatriculaId");
                nome.setText(rs.getString("strNomePessoa"));
                codTurmaAnt = rs.getInt("intTurmaId");
            }

            rs.last();
            int countRows = rs.getRow();
            rs.beforeFirst();
            pst.close();
            rs.close();

            if (countRows == 0) {
                JOptionPane.showMessageDialog(null, "Aluno não econtrado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                cpf.setText("");
            }

            FuctionsUtils fu = new FuctionsUtils();

            if (fu.turmasDisponiveisToOne(turnoTmp, serieTmp).isEmpty()) {
                flag.setText("Não Existe Turmas disponíveis!");
                flag.setForeground(Color.red);
            } else {
                flag.setText("");
                modelo.setNumRows(0);
                for (Turma lista : fu.turmasDisponiveisToOne(turnoTmp, serieTmp)) {
                    modelo.addRow(new Object[]{
                        lista.getIntTurmaId(),
                        lista.getStrDscTurma(),
                        lista.getStrHorarioInicio(),
                        lista.getStrHorarioFinal(),
                        lista.getIntCapacidade(),
                        lista.getIntVagasOcupadas()
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_pesquisarActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        transfer.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked
    
    public void clearFull(){
        turma.setText("");
        nome.setText("");
        cpf.setText("");
        for(int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
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
            java.util.logging.Logger.getLogger(TransferToAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransferToAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransferToAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransferToAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransferToAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JLabel flag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane nome;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTable table;
    private javax.swing.JButton transfer;
    private javax.swing.JTextPane turma;
    // End of variables declaration//GEN-END:variables
}
