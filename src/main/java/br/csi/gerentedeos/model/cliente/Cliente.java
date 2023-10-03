package br.csi.gerentedeos.model.cliente;

import br.csi.gerentedeos.model.entidade.Entidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "idcliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Entidade {
    private boolean ativo;
}
