/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.main;

import co.edu.uniminuto.dyv.ParMasCercano;
import co.edu.uniminuto.dyv.Punto;
import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class MenuProyecto {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
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
        //Punto[] puntos = {new Punto(4,1),new Punto(10,3),new Punto(7,5),new Punto(8,2),new Punto(1,4),new Punto(3,7),new Punto(6,6),new Punto(6,5.5),new Punto(6.1, 5.4)};
        System.out.println(p.divideYvenceras(puntos));
    }

}
