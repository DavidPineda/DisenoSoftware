/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.main;

import co.edu.uniminuto.backTraking.SumaMinima;
import co.edu.uniminuto.dyv.ParMasCercano;
import co.edu.uniminuto.dyv.Punto;
import co.edu.uniminuto.pd.Caminos;
import co.edu.uniminuto.pd.Ciudad;
import co.edu.uniminuto.pd.Destino;
import java.util.Random;
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
        System.out.println("3) Suma Minima (BackTraking)");
        switch (s.nextInt()) {
            case 1:
                divideYvenceras();
                break;
            case 2:
                programacionDinamica();
                break;
            case 3:
                backTraking();
                break;
            default:
                menuPrincipal();
                break;
        }
    }

    private void divideYvenceras() {
        System.out.println("Ingrese la cantidad de puntos");
        int cantPuntos = s.nextInt();
        Punto[] puntos = new Punto[cantPuntos];
        ParMasCercano p = new ParMasCercano();
        cargarPuntos(puntos);
        System.out.println(p.divideYvenceras(puntos));
    }

    private void cargarPuntos(Punto[] puntos) {
        System.out.println("1) Para ingresar puntos aleatorios.\n2) Para ingresar puntos manual.");
        int formaCargue = s.nextInt();
        double x = 0, y = 0;
        switch (formaCargue) {
            case 1:
                Random r = new Random();
                System.out.println("Ingrese el valor superio del rango de puntos");
                int valSUperior = s.nextInt();
                for (int i = 0; i < puntos.length; i++) {
                    x = r.nextDouble() * valSUperior + 0;
                    y = r.nextDouble() * valSUperior + 0;
                    puntos[i] = new Punto(x, y);
                }
                break;
            case 2:
                for (int i = 0; i < puntos.length; i++) {
                    System.out.println("Ingrese cordena X punto " + (i + 1));
                    x = s.nextDouble();
                    System.out.println("Ingrese cordena Y punto " + (i + 1));
                    y = s.nextDouble();
                    puntos[i] = new Punto(x, y);
                }
                break;
            default:
                System.out.println("Opcion invalida intente de nuevo.");
                cargarPuntos(puntos);
                break;
        }
    }

    private void programacionDinamica() {
        System.out.println("Ingrese la cantidad de ciudades");
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
        }

        int res = 0;
        while (res == 0) {
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

    private Ciudad ciudadDestino(int numCiudad, Ciudad[] ciudades) {
        for (Ciudad c : ciudades) {
            if (c.getNumCiudad() == numCiudad) {
                return c;
            }
        }
        return null;
    }

    private void backTraking() {
        System.out.println("Ingrese la cantidad n de la matriz");
        int n = s.nextInt();
        SumaMinima sumaMinima = new SumaMinima(n);
        sumaMinima.backTraking();
    }

    public static void main(String[] args) {
        MenuProyecto m = new MenuProyecto();
        m.menuPrincipal();
    }

}
