package techchallenge.fiap.dtos;

import jakarta.validation.constraints.NotBlank;

public class UsuarioTrocaDeSenhaDTO {

    @NotBlank
    private String senhaAtual;
    @NotBlank
    private String novaSenha;

    @Deprecated
    public UsuarioTrocaDeSenhaDTO() {}

    public UsuarioTrocaDeSenhaDTO(String senhaAtual, String novaSenha) {
        this.senhaAtual = senhaAtual;
        this.novaSenha = novaSenha;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }
}
