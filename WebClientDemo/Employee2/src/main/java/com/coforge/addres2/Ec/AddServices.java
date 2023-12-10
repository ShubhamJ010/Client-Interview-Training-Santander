package com.coforge.addres2.Ec;

import com.coforge.addres2.model.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Address-service",url = "http://localhost:8081")
public interface AddServices {
    @GetMapping("/address/{empId}")
    public AddressResponse AddService(@PathVariable int empId);
}
