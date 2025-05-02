package org.example;

public class CocaCola extends Bebida{
    public CocaCola(int numero) {
        super(numero);
    }
    @Override
    public String accion() {
        return super.accion() + "cocacola";
    }
}
