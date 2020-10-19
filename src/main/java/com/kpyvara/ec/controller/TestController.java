package com.kpyvara.ec.controller;

import com.kpyvara.ec.model.Empresa;
import com.kpyvara.ec.service.impl.EmpresaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    EmpresaServiceImpl service;
    @GetMapping
    public ResponseEntity<List<Empresa>> getEmpresa() {
        List<Empresa> pacientes = service.list();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> setEmpresa( @Valid @RequestBody Empresa empresa) {
        Empresa pac = service.save(empresa);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getRuc())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> updateEmpresas( @Valid @RequestBody Empresa empresa) {
        Empresa pac = service.save(empresa);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getRuc())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
