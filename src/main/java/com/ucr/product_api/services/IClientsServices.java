package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Client;

public interface IClientsServices {
    List<Client> getAll();
}