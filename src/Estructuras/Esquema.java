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
    Estructuras.Cola estruc;
    int numGenerados;
    int numAnalizados;
    int numPodados;
    int tamaño;
    private javax.swing.JTextField txtNA;
    private javax.swing.JTextField txtNG;
    private javax.swing.JTextField txtNP;

    public Esquema(int tamaño,
            javax.swing.JTextField txtNA,
            javax.swing.JTextField txtNG,
            javax.swing.JTextField txtNP) {
        this.numGenerados = 0;
        this.numAnalizados = 0;
        this.numPodados = 0;
        this.tamaño = tamaño;
        this.txtNA = txtNA;
        this.txtNG = txtNG;
        this.txtNP = txtNP;
    }

    public int RyP_una(Nodo nodo, Estructuras.Estruc estruc,
            Estructuras.Estructura e, Estructuras.Nodos nodos) { //(* encuentra la primera solucion *) 
        Nodo n; //(* nodo vivo en curso *)   
        Nodo[] hijos = new Nodo[this.tamaño]; //(* hijos de un nodo *)
        int numHijos = 0;
        e = estruc.crear(); //(* inicializamos las estructuras *) 
        n = nodos.nodoInicial();
        estruc.añadir(e, n, nodos.h(n)); //(*h es la funcion de coste*) 
        while (!estruc.esVacia(e)) {
            n = estruc.extraer(e);
            this.numAnalizados++;
            numHijos = nodos.expandir(n, hijos);
            this.numGenerados++;
//            System.out.println("numHijos: " + numHijos);
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
                        ((Reinas2.Nodos)nodos).copiar(hijos[i], nodo);
                        this.imprimir(hijos[i].getSolucion());
                        return 1; //(* devolvemos la solucion *) 

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
//        estruc.destruir(e);
        return 0;
    }

    private void imprimir(int[] s) {
        this.txtNA.setText("" + this.numGenerados);
        this.txtNG.setText("" + this.numAnalizados);
        this.txtNP.setText("" + this.numPodados);
        System.out.println("RESPUESTA");
        for (int i = 0; i < tamaño; i++) {
                System.out.print(" ," + s[i]);
            }
    }
}
