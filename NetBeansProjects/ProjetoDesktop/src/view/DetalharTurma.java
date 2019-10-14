package view;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import model.Turma;
import model.TurmaDAO;

public class DetalharTurma extends javax.swing.JDialog {

    private Connection con = null;
    private static int cod = 0;
    private DefaultTableModel modelaluno, modelprof;

    public DetalharTurma(int cod) {
        initComponents();
        modelaluno = (DefaultTableModel) tabelaaluno.getModel();
        modelprof = (DefaultTableModel) tabelaprof.getModel();
        this.cod = cod;
        this.setModal(true);
        this.con = new ConnectionFactory().getConnection();

        TurmaDAO dao = new TurmaDAO();

        for (Turma lista : dao.listaToSearch(cod)) {
            nome.setText(lista.getStrDscTurma());
            capa.setText(Integer.toString(lista.getIntCapacidade()));
            hinicio.setText(lista.getStrHorarioInicio());
            hfinal.setText(lista.getStrHorarioFinal());
            vagas.setText(Integer.toString(lista.getIntVagasOcupadas()));
            Integer livres = (lista.getIntVagasOcupadas() - lista.getIntCapacidade());
            livre.setText(livres.toString().replace("-", ""));
        }

        try {
            String query = "SELECT *"
                    + " FROM turma INNER JOIN curso ON curso.intCursoId = turma.intCursoId"
                    + " WHERE turma.intTurmaId = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                curso.setText(rs.getString("strNomeCurso"));
                serie.setText(Integer.toString(rs.getInt("intSerie"))+" °");
                turno.setText(rs.getString("strTurno"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        tableToAluno();
        tableToProf();
    }

    public void tableToAluno() {
        try {
            String query = "SELECT *"
                    + " FROM pessoa INNER JOIN aluno ON aluno.intPessoaId = pessoa.intPessoaId"
                    + " INNER JOIN matricula ON matricula.intAlunoId = aluno.intAlunoId"
                    + " INNER JOIN turma ON turma.intTurmaId = matricula.intTurmaId"
                    + " WHERE turma.intTurmaId = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();

            modelaluno.setNumRows(0);
            while (rs.next()) {
                modelaluno.addRow(new Object[]{
                    rs.getInt("intPessoaId"),
                    rs.getString("strNomePessoa"),
                    rs.getString("strMatricula")
                });
            }
            rs.close();
            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void tableToProf() {
        try {
            String query = "SELECT *"
                    + " FROM pessoa INNER JOIN professor ON professor.intPessoaId = pessoa.intPessoaId"
                    + " INNER JOIN turma_professor ON turma_professor.intProfId = professor.intProfId"
                    + " INNER JOIN turma ON turma.intTurmaId = turma_professor.intTurmaId"
                    + " WHERE turma.intTurmaId = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();

            modelprof.setNumRows(0);
            while (rs.next()) {
                modelprof.addRow(new Object[]{
                    rs.getInt("intPessoaId"),
                    rs.getString("strNomePessoa"),
                    rs.getString("strFormacaoProf")
                });
            }
            rs.close();
            pst.close();
            this.con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        capa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vagas = new javax.swing.JLabel();
        livre = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        hinicio = new javax.swing.JLabel();
        hfinal = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        curso = new javax.swing.JLabel();
        serie = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        turno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaaluno = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaprof = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setText("Detalhar Turma");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(457, 457, 457)
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Turma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N

        capa.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        capa.setText(".");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Horário de Inicio:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Horário Final:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Nome:");

        vagas.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        vagas.setText(".");

        livre.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        livre.setText(".");

        nome.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nome.setText(".");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setText("Capacidade:");

        hinicio.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        hinicio.setText(".");

        hfinal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        hfinal.setText(".");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel18.setText("Vagas Ocupadas:");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel19.setText("Livre:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("Curso:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("Série:");

        curso.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        curso.setText(".");

        serie.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        serie.setText(".");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("Turno:");

        turno.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        turno.setText(".");

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
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(livre)
                    .addComponent(hfinal)
                    .addComponent(vagas)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome)
                            .addComponent(capa)
                            .addComponent(hinicio))
                        .addGap(404, 404, 404)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(turno))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(serie)
                                    .addComponent(curso))))))
                .addContainerGap(429, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nome)
                    .addComponent(jLabel7)
                    .addComponent(curso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capa)
                    .addComponent(jLabel15)
                    .addComponent(jLabel8)
                    .addComponent(serie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hinicio)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(turno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hfinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vagas)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(livre))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tabelaaluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tabelaaluno.getTableHeader().setResizingAllowed(false);
        tabelaaluno.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaaluno);

        tabelaprof.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Formação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaprof.getTableHeader().setResizingAllowed(false);
        tabelaprof.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaprof);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("Alunos Veinculados");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("Professores Veinculados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
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
            java.util.logging.Logger.getLogger(DetalharTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalharTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalharTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalharTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalharTurma(cod).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel capa;
    private javax.swing.JLabel curso;
    private javax.swing.JLabel hfinal;
    private javax.swing.JLabel hinicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel livre;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel serie;
    private javax.swing.JTable tabelaaluno;
    private javax.swing.JTable tabelaprof;
    private javax.swing.JLabel turno;
    private javax.swing.JLabel vagas;
    // End of variables declaration//GEN-END:variables
}
