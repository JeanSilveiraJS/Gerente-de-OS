package br.csi.gerentedeos.controller;

import br.csi.gerentedeos.model.prestador.Prestador;
import br.csi.gerentedeos.service.PrestadorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/prestador")
public class PrestadorController {
    private final PrestadorService service;
    public PrestadorController(PrestadorService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity criaPrestador(@Valid @RequestBody Prestador prestador, UriComponentsBuilder uriBuilder) {
        this.service.create(prestador);
        URI uri = uriBuilder.path("/prestador/{id}").buildAndExpand(prestador.getId()).toUri();

        return ResponseEntity.created(uri).body(prestador);
    }
}
