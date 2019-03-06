/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Tapia
 */
public class ListaPedido implements Serializable {
     private Vector<Pedido> Lista;

    public ListaPedido() {
        Lista = new Stack<>();
    }

    public Vector<Pedido> getLista() {
        return Lista;
    }

    public void setLista(Vector<Pedido> lista) {
        Lista = lista;
    }

    public void pushProducto(Pedido p) {
        Lista.add(p);
    }

    public int getTamLista(){
        return Lista.size();
    }
    
    public void UneLista(Vector<Pedido> Lista){
        this.Lista.addAll(Lista);
    }
    
    public void LimpiaLista(){
        this.Lista.clear();
    }
    
}
