package com.example.allianhw.repository;

import com.example.allianhw.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByClientTokenEquals(String clientToken);
}