/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DATOS.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JESÚS
 */
public class VentasJDBC {

    Ventas venta = null;
    private static final String SQL_INSERTR = "INSERT INTO detalleventa (idRuta, idUsuario, Cantidad, Precio, NombreRuta, Tipo) VALUES (?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM detalleventa WHERE idUsuario = ?  AND Tipo = ? ORDER BY  NombreRuta";               
                                
    public int Reservas(Ventas venta) {
        int rows = 0;
        Connection cn = null;
        PreparedStatement psmt = null;
        //String sql = "INSERT INTO detalleventa (idRuta, idUsuario, Cantidad, Precio, NombreRuta, Tipo) VALUES (?,?,?,?,?,?)";
        try {
            cn = Conexion.getConnection();
            psmt = cn.prepareStatement(SQL_INSERTR);

            psmt.setString(1, venta.getIdRuta());
            psmt.setString(2, venta.getIdUsuario());
            psmt.setString(3, venta.getCantidad());
            psmt.setString(4, venta.getPrecio());
            psmt.setString(5, venta.getNombreRuta());
            psmt.setString(6, venta.getTipo());
            psmt.executeUpdate();
            rows = 1;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psmt);
            Conexion.close(cn);
        }
        return rows;
    }

    public int Compras(Ventas venta) {
        int rows = 0;
        Connection cn = null;
        PreparedStatement psmt = null;
        //String sql = "INSERT INTO detalleventa (idRuta, idUsuario, Cantidad, Precio, NombreRuta, Tipo) VALUES (?,?,?,?,?,?)";
        try {
            cn = Conexion.getConnection();
            psmt = cn.prepareStatement(SQL_INSERTR);
            psmt.setString(1, venta.getIdRuta());
            psmt.setString(2, venta.getIdUsuario());
            psmt.setString(3, venta.getCantidad());
            psmt.setString(4, venta.getPrecio());
            psmt.setString(5, venta.getNombreRuta());
            psmt.setString(6, venta.getTipo());
            psmt.executeUpdate();
            rows = 1;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psmt);
            Conexion.close(cn);
        }
        return rows;
    }

    public List listarReservas(String id) {
        //String sql = "SELECT * FROM detalleventa WHERE idUsuario = ?  AND Tipo = ? ORDER BY  NombreRuta";
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Ventas> reservas = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            pstm = cn.prepareStatement(SQL_SELECT);
            pstm.setString(1, id);
            pstm.setString(2, "Reservas");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String idRuta = rs.getString("idRuta");
                String idUsuario = rs.getString("idUsuario");
                String cantidad = rs.getString("cantidad");
                String Precio = rs.getString("Precio");
                String NombreRuta = rs.getString("NombreRuta");
                String tipo = rs.getString("Tipo");
                venta = new Ventas(idRuta, idUsuario, cantidad, Precio, NombreRuta, tipo);
                System.out.println("Venta " + venta);
                reservas.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return reservas;
    }

    public List listarCompras(String id) {
        //String sql = "SELECT * FROM detalleventa WHERE idUsuario = ?  AND Tipo = ? ORDER BY  NombreRuta";
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Ventas> reservas = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            pstm = cn.prepareStatement(SQL_SELECT);
            pstm.setString(1, id);
            pstm.setString(2, "Compras");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String idRuta = rs.getString("idRuta");
                String idUsuario = rs.getString("idUsuario");
                String cantidad = rs.getString("cantidad");
                String Precio = rs.getString("Precio");
                String NombreRuta = rs.getString("NombreRuta");
                String tipo = rs.getString("Tipo");
                venta = new Ventas(idRuta, idUsuario, cantidad, Precio, NombreRuta, tipo);
                reservas.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return reservas;
    }
    ///Quiero listar la placa para verificar si esta se encontraba en alguna ruta
    // por si modificaban la URL
    public List listarPlaca(Ventas ruta) {
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Ventas> rutas = new ArrayList<>();
        String sql = "SELECT placa FROM rutas";
        try {
            cn = Conexion.getConnection();
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String placa = rs.getString("Placa");
                venta.setIdRuta(placa);
                rutas.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
//        for (Ventas ruta1 : rutas) {
//            System.out.println("Las rutas 1 " + venta.getIdRuta());
//        }
        return rutas;
    }
}
