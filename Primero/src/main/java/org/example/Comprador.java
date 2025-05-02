package org.example;

class Comprador {
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualProducto, int precio, Expendedor exp) throws Expendedor.PagoInsuficienteException, Expendedor.PagoIncorrectoException /*throws Expendedor.PagoInsuficienteException, Expendedor.PagoIncorrectoException */{
        this.sonido = null;
        this.vuelto = 0;

        if (cualProducto==1 || cualProducto==2 || cualProducto==3 || cualProducto == 4 || cualProducto == 5) {
            Bebida compra = (Bebida) exp.comprarProducto(m, cualProducto, precio);
            if (compra != null) {
                this.sonido = compra.accion();
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
