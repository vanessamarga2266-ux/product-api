package com.ucr.product_api.repositories;

import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.ucr.product_api.Entities.TipoUser;
 
@Repository
public interface TipoUserRepository extends JpaRepository<TipoUser, Long> {
    default List<TipoUser> getAll() {
 
        return findAll();
    }
}