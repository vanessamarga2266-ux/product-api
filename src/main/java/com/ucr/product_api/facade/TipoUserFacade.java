package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.dtos.TipoUserDto;
import com.ucr.product_api.dtos.TipoUserRequestDto;
import com.ucr.product_api.mappers.TipoUserMapper;
import com.ucr.product_api.services.ITipoUserServices;

import jakarta.transaction.Transactional;

@Component
public class TipoUserFacade implements ITipoUserFacade {

    @Autowired
    private ITipoUserServices tipoUserServices;

    @Autowired
    private TipoUserMapper tipoUserMapper;

    @Override
    public List<TipoUserDto> getAll() {
        return tipoUserMapper.toTipoUserDtoList(tipoUserServices.getAll());
    }

    @Override
    public TipoUserDto create(TipoUserDto tipoUserDto) {
        com.ucr.product_api.Entities.TipoUser tipoUser = tipoUserMapper.toTipoUserEntity(tipoUserDto);
        com.ucr.product_api.Entities.TipoUser saved = tipoUserServices.create(tipoUser);

        return tipoUserMapper.toTipoUserDto(saved);
    }

    @Override
    public TipoUserDto addTipoUser(TipoUserRequestDto tipoUserDto) {
        var entity = tipoUserServices.addTipoUser(tipoUserDto);
        return tipoUserMapper.toTipoUserDto(entity);
    }

    @Override
    @Transactional
    public TipoUserDto updateTipoUser(UUID resourceId, TipoUserRequestDto tipoUser) {
        var entity = tipoUserServices.updateTipoUser(resourceId, tipoUser);
        return tipoUserMapper.toTipoUserDto(entity);
    }

    @Override
    public TipoUserDto getByResourceId(UUID resourceId) {
        var entity = tipoUserServices.getByResourceId(resourceId);
        return tipoUserMapper.toTipoUserDto(entity);
    }

    @Override
    @Transactional
    public void removeTipoUser(UUID resourceId) {
        tipoUserServices.removeTipoUser(resourceId);
    }
}