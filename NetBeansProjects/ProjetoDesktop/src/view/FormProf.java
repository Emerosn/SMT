package view;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import model.Professor;
import model.ProfessorDAO;
import utils.validar;

public class FormProf extends javax.swing.JDialog {

    private DefaultTableModel modelo = null, modelo1 = null;

    public FormProf() {
        this.setModal(true);
        initComponents();
        modelo1 = (DefaultTableModel) tableSele.getModel();
        modelo1.setNumRows(0);

        try {
            SimpleDateFormat df = new SimpleDateFormat("YYYY");
            Connection con = new ConnectionFactory().getConnection();
            String query = "SELECT * FROM turma AS t INNER JOIN curso AS c ON c.intCursoId = t.intCursoId"
                    + " WHERE c.strAnoLetivo = YEAR(CURDATE())";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            modelo = (DefaultTableModel) tabletodos.getModel();
            modelo.setNumRows(0);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("intTurmaId"),
                    rs.getString("strDscTurma"),
                    rs.getString("strNomeCurso"),
                    df.format(rs.getDate("strAnoLetivo"))});
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        end = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        formacao = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        uf = new javax.swing.JComboBox<String>();
        rg = new javax.swing.JFormattedTextField();
        cpf = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        tel = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabletodos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSele = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        excluir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Professor");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Professor"));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Sexo:");

        sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Endereço:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Cidade:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Cpf:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("Formação:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setText("Uf:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Rg:");

        uf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        try {
            rg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Telefone:");

        try {
            tel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Email:");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14)
                        .addComponent(jLabel8)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel15))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(176, 176, 176)
                                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(end, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                    .addComponent(formacao, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(115, 115, 115)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel15)
                        .addGap(214, 214, 214))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(formacao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        cadastrar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Apply.png"))); // NOI18N
        cadastrar.setText("Cadastrar");
        cadastrar.setEnabled(false);
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(482, 482, 482))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Turma"));

        tabletodos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabletodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabletodosMouseClicked(evt);
            }
        });
        tabletodos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabletodosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabletodos);

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        tableSele.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSeleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableSele);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Selecione as Turmas Desejadas");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Turmas Selecionadas");

        excluir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        excluir.setText("Excluir");
        excluir.setEnabled(false);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)))
                .addGap(0, 180, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(247, 247, 247))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel9.setText("Novo Professor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(536, 536, 536)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        if (nome.getText().trim().equals("") || rg.getText().trim().equals("") || cpf.getText().trim().equals("") || tel.getText().trim().equals("") || email.getText().equals("") || cidade.getText().trim().equals("") || end.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Existe campos vazios", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                List<Integer> lista = new ArrayList<>();

                Connection con = new ConnectionFactory().getConnection();
                Professor pf = new Professor();
                ProfessorDAO pfDAO = new ProfessorDAO();
                validar v = new validar();
                int choques = -1;
                boolean isValidCpf = v.validarCPF(cpf.getText());
                boolean isValidEmail = v.validarEMAIL(email.getText());
                choques = v.verficarCHOQUE(cpf.getText());
                boolean isValidNome = v.pregMathString(nome.getText());

                if (isValidEmail && choques == 0 && isValidCpf && isValidNome) {
                    pf.setStrNomePessoa(nome.getText());
                    pf.setStrRgPessoa(rg.getText());
                    pf.setStrCpfPessoa(cpf.getText());
                    pf.setStrTelPessoa(tel.getText());
                    pf.setStrEmailPessoa(email.getText());
                    pf.setStrSexoPessoa((String) sexo.getSelectedItem());
                    pf.setStrCidadePessoa(cidade.getText());
                    pf.setStrEnderecoPessoa(end.getText());
                    pf.setStrUfPessoa((String) uf.getSelectedItem());
                    pf.setFormacao(formacao.getText());

                    for (int i = 0; i < tableSele.getRowCount(); i++) {
                        lista.add(Integer.parseInt(tableSele.getValueAt(i, 0).toString()));
                    }

                    pfDAO.insertProf(pf, lista);
                    con.close();
                    JOptionPane.showMessageDialog(null, "Professor Cadastrado com Sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Data com formato inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_cadastrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tabletodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletodosMouseClicked
        Object[] obj = {tabletodos.getValueAt(tabletodos.getSelectedRow(), 0),
            tabletodos.getValueAt(tabletodos.getSelectedRow(), 1),
            tabletodos.getValueAt(tabletodos.getSelectedRow(), 2),
            tabletodos.getValueAt(tabletodos.getSelectedRow(), 3)};

        modelo.removeRow(tabletodos.getSelectedRow());
        modelo1.addRow(obj);
        cadastrar.setEnabled(true);
    }//GEN-LAST:event_tabletodosMouseClicked

    private void tabletodosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabletodosKeyPressed

    }//GEN-LAST:event_tabletodosKeyPressed

    private void tableSeleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSeleMouseClicked
        excluir.setEnabled(true);
    }//GEN-LAST:event_tableSeleMouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        try {
            Object[] res = {tableSele.getValueAt(tableSele.getSelectedRow(), 0),
                tableSele.getValueAt(tableSele.getSelectedRow(), 1),
                tableSele.getValueAt(tableSele.getSelectedRow(), 2),
                tableSele.getValueAt(tableSele.getSelectedRow(), 3)};
            modelo1.removeRow(tableSele.getSelectedRow());
            modelo.addRow(res);

            if (modelo1.getRowCount() == 0) {
                excluir.setEnabled(false);
                cadastrar.setEnabled(false);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione a turma para excluir!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_excluirActionPerformed

    public boolean isEmptyCampos() {
        if (cidade.getText().trim().equals("") || nome.getText().trim().equals("") || cpf.getText().trim().equals("")
                || rg.getText().trim().equals("") || tel.getText().trim().equals("") || end.getText().trim().equals("")
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
            java.util.logging.Logger.getLogger(FormProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField cidade;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JTextField email;
    private javax.swing.JTextField end;
    private javax.swing.JButton excluir;
    private javax.swing.JTextField formacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField rg;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JTable tableSele;
    private javax.swing.JTable tabletodos;
    private javax.swing.JFormattedTextField tel;
    private javax.swing.JComboBox<String> uf;
    // End of variables declaration//GEN-END:variables
}
