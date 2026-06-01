package com.ucr.product_api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.product_api.Entities.TipoUser;
import com.ucr.product_api.dtos.TipoUserDto;
import com.ucr.product_api.models.TipoUserResponseModel;

@Component
public class TipoUserMapper {
    
    public TipoUserDto toTipoUserDto(TipoUser tipoUser){
        if (tipoUser == null) {
            return null;
        }

        return new TipoUserDto(tipoUser.getName(), tipoUser.getDescription());
    }

    public List<TipoUserDto> toTipoUserDtoList(List<TipoUser> tipoUsers){
        if (tipoUsers == null) {
            return null;
        }

        return tipoUsers.stream()
                .map(this::toTipoUserDto)
                .collect(Collectors.toList());
    }

    public TipoUserResponseModel toTipoUserResponseModel(TipoUserDto tipoUserDto){
        if (tipoUserDto == null) {
            return null;
        }

        return new TipoUserResponseModel(tipoUserDto.name(), tipoUserDto.description());
    }

    public List<TipoUserResponseModel> toTipoUserResponseModelList(List<TipoUserDto> tipoUserDtos){
        if (tipoUserDtos == null) {
            return null;
        }

        return tipoUserDtos.stream()
                .map(this::toTipoUserResponseModel)
                .collect(Collectors.toList());
    }
}