package br.pucpr.nightlifeserver.rest.establishments;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/establishments")
public class EstablishmentsResource {
    private EstablishmentsService service;
    public EstablishmentsResource(EstablishmentsService service) {
        this.service = service;
    }

    @GetMapping
    @Transactional
    public List<Establishments> getAllEstablishments() {
        return service.getAllEstablishments();
    }


    @PostMapping
    @Transactional
    @SecurityRequirement(name = "Primeiro Servidor")
    @RolesAllowed({"ADMIN", "COMMERCIAL", "USER"})
    public ResponseEntity<Establishments> add(@Valid @RequestBody Establishments establishment) {
        return ResponseEntity.ok(service.addEstablishment(establishment));
    }

    @DeleteMapping("{id}")
    @Transactional
    @SecurityRequirement(name = "Primeiro Servidor")
    @RolesAllowed({"ADMIN", "COMMERCIAL", "USER"})
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.deleteEstablishment(id);
        return ResponseEntity.ok().build();
    }
}
