/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

/**
 *
 * @author CRISTIAN
 */
public class Esquema {

    Estruc estruc;//estructura para almacenar los nodos
    RNodos rNodos;
    int numGenerados;//Número total de nodos generados
    int numAnalizados;//Número total de nodos analizados
    int numPodados;//Número total de nodos podados.
    int tamaño;
    javax.swing.JTextField txtNA;
    javax.swing.JTextField txtNG;
    javax.swing.JTextField txtNP;

    public Esquema(int tamaño,
            javax.swing.JTextField txtNA,
            javax.swing.JTextField txtNG,
            javax.swing.JTextField txtNP) {
        this.tamaño = tamaño;
        this.estruc = new Estruc();
        this.rNodos = new RNodos(this.tamaño);
        this.numGenerados = 0;
        this.numAnalizados = 0;
        this.numPodados = 0;
        this.txtNA = txtNA;
        this.txtNG = txtNG;
        this.txtNP = txtNP;
    }

    public RNodo RyP_una() {
        Estructura e = estruc.crear();
        RNodo n = rNodos.nodoInicial();//primer nodo vivo en curso
        RNodo[] hijos = new RNodo[this.tamaño];//Hijos del nodo
        this.iniHijos(hijos);
        estruc.añadir(e, n);
        int numHijos = 0;

        while (!estruc.esVacia(e)) {
            n = estruc.extraer(e);
            this.numAnalizados++;
            numHijos = rNodos.expandir(n, hijos);
            this.numGenerados++;
            numHijos++;
//            this.rNodos.eliminar(n);
            for (int i = 1; i < numHijos; i++) {
//                if(this.rNodos.esAceptable(hijos[i])){
                if (this.rNodos.esSolucion(hijos[i])) {
//                    for (int j = 0; j < numHijos; j++) {//Elimina el resto de hijos
//                        if (i != j) {
//                            this.rNodos.eliminar(n);
//                        }
//
//                    }
//                    this.estruc.destruir(e);
                    return hijos[i];
                } else {
                    this.estruc.añadir(e, hijos[i]);
                }
//                }else{
//                    this.rNodos.eliminar(n);
//                    this.numPodados ++;
//                }
            }

        }
        this.estruc.destruir(e);
        this.txtNG.setText("" + this.numGenerados);
        this.txtNA.setText("" + this.numAnalizados);
        this.txtNP.setText("" + this.numPodados);
        return rNodos.noHaySolucion();
    }

    //inicializar lista de hijos
    private void iniHijos(RNodo[] hijos) {
        for (int i = 0; i < hijos.length; i++) {
            hijos[i] = null;
        }
    }
}
