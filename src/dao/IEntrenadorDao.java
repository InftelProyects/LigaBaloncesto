/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Entrenador;

/**
 *
 * @author mohammed
 */
public interface IEntrenadorDao {
    Entrenador buscarPorDni(String dni);
    List<Entrenador> buscarTodos();
    boolean insertarEntrenador(Entrenador e);
    //boolean eliminarPorDni(String dni);
   // boolean actualizarEntrenador(Entrenador e);
}
