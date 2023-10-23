package org.sid.compteservice.entities;

import org.sid.compteservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Compte.class,name = "p1")
public interface CompteProjection {
    public String getID();
    public AccountType getType();
    public Double getBalance();
}
