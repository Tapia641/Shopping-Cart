package classes;

import java.awt.*;

public class Producto {
    private String NombreProducto;
    private String Descripcion;
    private Image ImagenMuestra;

    public Producto() {
    }

    public Producto(String nombreProducto, String descripcion, Image imagenMuestra) {
        NombreProducto = nombreProducto;
        Descripcion = descripcion;
        ImagenMuestra = imagenMuestra;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Image getImagenMuestra() {
        return ImagenMuestra;
    }

    public void setImagenMuestra(Image imagenMuestra) {
        ImagenMuestra = imagenMuestra;
    }
}
