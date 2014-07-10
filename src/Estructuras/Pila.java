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
public class Pila implements Estructuras.Estruc {
    
    @Override
    public Estructura crear() {
        return new Estructura();
    }

    @Override
    public void añadir(Estructura h, Nodo nodo, int prioridad) {
        System.out.println("añadir");
        for (int i = 0; i < nodo.getSolucion().length; i++) {
            System.out.print(", " + nodo.getSolucion()[i]);
        }
        System.out.println("");
            h.addLast(nodo);
    }

    @Override
    public Nodo extraer(Estructura h) {
        System.out.println("rebovido-pila");
        return h.removeLast();
    }

    @Override
    public boolean esVacia(Estructura h) {
        return h.isEmpty();
    }

    @Override
    public int tamaño(Estructura h) {
        return h.size();
    }

    @Override
    public void destruir(Estructura h) {
        h = null;
    }

}
