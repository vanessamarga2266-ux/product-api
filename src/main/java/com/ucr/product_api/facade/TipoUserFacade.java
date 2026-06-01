package com.ucr.product_api.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.dtos.TipoUserDto;
import com.ucr.product_api.mappers.TipoUserMapper;
import com.ucr.product_api.services.ITipoUserServices;

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
}