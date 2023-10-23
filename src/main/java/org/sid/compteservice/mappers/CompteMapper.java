package org.sid.compteservice.mappers;

import org.sid.compteservice.dto.CompteResponseDto;
import org.sid.compteservice.entities.Compte;
import org.springframework.beans.BeanUtils;

public class CompteMapper {
    public CompteResponseDto FromBankAccount(Compte compte)
    {
        CompteResponseDto compteResponseDto=new CompteResponseDto();
        BeanUtils.copyProperties(compte,compteResponseDto);
        return compteResponseDto;
    }
}
