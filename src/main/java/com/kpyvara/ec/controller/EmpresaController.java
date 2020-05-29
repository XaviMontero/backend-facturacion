package com.kpyvara.ec.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kpyvara.ec.model.Empresa;

import com.kpyvara.ec.service.impl.EmpresaServiceImpl;


@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	@Autowired
	EmpresaServiceImpl service;
	@GetMapping
	public ResponseEntity<List<Empresa>> getFactura() {
		List<Empresa> pacientes = service.list();
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> setFactura( @Valid @RequestBody Empresa paciente) {
		Empresa pac = service.save(paciente);
		// pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getRuc())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
