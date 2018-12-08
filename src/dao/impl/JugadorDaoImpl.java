/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IJugadorDao;
import db.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entrenador;
import model.Jugador;
import model.Persona;
import utils.Contants;

/**
 *
 * @author mohammed
 */
public class JugadorDaoImpl implements IJugadorDao{

    @Override
    public Jugador buscarPorDni(String dni) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM JUGADODR WHERE dni='"+dni+"'");
            while (resultado.next()) {
                double altura = resultado.getDouble("altura");
                double peso = resultado.getDouble("peso");
                int dorsal = resultado.getInt("dorsal");
                double id_equipo = resultado.getDouble("id_equipo");
                return new Jugador(altura,peso,id_equipo,dorsal);
            }
        } catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }
        return null;
        
    }

    @Override
    public List<Jugador> buscarTodos() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        
        List<Jugador> listaJugadores = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM JUGADOR");
            while (resultado.next()) {
                double altura = resultado.getDouble("altura");
                double peso = resultado.getDouble("peso");
                int dorsal = resultado.getInt("dorsal");
                double id_equipo = resultado.getDouble("id_equipo");
                Jugador jugador = new Jugador(altura, peso, id_equipo,dorsal);
                listaJugadores.add(jugador);
            }
        } catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }
        return listaJugadores;  
    }

    @Override
    public boolean insertarJugador(Jugador j) {
        int numTuplas1 = 0;
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection(
                Contants.URL, Contants.USERNAME, Contants.PASSWORD);
        j = buscarPorDni(j.getDni());
        if(j == null){
            System.out.println("No existe ninguma jugador "+j.getDni());
            Statement stmt;
            try {
                stmt = connection.createStatement();
                numTuplas1 = stmt.executeUpdate("INSERT INTO JUGADOR"
                        + "(ALTURA,PESO,ID_EQUIPO,DORSAL) "
                        + "VALUES "
                        + "('"+j.getAltura()+"','"+j.getPeso()+"','"+j.getId_equipo()+"''"+j.getDorsal()+" )");
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }else{
            System.out.println("el jugador con DNI"+j.getDni() +" ya existe ");
        }
        
        return  numTuplas1 > 0;
    }
    
    
}
