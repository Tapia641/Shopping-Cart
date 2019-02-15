package classes;

import java.io.Serializable;
import java.util.Stack;
import java.util.Vector;

public class ListaProducto  implements Serializable {

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
