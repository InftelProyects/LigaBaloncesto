/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligabaloncesto;

import dao.IPersonaDao;
import dao.impl.PersonaDaoImpl;
import db.DatabaseConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Persona;
import utils.Contants;

/**
 *
 * @author mohammed
 */
public class LigaBaloncesto {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //conection a base de datos  (https://www.mkyong.com/jdbc/connect-to-oracle-db-via-jdbc-driver-java/)
        IPersonaDao personaDao = new PersonaDaoImpl();
        List<Persona> listaPersonas = personaDao.buscarTodos();
        System.out.println();
        for (int i=0; i<listaPersonas.size(); i++) {
            Persona persona = listaPersonas.get(i);
            System.out.println(persona.toString());
        }
        
        Persona personaPorDni = personaDao.buscarPorDni("222");
        System.out.println("Persona buscada por dni: " + personaPorDni.toString());
        
        Persona p = new Persona();
        p.setDni("66666");
        p.setApellido("el hodifi");
        p.setNombre("mohammed");
        p.setRol("entrendaor");
        p.setFech_nac("1988");
        p.setTelefono("888888");
        boolean personaInsertada = personaDao.insertarPersona(p);
        if (personaInsertada) {
            System.out.println("La persona ha sido insertada correctamente");
        }
        
        
        boolean eliminarPorDni = personaDao.eliminarPorDni("66666");
        if(eliminarPorDni){
             System.out.println("La persona ha sido borrada correctamente");
        }else{
             System.out.println("La persona no ha sido borrada");
        }
        
        Persona p2 = new Persona();
        p2.setDni("66666");
        p2.setApellido("el hodifi");
        p2.setNombre("mohammed");
        p2.setRol("entrendaor");
        p2.setFech_nac("1988");
        p2.setTelefono("888888");
        
        personaDao.actualizarPersona(p2);
    }
    
}
