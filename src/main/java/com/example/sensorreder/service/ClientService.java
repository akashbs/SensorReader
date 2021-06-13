package com.example.sensorreder.service;

import com.example.sensorreder.excpetion.UnauthorisedException;

public interface ClientService {
    void authenticateRequestByToken(String clientToken, String cityName) throws UnauthorisedException;
}
