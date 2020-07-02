package com.kpyvara.ec.controller;

import com.kpyvara.ec.dto.FacturacionDTO;
import com.kpyvara.ec.dto.RetencionDTO;
import com.kpyvara.ec.service.impl.FacturaServiceImpl;
import com.kpyvara.ec.service.impl.RetencionServicelImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contadores")
public class ContadorController {
    @Autowired
    FacturaServiceImpl service;
    @Autowired
    RetencionServicelImpl serviceContador;

    @GetMapping(value="/facturas/{ruc}/{fechaIni}/{fechaFin}")
    public ResponseEntity<List<FacturacionDTO>> getFacturaRucs( @PathVariable("ruc") String ruc , @PathVariable("fechaIni") String fechaIni , @PathVariable("fechaFin") String fechaFin) {
        List<FacturacionDTO> facturas = service.getEmpresasRucContador( ruc, fechaIni, fechaFin);
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping(value="/retenciones/{ruc}/{fechaIni}/{fechaFin}")
    public ResponseEntity<List<RetencionDTO>> getRetencionRucs( @PathVariable("ruc") String ruc , @PathVariable("fechaIni") String fechaIni , @PathVariable("fechaFin") String fechaFin) {
        List<RetencionDTO> retenciones = serviceContador.getEmpresasRucContador( ruc, fechaIni, fechaFin);
        return new ResponseEntity<>(retenciones, HttpStatus.OK);
    }

}
