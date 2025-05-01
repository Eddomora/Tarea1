package org.example;

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
