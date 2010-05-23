/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmVentanaUsuario.java
 *
 * Created on 05/05/2010, 10:17:29 PM
 */

package GUI.Seguridad;
import BusinessEntity.*;
import BusinessLogic.*;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Administador
 */
public class frmVentanaUsuario extends javax.swing.JFrame {
    private int intModo;
    private UsuarioBE objUsuarioBE;
    private UsuarioBL objUsuarioBL = new UsuarioBL();
    private PerfilBE objPerfilBE = new PerfilBE();
    private PerfilBL objPerfilBL = new PerfilBL();
    private ArrayList<PerfilBE> arrPerfiles = new ArrayList<PerfilBE>();
    private LogUsuarioBE objLogUsuarioBE;
    private LogUsuarioBL objLogUsuarioBL;
    private String ConsultaRealizada="Usuario";
    private String Accion=""; // si es registrar, modificar, eliminar
    private int codmodulo=7; // es 7 xq segun la tabla el codigo de modulo de usuario es 7
    private int codusuario=0; // el usuario que se logueo
    private int codlog=0;
    private boolean resp;
    /** Creates new form frmVentanaUsuario */
    public frmVentanaUsuario() {
        initComponents();
    }
    public frmVentanaUsuario(UsuarioBE objUsuario, int intModo){
        initComponents();

        this.setLocation(60, 110);
        this.intModo=intModo;

        objPerfilBE.setsEstado("Activo");
        objPerfilBE.setsPerfil("");

        try{
            arrPerfiles = (ArrayList<PerfilBE>) objPerfilBL.buscarPerfiles(objPerfilBE);
            this.cmbPerfil.addItem("--Seleccione--");
            for (PerfilBE obj : arrPerfiles ){
                System.out.printf("%s\n",obj.getsPerfil());
               this.cmbPerfil.addItem(obj.getsPerfil());
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en listar perfiles"," Mensaje ",JOptionPane.ERROR_MESSAGE);
        }

        this.cmbSexo.addItem("--Seleccione--");
        this.cmbSexo.addItem("FEMENINO");
        this.cmbSexo.addItem("MASCULINO");

        this.cmbTipoDocumento.addItem("--Seleccione--");
        this.cmbTipoDocumento.addItem("DNI");
        this.cmbTipoDocumento.addItem("CARNET DE EXTRANJERIA");

        this.cmbCargo.addItem("--Seleccione--");
        this.cmbCargo.addItem("Administrador");
        this.cmbCargo.addItem("Encargado");
        this.cmbCargo.addItem("Técnico");

        this.cmbArea.addItem("--Seleccione--");
        this.cmbArea.addItem("Sistemas");
        this.cmbArea.addItem("Contabilidad");
        this.cmbArea.addItem("Ventas");
        this.cmbArea.addItem("Operaciones");

       if(objUsuario!=null){
            this.objUsuarioBE=objUsuario;
        }
        if(intModo==2){
             habilitarControlesPanel();
             cargarDatosPanel(objUsuario);
             this.setTitle("Modificación del Usuario");
        }
    }
   private void habilitarControlesPanel(){
        this.txtNombres.setEnabled(true);
        this.txtApeMaterno.setEnabled(true);
        this.txtApePaterno.setEnabled(true);
        this.txtDireccion.setEnabled(true);
        this.txtNumDocumento.setEnabled(true);
        this.txtEmail.setEnabled(true);
        this.txtTelefono.setEnabled(true);
        this.txtUsuario.setEnabled(true);
        this.cmbSexo.setEnabled(true);
    }
   private void cargarDatosPanel(UsuarioBE obj){
        if(this.intModo==4){
           this.inhabilitarControlesPanel();
           this.btnRegistrar.setEnabled(false);
            this.btnRegistrar.setVisible(false);
        }
        UsuarioBE objUsuario = new UsuarioBE();
        objUsuario= objUsuarioBL.buscarUsuarioInt(obj.getCodUsuario());
        this.txtUsuario.setEditable(false);
        this.txtNombres.setText(objUsuario.getNombre());
        this.txtApeMaterno.setText(objUsuario.getApellidoMaterno());
        this.txtApePaterno.setText(objUsuario.getApellidoPaterno());
        this.txtDireccion.setText(objUsuario.getDireccion());
        this.txtNumDocumento.setText(objUsuario.getNumeroDocumento());
        this.txtEmail.setText(objUsuario.getEmail());
        this.txtTelefono.setText(objUsuario.getTelefono());
        this.txtUsuario.setText(objUsuario.getUsuario());
        if(objUsuario.getSexo()=='F')
            this.cmbSexo.setSelectedIndex(1);
        else{
            if(objUsuario.getSexo()=='M')
            this.cmbSexo.setSelectedIndex(2);
        }
            this.cmbTipoDocumento.setSelectedIndex(objUsuario.getCodTipoDocumento());
            this.cmbCargo.setSelectedIndex(objUsuario.getCodCargo());
            this.cmbArea.setSelectedIndex(objUsuario.getCodArea());
            PerfilBE objPerfilBE = new PerfilBE();
            PerfilBL objPerfilBL = new PerfilBL();
            objPerfilBE = objPerfilBL.buscarPerfil(objUsuario.getCodPerfil());
            this.cmbPerfil.setSelectedItem(objPerfilBE.getsPerfil());
            this.cmbDepartamento.setSelectedIndex(1);
            this.cmbProvincia.setSelectedIndex(1);
            this.cmbDistrito.setSelectedIndex(objUsuario.getCodDistrito());
    }
   private void inhabilitarControlesPanel(){
        this.txtNombres.setEditable(false);
        this.txtApeMaterno.setEditable(false);
        this.txtApePaterno.setEditable(false);
        this.txtDireccion.setEditable(false);
        this.txtNumDocumento.setEditable(false);
        this.txtEmail.setEditable(false);
        this.txtTelefono.setEditable(false);
        this.txtUsuario.setEditable(false);
        this.cmbDepartamento.setEnabled(false);
        this.cmbProvincia.setEnabled(false);
        this.cmbDistrito.setEnabled(false);
        this.cmbSexo.setEnabled(false);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUsuario = new javax.swing.JPanel();
        pnlDatosPersonales = new javax.swing.JPanel();
        lblNombres = new javax.swing.JLabel();
        lblApePaterno = new javax.swing.JLabel();
        lblApeMaterno = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApePaterno = new javax.swing.JTextField();
        txtApeMaterno = new javax.swing.JTextField();
        lblTipoDocumento = new javax.swing.JLabel();
        lblNumDocumento = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        cmbTipoDocumento = new javax.swing.JComboBox();
        cmbSexo = new javax.swing.JComboBox();
        txtNumDocumento = new javax.swing.JTextField();
        pnlDatosAcceso = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        cmbPerfil = new javax.swing.JComboBox();
        pnlOtrosDatos = new javax.swing.JPanel();
        lblDireccion = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        lblDistrito = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cmbDepartamento = new javax.swing.JComboBox();
        cmbProvincia = new javax.swing.JComboBox();
        cmbDistrito = new javax.swing.JComboBox();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cmbArea = new javax.swing.JComboBox();
        cmbCargo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 12), java.awt.Color.blue)); // NOI18N

        pnlDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 12), java.awt.Color.blue)); // NOI18N

        lblNombres.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblNombres.setText("Nombres (*): ");

        lblApePaterno.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblApePaterno.setText("Apellido Paterno (*) : ");

        lblApeMaterno.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblApeMaterno.setText("Apellido Materno (*) :");

        txtNombres.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        txtApePaterno.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        txtApeMaterno.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        lblTipoDocumento.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblTipoDocumento.setText("Tipo Documento (*):");

        lblNumDocumento.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblNumDocumento.setText("Numero de Documento (*) :");

        lblSexo.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblSexo.setText("Sexo (*) :");

        cmbTipoDocumento.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        cmbSexo.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        txtNumDocumento.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        javax.swing.GroupLayout pnlDatosPersonalesLayout = new javax.swing.GroupLayout(pnlDatosPersonales);
        pnlDatosPersonales.setLayout(pnlDatosPersonalesLayout);
        pnlDatosPersonalesLayout.setHorizontalGroup(
            pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombres)
                    .addComponent(lblApePaterno)
                    .addComponent(lblApeMaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSexo)
                    .addComponent(lblTipoDocumento)
                    .addComponent(lblNumDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        pnlDatosPersonalesLayout.setVerticalGroup(
            pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombres))
                    .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoDocumento)
                        .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblApePaterno))
                    .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNumDocumento)
                        .addComponent(txtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApeMaterno)
                    .addComponent(lblSexo)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatosAcceso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Acceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 12), java.awt.Color.blue)); // NOI18N

        lblUsuario.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblUsuario.setText("Usuario (*)");

        lblPerfil.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblPerfil.setText("Perfil de Usuario (*) :");

        txtUsuario.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        cmbPerfil.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        javax.swing.GroupLayout pnlDatosAccesoLayout = new javax.swing.GroupLayout(pnlDatosAcceso);
        pnlDatosAcceso.setLayout(pnlDatosAccesoLayout);
        pnlDatosAccesoLayout.setHorizontalGroup(
            pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosAccesoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addGap(81, 81, 81)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(lblPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pnlDatosAccesoLayout.setVerticalGroup(
            pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosAccesoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario)
                    .addComponent(lblPerfil)
                    .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlOtrosDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Otros Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 12), java.awt.Color.blue)); // NOI18N

        lblDireccion.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblDireccion.setText("Dirección (*) :");
        lblDireccion.setName("lblDireccion"); // NOI18N

        lblDepartamento.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblDepartamento.setText("Departamento(*) :");
        lblDepartamento.setName("lblPais"); // NOI18N

        lblProvincia.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblProvincia.setText("Provincia(*) :");
        lblProvincia.setName("lblPais"); // NOI18N

        lblDistrito.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblDistrito.setText("Distrito(*) :");
        lblDistrito.setName("lblPais"); // NOI18N

        lblTelefono.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblTelefono.setText("Teléfono (*) :");
        lblTelefono.setName("lblTelefono"); // NOI18N

        lblEmail.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblEmail.setText("Email (*) :");
        lblEmail.setName("lblEmail"); // NOI18N

        lblArea.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblArea.setText("Áreal (*) :");
        lblArea.setName("lblEmail"); // NOI18N

        lblCargo.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        lblCargo.setText("Cargo (*) :");
        lblCargo.setName("lblEmail"); // NOI18N

        txtDireccion.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        cmbDepartamento.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        cmbProvincia.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        cmbDistrito.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        txtTelefono.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        txtEmail.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        cmbArea.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        cmbCargo.setFont(new java.awt.Font("DejaVu Sans", 0, 12));

        javax.swing.GroupLayout pnlOtrosDatosLayout = new javax.swing.GroupLayout(pnlOtrosDatos);
        pnlOtrosDatos.setLayout(pnlOtrosDatosLayout);
        pnlOtrosDatosLayout.setHorizontalGroup(
            pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOtrosDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(lblDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbProvincia, 0, 176, Short.MAX_VALUE)
                    .addComponent(cmbDepartamento, 0, 176, Short.MAX_VALUE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(cmbDistrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addGroup(pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(lblTelefono)
                    .addComponent(lblArea)
                    .addComponent(lblCargo))
                .addGap(131, 131, 131)
                .addGroup(pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(cmbArea, javax.swing.GroupLayout.Alignment.LEADING, 0, 176, Short.MAX_VALUE)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.Alignment.LEADING, 0, 176, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(20, 20, 20))
        );
        pnlOtrosDatosLayout.setVerticalGroup(
            pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOtrosDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addGroup(pnlOtrosDatosLayout.createSequentialGroup()
                        .addGroup(pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDepartamento)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProvincia)
                            .addComponent(lblArea))
                        .addGap(6, 6, 6)
                        .addGroup(pnlOtrosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDistrito)
                            .addComponent(lblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlOtrosDatosLayout.createSequentialGroup()
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        jLabel9.setText("(*) Datos Obligatorios ");

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(pnlOtrosDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
                    .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatosAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatosAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlOtrosDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnRegistrar.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Seguridad/guardar.png"))); // NOI18N
        btnRegistrar.setFocusable(false);
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRegistrar);

        btnLimpiar.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Auditoria/erase_icon.gif"))); // NOI18N
        btnLimpiar.setFocusable(false);
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLimpiar);

        btnCancelar.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Seguridad/Close-icon.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(479, 479, 479))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(69, Short.MAX_VALUE)
                    .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.txtNombres.setText("");
        this.txtApeMaterno.setText("");
        this.txtApePaterno.setText("");
        this.txtNumDocumento.setText("");
        this.txtUsuario.setText("");
        this.txtDireccion.setText("");
        this.cmbDepartamento.setSelectedIndex(0);
        this.cmbPerfil.setSelectedIndex(0);
        this.cmbArea.setSelectedIndex(0);
        this.cmbCargo.setSelectedIndex(0);
        this.cmbTipoDocumento.setSelectedIndex(0);
        this.cmbSexo.setSelectedIndex(0);
        this.cmbProvincia.setSelectedIndex(0);
        this.cmbDistrito.setSelectedIndex(0);
        this.cmbSexo.setSelectedIndex(0);
        this.txtEmail.setText("");
        this.txtTelefono.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try{
        UsuarioBE objUsuario = new UsuarioBE();
                            almacenarDatos(objUsuario);
                            //insertarContraseñaUsuario(objUsuario);
                                 if (this.objUsuarioBL.registrarUsuario(objUsuario,2)){
                                  String texto="El usuario se registro satisfactoriamente";
                                  //dlgAvisoExito exito=new dlgAvisoExito(javax.swing.JOptionPane.getFrameForComponent(this),true,texto);
                                  //exito.setVisible(true);
                                  this.dispose();
                            }else{
                                String texto="Error al registrar al usuario";
                                //dlgAvisoError error=new dlgAvisoError(javax.swing.JOptionPane.getFrameForComponent(this),true, texto);
                                //error.setVisible(true);
                            }
        }
        catch(Exception e)
        {
            System.out.println("Ocurrio una Excepcion en frmMantenmientoUsuario"+e.getMessage());

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
 private void almacenarDatos(UsuarioBE objUsuario){
        objUsuario.setNombre(this.txtNombres.getText());
        objUsuario.setApellidoPaterno(this.txtApePaterno.getText());
        objUsuario.setApellidoMaterno(this.txtApeMaterno.getText());
        objUsuario.setTelefono(this.txtTelefono.getText());
        objUsuario.setDireccion(this.txtDireccion.getText());
        objUsuario.setEmail(this.txtEmail.getText());
        objUsuario.setCodCargo(this.cmbCargo.getSelectedIndex());
        objUsuario.setSexo(this.cmbSexo.getSelectedItem().toString().charAt(0));
        objUsuario.setCodArea(this.cmbArea.getSelectedIndex());
        objUsuario.setCodDistrito(this.cmbDistrito.getSelectedIndex());
        objUsuario.setUsuario(this.txtUsuario.getText());
        objUsuario.setEstado("Activo");
        PerfilBE objPerfilBE = new PerfilBE();
        PerfilBL objPerfilBL = new PerfilBL();
        objPerfilBE=objPerfilBL.buscarPerfilNombre(this.cmbPerfil.getSelectedItem().toString());
        objUsuario.setCodPerfil(objPerfilBE.getiCodPerfil());
        objUsuario.setCodTipoDocumento(this.cmbTipoDocumento.getSelectedIndex());
        objUsuario.setNumeroDocumento(this.txtNumDocumento.getText());
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVentanaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cmbArea;
    private javax.swing.JComboBox cmbCargo;
    private javax.swing.JComboBox cmbDepartamento;
    private javax.swing.JComboBox cmbDistrito;
    private javax.swing.JComboBox cmbPerfil;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JComboBox cmbTipoDocumento;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblApeMaterno;
    private javax.swing.JLabel lblApePaterno;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNumDocumento;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoDocumento;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlDatosAcceso;
    private javax.swing.JPanel pnlDatosPersonales;
    private javax.swing.JPanel pnlOtrosDatos;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JTextField txtApeMaterno;
    private javax.swing.JTextField txtApePaterno;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumDocumento;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
