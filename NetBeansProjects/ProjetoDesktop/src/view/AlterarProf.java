package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ConnectionFactory;
import model.Professor;
import model.ProfessorDAO;
import utils.validar;

public class AlterarProf extends javax.swing.JDialog {

    public static int cod = 0, codProf = 0;

    public AlterarProf(int cod) {
        initComponents();
        this.cod = cod;

        this.setModal(true);
        this.cod = cod;
        try {
            Connection con = new ConnectionFactory().getConnection();
            String query = "SELECT * "
                    + " FROM pessoa AS p INNER JOIN professor AS pf ON pf.intPessoaId = p.intPessoaId "
                    + " WHERE p.intPessoaId = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, cod);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                nome.setText(rs.getString("strNomePessoa"));
                cpf.setText(rs.getString("strCpfPessoa"));
                rg.setText(rs.getString("strRgPessoa"));
                tel.setText(rs.getString("strTelPessoa"));
                email.setText(rs.getString("strEmailPessoa"));
                cidade.setText(rs.getString("strCidadePessoa"));
                endereco.setText(rs.getString("strEnderecoPessoa"));
                formacao.setText(rs.getString("strFormacaoProf"));
                codProf = rs.getInt("intProfId");

                if (rs.getString("strStatusProf").equalsIgnoreCase("on")) {
                    status.addItem((String) "On");
                    status.addItem((String) "Off");
                } else {
                    status.addItem((String) "Off");
                    status.addItem((String) "On");
                }
                List<String> ufs = new ArrayList<>();
                String ufquery = "SELECT uf FROM uf_estado";
                PreparedStatement pst = con.prepareStatement(ufquery);
                ResultSet rsUf = pst.executeQuery();

                while (rsUf.next()) {
                    if (rs.getString("strUfPessoa").equalsIgnoreCase(rsUf.getString("uf"))) {
                        uf.addItem(rsUf.getString("uf"));
                    } else {
                        ufs.add(rsUf.getString("uf"));
                    }
                }
                for (int i = 0; i < ufs.size(); i++) {
                    uf.addItem(ufs.get(i).toString());
                }
                pst.close();
                rsUf.close();;
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nome = new javax.swing.JTextField();
        cpf = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        rg = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tel = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        formacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        uf = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Uf:");

        try {
            rg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        rg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Formação:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nome:");

        try {
            tel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Cpf:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("RG:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Telefone:");

        uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ufActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Endereço:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Cidade:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Status:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(69, 69, 69)
                        .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(424, 424, 424))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(38, 38, 38)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nome)
                                .addComponent(cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                                .addComponent(rg)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(13, 13, 13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                                .addComponent(tel, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                                .addComponent(cidade, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(formacao, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(45, 45, 45)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(170, 170, 170))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(formacao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(16, 16, 16)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        btnAlterar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Modify.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setPreferredSize(new java.awt.Dimension(105, 37));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(105, 37));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(381, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel8.setText("Alterar Professor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(409, 409, 409))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rgActionPerformed

    private void ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ufActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (!isEmptyCampos()) {

            validar v = new validar();
            int choques = -1;
            boolean isValidCpf = v.validarCPF(cpf.getText());
            boolean isValidEmail = v.validarEMAIL(email.getText());
            boolean isValidNome = v.pregMathString(nome.getText());

            if (isValidEmail && isValidCpf && isValidNome) {
                Professor a = new Professor();
                ProfessorDAO ad = new ProfessorDAO();

                a.setIntPessoaId(cod);
                a.setStrNomePessoa(nome.getText());
                a.setStrCpfPessoa(cpf.getText());
                a.setStrRgPessoa(rg.getText());
                a.setStrEmailPessoa(email.getText());
                a.setStrCidadePessoa(cidade.getText());
                a.setStrEnderecoPessoa(endereco.getText());
                a.setStrTelPessoa(tel.getText());
                a.setStrUfPessoa((String) uf.getSelectedItem());

                try {
                    ad.update(a);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
                try {
                    Connection con = new ConnectionFactory().getConnection();
                    String aluno = "UPDATE professor SET strFormacaoProf = ?, strStatusProf = ? WHERE intProfId = ?";
                    PreparedStatement stmtAluno = con.prepareStatement(aluno);
                    stmtAluno.setString(1, formacao.getText());
                    stmtAluno.setString(2, (String) status.getSelectedItem());
                    stmtAluno.setInt(3, codProf);
                    stmtAluno.execute();
                    stmtAluno.close();

                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "Professor Alterado com Sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            if (!isValidEmail) {
                JOptionPane.showMessageDialog(null, "Email inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (choques > 0) {
                JOptionPane.showMessageDialog(null, "Professor Já existe", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!isValidCpf) {
                JOptionPane.showMessageDialog(null, "CPF inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!isValidNome) {
                JOptionPane.showMessageDialog(null, "Nome inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Existe Campos Vazios!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    public boolean isEmptyCampos() {
        if (cidade.getText().trim().equals("") || nome.getText().trim().equals("") || cpf.getText().trim().equals("")
                || rg.getText().trim().equals("") || tel.getText().trim().equals("") || endereco.getText().trim().equals("")
                || email.getText().trim().equals("")) {
            return true;
        }

        return false;
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
            java.util.logging.Logger.getLogger(AlterarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarProf(cod).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField cidade;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JTextField email;
    private javax.swing.JTextField endereco;
    private javax.swing.JTextField formacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField rg;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JFormattedTextField tel;
    private javax.swing.JComboBox<String> uf;
    // End of variables declaration//GEN-END:variables
}
