package com.library.exceptions;

//* Casos de uso: parâmetros das colunas não concordante com o tipo de dado
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String message) {
        super(message);
    }
}