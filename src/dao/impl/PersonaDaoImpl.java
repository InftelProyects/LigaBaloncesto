/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

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
import model.Persona;
import utils.Contants;

/**
 *
 * @author mohammed
 */
public class PersonaDaoImpl implements IPersonaDao{

    @Override
    public Persona buscarPorDni(String dniId) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PERSONA WHERE dni='"+dniId+"'");
            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String rol = resultado.getString("rol");
                String telefono = resultado.getString("telefono");
                String fechaNaci = resultado.getString("fecha_nacimiento");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellidos");
                return new Persona(dni, rol, telefono, fechaNaci, nombre, apellido);
            }
        } catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Persona> buscarTodos() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        List<Persona> listaPersonas = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PERSONA");
            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String rol = resultado.getString("rol");
                String telefono = resultado.getString("telefono");
                String fechaNaci = resultado.getString("fecha_nacimiento");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellidos");
                Persona persona = new Persona(dni, rol, telefono, fechaNaci, nombre, apellido);
                listaPersonas.add(persona);
            }
        } catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }
        return listaPersonas;
    }

    @Override
    public boolean insertarPersona(Persona p) {
        int numTuplas1 = 0;
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        Persona buscarPorDni = buscarPorDni(p.dni);
        if(buscarPorDni == null){
            System.out.println("No existe ninguma persona con DNI "+p.dni);
            Statement stmt;
            try {
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("INSERT INTO PERSONA "
                        + "(DNI,ROL,NOMBRE,APELLIDOS,TELEFONO,FECHA_NACIMIENTO) "
                        + "VALUES "
                        + "('"+p.getDni()+"','"+p.getRol()+"','"+p.getNombre()+"','"+p.getApellido()+"','"+p.getTelefono()
                        +"','"+p.getFech_nac()+"')");
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }else{
            System.out.println("la persona con DNI "+p.dni +" ya existe ");
        }
        
        return numTuplas1 > 0;
    }

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
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        return numTuplas1 > 0;
    }
    
    
}
