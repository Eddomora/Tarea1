package org.example;
/**
 * Enum Precios define los PRECIOS que tendrá cada producto en el expendedor
 * Cada constante representa un producto.
 */

public enum PRECIOS {
    COCACOLA(1200),
    SPRITE(1000),
    FANTA(1100),
    SUPER8(500),
    SNICKERS(1500);
    private final int precio;
    PRECIOS(int precio) {
        this.precio = precio;
    }
    public int getPrecio() {
        return precio;
    }
}
