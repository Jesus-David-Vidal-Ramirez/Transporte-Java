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
public class Ventas {

    private int id;
    private String idRuta;
    private String idUsuario;
    private String Cantidad;
    private String Precio;
    private String NombreRuta;
    private String Tipo;

    public Ventas() {
    }

    public Ventas(String idRuta) {
        this.idRuta = idRuta;
    }

    public Ventas(String idRuta, String idUsuario, String Cantidad, String Precio, String NombreRuta, String Tipo) {
        this.idRuta = idRuta;
        this.idUsuario = idUsuario;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.NombreRuta = NombreRuta;
        this.Tipo = Tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getNombreRuta() {
        return NombreRuta;
    }

    public void setNombreRuta(String NombreRuta) {
        this.NombreRuta = NombreRuta;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    @Override
    public String toString() {
        return "Ventas{" + "id=" + id + ", idRuta=" + idRuta + ", idUsuario=" + idUsuario + ", Cantidad=" + Cantidad + ", Precio=" + Precio + ", NombreRuta=" + NombreRuta + ", Tipo=" + Tipo + '}';
    }

}
