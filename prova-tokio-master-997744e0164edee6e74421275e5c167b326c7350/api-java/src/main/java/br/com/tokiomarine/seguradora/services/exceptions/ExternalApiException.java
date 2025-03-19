package br.com.tokiomarine.seguradora.services.exceptions;

public class ExternalApiException extends RuntimeException {
    public ExternalApiException(String msg) {
        super(msg);
    }
}
