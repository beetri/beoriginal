/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic.Documentos;

import BusinessEntity.Documentos.*;
import DataAccess.Documentos.*;
import DataAccess.Documentos.CategoriaDA;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class CategoriaBL {
private CategoriaDA objCategoriaDA;
     //CategoriaDA categoria = new CategoriaDA();
     public boolean registrarCategoria(CategoriaBE objCategoria){
        objCategoriaDA = new CategoriaDA();
        try{
            return objCategoriaDA.registrarCategoria(objCategoria);
        }catch(Exception e){
            System.out.println("Ocurrio una Excepcion en CategoriaBL"+e.getMessage());
            return false;
        }
    }

    public ArrayList<CategoriaBE> listarCategoria(CategoriaBE objCategoria){
        objCategoriaDA = new CategoriaDA();
        try{
            return objCategoriaDA.buscarCategoria(objCategoria);
        }catch(Exception e){
            System.out.println("Ocurrio una Excepción"+e.getMessage());
            return null;
        }
    }

}
