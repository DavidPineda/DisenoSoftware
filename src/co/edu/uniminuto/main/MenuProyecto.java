/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.main;

import co.edu.uniminuto.dyv.ParMasCercano;
import co.edu.uniminuto.dyv.Punto;
import co.edu.uniminuto.pd.Caminos;
import co.edu.uniminuto.pd.Ciudad;
import co.edu.uniminuto.pd.Destino;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class MenuProyecto {

    Scanner s;

    public MenuProyecto() {
        s = new Scanner(System.in);
    }

    public void menuPrincipal() {
        System.out.println("Seleccione alguna de las siguientes opciones:");
        System.out.println("1) Par Mas Cercano (Divide y Venceras)");
        System.out.println("2) Camino Mas Corto (Programacion Dinamica)");
        switch (s.nextInt()) {
            case 1:
                divideYvenceras();
                break;
            case 2:
                programacionDinamica();
                break;
            default:
                menuPrincipal();
                break;
        }
    }

    private void divideYvenceras() {
        System.out.println("Ingrese la cantidad de puntos");
        int cantPuntos = s.nextInt();
        double x = 0, y = 0;
        Punto[] puntos = new Punto[cantPuntos];
        for (int i = 0; i < cantPuntos; i++) {
            System.out.println("Ingrese cordena X punto " + (i + 1));
            x = s.nextDouble();
            System.out.println("Ingrese cordena Y punto " + (i + 1));
            y = s.nextDouble();
            puntos[i] = new Punto(x, y);
        }
        ParMasCercano p = new ParMasCercano();
        System.out.println(p.divideYvenceras(puntos));
    }

    private void programacionDinamica() {
        /*System.out.println("Ingrese la cantidad de ciudades");
        int cantCiudades = s.nextInt();
        Ciudad[] ciudades = new Ciudad[cantCiudades];
        String nombre = "";
        int cantDestinos = 0;
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Nombre de la Ciudad # " + (i + 1));
            nombre = s.next();
            System.out.println("Cantidad Destinos Ciudad # " + (i + 1));
            cantDestinos = s.nextInt();
            if (cantDestinos > ciudades.length - 1) {
                cantDestinos = ciudades.length - 1;
            }
            ciudades[i] = new Ciudad(nombre, cantDestinos, i);
        }
        for (Ciudad c : ciudades) {
            for (Destino d : c.getDestinos()) {
                String strDestinos = destinos(ciudades, c);
                if (!strDestinos.equals("")) {
                    System.out.println("\nSeleccione uno de los siguientes destinos para " + c.getNombre());
                    System.out.println(strDestinos);
                    d = new Destino();
                    Ciudad ciudadDestino = ciudadDestino(s.nextInt(), ciudades);
                    if (ciudadDestino != null) {
                        d.setCiudad(ciudadDestino);
                        System.out.println("Ingrese el coste de viaje");
                        d.setCoste(s.nextInt());
                        System.out.println("Ingrese el tiempo de viaje");
                        d.setTiempo(s.nextInt());
                        c.addDestino(d);
                    }
                }
            }
        }*/

        Ciudad bogota = new Ciudad("bogota", 7, 0);
        Ciudad medellin = new Ciudad("medellin", 7, 1);
        Ciudad cali = new Ciudad("cali", 7, 2);
        Ciudad barranquilla = new Ciudad("barranquilla", 7, 3);
        Ciudad cucuta = new Ciudad("cucuta", 7, 4);
        Ciudad ibague = new Ciudad("ibague", 7, 5);
        Ciudad manizalez = new Ciudad("manizalez", 7, 6);
        Ciudad bucaramanga = new Ciudad("bucaramanga", 7, 7);
        
        // Partida desde bogota
        Destino bogotaMedellin = new Destino(medellin, 64, 41);
        Destino bogotaCali = new Destino(cali, 4, 53);
        Destino bogotaBarranquilla = new Destino(barranquilla, 33, 75);
        Destino bogotaCucuta = new Destino(cucuta, 13, 15);
        Destino bogotaIbague = new Destino(ibague, 37, 93);
        Destino bogotaManizalez = new Destino(manizalez, 49, 68);
        Destino bogotaBucaramanga = new Destino(bucaramanga, 28, 34);
        
        bogota.addDestino(bogotaMedellin);
        bogota.addDestino(bogotaCali);
        bogota.addDestino(bogotaBarranquilla);
        bogota.addDestino(bogotaCucuta);
        bogota.addDestino(bogotaIbague);
        bogota.addDestino(bogotaManizalez);
        bogota.addDestino(bogotaBucaramanga);
        
        // Partida desde medellin
        Destino medellinBogota = new Destino(bogota, 26, 29);
        Destino medellinCali = new Destino(cali, 90, 22);
        Destino medellinBarranquilla = new Destino(barranquilla, 42, 19);
        Destino medellinCucuta = new Destino(cucuta, 61, 20);
        Destino medellinIbague = new Destino(ibague, 77, 37);
        Destino medellinManizalez = new Destino(manizalez, 55, 38);
        Destino medellinBucaramanga = new Destino(bucaramanga, 3, 44);
        
        medellin.addDestino(medellinBogota);
        medellin.addDestino(medellinCali);
        medellin.addDestino(medellinBarranquilla);
        medellin.addDestino(medellinCucuta);
        medellin.addDestino(medellinIbague);
        medellin.addDestino(medellinManizalez);
        medellin.addDestino(medellinBucaramanga);
        
        // Partida desde cali
        Destino caliBogota = new Destino(bogota, 26, 57);
        Destino caliMedellin = new Destino(medellin, 45, 49);
        Destino caliBarranquilla = new Destino(barranquilla, 33, 58);
        Destino caliCucuta = new Destino(cucuta, 32, 10);
        Destino caliIbague = new Destino(ibague, 6, 56);
        Destino caliManizalez = new Destino(manizalez, 41, 10);
        Destino caliBucaramanga = new Destino(bucaramanga, 38, 46);
        
        cali.addDestino(caliBogota);
        cali.addDestino(caliMedellin);
        cali.addDestino(caliBarranquilla);
        cali.addDestino(caliCucuta);
        cali.addDestino(caliIbague);
        cali.addDestino(caliManizalez);
        cali.addDestino(caliBucaramanga);
        
        // Partida desde barranquilla
        Destino barranquillaBogota = new Destino(bogota, 35, 96);
        Destino barranquillaMedellin = new Destino(medellin, 77, 43);
        Destino barranquillaCali = new Destino(cali, 75, 68);
        Destino barranquillaCucuta = new Destino(cucuta, 45, 55);
        Destino barranquillaIbague = new Destino(ibague, 38, 96);
        Destino barranquillaManizalez = new Destino(manizalez, 99, 85);
        Destino barranquillaBucaramanga = new Destino(bucaramanga, 85, 43);
        
        barranquilla.addDestino(barranquillaBogota);
        barranquilla.addDestino(barranquillaMedellin);
        barranquilla.addDestino(barranquillaCali);
        barranquilla.addDestino(barranquillaCucuta);
        barranquilla.addDestino(barranquillaIbague);
        barranquilla.addDestino(barranquillaManizalez);
        barranquilla.addDestino(barranquillaBucaramanga);
        
        // Partida desde cucuta
        Destino cucutaBogota = new Destino(bogota, 36, 63);
        Destino cucutaMedellin = new Destino(medellin, 88, 32);
        Destino cucutaCali = new Destino(cali, 14, 36);
        Destino cucutaBarranquilla = new Destino(barranquilla, 42, 98);
        Destino cucutaIbague = new Destino(ibague, 19, 45);
        Destino cucutaManizalez = new Destino(manizalez, 36, 90);
        Destino cucutaBucaramanga = new Destino(bucaramanga, 13, 74);
        
        cucuta.addDestino(cucutaBogota);
        cucuta.addDestino(cucutaMedellin);
        cucuta.addDestino(cucutaCali);
        cucuta.addDestino(cucutaBarranquilla);
        cucuta.addDestino(cucutaIbague);
        cucuta.addDestino(cucutaManizalez);
        cucuta.addDestino(cucutaBucaramanga);
        
        // Partida desde ibague
        Destino ibagueBogota = new Destino(bogota, 37, 48);
        Destino ibagueMedellin = new Destino(medellin, 4, 43);
        Destino ibagueCali = new Destino(cali, 24, 21);
        Destino ibagueBaranquilla = new Destino(barranquilla, 63, 70);
        Destino ibagueCucuta = new Destino(cucuta, 67, 43);
        Destino ibagueManizalez = new Destino(manizalez, 69, 57);
        Destino ibagueBucaramanga = new Destino(bucaramanga, 66, 23);
        
        ibague.addDestino(ibagueBogota);
        ibague.addDestino(ibagueMedellin);
        ibague.addDestino(ibagueCali);
        ibague.addDestino(ibagueBaranquilla);
        ibague.addDestino(ibagueCucuta);
        ibague.addDestino(ibagueManizalez);
        ibague.addDestino(ibagueBucaramanga);
        
        // Partida desde manizalez
        Destino manizalezBogota = new Destino(bogota, 99, 54);
        Destino manizalezMedellin = new Destino(medellin, 2, 30);
        Destino manizalezCali = new Destino(cali, 79, 59);
        Destino manizalezBarranquilla = new Destino(barranquilla, 31, 99);
        Destino manizalezCucuta = new Destino(cucuta, 39, 13);
        Destino manizalezIbague = new Destino(ibague, 84, 61);
        Destino manizalezBucaramanga = new Destino(bucaramanga, 79, 81);
        
        manizalez.addDestino(manizalezBogota);
        manizalez.addDestino(manizalezMedellin);
        manizalez.addDestino(manizalezCali);
        manizalez.addDestino(manizalezBarranquilla);
        manizalez.addDestino(manizalezCucuta);
        manizalez.addDestino(manizalezIbague);
        manizalez.addDestino(manizalezBucaramanga);
        
        // Partida desde bucaramanga
        Destino BucaramangaBogota = new Destino(bogota, 79, 87);
        Destino BucaramangaMedellin = new Destino(medellin, 11, 11);
        Destino BucaramangaCali = new Destino(cali, 17, 40);
        Destino BucaramangaBarranquilla = new Destino(barranquilla, 14, 36);
        Destino BucaramangaCucuta = new Destino(cucuta, 88, 43);
        Destino BucaramangaIbague = new Destino(ibague, 91, 92);
        Destino BucaramangaManizalez = new Destino(manizalez, 58, 41);
        
        bucaramanga.addDestino(BucaramangaBogota);
        bucaramanga.addDestino(BucaramangaMedellin);
        bucaramanga.addDestino(BucaramangaCali);
        bucaramanga.addDestino(BucaramangaBarranquilla);
        bucaramanga.addDestino(BucaramangaCucuta);
        bucaramanga.addDestino(BucaramangaIbague);
        bucaramanga.addDestino(BucaramangaManizalez);
        
        Ciudad[] ciudades = {bogota, medellin, cali, barranquilla, cucuta, ibague, manizalez, bucaramanga};
      
        int res = 0;
        while(res == 0){
            System.out.println("Seleccione la ciudad Origen\n");
            System.out.println(destinos(ciudades));
            Ciudad origen = ciudadDestino(s.nextInt(), ciudades);
            System.out.println("Seleccione la ciudad Destino\n");
            System.out.println(destinos(ciudades));
            Ciudad destino = ciudadDestino(s.nextInt(), ciudades);
            Caminos camino = new Caminos(origen, destino);
            camino.programacionDinamica(ciudades);
            System.out.println("0) para continuar, 1) Terminar");
            res = s.nextInt();
        }       
    }

    private String destinos(Ciudad[] ciudades, Ciudad c) {
        String destinos = "";
        for (Ciudad c1 : ciudades) {
            if (!c1.getNombre().equals(c.getNombre()) && !destinoInArray(c.getDestinos(), c1.getNombre())) {
                destinos += c1.getNumCiudad() + ") " + c1.getNombre() + "\n";
            }
        }
        return destinos;
    }
    
    private String destinos(Ciudad[] ciudades) {
        String destinos = "";
        for (Ciudad c1 : ciudades) {           
            destinos += c1.getNumCiudad() + ") " + c1.getNombre() + "\n";
        }
        return destinos;
    }

    private Ciudad ciudadDestino(int numCiudad, Ciudad[] ciudades) {
        for (Ciudad c : ciudades) {
            if (c.getNumCiudad() == numCiudad) {
                return c;
            }
        }
        return null;
    }

    private boolean destinoInArray(Object[] array, String nombre) {
        if (array instanceof Ciudad[]) {
            for (Ciudad c : (Ciudad[]) array) {
                if ((c != null) && c.getNombre().equals(nombre)) {
                    return true;
                }
            }
        } else {
            for (Destino d : (Destino[]) array) {
                if ((d != null) && d.getCiudad().getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MenuProyecto m = new MenuProyecto();
        m.menuPrincipal();
    }

}