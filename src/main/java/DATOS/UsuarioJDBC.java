package DATOS;


import Modelo.Usuarios;
import java.sql.*;
import java.util.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author JESÚS
 */
public class UsuarioJDBC {

    private static final String SQL_SELECT_USER = "SELECT Usuario, Password, Telefono, Identificador, Correo, Rol from login WHERE Usuario LIKE ? && Password LIKE ?  ";

    private static final String SQL_BUSCAR = "SELECT Usuario FROM Login WHERE Usuario LIKE ?";

    private static final String SQL_LISTAR = "SELECT * FROM Login";

    private static final String SQL_INSERT_USER = "INSERT INTO Login (Usuario,Password, Telefono, Identificador,Correo,Rol ) VALUES (?, ?, ?, ?, ?,?)";

    private static final String SQL_DELETE = "DELETE  FROM login WHERE Usuario LIKE ?";

    private static final String SQL_BUSCAR_COMPLETO = "SELECT Usuario,Password, Telefono, Identificador,Correo FROM Login WHERE Usuario = ?";

    private static final String SQL_UPDATE = "UPDATE Login SET  Password = ?, Telefono  = ?, Identificador = ?, Correo = ?, Rol = ? WHERE Usuario = ?";

    public Usuarios Acceso(Usuarios usuarios) {

        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        //boolean encontrado = true;
        String mensaje = null;
        //Usuarios usuario = null;
        try {

            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_SELECT_USER);

            psm.setString(1, usuarios.getUsuario());
            psm.setString(2, usuarios.getPassword());
            

            rs = psm.executeQuery();
            //encontrado = rs.next();

            if (rs.next()) {
                System.out.println("Se encontro un dato " + rs.first());

                String Usuario = rs.getString("Usuario");
                String Password = rs.getString("Password");
                String Telefono = rs.getString("Telefono");
                String Identificacion = rs.getString("Identificador");
                String Correo = rs.getString("Correo");
                String Rol = rs.getString("Rol");

                usuarios.setUsuario(Usuario);
                usuarios.setPassword(Password);
                usuarios.setTelefono(Telefono);
                usuarios.setIdentificacion(Identificacion);
                usuarios.setCorreo(Correo);
                usuarios.setRol(Rol);
                System.out.println("Se encontro el rol " + usuarios.getRol());
                mensaje = "Se encontro un dato";
                usuarios.setMensaje(mensaje);
            } else {
                mensaje = "No hay coinsidencia";
                usuarios.setMensaje(mensaje);
                System.out.println("EL USUARIO ACA DESDE JDBC ES " + usuarios.getUsuario());
                //System.out.println("No hay coinsidencia");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("ERROR ACCESO");
        }

        return usuarios;
    }

    public int Insertar(Usuarios usuario) {
        Connection cn = null;
        PreparedStatement psm = null;
        int inserccion = 0;
        try {
            
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_INSERT_USER);

            psm.setString(1, usuario.getUsuario());
            psm.setString(2, usuario.getPassword());
            psm.setString(3, usuario.getTelefono());
            psm.setString(4, usuario.getIdentificacion());
            psm.setString(5, usuario.getCorreo());
            psm.setString(6, usuario.getRol());
            

            inserccion = psm.executeUpdate();

            System.out.println("insertado" + usuario);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return inserccion;
    }

    public boolean VerificarId(Usuarios usuario) {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;

        boolean encontrado = false;
        try {
            //String mensaje = "";

            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_BUSCAR);

            psm.setString(1, usuario.getUsuario());

            rs = psm.executeQuery();
            if (rs.first()) {
                //mensaje = "Hay un registro con este nombre";
                encontrado = true;
            } else {
                //mensaje = "Registro creado";
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return encontrado;
    }

    public List<Usuarios> listar() {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        Usuarios usuario = null;
        List<Usuarios> usuarios = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_LISTAR);
            rs = psm.executeQuery();

            while (rs.next()) {

                String user = rs.getString("Usuario");
                String pass = rs.getString("Password");
                String id = rs.getString("Identificador");
                String correo = rs.getString("Correo");
                String telefono = rs.getString("Telefono");
                String rol = rs.getString("Rol");
                usuario = new Usuarios(user, pass, id, correo, telefono, rol);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarios;
    }

    public int Eliminar(Usuarios usuario) {

        Connection cn = null;
        PreparedStatement psm = null;
        int rows = 0;

        try {

            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_DELETE);
            psm.setString(1, usuario.getUsuario());

            rows = psm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
        return rows;
    }

    public Usuarios BuscarCompleto(Usuarios usuario) {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        Usuarios user = null;
        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_BUSCAR_COMPLETO);
            psm.setString(1, usuario.getUsuario());
            rs = psm.executeQuery();
            if (rs.first()) {

                String usu = rs.getString("Usuario");
                String pass = rs.getString("Password");
                String id = rs.getString("Identificador");
                String correo = rs.getString("Correo");
                String telefono = rs.getString("Telefono");
                String rol = rs.getString("Rol");

                user = new Usuarios(usu, pass, telefono, id, correo, rol);
                System.out.println(user);
                System.out.println("------");

            }
    

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return user;
    }

    public int Modificar(Usuarios usuario) {
        int rows = 0;
        Connection cn = null;
        PreparedStatement psm = null;

        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_UPDATE);
            // "UPDATE Login SET  Password = ?, Telefono  = ?, Identificador = ?, Correo = ?";
            //Probar si funciona
            //Password = ?, Telefono  = ?, Identificador = ?, Correo = ?, Rol = ? WHERE Usuario = ?";
            psm.setString(1, usuario.getPassword());
            psm.setString(2, usuario.getTelefono());
            psm.setString(3, usuario.getIdentificacion());
            psm.setString(4, usuario.getCorreo());
            psm.setString(5, usuario.getRol());
            psm.setString(6, usuario.getUsuario());

            rows = psm.executeUpdate();
            System.out.println("MODIFICAR PARAMETRO " + usuario);
            System.out.println("Edito " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("ERROR Editar");
        }
        return rows;
    }
    public List ListarUsuario(Usuarios usuario) {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        //Empleados empleado = null;
        String SQL = "SELECT Usuario, Password, Identificador, Telefono, Rol, Correo FROM login WHERE Usuario = ?; ";
        List<Usuarios> usuarios = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL);
            psm.setString(1, usuario.getUsuario());
            rs = psm.executeQuery();

            while (rs.next()) {

                String user = rs.getString("Usuario");
                String pass = rs.getString("Password");
                String id = rs.getString("Identificador");
                String telefono = rs.getString("Telefono");
                String rol = rs.getString("Rol");
                String correo = rs.getString("Correo");
                

                //empleado = new Empleados(apellido, direccion, correo, telefono,id , nombre);
                usuario = new Usuarios(user, pass, id, telefono,  correo, rol);
                usuarios.add(usuario);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(psm);
            Conexion.close(cn);
            System.out.println("CERRANDO conexion listarusuario");

        }
        return usuarios;
    }

}
