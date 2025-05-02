package org.example.Excepciones;

public class NoHayProductoException extends Exception{
    public NoHayProductoException(String mensajeError){
        super(mensajeError);
    }
}
