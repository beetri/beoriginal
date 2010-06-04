/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmPerfil.java
 *
 * Created on 23/10/2009, 02:34:14 PM
 */

package GUI.Seguridad;
import BusinessEntity.*;
import BusinessLogic.*;
import GUI.Mensajes.*;
//import ElementosGlobales.JTextFieldFilter;
import GUI.Principal.frmVentanaPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Bernabe Yanac
 */

public class frmVentanaPerfil extends javax.swing.JFrame {
       private int intModo;
       private PerfilBE objPerfilBE;
       private PerfilBE objPerfilBE2;
//       private EstadoBE objEstadoBE;
       private PerfilBL objPerfilBL;
       private UsuarioBE objUsuario;
       List<ModuloBE> lstModulo1BE ;
       List<ModuloBE> lstModulo2BE ;
       List<ModuloBE> lstModulo3BE ;
       int intTamañoPerfiles = 1;
       // esto es para auditoria, valido para todos los modulos
        private LogUsuarioBE objLogUsuarioBE;
        private LogUsuarioBL objLogUsuarioBL;
        private TransaccionBE objTransaccionBE;
        private TransaccionBL objTransaccionBL;
        private String ConsultaRealizada="Perfil";
        private String Accion=""; // si es registrar, modificar, eliminar
        private int codmodulo=3; // es 3 xq segun la tabla el codigo de modulo de usuario es 3
        private int codusuario=0; // el usuario que se logueo
        private int codlog=0;
        private boolean resp;
   //// fin de lo agregado para auditoria

    /** Creates new form frmPerfil */
//    public frmVentanaPerfil(java.awt.Frame parent, boolean modal, int intModo, PerfilBE objPerfilBE, UsuarioBE objUsuario ) {
    public frmVentanaPerfil(PerfilBE objPerfil, int intModo) {
        initComponents();
//        validaciones();
//        this.txaBarraEstado.setFont(new Font("Dialog",Font.BOLD, 12));
//        this.objUsuario = objUsuario;

        

        this.intModo=intModo;
        this.objPerfilBE=null;

        modelo1 = new javax.swing.DefaultListModel();
        modelo2 = new javax.swing.DefaultListModel() ;

        if(objPerfil!=null){
            this.objPerfilBE=objPerfil;
        }


         ModuloBL objModuloBL = new ModuloBL();
         if(this.intModo!=3){
             if(this.intModo==2){
             this.setTitle("Modificación de Perfil");
             this.btnRegistrar.setText("Guardar");
             this.txtNombrePerfil.setText(this.objPerfilBE.getPerfil());
//             this.txtaDescripcion.setText(this.objPerfilBE.getStrDescripcion());
             try{
                 lstModulo3BE = objModuloBL.getModulo(this.objPerfilBE.getCodPerfil());
              }
              catch(Exception exc){
              System.out.println(exc.toString());
              }
              for (int i=0 ;i< lstModulo3BE.size();i++){
                  modelo1.addElement(lstModulo3BE.get(i).getModulo());
               }
              lstFuncionalidadPerfil.setModel(modelo1);



         }else{
           this.setTitle("Registro de Perfil");
                        this.btnRegistrar.setText("Registrar");
         }
            try{


            lstModulo1BE = objModuloBL.getModuloTotal();
            }
            catch(Exception exc){
            System.out.println(exc.toString());

            }

           for (int i=0 ;i< lstModulo1BE.size();i++){

            modelo2.addElement(lstModulo1BE.get(i).getModulo());

           }
          if(lstModulo3BE!=null){
           for (int i=0 ;i< lstModulo3BE.size();i++)
            modelo2.removeElement(lstModulo3BE.get(i).getModulo());
           }
         lstFuncionalidades.setModel(modelo2);

  }
}

    public void validaciones(){
//        this.txtNombrePerfil..setDocument(new JTextFieldFilter (JTextFieldFilter.ALL, 50));
//        this.txtAbreviaturaPerfil.setDocument(new JTextFieldFilter (JTextFieldFilter.ALL, 50));
//        this.txtaDescripcion.setDocument(new JTextFieldFilter (JTextFieldFilter.ALL, 250));

        
    }



