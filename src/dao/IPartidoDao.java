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
    Partido Buscar(int id_partido);
    List<Partido> BuscarTodosLospartidos();
    boolean insertarPartido(int id);
    boolean eliminarPartido(int id);
    boolean actualizarPartidos(Partido partido);   
}
