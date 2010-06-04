/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmLogUsuario.java
 *
 * 
 */

package GUI.Auditoria;

import BusinessEntity.*;
import BusinessLogic.*;
import com.toedter.calendar.JTextFieldDateEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bernabe & tRUfA
 */
public class frmLogUsuario extends javax.swing.JFrame {
    public String Mensaje = "";
    public UsuarioBE objUsuarioBE;
    DateFormat formato= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   /** Creates new form frmLogUsuario */
    public frmLogUsuario() {
        initComponents();

        //Configurar los jDateChooser como no editables
        ((JTextFieldDateEditor)jdtFechaIngreso.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor)jdtFechaSalida.getDateEditor()).setEditable(false);

        //llenarTabla();
    }
    public frmLogUsuario(UsuarioBE objUsuarioBEAux){
        initComponents();
        //llenarTabla();
        objUsuarioBE = objUsuarioBEAux;

    }
    public boolean validar() {
        boolean blnAux = true;

        if (this.jdtFechaIngreso.getDate()!=null && this.jdtFechaIngreso.getDate()!=null) {
            if (this.jdtFechaSalida.getDate().before(this.jdtFechaSalida.getDate())) {
                blnAux = false;
                Mensaje = "La fecha máxima debe ser mayor o igual que la fecha mínima en el rango.";
            }
        }

        return blnAux;
    }
    private Date aDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fecharesult = null;
        try {
          fecharesult = formatoDelTexto.parse(fecha);

           }
        catch (Exception ex) {
             ex.printStackTrace();
         }
         return fecharesult;
    }
    private String fechaACadena(Date objDate){
        SimpleDateFormat strFecha=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formato.format(objDate);

    }
    private void llenarTabla(){
        List<LogUsuarioBE> lstLogUsuarioBE;
        LogUsuarioBL objLogUsuarioBL = new LogUsuarioBL();
        LogUsuarioBE objLogUsuarioAuxBE = new LogUsuarioBE();
        UsuarioBE objUsuarioAuxBE = new UsuarioBE();
        PerfilBE objPerfilAuxBE = new PerfilBE();
        objUsuarioAuxBE.setNombre(this.txtNombre.getText());
        objUsuarioAuxBE.setUsuario(this.txtUsuario.getText());
        objUsuarioAuxBE.setEstado("Activo");
        objLogUsuarioAuxBE.setObjUsuarioBE(objUsuarioAuxBE);
        objLogUsuarioAuxBE.setFechaIngreso(this.jdtFechaIngreso.getDate());
        objLogUsuarioAuxBE.setFechaSalida(this.jdtFechaSalida.getDate());
        
//        String strFechaIngreso = "";  // Se crea para concatenar la fecha que se obtiene del JDateChooser
//        String strFechaSalida = "";
//
//        //Para obtener las fechas de los respectivos JDateChooser
//        if (this.jdtFechaIngreso.getDate() != null) {
//            strFechaIngreso= jdtFechaIngreso.getDate().toString().substring(4,10) + " " + jdtFechaIngreso.getDate().toString().substring(24,28);
//             objLogUsuarioAuxBE.setFechaIngreso(strFechaIngreso);
//        }
//
//        if (this.jdtFechaSalida.getDate() != null) {
//            strFechaSalida= jdtFechaSalida.getDate().toString().substring(4,10) + " " + dteFechaFin.getDate().toString().substring(24,28);
//            objLogUsuarioAuxBE.setFechaSalida(strFechaSalida);
//        }


        if (validar()) {
            lstLogUsuarioBE = objLogUsuarioBL.buscarLogs(objLogUsuarioAuxBE);
            // llenar la tabla
            if (!lstLogUsuarioBE.isEmpty()){
                DefaultTableModel model = (DefaultTableModel) this.tlbLog.getModel();
                model.setRowCount(0) ;
                String fechaingreso;
                for (LogUsuarioBE obj : lstLogUsuarioBE){
                    fechaingreso=fechaACadena(obj.getFechaIngreso());

                    obj.setFechaMia(fechaingreso);
                       Object[] newRow = {
                       obj.getCodLog(),
                       //obj.getObjUsuarioBE().getNombre(),
                       obj.getObjUsuarioBE().getNombre()+' '+obj.getObjUsuarioBE().getApellidoPaterno(),
                       obj.getObjUsuarioBE().getUsuario(),
                       obj.getIP(),
                       obj.getMAC(),
                       obj.getFechaMia(),
                       obj.getObjUsuarioBE().getEstado()};
                       model.addRow(newRow);
                }
                this.tlbLog.setModel(model);
                Mensaje = "Búsqueda satisfactoria.";
            }
            else{
                Mensaje = "No se encontró información que mostrar.";
            }
        }
     }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLog = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        pnlFechas = new javax.swing.JPanel();
        jdtFechaIngreso = new com.toedter.calendar.JDateChooser();
        jdtFechaSalida = new com.toedter.calendar.JDateChooser();
        lblFechaInicio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        pnlResultado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbLog = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Log de Usuario");

        pnlLog.setBorder(javax.swing.BorderFactory.createTitledBorder("Parametros de Busqueda de Logs"));

        lblNombre.setText("Nombre : ");

        lblUsuario.setText("Usuario : ");

        pnlFechas.setBorder(javax.swing.BorderFactory.createTitledBorder("Rango de Fechas"));

        jdtFechaIngreso.setDateFormatString("DD/MM/YYYY");

        jdtFechaSalida.setDateFormatString("DD/MM/YYYY");

        lblFechaInicio.setText("Fecha Inicio : ");

        lblFechaFin.setText("Fecha Fin : ");

        javax.swing.GroupLayout pnlFechasLayout = new javax.swing.GroupLayout(pnlFechas);
        pnlFechas.setLayout(pnlFechasLayout);
        pnlFechasLayout.setHorizontalGroup(
            pnlFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFechasLayout.createSequentialGroup()
                .addGroup(pnlFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaInicio)
                    .addComponent(jLabel2)
                    .addComponent(lblFechaFin))
                .addGap(18, 18, 18)
                .addGroup(pnlFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdtFechaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jdtFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFechasLayout.setVerticalGroup(
            pnlFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaInicio)
                    .addComponent(jdtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(lblFechaFin)
                    .addComponent(jdtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlLogLayout = new javax.swing.GroupLayout(pnlLog);
        pnlLog.setLayout(pnlLogLayout);
        pnlLogLayout.setHorizontalGroup(
            pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pnlFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        pnlLogLayout.setVerticalGroup(
            pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogLayout.createSequentialGroup()
                .addGroup(pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLogLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BuscarComputadora.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btnCerrar.setText("Cancelar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        pnlResultado.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado de la Busqueda"));

        tlbLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Nombre", "Usuario", "IP", "Mac", "Fecha Ingreso", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tlbLog);
        tlbLog.getColumnModel().getColumn(0).setResizable(false);
        tlbLog.getColumnModel().getColumn(0).setPreferredWidth(75);
        tlbLog.getColumnModel().getColumn(1).setResizable(false);
        tlbLog.getColumnModel().getColumn(1).setPreferredWidth(200);
        tlbLog.getColumnModel().getColumn(2).setResizable(false);
        tlbLog.getColumnModel().getColumn(2).setPreferredWidth(200);
        tlbLog.getColumnModel().getColumn(3).setResizable(false);
        tlbLog.getColumnModel().getColumn(3).setPreferredWidth(200);
        tlbLog.getColumnModel().getColumn(4).setResizable(false);
        tlbLog.getColumnModel().getColumn(4).setPreferredWidth(200);
        tlbLog.getColumnModel().getColumn(5).setResizable(false);
        tlbLog.getColumnModel().getColumn(5).setPreferredWidth(250);
        tlbLog.getColumnModel().getColumn(6).setResizable(false);
        tlbLog.getColumnModel().getColumn(6).setPreferredWidth(200);

        javax.swing.GroupLayout pnlResultadoLayout = new javax.swing.GroupLayout(pnlResultado);
        pnlResultado.setLayout(pnlResultadoLayout);
        pnlResultadoLayout.setHorizontalGroup(
            pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlResultadoLayout.setVerticalGroup(
            pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnBuscar)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pnlResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        llenarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        int cantFilas=this.tlbLog.getRowCount();

        // Limpio los JTextField
        txtNombre.setText("");
        txtUsuario.setText("");

        // Limpio la grilla
        for(int j=0;j<cantFilas;j++){
            ((DefaultTableModel) this.tlbLog.getModel()).removeRow(0);
        }

        // Pongo el foco en el JTextField de Nombre
        txtNombre.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdtFechaIngreso;
    private com.toedter.calendar.JDateChooser jdtFechaSalida;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlFechas;
    private javax.swing.JPanel pnlLog;
    private javax.swing.JPanel pnlResultado;
    private javax.swing.JTable tlbLog;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
