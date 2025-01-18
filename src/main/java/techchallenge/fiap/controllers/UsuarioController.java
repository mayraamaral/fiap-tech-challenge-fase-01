package techchallenge.fiap.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import techchallenge.fiap.dtos.usuario.*;
import techchallenge.fiap.services.UsuarioService;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuário", description = "Operações relacionadas à entidade do usuário")
public class UsuarioController implements IUsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> listarTudo(@Parameter(hidden = true) Pageable pageable) {
        return ResponseEntity.ok(usuarioService.listarTodos(pageable));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody @Valid UsuarioCreateDTO usuarioDTO) {
        return new ResponseEntity<>(
            usuarioService.criar(usuarioDTO),
            HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateDTO updateDTO) {
        usuarioService.atualizarDados(id, updateDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/troca-de-senha/{id}")
    @Transactional
    public ResponseEntity atualizarSenha(@PathVariable Long id, @RequestBody @Valid UsuarioTrocaDeSenhaDTO trocaDeSenhaDTO) {
        usuarioService.atualizarSenha(id, trocaDeSenhaDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> fazerLogin(@RequestBody @Valid UsuarioLoginDTO usuarioLoginDTO) {
        return ResponseEntity.ok(usuarioService.fazerLogin(usuarioLoginDTO));
    }

}
