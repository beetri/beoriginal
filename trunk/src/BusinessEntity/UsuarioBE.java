package BusinessEntity;


import java.util.Date;
/**
 *
 * @author Bernabe Yanac
 */
public class UsuarioBE {

   private Integer CodUsuario;
   private String Nombre;
   private String ApellidoPaterno;
   private String ApellidoMaterno;
   private String Telefono;
   private String Direccion;
   private String Email;
   private Integer CodCargo;
   private char Sexo;
   private Integer CodArea;
   private Integer CodDistrito;
   private String Usuario;
   private String Password;
   private String Estado;
   private Integer CodPerfil;
   private Integer CodTipoDocumento;
   private String NumeroDocumento;
   private Date FechaCreacion;



   public UsuarioBE()
   {
        this.CodUsuario = 0;
        this.Nombre = "";
        this.ApellidoPaterno = "";
        this.ApellidoMaterno = "";
        this.Usuario = "";
        this.Password = "";
   }

    public UsuarioBE(Integer CodUsuario, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String Usuario, String Password) {
        this.CodUsuario = CodUsuario;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Usuario = Usuario;
        this.Password = Password;
    }



    public Integer getCodUsuario() {return CodUsuario;}
    public String getNombre() {return Nombre;}
    public String getApellidoPaterno() {return ApellidoPaterno;}
    public String getApellidoMaterno() {return ApellidoMaterno;}
    public String getUsuario() {return Usuario;}
    public String getPassword() {return Password;}

    public void setCodUsuario(Integer CodUsuario) {this.CodUsuario = CodUsuario;}
    public void setNombre(String Nombre) {this.Nombre = Nombre;}
    public void setApellidoPaterno(String ApellidoPaterno) {this.ApellidoPaterno = ApellidoPaterno;}
    public void setApellidoMaterno(String ApellidoMaterno) {this.ApellidoMaterno = ApellidoMaterno;}
    public void setUsuario(String Usuario) {this.Usuario = Usuario;}
    public void setPassword(String Password) {this.Password = Password;}


    /**
     * @param Telefono the Telefono to set
     */

    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the CodCargo
     */
    public Integer getCodCargo() {
        return CodCargo;
    }

    /**
     * @param CodCargo the CodCargo to set
     */
    public void setCodCargo(Integer CodCargo) {
        this.CodCargo = CodCargo;
    }

    /**
     * @return the Sexo
     */
    public char getSexo() {
        return Sexo;
    }

    /**
     * @param Sexo the Sexo to set
     */
    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    /**
     * @return the CodArea
     */
    public Integer getCodArea() {
        return CodArea;
    }

    /**
     * @param CodArea the CodArea to set
     */
    public void setCodArea(Integer CodArea) {
        this.CodArea = CodArea;
    }

    /**
     * @return the CodDistrito
     */
    public Integer getCodDistrito() {
        return CodDistrito;
    }

    /**
     * @param CodDistrito the CodDistrito to set
     */
    public void setCodDistrito(Integer CodDistrito) {
        this.CodDistrito = CodDistrito;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the CodPerfil
     */
    public Integer getCodPerfil() {
        return CodPerfil;
    }

    /**
     * @param CodPerfil the CodPerfil to set
     */
    public void setCodPerfil(Integer CodPerfil) {
        this.CodPerfil = CodPerfil;
    }

    /**
     * @return the CodTipoDocumento
     */
    public Integer getCodTipoDocumento() {
        return CodTipoDocumento;
    }

    /**
     * @param CodTipoDocumento the CodTipoDocumento to set
     */
    public void setCodTipoDocumento(Integer CodTipoDocumento) {
        this.CodTipoDocumento = CodTipoDocumento;
    }

    /**
     * @return the NumeroDocumento
     */
    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    /**
     * @param NumeroDocumento the NumeroDocumento to set
     */
    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    /**
     * @return the FechaCreacion
     */
    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    /**
     * @param FechaCreacion the FechaCreacion to set
     */
    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }


  /////////////////////////Desde acá////////////////////////////
//    private PerfilBE objPerfil;
//    private EstadoBE objEstado;
//    private LugarBE objLugar;
//    private TipoDocumentoBE objTipoDocumento;
//
//    private Date dteFechaCreacion;
//    private Date dteFechaModificacion;
//    private int cambiarClave;
//    public int getCambiarClave() {
//        return cambiarClave;
//    }
//
//    public void setCambiarClave(int cambiarClave) {
//        this.cambiarClave = cambiarClave;
//    }
//    public PerfilBE getObjPerfil() {
//        return objPerfil;
//    }
//
//    public void setObjPerfil(PerfilBE objPerfil) {
//        this.objPerfil = objPerfil;
//    }
//    public TipoDocumentoBE getObjTipoDocumento() {
//        return objTipoDocumento;
//    }
//
//    public void setObjTipoDocumento(TipoDocumentoBE objTipoDocumento) {
//        this.objTipoDocumento = objTipoDocumento;
//    }
   
}
