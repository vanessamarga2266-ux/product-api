package com.ucr.product_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.product_api.Entities.Membership;

@Repository

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    default List<Membership> findAll() {
        return findAll();
    }
}
