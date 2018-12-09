package clases;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;

public class Persona {

    public SimpleStringProperty equipo = new SimpleStringProperty();
    public SimpleStringProperty vsequipo = new SimpleStringProperty();
    public SimpleStringProperty puntos = new SimpleStringProperty();
    public SimpleStringProperty fecha = new SimpleStringProperty();
    public SimpleStringProperty dni = new SimpleStringProperty();
    public SimpleStringProperty lugar = new SimpleStringProperty();
    public SimpleStringProperty roll = new SimpleStringProperty();

    public String getEquipo() {
        return equipo.get();
    }

    public SimpleStringProperty equipoProperty() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo.set(equipo);
    }

    public String getVsequipo() {
        return vsequipo.get();
    }

    public SimpleStringProperty vsequipoProperty() {
        return vsequipo;
    }

    public void setVsequipo(String vsequipo) {
        this.vsequipo.set(vsequipo);
    }

    public String getPuntos() {
        return puntos.get();
    }

    public SimpleStringProperty puntosProperty() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos.set(puntos);
    }

    public String getFecha() {
        return fecha.get();
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getDni() {
        return dni.get();
    }

    public SimpleStringProperty dniProperty() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni.set(dni);
    }

    public String getLugar() {
        return lugar.get();
    }

    public SimpleStringProperty lugarProperty() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar.set(lugar);
    }

    public String getRoll() {
        return roll.get();
    }

    public SimpleStringProperty rollProperty() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll.set(roll);
    }
}
