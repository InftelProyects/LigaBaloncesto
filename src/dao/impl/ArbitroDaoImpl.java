/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IArbitroDao;
import dao.IPersonaDao;
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
import model.Arbitro;
import model.Entrenador;
import model.Persona;
import utils.Contants;

/**
 *
 * @author josep
 */



public class ArbitroDaoImpl implements IArbitroDao{

    @Override
    public Arbitro buscarPorDni(String dniId) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT persona.nombre,persona.apellidos,arbitro.provincia FROM PERSONA,ARBITRO WHERE arbitro.dni=persona.dni AND arbitro.dni='"+dniId+"'");
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                String provincia = resultado.getString("provincia");

                return new Arbitro(nombre,apellidos,provincia);
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
    public List<Arbitro> buscarTodos() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        List<Arbitro> listaArbitros = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT persona.nombre,persona.apellidos,arbitro.provincia FROM PERSONA,ARBITRO WHERE arbitro.dni=persona.dni");
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                String provincia = resultado.getString("provincia");
                
                Arbitro arbitro = new Arbitro(nombre,apellidos,provincia);
                listaArbitros.add(arbitro);
            }
        } catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }
        return listaArbitros;
    } 

  
    @Override
    public boolean insertarArbitro(Arbitro a) {
        int numTuplas1 = 0;
        //Persona p;
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        //Persona buscarPorDni = IPersonaDao.buscarPorDni(e.getDni());
        /*if(buscarPorDni == null){
            
           System.out.println("El entrenador con DNI "+e.getDni() +" no existe ");
            
        }else{*/
            
            //System.out.println("El arbitro con DNI "+a.getDni() +" existe ");
            Statement stmt;
            try {
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("INSERT INTO ARBITRO "
                        + "(DNI,PROVINCIA) "
                        + "VALUES "
                        + "('"+a.getDni()+"','"+a.getProvincia()+"')");
            } catch (SQLException ex) {
                //Logger.getLogger(EntrenadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("El arbitro no existe");
                exit();
            }
           
        //}
        
        return numTuplas1 > 0;
    }

 /*
    @Override
    public boolean eliminarPorDni(String dni) {
         int numTuplas1 = 0;
         DatabaseConnector databaseConnector = new DatabaseConnector();
         Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
         
            System.out.println("Borrar Persona por DNI "+dni);
            Statement stmt;
            try {
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("DELETE FROM PERSONA  WHERE DNI ='"+dni+"'");
                        
                       
            } catch (SQLException ex) {
                Logger.getLogger(EntrenadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
           return numTuplas1 > 0;
            
         
    }

    @Override
    public boolean actualizarPersona(Persona p) {
         int numTuplas1 = 0;
         DatabaseConnector databaseConnector = new DatabaseConnector();
         Connection connection = databaseConnector.getConnection(
                 Contants.URL, Contants.USERNAME, Contants.PASSWORD);
         Statement stmt;
            try {
                System.out.println(" actualizar la persona con dni ");
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("UPDATE PERSONA SET "
                        + "NOMBRE = '"+p.getNombre()+"', "
                        + "APELLIDOS = '"+p.getApellido()+"', "
                        + "ROL = '"+p.getRol()+"' ,"
                        + "fecha_nacimiento = '"+p.getFech_nac()+"', "
                        + "telefono = '"+p.getTelefono()+"' "
                        + "WHERE DNI =  '"+p.getDni()+"'");
            } catch (SQLException ex) {
                Logger.getLogger(EntrenadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        return numTuplas1 > 0;
    }
    
    */
}
