package org.example;

import org.example.Excepciones.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda500());
        monedas.add(new Moneda100());
        monedas.add(new Moneda1500());
        monedas.add(new Moneda1000());
        //Para ordernar en el main, deben usar el sort disponible en ArrayList. (pauta)
        Collections.sort(monedas);

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
