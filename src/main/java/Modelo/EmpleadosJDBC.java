/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DATOS.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JESÚS
 */
public class EmpleadosJDBC {

    Empleados empleado = new Empleados();

    private static final String SQL_SELECTID = "SELECT Nombre, Apellido, idEmpleados, Telefono, Direccion, Correo FROM empleados WHERE idEmpleados = ? ";
    private static final String SQL_SELECT = "SELECT * FROM empleados";
    private static final String SQL_INSERT = "INSERT INTO Empleados (idEmpleados, Nombre, Apellido, Telefono,Direccion, Correo, Imagen) VALUE (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleados SET Nombre = ? , Apellido = ?, Telefono = ? , Direccion = ? , Correo = ? WHERE idEmpleados = ?";
    private static final String SQL_DELETE = "DELETE  FROM empleados WHERE idEmpleados = ?";

    public List listarE() {
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Empleados> empleados = new ArrayList<>();
        String sql = "SELECT idEmpleados, Nombre, Imagen FROM empleados";
        try {
            cn = Conexion.getConnection();
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                // Empleados empleado = new Empleados();
                empleado.setCedulaCiudadania(rs.getString(1));
                empleado.setNombre(rs.getString(2));
                //empleado.setApellido(rs.getString(3));
                //empleado.setTelefono(rs.getLong(4));
                //empleado.setDireccion(rs.getString(5));
                //empleado.setCorreo(rs.getString(6));
                empleado.setImagen(rs.getBinaryStream(3));
                empleados.add(empleado);
            }
            for (Empleados li : empleados) {
                System.out.println(li.getCedulaCiudadania());
                System.out.println(li.getNombre());
                System.out.println(li.getImagen());
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pstm);
            Conexion.close(cn);
            Conexion.close(rs);
        }
        return empleados;
    }

    public List<Empleados> listarEmpleados() {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        //String SQL = "SELECT * FROM empleados";
        List<Empleados> empleados = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_SELECT);
            rs = psm.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String telefono = rs.getString("Telefono");
                String direccion = rs.getString("Direccion");
                String correo = rs.getString("Correo");
                String id = rs.getString("idEmpleados");
                empleado = new Empleados(nombre, apellido, id, telefono, direccion, correo);
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return empleados;
    }

    public int ModificarEmpleado(Empleados empleado) {
        int rows = 0;
        Connection cn = null;
        PreparedStatement psm = null;

        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_UPDATE);

            psm.setString(1, empleado.getNombre());
            psm.setString(2, empleado.getApellido());
            psm.setString(3, empleado.getTelefono());
            psm.setString(4, empleado.getDireccion());
            psm.setString(5, empleado.getCorreo());
            psm.setString(6, empleado.getCedulaCiudadania());

            rows = psm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return rows;
    }

    public void listarImagen(int id, HttpServletResponse response) {
        String sql = "SELECT idEmpleados, Nombre, Imagen FROM Empleados  WHERE idEmpleados = " + id;
        //El id es la clave para llamar la imagen se pone como path en el url del img
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferInputStream = null;
        BufferedOutputStream bufferOutputStream = null;
        response.setContentType("image/*");
        try {
            outputStream = response.getOutputStream();
            cn = Conexion.getConnection();
            pstm = cn.prepareStatement(sql);

            rs = pstm.executeQuery();

            if (rs.next()) {
                //empleado.setCedulaCiudadania(rs.getString(1));
                inputStream = rs.getBinaryStream("Imagen");
                //inputStream = (InputStream) rs.getBlob("Imagen");
            }
            bufferInputStream = new BufferedInputStream(inputStream);
            bufferOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferInputStream.read()) != -1) {
                bufferOutputStream.write(i);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstm);
            Conexion.close(cn);
        }

    }

    public void AgregarEmpleado(Empleados empleado) {
        //String sql = "INSERT INTO Empleados (idEmpleados, Nombre, Apellido, Telefono,Direccion, Correo, Imagen) VALUE (?,?,?,?,?,?,?)";
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = Conexion.getConnection();
            pstm = cn.prepareStatement(SQL_INSERT);

            pstm.setString(1, empleado.getCedulaCiudadania());
            pstm.setString(2, empleado.getNombre());
            pstm.setString(3, empleado.getApellido());
            pstm.setString(4, empleado.getTelefono());
            pstm.setString(5, empleado.getDireccion());
            pstm.setString(6, empleado.getCorreo());
            pstm.setBlob(7, empleado.getImagen());

            pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pstm);
            Conexion.close(cn);
        }
    }

    public static ArrayList<Empleados> MostrarUsuarios() {
        ArrayList<Empleados> lista = new ArrayList<Empleados>();

        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement("SELECT idEmpleados, Nombre, Imagen FROM Empleados");
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleados Usu = new Empleados();
                Usu.setCedulaCiudadania(rs.getString("idEmpleados"));
                Usu.setNombre(rs.getString("Nombre"));
                Usu.setImagen(rs.getAsciiStream("Imagen"));
                lista.add(Usu);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return lista;
    }

    public int eliminarEmpleado(Empleados empleado) {
        //String SQL_DELETE = "DELETE  FROM empleados WHERE idEmpleados = ?";
        Connection cn = null;
        PreparedStatement psm = null;
        int rows = 0;

        try {

            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_DELETE);
            psm.setString(1, empleado.getCedulaCiudadania());
            rows = psm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return rows;
    }

    public List ListarEmpleado(Empleados empleado) {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        //String SQL = "SELECT Nombre, Apellido, idEmpleados, Telefono, Direccion, Correo FROM empleados WHERE idEmpleados = ? ";
        List<Empleados> empleados = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_SELECTID);
            psm.setString(1, empleado.getCedulaCiudadania());
            rs = psm.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String telefono = rs.getString("Telefono");
                String direccion = rs.getString("Direccion");
                String correo = rs.getString("Correo");
                String id = rs.getString("idEmpleados");
                empleado = new Empleados(nombre, apellido, id, telefono, direccion, correo);
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return empleados;
    }
}
