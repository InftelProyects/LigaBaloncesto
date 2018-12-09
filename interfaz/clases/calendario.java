package clases;
import javafx.beans.property.SimpleStringProperty;

public class calendario {

    public SimpleStringProperty fecha = new SimpleStringProperty();
    public SimpleStringProperty hora = new SimpleStringProperty();
    public SimpleStringProperty lugar = new SimpleStringProperty();
    public SimpleStringProperty equipo = new SimpleStringProperty();
    public SimpleStringProperty vsequipo = new SimpleStringProperty();

    public SimpleStringProperty fechaProperty() { return fecha; }
    public void setFecha(String fecha) { this.fecha.set(fecha); }

    public String getHora() { return hora.get();}
    public SimpleStringProperty horaProperty() { return hora; }
    public void setHora(String hora) { this.hora.set(hora); }

    public String getLugar() {
        return lugar.get();
    }
    public SimpleStringProperty lugarProperty() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar.set(lugar);
    }

    public String getEquipo() {
        return equipo.get();
    }
    public SimpleStringProperty equipoProperty() {
        return equipo;
    }
    public void setEquipo(String equipo) { this.equipo.set(equipo); }

    public String getVsequipo() {
        return vsequipo.get();
    }
    public SimpleStringProperty vsequipoProperty() {
        return vsequipo;
    }
    public void setVsequipo(String vsequipo) {
        this.vsequipo.set(vsequipo);
    }
}
