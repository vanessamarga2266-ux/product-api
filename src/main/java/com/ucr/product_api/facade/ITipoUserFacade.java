package com.ucr.product_api.facade;

import java.util.List;

import com.ucr.product_api.dtos.TipoUserDto;

public interface ITipoUserFacade {
    List<TipoUserDto> getAll();
}