package com.example.allianhw.service.impl;


import com.example.allianhw.excpetion.UnauthorisedException;
import com.example.allianhw.models.Client;
import com.example.allianhw.repository.ClientRepository;
import com.example.allianhw.service.ClientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void authenticateRequestByToken(String clientToken, String cityName) throws UnauthorisedException {
        Client client = clientRepository.findClientByClientTokenEquals(clientToken);
        if (null == client || null == client.getCity() || !StringUtils.equals(client.getCity().getName(), cityName)) {
            throw new UnauthorisedException("You are not authorised to view " + cityName + " city's data");
        }
    }
}
