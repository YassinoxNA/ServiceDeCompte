package org.sid.compteservice.repositories;

import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
