package com.example.DeliveryBoy.Controller;

import com.example.DeliveryBoy.Service.KalfkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationContoller {

    @Autowired
    private KalfkaService kalfkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updatelocation()
    {
        this.kalfkaService.updateLocation("("+Math.random()*100+","+ Math.random()*1000+")");
        return new ResponseEntity<>(Map.of("Message","Loction Recieved") ,HttpStatus.OK);
    }

}
