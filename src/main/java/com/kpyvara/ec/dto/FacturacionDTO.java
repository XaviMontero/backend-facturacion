package com.kpyvara.ec.dto;

import java.time.LocalDate;


import com.kpyvara.ec.model.Empresa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturacionDTO {

	private Integer id;

	private String identificacion;

	private Double subTotal;

	private Double total;

	private LocalDate fecha;

	private String codigo;	

	private Empresa empresa;
	
}
