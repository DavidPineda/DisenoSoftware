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
public class Destino {
    
    private Ciudad ciudad;
    private int coste;
    private int tiempo;

    /**
     * @return the ciudad
     */
    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the coste
     */
    public int getCoste() {
        return coste;
    }

    /**
     * @param coste the coste to set
     */
    public void setCoste(int coste) {
        this.coste = coste;
    }

    /**
     * @return the tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public Destino(){
        
    }
    
    public Destino(Ciudad ciudad, int coste, int tiempo){
        this.ciudad = ciudad;
        this.coste = coste;
        this.tiempo = tiempo;
    }
   
}
