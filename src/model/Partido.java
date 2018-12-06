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
    private int resultado;
    private int jornada;
    private int ID_VISITANTE;
    private int ID_LOCAL;

    @Override
    public String toString() {
        return "Partido{" + "fecha=" + fecha + ", resultado=" + resultado + ", ID_VISITANTE=" + ID_VISITANTE + ", ID_LOCAL=" + ID_LOCAL + '}';
    }

    public Partido(String fecha, String localizacion, int id_partido, int resultado, int jornada, int ID_VISITANTE, int ID_LOCAL) {
        this.fecha = fecha;
        this.localizacion = localizacion;
        this.id_partido = id_partido;
        this.resultado = resultado;
        this.jornada = jornada;
        this.ID_VISITANTE = ID_VISITANTE;
        this.ID_LOCAL = ID_LOCAL;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Objects.hashCode(this.localizacion);
        hash = 37 * hash + this.id_partido;
        hash = 37 * hash + this.resultado;
        hash = 37 * hash + this.jornada;
        hash = 37 * hash + this.ID_VISITANTE;
        hash = 37 * hash + this.ID_LOCAL;
        return hash;
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
        final Partido other = (Partido) obj;
        if (this.id_partido != other.id_partido) {
            return false;
        }
        if (this.resultado != other.resultado) {
            return false;
        }
        if (this.jornada != other.jornada) {
            return false;
        }
        if (this.ID_VISITANTE != other.ID_VISITANTE) {
            return false;
        }
        if (this.ID_LOCAL != other.ID_LOCAL) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.localizacion, other.localizacion)) {
            return false;
        }
        return true;
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

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
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
    

    
    public int resultados(){ //Calcula el resultado del partido segun los puntos de cda equipo
        return 0;
        
    }
   

    
    
}
