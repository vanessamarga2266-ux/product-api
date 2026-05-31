package com.ucr.product_api.facade;
import java.util.List;

import com.ucr.product_api.dtos.UserDto;

public interface IUserFacade {
    List<UserDto> getAll();
}