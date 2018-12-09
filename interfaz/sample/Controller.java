package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import clases.partido;
import clases.calendario;
import clases.equipo;
import clases.Persona;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import dao.impl.*;
import model.Partido;


public class Controller implements Initializable {

    // Flechas indicadoras de Paneles
    @FXML private ImageView arrowBallon;
    @FXML private ImageView arrowCalendar;
    @FXML private ImageView arrowShirt;
    @FXML private ImageView arrowCamp;
    @FXML private ImageView arrowPlayer;
    // Paneles de la aplicación
    @FXML private AnchorPane ballonPanel;
    @FXML private AnchorPane calendarPanel;
    @FXML private AnchorPane shirtPanel;
    @FXML private AnchorPane campPanel;
    @FXML private AnchorPane playerPanel;
    //Tabla del panel calendario
    @FXML private TableView<calendario> calendarTable;
    @FXML private TableColumn calenFecha;
    @FXML private TableColumn calenHora;
    @FXML private TableColumn calenLugar;
    @FXML private TableColumn calenEquipo;
    @FXML private TableColumn calenVsequipo;
    @FXML private TableColumn calenPunt;
    ObservableList<calendario> insertdate;
    //Tabla del panel equipos
    @FXML private TableView<equipo> equipoTable;
    @FXML private TableColumn nombEquipo;
    @FXML private TableColumn posEquipo;
    @FXML private TableColumn aFavEquipo;
    @FXML private TableColumn enContEquipo;
    @FXML private TableColumn puntosEquipo;
    ObservableList<equipo> insertequip;
    @FXML public ComboBox <String> selectEquipo;
    ObservableList<String> selecequip ;
    //Tablas del panel partidos
    @FXML private TableView<partido> ppasados;
    @FXML private TableColumn equipoPas;
    @FXML private TableColumn vsequipoPas;
    @FXML private TableColumn puntosPas;
    @FXML private TableColumn fechaPas;
    @FXML private TableColumn horaPas;
    @FXML private TableColumn lugarPas;
    ObservableList<partido> insertppas;
    @FXML private TableView<partido> ppendientes;
    @FXML private TableColumn equipoPen;
    @FXML private TableColumn vsequipoPen;
    @FXML private TableColumn fechaPen;
    @FXML private TableColumn horaPen;
    @FXML private TableColumn lugarPen;
    ObservableList<partido> insertppen;
    @FXML private DatePicker fechahoy;
    //Tablas del panel Player
    @FXML private TableView<Persona> dniTable;
    @FXML private TableColumn rolDni;
    @FXML private TableColumn fechaDni;
    @FXML private TableColumn lugarDni;
    @FXML private TableColumn equipoDni;
    @FXML private TableColumn vsequipoDni;
    @FXML private TableColumn puntDni;
    ObservableList<Persona> insertdni;
    @FXML private TextField dniInser;

