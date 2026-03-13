package com.marion.wacdo.controller;

import com.marion.wacdo.dto.*;
import com.marion.wacdo.service.CollaboratorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/collaborators")

public class CollaboratorController {

        private final CollaboratorService service;

        public CollaboratorController(CollaboratorService service) {
            this.service = service;
        }

    @GetMapping
    public List<CollaboratorDTO> rechercher(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String prenom,
            @RequestParam(required = false) String email) {

        return service.listerFiltrer(nom, prenom, email);
    }

    @GetMapping("/non-affectes")
    public List<CollaboratorDTO> nonAffectes() {
        return service.getCollaboratorsNonAffectes();
    }


    @PostMapping
    public CollaboratorCreateDTO create(@RequestBody CollaboratorCreateDTO dto) {
        return service.create(dto);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CollaboratorDTO update(
            @PathVariable Long id,
            @RequestBody CollaboratorDTO collaboratorDTO) {

        return service.update(id, collaboratorDTO);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }




    }

