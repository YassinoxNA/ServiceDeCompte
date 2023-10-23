package org.sid.compteservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.compteservice.dto.CompteRequestDto;
import org.sid.compteservice.dto.CompteResponseDto;
import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.entities.Customer;
import org.sid.compteservice.mappers.CompteMapper;
import org.sid.compteservice.repositories.BankAccountRepository;
import org.sid.compteservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class CompteService implements ComptegraphQlController {

    private CompteMapper compteMapper;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    @Lazy
    private CompteService compteService;

    @QueryMapping
    public List<Compte> comptesList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public Compte compteById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Account %s Not Found", id)));
    }

    public CompteResponseDto AddCompte(@Argument CompteRequestDto compteDto) {
        return compteService.AddCompte(compteDto);
    }

    @Override
    public CompteResponseDto updateCompte(CompteRequestDto compteDto, String id) {
        return compteService.updateCompte(compteDto,id);
    }
    @MutationMapping
    public Boolean deleteCompte(@Argument String id)
    {
         bankAccountRepository.deleteById(id);
         return true;
    }
    @QueryMapping
    public List<Customer> customers()
    {
        return customerRepository.findAll();
    }


}