    // Asignar al Boton X salir de la app.
    public void onExitButtonClicked (MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }
    // Funcion para aplicar cuando click en la imagen de la pelota
    public void onBallButtonClicked (MouseEvent event) {

        ballonPanel.setVisible(true);
        arrowBallon.setVisible(true);
        calendarPanel.setVisible(false);
        arrowCalendar.setVisible(false);
        shirtPanel.setVisible(false);
        arrowShirt.setVisible(false);
        campPanel.setVisible(false);
        arrowCamp.setVisible(false);
        playerPanel.setVisible(false);
        arrowPlayer.setVisible(false);

    }
    // Funcion para aplicar cuando click en la imagen del calendario
    public void onCalendarButtonClicked (MouseEvent event) {

        ballonPanel.setVisible(false);
        arrowBallon.setVisible(false);
        calendarPanel.setVisible(true);
        arrowCalendar.setVisible(true);
        shirtPanel.setVisible(false);
        arrowShirt.setVisible(false);
        campPanel.setVisible(false);
        arrowCamp.setVisible(false);
        playerPanel.setVisible(false);
        arrowPlayer.setVisible(false);
    }
    // Funcion para aplicar cuando click en la imagen de la camiseta
    public void onShirtButtonClicked (MouseEvent event) {
        ballonPanel.setVisible(false);
        arrowBallon.setVisible(false);
        calendarPanel.setVisible(false);
        arrowCalendar.setVisible(false);
        shirtPanel.setVisible(true);
        arrowShirt.setVisible(true);
        campPanel.setVisible(false);
        arrowCamp.setVisible(false);
        playerPanel.setVisible(false);
        arrowPlayer.setVisible(false);
    }
    // Funcion para aplicar cuando click en la imagen del campo
    public void onCampButtonClicked (MouseEvent event) {

        ballonPanel.setVisible(false);
        arrowBallon.setVisible(false);
        calendarPanel.setVisible(false);
        arrowCalendar.setVisible(false);
        shirtPanel.setVisible(false);
        arrowShirt.setVisible(false);
        campPanel.setVisible(true);
        arrowCamp.setVisible(true);
        playerPanel.setVisible(false);
        arrowPlayer.setVisible(false);
    }
    // Funcion para aplicar cuando click en la imagen de la jugador
    public void onPlayerButtonClicked (MouseEvent event) {

        ballonPanel.setVisible(false);
        arrowBallon.setVisible(false);
        calendarPanel.setVisible(false);
        arrowCalendar.setVisible(false);
        shirtPanel.setVisible(false);
        arrowShirt.setVisible(false);
        campPanel.setVisible(false);
        arrowCamp.setVisible(false);
        playerPanel.setVisible(true);
        arrowPlayer.setVisible(true);
    }
    // Funcion para inicializar la tabla de calendario de partidos
    private void inicializarTablaCalendar(){

        //Buscar e insertar en las columnas valores de los atributos la clase Calendario
        calenFecha.setCellValueFactory(new PropertyValueFactory<calendario,String>("fecha"));
        calenHora.setCellValueFactory(new PropertyValueFactory<calendario,String>("hora"));
        calenLugar.setCellValueFactory(new PropertyValueFactory<calendario,String>("lugar"));
        calenEquipo.setCellValueFactory(new PropertyValueFactory<calendario,String>("equipo"));
        calenVsequipo.setCellValueFactory(new PropertyValueFactory<calendario,String>("vsequipo"));
        // Insertar los valores anteriores en la tabla CalendarTable
        insertdate=FXCollections.observableArrayList();
        calendarTable.setItems(insertdate);
        // Para visualizar datos en la tabla
        LocalDateTime [] fecha = {LocalDateTime.of(2018,12,07,10,30,0,0),LocalDateTime.of(2018,12,07,11,00),LocalDateTime.of(2018,12,8,15,30),LocalDateTime.of(2018,12,8,20,30),LocalDateTime.of(2018,12,9,19,20),LocalDateTime.of(2018,12,9,14,00),LocalDateTime.of(2018,12,10,16,25),LocalDateTime.of(2018,12,11,17,35),LocalDateTime.of(2018,12,12,15,30),LocalDateTime.of(2018,12,13,15,50)};
        String [] lugar = {"Málaga","Torremolinos","Fuengirola","Benalmádena","Arroyo de la miel","Campanillas","Malaga","Malaga", "Estepona", "Algeciras"};
        String [] equipo = {"MalagaCity","Torremolinos","FuengirolaBasket","BenalBas","Arroyo de la miel","Campanillas","MalagaCity","MalagaCity","EsteBasket","Algeciras"};
        String [] vsequipo = {"Algeciras","MalagaCity","EsteBasket","Torremolinos","FuengirolaBasket","Arroyo de la miel","Campanillas","MalagaCity","BenalBas","MalagaCity"};
        LocalDateTime hoy = LocalDateTime.now();
        for (int i = 0; i < equipo.length; i++) {
            if ((hoy).compareTo(fecha[i])<=0) {
                calendario c1 = new calendario();
                c1.fecha.set(fecha[i].getYear()+"-"+fecha[i].getMonthValue()+"-"+fecha[i].getDayOfMonth());
                c1.hora.set(fecha[i].getHour()+":"+fecha[i].getMinute());
                c1.lugar.set(lugar[i]);
                c1.equipo.set(equipo[i]);
                c1.vsequipo.set(vsequipo[i]);
                insertdate.add(c1);
            }
        }
    }
    // Funcion para inicializar la tabla de equipos
    private void inicializarTablaEquipo(){

        //Buscar e insertar en las columnas valores de los atributos la clase Equipo
        nombEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("nombre"));
        posEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("posicion"));
        aFavEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("aFavor"));
        enContEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("enContra"));
        puntosEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("puntuacion"));
        // Insertar los valores anteriores en la tabla EquipoTable
        insertequip=FXCollections.observableArrayList();
        equipoTable.setItems(insertequip);
        // Para visualizar datos en la tabla
        String [] equipo = {"MalagaCity","Torremolinos","FuengirolaBasket","BenalBas","Arroyo de la miel","Campanillas","EsteBasket","Algeciras"};
        String [] posicion = {  "1º",           "6º",           "2º",           "3º",           "5º",           "4º",       "7º",       "8º"};
        String [] aFa = {       "7",            "0",            "5",            "7",            "9",            "5",        "0",        "1"};
        String [] aCon = {      "1",            "0",            "0",            "5",            "9",            "4",        "9",        "0"};
        String [] puntos = {    "6",            "0",            "5",            "2",            "0",            "1",        "0",        "1"};
        for (int i = 0; i < equipo.length; i++) {
            equipo e1 = new equipo();
            e1.nombre.set(equipo[i]);
            e1.posicion.set(posicion[i]);
            e1.aFavor.set(aFa[i]);
            e1.enContra.set(aCon[i]);
            e1.puntuacion.set(puntos[i]);
            insertequip.add(e1);
        }
        // Para visualizar datos en el comboBox
        selecequip=FXCollections.observableArrayList("MalagaCity","Torremolinos","FuengirolaBasket","BenalBas","Arroyo de la miel","Campanillas","EsteBasket","Algeciras");
        selectEquipo.setItems(selecequip);

    }
    // Buscar un equipo
    public void seleccionarEquipo (MouseEvent event){

        //Buscar e insertar en las columnas valores de los atributos la clase Equipo
        nombEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("nombre"));
        posEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("posicion"));
        aFavEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("aFavor"));
        enContEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("enContra"));
        puntosEquipo.setCellValueFactory(new PropertyValueFactory<equipo,String>("puntuacion"));
        // Insertar los valores anteriores en la tabla EquipoTable
        insertequip=FXCollections.observableArrayList();
        equipoTable.setItems(insertequip);
        // Para visualizar datos en la tabla
        String [] equipo = {"MalagaCity","Torremolinos","FuengirolaBasket","BenalBas","Arroyo de la miel","Campanillas","EsteBasket","Algeciras"};
        String [] posicion = {  "1º",           "6º",           "2º",           "3º",           "5º",           "4º",       "7º",       "8º"};
        String [] aFa = {       "7",            "0",            "5",            "7",            "9",            "5",        "0",        "1"};
        String [] aCon = {      "1",            "0",            "0",            "5",            "9",            "4",        "9",        "0"};
        String [] puntos = {    "6",            "0",            "5",            "2",            "0",            "1",        "0",        "1"};

        for(int i=0;i<equipo.length;i++){
            if (selectEquipo.getSelectionModel().getSelectedItem().equals(equipo[i])){
                equipo e1 = new equipo();
                e1.nombre.set(equipo[i]);
                e1.posicion.set(posicion[i]);
                e1.aFavor.set(aFa[i]);
                e1.enContra.set(aCon[i]);
                e1.puntuacion.set(puntos[i]);
                insertequip.add(e1);
            }
        }
    }
    // Funciones para inicializar las tablas de partidos
    private void inicializarTablapPen(){
        //Buscar e insertar en las columnas valores de los atributos la clase Partido
        equipoPen.setCellValueFactory(new PropertyValueFactory<partido,String>("equipo"));
        vsequipoPen.setCellValueFactory(new PropertyValueFactory<partido,String>("vsequipo"));
        fechaPen.setCellValueFactory(new PropertyValueFactory<partido,String>("fecha"));
        horaPen.setCellValueFactory(new PropertyValueFactory<partido,String>("hora"));
        lugarPen.setCellValueFactory(new PropertyValueFactory<partido,String>("lugar"));
        // Insertar los valores anteriores en la tabla ppendientes
        insertppen=FXCollections.observableArrayList();
        ppendientes.setItems(insertppen);
        // Para visualizar datos en la tabla
        LocalDateTime [] fecha = {LocalDateTime.of(2018,12,07,10,30,0,0),LocalDateTime.of(2018,12,07,11,00),LocalDateTime.of(2018,12,8,15,30),LocalDateTime.of(2018,12,8,20,30),LocalDateTime.of(2018,12,9,19,20),LocalDateTime.of(2018,12,9,14,00),LocalDateTime.of(2018,12,10,16,25),LocalDateTime.of(2018,12,11,17,35),LocalDateTime.of(2018,12,12,15,30),LocalDateTime.of(2018,12,13,15,50)};
        String [] lugar = {"Málaga","Torremolinos","Fuengirola","Benalmádena","Arroyo de la miel","Campanillas","Malaga","Malaga", "Estepona", "Algeciras"};
        String [] equipo = {"MalagaCity","Torremolinos","FuengirolaBasket","BenalBas","Arroyo de la miel","Campanillas","MalagaCity","MalagaCity","EsteBasket","Algeciras"};
        String [] vsequipo = {"Algeciras","MalagaCity","EsteBasket","Torremolinos","FuengirolaBasket","Arroyo de la miel","Campanillas","MalagaCity","BenalBas","MalagaCity"};
        LocalDateTime hoy = LocalDateTime.now();

        for (int i = 0; i < equipo.length; i++) {
            if ((hoy).compareTo(fecha[i])<=0) {
                partido p1 = new partido();
                p1.equipo.set(equipo[i]);
                p1.vsequipo.set(vsequipo[i]);
                p1.fecha.set(fecha[i].getYear()+"-"+fecha[i].getMonthValue()+"-"+fecha[i].getDayOfMonth());
                p1.hora.set(fecha[i].getHour()+":"+fecha[i].getMinute());
                p1.lugar.set(lugar[i]);
                insertppen.add(p1);
            }
        }

    }
    private void inicializarTablapPas(){

        //Buscar e insertar en las columnas valores de los atributos la clase Partido
        equipoPas.setCellValueFactory(new PropertyValueFactory<partido,String>("equipo"));
        vsequipoPas.setCellValueFactory(new PropertyValueFactory<partido,String>("vsequipo"));
        puntosPas.setCellValueFactory(new PropertyValueFactory<partido,String>("puntos"));
        fechaPas.setCellValueFactory(new PropertyValueFactory<partido,String>("fecha"));
        horaPas.setCellValueFactory(new PropertyValueFactory<partido,String>("hora"));
        lugarPas.setCellValueFactory(new PropertyValueFactory<partido,String>("lugar"));
        // Insertar los valores anteriores en la tabla ppasados
        insertppas=FXCollections.observableArrayList();
        ppasados.setItems(insertppas);
        // Para visualizar datos en la tabla
        LocalDateTime [] fecha = {LocalDateTime.of(2018,12,07,10,30,0,0),LocalDateTime.of(2018,12,07,11,00),LocalDateTime.of(2018,12,8,15,30),LocalDateTime.of(2018,12,8,20,30),LocalDateTime.of(2018,12,9,19,20),LocalDateTime.of(2018,12,9,14,00),LocalDateTime.of(2018,12,10,16,25),LocalDateTime.of(2018,12,11,17,35),LocalDateTime.of(2018,12,12,15,30),LocalDateTime.of(2018,12,13,15,50)};
        String [] lugar = {"Málaga","Torremolinos","Fuengirola","Benalmádena","Arroyo de la miel","Campanillas","Malaga","Malaga", "Estepona", "Algeciras"};
        String [] equipo = {"MalagaCity","Torremolinos","FuengirolaBasket","BenalBas","Arroyo de la miel","Campanillas","MalagaCity","MalagaCity","EsteBasket","Algeciras"};
        String [] vsequipo = {"Algeciras","MalagaCity","EsteBasket","Torremolinos","FuengirolaBasket","Arroyo de la miel","Campanillas","MalagaCity","BenalBas","MalagaCity"};
        String [] punt = {"7-0","0-10","5-3","7-4","9-9","5-6","0-2","1-7","4-4","7-8"};
        LocalDateTime hoy = LocalDateTime.now();
        for (int i = 0; i < equipo.length; i++) {
            if ((hoy).compareTo(fecha[i])>0) {
                partido p1 = new partido();
                p1.equipo.set(equipo[i]);
                p1.vsequipo.set(vsequipo[i]);
                p1.puntos.set(punt[i]);
                p1.fecha.set(fecha[i].getYear()+"-"+fecha[i].getMonthValue()+"-"+fecha[i].getDayOfMonth());
                p1.hora.set(fecha[i].getHour()+":"+fecha[i].getMinute());
                p1.lugar.set(lugar[i]);
                insertppas.add(p1);
            }
        }
    }
    public void buscandopPen(MouseEvent event){
        //Buscar e insertar en las columnas valores de los atributos la clase Partido
        equipoPen.setCellValueFactory(new PropertyValueFactory<partido,String>("equipo"));
        vsequipoPen.setCellValueFactory(new PropertyValueFactory<partido,String>("vsequipo"));
        fechaPen.setCellValueFactory(new PropertyValueFactory<partido,String>("fecha"));
        horaPen.setCellValueFactory(new PropertyValueFactory<partido,String>("hora"));
        lugarPen.setCellValueFactory(new PropertyValueFactory<partido,String>("lugar"));
        // Insertar los valores anteriores en la tabla ppendientes
        insertppen=FXCollections.observableArrayList();
        ppendientes.setItems(insertppen);
        // Para visualizar datos en la tabla
        LocalDateTime [] fecha = {LocalDateTime.of(2018,12,07,10,30,0,0),LocalDateTime.of(2018,12,07,11,00),LocalDateTime.of(2018,12,8,15,30),LocalDateTime.of(2018,12,8,20,30),LocalDateTime.of(2018,12,9,19,20),LocalDateTime.of(2018,12,9,14,00),LocalDateTime.of(2018,12,10,16,25),LocalDateTime.of(2018,12,11,17,35),LocalDateTime.of(2018,12,12,15,30),LocalDateTime.of(2018,12,13,15,50)};
        String [] lugar = {"Málaga","Torremolinos","Fuengirola","Benalmádena","Arroyo de la miel","Campanillas","Malaga","Malaga", "Estepona", "Algeciras"};
        String [] equipo = {"MalagaCity","Torremolinos","FuengirolaBasket","BenalBas","Arroyo de la miel","Campanillas","MalagaCity","MalagaCity","EsteBasket","Algeciras"};
        String [] vsequipo = {"Algeciras","MalagaCity","EsteBasket","Torremolinos","FuengirolaBasket","Arroyo de la miel","Campanillas","MalagaCity","BenalBas","MalagaCity"};
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime hoy = LocalDateTime.of(fechahoy.getValue().getYear(),fechahoy.getValue().getMonthValue(),fechahoy.getValue().getDayOfMonth(),ahora.getHour(),ahora.getMinute());

        for (int i = 0; i < equipo.length; i++) {
            if ((hoy).compareTo(fecha[i])<=0) {
                partido p1 = new partido();
                p1.equipo.set(equipo[i]);
                p1.vsequipo.set(vsequipo[i]);
                p1.fecha.set(fecha[i].getYear()+"-"+fecha[i].getMonthValue()+"-"+fecha[i].getDayOfMonth());
                p1.hora.set(fecha[i].getHour()+":"+fecha[i].getMinute());
                p1.lugar.set(lugar[i]);
                insertppen.add(p1);
            }
        }

        //Buscar e insertar en las columnas valores de los atributos la clase Partido
        equipoPas.setCellValueFactory(new PropertyValueFactory<partido,String>("equipo"));
        vsequipoPas.setCellValueFactory(new PropertyValueFactory<partido,String>("vsequipo"));
        puntosPas.setCellValueFactory(new PropertyValueFactory<partido,String>("puntos"));
        fechaPas.setCellValueFactory(new PropertyValueFactory<partido,String>("fecha"));
        horaPas.setCellValueFactory(new PropertyValueFactory<partido,String>("hora"));
        lugarPas.setCellValueFactory(new PropertyValueFactory<partido,String>("lugar"));
        // Insertar los valores anteriores en la tabla ppasados
        insertppas=FXCollections.observableArrayList();
        ppasados.setItems(insertppas);
        // Para visualizar datos en la tabla
        LocalDateTime [] fecha1 = {LocalDateTime.of(2018,12,07,10,30,0,0),LocalDateTime.of(2018,12,07,11,00),LocalDateTime.of(2018,12,8,15,30),LocalDateTime.of(2018,12,8,20,30),LocalDateTime.of(2018,12,9,19,20),LocalDateTime.of(2018,12,9,14,00),LocalDateTime.of(2018,12,10,16,25),LocalDateTime.of(2018,12,11,17,35),LocalDateTime.of(2018,12,12,15,30),LocalDateTime.of(2018,12,13,15,50)};
        String [] lugar1 = {"Málaga","Torremolinos","Fuengirola","Benalmádena","Arroyo de la miel","Campanillas","Malaga","Malaga", "Estepona", "Algeciras"};
        String [] equipo1 = {"MalagaCity","Torremolinos","FuengirolaBasket","BenalBas","Arroyo de la miel","Campanillas","MalagaCity","MalagaCity","EsteBasket","Algeciras"};
        String [] vsequipo1 = {"Algeciras","MalagaCity","EsteBasket","Torremolinos","FuengirolaBasket","Arroyo de la miel","Campanillas","MalagaCity","BenalBas","MalagaCity"};
        String [] punt = {"7-0","0-10","5-3","7-4","9-9","5-6","0-2","1-7","4-4","7-8"};
        for (int i = 0; i < equipo.length; i++) {
            if ((hoy).compareTo(fecha[i])>0) {
                partido p1 = new partido();
                p1.equipo.set(equipo[i]);
                p1.vsequipo.set(vsequipo[i]);
                p1.puntos.set(punt[i]);
                p1.fecha.set(fecha[i].getYear()+"-"+fecha[i].getMonthValue()+"-"+fecha[i].getDayOfMonth());
                p1.hora.set(fecha[i].getHour()+":"+fecha[i].getMinute());
                p1.lugar.set(lugar[i]);
                insertppas.add(p1);
            }
        }
    }
    // Funcion para vizualizar datos en la tabla player - dni
    public void buscandoDatos(MouseEvent event){

        //Buscar e insertar en las columnas valores de los atributos la clase Persona
        rolDni.setCellValueFactory(new PropertyValueFactory<Persona,String>("roll"));
        fechaDni.setCellValueFactory(new PropertyValueFactory<Persona,String>("fecha"));
        lugarDni.setCellValueFactory(new PropertyValueFactory<Persona,String>("lugar"));
        equipoDni.setCellValueFactory(new PropertyValueFactory<Persona,String>("equipo"));
        vsequipoDni.setCellValueFactory(new PropertyValueFactory<Persona,String>("vsequipo"));
        puntDni.setCellValueFactory(new PropertyValueFactory<Persona,Double>("puntos"));
        // Insertar los valores anteriores en la tabla CalendarTable
        insertdni=FXCollections.observableArrayList();
        dniTable.setItems(insertdni);
        // Para visualizar datos en la tabla
        String [] dni = {"07122018a","07133018v","08122018b","09122018d","07133018v","10122018w","18122018e","07133018v","19122018f","13122018e"};
        String [] rol = {"Jugador","Arbitro","Entrenador","Jugador","Jugador","Entrenador","Entrenador","Arbitro","Arbitro","Arbitro"};
        String [] fecha = {"07/12/2018","07/12/2018","08/12/2018","09/12/2018","10/12/2018","10/12/2018","10/12/2018","12/12/2018","12/12/2018","13/12/2018"};
        String [] hora = {"07:30","10:30","12:30","16:30","18:00","20:00","08:00","17:00","19:30","20:30"};
        String [] lugar = {"Málaga","Torremolinos","Fuengirola","Benalmádena","Arroyo de la miel","Campanillas","Malaga","Malaga", "Estepona", "Algeciras"};
        String [] equipo = {"MalagaCity","Torremolinos","FuengirolaBasket","BenalBas","Arroyo de la miel","Campanillas","MalagaCity","MalagaCity","EsteBasket","Algeciras"};
        String [] vsequipo = {"Algeciras","MalagaCity","EsteBasket","Torremolinos","FuengirolaBasket","Arroyo de la miel","Campanillas","MalagaCity","BenalBas","MalagaCity"};

        String a = dniInser.getCharacters().toString();



        for (int j = 0; j < dni.length; j++) {
            if(a.equals(dni[j])) {
                Persona c1 = new Persona();
                c1.fecha.set(fecha[j] + " " + hora[j]);
                c1.roll.set(rol[j]);
                c1.lugar.set(lugar[j]);
                c1.equipo.set(equipo[j]);
                c1.vsequipo.set(vsequipo[j]);
                insertdni.add(c1);
            }
        }

    }

    // Funcion que se ejecuta como iniciador
    @Override
    public void initialize (URL location, ResourceBundle resources) {

        // Paneles vistos y no vistos al iniciar la app
        ballonPanel.setVisible(true);
        arrowBallon.setVisible(true);
        calendarPanel.setVisible(false);
        arrowCalendar.setVisible(false);
        shirtPanel.setVisible(false);
        arrowShirt.setVisible(false);
        campPanel.setVisible(false);
        arrowCamp.setVisible(false);
        playerPanel.setVisible(false);
        arrowPlayer.setVisible(false);
        // Visualización de Tablas
        this.inicializarTablaCalendar();
        this.inicializarTablaEquipo();
        this.inicializarTablapPen();
        this.inicializarTablapPas();
        LocalDateTime hy=LocalDateTime.now();;
        fechahoy.setPromptText(hy.getDayOfMonth()+"/"+hy.getMonthValue()+"/"+hy.getYear());

        List<Partido> part=new PartidoDaoImpl().BuscarTodosLospartidos();
        System.out.println(part.get(0));
    }
}
