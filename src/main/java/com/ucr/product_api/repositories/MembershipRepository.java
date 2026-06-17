package com.ucr.product_api.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.ucr.product_api.Entities.Membership;
 
@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    default List<Membership> getAll() {
 
        return findAll();
    }

    default Membership addMembership(Membership membership){
        return save(membership);
    }

    Optional<Membership> findByResourceId(UUID resourceId);

    default Membership updateMembership(Membership membership){
        return save(membership);
    };
}