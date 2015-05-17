/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.dyv.main;

import co.edu.uniminuto.dyv.ParMasCercano;
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
        int x = 0, y = 0;
        Point[] puntos = new Point[cantPuntos];
        for (int i = 0; i < cantPuntos; i++) {
            System.out.println("Ingrese cordena X punto " + (i + 1));
            x = s.nextInt();
            System.out.println("Ingrese cordena Y punto " + (i + 1));
            y = s.nextInt();
            puntos[i] = new Point(x, y);
        }
        ParMasCercano p = new ParMasCercano();
        p.encontraPar(puntos);
    }

}
