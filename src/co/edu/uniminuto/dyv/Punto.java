/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.dyv;

/**
 *
 * @author david
 */
public class Punto {

    private double x;
    private double y;

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distancia(Punto punto) {
        double px = punto.getX() - this.getX();
        double py = punto.getY() - this.getY();
        return Math.sqrt(px * px + py * py);
    }

}
