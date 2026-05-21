package org.example;

public class CarritoCompra {
    public static final double cupon10 = 0.10;
    public static final double Cupon_Black_Friday = 0.25;
    private MetodoPago metodoPago;
    private String[] nombre_producto; // nombres de productos
    private double[] precios;  // precios unitarios
    private int[] c; // cantidades
    private String tipoDescuento; // "Ninguno", "Cupon10", "BlackFriday"

    public CarritoCompra(String[] nombre_producto, double[] precios, int[] c, String tipoDescuento, MetodoPago metodoPago) {
        this.nombre_producto = nombre_producto;
        this.precios = precios;
        this.c = c;
        this.tipoDescuento = tipoDescuento;
        this.metodoPago = metodoPago;
    }

    public void procesarCompra() {
        // Validar que los arrays tengan la misma longitud y no exceda el límite máximpo de 10 productos
        if (nombre_producto.length >= 10 || precios.length >= 10 || c.length >= 10) {
            System.out.println("Error: No se pueden procesar más de 10 productos.");
            return;
        } else {
            if (nombre_producto.length != precios.length || nombre_producto.length != c.length) {
                System.out.println(
                    "Error: Los arrays de productos, precios y cantidades deben tener la misma longitud.");
                return;
            } else {
                // Calcular el total
                double total = 0;
                for (int i = 0; i < nombre_producto.length; i++) {
                    System.out.println(
                        "Producto: " + nombre_producto[i] + ", Cantidad: " + c[i] + ", Precio: " + precios[i]);
                    total += precios[i] * c[i];
                }

                System.out.println("Total sin descuento: " + total);

                double total1 = total;
                // Aplicar descuento
                if (tipoDescuento.equals("Cupon10")) {
                    total1 = total1 - (total1 * cupon10);
                } else if (tipoDescuento.equals("BlackFriday")) {
                    total1 = total1 - (total1 * Cupon_Black_Friday);
                }
                System.out.println("Total con descuento: " + total1);

                procesarPago();

                //vaciar carrito
                nombre_producto = new String[0];
                precios = new double[0];
                c = new int[0];
                tipoDescuento = "Ninguno";
//                metodoPago.metodoPago = "Ninguno";
            }
        }
    }

    private void procesarPago() {
//        // Procesar pago
//        if (metodoPago.metodoPago.equals("Tarjeta")) {
//            System.out.println("Procesando pago con tarjeta de crédito...");
//        } else if (metodoPago.metodoPago.equals("PayPal")) {
//            System.out.println("Procesando pago con PayPal...");
//        } else if (metodoPago.metodoPago.equals("Transferencia")) {
//            System.out.println("Procesando pago mediante transferencia bancaria...");
//        } else {
//            System.out.println("Método de pago no soportado.");
//        }
        metodoPago.pagar();

            System.out.println("Compra procesada con éxito.");
    }

    private double aplicarDescuento(double total) {
        // Aplicar descuento
        if (tipoDescuento.equals("Cupon10")) {
            total = total - (total * cupon10);
        } else if (tipoDescuento.equals("BlackFriday")) {
            total = total - (total * Cupon_Black_Friday);
        }
        System.out.println("Total con descuento: " + total);
        return total;
    }
}
