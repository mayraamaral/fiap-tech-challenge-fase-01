package techchallenge.fiap.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techchallenge.fiap.dtos.UsuarioCreateDTO;
import techchallenge.fiap.dtos.UsuarioResponseDTO;
import techchallenge.fiap.repositories.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        List<UsuarioResponseDTO> list = usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();

        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody @Valid UsuarioCreateDTO usuarioDTO) {
        var usuario = new UsuarioResponseDTO(usuarioRepository.save(usuarioDTO.toEntity()));

        return ResponseEntity.ok(usuario);
    }
}
