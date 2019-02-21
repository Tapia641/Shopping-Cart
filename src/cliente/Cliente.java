package cliente;

import classes.ListaProducto;
import classes.Producto;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        iniciarCliente();
    }

    public static void iniciarCliente() {

        /* DECLARAMOS LOS OBJETOS */
        ObjectOutputStream objetoSalida;
        ObjectInputStream objetoEntrada;

        /* REALIZAMOS LAS CONFIGURACIONES DE CONEXIÓN */
        String host = "127.0.0.1";// localhost
        int port = 9090;

        try {

            /* CREAMOS UN SOCKET TCP Y LO CONECTAMOS A LA MAQUINA ESPECIFICA */
            Socket socketCliente = new Socket(host, port);
            System.out.println("Conexion establecida...");

            /* INICIALIZAMOS LOS OBJETOS DE ENTRADA Y SALIDA */
            objetoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
            objetoEntrada = new ObjectInputStream(socketCliente.getInputStream());

            /* CREAMOS UN NUEVO PRODUCTO CON LAS PARAMETROS RESPECTIVOS */
            //Image imagen = new ImageIcon("p1.png").getImage();
            Producto p = new Producto("Producto 1", "Descripcion 1", 50);

            /* LO AÑADIMOS A LA LISTA */
            ListaProducto Lista = new ListaProducto();
            Lista.pushProducto(p);

            /* ESCRIBIMOS UN OBJETO EN EL FLUJO */
            objetoSalida.writeObject(Lista);
            objetoSalida.flush();

            /* RECIBIMOS EL OBJETO */
            objetoEntrada = new ObjectInputStream(new FileInputStream("objetos.out"));
            Lista = (ListaProducto) objetoEntrada.readObject();
            System.out.println("Objeto recibido");

            for (Producto i : Lista.getLista()){
                System.out.println(i.getNombreProducto());
                System.out.println(i.getDescripcion());
                System.out.println(i.getPrecio());
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
