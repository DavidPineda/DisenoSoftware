/**
 * Clase que evalua la distancia de puntos en el plano para retornar el par
 * mas cercano, por medio de la tecnica de divide y vencerar
 * 
 * Problema: Dado un conjunto de puntos en el plano cartesiano (x,y) el problema
 * es encontrar aquellos dos puntos que se encuentran más cerca el uno del otro.
 */
package co.edu.uniminuto.dyv;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

public class ParMasCercano {

    /**
     * Funcion publica encargada llamar el metodo de ordenacion del array y luego llamar al proceso principal
     * @param puntos Array con todos los puntos cargados
     * @return Retorna mensaje indicando cual fue el par mas cercano encontrado
     */    
    public String encontraPar(Point[] puntos){
        // Se ordena el array de acuerdo a la cordenada X
        Arrays.sort(puntos, new OrdenPoint());
        dyv(puntos, 0, puntos.length - 1);
        return "";
    }

    /**
     * Funcion recursiva en la cual se aplica la tecnica divide y venceras
     * @param p Arreglo con todos los puntos ingresados
     * @param inf Parte inferior del array(Desde donde empezar)
     * @param sup Parte Superior del array(Hasta donde ir)
     * @return El par de puntos mas cercano
     */
    private ParPuntos dyv(Point[] p, int inf, int sup) {

        if ((sup - inf) <= 1)
            return new ParPuntos(p[inf], p[sup]);

        int medio = (inf + sup) / 2;

        ParPuntos parIzquierda = dyv(p, inf, medio);
        ParPuntos parDerecha = dyv(p, medio + 1, sup);

        ParPuntos result = minDistancia(parIzquierda, parDerecha);
        return result;
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
     * Clase que implementa la interfaz Comparator para realizar la ordenacion
     * del array por la posicion x del punto
     */
    class OrdenPoint implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            return o1.x - o2.x;
        }

    }
    
    /**
     * Clase para almacenar el par de puntos
     */
    class ParPuntos{
        Point puntoA;
        Point puntoB;
        
        public ParPuntos(Point puntoA, Point puntoB){
            this.puntoA = puntoA;
            this.puntoB = puntoB;
        }
        
        public double distancia(){
            return puntoA.distance(puntoB);
        }
    }
}
