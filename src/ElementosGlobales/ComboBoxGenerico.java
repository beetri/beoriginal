/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementosGlobales;

/**
 *
 * @author Bernabe
 */
public class ComboBoxGenerico {
    private String texto;
    private int codigo;

    public void setCodigo(int codigo) {this.codigo = codigo;}
    public void setTexto(String texto) {this.texto = texto;}
    
    
    public int getCodigo() {return codigo;}
    public String getTexto() {return texto;}
    @Override
    public String toString (){return this.texto;}

}
