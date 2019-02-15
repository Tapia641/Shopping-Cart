package classes;

import java.util.Stack;
import java.util.Vector;

public class ListaProducto {

    private Vector<Producto> Lista;

    public ListaProducto() {
        Lista = new Stack<>();
    }

    public Vector<Producto> getLista() {
        return Lista;
    }

    public void setLista(Vector<Producto> lista) {
        Lista = lista;
    }

    public void pushProducto(Producto p) {
        Lista.add(p);
    }

    public int getTamLista(){
        return Lista.size();
    }
}
