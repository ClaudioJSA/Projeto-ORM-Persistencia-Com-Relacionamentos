/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicinterface;

import admin.Admin;
import admin.AdminDao;
import credential.Credential;
import credential.CredentialDao;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.text.MaskFormatter;
import librarian.Librarian;
import librarian.LibrarianDao;
import reader.Reader;
import reader.ReaderDao;
import role.Role;
import role.RoleDao;
import user.UserDao;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class CadastrarAtualizarUser extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarUsuario
     */
    private MaskFormatter mfdata;
    private MaskFormatter mftelefone;
    private static CadastrarAtualizarUser instancia;
    int type;
    Reader reader;
    Librarian librarian;
    Admin admin;
    
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
                this.type = type;
                break;
            case 1:
                lblCadastroTitulo.setText("CADASTRAR BIBLIOTECARIO");
                txtCadastrarDocumento.setEnabled(false);
                setTitle("Cadastrar Bibliotecario");
                this.type = type;
                break;
            case 2:
                lblCadastroTitulo.setText("CADASTRAR ADMINISTRADOR");
                txtCadastrarDocumento.setEnabled(false);
                setTitle("Cadastrar Administrador");
                this.type = type;
                break;
        }
    }
    
    private CadastrarAtualizarUser(int type, Object user) {
        try {
            mfdata = new MaskFormatter("##/##/####");
            mftelefone = new MaskFormatter("(##) #####-####");
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        initComponents();
        switch(type){
            case 0:
                lblCadastroTitulo.setText("ATUALIZAR LEITOR");
                txtCadastrarMatricula.setEnabled(false);
                setTitle("Atualizar Leitor");
                this.type = type;
                reader = (Reader) user;
                txtCadastrarNome.setText(reader.getName());
                txtCadastrarEmail.setText(reader.getEmail());
                txtCadastrarData.setText(reader.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                txtCadastrarNomeDeUsuario.setText(reader.getCredentical().getUsername());
                break;
            case 1:
                lblCadastroTitulo.setText("ATUALIZAR BIBLIOTECARIO");
                txtCadastrarDocumento.setEnabled(false);
                setTitle("Atualizar Bibliotecario");
                this.type = type;
                librarian = (Librarian) user;
                txtCadastrarNome.setText(librarian.getName());
                txtCadastrarEmail.setText(librarian.getEmail());
                txtCadastrarData.setText(librarian.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                txtCadastrarNomeDeUsuario.setText(librarian.getCredentical().getUsername());
                break;
            case 2:
                lblCadastroTitulo.setText("ATUALIZAR ADMINISTRADOR");
                txtCadastrarDocumento.setEnabled(false);
                setTitle("Cadastrar Administador");
                this.type = type;
                admin = (Admin) user;
                txtCadastrarNome.setText(admin.getName());
                txtCadastrarEmail.setText(admin.getEmail());
                txtCadastrarData.setText(admin.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                txtCadastrarNomeDeUsuario.setText(admin.getCredentical().getUsername());
                break;
        }
    }
    
    public static CadastrarAtualizarUser getInstance(int type) {
        if (instancia == null) {
            instancia = new CadastrarAtualizarUser(type);
        }
        return instancia;
    }
    
    public static CadastrarAtualizarUser getInstance(int type, Object user) {
        if (instancia == null) {
            instancia = new CadastrarAtualizarUser(type, user);
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

        lblCadastroLogo.setIcon(new ImageIcon(getClass().getResource("/cadastro.png")));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(lblCadastroLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCadastroTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
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
                        .addGap(42, 42, 42)
                        .addComponent(lblCadastroTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblCadastroLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(29, Short.MAX_VALUE))
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
        Credential credential;
        if(reader == null)
            credential = new Credential();
        else if(type == 0)
            credential = reader.getCredentical();
        else if(type == 1)
            credential = librarian.getCredentical();
        else
            credential = admin.getCredentical();
            
        try {
            credential.setUsername(txtCadastrarNomeDeUsuario.getText());
            credential.setPassword(String.valueOf(pwdCadastrarSenha.getPassword()));
            credential.setLastAccess(LocalDate.of(0000, 1, 1));
            credential.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarAtualizarUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(type){
            case 0:
                if(reader == null)
                    reader = new Reader();
                try {
                    reader.setCredential(credential);
                    reader.setName(txtCadastrarNome.getText());
                    reader.setEmail(txtCadastrarEmail.getText());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    reader.setBirthDate(LocalDate.parse(txtCadastrarData.getText(), formatter));
                    reader.setRole(new Role("Leitor"));
                    reader.getRole().setId(new RoleDao().saveOrUpdate(reader.getRole()));
                } catch (Exception ex) {
                    Logger.getLogger(CadastrarAtualizarUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                credential.setUser(reader);
                reader.setCredential(credential);
                credential.setId(new CredentialDao().saveOrUpdate(credential));
                if(credential.getId() != 0){
                    reader.setId(new UserDao().saveOrUpdate(reader));
                    ///Atualizando a referencia de librarian em credencial no banco
                    new CredentialDao().saveOrUpdate(credential);
                    ///Adicionando User na tabela reader
                    new ReaderDao().saveOrUpdate(reader);
                }
                if(credential.getId() != null && credential.getId() != 0 
                        && reader.getId() != null && reader.getId() != 0){
                    btnCadastrarSalvar.setEnabled(false);
                    btnCadastrarCancelar.setText("Sair");
                }
                break;
            case 1:
                if(librarian == null)
                    librarian = new Librarian();
                try {
                    librarian.setCredential(credential);
                    librarian.setName(txtCadastrarNome.getText());
                    librarian.setEmail(txtCadastrarEmail.getText());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    librarian.setBirthDate(LocalDate.parse(txtCadastrarData.getText(), formatter));
                    librarian.setRole(new Role("Leitor"));
                    librarian.getRole().setId(new RoleDao().saveOrUpdate(librarian.getRole()));
                } catch (Exception ex) {
                    Logger.getLogger(CadastrarAtualizarUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                credential.setUser(librarian);
                librarian.setCredential(credential);
                credential.setId(new CredentialDao().saveOrUpdate(credential));
                if(credential.getId() != 0){
                    librarian.setId(new UserDao().saveOrUpdate(librarian));
                    ///Atualizando a referencia de librarian em credencial no banco
                    new CredentialDao().saveOrUpdate(credential);
                    ///Adicionando User na tabela reader
                    new LibrarianDao().saveOrUpdate(librarian);
                }
                if(credential.getId() != null && credential.getId() != 0 
                        && librarian.getId() != null && librarian.getId() != 0){
                    btnCadastrarSalvar.setEnabled(false);
                    btnCadastrarCancelar.setText("Sair");
                }
                break;
            case 2:
                if(admin == null)
                    admin = new Admin();
                try {
                    admin.setCredential(credential);
                    admin.setName(txtCadastrarNome.getText());
                    admin.setEmail(txtCadastrarEmail.getText());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    admin.setBirthDate(LocalDate.parse(txtCadastrarData.getText(), formatter));
                    admin.setRole(new Role("Admin"));
                    admin.getRole().setId(new RoleDao().saveOrUpdate(admin.getRole()));
                } catch (Exception ex) {
                    Logger.getLogger(CadastrarAtualizarUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                credential.setUser(admin);
                admin.setCredential(credential);
                credential.setId(new CredentialDao().saveOrUpdate(credential));
                if(credential.getId() != 0){
                    admin.setId(new UserDao().saveOrUpdate(admin));
                    ///Atualizando a referencia de librarian em credencial no banco
                    new CredentialDao().saveOrUpdate(credential);
                    ///Adicionando User na tabela reader
                    new AdminDao().saveOrUpdate(admin);
                }
                if(credential.getId() != null && credential.getId() != 0 
                        && admin.getId() != null && admin.getId() != 0){
                    btnCadastrarSalvar.setEnabled(false);
                    btnCadastrarCancelar.setText("Sair");
                }
                break;

        }
    }//GEN-LAST:event_btnCadastrarSalvarActionPerformed

    private void btnCadastrarSalvarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCadastrarSalvarKeyReleased
        if(String.valueOf(pwdCadastrarSenha).equals(String.valueOf(pwdCadastrarConfSenha.getPassword()))
                && !txtCadastrarNomeDeUsuario.getText().trim().isEmpty()){
            btnCadastrarSalvar.setEnabled(true);
        }else
            btnCadastrarSalvar.setEnabled(false);
    }//GEN-LAST:event_btnCadastrarSalvarKeyReleased

    

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