    public void  registrarPerfil(){
        ModuloBL objModuloBL = new ModuloBL();
        int[] arreglo= new int[50];
        objPerfilBE2=new PerfilBE();
        objPerfilBL = new PerfilBL();
        if(validar()){

            try{
               objPerfilBE2.setEstado("Activo");
               objPerfilBE2.setPerfil(txtNombrePerfil.getText());
                if(this.intModo==1){
                   //objPerfilBE2.setDteFechaCreacion(new Date());
               }else{//objPerfilBE2.setDteFechaCreacion(objPerfilBE.getDteFechaCreacion());
//                 objPerfilBE2.setCodPerfil(objPerfilBE.getCodPerfil());
                }
                ModuloBE objModuloAux = new ModuloBE();
                for (int i=0 ;i< modelo1.size();i++){
                    String s= ((String)modelo1.getElementAt(i));
                    try{
                        objModuloAux = new ModuloBE();
                        objModuloAux = objModuloBL.getModulo(s);
                    } catch(Exception exc){
                        System.out.println(exc.toString());

                    }
                    arreglo[i]=objModuloAux.getCodModulo();
                }
                if(this.intModo==1)
                {
//                    if (objPerfilBL.registrarPerfil(objPerfilBE2, arreglo, this.objUsuario.getCodUsuario())){
                    
                       if (objPerfilBL.registrarPerfil(objPerfilBE2, arreglo)){
//                            JOptionPane.showMessageDialog(this,"El Perfil se registró satisfactoriamente.",null, JOptionPane.INFORMATION_MESSAGE);
                           // se agrega para auditoria
                          objTransaccionBE = new TransaccionBE();
                          objTransaccionBL = new TransaccionBL();
                          Accion="Guardar";

                          objUsuario=frmVentanaPrincipal.usuarioActual;
                           codlog=frmVentanaPrincipal.logActual;
                          codusuario = objUsuario.getCodUsuario();
                          objTransaccionBE = cargarTransaccion(objUsuario,Accion,codmodulo,codusuario,codlog);
                          resp=objTransaccionBL.registrarTransaccion(objTransaccionBE);
                      // fin de lo agregado para auditoria

                           String texto="El Perfil se registró satisfactoriamente";
                           dlgAvisoExito exito=new dlgAvisoExito(javax.swing.JOptionPane.getFrameForComponent(this),true,texto);
                            exito.setVisible(true);
                            this.dispose();
                       }
                       else
//                       JOptionPane.showMessageDialog(this,"El Perfil no se pudo registrar",null, JOptionPane.INFORMATION_MESSAGE);
                        {
                           String texto="Error al registrar el perfil";
                           dlgAvisoError error=new dlgAvisoError(javax.swing.JOptionPane.getFrameForComponent(this),true, texto);
                            error.setVisible(true);}
                }//else { objPerfilBL.modificarPerfil(objPerfilBE2, arreglo, this.objUsuario.getCodUsuario());
                 else { 
                    
                    if(objPerfilBL.modificarPerfil(objPerfilBE2, arreglo, objPerfilBE.getCodPerfil())){
//                         // se agrega para auditoria
//                          objTransaccionBE = new TransaccionBE();
//                          objTransaccionBL = new TransaccionBL();
//                          Accion="Modificar";
//
//                          objUsuario=frmVentanaPrincipal.usuarioActual;
//                           codlog=frmVentanaPrincipal.logActual;
//                          codusuario = objUsuario.getCodUsuario();
//                          objTransaccionBE = cargarTransaccion(objUsuario,Accion,codmodulo,codusuario,codlog);
//                          resp=objTransaccionBL.registrarTransaccion(objTransaccionBE);
//                      // fin de lo agregado para auditoria

                        String texto="El Perfil se modificó satisfactoriamente";
                        dlgAvisoExito exito=new dlgAvisoExito(javax.swing.JOptionPane.getFrameForComponent(this),true,texto);
                        exito.setVisible(true);
                        this.dispose();
                    }
                    else
//                       JOptionPane.showMessageDialog(this,"El Perfil no se pudo modificar",null, JOptionPane.INFORMATION_MESSAGE);
                        {
                            String texto="Error al modificar al perfil";
                            dlgAvisoError error=new dlgAvisoError(javax.swing.JOptionPane.getFrameForComponent(this),true, texto);
                            error.setVisible(true);}
                        }
                } catch(Exception e){
                     System.out.println(e.toString());
                }
        } else{
        }
    }
     public boolean eliminarPerfil(PerfilBE objPerfilBE){
          objPerfilBL=new PerfilBL();

        if (objPerfilBL.eliminarperfil(objPerfilBE, this.objUsuario.getCodUsuario())){           

            return true;
        }else{
           return false;
        }

    }

