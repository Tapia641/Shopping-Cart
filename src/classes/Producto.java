package classes;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* NECESITA SER EXTERNALIZABLE PARA QUE LISTA SEA SERIALIZABLE */
public class Producto implements Externalizable {

    private String NombreProducto;
    private String Descripcion;
    private Integer Precio;
    //private Image ImagenMuestra;
    //private ImageIcon

    public Producto() {
    }


    /* NECESARIO PARA QUE SEA EXTERNALIZABLE */
    public void writeExternal(ObjectOutput out)
            throws IOException {
        // INDICAMOS CUALES ATRIBUTOS SE VAN A ENVIAR
        out.writeObject(NombreProducto);
        out.writeObject(Descripcion);
        out.writeObject(Precio);
        //out.writeObject(ImagenMuestra);
    }

    /* NECESARIO PARA QUE SEA EXTERNALIZABLE */
    public void readExternal(ObjectInput in)
            throws IOException,
            ClassNotFoundException {
        // INDICAMOS CUALES ATRIBUTOS SE RECUPERAN
        this.NombreProducto = (String) in.readObject();
        this.Descripcion = (String) in.readObject();
        this.Precio = (Integer) in.readObject();
        //this.ImagenMuestra = (Image) in.readObject();
    }

    public Producto(String NombreProducto, String Descripcion, Integer Precio) {
        this.NombreProducto = NombreProducto;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        //this.ImagenMuestra = ImagenMuestra;
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
/*
    public Image getImagenMuestra() {
        return ImagenMuestra;
    }

    public void setImagenMuestra(Image imagenMuestra) {
        ImagenMuestra = imagenMuestra;
    }
    */
}
