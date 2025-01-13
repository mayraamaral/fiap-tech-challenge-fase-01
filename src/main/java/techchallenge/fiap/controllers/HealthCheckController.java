package techchallenge.fiap.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Hidden
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity checarSaudeServidor() {
        return ResponseEntity.ok().build();
    }

}
