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
public interface Estruc {
//    public void estructura();
    public Estructura crear();
    public void añadir(Estructura h, Nodo nodo, int prioridad);
    public Nodo extraer(Estructura h);
    public boolean esVacia(Estructura h);
    public int tamaño(Estructura h);
    public void destruir(Estructura h);
}
