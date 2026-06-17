package com.ucr.product_api.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucr.product_api.dtos.MembershipDto;
import com.ucr.product_api.facade.IMembershipFacade;
import com.ucr.product_api.mappers.MembershipMapper;
import com.ucr.product_api.models.MembershipRequestModel;
import com.ucr.product_api.models.MembershipResponseModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/memberships")
public class MembershipController {
    @Autowired
    private IMembershipFacade membershipFacade;

    @Autowired
    private MembershipMapper membershipMapper;

    @GetMapping
    public ResponseEntity<List<MembershipResponseModel>> findAll() {
        return ResponseEntity.ok(membershipMapper.toMembershipResponseModelList(membershipFacade.getAll()));
    }

    @PostMapping
    public MembershipDto save(@RequestBody MembershipRequestModel membershipRequestModel) {
        var dto = membershipMapper.toMembershipRequestDto(membershipRequestModel);

        return membershipFacade.addMembership(dto);
    }
    
    @PutMapping(path = "/{resourceId}")
    public MembershipDto update(@PathVariable("resourceId") UUID resourceId,
            @RequestBody MembershipRequestModel membershipRequestModel) {
        
        var dto = membershipMapper.toMembershipRequestDto(membershipRequestModel);

        return membershipFacade.updateMembership(resourceId, dto);
    }

    @GetMapping(path = "/{resourceId}")
    public MembershipDto findById(@PathVariable("resourceId") UUID resourceId) {
        return membershipFacade.getByResourceId(resourceId);
    }
    
    @DeleteMapping(path = "/{resourceId}")
    public void remove(@PathVariable("resourceId") UUID resourceId) {
        membershipFacade.removeMembership(resourceId);
    }
}