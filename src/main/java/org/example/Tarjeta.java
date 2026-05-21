package org.example;

public class Tarjeta implements MetodoPago{
    @Override
    public void pagar() {
        System.out.println("Pagando con tarjeta... Pago exitoso");
    }
}

