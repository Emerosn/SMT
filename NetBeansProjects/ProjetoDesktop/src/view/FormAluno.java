package view;

import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.ConnectionFactory;
import model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AlunoDAO;
import model.GerarComprovante;
import utils.validar;

public class FormAluno extends javax.swing.JDialog {
    public FormAluno() {
        initComponents();
        this.setModal(true);

        try {
            Connection con = new ConnectionFactory().getConnection();
            String combox = "SELECT strDscTurma, intVagasOcupadas, intCapacidade FROM turma WHERE intVagasOcupadas < intCapacidade";
            PreparedStatement stmt = con.prepareStatement(combox);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                turmaAluno.addItem(rs.getString("strDscTurma"));
            }
            rs.last();
            int countRows = rs.getRow();
            rs.beforeFirst();
            
            if(countRows == 0){
                btnMatricular.setEnabled(false);
                turmaAluno.setEnabled(false);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnMatricular = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        turmaAluno = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        sexoAluno = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cidadeAluno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        enderecoAluno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        statusAluno = new javax.swing.JComboBox<String>();
        dataNasc = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        nomeAluno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nomepai = new javax.swing.JTextField();
        nomemae = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        uf = new javax.swing.JComboBox<String>();
        rgAluno = new javax.swing.JFormattedTextField();
        cpfAluno = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        telefoneAluno = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        emailAluno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Novo Aluno");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        btnMatricular.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnMatricular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Apply.png"))); // NOI18N
        btnMatricular.setText("Matricular");
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
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
                .addGap(323, 323, 323)
                .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Sexo:");

        sexoAluno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Data de Nascimento:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Endereço:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Cidade:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Status");

        statusAluno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matriculado", "Pendente" }));

        dataNasc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Cpf:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Pai:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("Mãe:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setText("Uf:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Rg:");

        uf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        try {
            rgAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            cpfAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Telefone:");

        try {
            telefoneAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Email:");

        emailAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAlunoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Turma:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomemae, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomepai, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(rgAluno)
                        .addComponent(nomeAluno)
                        .addComponent(cpfAluno)
                        .addComponent(telefoneAluno)
                        .addComponent(emailAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(turmaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sexoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(cidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(enderecoAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(enderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sexoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telefoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(turmaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emailAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(statusAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(nomemae, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomepai, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailAlunoActionPerformed

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        if (nomeAluno.getText().trim().equals("") || rgAluno.getText().trim().equals("") || cpfAluno.getText().trim().equals("")
                || telefoneAluno.getText().trim().equals("")
                || emailAluno.getText().equals("") || cidadeAluno.getText().trim().equals("")
                || enderecoAluno.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Existe campos vazios", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                int cod = 0;
                Connection con = new ConnectionFactory().getConnection();
                Aluno a = new Aluno();
                AlunoDAO ad = new AlunoDAO();
                validar v = new validar();
                int choques = -1;
                boolean isValidCpf = v.validarCPF(cpfAluno.getText());
                boolean isValidEmail = v.validarEMAIL(emailAluno.getText());
                choques = v.verficarCHOQUE(cpfAluno.getText());
                boolean isValidNome = v.pregMathString(nomeAluno.getText());
                boolean isValidPai = v.pregMathString(nomepai.getText());
                boolean isValidMae = v.pregMathString(nomemae.getText());

                if (isValidEmail && choques == 0 && isValidCpf && isValidNome && isValidMae && isValidPai) {
                    a.setStrNomePessoa(nomeAluno.getText());
                    a.setStrRgPessoa(rgAluno.getText());
                    a.setStrCpfPessoa(cpfAluno.getText());
                    a.setStrTelPessoa(telefoneAluno.getText());
                    a.setStrEmailPessoa(emailAluno.getText());
                    a.setStrSexoPessoa((String) sexoAluno.getSelectedItem());
                    a.setStrCidadePessoa(cidadeAluno.getText());
                    a.setStrEnderecoPessoa(enderecoAluno.getText());
                    a.setStrMaeAluno(nomemae.getText());
                    a.setStrPaiAluno(nomepai.getText());
                    a.setStrUfPessoa((String) uf.getSelectedItem());
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String dataf = df.format(dataNasc.getDate());
                    a.setDatDataNasc(dataf);
                    cod = ad.insertAluno(a, (String) turmaAluno.getSelectedItem(), (String) statusAluno.getSelectedItem());
                    if (cod != -1) {
                        GerarComprovante gc = new GerarComprovante(cpfAluno.getText());
                        try {
                            gc.gerarPDF();
                        } catch (DocumentException ex) {
                            Logger.getLogger(FormAluno.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(FormAluno.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        int answer = JOptionPane.showConfirmDialog(null, "Aluno Matrículado com Sucesso\n\nDeseja Gerar Comprovante de Matrícula?", null, JOptionPane.YES_NO_OPTION);
                        if (answer == JOptionPane.YES_OPTION) {
                            try {
                                try {
                                    Desktop.getDesktop().open(new File("comprovante" + cod + ".pdf"));
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                                }

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
                if (!isValidEmail) {
                    JOptionPane.showMessageDialog(null, "Email inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (choques > 0) {
                    JOptionPane.showMessageDialog(null, "Aluno Já existe", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!isValidCpf) {
                    JOptionPane.showMessageDialog(null, "CPF inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!isValidNome) {
                    JOptionPane.showMessageDialog(null, "Nome inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!isValidMae) {
                    JOptionPane.showMessageDialog(null, "Nome da Mãe inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!isValidPai) {
                    JOptionPane.showMessageDialog(null, "Nome do Pai inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Data com formato inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnMatricularActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FormAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMatricular;
    private javax.swing.JTextField cidadeAluno;
    private javax.swing.JFormattedTextField cpfAluno;
    private com.toedter.calendar.JDateChooser dataNasc;
    private javax.swing.JTextField emailAluno;
    private javax.swing.JTextField enderecoAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField nomeAluno;
    private javax.swing.JTextField nomemae;
    private javax.swing.JTextField nomepai;
    private javax.swing.JFormattedTextField rgAluno;
    private javax.swing.JComboBox<String> sexoAluno;
    private javax.swing.JComboBox<String> statusAluno;
    private javax.swing.JFormattedTextField telefoneAluno;
    private javax.swing.JComboBox<String> turmaAluno;
    private javax.swing.JComboBox<String> uf;
    // End of variables declaration//GEN-END:variables
}
