/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IPartidoDao;
import db.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Partido;
import model.Persona;
import utils.Contants;

/**
 *
 * @author mohammed
 */
public class PartidoDaoImpl implements IPartidoDao{

    
    
    @Override
    public Partido BuscarPorIdPartido(int id_partido) {
           DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PARTIDO WHERE ID_PARTIDO='" +id_partido+ "'");
            while (resultado.next()) {
             
                String fecha = resultado.getString("fecha");
                String localizacion = resultado.getString("localizacion");
                id_partido = resultado.getInt("id_partido");
                int resultad = resultado.getInt("RESULTADO");
                int jornada  = resultado.getInt("jornada");
                int idVisitante = resultado.getInt("id_visitante");
                int idLocal = resultado.getInt("id_local");
             
                return new Partido (fecha,localizacion , id_partido, resultad ,
                        jornada, idVisitante, idLocal);
            }
        } catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Partido> BuscarTodosLospartidos() {
           List<Partido> listaPartidos = new ArrayList<>();
           DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        try {
            Statement stm = connection.createStatement();
            ResultSet resultado = stm.executeQuery("Select * FFROM PARTIDO");
            while(resultado.next()){
                String fecha = resultado.getString("fecha");
                String localizacion = resultado.getString("localizacion");
                int id_partido = resultado.getInt("id_partido");
                int resultad = resultado.getInt("RESULTADO");
                int jornada  = resultado.getInt("jornada");
                int idVisitante = resultado.getInt("id_visitante");
                int idLocal = resultado.getInt("id_local");
               Partido partido = new Partido(fecha ,localizacion ,id_partido ,resultad
                       ,jornada , idVisitante ,idLocal );
               listaPartidos.add(partido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PartidoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPartidos;
    }

    

    @Override
    public boolean eliminarPartido(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarPartidos(Partido partido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertarPartido(Partido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
