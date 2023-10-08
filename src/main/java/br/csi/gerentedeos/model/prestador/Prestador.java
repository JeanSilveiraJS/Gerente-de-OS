package br.csi.gerentedeos.model.prestador;

import br.csi.gerentedeos.model.entidade.Entidade;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "idprestador")
@Table(name = "prestador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prestador extends Entidade {
    @NotBlank
    @Size(min = 4, message = "Senha deve ter mais de 4 caracteres")
    @Size(max = 30, message = "Senha não pode exceder 30 caracteres")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{4,40}$", message = "Senha não atende os requisitos mínimos")
    private String senha;
}
