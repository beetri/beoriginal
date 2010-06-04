/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmVentanaDocumento.java
 *
 * Created on 19/05/2010, 07:50:48 PM
 */

package GUI.Documentos;

/**
 *primera vez SVN
 * @author pedro
 */

import BusinessEntity.Documentos.DocumentoBE;
import BusinessEntity.Documentos.TextoBE;
import BusinessLogic.Documentos.DocumentoBL;
import BusinessLogic.Documentos.TextoBL;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import GUI.Evaluacion.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frmVentanaDocumento extends javax.swing.JFrame {

    /** Creates new form frmVentanaDocumento */

    private  File fichero;
    private frmVentanaEvaluacion ventanaEvaluacion;
    private String ruta, titulo;
    // HR ini
    private JTextField enterField;
    private DocumentoBL objDocumentoBL = new DocumentoBL();
    private TextoBL objTextoBL = new TextoBL();
    private DocumentoBE objDocumentoBE;
    private TextoBE objTextoBE;
    private Object outputArea;
    // HR fin

    //Este constructor será llamado desde el frmEVALUACION. NO USAR DESDE DOCUMENTOS
    public frmVentanaDocumento(frmVentanaEvaluacion evaluacion, String tituloVentana) {
        initComponents();
        ventanaEvaluacion = evaluacion;
        this.btnAgregar.setVisible(true);
        this.btnGuardar.setEnabled(false);
        //this.btnCargar.setVisible(false);
        //this.txtRuta.setVisible(false);
        //this.jPanel1.setVisible(false);
        //Redefinimos el tamaño de la ventana
        //this.setSize(this.getWidth(), this.getHeight()-this.jPanel1.getHeight());
       
        this.setTitle(tituloVentana);
    }

    public frmVentanaDocumento(){
        
    }

    public frmVentanaDocumento(String txtRuta, String txttitulo) {
        ventanaEvaluacion = null;
        ruta = txtRuta;
        titulo  = txttitulo;
        initComponents();
        //this.btnAgregar.setVisible(false);
        this.btnAgregar.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        btnMostrarRuta1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnConfigurarCategorias = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Documentos");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Documentos"));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Categorías");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Autor");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Manuel Tupia");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Ciro Alegría");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Mario Vargas Llosa");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Temas");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Ciencias de la Computación");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Poemas");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Realidad Peruana");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Historia");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Biología");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Matemáticas");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Otros");
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setName("treeArbolCategorías"); // NOI18N
        jScrollPane1.setViewportView(jTree1);

        btnMostrarRuta1.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        btnMostrarRuta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/find.png"))); // NOI18N
        btnMostrarRuta1.setText("Buscar");
        btnMostrarRuta1.setMaximumSize(new java.awt.Dimension(120, 27));
        btnMostrarRuta1.setMinimumSize(new java.awt.Dimension(80, 27));
        btnMostrarRuta1.setPreferredSize(new java.awt.Dimension(110, 30));
        btnMostrarRuta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarRuta1ActionPerformed(evt);
            }
        });

        jTextField2.setText("Aqui se muestran los documentos que hay dentro de cada categoría");

        btnGuardar.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(80, 30));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(80, 30));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregar.setText("Añadir");
        btnAgregar.setPreferredSize(new java.awt.Dimension(80, 30));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnConfigurarCategorias.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        btnConfigurarCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/settings.png"))); // NOI18N
        btnConfigurarCategorias.setText("Configurar");
        btnConfigurarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarCategoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnMostrarRuta1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfigurarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMostrarRuta1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConfigurarCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarRuta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarRuta1ActionPerformed
        // TODO add your handling code here:

        /*if (ventanaEvaluacion != null) {
            ventanaEvaluacion.setDocumento("", txtRuta.getText(), fichero);
            this.dispose();
        } else {
            this.dispose();
        }*/

}//GEN-LAST:event_btnMostrarRuta1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//     File name = new File( actionEvent.getActionCommand() );
//     File name = fichero;
     File name = new File(ruta);
      objDocumentoBE = new DocumentoBE();
      objTextoBE = new TextoBE();
      // if name exists, output information about it
      if ( name.exists() ) {
//         objDocumentoBE.setvchTitulo(name.getName());
         objDocumentoBE.setvchTitulo(titulo);
         
         objDocumentoBL.insertarDocumento(objDocumentoBE);
         if ( name.isFile() ) {

            // append contents of file to outputArea
            try {
               BufferedReader input = new BufferedReader(
                  new FileReader( name ) );
               StringBuffer buffer = new StringBuffer();
               String text;
//               outputArea.append( "\n\n" );

               while ( ( text = input.readLine() ) != null )
                  buffer.append( text + "\n" );

//               outputArea.append( buffer.toString() );
               objTextoBE.setvchTexto( buffer.toString());
               objTextoBL.insertarTexto(objTextoBE);
            }

            // process file processing problems
            catch( IOException ioException ) {
               JOptionPane.showMessageDialog( this, "ERROR DE ARCHIVO",
                  "FILE ERROR", JOptionPane.ERROR_MESSAGE );
            }

         } // end if
}//GEN-LAST:event_btnGuardarActionPerformed
}
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnConfigurarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarCategoriasActionPerformed
        new frmNuevaCategoria().setVisible(true);
    }//GEN-LAST:event_btnConfigurarCategoriasActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVentanaDocumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfigurarCategorias;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMostrarRuta1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnAgregar
     */
    public javax.swing.JButton getBtnAgregar() {
        return btnAgregar;
    }

}
