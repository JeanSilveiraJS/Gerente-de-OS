package br.csi.gerentedeos.service;

import br.csi.gerentedeos.model.cliente.Cliente;
import br.csi.gerentedeos.model.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void create(Cliente cliente) {
        repository.save(cliente);
    }

    public List<Cliente> read() {
        return repository.findAll();
    }

    public Cliente readById(Long id) {
        return repository.findById(id).get();
    }

    public void update(Cliente cliente) {
        repository.save(cliente);
    }

    public void delete(Cliente cliente) {
        repository.delete(cliente);
    }
}
