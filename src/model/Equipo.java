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
    private char categoria;
    private char nombre;
    private char provincia;
    private int id_equipo;
    private int puntos;

    public Equipo(char categoria, char nombre, char provincia, int id_equipo, int puntos) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.provincia = provincia;
        this.id_equipo = id_equipo;
        this.puntos = puntos;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public char getProvincia() {
        return provincia;
    }

    public void setProvincia(char provincia) {
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
