package Modelo;

import java.io.InputStream;

/**
 *
 * @author JESÚS
 */
public class Empleados {

    private String apellido;
    private String direccion;
    private String correo;
    private String telefono;
    private InputStream imagen;
    private String cedulaCiudadania;
    private String nombre;

    public Empleados(String nombre, String apellido, String direccion, String correo, InputStream imagen, String cedulaCiudadania, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.imagen = imagen;
        this.cedulaCiudadania = cedulaCiudadania;
        this.telefono = telefono;
    }

    public Empleados(String nombre, String apellido, String cedulaCiudadania, String telefono, String direccion, String correo) {
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.cedulaCiudadania = cedulaCiudadania;
        this.nombre = nombre;
    }

    public Empleados(String nombre, InputStream imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Empleados(String cedulaCiudadania, String nombre, InputStream imagen) {
        this.cedulaCiudadania = cedulaCiudadania;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Empleados(String cedulaCiudadania) {
        this.cedulaCiudadania = cedulaCiudadania;
    }

    public Empleados() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public String getCedulaCiudadania() {
        return cedulaCiudadania;
    }

    public void setCedulaCiudadania(String cedulaCiudadania) {
        this.cedulaCiudadania = cedulaCiudadania;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empleados{" + "apellido=" + apellido + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", imagen=" + imagen + ", cedulaCiudadania=" + cedulaCiudadania + ", nombre=" + nombre + '}';
    }

}
