package org.sid.compteservice;

import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.entities.Customer;
import org.sid.compteservice.enums.AccountType;
import org.sid.compteservice.repositories.BankAccountRepository;
import org.sid.compteservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository,CustomerRepository
                            customerRepository)
    {
        return args -> {
            Stream.of("mohamed","Achraf","amine","yassine").forEach(c->
            {
                Customer customer=Customer.builder()
                        .nom(c).build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                for (int i=0 ; i<10 ;i++){
                    Compte bankAccount=Compte.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                            .balance(10000+Math.random()*90000)
                            .dateCreation(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });


        };
    }
}
