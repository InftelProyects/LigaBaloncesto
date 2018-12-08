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
 * @author beatrizillanesalcaide
 */
public interface IPartidoDao {
    
    Partido buscarPorIdPartido(int id);
    List<Partido> buscarTodo();
    boolean actualizarPartido(Partido partido);
    boolean insertarPartido(Partido partido);
    
}
