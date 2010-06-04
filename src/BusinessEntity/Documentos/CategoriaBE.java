/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity.Documentos;

/**
 *
 * @author pedro
 */
public class CategoriaBE {
    private Integer CodCategoria;
    private String Descripcion;
    private String Estado;

    public CategoriaBE()
   {
        this.CodCategoria=0;
        this.Descripcion = "";
        this.Estado = "";
   }

   public CategoriaBE(Integer CodCategoria,String Descripcion, String Estado) {
        this.CodCategoria=CodCategoria;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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
     * @return the CodCategoria
     */
    public Integer getCodCategoria() {
        return CodCategoria;
    }

    /**
     * @param CodCategoria the CodCategoria to set
     */
    public void setCodCategoria(Integer CodCategoria) {
        this.CodCategoria = CodCategoria;
    }

}
