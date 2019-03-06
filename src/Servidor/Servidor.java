package Servidor;

import Clases.ListaProducto;
import Clases.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Servidor {

    public static void main(String[] args) {
        IniciarServidor();
    }

    public static void IniciarServidor() {
        ServidorGUI GUI = new ServidorGUI();
        AgregarProducto Agregar = new AgregarProducto();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    // Modificamos la apariencia.
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                GUI.setTitle("Servidor");
                GUI.setVisible(true);
            }
        });

        /* DECLARAMOS LOS OBJETOS */
        ObjectOutputStream objetoSalida;
        ObjectInputStream objetoEntrada;

        ListaProducto Lista = new ListaProducto();
        Lista = CargarDatos(Lista);
        GUI.MostrarDatos(Lista);

        try {
            String filename = "datos.out";
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(Lista);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            /* PUERTO POR EL QUE ESCUCHA */
            ServerSocket socketServidor = new ServerSocket(9090);
            System.out.println("Servidor iniciado...");

            while (true) {

                /* ESCUCHA UNA CONEXION A ESTE SOCKET Y LA ACEPTA */
                Socket socketCliente = socketServidor.accept();

                /* LEEMOS EL OBJETO DEL .OUT */
                FileInputStream miarchivo = new FileInputStream(new File("datos.out").getAbsolutePath());
                ObjectInputStream LeerObjeto = new ObjectInputStream(miarchivo);
                Lista = (ListaProducto) LeerObjeto.readObject();
                LeerObjeto.close();

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
                GUI.MostrarDatos(Lista);

                System.out.println("Objeto recibido...");
                for (Producto i : Lista.getLista()) {
                    System.out.println(i.getNombreProducto());
                    System.out.println(i.getDescripcion());
                    System.out.println(i.getPrecio());
                    System.out.println(i.getCantidad());
                    System.out.println(i.getCategoria());
                }

                /* LOS GUARDAMOS EN UN .OUT */
                ObjectOutputStream GuardarObjeto = new ObjectOutputStream(new FileOutputStream("datos.out"));
                GuardarObjeto.writeObject(Lista);
                GuardarObjeto.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ListaProducto CargarDatos(ListaProducto Lista) {

        /*Laptops*/
        ImageIcon imagen = new ImageIcon(new File("src/Imagenes/p1.jpg").getAbsolutePath());
        Producto p1 = new Producto("Producto 1", "Descripcion 1", 100, imagen, 10, "Laptops");

        imagen = new ImageIcon(new File("src/Imagenes/p2.jpg").getAbsolutePath());
        Producto p2 = new Producto("Producto 2", "Descripcion 2", 200, imagen, 20, "Laptops");

        imagen = new ImageIcon(new File("src/Imagenes/p3.jpg").getAbsolutePath());
        Producto p3 = new Producto("Producto 3", "Descripcion 3", 300, imagen, 10, "Laptops");

        imagen = new ImageIcon(new File("src/Imagenes/p4.jpg").getAbsolutePath());
        Producto p4 = new Producto("Producto 4", "Descripcion 4", 400, imagen, 10, "Laptops");

        imagen = new ImageIcon(new File("src/Imagenes/p5.jpg").getAbsolutePath());
        Producto p5 = new Producto("Producto 5", "Descripcion 5", 500, imagen, 5, "Laptops");

        //Monitores
        imagen = new ImageIcon(new File("src/Imagenes/m1.jpg").getAbsolutePath());
        Producto p6 = new Producto("Dell P2417H Professional VGA, HDMI & DP Ports, Adjustable base",
                "23.8 Pulgadas 250 ", 5668, imagen, 10, "Monitores");

        imagen = new ImageIcon(new File("src/Imagenes/m2.jpg").getAbsolutePath());
        Producto p7 = new Producto("BenQ RL2455S Monitor 1920 x 1080 Pixels, 16:9, 2 HDMI, 0 USB, 60 Hz",
                "BenQ ZOWIE RL2455 60,96cm ", 4863, imagen, 20, "Monitores");

        imagen = new ImageIcon(new File("src/Imagenes/m3.jpg").getAbsolutePath());
        Producto p8 = new Producto("Viewsonic TD2220  Full HD 1080p, 1920 x 1080, DVI-D, 2x USB 2.0, color Negro",
                "U relación de contraste dinámico ", 5099, imagen, 10, "Monitores");

        imagen = new ImageIcon(new File("src/Imagenes/m4.jpg").getAbsolutePath());
        Producto p9 = new Producto("Samsung - Monitor LED SAMSUNG S22F350FHL",
                "Monitor de Samsung, 22\" Full HD", 1929, imagen, 10, "Monitores");

        imagen = new ImageIcon(new File("src/Imagenes/m5.jpg").getAbsolutePath());
        Producto p10 = new Producto("BenQ GW2280 LED Full HD, HDMIx2, 5ms",
                "Diagonal de la pantalla: 54,6 cm ", 2098, imagen, 5, "Monitores");

        imagen = new ImageIcon(new File("src/Imagenes/s1.png").getAbsolutePath());
        Producto p11 = new Producto("PANDA DOME ESSENTIAL 2019 Version 1",
                "Protege tu red ", 2098, imagen, 5, "Antivirus");
        imagen = new ImageIcon(new File("src/Imagenes/s2.png").getAbsolutePath());
        Producto p12 = new Producto("PANDA DOME ESSENTIAL 2019 Version 2",
                "Navega sin preocupaciones ", 3008, imagen, 5, "Antivirus");
        imagen = new ImageIcon(new File("src/Imagenes/s3.png").getAbsolutePath());
        Producto p13 = new Producto("PANDA DOME ESSENTIAL 2019 Version 3",
                "Navega sin preocupaciones  ", 2098, imagen, 5, "Antivirus");
        imagen = new ImageIcon(new File("src/Imagenes/s4.png").getAbsolutePath());
        Producto p14 = new Producto("PANDA DOME ESSENTIAL 2019 Version 4",
                "Protege tu red", 2098, imagen, 5, "Antivirus");

        imagen = new ImageIcon(new File("src/Imagenes/s4.png").getAbsolutePath());
        Producto p15 = new Producto("Producto 15",
                "Protege tu red", 2098, imagen, 5, "Tablets");
        imagen = new ImageIcon(new File("src/Imagenes/s4.png").getAbsolutePath());
        Producto p16 = new Producto("Producto 16",
                "Protege tu red", 2098, imagen, 5, "Tablets");
        imagen = new ImageIcon(new File("src/Imagenes/s4.png").getAbsolutePath());
        Producto p17 = new Producto("Producto 17",
                "Protege tu red", 2098, imagen, 5, "Tablets");
        imagen = new ImageIcon(new File("src/Imagenes/s4.png").getAbsolutePath());
        Producto p18 = new Producto("Producto 18",
                "Protege tu red", 2098, imagen, 5, "Tablets");

        imagen = new ImageIcon(new File("src/Imagenes/s4.png").getAbsolutePath());
        Producto p19 = new Producto("Producto 20",
                "Descripcion para videojuegos", 2098, imagen, 5, "Videojuegos");
        imagen = new ImageIcon(new File("src/Imagenes/s4.png").getAbsolutePath());
        Producto p20 = new Producto("Producto 21",
                "Descripcion para videojuegos", 2098, imagen, 5, "Videojuegos");
        imagen = new ImageIcon(new File("src/Imagenes/s4.png").getAbsolutePath());
        Producto p21 = new Producto("Producto 22",
                "Descripcion para videojuegos", 2098, imagen, 5, "Videojuegos");
        imagen = new ImageIcon(new File("src/Imagenes/s4.png").getAbsolutePath());
        Producto p22 = new Producto("Producto 23",
                "Descripcion para videojuegos", 2098, imagen, 5, "Videojuegos");

        Lista.pushProducto(p1);
        Lista.pushProducto(p2);
        Lista.pushProducto(p3);
        Lista.pushProducto(p4);
        Lista.pushProducto(p5);
        Lista.pushProducto(p6);
        Lista.pushProducto(p7);
        Lista.pushProducto(p8);
        Lista.pushProducto(p9);
        Lista.pushProducto(p10);
        Lista.pushProducto(p11);
        Lista.pushProducto(p12);
        Lista.pushProducto(p13);
        Lista.pushProducto(p14);
        Lista.pushProducto(p15);
        Lista.pushProducto(p16);
        Lista.pushProducto(p17);
        Lista.pushProducto(p18);
        Lista.pushProducto(p19);
        Lista.pushProducto(p20);
        Lista.pushProducto(p21);
        Lista.pushProducto(p22);

        return Lista;
    }
}
