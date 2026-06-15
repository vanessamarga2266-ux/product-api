package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.dtos.TipoUserDto;
import com.ucr.product_api.dtos.TipoUserRequestDto;

public interface ITipoUserFacade {
    List<TipoUserDto> getAll();
    public TipoUserDto create(TipoUserDto tipoUserDto);
    TipoUserDto addTipoUser(TipoUserRequestDto tipoUserDto);
    TipoUserDto updateTipoUser(UUID resourceId, TipoUserRequestDto tipoUser);
    TipoUserDto getByResourceId(UUID resourceId);
    void removeTipoUser(UUID resourceId);
}