package cliente;

import classes.ListaProducto;
import classes.Producto;

import javax.swing.*;
import java.awt.*;
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
        int port = 9999;

        try {

            /* CREAMOS UN SOCKET TCP Y LO CONECTAMOS A LA MAQUINA ESPECIFICA */
            Socket socketCliente = new Socket(host, port);
            System.out.println("Conexion establecida...");

            /* INICIALIZAMOS LOS OBJETOS DE ENTRADA Y SALIDA */
            objetoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
            objetoEntrada = new ObjectInputStream(socketCliente.getInputStream());

            /* CREAMOS UN NUEVO PRODUCTO CON LAS PARAMETROS RESPECTIVOS */
            //Image imagen = new ImageIcon("p1.png").getImage();
            Producto p = new Producto("Producto 1","Descripcion 1",50);

            /* LO AÑADIMOS A LA LISTA */
            ListaProducto Lista = new ListaProducto();
            Lista.pushProducto(p);

            /* ESCRIBIMOS UN OBJETO EN EL FLUJO */
            objetoSalida.writeObject(Lista);
            objetoSalida.flush();

            /* RECIBIMOS EL OBJETO */
            Lista = (ListaProducto) objetoEntrada.readObject();

            /*
            Ejemplo:
             */
            /* CREAMOS UN NUEVO PRODUCTO PARA RECIBIR EL OBJETO DE TIPO USUARIO
            System.out.println("Preparado para recibir respuesta");
            Usuario usuario2 = (Usuario) objetoEntrada.readObject();
            System.out.println("Objeto recibido... Extrayendo datos");
            System.out.print("Nombre: " + usuario2.getNombre() + "\nA. paterno: " + usuario2.getApaterno()
                    + "\nA. materno: " + usuario2.getAmaterno() + "\nPassword: " + usuario2.getPassword() + "\nEdad: "
                    + usuario2.getEdad() + "\n");
            */
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
