package cliente;

import classes.ListaProducto;
import classes.Producto;

import javax.swing.*;
import java.io.*;
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
            objetoEntrada = new ObjectInputStream(socketCliente.getInputStream());
            ListaProducto Lista = (ListaProducto) objetoEntrada.readObject();

            System.out.println("Objeto recibido");
            /* SE TRABAJA EL OBJETO */
            for (Producto i : Lista.getLista()){
                System.out.println(i.getNombreProducto());
                System.out.println(i.getDescripcion());
                System.out.println(i.getPrecio());
            }

            /* CREAMOS UN NUEVO PRODUCTO CON LAS PARAMETROS RESPECTIVOS */
            File ar = new File("src/imgs/p1.jpg");
            ImageIcon imagen = new ImageIcon(ar.getAbsolutePath());
            Producto p = new Producto("Producto x", "Descripcion x", 100, imagen);

            /* LO AÑADIMOS A LA LISTA */
            Lista.pushProducto(p);

            /* REENVIAMOS EL OBJETO YA ACTUALIZADO */
            objetoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
            objetoSalida.writeObject(Lista);
            objetoSalida.flush();
            socketCliente.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
