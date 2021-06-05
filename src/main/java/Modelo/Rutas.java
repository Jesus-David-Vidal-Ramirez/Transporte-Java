/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JESÚS
 */
public class Rutas {

    private String codigoRuta;
    private String nombre;
    private String precio;
    private String info;
    private String imagen;

    public Rutas() {
    }

    public Rutas(String codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public Rutas(String codigoRuta, String nombre, String info, String imagen) {
        this.codigoRuta = codigoRuta;
        this.nombre = nombre;
        this.imagen = imagen;
        this.info = info;
    }

    public Rutas(String codigoRuta, String nombre, String precio, String info, String imagen) {
        this.codigoRuta = codigoRuta;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.info = info;
    }

    public String getCodigoRuta() {
        return codigoRuta;
    }

    public void setCodigoRuta(String codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Rutas{" + "codigoRuta=" + codigoRuta + ", nombre=" + nombre + ", precio=" + precio + ", info=" + info + ", imagen=" + imagen + '}';
    }

}
