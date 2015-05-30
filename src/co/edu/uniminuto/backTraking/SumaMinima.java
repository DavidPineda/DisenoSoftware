/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.backTraking;

/**
 *
 * @author david
 */
public class SumaMinima {

    int[][] matriz;
    int n;

    public SumaMinima(int n) {
        this.n = n;
        armarMatriz();
        backTraking();
    }

    private void armarMatriz() {
        matriz = new int[n][n];
        for (int[] array : matriz) {
            for (int i = 0; i < array.length; i++) {
                array[i] = -1;
            }
        }
    }

    private void backTraking() {
        //for (int[] array : matriz) {
        int[] solucion = new int[n * n];
        int[] solucionFinal = new int[n * n];
        backTraking(solucion, 0, solucionFinal);
        String s = "";
        //}
    }

    /**
     * Utiliza el algoritmo de BackTraking para determinar la cantidad de
     * valores minimos a agregar a la matriz
     *
     * @param array Array Solucion
     * @param etapa Etapa dentro del arbol
     * @return Valor True o False indicando que se encontro solucion o no
     * respectivamente
     */
    /*private void backTraking(int solucion[], int etapa, int[] solucionFInal) {
     if (etapa > solucion.length - 1) {
     return; // No se encontro Solucion
     }
     int numero = 1;
     do {
     solucion[etapa] = numero; // Se selecciona una nueva opcion
     if (validaPosicion(solucion, etapa, numero)) {
     if (etapa == solucion.length - 1) {
     actualizarSolucion(solucion, solucionFInal);
     } else {
     backTraking(solucion, etapa + 1, solucionFInal);
     }
     }
     numero++;
     } while (solucion[etapa] != n*n);
     }*/
    private void backTraking(int solucion[], int etapa, int[] solucionFinal) {
        if (etapa > (n * n) - 1) {
            return; // No se encontro Solucion
        }
        int numero = 1;
        do {
            solucion[etapa] = numero; // Se selecciona una nueva opcionF
            if (validarPosicionFila(solucion, etapa) && validaPosicionColumna(solucion, etapa)) {
                if (etapa == solucion.length - 1) {
                    solucionFinal = actualizarSolucion(solucion, solucionFinal);
                } else {
                    backTraking(solucion, etapa + 1, solucionFinal);
                }
            }
            numero++;
        } while (solucion[etapa] != (n * n));
    }

    private int[] actualizarSolucion(int solucion[], int solucionFinal[]) {
        int sumaInicial = 0, sumaFinal = 0;
        for (int i = 0; i < solucion.length; i++) {
            sumaInicial += solucion[i];
            sumaFinal += solucionFinal[i];
        }
        if (sumaFinal < sumaInicial) {
            solucionFinal = (int[]) solucion.clone();
        }        
        return solucionFinal;
    }

    /*private boolean backTraking(int array[], int etapa) {
     if (etapa > n - 1) {
     return false; // No se encontro Solucion
     }
     boolean exito = false;
     array[etapa] = -1;
     do {
     array[etapa] = array[etapa] + 1; // Se selecciona una nueva opcion
     if (validaPosicion(array, etapa)) {
     if (etapa != n - 1) {
     exito = backTraking(array, etapa + 1);
     } else {
     exito = true;
     }
     }
     } while (array[etapa] != n - 1 && !exito);

     return exito;
     }*/
    /**
     * Valida si una posicion es valida respecto a la diagonal y la fila de
     * manera que el valor no se repita en dichas ubicaciones
     *
     * @param array El array solucion temporal
     * @param k la etapa en la cual se esta evaluando
     * @return valor true si el numero es valido en la posicion, de lo contrario
     * false
     */
    private boolean validaPosicionColumna(int[] solucion, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + n; j < solucion.length; j = j + n) {
                if (solucion[i] == solucion[j]) {
                    return false;
                }
            }
            /*if (array[k] || array[i] == array[k] || ((valAbs(array[i], array[k]) == valAbs(i, k) && array[k] == numero))) {
             return false;
             }*/
        }
        return true;
    }

    private boolean validarPosicionFila(int[] solucion, int k) {
        for (int i = 0; i < solucion.length; i = i + n) {
            if ((i + n) > k) {
                for (int j = i; j < k; j++) {
                    if (solucion[k] == solucion[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Retorna el valor absoluto de la resta entre x y y (x-y)
     *
     * @param x Valor del cual se restara
     * @param y Valor a restar
     * @return Valor absoluto de la division
     */
    private int valAbs(int x, int y) {
        return Math.abs(x - y);
    }
}
