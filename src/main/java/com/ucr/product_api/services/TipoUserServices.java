package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ucr.product_api.Entities.TipoUser;
import com.ucr.product_api.dtos.TipoUserRequestDto;
import com.ucr.product_api.exceptions.TipoUserNotFoundException;
import com.ucr.product_api.repositories.TipoUserRepository;
 
@Service
public class TipoUserServices implements ITipoUserServices {
 
    @Autowired
    private TipoUserRepository tipoUserRepository;
 
    @Override
    public List<TipoUser> getAll() {
 
        return tipoUserRepository.getAll();
    }

    @Override
    public TipoUser create(TipoUser tipoUser) {
        if (tipoUser.getResourceId() == null) {
            tipoUser.setResourceId(UUID.randomUUID());
        }
        return tipoUserRepository.save(tipoUser);
    }

    @Override
    public TipoUser addTipoUser(TipoUserRequestDto tipoUserDto) {
        var tipoUser = TipoUser
        .builder()
        .name(tipoUserDto.getName())
        .description(tipoUserDto.getDescription())
        .resourceId(UUID.randomUUID())
        .build();

        return tipoUserRepository.addTipoUser(tipoUser);
    }

    @Override
    public TipoUser updateTipoUser(UUID resourceId, TipoUserRequestDto tipoUserDto) {
        var tipoUser = tipoUserRepository.findByResourceId(resourceId)
        .orElseThrow(() -> new TipoUserNotFoundException("TipoUser no encontrado"));

        tipoUser.setName(tipoUserDto.getName());
        tipoUser.setDescription(tipoUserDto.getDescription());

        return tipoUserRepository.updateTipoUser(tipoUser);
    }

    @Override
    public TipoUser getByResourceId(UUID resourceId) {
        return tipoUserRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new TipoUserNotFoundException("TipoUser no encontrado con resourceId"));
    }

    @Override
    public void removeTipoUser(UUID resourceId) {
       var tipoUser = tipoUserRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new TipoUserNotFoundException("TipoUser no encontrado"));

        tipoUserRepository.delete(tipoUser);
    }
}