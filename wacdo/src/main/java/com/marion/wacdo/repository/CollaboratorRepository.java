package com.marion.wacdo.repository;

import com.marion.wacdo.entities.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollaboratorRepository extends JpaRepository <Collaborator, Long>
        {

            @Query(value = """
    SELECT * FROM collaborator
    WHERE (:lastname IS NULL OR LOWER(last_name) LIKE LOWER(CONCAT('%', :lastname, '%')))
      AND (:firstname IS NULL OR LOWER(first_name) LIKE LOWER(CONCAT('%', :firstname, '%')))
      AND (:email IS NULL OR LOWER(email) LIKE LOWER(CONCAT('%', :email, '%')))
""", nativeQuery = true)
    List<Collaborator> listerFiltrer(
            @Param("lastname") String lastname,
            @Param("firstname") String firstname,
            @Param("email") String email
    );


    @Query(value = """
        SELECT c FROM Collaborator c
        WHERE c.id NOT IN (
            SELECT a.collaborator.id FROM Affectation a
            WHERE a.endDateAffectation IS NULL
        )
    """)
    List<Collaborator> findCollaboratorsNonAffectes();

    Optional<Collaborator> findByEmail(String email);

}
