/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Partido;

/**
 *
 * @author mohammed
 */
public interface IPartidoDao {   
    Partido BuscarPorIdPartido(int id_partido);
    List<Partido> BuscarTodosLospartidos();
    boolean insertarPartido(Partido p);
    boolean eliminarPartido(int id);
    boolean actualizarPartidos(Partido partido);   
}
