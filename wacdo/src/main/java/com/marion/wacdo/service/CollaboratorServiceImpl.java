package com.marion.wacdo.service;

import com.marion.wacdo.dto.*;
import com.marion.wacdo.entities.Affectation;
import com.marion.wacdo.entities.Collaborator;
import com.marion.wacdo.entities.Job;
import com.marion.wacdo.entities.Restaurant;
import com.marion.wacdo.repository.AffectationRepository;
import com.marion.wacdo.repository.CollaboratorRepository;
import com.marion.wacdo.repository.JobRepository;
import com.marion.wacdo.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional

public class CollaboratorServiceImpl implements CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;
    private final ModelMapper modelMapper;

    public CollaboratorServiceImpl(CollaboratorRepository collaboratorRepository, ModelMapper modelMapper) {
        this.collaboratorRepository = collaboratorRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<CollaboratorDTO> listerFiltrer(String lastname, String firstname, String email) {
        return collaboratorRepository.listerFiltrer(lastname, firstname, email)
                .stream()
                .map(collaborator -> modelMapper.map(collaborator, CollaboratorDTO.class))
                .toList();
    }

    @Override
    public List<CollaboratorDTO> getCollaboratorsNonAffectes() {
        return collaboratorRepository.findCollaboratorsNonAffectes()
                .stream()
                .map(collaborator -> modelMapper.map(collaborator, CollaboratorDTO.class))
                .toList();
    }

    @Override
    public CollaboratorCreateDTO create(CollaboratorCreateDTO collaboratorDto) {
        Collaborator collaborator = modelMapper.map(collaboratorDto, Collaborator.class); // DTO -> Entité
        Collaborator savedCollaborator = collaboratorRepository.save(collaborator);          // Enregistre en base
        return modelMapper.map(savedCollaborator, CollaboratorCreateDTO.class); // Entité -> DTO

    }

    @Override
    public CollaboratorDTO update(Long id, CollaboratorDTO collaboratorDTO) {

        Collaborator collaborator = collaboratorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Collaborator not found with id : " + id));

        modelMapper.map(collaboratorDTO, collaborator); // copie les champs dans l'entité existante

        Collaborator updatedCollaborator = collaboratorRepository.save(collaborator);

        return modelMapper.map(updatedCollaborator, CollaboratorDTO.class);
    }

    @Override
    public void delete(Long id) {

        if (!collaboratorRepository.existsById(id)) {
            throw new RuntimeException("Collaborator not found with id : " + id);
        }

        collaboratorRepository.deleteById(id);
    }























}
