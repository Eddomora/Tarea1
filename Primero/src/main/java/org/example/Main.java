package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(7,300);
        Moneda m = null;
        Comprador c = null;
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
    }
}
