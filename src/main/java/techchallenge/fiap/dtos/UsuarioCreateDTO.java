package techchallenge.fiap.dtos;

import jakarta.validation.constraints.NotBlank;
import techchallenge.fiap.entities.Usuario;
import techchallenge.fiap.utils.PasswordEncoderProvider;

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
            PasswordEncoderProvider.encode(senha),
            LocalDate.now()
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
}
