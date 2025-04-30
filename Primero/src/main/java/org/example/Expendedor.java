package org.example;

public class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    private Deposito coca;
    private Deposito sprite;
    private DepositoM monVu;
    int precio;

    public Expendedor(int cantidad, int precioBebidas) {
        coca = new Deposito(cantidad);
        sprite = new Deposito(cantidad);
        monVu = new DepositoM(cantidad);
        this.precio = precioBebidas;
        for (int i = 0; i < cantidad; i++) {
            Bebida cocacola = new CocaCola(100 + i);
            coca.addBebida(cocacola);
            Bebida spriite = new Sprite(200 + i);
            sprite.addBebida(spriite);
        }
    }

    public Bebida comprarBebida(Moneda moneda, int select) {

        if (moneda == null) {
            return null;
        }

        int valorMoneda = moneda.getValor();

        if (valorMoneda < this.precio) {
            monVu.addMoneda(moneda);
            return null;
        }

        int vuelto_temporal = moneda.getValor() - this.precio;

        if (select == COCA) {
            Bebida b = coca.getBebida();
            if (b == null) {
                monVu.addMoneda(moneda);
            }
            else {
                for (int i=0; i< vuelto_temporal; i+=100) {
                    monVu.addMoneda(new Moneda100());
                }
            }
            return b;

        } else if (select == SPRITE) {
            Bebida b = sprite.getBebida();
            if (b == null) {
                monVu.addMoneda(moneda);
            }
            else {
                for (int i=0; i< vuelto_temporal; i+=100) {
                    monVu.addMoneda(new Moneda100());
                }}
            return b;
        }
        else {
            monVu.addMoneda(moneda);
            return null;
        }
    }
    public Moneda getVuelto() {
        return monVu.getMoneda();
    }
}
