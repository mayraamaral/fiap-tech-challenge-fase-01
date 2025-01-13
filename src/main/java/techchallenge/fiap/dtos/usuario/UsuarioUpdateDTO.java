package techchallenge.fiap.dtos.usuario;

import jakarta.validation.constraints.NotBlank;

public class UsuarioUpdateDTO {

    private DadosAtualizacao dados;

    @NotBlank
    private String senha;

    @Deprecated
    public UsuarioUpdateDTO() {}

    public UsuarioUpdateDTO(DadosAtualizacao dados, String senha) {
        this.dados = dados;
        this.senha = senha;
    }

    public DadosAtualizacao getDados() {
        return dados;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return dados.nome();
    }

    public String getEmail() {
        return dados.email();
    }

    public String getLogin() {
        return dados.login();
    }

    private record DadosAtualizacao(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String login
    ) {}
}
