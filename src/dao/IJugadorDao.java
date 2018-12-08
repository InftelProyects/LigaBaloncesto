/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Entrenador;
import model.Jugador;
import model.Persona;

/**
 *
 * @author mohammed
 */
public interface IJugadorDao {
    Jugador buscarPorDni(String dni);
    List<Jugador> buscarTodos();
    public boolean insertarJugador(Jugador j) ;
   
}
