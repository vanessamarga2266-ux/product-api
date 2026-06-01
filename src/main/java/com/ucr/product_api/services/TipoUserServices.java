package com.ucr.product_api.services;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ucr.product_api.Entities.TipoUser;
import com.ucr.product_api.repositories.TipoUserRepository;
 
@Service
public class TipoUserServices implements ITipoUserServices {
 
    @Autowired
    private TipoUserRepository tipoUserRepository;
 
    @Override
    public List<TipoUser> getAll() {
 
        return tipoUserRepository.getAll();
    }
}