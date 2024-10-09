package com.example.login_auth_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro: " + ex.getMessage());
    }
}

//No GlobalExceptionHandler esta o tratamento de Exceções para lidar com Tratamentos especificos que e quando o recurso nao e encontrado retornando um status HTTP 404(Não Encontrado.
//em seguida esta fazendo o Tratamento de Exceções para lidar com as validações com o MethodArgumentNotValidException, retornando um status HTTP 400 (Requisição Inválida) com detalhes sobre os campos inválidos.
//e por ultimo esta fazendo um tratamento de exceções genéricas que seria qualquer outra exceção não tratada é capturada, retornando um status HTTP 500 (Erro Interno do Servidor) com uma mensagem "genérica".