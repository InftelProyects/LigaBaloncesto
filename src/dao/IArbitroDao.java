/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Arbitro;

/**
 *
 * @author josep
 */
public interface IArbitroDao {
    Arbitro buscarPorDni(String dni);
    public List<Arbitro> buscarTodos();
    public boolean insertarArbitro(Arbitro a);
    //boolean eliminarPorDni(String dni);
   // boolean actualizarEntrenador(Entrenador e);

    
}