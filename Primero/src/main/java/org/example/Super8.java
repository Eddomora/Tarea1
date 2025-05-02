package org.example;

public class Super8  extends Dulces{
    public Super8(int numero) {
        super(numero);
    }

    @Override
    public String accion() {
        return super.accion() + "super8";
    }
}
