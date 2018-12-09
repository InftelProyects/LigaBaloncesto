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
public class Arbitro extends Persona{
    
    String provincia;

    public Arbitro(String nombre, String apellido,String provincia) {
        this.provincia = provincia;
        this.nombre= nombre;
        this.apellido=apellido;
    }

    public Arbitro() {
        
    }

    

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDni() {
        return dni;
    }

    /**
     *
     * @param dni
     */
    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     *
     * @return
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    @Override
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido
     */
    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre  +" "+ apellido + ", Provincia: " + provincia;
    }
    
    
    
}
