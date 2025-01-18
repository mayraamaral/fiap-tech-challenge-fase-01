package techchallenge.fiap.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import techchallenge.fiap.dtos.usuario.*;
import techchallenge.fiap.repositories.UsuarioRepository;
import techchallenge.fiap.utils.exceptions.DadosIncorretosLoginException;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Page<UsuarioResponseDTO> listarTodos(Pageable pageable) {
        if (!pageable.getSort().isSorted()) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").ascending());
        }

        return usuarioRepository.findAll(pageable)
            .map(UsuarioResponseDTO::new);
    }

    public UsuarioResponseDTO criar(UsuarioCreateDTO createDTO) {
        return new UsuarioResponseDTO(usuarioRepository.save(createDTO.toEntity()));
    }

    public void atualizarDados(Long id, UsuarioUpdateDTO updateDTO) {
        usuarioRepository.findById(id)
            .ifPresent(u -> u.atualizarDadosSeSenhaEstiverCorreta(updateDTO));
    }

    public void atualizarSenha(Long id, UsuarioTrocaDeSenhaDTO trocaDeSenhaDTO) {
        usuarioRepository.findById(id)
            .ifPresent(u -> u.atualizarSenhaSeSenhaAtualEstiverCorreta(trocaDeSenhaDTO));
    }

    public Map<String, String> fazerLogin(UsuarioLoginDTO loginDTO) {
        var usuario = usuarioRepository.findByLogin(loginDTO.getLogin())
            .orElseThrow(() -> new DadosIncorretosLoginException("Dados incorretos"));

        if (!usuario.aSenhaEstaCorreta(loginDTO.getSenha())) {
            throw new DadosIncorretosLoginException("Dados incorretos");
        }

        return new HashMap<>(Map.of("message", "Login realizado com sucesso"));
    }
}
