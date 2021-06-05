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
public class RutasJDBC {

    Rutas ruta = new Rutas();

    private static final String SQL_SELECTRUTAS = "SELECT * FROM rutas WHERE placa LIKE ?";
    private static final String SQL_DELETE = "DELETE  FROM rutas WHERE placa = ?";
    private static final String SQL_INSERT = "INSERT INTO rutas (Placa, Nombre, Precio, Imagen, info) VALUES (?,?,?,?,?)";
    private static final String SQL_LEFTJOIN = "SELECT busetas.placa,busetas.modelo, rutas.placa, rutas.nombre FROM busetas LEFT JOIN rutas on busetas.Placa = rutas.placa";

    public static List<Rutas> obtenerRutas() {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        String sql = "SELECT p.Placa,p.nombre,p.precio, p.info, p.imagen FROM rutas p";
        ArrayList<Rutas> lista = new ArrayList<Rutas>();
        try {
            //Procedimientos almacenados
//            CREATE PROCEDURE listarProductos()
//                    SELECT p.codigoProducto,p.nombre,p.precio,p.imagen
//                            FROM productos p ORDER BY p.nombre;
//CallableStatement cl = conexion.getConnection().prepareCall("{call listarProductos()}");            
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                //Se puede enviar como parametro el rs con index o columna
                Rutas p = new Rutas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                lista.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return lista;
    }

    public Rutas obtenerRuta(int codigo) {
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT Placa, Nombre,Precio,info,Imagen FROM rutas WHERE placa LIKE ?";
        /* Procedimiento
        CREATE PROCEDURE ProductoCodigo(cod int)
            SELECT p.codigoProducto, p.nombre, p.precio, p.imagen
            FROM productos p WHERE p.codigoProducto = cod ORDER BY p.nombre;
        
         CallableStatement cl = conexion.getConnection().prepareCall("{call  RutaCodigo(?)}");
        //cl.setInt(1, codigo);
         */
        try {
            cn = Conexion.getConnection();
            pstm = cn.prepareCall(sql);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ext = rs.getString(1);
                ruta = new Rutas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            System.out.println("ERROR ObenerRUTA(Cod)" + codigo);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstm);
            Conexion.close(cn);
        }
        return ruta;
    }

    public List DisponibilidadRutas() {
        ArrayList<Rutas> array = new ArrayList<Rutas>();
        Rutas rutas = null;
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        //Saber las rutas busetas que no tienen ruta elegida
        //String sql = "SELECT busetas.placa,busetas.modelo, rutas.placa, rutas.nombre FROM busetas LEFT JOIN rutas on busetas.Placa = rutas.placa";
        try {
            cn = Conexion.getConnection();
            pstm = cn.prepareStatement(SQL_LEFTJOIN);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String placab = rs.getString(1);
                String modelo = rs.getString(2);
                String placar = rs.getString(3);
                String nombre = rs.getString(4);
                rutas = new Rutas(placab, modelo, placar, nombre);
                array.add(rutas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstm);
            Conexion.close(cn);
        }
        return array;
    }

    public void AgregarRuta(Rutas ruta) {
        Connection cn = null;
        PreparedStatement psmt = null;
        //String sql = "INSERT INTO rutas (Placa, Nombre, Precio, Imagen, info) VALUES (?,?,?,?,?)";
        try {
            cn = Conexion.getConnection();
            psmt = cn.prepareStatement(SQL_INSERT);
            psmt.setString(1, ruta.getCodigoRuta());
            psmt.setString(2, ruta.getNombre());
            psmt.setString(3, ruta.getPrecio());
            psmt.setString(4, ruta.getImagen());
            psmt.setString(5, ruta.getInfo());
            psmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psmt);
            Conexion.close(cn);
        }

    }

    public int eliminarRuta(Rutas ruta) {
        //String SQL_DELETE = "DELETE  FROM rutas WHERE placa = ?";
        Connection cn = null;
        PreparedStatement psm = null;
        int rows = 0;
        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_DELETE);
            psm.setString(1, ruta.getCodigoRuta());
            rows = psm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return rows;
    }

    public List ListaRuta(Rutas ruta) {
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        List<Rutas> rutas = new ArrayList<>();
        //String Sql = "SELECT * FROM rutas WHERE placa LIKE ?";
        try {
            cn = Conexion.getConnection();
            psm = cn.prepareStatement(SQL_SELECTRUTAS);
            psm.setString(1, ruta.getCodigoRuta());
            rs = psm.executeQuery();
            if (rs.first()) {
                String codigoRuta = rs.getString("Placa");
                String nombre = rs.getString("Nombre");
                String precio = rs.getString("Precio");
                String imagen = rs.getString("Imagen");
                String info = rs.getString("info");
                ruta = new Rutas(codigoRuta, nombre, precio, info, imagen);
                rutas.add(ruta);
                System.out.println(ruta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(psm);
            Conexion.close(cn);
        }
        return rutas;
    }

}
