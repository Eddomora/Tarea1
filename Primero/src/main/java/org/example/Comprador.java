package org.example;

class Comprador {
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualProducto, int precio, Expendedor exp) /*throws Expendedor.PagoInsuficienteException, Expendedor.PagoIncorrectoException */{
        this.sonido = null;
        this.vuelto = 0;
        if (m == null) {
            return;
        }
        Bebida bebi = (Bebida) exp.comprarProducto(m, cualProducto, precio);
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
