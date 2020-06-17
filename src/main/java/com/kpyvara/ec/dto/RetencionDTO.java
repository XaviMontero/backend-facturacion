package com.kpyvara.ec.dto;

import java.time.LocalDate;



import com.kpyvara.ec.model.Empresa;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RetencionDTO {
 
	private Integer id;
	private String rucProvedor;
	private Double valor;
	private Double baseImponible;
 	private LocalDate fecha;
 	private String codigo;	
	private Empresa empresa;
}
