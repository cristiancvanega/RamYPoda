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
public interface Nodos {
    public RNodo nodoInicial();    
    public int expandir(RNodo n, RNodo[] hijos);
    public boolean esAceptable(RNodo n);
    public boolean esSolucion(RNodo n);
    public int h(RNodo n);
    public void ponerCota(int c);
    public int valor(RNodo n);
    public void eliminar(RNodo n);
    public RNodo noHaySolucion();
    public void imprimir(RNodo n);
}
