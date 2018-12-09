package model;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author inftel10
 */
public class Partido {
    
    private String fecha;
    private String localizacion;
    private int id_partido;
    private int resultado_local;
    private int resultado_visitante;
    private int jornada;
    private int ID_VISITANTE;
    private int ID_LOCAL;
    private String Nombre_VISITANTE;
    private String Nombre_LOCAL;

    public Partido(String fecha, String localizacion, int id_partido, int resultado_local, int resultado_visitante, int jornada, String Nombre_VISITANTE, String Nombre_LOCAL) {
        this.fecha = fecha;
        this.localizacion = localizacion;
        this.id_partido = id_partido;
        this.resultado_local = resultado_local;
        this.resultado_visitante = resultado_visitante;
        this.jornada = jornada;
        this.Nombre_VISITANTE = Nombre_VISITANTE;
        this.Nombre_LOCAL = Nombre_LOCAL;
    }

    @Override
    public String toString() {
        return Nombre_VISITANTE + " VS " + Nombre_LOCAL  + ", fecha=" + fecha + ", localizacion=" + localizacion + ", id_partido=" + id_partido + ", resultado_local=" + resultado_local + ", resultado_visitante=" + resultado_visitante + ", jornada=" + jornada + '}';
    }

    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public int getResultado_local() {
        return resultado_local;
    }

    public void setResultado_local(int resultado_local) {
        this.resultado_local = resultado_local;
    }

    public int getResultado_visitante() {
        return resultado_visitante;
    }

    public void setResultado_visitante(int resultado_visitante) {
        this.resultado_visitante = resultado_visitante;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getID_VISITANTE() {
        return ID_VISITANTE;
    }

    public void setID_VISITANTE(int ID_VISITANTE) {
        this.ID_VISITANTE = ID_VISITANTE;
    }

    public int getID_LOCAL() {
        return ID_LOCAL;
    }

    public void setID_LOCAL(int ID_LOCAL) {
        this.ID_LOCAL = ID_LOCAL;
    }

    public String getNombre_VISITANTE() {
        return Nombre_VISITANTE;
    }

    public void setNombre_VISITANTE(String Nombre_VISITANTE) {
        this.Nombre_VISITANTE = Nombre_VISITANTE;
    }

    public String getNombre_LOCAL() {
        return Nombre_LOCAL;
    }

    public void setNombre_LOCAL(String Nombre_LOCAL) {
        this.Nombre_LOCAL = Nombre_LOCAL;
    }

   
   

    
    
}
