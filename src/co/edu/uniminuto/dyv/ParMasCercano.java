/**
 * Clase que evalua la distancia de puntos en el plano para retornar el par
 * mas cercano, por medio de la tecnica de divide y vencerar
 * 
 * Problema: Dado un conjunto de puntos en el plano cartesiano (x,y) el problema
 * es encontrar aquellos dos puntos que se encuentran más cerca el uno del otro.
 */
package co.edu.uniminuto.dyv;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ParMasCercano {

    /**
     * Funcion publica encargada llamar el metodo de ordenacion del array y luego llamar al proceso principal
     * @param puntos Array con todos los puntos cargados
     * @return Retorna mensaje indicando cual fue el par mas cercano encontrado
     */    
    public String divideYvenceras(Point[] puntos){
        // Se ordena el array de acuerdo a la cordenada X
        Arrays.sort(puntos, new OrdenPointX());
        // Se obtiene el par de puntos con menor distancia
        ParPuntos dmin = divideYvenceras(puntos, 0, puntos.length - 1);
        return "El par de puntos mas cercano es: " + dmin.toString();
    }
    
    /**
     * Funcion recursiva en la cual se aplica la tecnica divide y venceras
     * @param p Arreglo con todos los puntos ingresados
     * @param inf Parte inferior del array(Desde donde empezar)
     * @param sup Parte Superior del array(Hasta donde ir)
     * @return El par de puntos mas cercano
     */
    private ParPuntos divideYvenceras(Point[] p, int inf, int sup) {

        if ((sup - inf) <= 2)
            return fuerzaBruta(p, inf, sup);

        int medio = (inf + sup) / 2;
        int xMed = p[medio].x;

        // parIzquierda Representa el par de puntos con menor distancia de la parte izquierda de la division
        ParPuntos parIzquierda = divideYvenceras(p, inf, medio); // Evalua la parte izquierda
        // parDerecha Representa el par de puntos con menor distancia de la parte dercha de la division
        ParPuntos parDerecha = divideYvenceras(p, medio + 1, sup); // Evalua la parte derecha

        // parResult Representa el par de puntos mas cercano entre el par izquierdo y el derecho
        ParPuntos parResult = minDistancia(parIzquierda, parDerecha);
        
        // Se buscan los puntos que quedaron separados por la division, y que pudene estar mas cerca que 
        // los que quedaron a cada lado de la division
        Point[] p1 = Arrays.copyOfRange(p, inf, sup + 1); // Se hace un array con la cantidad de puntos evaluados
        ArrayList<Point> tempList = new ArrayList<>(); // Lista de puntos temporal en la que se almacenan los que podrian ser menores
        Arrays.sort(p1, new OrdenPointY()); // Se ordena el nuevo array por la posicion Y
        for(int i = inf; i < p1.length; i++){
            if(Math.abs(xMed - ((Point)p1[i]).x) < parResult.distancia()){
                tempList.add(p1[i]);
            }
        }
        
        for(int i = 0; i < tempList.size() - 1; i++){
            Point pTemp1 = tempList.get(i);
            for(int j = i + 1; j < tempList.size(); j++){
                Point pTemp2 = tempList.get(j);
                ParPuntos parTemp = new ParPuntos(pTemp1, pTemp2);
                if(parTemp.distancia() < parResult.distancia())
                    // Si el punto es menor se actualiza el resultado a retornar
                    parResult = parTemp;
            }
        }
                
        return parResult;
    }

    /**
     * Valida la distancia que existe entre dos pares para retornar el de menor distancia
     * @param parIzquierda par de puntos izquierdo
     * @param parDerecha par de puntos derecho
     * @return retorna el par de puntos cuya distancia sea menor
     */
    ParPuntos minDistancia(ParPuntos parIzquierda, ParPuntos parDerecha) {
        return (parIzquierda.distancia() - parDerecha.distancia()) < 0 ? parIzquierda : parDerecha; 
    }

    /**
     * Algortimo Voraz para encontrar la menor distancia entre dos puntos
     * @param p Arreglo con los puntos
     * @param inf Posicion inferior de donde inicar el recorrido
     * @param sup Posicion final hasta donde terminar el recorrido
     * @return Par de puntos con la distancia mas cercana
     */
    private ParPuntos fuerzaBruta(Point[] p, int inf, int sup){
        int rango = sup -  inf;
        if(rango < 1)
            return null;
        ParPuntos parOrigen = new ParPuntos(p[inf], p[inf + 1]);
        if(rango > 1){
            for(int i = inf; i < sup; i++){
                for(int j = i + 1; j < sup + 1; j++){
                    ParPuntos parComparacion = new ParPuntos(p[i], p[j]);
                    if(parComparacion.distancia() < parOrigen.distancia())
                        parOrigen = parComparacion;
                }
            }
        }
        return parOrigen;
    }    

    /**
     * Clase que implementa la interfaz Comparator para realizar la ordenacion
     * del array por la posicion x del punto
     */
    class OrdenPointX implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            return o1.x - o2.x;
        }

    }
    
    class OrdenPointY implements Comparator<Point>{

        @Override
        public int compare(Point o1, Point o2) {
            return o1.y - o2.y;
        }
        
    }
    
    /**
     * Clase para almacenar el par de puntos
     */
    class ParPuntos{
        private Point puntoA;
        private Point puntoB;
        
        public ParPuntos(Point puntoA, Point puntoB){
            this.puntoA = puntoA;
            this.puntoB = puntoB;
        }
                
        public double distancia(){
            return getPuntoA().distance(getPuntoB());
        }

        /**
         * @return the puntoA
         */
        public Point getPuntoA() {
            return puntoA;
        }

        /**
         * @param puntoA the puntoA to set
         */
        public void setPuntoA(Point puntoA) {
            this.puntoA = puntoA;
        }

        /**
         * @return the puntoB
         */
        public Point getPuntoB() {
            return puntoB;
        }

        /**
         * @param puntoB the puntoB to set
         */
        public void setPuntoB(Point puntoB) {
            this.puntoB = puntoB;
        }
        
        @Override
        public String toString(){
            return "[(" + puntoA.x + "," + puntoA.y + "),(" + puntoB.x + "," + puntoB.y + ")]";
        }
    }
}
