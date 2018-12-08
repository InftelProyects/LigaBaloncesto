/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IEquipoDao;
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
import utils.Contants;

/**
 *
 * @author mohammed
 */
public class EquipoDaoImpl implements IEquipoDao{

    @Override
    public Equipo buscarPorIdEquipo(int id) {
         DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
         Statement stmt;
        try {
            stmt = connection.createStatement();
            
             ResultSet resultado = stmt.executeQuery("SELECT * FROM EQUIPO WHERE ID_EQUIPO ='"+id+"'");
             while (resultado.next()) {
               
                int idEquipo = resultado.getInt("ID_EQUIPO");
                String nombre = resultado.getString("NOMBRE");
                String provencia = resultado.getString("PROVENCIA");
                String categoria = resultado.getString("CATEGORIA");
                int puntos = resultado.getInt("PUNTOS");
                
                return new Equipo(categoria, nombre, provencia, idEquipo, puntos) ;
                
             }   
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
           return null;
            
    }

    @Override
    public List<Equipo> buscarTodos() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        List<Equipo> listaDeEquipos = new ArrayList<>();
         Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM EQUIPO");
            while (resultado.next()) {
                int idEquipo = resultado.getInt("ID_EQUIPO");
                String nombre = resultado.getString("NOMBRE_EQUIPO");
                String categoria = resultado.getString("CATEGORIA");
                String provencia = resultado.getString("PROVINCIA");
                int puntos = resultado.getInt("PUNTOS");
                
                Equipo equipo = new Equipo(categoria, nombre, provencia, idEquipo, puntos);
                listaDeEquipos.add(equipo);
                
            }    
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaDeEquipos;
    }

    @Override
    public boolean insertarEquipo(Equipo equipo) {
        int numTuplas1 = 0; 
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        Equipo buscarPorIdEquipo =  buscarPorIdEquipo(equipo.getId_equipo());
        if(buscarPorIdEquipo == null){
             System.out.println("No existe ningun Equipo con EL ID "+equipo.getId_equipo());
            Statement stmt;
            try {
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("INSERT INTO EQUIPO "
                        + "(ID_EQUIPO,NOMBRE,PROVINCIA,CATEGORIA,PUNTOS) "
                        + "VALUES "
                        + "("+equipo.getId_equipo()+",'"+equipo.getNombre()+"','"
                        +equipo.getProvincia()+"','"+ equipo.getCategoria()+"',"
                        +equipo.getPuntos()+")");
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return numTuplas1 > 0;
    }

    @Override
    public boolean eliminarPorIdEquipo(String nombre) {
       
       int  numTuplas1 = 0; 
       DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        System.out.println("borrar equipo por nombre");
        Statement stmt;
        try {
            stmt = connection.createStatement();
            numTuplas1 = stmt.executeUpdate("DELETE FROM EQUIPO WHERE NOMBRE = '"+nombre+"' ");
            
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return numTuplas1 > 0;
    }

    @Override
    public boolean actualizarEquipo(Equipo equipo) {
        int numTuplas1 = 0;
         DatabaseConnector databaseConnector = new DatabaseConnector();
         Connection connection = databaseConnector.getConnection(
                 Contants.URL, Contants.USERNAME, Contants.PASSWORD);
         Statement stmt;
            try {
                System.out.println(" actualizar el equipo ");
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("UPDATE EQUIPO SET "
                        + "NOMBRE = '"+equipo.getNombre()+"', "
                        + "CATEGORIA = '"+equipo.getCategoria()+"', "
                        + "PROVINCIA = '"+equipo.getProvincia()+"' ,"
                        + "PUNTOS = '"+equipo.getPuntos()+"', "
                        + "ID_EQUIPO = '"+equipo.getId_equipo()+"' ");
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        return numTuplas1 > 0;
    }
}
