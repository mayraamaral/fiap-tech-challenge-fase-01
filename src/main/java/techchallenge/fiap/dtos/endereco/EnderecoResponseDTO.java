package techchallenge.fiap.dtos.endereco;

import techchallenge.fiap.entities.Endereco;

public class EnderecoResponseDTO {

    private Long id;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    @Deprecated
    public EnderecoResponseDTO() {}

    public EnderecoResponseDTO(Long id, String rua, String numero, String complemento, String bairro, String cidade, String estado, String pais, String cep) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }

    public EnderecoResponseDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento().orElse(null);
        this.bairro = endereco.getBairro().orElse(null);
        this.cidade = endereco.getCidade().orElse(null);
        this.estado = endereco.getEstado();
        this.pais = endereco.getPais();
        this.cep = endereco.getCep();
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
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
