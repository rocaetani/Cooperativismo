package com.example.cooperativism.resource;

import com.example.cooperativism.service.AssociateService;
import com.example.cooperativism.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Associate")
public class AssociateResource {

    @Autowired
    private AssociateService associateService;

    @RequestMapping(method = RequestMethod.GET, value="/verifyCPF")
    public ResponseEntity verifyCPF(@RequestParam(value="cpf") String cpf){
        return ResponseEntity.ok().body(associateService.verifyCPF(cpf));
    }
}
