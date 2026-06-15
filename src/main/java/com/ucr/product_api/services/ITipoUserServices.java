package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.Entities.TipoUser;
import com.ucr.product_api.dtos.TipoUserRequestDto;

public interface ITipoUserServices {
    List<TipoUser> getAll();

    public TipoUser create(TipoUser tipoUser);

    TipoUser addTipoUser(TipoUserRequestDto tipoUserDto);

    TipoUser updateTipoUser(UUID resourceId, TipoUserRequestDto tipoUserDto);

    TipoUser getByResourceId (UUID resourceId);

    void removeTipoUser(UUID resourceId);
}