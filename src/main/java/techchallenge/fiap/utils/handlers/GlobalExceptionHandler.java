package techchallenge.fiap.utils.handlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import techchallenge.fiap.utils.exceptions.DadosIncorretosLoginException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseWithErrorsMapDTO> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
            .collect(Collectors.toMap(
                FieldError::getField,
                error -> Optional.ofNullable(error.getDefaultMessage())
                    .orElse("Mensagem de erro não disponível")));

        ErrorResponseWithErrorsMapDTO errorResponse = new ErrorResponseWithErrorsMapDTO(
            LocalDateTime.now().toString(),
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            "Validation failed",
            request.getRequestURI(),
            errors);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DadosIncorretosLoginException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidDataLoginException(DadosIncorretosLoginException ex, HttpServletRequest request) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
            LocalDateTime.now().toString(),
            HttpStatus.UNAUTHORIZED.value(),
            HttpStatus.UNAUTHORIZED.getReasonPhrase(),
            ex.getMessage(),
            request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    public record ErrorResponseWithErrorsMapDTO(String timestamp, int status, String error, String message, String path, Map<String, String> errors) {}

    public record ErrorResponseDTO(String timestamp, int status, String error, String message, String path) {}
}