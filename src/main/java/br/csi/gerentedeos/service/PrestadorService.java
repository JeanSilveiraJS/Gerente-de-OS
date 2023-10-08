package br.csi.gerentedeos.service;

import br.csi.gerentedeos.model.prestador.Prestador;
import br.csi.gerentedeos.model.prestador.PrestadorRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestadorService {
    private final PrestadorRepository repository;
    public PrestadorService(PrestadorRepository repository) {
        this.repository = repository;
    }

    //CRUD
    public void create(Prestador prestador) {
        repository.save(prestador);
    }
    public List<Prestador> read() {
        return repository.findAll();
    }
    public Prestador readById(Long id) {
        return repository.findById(id).get();
    }
    public void update(@NotBlank Prestador prestador) {
        Prestador p = repository.getReferenceById(prestador.getId());

        p.setNome(prestador.getNome());
        p.setCpf(prestador.getCpf());
        p.setCnpj(prestador.getCnpj());
        p.setIe(prestador.getIe());
        p.setEmail(prestador.getEmail());
        p.setTelefone(prestador.getTelefone());
        p.setEndereco(prestador.getEndereco());
        p.setSenha(prestador.getSenha());
    }
    public void delete(Long id) {
        repository.delete(repository.findById(id).get());
    }
}
