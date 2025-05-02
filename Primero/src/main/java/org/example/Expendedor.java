package org.example;
import org.example.Excepciones.*;

public class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    public static final int SNICKERS = 4;
    public static final int SUPER8 = 5;
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulces> snickers;
    private Deposito<Dulces> super8;
    private Deposito<Moneda> monVu;


    public Expendedor(int cantidad) {
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        fanta = new Deposito<Bebida>();
        snickers = new Deposito<Dulces>();
        super8 = new Deposito<Dulces>();
        monVu = new Deposito<Moneda>();


        for (int i = 0; i < cantidad; i++) {

            Bebida cocacola = new CocaCola(100 + i);
            coca.addCosa(cocacola);

            Bebida spriite = new Sprite(200 + i);
            sprite.addCosa(spriite);

            Bebida faanta = new Fanta(300 + i);
            fanta.addCosa(faanta);

            Dulces snicker = new Snickers(400 + i);
            snickers.addCosa(snicker);

            Dulces superocho = new Snickers(500 + i);
            super8.addCosa(superocho);
        }
    }

    public Producto comprarProducto(Moneda moneda, int select, int precio) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        if (moneda == null) {
            throw new PagoIncorrectoException("No ingresaste una moneda");
        }
        int valorMoneda = moneda.getValor();
        int vuelto_temporal = moneda.getValor() - precio;

        if (valorMoneda < precio) {
            monVu.addCosa(moneda);
            throw new PagoInsuficienteException("No te alcanza para comprar el producto");
        }

        Bebida b = null;
        Dulces d = null;
        switch (select) {
            case 1:
                b = coca.getCosa();
                if (b == null) {
                    monVu.addCosa(moneda);
                } else {
                    for (int i = 0; i < vuelto_temporal; i += 100) {
                        monVu.addCosa(new Moneda100());
                    }
                }
                return b;

            case 2:
                b = sprite.getCosa();
                if (b == null) {
                    monVu.addCosa(moneda);
                } else {
                    for (int i = 0; i < vuelto_temporal; i += 100) {
                        monVu.addCosa(new Moneda100());
                    }
                }
                return b;

            case 3:
                b = fanta.getCosa();
                if (b == null) {
                    monVu.addCosa(moneda);
                } else {
                    for (int i = 0; i < vuelto_temporal; i += 100) {
                        monVu.addCosa(new Moneda100());
                    }
                }
                return b;

            case 4:
                d = super8.getCosa();
                if (d == null) {
                    monVu.addCosa(moneda);
                } else {
                    for (int i = 0; i < vuelto_temporal; i += 100) {
                        monVu.addCosa(new Moneda100());
                    }
                }
                return d;

            case 5:
                d = snickers.getCosa();
                if (d == null) {
                    monVu.addCosa(moneda);
                } else {
                    for (int i = 0; i < vuelto_temporal; i += 100) {
                        monVu.addCosa(new Moneda100());
                    }
                }
                return d;

            default:
                monVu.addCosa(moneda);
                return null;
        }

        /*
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
         */
    }
    public Moneda getVuelto() {
        return monVu.getCosa();
    }
}