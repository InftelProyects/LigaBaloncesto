/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author mohammed
 */
public class Persona {
    private String dni;
    private String rol;
    private String telefono;
    private String fech_nac;
    public String nombre;
    public String apellido;

    public Persona() {
    }
    
    public Persona(String dni, String rol, String telefono, String fech_nac, String nombre, String apellido) {
        this.dni = dni;
        this.rol = rol;
        this.telefono = telefono;
        this.fech_nac = fech_nac;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre  +" "+ apellido + ", " + rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, rol, telefono, fech_nac, nombre, apellido);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!this.dni.equals(other.dni)) {
            return false;
        }
        if (!this.rol.equals(other.rol)) {
            return false;
        }
        if (!this.telefono.equals(other.telefono)) {
            return false;
        }
        if (!this.fech_nac.equals(other.fech_nac)) {
            return false;
        }
        if (!this.nombre.equals(other.nombre)) {
            return false;
        }
        if (!this.apellido.equals(other.apellido)) {
            return false;
        }
        return true;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFech_nac() {
        return fech_nac;
    }

    public void setFech_nac(String fech_nac) {
        this.fech_nac = fech_nac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
 
}

