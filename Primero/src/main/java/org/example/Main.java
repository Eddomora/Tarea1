import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(7,300);
        Moneda m = null;
        Comprador c = null;
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
    }
}

class Expendedor {
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

class Deposito {
    private ArrayList<Bebida> dep;
    public void addBebida(Bebida bebida) {
        dep.add(bebida);
    }
    public Bebida getBebida() {
        if (dep.size() != 0) {
            Bebida b = dep.get(0);
            dep.remove(0);
            return b;
        } else {
            return null;
        }
    }
    public Deposito(int c) {
        dep = new ArrayList<Bebida>(c);
    }
}

class DepositoM {
    private ArrayList<Moneda> depM;
    public void addMoneda(Moneda moneda) {
        depM.add(moneda);
    }
    public Moneda getMoneda() {
        if (depM.size() != 0) {
            Moneda m = depM.get(0);
            depM.remove(0);
            return m;
        } else {
            return null;
        }
    }
    public DepositoM(int c) {
        depM = new ArrayList<Moneda>(c);
    }
}

abstract class Bebida {
    private int serie;
    public Bebida(int serie) {
        this.serie = serie;
    }
    public int getSerie() {
        return serie;
    }
    public abstract String beber();
}

class Sprite extends Bebida {
    public Sprite(int serie){
        super(serie);
    }@Override
    public String beber() {
        return "sprite";
    }
}

class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    @Override
    public String beber() {
        return "cocacola";
    }
}

class Comprador {
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        this.sonido = null;
        this.vuelto = 0;
        if (m == null) {
            return;
        }
        Bebida bebi = exp.comprarBebida(m, cualBebida);
        if (bebi != null) {
            this.sonido = bebi.beber();
        }

        while (true) {
            Moneda aux = exp.getVuelto();
            if (aux == null) break;
            vuelto += aux.getValor();
        }
    }
    public String queBebiste() {
        return sonido;
    }
    public int cuantoVuelto() {
        return vuelto;
    }
}

abstract class Moneda {
    public Moneda() {}
    public Moneda getSerie() {
        return this;
    }
    public abstract int getValor();
}

class Moneda1500 extends Moneda {
    public Moneda1500() {
        super();
    }
    public int getValor() {
        return 1500;
    }
}

class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
    }
    public int getValor() {
        return 1000;
    }
}

class Moneda500 extends Moneda {
    public Moneda500() {
        super();
    }
    public int getValor() {
        return 500;
    }
}

class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }
    public int getValor() {
        return 100;
    }
}