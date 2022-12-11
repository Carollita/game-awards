package me.dio.gameawards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import me.dio.gameawards.service.exception.BusinessException;
import me.dio.gameawards.service.exception.NoContentException;


// If game do not exists
@RequestMapping("/api")
public abstract class BaseRestController {
    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Void> handlerNoContentException(NoContentException exception) {
        return ResponseEntity.noContent().build();
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorDto> handlerBusinessException(BusinessException exception) {
        ApiErrorDto error = new ApiErrorDto(exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorDto> handlerUnexpectException(BusinessException exception) {
        // exception.printStackTrace();
        ApiErrorDto error = new ApiErrorDto("Ops...It was unexpect!");
        return ResponseEntity.internalServerError().body(error);
    }
}
