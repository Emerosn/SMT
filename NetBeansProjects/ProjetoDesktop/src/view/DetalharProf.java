package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import utils.FuctionsUtils;

public class DetalharProf extends javax.swing.JDialog {

    private static int cod = 0;

    public DetalharProf(int cod) {
        this.cod = cod;
        initComponents();

        this.setModal(true);
        FuctionsUtils fu = new FuctionsUtils();

        try {
            if (fu.isExistProfInTurma(cod)) {
                Connection con = new ConnectionFactory().getConnection();
                String queryPesquisar = "SELECT * FROM pessoa AS p INNER JOIN professor AS pf ON pf.intPessoaId = p.intPessoaId"
                        + " INNER JOIN turma_professor AS tp ON tp.intProfId = pf.intProfId "
                        + " INNER JOIN turma AS t ON t.intTurmaId = tp.intTurmaId"
                        + " INNER JOIN curso AS c ON c.intCursoId = t.intCursoId"
                        + " WHERE p.intPessoaId = ?";
                PreparedStatement stmt = con.prepareStatement(queryPesquisar);
                stmt.setInt(1, cod);
                ResultSet rs = stmt.executeQuery();

                SimpleDateFormat df = new SimpleDateFormat("YYYY");
                DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                modelo.setNumRows(0);

                while (rs.next()) {
                    modelo.addRow(new Object[]{
                        rs.getInt("intTurmaId"),
                        rs.getString("strDscTurma"),
                        rs.getString("strNomeCurso"),
                        df.format(rs.getDate("strAnoLetivo"))
                    });
                    nome.setText(rs.getString("strNomePessoa"));
                    rg.setText(rs.getString("strRgPessoa"));
                    cpf.setText(rs.getString("strCpfPessoa"));
                    formacao.setText(rs.getString("strFormacaoProf"));
                    end.setText(rs.getString("strEnderecoPessoa"));
                    cidade.setText(rs.getString("strCidadePessoa"));
                    uf.setText(rs.getString("strUfPessoa"));
                    tel.setText(rs.getString("strTelPessoa"));
                    sexo.setText(rs.getString("strSexoPessoa"));
                    email.setText(rs.getString("strEmailPessoa"));
                    status.setText(rs.getString("strStatusProf"));
                    if (rs.getString("strStatusProf").equalsIgnoreCase("off")) {
                        status.setForeground(Color.red);
                    } else {
                        status.setForeground(Color.BLUE);
                    }
                }
                stmt.close();
                rs.close();
                con.close();
            } else {
                try {
                    Connection con = new ConnectionFactory().getConnection();
                    String queryPesquisar = "SELECT * FROM pessoa AS p INNER JOIN professor AS pf ON pf.intPessoaId = p.intPessoaId"
                            + " WHERE p.intPessoaId = ?";
                    PreparedStatement stmt = con.prepareStatement(queryPesquisar);
                    stmt.setInt(1, cod);
                    ResultSet rs = stmt.executeQuery();

                    
                    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                    modelo.setNumRows(0);

                    while (rs.next()) {
                   
                        nome.setText(rs.getString("strNomePessoa"));
                        rg.setText(rs.getString("strRgPessoa"));
                        cpf.setText(rs.getString("strCpfPessoa"));
                        formacao.setText(rs.getString("strFormacaoProf"));
                        end.setText(rs.getString("strEnderecoPessoa"));
                        cidade.setText(rs.getString("strCidadePessoa"));
                        uf.setText(rs.getString("strUfPessoa"));
                        tel.setText(rs.getString("strTelPessoa"));
                        sexo.setText(rs.getString("strSexoPessoa"));
                        email.setText(rs.getString("strEmailPessoa"));
                        status.setText(rs.getString("strStatusProf"));
                        if (rs.getString("strStatusProf").equalsIgnoreCase("off")) {
                            status.setForeground(Color.red);
                        } else {
                            status.setForeground(Color.BLUE);
                        }
                    }
                    stmt.close();
                    rs.close();
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        formacao = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sexo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        end = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cidade = new javax.swing.JLabel();
        uf = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Detalhar Professor");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Professor"));

        rg.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        rg.setText("Rg:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Cpf:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Formação:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Nome:");

        status.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        status.setText("status");

        nome.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nome.setText("Nome:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setText("Rg:");

        cpf.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cpf.setText("Cpf:");

        formacao.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        formacao.setText("for");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel18.setText("Status:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("Telefone:");

        tel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tel.setText("tel");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("Sexo:");

        sexo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        sexo.setText("sexo");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setText("Email:");

        email.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        email.setText("email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nome)
                    .addComponent(formacao)
                    .addComponent(cpf)
                    .addComponent(rg)
                    .addComponent(status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(tel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(60, 60, 60)
                        .addComponent(sexo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(53, 53, 53)
                        .addComponent(email)))
                .addGap(201, 201, 201))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nome)
                    .addComponent(jLabel7)
                    .addComponent(tel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rg)
                    .addComponent(jLabel15)
                    .addComponent(jLabel9)
                    .addComponent(sexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cpf))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(email)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(formacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status)
                    .addComponent(jLabel18)))
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Turmas"));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "COD", "Turma", "Curso", "Ano Letivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
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
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(DetalharProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalharProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalharProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalharProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalharProf(cod).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cidade;
    private javax.swing.JLabel cpf;
    private javax.swing.JLabel email;
    private javax.swing.JLabel end;
    private javax.swing.JLabel formacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel rg;
    private javax.swing.JLabel sexo;
    private javax.swing.JLabel status;
    private javax.swing.JTable table;
    private javax.swing.JLabel tel;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables
}
