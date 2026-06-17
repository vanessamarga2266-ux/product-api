package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.dtos.MembershipDto;
import com.ucr.product_api.dtos.MembershipRequestDto;
import com.ucr.product_api.mappers.MembershipMapper;
import com.ucr.product_api.services.IMembershipServices;

import jakarta.transaction.Transactional;

@Component
public class MembershipFacade implements IMembershipFacade {

    @Autowired
    private IMembershipServices membershipServices;

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