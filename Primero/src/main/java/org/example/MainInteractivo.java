package org.example;
import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) throws Expendedor.PagoInsuficienteException, Expendedor.PagoIncorrectoException {
        Scanner scanner = new Scanner(System.in);
        Moneda m = new Moneda1500();
        Expendedor exp = new Expendedor(10); //modificar con el enum
        Comprador c = null;
        imprimirOpciones();
        int eleccion = scanner.nextInt();
        switch (eleccion) {
            case 1:
                c = new Comprador(m,1, PRECIOS.COCACOLA.getPrecio(), exp);

                break;
            case 2:
                c = new Comprador(m,2, PRECIOS.FANTA.getPrecio(), exp);

                break;
            case 3:
                c = new Comprador(m,3, PRECIOS.SPRITE.getPrecio(), exp);

                break;
            case 4:
                c = new Comprador(m,4, PRECIOS.SUPER8.getPrecio(), exp);

                break;
            case 5:
                c = new Comprador(m,5, PRECIOS.SNICKERS.getPrecio(), exp);

                break;
            default:
                System.out.println("Elección no válida.");
        }
        scanner.close();
    }
    public static void imprimirOpciones(){
        System.out.println("Elige una comida o bebida:");
        System.out.println("1. Coca cola");
        System.out.println("2. Sprite");
        System.out.println("3. Fanta");
        System.out.println("4. Super 8");
        System.out.println("5. Snicker");
        System.out.print("Ingresa el número de tu elección: ");
    }
}
