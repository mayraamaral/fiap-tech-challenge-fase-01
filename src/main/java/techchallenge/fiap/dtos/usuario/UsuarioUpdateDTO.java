package techchallenge.fiap.dtos.usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import techchallenge.fiap.dtos.endereco.EnderecoUpdateDTO;

public class UsuarioUpdateDTO {

    @NotNull
    @Valid
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

    public record DadosAtualizacao(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String login,
        @NotNull @Valid EnderecoUpdateDTO endereco
    ) {}
}
