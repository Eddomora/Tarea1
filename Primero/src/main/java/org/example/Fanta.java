package org.example;

public class Fanta extends Bebida{
    public Fanta(int numero) {
        super(numero);
    }
    @Override
    public String accion() {
        return super.accion() + "fanta";
    }
}

