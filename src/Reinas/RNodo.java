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
public class RNodo {
    private int n; //dimensión del tablero
    private int[] solucion;//de tamaño n
    private int k;

    public RNodo(int n) {
        this.n = n;
        this.solucion = new int[n];
        this.k = 0;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
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
        this.solucion = solucion;
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
        this.k ++;
    }
}
