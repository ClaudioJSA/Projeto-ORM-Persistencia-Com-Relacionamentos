/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicinterface;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class CadastrarAtualizarUser extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarUsuario
     */
    MaskFormatter mfdata;
    MaskFormatter mftelefone;
    private static CadastrarAtualizarUser instancia;
    
    private CadastrarAtualizarUser() {
        try {
            mfdata = new MaskFormatter("##/##/####");
            mftelefone = new MaskFormatter("(##) #####-####"); 
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        initComponents();
    }
    
    
    
    private CadastrarAtualizarUser(int type) {
        try {
            mfdata = new MaskFormatter("##/##/####");
            mftelefone = new MaskFormatter("(##) #####-####");
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        initComponents();
        switch(type){
            case 0:
                lblCadastroTitulo.setText("CADASTRAR LEITOR");
                txtCadastrarMatricula.setEnabled(false);
                setTitle("Cadastrar Leitor");
                break;
            case 1:
                lblCadastroTitulo.setText("CADASTRAR BIBLIOTECARIO");
                txtCadastrarDocumento.setEnabled(false);
                setTitle("Cadastrar Bibliotecario");
                break;
        }
    }
    
    public static CadastrarAtualizarUser getInstance(int type) {
        if (instancia == null) {
            instancia = new CadastrarAtualizarUser(type);
        }
        return instancia;
    }
    
    public static CadastrarAtualizarUser getInstance() {
        if (instancia == null) {
            instancia = new CadastrarAtualizarUser();
        }
        return instancia;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCadastrarNome = new javax.swing.JTextField();
        lblCadastroNome = new javax.swing.JLabel();
        txtCadastrarEmail = new javax.swing.JTextField();
        txtCadastrarDocumento = new javax.swing.JTextField();
        txtCadastrarData = new javax.swing.JFormattedTextField(mfdata);
        lblCadastroEmail = new javax.swing.JLabel();
        lblCadastroDataDeNascimento = new javax.swing.JLabel();
        lblCadastroNomeDeUsuario = new javax.swing.JLabel();
        lblCadastroSenha = new javax.swing.JLabel();
        lblCadastroConfirmarSenha = new javax.swing.JLabel();
        btnCadastrarSalvar = new javax.swing.JButton();
        btnCadastrarCancelar = new javax.swing.JButton();
        lblCadastroTitulo = new javax.swing.JLabel();
        lblCadastroLogo = new javax.swing.JLabel();
        lblCadastroTelefone = new javax.swing.JLabel();
        txtCadastrarNomeDeUsuario = new javax.swing.JTextField();
        txtCadastrarTelefone = new javax.swing.JFormattedTextField(mftelefone);
        lblCadastroMatricula = new javax.swing.JLabel();
        lblCadastroDocumento = new javax.swing.JLabel();
        txtCadastrarMatricula = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pwdCadastrarSenha = new javax.swing.JPasswordField();
        pwdCadastrarConfSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar/Atualizar");
        setName("tlCadUpUser"); // NOI18N
        setResizable(false);

        txtCadastrarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadastrarNomeActionPerformed(evt);
            }
        });

        lblCadastroNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroNome.setText("Nome:");

        txtCadastrarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadastrarDocumentoActionPerformed(evt);
            }
        });

        txtCadastrarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadastrarDataActionPerformed(evt);
            }
        });

        lblCadastroEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroEmail.setText("E-mail:");

        lblCadastroDataDeNascimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroDataDeNascimento.setText("Data de nascimento:");

        lblCadastroNomeDeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroNomeDeUsuario.setText("Nome de Usuário:");

        lblCadastroSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroSenha.setText("Senha:");

        lblCadastroConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroConfirmarSenha.setText("Confirmação da senha:");

        btnCadastrarSalvar.setText("Salvar");
        btnCadastrarSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarSalvarActionPerformed(evt);
            }
        });
        btnCadastrarSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnCadastrarSalvarKeyReleased(evt);
            }
        });

        btnCadastrarCancelar.setText("Cancelar");
        btnCadastrarCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCancelarActionPerformed(evt);
            }
        });

        lblCadastroTitulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblCadastroTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCadastroTitulo.setText("CADASTRO/ATUALIZAR");

        lblCadastroLogo.setIcon(new javax.swing.ImageIcon("D:\\Programas\\Dev\\netbeans\\Projetos\\Projeto Trabalho Final\\Projeto-ORM-Persistencia-Com-Relacionamentos\\Projeto-ORM-Persistencia-Com-Relacionamentos\\src\\main\\resoursces\\cadastro.png")); // NOI18N

        lblCadastroTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroTelefone.setText("Telefone:");

        lblCadastroMatricula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroMatricula.setText("Matricula:");

        lblCadastroDocumento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroDocumento.setText("Documento:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Dados Pessoais");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Credencial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCadastroLogo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCadastroTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblCadastroConfirmarSenha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCadastrarNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCadastrarEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCadastroDataDeNascimento)
                                        .addComponent(txtCadastrarData, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCadastroDocumento))
                                    .addGap(44, 44, 44)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblCadastroTelefone)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(txtCadastrarTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)))
                                .addComponent(lblCadastroNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCadastroEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCadastroMatricula, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCadastrarDocumento, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCadastrarMatricula, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCadastroNomeDeUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCadastroSenha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCadastrarNomeDeUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pwdCadastrarSenha)
                                .addComponent(pwdCadastrarConfSenha))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrarCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrarSalvar)
                        .addGap(9, 9, 9)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblCadastroLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblCadastroTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCadastroNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadastrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCadastroEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadastrarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCadastroDataDeNascimento)
                    .addComponent(lblCadastroTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCadastrarData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCadastrarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCadastroDocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadastrarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCadastroMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadastrarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(5, 5, 5)
                .addComponent(lblCadastroNomeDeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadastrarNomeDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCadastroSenha)
                .addGap(5, 5, 5)
                .addComponent(pwdCadastrarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCadastroConfirmarSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdCadastrarConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarCancelar)
                    .addComponent(btnCadastrarSalvar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCadastrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadastrarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadastrarNomeActionPerformed

    private void txtCadastrarDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadastrarDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadastrarDataActionPerformed

    private void txtCadastrarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadastrarDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadastrarDocumentoActionPerformed

    private void btnCadastrarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCancelarActionPerformed
        dispose();
        instancia = null;
    }//GEN-LAST:event_btnCadastrarCancelarActionPerformed

    private void btnCadastrarSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarSalvarActionPerformed

    }//GEN-LAST:event_btnCadastrarSalvarActionPerformed

    private void btnCadastrarSalvarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCadastrarSalvarKeyReleased
        if(String.valueOf(pwdCadastrarSenha).equals(String.valueOf(pwdCadastrarConfSenha.getPassword()))
                && !txtCadastrarNomeDeUsuario.getText().trim().isEmpty()){
            btnCadastrarSalvar.setEnabled(true);
        }else
            btnCadastrarSalvar.setEnabled(false);
    }//GEN-LAST:event_btnCadastrarSalvarKeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CadastrarAtualizarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarAtualizarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarAtualizarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarAtualizarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarAtualizarUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCancelar;
    private javax.swing.JButton btnCadastrarSalvar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel lblCadastroConfirmarSenha;
    private javax.swing.JLabel lblCadastroDataDeNascimento;
    private javax.swing.JLabel lblCadastroDocumento;
    private javax.swing.JLabel lblCadastroEmail;
    private javax.swing.JLabel lblCadastroLogo;
    private javax.swing.JLabel lblCadastroMatricula;
    private javax.swing.JLabel lblCadastroNome;
    private javax.swing.JLabel lblCadastroNomeDeUsuario;
    private javax.swing.JLabel lblCadastroSenha;
    private javax.swing.JLabel lblCadastroTelefone;
    private javax.swing.JLabel lblCadastroTitulo;
    private javax.swing.JPasswordField pwdCadastrarConfSenha;
    private javax.swing.JPasswordField pwdCadastrarSenha;
    private javax.swing.JFormattedTextField txtCadastrarData;
    private javax.swing.JTextField txtCadastrarDocumento;
    private javax.swing.JTextField txtCadastrarEmail;
    private javax.swing.JTextField txtCadastrarMatricula;
    private javax.swing.JTextField txtCadastrarNome;
    private javax.swing.JTextField txtCadastrarNomeDeUsuario;
    private javax.swing.JFormattedTextField txtCadastrarTelefone;
    // End of variables declaration//GEN-END:variables
}
