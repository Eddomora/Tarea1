package org.example;

public class Main {
    public static void main(String[] args) throws Expendedor.PagoInsuficienteException, Expendedor.PagoIncorrectoException {
        Expendedor exp = new Expendedor(7);
        Moneda m = null;
        Comprador c = null;
        c = new Comprador(m,Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
        // Lanza PagoIncorrectoException correctamente

        System.out.println(c.queCompraste() + ", " + c.cuantoVuelto());
    }
}
