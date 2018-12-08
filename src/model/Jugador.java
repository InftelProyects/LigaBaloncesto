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
public class Jugador extends Persona{
    double altura,peso,id_equipo;
    int dorsal;
    public Jugador(){
    };
    public Jugador(double altura, double peso, double id_equipo, int dorsal) {
        this.altura = altura;
        this.peso = peso;
        this.id_equipo = id_equipo;
        this.dorsal = dorsal;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public double getId_equipo() {
        return id_equipo;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setId_equipo(double id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.id_equipo) ^ (Double.doubleToLongBits(this.id_equipo) >>> 32));
        hash = 59 * hash + this.dorsal;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (Double.doubleToLongBits(this.altura) != Double.doubleToLongBits(other.altura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.id_equipo) != Double.doubleToLongBits(other.id_equipo)) {
            return false;
        }
        if (this.dorsal != other.dorsal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jugador{" + "altura=" + altura + ", peso=" + peso + ", id_equipo=" + id_equipo + ", dorsal=" + dorsal + '}';
    }

    
}
