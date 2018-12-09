/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Equipo;

/**
 *
 * @author mohammed
 */
public interface IEquipoDao {
    
    List<Equipo> buscarTodos();
    boolean insertarEquipo(Equipo equipo);  
    boolean eliminarPorNombreEquipo(String nombre);
    boolean actualizarEquipo(Equipo equipo);

    public Equipo buscarPorNombreEquipo(String nombre_e);
}
