package com.example.sensorreder.repository;

import com.example.sensorreder.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByClientTokenEquals(String clientToken);
}