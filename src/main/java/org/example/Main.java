package org.example;

public class Main {
    public static void main(String[] args) {
        // Pruebas de uso de CarritoCompra
        String[] productos = {"Laptop", "Mouse", "Teclado"};
        double[] precios = {1000.0, 50.0, 80.0};
        int[] cantidades = {1, 2, 1};
        String tipoDescuento = "Cupon10";

        CarritoCompra carrito = new CarritoCompra(productos, precios, cantidades, tipoDescuento, new Tarjeta());
        carrito.procesarCompra();
    }
}