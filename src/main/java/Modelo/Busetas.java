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
public class Busetas {

    private String modelo;
    private String marca;
    private String color;
    private String placa;

    public Busetas() {

    }

    public Busetas(String placa) {
        this.placa = placa;
    }

    public Busetas(String modelo, String marca, String color, String placa) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Busetas{" + "modelo=" + modelo + ", marca=" + marca + ", color=" + color + ", placa=" + placa + '}';
    }

}
