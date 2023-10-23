package org.sid.compteservice.service;

import org.sid.compteservice.dto.CompteRequestDto;
import org.sid.compteservice.dto.CompteResponseDto;

public interface CompteService {
     CompteResponseDto addCount(CompteRequestDto compteDto);
}
