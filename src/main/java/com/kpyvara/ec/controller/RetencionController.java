package com.kpyvara.ec.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kpyvara.ec.dto.RetencionDTO;
import com.kpyvara.ec.model.Retencion;
import com.kpyvara.ec.service.impl.RetencionServicelImpl;
@RestController
@RequestMapping("/retenciones")
public class RetencionController {
	@Autowired
	RetencionServicelImpl service;
	
	@GetMapping(value="/{cedula}")
	public ResponseEntity<List<RetencionDTO>> getRetencion(@PathVariable("cedula") String cedula ) {
		List<RetencionDTO> pacientes = service.getEmpresas(cedula);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
	@DeleteMapping(value="/{codigo}")
	public ResponseEntity<Integer> deleteFactura(@PathVariable("codigo") String codigo ) {
		Integer id = service.deletFactura(codigo);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@GetMapping(value="/{cedula}/{fechaIni}/{fechaFin}")
	public ResponseEntity<List<RetencionDTO>> getRetencionFecha(@PathVariable("cedula") String cedula ,@PathVariable("fechaIni") String fechaIni ,@PathVariable("fechaFin") String fechaFin) {
		List<RetencionDTO> pacientes = service.getEmpresasRucFecha(cedula, fechaIni, fechaFin);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
	
	@GetMapping(value="/{cedula}/{ruc}")
	public ResponseEntity<List<RetencionDTO>> getRetencionRuc(@PathVariable("cedula") String cedula ,@PathVariable("ruc") String ruc ) {
		List<RetencionDTO> pacientes = service.getEmpresasRuc(cedula, ruc);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
	
	@GetMapping(value="/{cedula}/{ruc}/{fechaIni}/{fechaFin}")
	public ResponseEntity<List<RetencionDTO>> getRetencionRucs(@PathVariable("cedula") String cedula ,@PathVariable("ruc") String ruc ,@PathVariable("fechaIni") String fechaIni ,@PathVariable("fechaFin") String fechaFin) {
		List<RetencionDTO> pacientes = service.getEmpresasRucFecha(cedula, ruc, fechaIni, fechaFin);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> setRetencion( @Valid @RequestBody Retencion paciente) {
		Retencion pac = service.save(paciente);
		// pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping(value="/generarPdf/{codigo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> getPdf(@PathVariable("codigo") String codigo ) {
		byte[] docuemento = service.getOneByte(codigo);
		return new ResponseEntity<>(docuemento, HttpStatus.OK);
	}
}
