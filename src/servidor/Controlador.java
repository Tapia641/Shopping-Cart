package servidor;

import classes.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controlador implements Initializable {

    /* INICIALIZAMOS LAS VARIABLES */
    @FXML private TableView<Producto> Tabla;
    @FXML private TableColumn<Producto, String> Nombre;
    @FXML private TableColumn<Producto, String> Descripcion;
    @FXML private TableColumn<Producto, Integer> Precio;
    @FXML private TableColumn<Producto, Image> Imagen;

    private ObservableList<Producto> datos;


    private void CargarDatos(){
        datos = Tabla.getItems();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        Descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        Precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        Imagen.setCellValueFactory(new PropertyValueFactory<>("imagen"));

        Tabla.setItems(GetProductos());
    }

    public ObservableList<Producto> GetProductos(){
        datos = FXCollections.observableArrayList(
                new Producto("Producto 1", "Descripcion 1", 10, new Image(new File("src/imgs/p1.jpg").toURI().toString())),
                new Producto("Producto 2", "Descripcion 2", 20, new Image(new File("src/imgs/p2.jpg").toURI().toString())),
                new Producto("Producto 3", "Descripcion 3", 30, new Image(new File("src/imgs/p3.jpg").toURI().toString())),
                new Producto("Producto 4", "Descripcion 4", 40, new Image(new File("src/imgs/p4.jpg").toURI().toString())),
                new Producto("Producto 5", "Descripcion 5", 50, new Image(new File("src/imgs/p5.jpg").toURI().toString()))
        );
        return datos;
    }


}
