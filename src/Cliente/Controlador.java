/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Clases.ListaPedido;
import Clases.ListaProducto;
import Clases.Pedido;
import Clases.Producto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Controlador implements Initializable {

    @FXML
    private JFXButton Laptops;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label Titulo;

    @FXML
    JFXTextField Titulo2;

    public static ListaProducto Lista = new ListaProducto();
    public static ListaPedido ListaP = new ListaPedido();
    private static Pedido P = new Pedido();

    public void initialize(URL url, ResourceBundle rb) {
        IniciarCliente();
    }

    public static void IniciarCliente() {

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
            Lista = (ListaProducto) objetoEntrada.readObject();

            System.out.println("Objeto recibido");


            /* REENVIAMOS EL OBJETO YA ACTUALIZADO */
            objetoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
            objetoSalida.writeObject(Lista);
            objetoSalida.flush();
            socketCliente.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    public void ClickLaptops(javafx.scene.input.MouseEvent event) {
        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[this.Lista.getLista().size()];
        System.err.println(Lista.getLista().size());
        for (int i = 0; i < this.Lista.getTamLista(); i++) {
            if (Lista.getLista().get(i).getCategoria().equals("Laptops")) {
                try {
                    int j = i;
                    //Guardamos ese producto
                    String filename = "producto.out";
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
                    out.writeObject(Lista.getLista().get(i));

                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("Producto.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);
//                    Titulo2.setText(Lista.getLista().get(i).getNombreProducto());

                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    @FXML
    public void ClickMonitores(javafx.scene.input.MouseEvent event) {
        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[this.Lista.getLista().size()];
        System.err.println(Lista.getLista().size());
        for (int i = 0; i < this.Lista.getTamLista(); i++) {
            if (Lista.getLista().get(i).getCategoria().equals("Monitores")) {
                try {
                    int j = i;
                    //Guardamos ese producto
                    String filename = "producto.out";
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
                    out.writeObject(Lista.getLista().get(i));

                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("Producto.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);
//                    Titulo2.setText(Lista.getLista().get(i).getNombreProducto());

                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        System.out.println("Monitores");
    }

    @FXML
    public void ClickSoftware(javafx.scene.input.MouseEvent event) {
        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[this.Lista.getLista().size()];
        System.err.println(Lista.getLista().size());
        for (int i = 0; i < this.Lista.getTamLista(); i++) {
            if (Lista.getLista().get(i).getCategoria().equals("Software")) {
                try {
                    int j = i;
                    //Guardamos ese producto
                    String filename = "producto.out";
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
                    out.writeObject(Lista.getLista().get(i));

                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("Producto.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);
//                    Titulo2.setText(Lista.getLista().get(i).getNombreProducto());

                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        System.out.println("Software");
    }

    @FXML
    public void ClickAntivirus(javafx.scene.input.MouseEvent event) {
        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[this.Lista.getLista().size()];
        System.err.println(Lista.getLista().size());
        for (int i = 0; i < this.Lista.getTamLista(); i++) {
            if (Lista.getLista().get(i).getCategoria().equals("Antivirus")) {
                try {
                    int j = i;
                    //Guardamos ese producto
                    String filename = "producto.out";
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
                    out.writeObject(Lista.getLista().get(i));

                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("Producto.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);
//                    Titulo2.setText(Lista.getLista().get(i).getNombreProducto());

                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        System.out.println("Antivirus");
    }

    @FXML
    public void ClickTablets(javafx.scene.input.MouseEvent event) {
        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[this.Lista.getLista().size()];
        System.err.println(Lista.getLista().size());
        for (int i = 0; i < this.Lista.getTamLista(); i++) {
            if (Lista.getLista().get(i).getCategoria().equals("Tablets")) {
                try {
                    int j = i;
                    //Guardamos ese producto
                    String filename = "producto.out";
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
                    out.writeObject(Lista.getLista().get(i));

                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("Producto.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);
//                    Titulo2.setText(Lista.getLista().get(i).getNombreProducto());

                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        System.out.println("Tablets");
    }

    @FXML
    public void ClickVideojuegos(javafx.scene.input.MouseEvent event) {
                 pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[this.Lista.getLista().size()];
        System.err.println(Lista.getLista().size());
        for (int i = 0; i < this.Lista.getTamLista(); i++) {
            if (Lista.getLista().get(i).getCategoria().equals("Videojuegos")) {
                try {
                    int j = i;
                    //Guardamos ese producto
                    String filename = "producto.out";
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
                    out.writeObject(Lista.getLista().get(i));

                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("Producto.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);
//                    Titulo2.setText(Lista.getLista().get(i).getNombreProducto());

                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        System.out.println("Videojuegos");
    }

    @FXML
    public void ClickCarrito(javafx.scene.input.MouseEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {

        /* LEEMOS EL OBJETO DEL .OUT */
        FileInputStream miarchivo = new FileInputStream(new File("pedidos.out").getAbsolutePath());
        try (ObjectInputStream LeerObjeto = new ObjectInputStream(miarchivo)) {
            //Creamos la clase pedido
            ListaP = (ListaPedido) LeerObjeto.readObject();
        }

        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[this.ListaP.getLista().size()];
        System.err.println(ListaP.getLista().size());
        for (int i = 0; i < this.ListaP.getTamLista(); i++) {
            try {
                int j = i;
                //Guardamos ese pedido
                String filename = "pedido.out";
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
                out.writeObject(ListaP.getLista().get(i));

                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("Carrito.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);
//                    Titulo2.setText(Lista.getLista().get(i).getNombreProducto());

            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    
    
    @FXML
    public void ClickFinalizar(javafx.scene.input.MouseEvent event) throws IOException {
        
        pnl_scroll.getChildren().clear();
        Node nodes;
        nodes = (Node) FXMLLoader.load(getClass().getResource("Finalizar.fxml"));
        pnl_scroll.getChildren().add(nodes);
    }

}
