/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.pd;

/**
 *
 * @author david
 */
public class Ciudad {

    private String nombre;
    private Destino[] destinos;
    private int numCiudad;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the destinos
     */
    public Destino[] getDestinos() {
        return destinos;
    }

    /**
     * @param destinos the destinos to set
     */
    public void setDestinos(Destino[] destinos) {
        this.destinos = destinos;
    }

    /**
     * @return the numCiudad
     */
    public int getNumCiudad() {
        return numCiudad;
    }

    /**
     * @param numCiudad the numCiudad to set
     */
    public void setNumCiudad(int numCiudad) {
        this.numCiudad = numCiudad;
    }
    
    public Ciudad(String nombre, Destino[] destinos){
        this.nombre = nombre;
        this.destinos = destinos;
    }            

    public Ciudad(String nombre, int destinos, int numCiudad) {
        this.nombre = nombre;
        this.destinos = new Destino[destinos];
        this.numCiudad = numCiudad;
    }

    public void addDestino(Destino destino) {
        for(int i = 0; i < getDestinos().length; i++){
            if(getDestinos()[i] == null){
                destinos[i] = destino;
                return;
            }
        }
    }
}
