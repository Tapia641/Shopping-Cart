/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 *
 * @author Tapia
 */
public class Pedido implements Externalizable {

    private String nombre;
    private Integer precio;
    private Integer cantidad;
    private Integer total;
    private String direccion = "";

    public Pedido(String nombre, Integer precio, Integer cantidad, Integer total) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Pedido() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // INDICAMOS CUALES ATRIBUTOS SE VAN A ENVIAR
        out.writeObject(nombre);
        out.writeObject(precio);
        out.writeObject(cantidad);
        out.writeObject(total);
        out.writeObject(direccion);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        // INDICAMOS CUALES ATRIBUTOS SE RECUPERAN
        this.nombre = (String) in.readObject();
        this.precio = (Integer) in.readObject();
        this.cantidad = (Integer) in.readObject();
        this.total = (Integer) in.readObject();
        this.direccion = (String) in.readObject();

    }

}
