package br.csi.gerentedeos.infra;

import lombok.Data;

// A classe que representa o erro
@Data
public class ApiError {
    private String campo;
    private String mensagem;

    public ApiError(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }
}
