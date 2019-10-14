package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.ConnectionFactory;
import utils.FuctionsUtils;

public class DetalharAluno extends javax.swing.JDialog {

    private static int cod = 0;

    public DetalharAluno(int cod) {
        initComponents();
        this.cod = cod;
        this.setModal(true);
        FuctionsUtils fu = new FuctionsUtils();

        try {
            if (fu.isExistMatInTurma(cod)) {
                Connection con = new ConnectionFactory().getConnection();
                String queryPesquisar = "SELECT * FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId "
                        + " INNER JOIN matricula AS m ON m.intAlunoId = a.intAlunoId "
                        + " INNER JOIN turma AS t ON t.intTurmaId = m.intTurmaId"
                        + " INNER JOIN curso AS c ON c.intCursoId = t.intCursoId WHERE p.intPessoaId = ?";
                PreparedStatement stmt = con.prepareStatement(queryPesquisar);
                stmt.setInt(1, cod);
                ResultSet rs = stmt.executeQuery();

                SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");

                while (rs.next()) {
                    nome.setText(rs.getString("strNomePessoa"));
                    rg.setText(rs.getString("strRgPessoa"));
                    cpf.setText(rs.getString("strCpfPessoa"));
                    mae.setText(rs.getString("strMaeAluno"));
                    pai.setText(rs.getString("strPaiAluno"));
                    datanasc.setText(df.format(rs.getDate("datDataNasc")));
                    end.setText(rs.getString("strEnderecoPessoa"));
                    cidade.setText(rs.getString("strCidadePessoa"));
                    uf.setText(rs.getString("strUfPessoa"));
                    mat.setText(rs.getString("strMatricula"));
                    datamat.setText(df.format(rs.getDate("datDataMatricula")));
                    status.setText(rs.getString("strStatusMatricula"));
                    tel.setText(rs.getString("strTelPessoa"));
                    email.setText(rs.getString("strEmailPessoa"));
                    sexo.setText(rs.getString("strSexoPessoa"));
                    turma.setText(rs.getString("strDscTurma"));
                    if (rs.getString("strStatusMatricula").equalsIgnoreCase("pendente")) {
                        status.setForeground(Color.red);
                    } else {
                        status.setForeground(Color.BLUE);
                    }
                    curso.setText(rs.getString("strNomeCurso"));
                    serie.setText(Integer.toString(rs.getInt("intSerie"))+" °");
                    
                }
                stmt.close();
                rs.close();
                con.close();
            } else {
                Connection con = new ConnectionFactory().getConnection();
                String queryPesquisar = "SELECT * FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId "
                        + " WHERE p.intPessoaId = ?";
                PreparedStatement stmt = con.prepareStatement(queryPesquisar);
                stmt.setInt(1, cod);
                ResultSet rs = stmt.executeQuery();

                SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");

                while (rs.next()) {
                    nome.setText(rs.getString("strNomePessoa"));
                    rg.setText(rs.getString("strRgPessoa"));
                    cpf.setText(rs.getString("strCpfPessoa"));
                    mae.setText(rs.getString("strMaeAluno"));
                    pai.setText(rs.getString("strPaiAluno"));
                    datanasc.setText(df.format(rs.getDate("datDataNasc")));
                    end.setText(rs.getString("strEnderecoPessoa"));
                    cidade.setText(rs.getString("strCidadePessoa"));
                    uf.setText(rs.getString("strUfPessoa"));
                    mat.setText(rs.getString("strMatricula"));
                    tel.setText(rs.getString("strTelPessoa"));
                    email.setText(rs.getString("strEmailPessoa"));
                    sexo.setText(rs.getString("strSexoPessoa"));
                }
                datamat.setText("------------------------------");
                status.setText("------------------------------");
                turma.setText("---------------------");
                curso.setText("---------------------");
                serie.setText("---------------------");
                stmt.close();
                rs.close();
                con.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pai = new javax.swing.JLabel();
        datanasc = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        mae = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sexo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        end = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cidade = new javax.swing.JLabel();
        uf = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        mat = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        datamat = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        turma = new javax.swing.JLabel();
        status2 = new javax.swing.JLabel();
        status3 = new javax.swing.JLabel();
        curso = new javax.swing.JLabel();
        serie = new javax.swing.JLabel();
        status4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aluno"));

        rg.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        rg.setText("Rg:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Cpf:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Mãe:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Nome:");

        pai.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        pai.setText("Pai:");

        datanasc.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        datanasc.setText("Data de Nascimento:");

        nome.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nome.setText("Nome:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setText("Rg:");

        cpf.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cpf.setText("Cpf:");

        mae.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        mae.setText("Mãe:");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel18.setText("Pai:");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel19.setText("Data de Nascimento:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("Email:");

        email.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        email.setText("email");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("Sexo:");

        sexo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        sexo.setText("sexo");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setText("Telefone:");

        tel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tel.setText("tel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mae)
                            .addComponent(pai)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nome)
                                    .addComponent(cpf)
                                    .addComponent(rg))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(53, 53, 53)
                                        .addComponent(email))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(tel))
                                            .addComponent(sexo)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(37, 37, 37)
                        .addComponent(datanasc)))
                .addGap(366, 366, 366))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(nome)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rg)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(sexo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cpf)
                        .addComponent(tel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pai)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(datanasc))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("Cidade:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("Uf:");

        end.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        end.setText("Endereço:");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel20.setText("Endereço:");

        cidade.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cidade.setText("Cidade:");

        uf.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        uf.setText("Uf:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel20)
                    .addComponent(jLabel8))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uf)
                    .addComponent(end)
                    .addComponent(cidade))
                .addContainerGap(885, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(end))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(uf))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Matrícula"));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setText("Data da Matrícula:");

        status.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        status.setText("Status:");

        mat.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        mat.setText("N° de Matrícula:");

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel23.setText("N° de Matrícula:");

        datamat.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        datamat.setText("Data da Matrícula:");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel25.setText("Status:");

        turma.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        turma.setText("Turma:");

        status2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        status2.setText("Turma:");

        status3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        status3.setText("Curso:");

        curso.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        curso.setText("Turma:");

        serie.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        serie.setText("Turma:");

        status4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        status4.setText("Série:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(39, 39, 39)
                        .addComponent(mat))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datamat)
                            .addComponent(status))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status2)
                    .addComponent(status3)
                    .addComponent(status4))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serie)
                    .addComponent(curso)
                    .addComponent(turma))
                .addGap(316, 316, 316))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mat)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(datamat))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(turma)
                            .addComponent(status2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(curso)
                            .addComponent(status3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(serie)
                            .addComponent(status4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setText("Detalhar Aluno");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DetalharAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalharAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalharAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalharAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalharAluno(cod).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cidade;
    private javax.swing.JLabel cpf;
    private javax.swing.JLabel curso;
    private javax.swing.JLabel datamat;
    private javax.swing.JLabel datanasc;
    private javax.swing.JLabel email;
    private javax.swing.JLabel end;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel mae;
    private javax.swing.JLabel mat;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel pai;
    private javax.swing.JLabel rg;
    private javax.swing.JLabel serie;
    private javax.swing.JLabel sexo;
    private javax.swing.JLabel status;
    private javax.swing.JLabel status2;
    private javax.swing.JLabel status3;
    private javax.swing.JLabel status4;
    private javax.swing.JLabel tel;
    private javax.swing.JLabel turma;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables
}