    public boolean validar(){
        boolean respuesta = true;
        this.txtNombrePerfil.setBackground(new JTextField().getBackground());
        this.lstFuncionalidadPerfil.setBackground(new JTextField().getBackground());
        if (this.txtNombrePerfil.getText().isEmpty()){
            respuesta = false;
            this.txtNombrePerfil.setBackground(Color.YELLOW);
             this.txaBarraEstado.setForeground(Color.RED);
              this.txaBarraEstado.setText("Error Falta ingresar el nombre del Perfil, campos Obligatorio");
        }
        if (this.modelo1.isEmpty()){
            respuesta = false;
            this.lstFuncionalidadPerfil.setBackground(Color.YELLOW);
             this.txaBarraEstado.setForeground(Color.RED);
              this.txaBarraEstado.setText("ERROR - Debe asignar por lo menos un módulo al perfil");
        }

        return respuesta;
    }
    
public TransaccionBE cargarTransaccion(UsuarioBE objUsuarioBE,String Accion,int codmodulo,int codusuario,int codlog){

        Date fecha = new Date();

//        objTransaccionBE = new TransaccionBE();
//        objTransaccionBE.setFecha(fecha);
//        objTransaccionBE.setObjUsuarioBE(objUsuarioBE);
//        objTransaccionBE.setCodModulo(codmodulo);
//        objTransaccionBE.setConsultaRealizada(ConsultaRealizada);
//        objTransaccionBE.setAccion(Accion);
//        objTransaccionBE.setCodlog(codlog);


         return   objTransaccionBE;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPerfil = new javax.swing.JPanel();
        lblNombrePerfil = new javax.swing.JLabel();
        txtNombrePerfil = new javax.swing.JTextField();
        lblCamposObligatorios = new javax.swing.JLabel();
        pnlFuncionalidades = new javax.swing.JPanel();
        lblFuncionalidadPerfil = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFuncionalidadPerfil = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFuncionalidades = new javax.swing.JList();
        lblFuncionalidades = new javax.swing.JLabel();
        btnAgregarTodo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnQuitarTodo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txaBarraEstado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfil");

        pnlPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Perfil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 12), java.awt.Color.blue)); // NOI18N

        lblNombrePerfil.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblNombrePerfil.setText("Nombre (*) :");

        txtNombrePerfil.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        txtNombrePerfil.setNextFocusableComponent(lstFuncionalidadPerfil);
        txtNombrePerfil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombrePerfilFocusGained(evt);
            }
        });
        txtNombrePerfil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePerfilKeyTyped(evt);
            }
        });

        lblCamposObligatorios.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblCamposObligatorios.setText("(*) Campos obligatorios");

        pnlFuncionalidades.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcionalidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 12), java.awt.Color.blue)); // NOI18N

        lblFuncionalidadPerfil.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblFuncionalidadPerfil.setText("Funcionalidades del Perfil (*) :");

        lstFuncionalidadPerfil.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lstFuncionalidadPerfil.setAutoscrolls(false);
        jScrollPane1.setViewportView(lstFuncionalidadPerfil);

        lstFuncionalidades.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lstFuncionalidades.setAutoscrolls(false);
        jScrollPane2.setViewportView(lstFuncionalidades);

        lblFuncionalidades.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblFuncionalidades.setText("Funcionalidades :");

        btnAgregarTodo.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        btnAgregarTodo.setText("<<");
        btnAgregarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTodoActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        btnAgregar.setText("<");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        btnQuitar.setText(">");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnQuitarTodo.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        btnQuitarTodo.setText(">>");
        btnQuitarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFuncionalidadesLayout = new javax.swing.GroupLayout(pnlFuncionalidades);
        pnlFuncionalidades.setLayout(pnlFuncionalidadesLayout);
        pnlFuncionalidadesLayout.setHorizontalGroup(
            pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFuncionalidadPerfil)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                        .addComponent(btnQuitarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                        .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addComponent(btnAgregarTodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(lblFuncionalidades))
                    .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlFuncionalidadesLayout.setVerticalGroup(
            pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFuncionalidades)
                    .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                        .addComponent(lblFuncionalidadPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                                .addComponent(btnAgregarTodo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnQuitar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnQuitarTodo)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPerfilLayout = new javax.swing.GroupLayout(pnlPerfil);
        pnlPerfil.setLayout(pnlPerfilLayout);
        pnlPerfilLayout.setHorizontalGroup(
            pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPerfilLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFuncionalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPerfilLayout.createSequentialGroup()
                        .addComponent(lblNombrePerfil)
                        .addGap(5, 5, 5)
                        .addComponent(txtNombrePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCamposObligatorios)
                .addContainerGap(518, Short.MAX_VALUE))
        );
        pnlPerfilLayout.setVerticalGroup(
            pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerfilLayout.createSequentialGroup()
                .addGroup(pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombrePerfil)
                    .addComponent(txtNombrePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFuncionalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCamposObligatorios, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCancelar.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txaBarraEstado.setBackground(new java.awt.Color(204, 204, 204));
        txaBarraEstado.setColumns(20);
        txaBarraEstado.setFont(new java.awt.Font("Dialog", 1, 12));
        txaBarraEstado.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addComponent(txaBarraEstado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txaBarraEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombrePerfilFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombrePerfilFocusGained

}//GEN-LAST:event_txtNombrePerfilFocusGained

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (lstFuncionalidades.getSelectedValue()!=null){
        modelo1.addElement(lstFuncionalidades.getSelectedValue());
        lstFuncionalidadPerfil.setModel(this.modelo1);
        modelo2.removeElement(lstFuncionalidades.getSelectedValue());
        lstFuncionalidades.setModel(this.modelo2);
        }else  {
}
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
         if (lstFuncionalidadPerfil.getSelectedValue()!=null){
        modelo2.addElement(lstFuncionalidadPerfil.getSelectedValue());
        lstFuncionalidades.setModel(this.modelo2);
        modelo1.removeElement(lstFuncionalidadPerfil.getSelectedValue());
        lstFuncionalidadPerfil.setModel(this.modelo1);
        }else  {
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoActionPerformed
        // TODO add your handling code here:
        for (int i=0 ;i< modelo2.size();i++)
            modelo1.addElement(modelo2.getElementAt(i));
        modelo2.removeAllElements();

        lstFuncionalidades.setModel(modelo2);
        lstFuncionalidadPerfil.setModel(modelo1);
    }//GEN-LAST:event_btnAgregarTodoActionPerformed

    private void btnQuitarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTodoActionPerformed
        // TODO add your handling code here:
         for (int i=0 ;i< modelo1.size();i++)
        modelo2.addElement(modelo1.getElementAt(i));
        modelo1.removeAllElements();

        lstFuncionalidades.setModel(modelo2);
        lstFuncionalidadPerfil.setModel(modelo1);
    }//GEN-LAST:event_btnQuitarTodoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        String texto="Desea continuar con la operación?";
        dlgAvisoConfirmacion aviso=new dlgAvisoConfirmacion(javax.swing.JOptionPane.getFrameForComponent(this),true,texto);
        aviso.setVisible(true);

         if (aviso.getReturnStatus()==1){
            registrarPerfil();
         }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtNombrePerfilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePerfilKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        this.intTamañoPerfiles=this.txtNombrePerfil.getText().length()+1;
        if( (caracter >= '0') && (caracter <= '9') ){
            evt.consume(); // ignorar el evento de teclado
        }

        if (this.intTamañoPerfiles > 50){
            evt.consume();
        }
        if ((caracter == '\b') && (this.intTamañoPerfiles > 1)){
            this.intTamañoPerfiles -= 1;
        } else
            if ( (this.intTamañoPerfiles <=50) && (caracter != '\b')
                 && ( (caracter < '0') || (caracter > '9')) ){
            this.intTamañoPerfiles += 1;
        }
    }//GEN-LAST:event_txtNombrePerfilKeyTyped

//    /**
//    * @param args the command line arguments
//    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmVentanaPerfil().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarTodo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarTodo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCamposObligatorios;
    private javax.swing.JLabel lblFuncionalidadPerfil;
    private javax.swing.JLabel lblFuncionalidades;
    private javax.swing.JLabel lblNombrePerfil;
    private javax.swing.JList lstFuncionalidadPerfil;
    private javax.swing.JList lstFuncionalidades;
    private javax.swing.JPanel pnlFuncionalidades;
    private javax.swing.JPanel pnlPerfil;
    private javax.swing.JTextArea txaBarraEstado;
    private javax.swing.JTextField txtNombrePerfil;
    // End of variables declaration//GEN-END:variables
    private javax.swing.DefaultListModel modelo1 ;
    private javax.swing.DefaultListModel modelo2 ;
}
