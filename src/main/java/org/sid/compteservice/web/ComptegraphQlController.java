package org.sid.compteservice.web;

import org.sid.compteservice.dto.CompteRequestDto;
import org.sid.compteservice.dto.CompteResponseDto;
import org.sid.compteservice.entities.Compte;

import java.util.Date;
import java.util.UUID;

public interface ComptegraphQlController {
    CompteResponseDto AddCompte(CompteRequestDto compteDto);
    CompteResponseDto updateCompte(CompteRequestDto compteDto,String id);
}
