package org.example;

public class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Moneda> monVu;
    int precio;

    public Expendedor(int cantidad, int precioBebidas) {
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        fanta = new Deposito<Bebida>();

        monVu = new Deposito();
        this.precio = precioBebidas;
        for (int i = 0; i < cantidad; i++) {
            Bebida cocacola = new CocaCola(100 + i);
            coca.addCosa(cocacola);
            Bebida spriite = new Sprite(200 + i);
            sprite.addCosa(spriite);
            Bebida faanta = new Fanta(300 + i);
            sprite.addCosa(faanta);
        }
    }

    public Bebida comprarBebida(Moneda moneda, int select) {

        if (moneda == null) {
            return null;
        }

        int valorMoneda = moneda.getValor();

        if (valorMoneda < this.precio) {
            monVu.addCosa(moneda);
            return null;
        }

        int vuelto_temporal = moneda.getValor() - this.precio;

        if (select == COCA) {
            Bebida b = coca.getCosa();
            if (b == null) {
                monVu.addCosa(moneda);
            }
            else {
                for (int i=0; i< vuelto_temporal; i+=100) {
                    monVu.addCosa(new Moneda100());
                }
            }
            return b;

        } else if (select == SPRITE) {
            Bebida b = sprite.getCosa();
            if (b == null) {
                monVu.addCosa(moneda);
            }
            else {
                for (int i=0; i< vuelto_temporal; i+=100) {
                    monVu.addCosa(new Moneda100());
                }}
            return b;
        }
        else {
            monVu.addCosa(moneda);
            return null;
        }
    }
    public Moneda getVuelto() {
        return monVu.getCosa();
    }
}