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

abstract class Moneda {
    public Moneda() {}
    public Moneda getSerie() {
        return this;
    }
    public abstract int getValor();
}

class Moneda1500 extends Moneda {
    public Moneda1500() {
        super();
    }
    public int getValor() {
        return 1500;
    }
}

class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
    }
    public int getValor() {
        return 1000;
    }
}

class Moneda500 extends Moneda {
    public Moneda500() {
        super();
    }
    public int getValor() {
        return 500;
    }
}

class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }
    public int getValor() {
        return 100;
    }
}