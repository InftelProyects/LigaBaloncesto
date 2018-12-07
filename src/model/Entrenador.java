/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author josep
 */
public class Entrenador extends Persona{
    String nivel;
    int id_equipo;
    private String nombre_equipo;
   // String equipo;
    public Entrenador(String nivel, int id_equipo) {
        this.nivel = nivel;
        this.id_equipo = id_equipo;
    }

    public Entrenador() {
    }

    public Entrenador(String dni, String rol, String telefono, String fech_nac, String nombre, String apellido) {
        super(dni, rol, telefono, fech_nac, nombre, apellido);
    }

    public Entrenador(String nombre, String apellido, String nivel,String nombre_equipo) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.nivel=nivel;
        this.nombre_equipo=nombre_equipo;
    }
    
    public Entrenador(String nombre) {
        this.nombre=nombre;
    }

    @Override
    public String toString() {
        return nombre  +" "+ apellido + ", Equipo: " + nombre_equipo + ",nivel: "+nivel;
    }

    
    
    
    
}
