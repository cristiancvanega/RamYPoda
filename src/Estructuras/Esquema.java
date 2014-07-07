/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author CRISTIAN
 */
public class Esquema {

    // Falta Strings a imprimir
    Reinas2.Estruc estruc;
    Nodos nodos;//crear objeto nodos
    int numGenerados;
    int numAnalizados;
    int numPodados;
    int tamaño;

    public Esquema(int tamaño) {
        this.estruc = new Reinas2.Estruc();
        this.nodos = new Reinas2.Nodos(tamaño);
        this.numGenerados = 0;
        this.numAnalizados = 0;
        this.numPodados = 0;
        this.tamaño = tamaño;
    }

    public Nodo RyP_una() { //(* encuentra la primera solucion *) 
        Estructura e; //(* estructura para almacenar los nodos *) 
        Nodo n; //(* nodo vivo en curso *)   
        Nodo[] hijos = new Nodo[this.tamaño]; //(* hijos de un nodo *)
        int numHijos=0;
        e = estruc.crear(); //(* inicializamos las estructuras *) 
        n = nodos.nodoInicial();
        estruc.añadir(e, n, nodos.h(n)); //(*h es la funcion de coste*) 
        while (!estruc.esVacia(e)) {
            n = estruc.extraer(e);
            this.numAnalizados++;
            numHijos = nodos.expandir(n, hijos);
            this.numGenerados++;
            System.out.println("numHijos: " + numHijos);
            numHijos++;
//            nodos.eliminar(n);
            for (int i = 0; i < numHijos; i++) {
                if (nodos.esAceptable(hijos[i])) {
                    if (nodos.esSolucion(hijos[i])) {
//                        for (int j = 1; j < numHijos; j++) { //(*eliminamos resto de hijos*) 
//                            if (i != j) {
//                                nodos.eliminar(hijos[j]);
//                            }
//                        }
//                        estruc.destruir(e);
                        return hijos[i]; //(* devolvemos la solucion *) 
                    } else {
                        estruc.añadir(e, hijos[i], nodos.h(hijos[i]));
                    }
                } 
//                    else {
//                    nodos.eliminar(hijos[i]);
//                    this.numPodados++;
//                }
            }
        }
        estruc.destruir(e);
        this.imprimir();
        return nodos.noHaySolucion();
    }

    private void imprimir() {
        System.out.println("Generados: " + this.numGenerados);
        System.out.println("Analizados: " + this.numAnalizados);
        System.out.println("Podados: " + this.numPodados);
    }
}
