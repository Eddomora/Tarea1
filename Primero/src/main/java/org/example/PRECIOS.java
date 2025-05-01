package org.example;

public enum PRECIOS {
    COCACOLA(1500),
    SPRITE(1000),
    FANTA(1100),
    SUPER8(800),
    SNICKERS(2000);
    private final int precio;
    PRECIOS(int precio) {
        this.precio = precio;
    }
    public int getPrecio() {
        return precio;
    }
}
