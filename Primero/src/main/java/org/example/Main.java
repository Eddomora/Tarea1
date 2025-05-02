package org.example;

import org.example.Excepciones.*;

public class Main {
    public static void main(String[] args){
        try {
            Expendedor exp = new Expendedor(7);
            Moneda m = null;
            Comprador c = null;
            c = new Comprador(m, Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        }
        // Ahora PagoInsuficiente
    }
}
