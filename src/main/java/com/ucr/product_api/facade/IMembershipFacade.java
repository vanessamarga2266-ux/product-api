package com.ucr.product_api.facade;
import java.util.List;

import com.ucr.product_api.dtos.MembershipDto;

public interface IMembershipFacade {
    List<MembershipDto> getAll();
}