package com.coforge.addres2.EmployeeController;

import com.coforge.addres2.model.DetailResponse;
import com.coforge.addres2.model.Employee;
import com.coforge.addres2.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService service;


    @GetMapping("/getEmpolyee")
    public java.util.List<Employee> getall() {
        return service.getEmpDetails();
    }

    @GetMapping("/getEmpDetails/{id}")
    public Employee fetchbyid(@PathVariable int id) {
        return service.getEmpDetailsById(id);

    }

    @GetMapping("/getAllDetail/{id}")
    public DetailResponse getAllDetail(@PathVariable int id) {
        DetailResponse detailResponse = new DetailResponse();
        detailResponse.setEmployee(fetchbyid(id));
        detailResponse.setAddressResponse(service.getEmployeeAddress(id));

        return detailResponse;
    }

}
