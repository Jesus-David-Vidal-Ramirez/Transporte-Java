/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author JESÚS
 */
public class main {

    public static void main(String[] args) {
        VentasJDBC venta = new VentasJDBC();
        //venta.listarReservas("User");
        
        Ventas v = new Ventas();
        v.setId(1);
        v.setIdRuta("1");
        v.setIdUsuario("Amalfy");
        v.setCantidad("89");
        v.setPrecio("15000.0");
        v.setNombreRuta("corozal");
        v.setTipo("Reservas");
           //(1,'Jesus',10,12,'Sincelejo');
           // idRuta=102, idUsuario=Amalfy, Cantidad=6, Precio=15000.0, NombreRuta=corozal
        System.out.println("v "+ v);
         RutasJDBC ruta = new RutasJDBC();
         //venta.listarPlaca(v);
         int rows = new VentasJDBC().Reservas(v);
         
         
//        RutasJDBC ruta = new RutasJDBC();
//        ruta.DisponibilidadRutas();
//        Object datos = "azul";
//        
//        String[] arrayCadenas = new String[4];
//        arrayCadenas[0] ="Jesus";
//        arrayCadenas[1] ="David";
//        arrayCadenas[2] ="Vidal";
//        arrayCadenas[3] ="Ramirez";
//        
//        System.out.println("El arraycadenas " +arrayCadenas[0] + arrayCadenas[3] );
//        System.out.println("el dato" + datos);
//        

    }
}
