package com.iris.entitymanager.controller;

import com.iris.entitymanager.dto.AddReturnDTO;
import com.iris.entitymanager.dto.UpdateReturnDTO;
import com.iris.entitymanager.service.ReturnService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("CIMSCustomizationService/service")
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @GetMapping("/returnType/getAllReturnType")
    public ResponseEntity<?> getAllReturns(){
        return returnService.getAllReturns();
    }

    @PostMapping("/returnService/addReturnData")
    public ResponseEntity<?> createReturn(@RequestBody AddReturnDTO addReturnDTO) {
        return returnService.addReturn(addReturnDTO);
    }

    @PostMapping("/returnService/updateReturnData")
    public ResponseEntity<?> updateReturn(@Valid @RequestBody UpdateReturnDTO updateReturnDTO){
        return returnService.updateReturn(updateReturnDTO);
    }
}
