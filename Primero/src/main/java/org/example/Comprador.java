package org.example;
import org.example.Excepciones.*;

class Comprador {
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualProducto, int precio, Expendedor exp) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException{
        this.sonido = null;
        this.vuelto = 0;

        if (cualProducto==1 || cualProducto==2 || cualProducto==3) {
            Bebida compra = (Bebida) exp.comprarProducto(m, cualProducto, precio);
            if (compra != null) {
                this.sonido = compra.accion();
            }
        } else if (cualProducto==4 || cualProducto==5) {
            Dulces compra = (Dulces) exp.comprarProducto(m, cualProducto, precio);
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
//public Comprador(Moneda m, int cualBebida, Expendedor exp){
//        Bebida b = exp.comprarBebida(m,cualBebida);
//        if (b != null) {
//            sonido = b.beber();
//        }
//        Moneda monedaSaliente = exp.getVuelto();
//        while(monedaSaliente != null){
//            vuelto += monedaSaliente.getValor();
//            monedaSaliente = exp.getVuelto();
//        }
//    }
