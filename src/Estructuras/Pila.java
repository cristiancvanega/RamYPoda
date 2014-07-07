/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.Estructura;
import Estructuras.Nodo;

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
            h.add(nodo);
    }

    @Override
    public Nodo extraer(Estructura h) {
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
