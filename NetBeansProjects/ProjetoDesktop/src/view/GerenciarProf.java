package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import model.LogUsr;
import model.ProfessorDAO;
import utils.FuctionsUtils;

public class GerenciarProf extends javax.swing.JFrame {

    private DefaultTableModel modelo = null;

    public GerenciarProf() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int answer = JOptionPane.showConfirmDialog(null, "Deseja Fechar a Janela Atual?", null, JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    dispose();
                    MenuPrincipal m = new MenuPrincipal();
                    m.setVisible(true);
                    m.setLocationRelativeTo(null);
                }
            }
        });
        try {
            LogUsr log = new LogUsr();
            usu.setText(log.getLogUser());
            
            if(log.getTipoTmp().equalsIgnoreCase("usuario")){
                excluir.setVisible(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        refreshTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        detalhar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usu = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gerenciar Professor");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(297, 843));

        btnNovo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(204, 204, 204));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(204, 204, 204));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Modify.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        detalhar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        detalhar.setForeground(new java.awt.Color(204, 204, 204));
        detalhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/List.png"))); // NOI18N
        detalhar.setText("Detalhar");
        detalhar.setEnabled(false);
        detalhar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        detalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalharActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        excluir.setForeground(new java.awt.Color(204, 204, 204));
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Forbidden_132577.png"))); // NOI18N
        excluir.setText("Excluir");
        excluir.setEnabled(false);
        excluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(detalhar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detalhar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
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
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/design (3).png"))); // NOI18N
        jLabel1.setText("Gerenciar Professor");

        usu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        usu.setForeground(new java.awt.Color(51, 51, 255));
        usu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Person.png"))); // NOI18N
        usu.setText("jLabel2");

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Home.png"))); // NOI18N
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usu)
                .addGap(46, 46, 46)
                .addComponent(home)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(home))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(usu))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Nome do Professor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1386, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        FormProf fp = new FormProf();
        fp.setVisible(true);
        refreshTable();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            AlterarProf ap = new AlterarProf((int) modelo.getValueAt(tabela.getSelectedRow(), 0));
            ap.setVisible(true);
            refreshTable();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um professor!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        try {
            FuctionsUtils fu = new FuctionsUtils();
            int cod = (int) modelo.getValueAt(tabela.getSelectedRow(), 0);

            if (!fu.isExistProfInTurma(cod)) {
                int answer = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Professor?", null, JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    ProfessorDAO dao = new ProfessorDAO();
                    dao.delete(cod);
                    refreshTable();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não e possivel excluir o Professor, pois o mesmo está veinculado a uma turma!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

            if (modelo.getRowCount() == 0) {
                btnAlterar.setEnabled(false);
                detalhar.setEnabled(false);
                excluir.setEnabled(false);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um professor!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void detalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalharActionPerformed
        try {
            DetalharProf ap = new DetalharProf((int) modelo.getValueAt(tabela.getSelectedRow(), 0));
            ap.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um professor!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_detalharActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        dispose();
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
    }//GEN-LAST:event_homeMouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        btnAlterar.setEnabled(true);
        detalhar.setEnabled(true);
        excluir.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refreshTableToSearch();
        nome.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    public void refreshTable() {
        try {
            Connection con = new ConnectionFactory().getConnection();
            String query = "SELECT * FROM pessoa AS p INNER JOIN professor as pf ON pf.intPessoaId = p.intPessoaId ";
            
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            modelo = (DefaultTableModel) tabela.getModel();
            modelo.setNumRows(0);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("intPessoaId"), rs.getString("strNomePessoa"), rs.getString("strFormacaoProf")});
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void refreshTableToSearch() {
        try {
            Connection con = new ConnectionFactory().getConnection();
            String query = "SELECT * FROM pessoa AS p INNER JOIN professor as pf ON pf.intPessoaId = p.intPessoaId "
                    + " WHERE p.strNomePessoa LIKE ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, "%"+nome.getText()+"%");
            ResultSet rs = pst.executeQuery();

            modelo = (DefaultTableModel) tabela.getModel();
            modelo.setNumRows(0);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("intPessoaId"), rs.getString("strNomePessoa"), rs.getString("strFormacaoProf")});
            }
            
            if(modelo.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Nenhum Professor foi encontrado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            rs.close();
            pst.close();
            con.close();
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
            java.util.logging.Logger.getLogger(GerenciarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton detalhar;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel usu;
    // End of variables declaration//GEN-END:variables
}
