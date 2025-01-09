package techchallenge.fiap.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import techchallenge.fiap.entities.Endereco;
import techchallenge.fiap.entities.Usuario;

import java.time.LocalDate;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate ultimaAlteracao;
    private Long idEndereco;

    @Deprecated
    public UsuarioResponseDTO() {}

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.ultimaAlteracao = usuario.getUltimaAlteracao();
        this.idEndereco = usuario.getEndereco().map(Endereco::getId)
            .orElse(null);
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

    public LocalDate getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }
}
