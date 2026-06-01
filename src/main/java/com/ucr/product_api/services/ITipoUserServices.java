package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.TipoUser;

public interface ITipoUserServices {
    List<TipoUser> getAll();
}