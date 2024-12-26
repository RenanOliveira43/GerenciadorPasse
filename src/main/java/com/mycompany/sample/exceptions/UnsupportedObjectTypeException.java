package com.mycompany.sample.exceptions;

/**
 * Exceção que indica que um tipo de objeto não é suportado.
 * Pode ser usada para sinalizar erros em operações que recebem tipos de objeto incompatíveis.
 */
public class UnsupportedObjectTypeException extends RuntimeException {

    /**
     * Construtor que aceita uma mensagem descritiva do erro.
     * 
     * @param message Mensagem descrevendo o motivo da exceção.
     */
    public UnsupportedObjectTypeException(String message) {
        super(message);
    }

    /**
     * Construtor que aceita uma mensagem descritiva do erro e uma causa.
     * 
     * @param message Mensagem descrevendo o motivo da exceção.
     * @param cause A causa original da exceção, usada para encadeamento de exceções.
     */
    public UnsupportedObjectTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}