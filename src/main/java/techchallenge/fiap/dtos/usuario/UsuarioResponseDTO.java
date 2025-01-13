package techchallenge.fiap.dtos.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import techchallenge.fiap.dtos.endereco.EnderecoResponseDTO;
import techchallenge.fiap.entities.Endereco;
import techchallenge.fiap.entities.Usuario;

import java.time.LocalDate;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String login;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate ultimaAlteracao;
    private EnderecoResponseDTO endereco;

    @Deprecated
    public UsuarioResponseDTO() {}

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.login = usuario.getLogin();
        this.ultimaAlteracao = usuario.getUltimaAlteracao();
        this.endereco = usuario.getEndereco()
            .map(EnderecoResponseDTO::new).orElse(null);
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

    public LocalDate getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public EnderecoResponseDTO getEndereco() {
        return endereco;
    }
}
