/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mohammed
 */
public class Equipo {
    private String categoria;
    private String nombre;
    private String provincia;
    private int id_equipo;
    private int puntos;

    public Equipo(String categoria, String nombre, String provincia, int id_equipo, int puntos) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.provincia = provincia;
        this.id_equipo = id_equipo;
        this.puntos = puntos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", puntos=" + puntos + '}';
    }
}
