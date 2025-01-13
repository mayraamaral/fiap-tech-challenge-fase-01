package techchallenge.fiap.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Optional;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    /**
     * Número do endereço.
     * Armazenado como String para permitir valores como "S/N" (sem número)
     * ou números com letras (e.g., "1000A").
     */
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    @Deprecated
    public Endereco() {}

    /**
     * Construtor para criação de endereços sem ID.
     *
     * @param rua rua do endereço
     * @param numero número do endereço
     * @param complemento complemento do endereço, se houver
     * @param bairro bairro do endereço, se houver
     * @param cidade cidade do endereço, se houver
     * @param estado estado do endereço
     * @param pais país do endereço
     * @param cep código postal do endereço
     */
    public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String estado, String pais, String cep) {
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

    public Endereco(Long id, String rua, String numero, String complemento, String bairro, String cidade, String estado, String pais, String cep) {
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

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    /**
     * Retorna o complemento do endereço, se disponível.
     * @return um Optional contendo o complemento, ou um Optional vazio se não houver complemento.
     */
    public Optional<String> getComplemento() {
        return Optional.ofNullable(complemento);
    }

    /**
     * Retorna o bairro do endereço, se disponível.
     * @return um Optional contendo o bairro ou um Optional vazio.
     */
    public Optional<String> getBairro() {
        return Optional.ofNullable(bairro);
    }

    /**
     * Retorna a cidade do endereço, se disponível.
     * @return um Optional contendo a cidade ou um Optional vazio.
     */
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
