package com.java.deptservice.entity.repository;

import com.java.deptservice.entity.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {


}
