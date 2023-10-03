package br.csi.gerentedeos.model.prestador;

import br.csi.gerentedeos.model.entidade.Entidade;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
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
    private String senha;
}
