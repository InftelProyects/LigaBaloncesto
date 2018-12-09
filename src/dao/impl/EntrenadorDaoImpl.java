/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IEntrenadorDao;
import dao.IPersonaDao;
import dao.impl.PersonaDaoImpl;
import db.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import model.Entrenador;
import model.Persona;
import utils.Contants;

/**
 *
 * @author josep
 */



public class EntrenadorDaoImpl implements IEntrenadorDao{

    @Override
    public Entrenador buscarPorDni(String dniId) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT persona.nombre,persona.apellidos,entrenador.nivel,equipo.nombre_equipo FROM ENTRENADOR,PERSONA,EQUIPO WHERE entrenador.dni='"+dniId+"' AND entrenador.dni=persona.dni AND entrenador.id_equipo=equipo.id_equipo");
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                String nivel = resultado.getString("nivel");
                String nombre_equipo = resultado.getString("nombre_equipo");

                return new Entrenador(nombre,apellidos,nivel,nombre_equipo);
            }
        } catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Entrenador> buscarTodos() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        List<Entrenador> listaEntrenadores = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT persona.nombre,persona.apellidos,entrenador.nivel,equipo.nombre_equipo FROM ENTRENADOR,PERSONA,EQUIPO WHERE entrenador.dni=persona.dni AND entrenador.id_equipo=equipo.id_equipo");
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                String nivel = resultado.getString("nivel");
                String nombre_equipo = resultado.getString("nombre_equipo");
                
                Entrenador entrenador = new Entrenador(nombre,apellidos,nivel,nombre_equipo);
                listaEntrenadores.add(entrenador);
            }
        } catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }
        return listaEntrenadores;
    }
    @Override
    public boolean insertarEntrenador(Entrenador e) {
        int numTuplas1 = 0;
        Persona p;
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        //Persona buscarPorDni = IPersonaDao.buscarPorDni(e.getDni());
        /*if(buscarPorDni == null){
            
           System.out.println("El entrenador con DNI "+e.getDni() +" no existe ");
            
        }else{
            
            System.out.println("El entrenador con DNI "+e.getDni() +" existe ");*/
            Statement stmt;
            try {
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("INSERT INTO ENTRENADOR "
                        + "(DNI,NIVEL,EQUIPO_ID_EQUIPO,) "
                        + "VALUES "
                        + "('"+e.getDni()+"','"+e.getNivel()+"','"+e.getId_equipo()+"')");
            } catch (SQLException ex) {
                //Logger.getLogger(EntrenadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("La persona no existe");
                exit();
            }
           
        //}
        
        return numTuplas1 > 0;
    }

    @Override
    public boolean eliminarPorDniEntrenador(String dni) {
         int numTuplas1 = 0;
         DatabaseConnector databaseConnector = new DatabaseConnector();
         Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
         
            System.out.println("Borrar entrenador por DNI "+dni);
            Statement stmt;
            try {
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("DELETE FROM ENTRENADOR WHERE DNI ='"+dni+"'");
                        
                       
            } catch (SQLException ex) {
                Logger.getLogger(EntrenadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
           return numTuplas1 > 0;
    }
    
    @Override
    public boolean actualizarEntrenador(Entrenador e) {
         int numTuplas1 = 0;
         DatabaseConnector databaseConnector = new DatabaseConnector();
         Connection connection = databaseConnector.getConnection(
                 Contants.URL, Contants.USERNAME, Contants.PASSWORD);
         Statement stmt;
            try {
                System.out.println(" actualizar el entrenador con dni ");
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("UPDATE ENTRENADOR SET "
                        + "NIVEL = '"+e.getNivel()+"' "
                        + "WHERE DNI =  '"+e.getDni()+"'");
            } catch (SQLException ex) {
                Logger.getLogger(EntrenadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        return numTuplas1 > 0;
    }
}
