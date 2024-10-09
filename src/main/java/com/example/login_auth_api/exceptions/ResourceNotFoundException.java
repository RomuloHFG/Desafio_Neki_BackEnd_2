package com.example.login_auth_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

//A ResourceNotFoundException é uma maneira eficaz de lidar com situações em que os recursos solicitados não estão disponíveis,
//fornecendo uma mensagem clara e um código de status HTTP apropriado.