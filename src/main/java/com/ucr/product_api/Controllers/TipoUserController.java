package com.ucr.product_api.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucr.product_api.dtos.TipoUserDto;
import com.ucr.product_api.facade.ITipoUserFacade;
import com.ucr.product_api.mappers.TipoUserMapper;
import com.ucr.product_api.models.TipoUserRequestModel;
import com.ucr.product_api.models.TipoUserResponseModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/tipousers")
public class TipoUserController {
    @Autowired
    private ITipoUserFacade tipoUserFacade;

    @Autowired
    private TipoUserMapper tipoUserMapper;

    @GetMapping
    public ResponseEntity<List<TipoUserResponseModel>> findAll() {
        return ResponseEntity.ok(tipoUserMapper.toTipoUserResponseModelList(tipoUserFacade.getAll()));
    }

    @PostMapping
    public TipoUserDto save(@RequestBody TipoUserRequestModel tipoUserRequestModel) {
        var dto = tipoUserMapper.toTipoUserRequestDto(tipoUserRequestModel);

        return tipoUserFacade.addTipoUser(dto);
    }
    
    @PutMapping(path = "/{resourceId}")
    public TipoUserDto update(@PathVariable("resourceId") UUID resourceId,
            @RequestBody TipoUserRequestModel tipoUserRequestModel) {
        
        var dto = tipoUserMapper.toTipoUserRequestDto(tipoUserRequestModel);

        return tipoUserFacade.updateTipoUser(resourceId, dto);
    }

    @GetMapping(path = "/{resourceId}")
    public TipoUserDto findById(@PathVariable("resourceId") UUID resourceId) {
        return tipoUserFacade.getByResourceId(resourceId);
    }
    
    @DeleteMapping(path = "/{resourceId}")
    public void remove(@PathVariable("resourceId") UUID resourceId) {
        tipoUserFacade.removeTipoUser(resourceId);
    }
}