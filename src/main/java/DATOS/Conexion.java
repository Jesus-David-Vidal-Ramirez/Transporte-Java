
package DATOS;



import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.sql.DataSource;
//import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author JESÚS
 */
public class Conexion {
    
    private static final String JDBC_URL ="jdbc:mysql://localhost:3307/transporteb1?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true"; 
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="root";
                                                                        
    //private static BasicDataSource bds = null;
    
   
    
    public static DataSource getDataSource(){
            
        //if(bds == null){
            BasicDataSource bds = new BasicDataSource();
            bds.setUrl(JDBC_URL);
            bds.setUsername(JDBC_USER);
            bds.setPassword(JDBC_PASSWORD);
            bds.setInitialSize(100);
       // } (DataSource)
        
         return  bds;
    }
    
    
    
    //getConnection
    public static Connection getConnection() throws SQLException{
         return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
//        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
        
    }
    
    public static void close(PreparedStatement pstm){
        
        try {
            pstm.close();
        } catch (SQLException ex) {
             ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection cn){
        
        try {
            cn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
        
    }

    
    
}
