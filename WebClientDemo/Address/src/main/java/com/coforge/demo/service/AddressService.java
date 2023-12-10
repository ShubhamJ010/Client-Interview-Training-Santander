package com.coforge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.demo.dao.AddressRepo;
import com.coforge.demo.model.Address;


@Service
public class AddressService {
    @Autowired
    private AddressRepo repo;


    public List<Address> getAddress() {
        return repo.findAll();
    }

    public Address getAddressByEmployeeId(int empId) {
        return repo.findAddressByEmpId(empId);
    }
}
