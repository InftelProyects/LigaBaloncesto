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
import model.Equipo;
import model.Partido;
import model.Persona;
import utils.Contants;

/**
 *
 * @author mohammed
 */
public class PartidoDaoImpl implements IPartidoDao{

    
    
    @Override
    
    public Partido BuscarPorIdPartido(int id) {
           DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PARTIDO WHERE ID_PARTIDO='" +id+ "'");
            while (resultado.next()) {
                int id_partido = resultado.getInt("id_partido");
                String fecha = resultado.getString("fecha");
                String localizacion = resultado.getString("localizacion");
                int resultado_local = resultado.getInt("RESULTADO_LOCAL");
                int resultado_visitante = resultado.getInt("RESULTADO_VISITANTE");
                int jornada  = resultado.getInt("jornada");
                String nombre_local = resultado.getString("NOMBRE_LOCAL");
                String nombre_visitante = resultado.getString("NOMBRE_VISITANTE");
             
               return new Partido(fecha ,localizacion ,id_partido ,resultado_local,resultado_visitante,jornada,nombre_visitante,nombre_local);
            }
        } catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }
        return null;
    }

    public Partido BuscarPorIdPartido2(int id) {
           DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PARTIDO WHERE ID_PARTIDO='" +id+ "'");
            while (resultado.next()) {
                
                String fecha = resultado.getString("fecha");
                String localizacion = resultado.getString("localizacion");
                String nombre_local = resultado.getString("NOMBRE_LOCAL");
                String nombre_visitante = resultado.getString("NOMBRE_VISITANTE");
             
               return new Partido(fecha ,localizacion ,nombre_visitante,nombre_local);
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
            ResultSet resultado = stm.executeQuery("Select * FROM PARTIDO");
            while(resultado.next()){
                int id_partido = resultado.getInt("id_partido");
                String fecha = resultado.getString("fecha");
                String localizacion = resultado.getString("localizacion");
                int resultado_local = resultado.getInt("RESULTADO_LOCAL");
                int resultado_visitante = resultado.getInt("RESULTADO_VISITANTE");
                int jornada  = resultado.getInt("jornada");
                String nombre_local = resultado.getString("NOMBRE_LOCAL");
                String nombre_visitante = resultado.getString("NOMBRE_VISITANTE");
               Partido partido = new Partido(fecha ,localizacion ,id_partido ,resultado_local,resultado_visitante,jornada,nombre_visitante,nombre_local);
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
        int numTuplas1 = 0;
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        Partido buscarPartidoPorId = BuscarPorIdPartido(p.getId_partido());
        if(buscarPartidoPorId == null){
            System.out.println("No existe ninguN partido con id "+p.getId_partido());
            Statement stmt;
            try {
                stmt = connection.createStatement();
                
                numTuplas1 = stmt.executeUpdate("INSERT INTO PARTIDO (FECHA,LOCALIZACION,ID_PARTIDO,RESULTADO_LOCAL"
                        + ",RESULTADO_VISITANTE,JORNADA,NOMBRE_VISITANTE,NOMBRE_LOCAL) "
                        + "VALUES "
                        + "('"+p.getFecha()+"','"+p.getLocalizacion()+"','"+p.getId_partido()+"','"
                        +p.getResultado_local()+"','"+p.getResultado_visitante() +"','"+p.getJornada()
                        +"','"+p.getNombre_VISITANTE()+"'+'"+p.getNombre_LOCAL()+"')");
            } catch (SQLException ex) {
                Logger.getLogger(PartidoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }else{
            System.out.println("EL PARTIDO con ID "+p.getId_partido() +" ya existe ");
        }
        
        return numTuplas1 > 0;
    }
    
    public boolean insertarResultadosPartidos(Partido partido) {
        int numTuplas1 = 0; 
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        //Equipo buscarPorIdEquipo =  buscarPorIdEquipo(equipo.getId_equipo());
        Statement stmt;
        //int mayorID=obtenerMayorID();
        //mayorID++;
            try {
                stmt = connection.createStatement();
                //ResultSet resultado = stmt.executeQuery("select id_partido from partido where id_partido ='"+id_partido+"'" );
                //while (resultado.next()) {
                numTuplas1 = stmt.executeUpdate("UPDATE PARTIDO "
                        + "SET resultado_local ="+partido.getResultado_local()+", resultado_visitante ="+partido.getResultado_visitante()
                        + "WHERE id_partido="+partido.getId_partido()
                        );
                //System.out.println("Resultados insertados");
               // }
                
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error de valor");
        }
        return numTuplas1 > 0;
    }
    
}
