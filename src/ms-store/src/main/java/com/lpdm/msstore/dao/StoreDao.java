package com.lpdm.msstore.dao;

import com.lpdm.msstore.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDao extends JpaRepository<Store, Integer> {

}
