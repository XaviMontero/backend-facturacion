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
public class Retencion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column()
	private String rucProvedor;
	@Column()
	private Double valor;
	@Column()
	private Double baseImponible;
	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;
	@Column(name = "codigo", nullable = false, length = 60)
	private String codigo;	
	@Column
	private byte[] documento;
	@ManyToOne
	@JoinColumn(name = "ruc", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPRESA_RETENCION"))
	private Empresa empresa;
}
