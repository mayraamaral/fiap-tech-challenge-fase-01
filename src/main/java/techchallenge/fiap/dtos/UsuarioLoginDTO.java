package techchallenge.fiap.dtos;

import jakarta.validation.constraints.NotBlank;

public class UsuarioLoginDTO {

    @NotBlank
    private String login;
    @NotBlank
    private String senha;

    @Deprecated
    public UsuarioLoginDTO() {}

    public UsuarioLoginDTO(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
