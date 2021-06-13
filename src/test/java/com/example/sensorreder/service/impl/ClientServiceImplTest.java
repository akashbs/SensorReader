package com.example.sensorreder.service.impl;

import com.example.sensorreder.excpetion.UnauthorisedException;
import com.example.sensorreder.models.City;
import com.example.sensorreder.models.Client;
import com.example.sensorreder.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClientServiceImplTest {

    private static final String clientToken = "token1";
    private static final String cityName = "Barcelona";
    private static final String clientToken4 = "token4";
    @Autowired
    Client client;
    @Autowired
    City city;
    @Autowired
    ClientServiceImpl clientService;
    ClientRepository clientRepository = Mockito.mock(ClientRepository.class);

    @Test
    public void testAuthenticateRequestByTokenWhenClientExist() throws UnauthorisedException {
        boolean thrown = false;
        try {
            clientService.authenticateRequestByToken(clientToken, cityName);
        } catch (UnauthorisedException exception) {
            thrown = true;
        }
        assertFalse(thrown);
    }

    @Test
    public void testAuthenticateRequestByTokenWhenClientDoesNotExist() throws UnauthorisedException {
        boolean thrown = false;
        try {
            clientService.authenticateRequestByToken(clientToken4, cityName);
        } catch (UnauthorisedException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}