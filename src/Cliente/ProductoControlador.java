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
import static Cliente.Controlador.IniciarCliente;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.Icon;

/**
 *
 * @author Tapia
 */
public class ProductoControlador implements Initializable {

    @FXML
    private Label Titulo;
    @FXML
    private Label Descripcion;
    @FXML
    private Label Precio;
    @FXML
    private Label Cantidad;
    @FXML
    private ChoiceBox Disponibles;

    private ListaPedido ListaP = new ListaPedido();

    @FXML
    private ImageView Imagen;
    public Producto P = new Producto();

    public void initialize(URL url, ResourceBundle rb) {
        /* LOS GUARDAMOS EN UN .OUT */
        ObjectOutputStream GuardarObjeto = null;
        try {
            GuardarObjeto = new ObjectOutputStream(new FileOutputStream("pedidos.out"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            GuardarObjeto.writeObject(ListaP);
        } catch (IOException ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            GuardarObjeto.flush();
            GuardarObjeto.close();
        } catch (IOException ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            LeerArchivo();
        } catch (IOException ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LeerArchivo() throws FileNotFoundException, IOException, ClassNotFoundException {
        /* LEEMOS EL OBJETO DEL .OUT */
        FileInputStream miarchivo = new FileInputStream(new File("producto.out").getAbsolutePath());
        ObjectInputStream LeerObjeto = new ObjectInputStream(miarchivo);
        this.P = (Producto) LeerObjeto.readObject();
        LeerObjeto.close();

        System.err.println("Leido....");
        Titulo.setText(P.getNombreProducto());
        Descripcion.setText(P.getDescripcion());
        Precio.setText(Integer.toString(P.getPrecio()));
        Cantidad.setText(Integer.toString(P.getCantidad()));

        ObservableList<Integer> items = FXCollections.observableArrayList();
        for (int i = 0; i < P.getCantidad(); i++) {
            items.add(i + 1);
        }
        Disponibles.setItems(items);
        //System.out.println(P.getImagenMuestra().toString());
        //Imagen.setImage(new Image(P.getImagenMuestra().toString()));
    }

    public void ClickAgregar(javafx.scene.input.MouseEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        Integer cantidad = (Integer) Disponibles.getValue();
        int nuevo = P.getCantidad() - cantidad;
        if (nuevo <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Existencias agotadas");
            alert.setContentText("Ooops, se han agotado nuestras existencias :(");
            alert.showAndWait();
        } else {
            P.setCantidad(nuevo);

            /* LEEMOS EL OBJETO DEL .OUT */
            FileInputStream miarchivo = new FileInputStream(new File("pedidos.out").getAbsolutePath());
            try (ObjectInputStream LeerObjeto = new ObjectInputStream(miarchivo)) {
                //Creamos la clase pedido
                ListaP = (ListaPedido) LeerObjeto.readObject();
                Pedido n = new Pedido(P.getNombreProducto(), P.getPrecio(), P.getCantidad(), P.getCantidad() * P.getPrecio());
                ListaP.pushProducto(n);
            }

            /* LOS GUARDAMOS EN UN .OUT */
            ObjectOutputStream GuardarObjeto = new ObjectOutputStream(new FileOutputStream("pedidos.out"));
            GuardarObjeto.writeObject(ListaP);
            GuardarObjeto.flush();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("¡Excelente!");
            alert.setHeaderText(null);
            alert.setContentText("Artículo agregado correctamente!");

            alert.showAndWait();
        }
        System.out.println(cantidad);
        System.out.println(nuevo);

    }
}
