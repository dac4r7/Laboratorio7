package com.lab.laboratorio7;

/*
  */

/**
 *
 * @author diego
 */
public class PedidoInvalidoException extends RuntimeException{

    public PedidoInvalidoException() {
        super();
    }

    public PedidoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public PedidoInvalidoException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }
    
    
    
}
