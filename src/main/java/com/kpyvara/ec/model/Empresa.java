package com.kpyvara.ec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Empresa {
	@Id
	private String ruc;
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
 
	
}
