package com.marion.wacdo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public abstract class CollaboratorBaseDTO {

        @NotBlank(message = "Le nom est obligatoire")
        private String lastname;

        @NotBlank(message = "Le prénom est obligatoire")
        private String firstname;

        @NotBlank(message = "L'email est obligatoire")
        @Email(message = "Format d'email invalide")
        private String email;

        public CollaboratorBaseDTO() {}
}
