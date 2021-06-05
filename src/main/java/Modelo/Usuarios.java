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
public class Usuarios {

    private String usuario;
    private String password;
    private String telefono;
    private String correo;
    private String identificacion;
    private String mensaje;
    private String rol;

    public Usuarios() {
    }

    public Usuarios(String usuario) {
        this.usuario = usuario;
    }

    public Usuarios(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Usuarios(String usuario, String password, String telefono, String identificacion, String correo, String rol) {
        this.usuario = usuario;
        this.password = password;
        this.telefono = telefono;
        this.correo = correo;
        this.identificacion = identificacion;
        this.rol = rol;
    }

    public Usuarios(String usuario, String password, String telefono, String identificacion, String correo) {
        this.usuario = usuario;
        this.password = password;
        this.telefono = telefono;
        this.correo = correo;
        this.identificacion = identificacion;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "usuario=" + usuario + ", password=" + password + ", telefono=" + telefono + ", correo=" + correo + ", identificacion=" + identificacion + ", rol=" + rol + '}';
    }

}
