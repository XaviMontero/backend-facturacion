package com.kpyvara.ec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

 
@Entity
@Table
@Getter
@Setter
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "identificacion", nullable = false, length = 50)
	private String identificacion;
	@Column()
	private Double subTotal;
	@Column(name = "total", nullable = false)
	private Double total;
	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;
	@Column(name = "codigo", nullable = false, length = 60)
	private String codigo;	
	@Column
	private byte[] documento;
	@ManyToOne
	@JoinColumn(name = "ruc", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPRESA_FACTURA"))
	private Empresa empresa;
}
