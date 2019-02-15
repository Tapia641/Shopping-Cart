package servidor;

import classes.ListaProducto;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        iniciarServidor();
    }
    public static void iniciarServidor() {

        /* DECLARAMOS LOS OBJETOS */
        ObjectOutputStream objetoSalida;
        ObjectInputStream objetoEntrada;

        try {

            /* PUERTO POR EL QUE ESCUCHA */
            ServerSocket socketServidor = new ServerSocket(9999);
            System.out.println("Servidor iniciado...");

            while (true) {
                /* ESCUCHA UNA CONEXION A ESTE SOCKET Y LA ACEPTA */
                Socket socketCliente = socketServidor.accept();

                /* RECIBIMOS INFORMACION DEL CLIENTE */
                System.out.println("Cliente conectado desde " + socketCliente.getInetAddress() + " : " + socketCliente.getPort());

                /* INICIALIZAMOS LOS OBJETOS DE ENTRADA Y SALIDA */
                objetoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
                objetoEntrada = new ObjectInputStream(socketCliente.getInputStream());

                /* RECIBIMOS EL OBJETO DE  LISTA_PRODUCTO */
                System.out.println("Objeto recibido...");
                ListaProducto Lista = (ListaProducto) objetoEntrada.readObject();

                /* LOS GUARDAMOS EN UN .OUT */
                objetoSalida = new ObjectOutputStream(new FileOutputStream("objetos.out"));
                objetoSalida.writeObject(Lista);

                /* REENVIAMOS EL OBJETO*/
                System.out.println("Devolviendo objeto...");
                objetoSalida.writeObject(Lista);
                objetoSalida.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
