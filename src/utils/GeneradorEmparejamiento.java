/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import model.Equipo;
import model.Partido;

/**
 *
 * @author mohammed
 */
public class GeneradorEmparejamiento {
    
    private List<Equipo> equipos= new ArrayList();
    
    public List<List<Partido>> genararEmparejamientos(){
         GeneradorEmparejamiento rr = new GeneradorEmparejamiento();
         List<List<Partido>> jornadas = new ArrayList<>();
         for (int i = 0; i < 9; i++) {
             List<Partido> partidos = rr.mostrar();
             jornadas.add(partidos);
            rr.combinar();
        }
        return jornadas;
    }

    public GeneradorEmparejamiento() {
        this.equipos.add(new Equipo("a", "aa", "malaga", 1, 0));
        this.equipos.add(new Equipo("a", "bb", "madrid", 2, 0));
        this.equipos.add(new Equipo("a", "cc", "barcelona", 3, 0));
        this.equipos.add(new Equipo("a", "dd", "svilla", 4, 0));
        this.equipos.add(new Equipo("a", "ee", "cadiz", 5, 0));
        this.equipos.add(new Equipo("a", "ff", "gordoba", 6, 0));
        this.equipos.add(new Equipo("a", "gg", "bilbao", 7, 0));
        this.equipos.add(new Equipo("a", "hh", "granada", 8, 0));
        this.equipos.add(new Equipo("a", "ee", "vvalencia", 9, 0));
        this.equipos.add(new Equipo("a", "ii", "santiago ", 10, 0));
    }

    public void combinar(){             
        Equipo equipo=equipos.get(equipos.size()-1);
  
        for (int i = equipos.size()-1; i > 1; i--) {
            equipos.set(i, equipos.get(i-1));
        }
        equipos.set(1, equipo);  
    }

    public List<Partido> mostrar(){
        List<Partido> listaPartidos = new ArrayList<>();
        for (int i = 0, j=equipos.size()-1; i<j; i++, j--) {
            //Partido p = new Partido("10", "10", 0, 0, 0, equipos.get(i).getId_equipo(), equipos.get(j).getId_equipo());
            //listaPartidos.add(p);
            System.out.println(equipos.get(i).getId_equipo()+" vs "+ equipos.get(j).getId_equipo());
        }
        System.out.println("*************************************");
        return listaPartidos;
        
    }
    
}
