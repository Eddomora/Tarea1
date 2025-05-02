package org.example.Excepciones;

public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(String mensajeError) {
        super(mensajeError);
    }
}

