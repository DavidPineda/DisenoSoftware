/**
 * Clase para almacenar el par de puntos
 */
package co.edu.uniminuto.dyv;

import java.awt.Point;

/**
 *
 * @author david
 */
public class ParPuntos {

    private Punto puntoA;
    private Punto puntoB;

    public ParPuntos(Punto puntoA, Punto puntoB) {
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    public double distancia() {
        return getPuntoA().distancia(getPuntoB());
    }

    /**
     * @return the puntoA
     */
    public Punto getPuntoA() {
        return puntoA;
    }

    /**
     * @param puntoA the puntoA to set
     */
    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    /**
     * @return the puntoB
     */
    public Punto getPuntoB() {
        return puntoB;
    }

    /**
     * @param puntoB the puntoB to set
     */
    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }

    @Override
    public String toString() {
        return "[(" + puntoA.getX() + "," + puntoA.getY() + "),(" + puntoB.getX() + "," + puntoB.getY() + ")]";
    }
}
