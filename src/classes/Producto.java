package classes;

import java.awt.*;

public class Producto {
    private String NombreProducto;
    private String Descripcion;
    private Integer Precio;
    private Image ImagenMuestra;

    public Producto() {
    }

    public Producto(String NombreProducto, String Descripcion, Integer Precio, Image ImagenMuestra) {
        this.NombreProducto = NombreProducto;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.ImagenMuestra = ImagenMuestra;
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

    public Integer getPrecio() {
        return Precio;
    }

    public void setPrecio(Integer precio) {
        Precio = precio;
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
