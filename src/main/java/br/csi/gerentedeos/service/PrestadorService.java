package br.csi.gerentedeos.service;

import br.csi.gerentedeos.model.prestador.Prestador;
import br.csi.gerentedeos.model.prestador.PrestadorRepository;
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
    public void update(Prestador prestador) {
        repository.save(prestador);
    }
    public void delete(Prestador prestador) {
        repository.delete(prestador);
    }
}
