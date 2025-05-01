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

        if (cualProducto==1 || cualProducto==2 || cualProducto==3) {
            Bebida compra = (Bebida) exp.comprarProducto(m, cualProducto, precio);
            if (compra != null) {
                this.sonido = compra.beber();
            }
        } else if (cualProducto==4 || cualProducto==5){
            Dulces compra = (Dulces) exp.comprarProducto(m, cualProducto, precio);
            if (compra != null) {
                this.sonido = compra.comer();
            }
        }

        while (true) {
            Moneda aux = exp.getVuelto();
            if (aux == null) break;
            vuelto += aux.getValor();
        }
    }
    public String queCompraste() {
        return sonido;
    }
    public int cuantoVuelto() {
        return vuelto;
    }

}
