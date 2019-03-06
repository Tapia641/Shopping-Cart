package Clases;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.swing.ImageIcon;

/* NECESITA SER EXTERNALIZABLE PARA QUE LISTA SEA SERIALIZABLE */
public class Producto implements Externalizable {

    private String NombreProducto;
    private String Descripcion;
    private Integer Precio;
    private ImageIcon ImagenMuestra;
    private Integer Cantidad;
    private String Categoria;

    public Producto() {
    }


    /* NECESARIO PARA QUE SEA EXTERNALIZABLE */
    public void writeExternal(ObjectOutput out)
            throws IOException {
        // INDICAMOS CUALES ATRIBUTOS SE VAN A ENVIAR
        out.writeObject(NombreProducto);
        out.writeObject(Descripcion);
        out.writeObject(Precio);
        out.writeObject(ImagenMuestra);
        out.writeObject(Cantidad);
        out.writeObject(Categoria);
    }

    /* NECESARIO PARA QUE SEA EXTERNALIZABLE */
    public void readExternal(ObjectInput in)
            throws IOException,
            ClassNotFoundException {
        // INDICAMOS CUALES ATRIBUTOS SE RECUPERAN
        this.NombreProducto = (String) in.readObject();
        this.Descripcion = (String) in.readObject();
        this.Precio = (Integer) in.readObject();
        this.ImagenMuestra = (ImageIcon) in.readObject();
        this.Cantidad = (Integer) in.readObject();
        this.Categoria = (String) in.readObject();
    }

    public Producto(String NombreProducto, String Descripcion, Integer Precio, ImageIcon ImagenMuestra, Integer Cantidad, String Categoria) {
        this.NombreProducto = NombreProducto;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.ImagenMuestra = ImagenMuestra;
        this.Cantidad = Cantidad;
        this.Categoria = Categoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    
    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
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

    public ImageIcon getImagenMuestra() {
        return ImagenMuestra;
    }

    public void setImagenMuestra(ImageIcon imagenMuestra) {
        this.ImagenMuestra = imagenMuestra;
    }
}
