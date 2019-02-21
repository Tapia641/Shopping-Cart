package servidor;

import classes.ListaProducto;
import classes.Producto;

import java.io.*;
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

        ListaProducto Lista = new ListaProducto();

        try {
            String filename = "objetos.out";
            ListaProducto person = new ListaProducto();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(person);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {

            /* PUERTO POR EL QUE ESCUCHA */
            ServerSocket socketServidor = new ServerSocket(9090);
            System.out.println("Servidor iniciado...");

            while (true) {

                /* LEEMOS EL OBJETO DEL .OUT */
                FileInputStream miarchivo = new FileInputStream(new File("objetos.out").getAbsolutePath());
                ObjectInputStream LeerObjeto = new ObjectInputStream(miarchivo);
                Lista = (ListaProducto) LeerObjeto.readObject();
                LeerObjeto.close();

                /* ESCUCHA UNA CONEXION A ESTE SOCKET Y LA ACEPTA */
                Socket socketCliente = socketServidor.accept();

                /* RECIBIMOS INFORMACION DEL CLIENTE */
                System.out.println("Cliente conectado desde " + socketCliente.getInetAddress() + " : " + socketCliente.getPort());



                /* ENVIAMOS EL OBJETO */
                objetoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
                System.out.println("Enviando objeto...");
                objetoSalida.writeObject(Lista);
                objetoSalida.flush();


                /* DAMOS ENTRADA AL OBJETO YA ACTUALIZADO */
                objetoEntrada = new ObjectInputStream(socketCliente.getInputStream());
                Lista = (ListaProducto) objetoEntrada.readObject();

                /* RECIBIMOS EL OBJETO ACTUALIZADO */
                System.out.println("Objeto recibido...");
                for (Producto i : Lista.getLista()){
                    System.out.println(i.getNombreProducto());
                    System.out.println(i.getDescripcion());
                    System.out.println(i.getPrecio());
                }

                /* LOS GUARDAMOS EN UN .OUT */
                ObjectOutputStream GuardarObjeto = new ObjectOutputStream(new FileOutputStream("objetos.out"));
                GuardarObjeto.writeObject(Lista);
                GuardarObjeto.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
