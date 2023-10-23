package org.sid.compteservice.service;

import jakarta.transaction.Transactional;
import org.sid.compteservice.dto.CompteRequestDto;
import org.sid.compteservice.dto.CompteResponseDto;
import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.mappers.CompteMapper;
import org.sid.compteservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    private CompteMapper compteMapper;
    @Override
    public CompteResponseDto addCount(CompteRequestDto compteDto) {
        Compte compte = Compte.builder()
                .id(UUID.randomUUID().toString())
                .dateCreation(new Date())
                .balance(compteDto.getBalance())
                .type(compteDto.getType())
                .currency(compteDto.getCurrency())

                .build();
        Compte Savecompte1=bankAccountRepository.save(compte);
         CompteResponseDto  compteResponseDto = compteMapper.FromBankAccount(Savecompte1);
        return compteResponseDto;
    }
    public CompteResponseDto updateCompte(CompteRequestDto compteDto) {
        Compte compte = Compte.builder()
                .id(UUID.randomUUID().toString())
                .dateCreation(new Date())
                .balance(compteDto.getBalance())
                .type(compteDto.getType())
                .currency(compteDto.getCurrency())
                .build();
        Compte Savecompte1=bankAccountRepository.save(compte);
        CompteResponseDto  compteResponseDto = compteMapper.FromBankAccount(Savecompte1);
        return compteResponseDto;
    }
}
