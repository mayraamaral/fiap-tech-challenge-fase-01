package techchallenge.fiap.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class DadosIncorretosLoginException extends RuntimeException {
    public DadosIncorretosLoginException(String message) {
        super(message);
    }

    @Deprecated
    public DadosIncorretosLoginException() {
        super(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }
}
