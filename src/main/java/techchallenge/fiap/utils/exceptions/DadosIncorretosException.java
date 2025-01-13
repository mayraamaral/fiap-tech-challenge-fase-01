package techchallenge.fiap.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DadosIncorretosException extends RuntimeException {
    public DadosIncorretosException(String message) {
        super(message);
    }

    @Deprecated
    public DadosIncorretosException() {
        super(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }
}
