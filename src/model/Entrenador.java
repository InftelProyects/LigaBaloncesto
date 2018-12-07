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

     public Entrenador(String dni,String nombre, String apellido, String nivel,int id_equipo) {
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.nivel=nivel;
        this.id_equipo=id_equipo;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDni() {
        return dni;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
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
