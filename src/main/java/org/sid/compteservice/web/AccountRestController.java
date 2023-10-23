package org.sid.compteservice.web;

import org.sid.compteservice.dto.CompteRequestDto;
import org.sid.compteservice.dto.CompteResponseDto;
import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.repositories.BankAccountRepository;
import org.sid.compteservice.service.CompteService;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    @Lazy
    private CompteService compteService;

    public AccountRestController(BankAccountRepository bankAccountRepository, CompteService compteService) {
        this.bankAccountRepository = bankAccountRepository;
        this.compteService = compteService;
    }


    @GetMapping("/comptes")
    public List<Compte> comptes()
    {
        return bankAccountRepository.findAll();
    }
    public Compte compte(@PathVariable  String id)
    {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(
            String.format("Account %s Not Found")));
    }
    @PostMapping("/comptes")
    public CompteResponseDto save(@RequestBody CompteRequestDto compteDto)
    {
        return compteService.addCount(compteDto);
    }
    @PutMapping("/comptes/{id}")
    public Compte update(@RequestBody Compte compte,@PathVariable String id)
    {
        Compte compte1=bankAccountRepository.findById(id).orElseThrow();
        if(compte1.getBalance()!=null)  compte1.setBalance(compte.getBalance());
        if(compte1.getDateCreation()!=null)  compte1.setDateCreation(new Date());
        if(compte1.getType()!=null)  compte1.setType(compte.getType());
        if(compte1.getCurrency()!=null) compte1.setCurrency(compte.getCurrency());
        return bankAccountRepository.save(compte1);
    }
    @DeleteMapping("/comptes/{id}")
    public void deleteAccount(@PathVariable String id)
    {
        bankAccountRepository.deleteById(id);
    }
}
