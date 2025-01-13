package techchallenge.fiap.entities;

import jakarta.persistence.*;
import techchallenge.fiap.dtos.endereco.EnderecoCreateDTO;
import techchallenge.fiap.dtos.usuario.UsuarioTrocaDeSenhaDTO;
import techchallenge.fiap.dtos.usuario.UsuarioUpdateDTO;
import techchallenge.fiap.utils.PasswordEncoderProvider;

import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private LocalDate ultimaAlteracao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Endereco endereco;

    @Deprecated
    public Usuario() {}

    public Usuario(Long id, String nome, String email, String login, String senha, LocalDate ultimaAlteracao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public Usuario(String nome, String email, String login, String senha, LocalDate ultimaAlteracao, EnderecoCreateDTO enderecoDTO) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = PasswordEncoderProvider.encode(senha);
        this.ultimaAlteracao = ultimaAlteracao;
        this.endereco = enderecoDTO.toEntity();
    }

    public boolean aSenhaEstaCorreta(String senha) {
        return PasswordEncoderProvider.matches(senha, this.senha);
    }

    public void atualizarDadosSeSenhaEstiverCorreta(UsuarioUpdateDTO usuarioUpdate) {
        if(!this.aSenhaEstaCorreta(usuarioUpdate.getSenha())) return;

        this.nome = usuarioUpdate.getNome();
        this.email = usuarioUpdate.getEmail();
        this.login = usuarioUpdate.getLogin();
        this.ultimaAlteracao = LocalDate.now();
    }

    public void atualizarSenhaSeSenhaAtualEstiverCorreta(UsuarioTrocaDeSenhaDTO trocaDeSenhaDTO) {
        if(!this.aSenhaEstaCorreta(trocaDeSenhaDTO.getSenhaAtual())) return;

        this.senha = PasswordEncoderProvider.encode(trocaDeSenhaDTO.getNovaSenha());
        this.ultimaAlteracao = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public Optional<Endereco> getEndereco() {
        return Optional.ofNullable(endereco);
    }
}
