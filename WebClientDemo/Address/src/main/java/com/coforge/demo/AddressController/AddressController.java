package com.coforge.demo.AddressController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.coforge.demo.model.Address;
import com.coforge.demo.service.AddressService;

import java.util.List;


@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class AddressController {
	@Autowired
	private AddressService service;

	@GetMapping("/hwlloo")
	public String hell()
	{
		return "hello world";
	}
	@GetMapping("/getAddress")
	public List<Address> getall() {
	   return service.getAddress();
	}
	@GetMapping("/{empId}")
	public Address getAddressByEmployeeId(@PathVariable int empId) {
        return service.getAddressByEmployeeId(empId);
	}
}
