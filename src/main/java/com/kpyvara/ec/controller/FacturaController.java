package com.kpyvara.ec.controller;

 
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kpyvara.ec.dto.FacturacionDTO;
import com.kpyvara.ec.model.Factura;
import com.kpyvara.ec.service.impl.FacturaServiceImpl;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
	@Autowired
	FacturaServiceImpl service;
	
	@GetMapping(value="/{cedula}")
	public ResponseEntity<List<FacturacionDTO>> getFactura(@PathVariable("cedula") String cedula ) {
		List<FacturacionDTO> pacientes = service.getEmpresas(cedula);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
	
	@GetMapping(value="/{cedula}/{fechaIni}/{fechaFin}")
	public ResponseEntity<List<FacturacionDTO>> getFacturaFecha(@PathVariable("cedula") String cedula ,@PathVariable("fechaIni") String fechaIni ,@PathVariable("fechaFin") String fechaFin) {
		List<FacturacionDTO> pacientes = service.getEmpresasRucFecha(cedula, fechaIni, fechaFin);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
	
	@GetMapping(value="/{cedula}/{ruc}")
	public ResponseEntity<List<FacturacionDTO>> getFacturaRuc(@PathVariable("cedula") String cedula ,@PathVariable("ruc") String ruc ) {
		List<FacturacionDTO> pacientes = service.getEmpresasRuc(cedula, ruc);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
	
	@GetMapping(value="/{cedula}/{ruc}/{fechaIni}/{fechaFin}")
	public ResponseEntity<List<FacturacionDTO>> getFacturaRucs(@PathVariable("cedula") String cedula ,@PathVariable("ruc") String ruc ,@PathVariable("fechaIni") String fechaIni ,@PathVariable("fechaFin") String fechaFin) {
		List<FacturacionDTO> pacientes = service.getEmpresasRucFecha(cedula, ruc, fechaIni, fechaFin);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> setFactura( @Valid @RequestBody Factura paciente) {
		Factura pac = service.save(paciente);
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