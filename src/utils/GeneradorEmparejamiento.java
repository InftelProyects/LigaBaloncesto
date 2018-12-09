/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.IPartidoDao;
import dao.impl.PartidoDaoImpl;
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
         int m = 0;
         for (int i = 0; i < 9; i++) {
             m = i + 1;
             System.out.println("El numero de la jornada es : "+ m);
             List<Partido> partidos = rr.mostrar();
             jornadas.add(partidos);
             rr.combinar();
        }
        return jornadas;
    }

    public GeneradorEmparejamiento() {
        this.equipos.add(new Equipo("a", "iberostar", "malaga", 7, 0));
        this.equipos.add(new Equipo("a", "manresa", "madrid", 8, 0));
        this.equipos.add(new Equipo("a", "MoraBank", "barcelona", 9, 0));
        this.equipos.add(new Equipo("a", "unicaja", "malaga", 10, 0));
        this.equipos.add(new Equipo("a", "estudiantes", "cadiz", 5, 0));
        this.equipos.add(new Equipo("a", "barcelona", "gordoba", 1, 0));
        this.equipos.add(new Equipo("a", "real madrid", "madrid", 3, 0));
        this.equipos.add(new Equipo("a", "valencia Basket", "valencia", 2, 0));
        this.equipos.add(new Equipo("a", "baskonia", "bilbao", 4, 0));
        this.equipos.add(new Equipo("a", "joventut", "santander", 6, 0));
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
            
            System.out.println(equipos.get(i).getNombre()+" vs "+ equipos.get(j).getNombre());
            
        }
       System.out.println("*************************************");
        return listaPartidos;
        
    }
    
}
