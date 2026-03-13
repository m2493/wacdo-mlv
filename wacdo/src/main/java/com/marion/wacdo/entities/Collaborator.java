package com.marion.wacdo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Collaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @Email
    private String email;
    @PastOrPresent
    private Date hiringDate;
    private boolean isAdmin;
    @NotNull
    private String password;

    @OneToMany(mappedBy = "collaborator")
    private List<Affectation> affectations;



}
