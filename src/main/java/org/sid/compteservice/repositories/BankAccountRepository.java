package org.sid.compteservice.repositories;

import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<Compte,String> {
    @RestResource(path="/byType")
    List<Compte> findByType(@Param("t") AccountType type);

}
