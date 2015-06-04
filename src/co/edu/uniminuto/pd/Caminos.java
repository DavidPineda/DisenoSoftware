/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.pd;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Caminos {

    private Ciudad origen;
    private Ciudad destino;
    private ArrayList<Ciudad> camino;

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public Caminos(Ciudad origen, Ciudad destino) {
        this.origen = origen;
        this.destino = destino;
        this.camino = new ArrayList<>();
    }
    
    public Caminos(){
        this.origen = null;
        this.destino = null;
        this.camino = new ArrayList<>();
    }

    public Object[][] generarMatrizCaminos(Ciudad[] ciudades) {
        Object[][] matrizCaminos = new Object[ciudades.length + 1][ciudades.length + 1];
        for (int f = 0; f < matrizCaminos.length; f++) {
            for (int c = 0; c < matrizCaminos[0].length; c++) {
                if (f == c) {
                    matrizCaminos[f][c] = 0;
                } else if (f == 0 && c > 0) {
                    matrizCaminos[f][c] = ciudades[c - 1];
                } else if (f > 0 && c == 0) {
                    matrizCaminos[f][c] = ciudades[f - 1];
                } else {
                    matrizCaminos[f][c] = obtenerDestino((Ciudad) matrizCaminos[f][0], (Ciudad) matrizCaminos[0][c]);
                }
            }
        }
        return matrizCaminos;
    }

    public void imprimirMatriz(Object[][] matrizCaminos) {
        for (int f = 0; f < matrizCaminos.length; f++) {
            for (int c = 0; c < matrizCaminos[0].length; c++) {
                if (matrizCaminos[f][c] != null) {
                    if (matrizCaminos[f][c] instanceof Ciudad) {
                        System.out.print("[" + ((Ciudad) matrizCaminos[f][c]).getNombre() + "], ");
                    } else if (matrizCaminos[f][c] instanceof Destino) {
                        System.out.print("[" + ((Destino) matrizCaminos[f][c]).getCoste() + "], ");
                    } else {
                        System.out.print("[" + (int) matrizCaminos[f][c] + "], ");
                    }
                } else {
                    System.out.print("[NULL], ");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Permite determinar el destina hacia el cual ir
     *
     * @param cSalida Ciudad origen
     * @param cLlegada Ciudad destino
     * @return El destino hacia el cual va una determinada ciudad
     */
    private Destino obtenerDestino(Ciudad cSalida, Ciudad cLlegada) {
        for (Destino d : cSalida.getDestinos()) {
            if (d.getCiudad().getNombre().equals(cLlegada.getNombre())) {
                return d;
            }
        }
        return null;
    }

    public void programacionDinamica(Object[][] matriz) {
        for (int k = 1; k < matriz.length; k++) {
            for (int i = 1; i < matriz.length; i++) {
                for (int j = 1; j < matriz.length; j++) {
                    matriz[i][j] = actualizarDestino(matriz[i][j], Math.min(costeDestino(matriz[i][j]), costeDestino(matriz[i][k]) + costeDestino(matriz[k][j])), (Ciudad) matriz[0][k]);
                }
            }
        }
        caminoCorto(matriz);
    }

    private void caminoCorto(Object[][] matriz) {
        camino.clear();
        camino.add(getOrigen());
        boolean valor = true;
        Ciudad copiaOrigen = getOrigen();
        Ciudad c1 = null;
        while (valor) {
            c1 = encontrarCamino(matriz, copiaOrigen, getDestino());
            Ciudad ultimoDestino = camino.get(camino.size() - 1);
            Destino d = (Destino) matriz[ultimoDestino.getNumCiudad() + 1][getDestino().getNumCiudad() + 1];
            if (getDestino().getNumCiudad() != ultimoDestino.getNumCiudad() && d.getCiudad().getNumCiudad() != c1.getNumCiudad()) {
                copiaOrigen = camino.get(camino.size() - 1);
            } else {
                valor = false;
            }
        }
        camino.add(c1);
        int coste = 0;
        for (int i = 0; i < camino.size(); i++) {
            System.out.println(camino.get(i).getNombre());
            if (i < camino.size() - 1) {
                coste += destinoCoste(camino.get(i + 1).getNumCiudad(), camino.get(i).getDestinos());
            }
        }
        System.out.println("El Coste del camino es:" + coste);
    }

    private int destinoCoste(int numCiudad, Destino[] destinos) {
        for (Destino d : destinos) {
            if (d.getCiudad().getNumCiudad() == numCiudad) {
                return d.getCoste();
            }
        }
        return 0;
    }

    /**
     * Permite calcular los caminos intermedios entre dos ciudades
     *
     * @param matriz Matriz de adyacencias con los caminos mas cortos
     * @param origen Ciudad de origen de busqueda del camino
     * @param destino Ciudad destino de busqueda del camino
     * @return La ultmia ciudad de destino
     */
    private Ciudad encontrarCamino(Object[][] matriz, Ciudad origen, Ciudad destino) {
        Destino d = (Destino) matriz[origen.getNumCiudad() + 1][destino.getNumCiudad() + 1];
        if (destino.getNumCiudad() != d.getCiudad().getNumCiudad()) {
            camino.add(encontrarCamino(matriz, origen, d.getCiudad()));
        }
        return destino;
    }

    /**
     * Se encarga de determinar el tipo de costes que tiene una celda
     * determinada de la matriz
     *
     * @param d el objeto del cual se determinara su coste
     * @return Coste del objeto evaluado
     */
    private int costeDestino(Object d) {
        if (d == null) {
            return Integer.MAX_VALUE;
        } else if (d instanceof Destino) {
            return ((Destino) d).getCoste();
        }
        return (int) d;
    }

    /**
     * Actualiza el Destino de una celda especifica de la matriz
     *
     * @param d Objeto actual de la celda antes de actualizar
     * @param newCoste Nuevo cosre a evaluar para poder determinar si se cambia
     * en la celda
     * @param c Ciudad del nuevo destino
     * @return El destino mas cercano desde la posicion d
     */
    private Destino actualizarDestino(Object d, int newCoste, Ciudad c) {
        if (d != null && d instanceof Destino) {
            if (((Destino) d).getCoste() != newCoste) {
                return new Destino(c, newCoste, 0);
            } else {
                return (Destino) d;
            }
        }
        return new Destino(c, newCoste, 0);
    }

}
