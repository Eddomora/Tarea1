package org.example;

public abstract class Dulces extends Producto {
    private int serie;

    public Dulces(int numero){
        super(numero);
    }

    public abstract String comer();
}