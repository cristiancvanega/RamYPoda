/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas2;

import Estructuras.Nodo;
import java.util.LinkedList;

/**
 *
 * @author CRISTIAN
 */
public class Nodos implements Estructuras.Nodos {

    int N;
    boolean pPasada;

    public Nodos(int N) {
        this.N = N;
        this.pPasada = true;
    }

    @Override
    public Nodo nodoInicial() {
        Nodo n = new Nodo(this.N);
//        n.getSolucion()[0] = -1;
        return n;
    }

    @Override
    public int expandir(Nodo n, Nodo[] hijos) {
//        this.imprimeNodoAExpandir(n);
        int nHijos = 0;
        Nodo p;
        int i = n.getK() + 1;
//        if (this.pPasada == true) {
//            for (int j = 1; j < this.N; j++) {
////                if (this.esKPrometedor(n.getSolucion(), i, j)) {
//                nHijos++;
//                p = new Nodo(this.N);
//                this.copiar(n, p);
//                p.getSolucion()[i - 1] = j;
//                p.incK();
//                hijos[nHijos - 1] = p;
//                this.imprimeHijos(hijos, nHijos);
////                }
//            }
//            System.out.println("la cagada \nla cagada\nla cagada\nla cagada\nla cagada" + this.pPasada);
//            this.pPasada = false;
//        } else {
            if (i > this.N) {
                return nHijos;//Caso especial
            }
            for (int j = 1; j < this.N; j++) {
                if (this.esKPrometedor(n.getSolucion(), i, j)) {
                    nHijos++;
                    p = new Nodo(this.N);
                    this.copiar(n, p);
                    p.getSolucion()[i] = j;
                    p.incK();
                    hijos[nHijos - 1] = p;
                }
            }
//        this.imprimeHijos(hijos, nHijos);
//        }
        return nHijos;
    }

    private boolean esKPrometedor(int[] s, int k, int j) {
//        if(k == 1)
//            return true;
        for (int i = 0; i <= k; i++) {
            if ((s[i] == j) || valABS(s[i], j) == valABS(i, k)) {
                return false;
            }
        }
        return true;
    }

    private void imprimeNodoAExpandir(Nodo n) {
        int[] s = n.getSolucion();
        System.out.println("######imprimeNodoAExpandir(n)");
        for (int i = 0; i < s.length; i++) {
            System.out.print(", " + s[i]);
        }
        System.out.println("");
        System.out.println("######imprimeNodoAExpandir(n)");
    }

    private void imprimeHijos(Nodo[] hijos, int nHijos) {
        System.out.println("\nhijos la cagada");
        for (int i = 0; i < nHijos; i++) {
            for (int j = 0; j < this.N; j++) {
                System.out.print(", " + hijos[i].getSolucion()[j]);
            }
            System.out.println("###############\n");
        }
    }

    @Override
    public void copiar(Nodo n1, Nodo n2) {
        n2.setSolucion(n1.getSolucion());
        n2.setK(n1.getK());
    }

    private boolean esKPrometedor(int[] s, int k) {
        for (int i = 1; i < k; i++) {
            if (s[i] == s[k]
                    || this.valABS(s[i], s[k]) == this.valABS(i, k)) {
                System.out.println("true");
            }
            return false;
        }
        System.out.println("false");
        return true;
    }

    private int valABS(int a, int b) {
        if (a > b) {
            return a - b;
        } else {
            return b - a;
        }
    }

    @Override
    public boolean esAceptable(Nodo n) {
        return n != null;
    }

    @Override
    public boolean esSolucion(Nodo n) {
//        if(n == null)
//            return false;
        return n.getK() == this.N - 1;
    }

    @Override
    public int h(Nodo n) {
        return 0;
    }

    @Override
    public void ponerCota(int c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int valor(Nodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Nodo n) {
        n = null;
    }

    @Override
    public Nodo noHaySolucion() {
        return null;
    }

    @Override
    public void Imprimir(Nodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
