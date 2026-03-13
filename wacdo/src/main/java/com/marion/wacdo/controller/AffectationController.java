package com.marion.wacdo.controller;

import com.marion.wacdo.dto.AffectationDTO;
import com.marion.wacdo.service.AffectationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/affectations")
public class AffectationController {

    private final AffectationService affectationService;

    public AffectationController(AffectationService affectationService) {
        this.affectationService = affectationService;
    }

    @GetMapping
    public List<AffectationDTO> getAll() {
        return affectationService.getAll();
    }

    @GetMapping("/{id}")
    public AffectationDTO getDetail(@PathVariable Long id) {
        return affectationService.getDetail(id);
    }

    @GetMapping("/search")
    public List<AffectationDTO> search(
            @RequestParam(required = false) String jobTitle,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) String city
    ) {
        return affectationService.search(jobTitle, startDate, endDate, city);
    }

    @GetMapping("/collaborator/{id}")
    public List<AffectationDTO> getByCollaborator(@PathVariable Long id) {
        return affectationService.getByCollaborator(id);
    }

    @GetMapping("/restaurant/{id}/current")
    public List<AffectationDTO> getCurrentByRestaurant(@PathVariable Long id) {
        return affectationService.getCurrentByRestaurant(id);
    }

    @PostMapping
    public AffectationDTO create(@RequestBody AffectationDTO dto) {
        return affectationService.create(dto);
    }

    @PutMapping("/{id}")
    public AffectationDTO update(@PathVariable Long id, @RequestBody AffectationDTO dto) {
        return affectationService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        affectationService.delete(id);
    }
}