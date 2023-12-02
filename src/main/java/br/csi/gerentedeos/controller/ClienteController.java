package br.csi.gerentedeos.controller;

import br.csi.gerentedeos.model.cliente.Cliente;
import br.csi.gerentedeos.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listaClientes() {
        return ResponseEntity.ok(service.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaCliente(@PathVariable long id) {
        return ResponseEntity.ok(service.readById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity criaCliente(@Valid @RequestBody Cliente cliente, UriComponentsBuilder uriBuilder) {
        service.create(cliente);
        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(cliente);
    }
}
