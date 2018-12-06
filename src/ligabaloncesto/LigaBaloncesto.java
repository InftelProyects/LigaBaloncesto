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
import java.util.Scanner;
import static javafx.application.Platform.exit;
import model.Persona;
import oracle.net.aso.i;
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
        
//MENÚ PARA HACER PRUEBAS
        int opcion;
        Scanner reader = new Scanner(System.in);
        System.out.println ("Mostrar todo:1");
        System.out.println ("Buscar por DNI:2");
        System.out.println ("Añadir Persona:3");
        System.out.println ("Eliminar por DNI:4");
        System.out.println ("**METODOS SIN IMPLEMENTAR**");
       
        System.out.println ("***************************");
        System.out.println ("Salir:0");
        System.out.println ("Seleccione opcion: ");
        opcion = reader.nextInt();
       
        if(opcion==1){
           
           List<Persona> listaPersonas = personaDao.buscarTodos();
           System.out.println();
            for (int i=0; i<listaPersonas.size(); i++) {
                Persona persona = listaPersonas.get(i);
                System.out.println(persona.toString());
            }
        } 
        if(opcion==2){
            String dni;
            System.out.println("Introduzca dni");
            dni = reader.next();
            Persona personaPorDni = personaDao.buscarPorDni(dni);
            System.out.println("Persona buscada por dni: " + personaPorDni.toString());
        }
        if(opcion==3){
            Persona p = new Persona();
            System.out.println ("DNI: ");
                String temp= reader.next();
                p.setDni(temp);
            System.out.println ("Nombre: ");
                temp= reader.next();
                p.setNombre(temp);
            System.out.println ("Apellido: ");
                temp= reader.next();
                p.setApellido(temp);
            System.out.println ("Rol: ");
                temp= reader.next();
                p.setRol(temp);
            System.out.println ("Fecha de nacimiento: ");
                temp= reader.next();   
                p.setFech_nac(temp);
            System.out.println ("Telefono: ");
                temp= reader.next();
                p.setTelefono(temp);
            
            boolean personaInsertada = personaDao.insertarPersona(p);
            if (personaInsertada) {
                System.out.println("La persona ha sido insertada correctamente");
            }
        }
        if(opcion==4){
            String dni;
            System.out.println("Introduzca dni");
            dni = reader.next();
            boolean eliminarPorDni = personaDao.eliminarPorDni(dni);
            if(eliminarPorDni){
                 System.out.println("La persona ha sido borrada correctamente");
            }else{
                 System.out.println("La persona no ha sido borrada");
            }
        }
        
        if(opcion==0){
           
           exit();
        } 

        //personaDao.actualizarPersona(p2);
    }
    
}
