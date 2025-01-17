package techchallenge.fiap.dtos.usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import techchallenge.fiap.dtos.endereco.EnderecoCreateDTO;
import techchallenge.fiap.entities.Usuario;

import java.time.LocalDate;

public class UsuarioCreateDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    @NotNull
    @Valid
    private EnderecoCreateDTO endereco;

    @Deprecated
    public UsuarioCreateDTO() {}

    public UsuarioCreateDTO(String nome, String email, String login, String senha) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Usuario toEntity() {
        return new Usuario(
            nome,
            email,
            login,
            senha,
            LocalDate.now(),
            endereco
        );
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

    public EnderecoCreateDTO getEndereco() {
        return endereco;
    }
}
