
package GUI.Principal;
import GUI.Seguridad.*;
import GUI.Documentos.*;
import GUI.Reportes.*;
import GUI.Evaluacion.*;
import GUI.Auditoria.*;

public class frmVentanaPrincipal extends javax.swing.JFrame {
        public frmVentanaPrincipal(){
                this.setBounds(0, 0, 1203, 489);
                this.getContentPane().setVisible(true);
                initComponents();
            }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOperaciones = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuAntena = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sisteme BeOriginal");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Principal/levis.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 604));
        jLabel1.setName("jLabel1"); // NOI18N

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        menuOperaciones.setText("Documentos");
        menuOperaciones.setName("menuOperaciones"); // NOI18N
        menuOperaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuOperacionesMouseClicked(evt);
            }
        });

        jMenuItem3.setText("Administrar Documentos");
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuOperaciones.add(jMenuItem3);

        jMenuBar1.add(menuOperaciones);

        menuClientes.setText("Evaluación");
        menuClientes.setName("menuClientes"); // NOI18N

        jMenuItem2.setText("Análisis");
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuClientes.add(jMenuItem2);

        jMenuBar1.add(menuClientes);

        menuUsuario.setText("Seguridad");
        menuUsuario.setName("menuUsuario"); // NOI18N

        jMenuItem10.setText("Administrar Usuario");
        jMenuItem10.setName("jMenuItem10"); // NOI18N
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        menuUsuario.add(jMenuItem10);

        jMenuItem11.setText("Administrar Perfil");
        jMenuItem11.setName("jMenuItem11"); // NOI18N
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        menuUsuario.add(jMenuItem11);

        jMenuBar1.add(menuUsuario);

        jMenu1.setText("Auditoria");
        jMenu1.setName("jMenu1"); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        menuAntena.setText("Reportes");
        menuAntena.setName("menuAntena"); // NOI18N
        jMenuBar1.add(menuAntena);

        jMenu2.setText("Salir");
        jMenu2.setName("jMenu2"); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new frmVentanaEvaluacion().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       new frmVentanaDocumentos().setVisible(true);
}//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new frmVentanaMantenerPerfil().setVisible(true);
}//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new frmVentanaMantenerUsuario().setVisible(true);
}//GEN-LAST:event_jMenuItem10ActionPerformed

    private void menuOperacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuOperacionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuOperacionesMouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        new frmLogUsuario().setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu menuAntena;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables

}
