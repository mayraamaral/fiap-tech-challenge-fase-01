package techchallenge.fiap.dtos.endereco;

import jakarta.validation.constraints.NotBlank;
import techchallenge.fiap.entities.Endereco;

import java.util.Optional;

public class EnderecoCreateDTO {

    @NotBlank
    private String rua;
    @NotBlank
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String pais;
    @NotBlank
    private String cep;

    @Deprecated
    public EnderecoCreateDTO() {}

    public EnderecoCreateDTO(String rua, String numero, String complemento, String bairro, String cidade, String estado, String pais, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }

    public Endereco toEntity() {
        return new Endereco(
            rua,
            numero,
            getComplemento().orElse(null),
            getBairro().orElse(null),
            getCidade().orElse(null),
            estado,
            pais,
            cep
        );
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public Optional<String> getComplemento() {
        return Optional.ofNullable(complemento);
    }

    public Optional<String> getBairro() {
        return Optional.ofNullable(bairro);
    }

    public Optional<String> getCidade() {
        return Optional.ofNullable(cidade);
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    public String getCep() {
        return cep;
    }
}
