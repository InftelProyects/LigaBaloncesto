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
    Equipo buscarPorIdEquipo(int id);
    List<Equipo> buscarTodos();
    boolean insertarPersona(Equipo equipo);
    boolean eliminarPorIdEquipo(int id);
    boolean actualizarPersona(Equipo equipo);
}
