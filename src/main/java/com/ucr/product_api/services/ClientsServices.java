package com.ucr.product_api.services;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ucr.product_api.Entities.Client;
import com.ucr.product_api.repositories.ClientRepository;
 
@Service
public class ClientsServices implements IClientsServices {
 
    @Autowired
    private ClientRepository clientRepository;
 
    @Override
    public List<Client> getAll() {
 
        return clientRepository.getAll();
    }
}