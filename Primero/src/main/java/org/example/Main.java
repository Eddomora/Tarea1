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


        Expendedor exp = new Expendedor(1);
        Moneda m = null;
        Comprador c;
      
        try {
            c = new Comprador(m, Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
            System.out.println(c.queCompraste() + ", tu vuelto es $" + c.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        }
        try{
            m = new Moneda500();
            c = new Comprador(m, Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
            System.out.println(c.queCompraste() + ", tu vuelto es $" + c.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        }
        try{
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
            System.out.println(c.queCompraste() + ", tu vuelto es $" + c.cuantoVuelto());

            Comprador d = new Comprador(m, Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
            System.out.println(d.queCompraste() + ", tu vuelto es $" + d.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        }
    }
}
