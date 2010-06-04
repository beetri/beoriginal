/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic.Documentos;

import BusinessEntity.Documentos.*;
import DataAccess.Documentos.*;
import java.util.ArrayList;
/**
 *
 * @author pedro
 */
public class SubcategoriaBL {
private SubcategoriaDA objSubcategoriaDA;
     //CategoriaDA categoria = new CategoriaDA();
     public boolean registrarSubcategoria(SubcategoriaBE objSubcategoria){
        objSubcategoriaDA = new SubcategoriaDA();
        try{
            return objSubcategoriaDA.registrarSubcategoria(objSubcategoria);
        }catch(Exception e){
            System.out.println("Ocurrio una Excepcion en SubcategoriaBL"+e.getMessage());
            return false;
        }
    }

   public ArrayList<SubcategoriaBE> listarSubcategoria(SubcategoriaBE objSubcategoria){
        objSubcategoriaDA = new SubcategoriaDA();
        try{
            return objSubcategoriaDA.buscarSubcategoria(objSubcategoria);
        }catch(Exception e){
            System.out.println("Ocurrio una Excepción"+e.getMessage());
            return null;
        }
    }
}
