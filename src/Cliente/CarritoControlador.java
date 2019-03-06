/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Clases.ListaPedido;
import Clases.Pedido;
import Clases.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Tapia
 */
public class CarritoControlador implements Initializable {

    private static ListaPedido ListaP = new ListaPedido();
    private static Pedido P = new Pedido();
    @FXML private static Label Titulo;
    @FXML private static Label Cantidad;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
        
        try {
            LeerPedido();
        } catch (IOException ex) {
            Logger.getLogger(CarritoControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarritoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void LeerPedido() throws FileNotFoundException, IOException, ClassNotFoundException {
 /* LEEMOS EL OBJETO DEL .OUT */
        FileInputStream miarchivo = new FileInputStream(new File("pedido.out").getAbsolutePath());
        ObjectInputStream LeerObjeto = new ObjectInputStream(miarchivo);
        P = (Pedido) LeerObjeto.readObject();
        LeerObjeto.close();

        System.err.println("Leido....");
        System.out.println(P.getNombre());
        
        //Cantidad.setText(Integer.toString(P.getCantidad()));

        //ObservableList<Integer> items = FXCollections.observableArrayList();
        //for (int i = 0; i < P.getCantidad(); i++) {
          //  items.add(i + 1);
        //}
        //Disponibles.setItems(items);
        
        
    }

}
