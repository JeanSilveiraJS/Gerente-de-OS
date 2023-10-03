package br.csi.gerentedeos.model.entidade;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @NotBlank(message = "Insira o CEP")
    @Pattern(regexp = "([0-9]{2}[.]?[0-9]{3}-[0-9]{3})|([0-9]{8})", message = "CEP inválido")
    private String cep;
    @NotBlank(message = "Insira a rua")
    @Size(max = 60, message = "Rua inválida")
    private String rua;
    private int numero;
    @Size(max = 20, message = "Complemento inválido")
    private String complemento;
    @NotBlank(message = "Insira o bairro")
    @Size(max = 40, message = "Bairro inválido")
    private String bairro;
    @NotBlank(message = "Insira a cidade")
    @Size(max = 40, message = "Cidade inválida")
    private String cidade;
    @NotBlank(message = "Insira a UF")
    @Pattern(regexp = "([A-Z]{2})", message = "UF inválida")
    private String uf;
}
