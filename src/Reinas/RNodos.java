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
public class RNodos implements Nodos {

    private int tamaño;

    public RNodos(int tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public RNodo nodoInicial() {
        RNodo n = new RNodo(this.tamaño);
        for (int i = 0; i < this.tamaño; i++) {
            n.getSolucion()[i] = 0;
            System.out.print(" " + n.getSolucion()[i]);
        }
        System.out.println("");
        return n;
    }

    @Override
    public int expandir(RNodo n, RNodo[] hijos) {
        int nHijos = 0;
        RNodo p = new RNodo(0);
        if(n == null)
            System.out.println("n es null");
        int i = n.getK() + 1;
        if (i > this.tamaño) {
            return nHijos;
        }

        for (int j = 1; j < this.tamaño; j++) {
            if (this.esKPrometedor(n.getSolucion(), i - 1, j)) {
                nHijos++;
                this.copiar(n, p);
                p.getSolucion()[i] = j;
                p.incK();
                System.out.println("Tamaño hijos: " + hijos.length
                + ", tamaño nHijos: " + nHijos);
                hijos[nHijos-1] = p;
            }
        }

        return nHijos;
    }

    //duplica un nodo
    private void copiar(RNodo n, RNodo p) {
        p.setSolucion(n.getSolucion());
        p.setK(n.getK());
    }

    private boolean esKPrometedor(int[] s, int k, int j) {
        for (int i = 1; i < k; i++) {
            if (s[i] == j || this.valABS(s[i], j) == (k + 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //calcula el valor absoluto de la diferencia de dos enteros no negativo
    private int valABS(int a, int b) {
        if (a > b) {
            return a - b;
        } else {
            return b - a;
        }
    }

    @Override
    public boolean esAceptable(RNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esSolucion(RNodo n) {
        if (n == null){
            System.out.println("El nodo es null");
        }
        if(n.getK() == this.tamaño)
            return true;
        return false;
    }

    @Override
    public int h(RNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ponerCota(int c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int valor(RNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(RNodo n) {
        n = null;
    }

    @Override
    public RNodo noHaySolucion() {
        return null;
    }

    @Override
    public void imprimir(RNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
