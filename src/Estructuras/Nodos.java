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
public interface Nodos {
int MAXHIJOS = 8; //(* numero maximo de hijos de un nodo *) 
//TYPE nodo; 
public Nodo nodoInicial(); //(* raiz del arbol *) 
public int expandir(Nodo n, Nodo[] hijos); //RAMIFICACIÓN Y PODA 261 
public boolean esAceptable(Nodo n); 
public boolean esSolucion(Nodo n); 
public int h(Nodo n); 
public void ponerCota(int c); 
public int valor(Nodo n); 
public void eliminar(Nodo n); 
public Nodo noHaySolucion(); 
public void Imprimir(Nodo n); 

}
