package br.csi.gerentedeos.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();
        List<DadosErroValidacao> dados = new ArrayList<>();

        for (FieldError fe : errors) {
            dados.add(new DadosErroValidacao(fe.getField(), fe.getDefaultMessage()));
        }

        return ResponseEntity.badRequest().body(dados);
    }

    private record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    //Erros de validação
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String details = ex.getCause().getMessage();

        ApiError error = new ApiError(null, "Erro de conscistência de dados");

        //Primary Key
        if (details.contains("entidade_nome_key")) {
            error = new ApiError("nome", "Nome já cadastrado");
        }
        if (details.contains("entidade_cpf_key")) {
            error = new ApiError("cpf", "CPF já cadastrado");
        }
        if (details.contains("entidade_cnpj_key")) {
            error = new ApiError("cpf", "CNPJ já cadastrado");
        }
        if (details.contains("entidade_email_key")) {
            error = new ApiError("email", "E-mail já cadastrado");
        }
        if (details.contains("entidade_ie_key")) {
            error = new ApiError("ie", "Inscrição Estadual já cadastrada");
        }

        //Check
        if (details.contains("entidade_cpf_cnpj_check")) {
            error = new ApiError("cpf_cnpj", "Cadastro não deve conter CPF e CNPJ simultaneamente");
        }

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity tratarErro500(Exception e){
        return ResponseEntity.internalServerError().body("Erro no Banco de Dados");
    }
}
