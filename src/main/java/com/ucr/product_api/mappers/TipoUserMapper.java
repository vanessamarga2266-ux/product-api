package com.ucr.product_api.mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.product_api.Entities.TipoUser;
import com.ucr.product_api.dtos.TipoUserDto;
import com.ucr.product_api.dtos.TipoUserRequestDto;
import com.ucr.product_api.models.TipoUserRequestModel;
import com.ucr.product_api.models.TipoUserResponseModel;

@Component
public class TipoUserMapper {
    
    public TipoUserDto toTipoUserDto(TipoUser tipoUser){
        if (tipoUser == null) {
            return null;
        }

        return new TipoUserDto(tipoUser.getResourceId() ,tipoUser.getName(), tipoUser.getDescription());
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

        return new TipoUserResponseModel(tipoUserDto.resourceId(), tipoUserDto.name(), tipoUserDto.description());
    }

    public List<TipoUserResponseModel> toTipoUserResponseModelList(List<TipoUserDto> tipoUserDtos){
        if (tipoUserDtos == null) {
            return null;
        }

        return tipoUserDtos.stream()
                .map(this::toTipoUserResponseModel)
                .collect(Collectors.toList());
    }

    public TipoUserRequestDto toTipoUserRequestDto(TipoUserRequestModel tipoUser){
        if (tipoUser == null) {
            return null;
        }

        TipoUserRequestDto tipoUserDto = new TipoUserRequestDto();
        tipoUserDto.setName(tipoUser.name());
        tipoUserDto.setDescription(tipoUser.description());
        return tipoUserDto;
    }

    public TipoUser toTipoUserEntity(TipoUserDto dto){
        if (dto == null) {
            return null;
        }

        UUID resourceId = dto.resourceId() == null ? UUID.randomUUID() : dto.resourceId();

        return TipoUser.builder()
        .name(dto.name())
        .description(dto.description())
        .resourceId(resourceId)
        .build();
    }
}