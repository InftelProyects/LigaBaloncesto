/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IPartidoDao;
import db.DatabaseConnector;
import java.sql.Connection;
import java.util.List;
import model.Partido;
import utils.Contants;

/**
 *
 * @author mohammed
 */
public class PartidoDaoImpl implements IPartidoDao{

    
    
    @Override
    public Partido Buscar(int id_partido) {
         
    }

    @Override
    public List<Partido> BuscarTodosLospartidos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertarPartido(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPartido(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarPartidos(Partido partido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
