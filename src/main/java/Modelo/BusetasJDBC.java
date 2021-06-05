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
public class BusetasJDBC {

    private static final String SQL_SELECT = "SELECT * FROM busetas";

    private static final String SQL_SELECT_BUSCAR = "SELECT * FROM busetas WHERE Placa LIKE ?";

    private static final String SQL_UPDATE = "UPDATE busetas set Modelo = ?, Marca = ?, Color = ? WHERE Placa = ? ";

    private static final String SQL_DELETE = "DELETE FROM busetas WHERE Placa = ?";

    private static final String SQL_INSERT = "INSERT INTO busetas (Placa, Modelo, Marca, Color) VALUE (?,?,?,?)";

//    private Connection conexciontransanccional;
//    
//    public BusetasJDBC( Connection conexciontransanccional){
//        this.conexciontransanccional = conexciontransanccional;
//    }
//    
    public List<Busetas> ListarBusetas() {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        Busetas buseta = null;
        List<Busetas> busetas = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            //this.conexciontransanccional != null ? this.conexciontransanccional : Conexion.getConnection();
            psm = cn.prepareStatement(SQL_SELECT);
            rs = psm.executeQuery();
            while (rs.next()) {
                String placa = rs.getString("Placa");
                String marca = rs.getString("Marca");
                String modelo = rs.getString("Modelo");
                String color = rs.getString("Color");
                buseta = new Busetas(modelo, marca, color, placa);
                busetas.add(buseta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return busetas;
    }

    public List ListaBuseta(Busetas buseta) {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        List<Busetas> bus = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_SELECT_BUSCAR);
            psm.setString(1, buseta.getPlaca());
            rs = psm.executeQuery();
            if (rs.first()) {
                String marca = rs.getString("Marca");
                String modelo = rs.getString("Modelo");
                String color = rs.getString("Color");
                String placa = rs.getString("Placa");

                buseta = new Busetas(modelo, marca, color, placa);
                bus.add(buseta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return bus;
    }

    public int EliminarBuseta(Busetas buseta) {
        Connection cn = null;
        PreparedStatement psm = null;
        int rows = 0;
        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_DELETE);
            psm.setString(1, buseta.getPlaca());
            rows = psm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return rows;
    }

    public int ModificarBusetas(Busetas buseta) {
        int rows = 0;
        Connection cn = null;
        PreparedStatement psm = null;

        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_UPDATE);
            psm.setString(1, buseta.getModelo());
            psm.setString(2, buseta.getMarca());
            psm.setString(3, buseta.getColor());
            psm.setString(4, buseta.getPlaca());
            rows = psm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return rows;
    }

    public int InsertarBusetas(Busetas buseta) {
        Connection cn = null;
        PreparedStatement psm = null;
        int inserccion = 0;
        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_INSERT);

            psm.setString(1, buseta.getPlaca());
            psm.setString(2, buseta.getModelo());
            psm.setString(3, buseta.getMarca());
            psm.setString(4, buseta.getColor());

            inserccion = psm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return inserccion;
    }

    public boolean VerificarId(Busetas buseta) {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        boolean encontrado = false;
        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_SELECT_BUSCAR);
            psm.setString(1, buseta.getPlaca());
            rs = psm.executeQuery();
            if (rs.first()) {
                encontrado = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psm);
            Conexion.close(rs);
            Conexion.close(cn);
        }
        return encontrado;
    }
}
