package techchallenge.fiap.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import techchallenge.fiap.dtos.usuario.*;
import techchallenge.fiap.repositories.UsuarioRepository;
import techchallenge.fiap.utils.exceptions.DadosIncorretosException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        usuario.ifPresent(u -> u.atualizarDadosSeSenhaEstiverCorreta(updateDTO));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/troca-de-senha/{id}")
    @Transactional
    public ResponseEntity atualizarSenha(@PathVariable Long id, @RequestBody @Valid UsuarioTrocaDeSenhaDTO trocaDeSenhaDTO) {
        var usuario = usuarioRepository.findById(id);
        usuario.ifPresent(u -> u.atualizarSenhaSeSenhaAtualEstiverCorreta(trocaDeSenhaDTO));

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> fazerLogin(@RequestBody @Valid UsuarioLoginDTO usuarioLoginDTO) {
        var usuario = usuarioRepository.findByLogin(usuarioLoginDTO.getLogin())
            .orElseThrow(() -> new DadosIncorretosException("Dados incorretos"));

        if (!usuario.aSenhaEstaCorreta(usuarioLoginDTO.getSenha())) {
            throw new DadosIncorretosException("Dados incorretos");
        }

        return ResponseEntity.ok(
            new HashMap<>(Map.of("message", "Login realizado com sucesso"))
        );

    }
}
