package servidor;

import classes.Producto;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;

import javafx.scene.control.TableView;

import java.io.File;

public class Controlador {
    /* INICIALIZAMOS LAS VARIABLES */

    @FXML
    private TableView<Producto> Tabla = new TableView();

    //https://docs.oracle.com/javafx/2/ui_controls/table-view.htm

    public void Controlador(){

    }
    public void CargarDatos(){

        TableColumn<Producto, String> Nombre = new TableColumn<>("Nombre");
        TableColumn<Producto, String> Descripcion = new TableColumn<>("Descripcion");
        TableColumn<Producto, Integer> Precio = new TableColumn<>("Precio");
        TableColumn<Producto,ImageIcon> Imagen = new TableColumn<>("Imagen");

        ObservableList<Producto> datos =
                FXCollections.observableArrayList(
                        new Producto("Producto 1", "Descripcion 1", 10, new ImageIcon(new File("src/imgs/p1.jpg").getAbsolutePath())),
                        new Producto("Producto 2", "Descripcion 2", 20, new ImageIcon(new File("src/imgs/p2.jpg").getAbsolutePath()))
                );
        Tabla.setItems(datos);
        Tabla.getColumns().addAll(Nombre,Descripcion,Precio, Imagen);

    }


}
