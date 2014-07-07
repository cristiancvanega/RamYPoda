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
public class Nodo {

    private int N; //Dimensión del tablero
    private int[] solucion; //Solución del preoblema hasta este nodo
    private int k; //nivel del nodo

    public Nodo(int N) {
        this.N = N;
        this.k = 0;
        this.iniciar();
    }

    private void iniciar() {
        this.solucion = new int[this.N];
        for (int i = 0; i < this.N; i++) {
            this.solucion[i] = 0;
        }
    }

    /**
     * @return the N
     */
    public int getN() {
        return N;
    }

    /**
     * @param N the N to set
     */
    public void setN(int N) {
        this.N = N;
    }

    /**
     * @return the solucion
     */
    public int[] getSolucion() {
        return solucion;
    }

    /**
     * @param solucion the solucion to set
     */
    public void setSolucion(int[] solucion) {
        for (int i = 0; i < solucion.length; i++) {
            this.solucion[i] = solucion[i];
            
        }
//        System.arraycopy(solucion, 0, this.solucion, 0, this.N);
    }

    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        this.k = k;
    }
    
    public void incK(){
        this.k++;
    }
}
