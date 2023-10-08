alter table entidade
    add constraint entidade_cpf_cnpj_check
        check (cpf is not null and cnpj is null or cpf is null and cnpj is not null);

alter table entidade
    drop constraint entidade_telefone_key;