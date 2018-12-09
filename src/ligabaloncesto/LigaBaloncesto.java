/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligabaloncesto;

import dao.IPersonaDao;
import dao.impl.PersonaDaoImpl;
import dao.IEntrenadorDao;
import dao.impl.EntrenadorDaoImpl;
import dao.IEquipoDao;
import dao.impl.EquipoDaoImpl;
import dao.IArbitroDao;
import dao.IJugadorDao;
import dao.IPartidoDao;
import dao.impl.ArbitroDaoImpl;
import dao.impl.JugadorDaoImpl;
import dao.impl.PartidoDaoImpl;
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
import model.Entrenador;
import model.Partido;
import model.Persona;
import model.Equipo;
import model.Arbitro;
import model.Jugador;
//import oracle.net.aso.i;
import utils.Contants;
import utils.GeneradorEmparejamiento;

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
        IEntrenadorDao entrenadorDao = new EntrenadorDaoImpl();
        IEquipoDao equipoDao = new EquipoDaoImpl();
        IArbitroDao arbitroDao = new ArbitroDaoImpl();
        IJugadorDao jugadorDao = new JugadorDaoImpl();
        IPartidoDao partidoDao = new PartidoDaoImpl();
        
//MENÚ PARA HACER PRUEBAS
        int opcion;
        Scanner reader = new Scanner(System.in);
        System.out.println ("Mostrar personas:1");
        System.out.println ("Buscar por DNI:2");
        System.out.println ("Añadir Persona:3");
        System.out.println ("Eliminar por DNI:4");
        System.out.println ("Crear emparejamientos:5");
        System.out.println ("Añadir equipo: 6");
        System.out.println ("Eliminar equipo por nombre: 7");   
        System.out.println ("Añadir entrenador: 8"); //Debe existir el equipo
        System.out.println ("Mostrar entrenadores:9");
        System.out.println ("Buscar entrenador DNI:10");
        System.out.println ("Buscar arbitro DNI:11");
        System.out.println ("Mostrar arbitros:12");
        System.out.println ("Añadir arbitro:13 ");
        System.out.println ("Añadir jugador:14");
        System.out.println ("Buscar Equipo:15");
        System.out.println ("Mostrar entrenadores:16");
        System.out.println ("Mostrar partidos:17");
      //System.out.println ("Crear Liga: "); //Se selccionan los equipos y se crean las jornadas con round roubin
        System.out.println ("Mostrar clasificacion:18");
        System.out.println ("Añadir resultados partidos:19 ");
        System.out.println ("Mostrar partido por ID:20");
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
        
        if(opcion==5){
            
            System.out.println("Generando emparejamientos");
            GeneradorEmparejamiento emparejamiento = new GeneradorEmparejamiento();
            List<List<Partido>> jornadas = emparejamiento.genararEmparejamientos();
            int idPartido = 1;
            for (int numJornada=0; numJornada< jornadas.size(); numJornada++){
                for (int numPartido=0; numPartido<jornadas.get(numJornada).size(); numPartido++) {
                    Partido partido = jornadas.get(numJornada).get(numPartido);
                    partido.setJornada(numJornada+1);
                    partido.setId_partido(idPartido);
                    idPartido++;
                }
            }
        }
        if(opcion==6){
            Equipo equipo = new Equipo();
            System.out.println ("Nombre: ");
                String temp= reader.next();
                equipo.setNombre(temp);
            System.out.println ("Categoria: ");
                temp= reader.next();
                equipo.setCategoria(temp);
            System.out.println ("Provincia: ");
                temp= reader.next();
                equipo.setProvincia(temp);    
            //equipo.setId_equipo(5);
            equipo.setPuntos(0);
             
            boolean insertarEquipo = equipoDao.insertarEquipo(equipo);
            if (insertarEquipo) {
                System.out.println("El equipo ha sido insertado correctamente");
            }
        }
        if(opcion==7){
            String nombre;
            System.out.println("Introduzca nombre de equipo");
            nombre = reader.next();
            
            boolean eliminarPorNombreEquipo = equipoDao.eliminarPorNombreEquipo(nombre);
            if(eliminarPorNombreEquipo){
                 System.out.println("El equipo ha sido borrado correctamente");
            }else{
                 System.out.println("El equipo no ha sido borrado");
            }
        }
        
        if(opcion==8){
            Entrenador e = new Entrenador();
            System.out.println ("DNI: ");
                String temp= reader.next();
                e.setDni(temp);
            System.out.println ("Nivel: ");
                temp= reader.next();
                e.setNivel(temp);
            System.out.println ("ID_equipo: ");
                int temp2= reader.nextInt();
                e.setId_equipo(temp2);
                
            boolean entrenadorInsertado = entrenadorDao.insertarEntrenador(e);
            if (entrenadorInsertado) {
                System.out.println("El entrenador ha sido insertada correctamente");
            }
        }

        
        if(opcion==9){
           
           List<Entrenador> listaEntrenadores = entrenadorDao.buscarTodos();
           System.out.println();
            for (int i=0; i<listaEntrenadores.size(); i++) {
                Entrenador entrenador = listaEntrenadores.get(i);
                System.out.println(entrenador.toString());
            }
        } 
        if(opcion==16){
           
           List<Equipo> listaDeEquipos = equipoDao.buscarTodos();
           System.out.println();
            for (int i=0; i<listaDeEquipos.size(); i++) {
                Equipo equipo = listaDeEquipos.get(i);
                System.out.println(equipo.toString());
            }
        }
        
        if(opcion==17){
           
           List<Partido> listaDePartidos = partidoDao.BuscarTodosLospartidos();
           System.out.println();
            for (int i=0; i<listaDePartidos.size(); i++) {
               Partido partido = listaDePartidos.get(i);
                System.out.println(partido.toString());
            }
        }
        
        if(opcion==18){
           
           List<Equipo> listaEquipos = equipoDao.MostrarClasificacion();
           System.out.println();
           System.out.println("La clasificacion de los equipos en la liga es la siguiente:");
           System.out.println();
            for (int i=0; i<listaEquipos.size(); i++) {
                Equipo equipo = listaEquipos.get(i);               
                System.out.println(equipo.toString2());
            }
        }
        
        if(opcion==19){
            Partido partido  = new Partido();
            System.out.println ("ID: ");
                int id= reader.nextInt();
                Partido PartidoPorID = partidoDao.BuscarPorIdPartido(id);
                System.out.println();
                System.out.println(PartidoPorID.toString2());
                System.out.println();
                partido.setId_partido(id);
            System.out.println ("Resultado Visitante: ");
                int temp= reader.nextInt();
                partido.setResultado_visitante(temp);
            System.out.println ("Resultado Local: ");
                temp= reader.nextInt();
                partido.setResultado_local(temp);    
    
            boolean insertarResultados = partidoDao.insertarResultadosPartidos(partido);
            if (insertarResultados) {
                System.out.println("Resultados insertados");
            }
        }
        if(opcion==20){
            int id;
            System.out.println("Introduzca ID del partido");
            id = reader.nextInt();
            Partido PartidoPorID = partidoDao.BuscarPorIdPartido(id);
            System.out.println(PartidoPorID.toString());
        }
        
        if(opcion==10){
            String dni;
            System.out.println("Introduzca dni");
            dni = reader.next();
            Entrenador entrenadorPorDni = entrenadorDao.buscarPorDni(dni);
            System.out.println("Entrenador buscado por dni: " + entrenadorPorDni.toString());
        }
        
        if(opcion==11){
            String dni;
            System.out.println("Introduzca dni");
            dni = reader.next();
            Arbitro arbitroPorDni = arbitroDao.buscarPorDni(dni);
            System.out.println("Arbitro buscado por dni: " + arbitroPorDni.toString());
        } 
        
        if(opcion==15){
            String nombre_e;
            System.out.println("Introduzca nombre del equipo: ");
            nombre_e = reader.next();
            Equipo equipoPorNombre = equipoDao.buscarPorNombreEquipo(nombre_e);
            System.out.println("Equipo: " + equipoPorNombre.toString());
        } 
        
        
        if(opcion==12){
           List<Arbitro> listaArbitros = arbitroDao.buscarTodos();
           System.out.println();
            for (int i=0; i<listaArbitros.size(); i++) {
                Arbitro arbitro = listaArbitros.get(i);
                System.out.println(arbitro.toString());
            }
        } 
        
        if(opcion==13){
            Arbitro a = new Arbitro();
            System.out.println ("DNI: ");
                String temp= reader.next();
                a.setDni(temp);
            System.out.println ("Provincia: ");
                temp= reader.next();
                a.setProvincia(temp);
                
            boolean arbitroInsertado = arbitroDao.insertarArbitro(a);
            if (arbitroInsertado) {
                System.out.println("El arbitro ha sido insertado correctamente");
            }
        }
        
        if(opcion==14){
            Jugador j = new Jugador();
            System.out.println ("DNI: ");
                String temp= reader.next();
                j.setDni(temp);
            System.out.println ("Dorsal: ");
               int temp2 = reader.nextInt();
                j.setDorsal(temp2);
            System.out.println ("Altura: ");
               int  temp3 = reader.nextInt();
                j.setAltura(temp3);
            boolean insertarjugador = jugadorDao.insertarJugador(j);
            if(insertarjugador){
                System.out.println("El jugador  ha sido insertado correctamente");
            }
        }    
        
        if(opcion==0){
           
           exit();
        } 

        //personaDao.actualizarPersona(p2);
    }
    
}
