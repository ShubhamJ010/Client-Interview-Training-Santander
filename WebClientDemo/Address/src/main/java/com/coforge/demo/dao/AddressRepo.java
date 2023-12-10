package com.coforge.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.demo.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

     Address findAddressByEmpId(int empId);
}
