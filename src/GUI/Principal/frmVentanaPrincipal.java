
package GUI.Principal;
import GUI.Seguridad.*;
import GUI.Documentos.*;
import BusinessEntity.*;
import GUI.Evaluacion.*;
import java.sql.Date;
import GUI.Auditoria.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmVentanaPrincipal extends javax.swing.JFrame {
   // private Date fechaActual= new Date();  //para buscar mas adelante
    private UsuarioBE objUsuario;
    public static UsuarioBE usuarioActual = new UsuarioBE();
    public static int logActual;
    public UsuarioBE getObjUsuario() { return objUsuario;    }
    public void setObjUsuario(UsuarioBE objUsuario) { this.objUsuario = objUsuario;    }

       public frmVentanaPrincipal(UsuarioBE objUsuario,int codlogactual){
        super();
        initComponents();
        this.setResizable(false);
        this.setSize(this.getToolkit().getScreenSize());
        this.setDefaultCloseOperation( frmVentanaPrincipal.EXIT_ON_CLOSE );
        this.getContentPane().setVisible(true);

        frmVentanaPrincipal.usuarioActual=objUsuario;
        frmVentanaPrincipal.logActual=codlogactual;
        setObjUsuario(objUsuario);
       
    }

    public frmVentanaPrincipal(){
        super();
        initComponents();
        this.setResizable(false);
        this.setMaximumSize(this.getToolkit().getScreenSize());
        this.setDefaultCloseOperation( frmVentanaPrincipal.EXIT_ON_CLOSE );
        this.getContentPane().setVisible(true);
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mnuBarMenu = new javax.swing.JMenuBar();
        mnuDocumentos = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        mnuEvaluacion = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuSeguridad = new javax.swing.JMenu();
        mnuUsuario = new javax.swing.JMenuItem();
        mnuPerfil = new javax.swing.JMenuItem();
        mnuAuditoria = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuAntena = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema BeOriginal");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/levis.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 604));
        jLabel1.setName("jLabel1"); // NOI18N

        mnuBarMenu.setName("mnuBarMenu"); // NOI18N

        mnuDocumentos.setText("Documentos");
        mnuDocumentos.setName("mnuDocumentos"); // NOI18N

        jMenuItem3.setText("Administrar Documentos");
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuDocumentos.add(jMenuItem3);

        jMenuItem5.setText("Cargar Documento Local");
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuDocumentos.add(jMenuItem5);

        jMenuItem6.setText("Cargar Documento URL");
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuDocumentos.add(jMenuItem6);

        mnuBarMenu.add(mnuDocumentos);

        mnuEvaluacion.setText("Evaluación");
        mnuEvaluacion.setName("mnuEvaluacion"); // NOI18N

        jMenuItem2.setText("Análisis");
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuEvaluacion.add(jMenuItem2);

        mnuBarMenu.add(mnuEvaluacion);

        mnuSeguridad.setText("Seguridad");
        mnuSeguridad.setName("mnuSeguridad"); // NOI18N

        mnuUsuario.setText("Administrar Usuario");
        mnuUsuario.setName("mnuUsuario"); // NOI18N
        mnuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuarioActionPerformed(evt);
            }
        });
        mnuSeguridad.add(mnuUsuario);

        mnuPerfil.setText("Administrar Perfil");
        mnuPerfil.setName("mnuPerfil"); // NOI18N
        mnuPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPerfilActionPerformed(evt);
            }
        });
        mnuSeguridad.add(mnuPerfil);

        mnuBarMenu.add(mnuSeguridad);

        mnuAuditoria.setText("Auditoria");
        mnuAuditoria.setName("mnuAuditoria"); // NOI18N

        jMenuItem1.setText("Log Usuario");
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuAuditoria.add(jMenuItem1);

        jMenuItem4.setText("Transaccion");
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuAuditoria.add(jMenuItem4);

        mnuBarMenu.add(mnuAuditoria);

        menuAntena.setText("Reportes");
        menuAntena.setName("menuAntena"); // NOI18N
        mnuBarMenu.add(menuAntena);

        mnuSalir.setText("Salir");
        mnuSalir.setName("mnuSalir"); // NOI18N
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuSalirMousePressed(evt);
            }
        });
        mnuBarMenu.add(mnuSalir);

        setJMenuBar(mnuBarMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuarioActionPerformed
        // TODO add your handling code here:
        frmVentanaMantenerUsuario ventanausuario=new frmVentanaMantenerUsuario();
         ventanausuario.setVisible(true);

    }//GEN-LAST:event_mnuUsuarioActionPerformed

    private void mnuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPerfilActionPerformed
            // TODO add your handling code here:
        frmVentanaMantenerPerfil ventanaperfil=new frmVentanaMantenerPerfil();
         ventanaperfil.setVisible(true);

    }//GEN-LAST:event_mnuPerfilActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        frmCargaDocumento documento=new frmCargaDocumento();
        documento.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        frmVentanaEvaluacion evaluacion=new frmVentanaEvaluacion();
        evaluacion.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        frmLogUsuario logusuario=new frmLogUsuario();
        logusuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        frmTransaccion transaccion=new frmTransaccion();
        transaccion.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        frmCargarDocumentoFileSystem documento=new frmCargarDocumentoFileSystem();
        documento.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        frmCargarDocumentoURL documento=new frmCargarDocumentoURL();
        documento.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mnuSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnuSalirMousePressed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu menuAntena;
    public javax.swing.JMenu mnuAuditoria;
    private javax.swing.JMenuBar mnuBarMenu;
    public javax.swing.JMenu mnuDocumentos;
    public javax.swing.JMenu mnuEvaluacion;
    private javax.swing.JMenuItem mnuPerfil;
    private javax.swing.JMenu mnuSalir;
    public javax.swing.JMenu mnuSeguridad;
    private javax.swing.JMenuItem mnuUsuario;
    // End of variables declaration//GEN-END:variables

}
