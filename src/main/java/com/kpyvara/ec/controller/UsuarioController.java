package com.kpyvara.ec.controller;



import com.kpyvara.ec.model.Usuario;
import com.kpyvara.ec.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> setUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario pac = service.save(usuario);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getUsername())
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
