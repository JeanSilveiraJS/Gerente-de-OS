package br.csi.gerentedeos.model.entidade;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "entidade", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nome"),
        @UniqueConstraint(columnNames = "cpf"),
        @UniqueConstraint(columnNames = "cnpj"),
        @UniqueConstraint(columnNames = "email")
})
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entidade {
    @Check(constraints = "id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @CPF(message = "CPF inválido")
    private String cpf;
    @CNPJ(message = "CNPJ inválido")
    private String cnpj;
    @Size(max = 13, message = "Inscrição Estadual não pode exceder 13 caracteres")
    private String ie;
    @Email(message = "E-mail inválido")
    private String email;
    @Pattern(regexp = "([(][0-9]{2}[)] [0-9]{5}-[0-9]{4})|([(][0-9]{2}[)] [0-9]{4}-[0-9]{4})|([0-9]{10})", message = "Número inválido")
    private String telefone;
    @Valid
    @Embedded
    private Endereco endereco;
}
