package br.com.tokiomarine.seguradora.controllers.handlers;

import br.com.tokiomarine.seguradora.dto.ApiErrorResponseDTO;
import br.com.tokiomarine.seguradora.dto.CustomError;
import br.com.tokiomarine.seguradora.dto.ValidationError;
import br.com.tokiomarine.seguradora.services.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Instant;


@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados inválidos", request.getRequestURI());
        for (FieldError f: e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ApiErrorResponseDTO> apiErrorResponse(HttpClientErrorException e, HttpServletRequest request) throws IOException {
        HttpStatus status = e.getStatusCode();

        ObjectMapper objectMapper = new ObjectMapper();
        ApiErrorResponseDTO errorMessage = objectMapper.readValue(e.getResponseBodyAsString(), ApiErrorResponseDTO.class);

        ApiErrorResponseDTO err = new ApiErrorResponseDTO(errorMessage.getMeta(), errorMessage.getResult(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
