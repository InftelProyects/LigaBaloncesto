package clases;

import javafx.beans.property.SimpleStringProperty;

public class equipo {

    public SimpleStringProperty nombre = new SimpleStringProperty();
    public SimpleStringProperty posicion = new SimpleStringProperty();
    public SimpleStringProperty aFavor = new SimpleStringProperty();
    public SimpleStringProperty enContra = new SimpleStringProperty();
    public SimpleStringProperty puntuacion = new SimpleStringProperty();

    public String getNombre() {
        return nombre.get();
    }
    public SimpleStringProperty nombreProperty() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getPosicion() {
        return posicion.get();
    }
    public SimpleStringProperty posicionProperty() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion.set(posicion);
    }

    public String getaFavor() {
        return aFavor.get();
    }
    public SimpleStringProperty aFavorProperty() {
        return aFavor;
    }
    public void setaFavor(String aFavor) {
        this.aFavor.set(aFavor);
    }

    public String getEnContra() {
        return enContra.get();
    }
    public SimpleStringProperty enContraProperty() {
        return enContra;
    }
    public void setEnContra(String enContra) {
        this.enContra.set(enContra);
    }

    public String getPuntuacion() {
        return puntuacion.get();
    }
    public SimpleStringProperty puntuacionProperty() {
        return puntuacion;
    }
    public void setPuntuacion(String puntuacion) {
        this.puntuacion.set(puntuacion);
    }
}
