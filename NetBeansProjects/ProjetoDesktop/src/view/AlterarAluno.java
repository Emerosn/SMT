package view;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
import model.AlunoDAO;
import model.ConnectionFactory;
import model.GerarComprovante;
import utils.FuctionsUtils;
import utils.validar;

public class AlterarAluno extends javax.swing.JDialog {

    private static int cod, codAluno;
    private String query = null;
    private boolean flag = false;

    public AlterarAluno(int cod) {
        initComponents();
        this.setModal(true);
        this.cod = cod;
        FuctionsUtils fu = new FuctionsUtils();

        try {
            Connection con = new ConnectionFactory().getConnection();
            if (fu.isExistMatInTurma(cod)) {
                this.query = "SELECT p.strNomePessoa, p.strCpfPessoa, p.strRgPessoa, p.strTelPessoa, p.strEmailPessoa, p.strCidadePessoa, p.strEnderecoPessoa, p.strUfPessoa, a.intAlunoId, a.strMaeAluno, a.strPaiAluno, m.strStatusMatricula "
                        + " FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId "
                        + " INNER JOIN matricula AS m ON m.intAlunoId = a.intAlunoId  WHERE p.intPessoaId = ?";
            } else {
                this.flag = true;
                this.query = "SELECT p.strNomePessoa, p.strCpfPessoa, p.strRgPessoa, p.strTelPessoa, p.strEmailPessoa, p.strCidadePessoa, p.strEnderecoPessoa, p.strUfPessoa, a.intAlunoId, a.strMaeAluno, a.strPaiAluno "
                        + " FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId "
                        + " WHERE p.intPessoaId = ?";
                statusAluno.setEnabled(false);
            }
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
                mae.setText(rs.getString("strMaeAluno"));
                pai.setText(rs.getString("strPaiAluno"));
                codAluno = rs.getInt("intAlunoId");

                if (!this.flag) {
                    if (rs.getString("strStatusMatricula").equalsIgnoreCase("matriculado")) {
                        statusAluno.addItem((String) "Matriculado");
                        statusAluno.addItem((String) "Pendente");
                    } else {
                        statusAluno.addItem((String) "Pendente");
                        statusAluno.addItem((String) "Matriculado");
                    }
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

        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pai = new javax.swing.JTextField();
        mae = new javax.swing.JTextField();
        statusAluno = new javax.swing.JComboBox<String>();
        uf = new javax.swing.JComboBox<String>();
        cpf = new javax.swing.JFormattedTextField();
        rg = new javax.swing.JFormattedTextField();
        email = new javax.swing.JTextField();
        tel = new javax.swing.JFormattedTextField();
        cidade = new javax.swing.JTextField();
        endereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Cidade:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel8.setText("ALTERAR ALUNO");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Mãe:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Pai:");

        uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ufActionPerformed(evt);
            }
        });

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        try {
            tel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Endereço:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Cpf:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("RG:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Telefone:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Cidade:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Status:");

        nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Uf:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nome)
                            .addComponent(cpf)
                            .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pai, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mae, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mae, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(pai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(391, 391, 391))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rgActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        validar v = new validar();
        boolean isValidCpf = v.validarCPF(cpf.getText());
        boolean isValidEmail = v.validarEMAIL(email.getText());
        boolean isValidNome = v.pregMathString(nome.getText());
        boolean isValidPai = v.pregMathString(pai.getText());
        boolean isValidMae = v.pregMathString(mae.getText());

        if (!isEmptyCampos()) {
            if (isValidCpf && isValidEmail && isValidMae && isValidNome && isValidPai) {
                int codMat = 0;
                Aluno a = new Aluno();
                AlunoDAO ad = new AlunoDAO();

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
                    ad.alterAluno(a);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }

                try {
                    Connection con = new ConnectionFactory().getConnection();
                    String aluno = "UPDATE aluno SET strMaeAluno = ?, strPaiAluno = ? WHERE intAlunoId = ?";
                    PreparedStatement stmtAluno = con.prepareStatement(aluno);
                    stmtAluno.setString(1, mae.getText());
                    stmtAluno.setString(2, pai.getText());
                    stmtAluno.setInt(3, codAluno);
                    stmtAluno.execute();
                    stmtAluno.close();

                    if (this.flag) {
                        String buscar = "SELECT m.intMatriculaId FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId INNER JOIN matricula AS m ON m.intAlunoId = a.intAlunoId WHERE p.intPessoaId = ?";
                        PreparedStatement stmtB = con.prepareStatement(buscar);
                        stmtB.setInt(1, a.getIntPessoaId());
                        ResultSet rsB = stmtB.executeQuery();

                        while (rsB.next()) {
                            codMat = rsB.getInt("intMatriculaId");
                        }
                        stmtB.close();
                        rsB.close();

                        String update = "UPDATE matricula SET strStatusMatricula = ? WHERE intMatriculaId = ?";
                        PreparedStatement stmtUpdate = con.prepareStatement(update);
                        stmtUpdate.setString(1, (String) statusAluno.getSelectedItem());
                        stmtUpdate.setInt(2, codMat);
                        stmtUpdate.execute();

                        stmtUpdate.close();
                        con.close();
                    }
                    JOptionPane.showMessageDialog(null, "Alterações Efetuada com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                    GerarComprovante gc = new GerarComprovante(cpf.getText());
                    gc.gerarPDF();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } catch (DocumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (!isValidCpf) {
                JOptionPane.showMessageDialog(null, "CPF inválido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!isValidEmail) {
                JOptionPane.showMessageDialog(null, "Email inválido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!isValidMae) {
                JOptionPane.showMessageDialog(null, "Nome da Mãe inválido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!isValidNome) {
                JOptionPane.showMessageDialog(null, "Nome inválido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!isValidPai) {
                JOptionPane.showMessageDialog(null, "Nome do Pai inválido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Existe Campos Vazios!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ufActionPerformed

    private void nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeFocusLost

    }//GEN-LAST:event_nomeFocusLost

    public boolean isEmptyCampos() {
        if (nome.getText().trim().equals("") || rg.getText().trim().equals("") || cpf.getText().trim().equals("")
                || tel.getText().trim().equals("")
                || email.getText().equals("") || cidade.getText().trim().equals("")
                || endereco.getText().trim().equals("")) {
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
            java.util.logging.Logger.getLogger(AlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarAluno(cod).setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTextField mae;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField pai;
    private javax.swing.JFormattedTextField rg;
    private javax.swing.JComboBox<String> statusAluno;
    private javax.swing.JFormattedTextField tel;
    private javax.swing.JComboBox<String> uf;
    // End of variables declaration//GEN-END:variables
}
