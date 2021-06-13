package com.example.allianhw.service;

import com.example.allianhw.excpetion.UnauthorisedException;

public interface ClientService {
    void authenticateRequestByToken(String clientToken, String cityName) throws UnauthorisedException;
}
