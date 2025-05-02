package org.example;

public abstract class Bebida extends Producto{
    private int serie;

    public Bebida(int numero){
        super(numero);
    }
    public String accion(){return "Estás bebiendo: ";}
}