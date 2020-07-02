package com.kpyvara.ec;

import com.kpyvara.ec.model.Usuario;
import com.kpyvara.ec.repo.IUsuarioRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiFacturacion1ApplicationTests {
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	@Autowired
	private IUsuarioRepo repo;
	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario(7);
		us.setUsername("mito8@gmail.com");
		us.setPassword(bcrypt.encode("123"));
		us.setEnabled(true);

		Usuario retorno = repo.save(us);

		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}