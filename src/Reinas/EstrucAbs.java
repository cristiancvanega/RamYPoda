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
public interface EstrucAbs {
//    public void estructura();
    public Estructura crear();
    public void añadir(Estructura h, RNodo nodo);
    public RNodo extraer(Estructura h);
    public boolean esVacia(Estructura h);
    public int tamaño(Estructura h);
    public void destruir(Estructura h);
}
