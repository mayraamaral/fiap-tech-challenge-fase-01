package techchallenge.fiap.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import techchallenge.fiap.dtos.UsuarioCreateDTO;
import techchallenge.fiap.dtos.UsuarioResponseDTO;
import techchallenge.fiap.dtos.UsuarioUpdateDTO;
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
    public ResponseEntity<List<UsuarioResponseDTO>> listarTudo() {
        List<UsuarioResponseDTO> list = usuarioRepository.findAll()
            .stream().map(UsuarioResponseDTO::new).toList();

        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody @Valid UsuarioCreateDTO usuarioDTO) {
        var usuario = new UsuarioResponseDTO(usuarioRepository.save(usuarioDTO.toEntity()));

        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateDTO updateDTO) {
        var usuario = usuarioRepository.findById(id);
        usuario.ifPresent(u -> u.atualizarSeSenhaEstiverCorreta(updateDTO));

        return ResponseEntity.noContent().build();
    }
}
