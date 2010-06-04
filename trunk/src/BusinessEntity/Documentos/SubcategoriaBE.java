/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity.Documentos;

/**
 *
 * @author pedro
 */
public class SubcategoriaBE {
    private Integer CodSubcategoria;
    private String Descripcion;
    private String Estado;
    private int CodCategoria;

    public SubcategoriaBE()
   {
        this.CodSubcategoria=0;
        this.Descripcion = "";
        this.Estado = "";
        this.CodCategoria=0;
   }

   public SubcategoriaBE(Integer CodSubcategoria, String Descripcion, String Estado, int CodCategoria) {
        this.CodSubcategoria=CodSubcategoria;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.CodCategoria=CodCategoria;
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
    public int getCodCategoria() {
        return CodCategoria;
    }

    /**
     * @param CodCategoria the CodCategoria to set
     */
    public void setCodCategoria(int CodCategoria) {
        this.CodCategoria = CodCategoria;
    }

    /**
     * @return the CodSubcategoria
     */
    public Integer getCodSubcategoria() {
        return CodSubcategoria;
    }

    /**
     * @param CodSubcategoria the CodSubcategoria to set
     */
    public void setCodSubcategoria(Integer CodSubcategoria) {
        this.CodSubcategoria = CodSubcategoria;
    }
}
