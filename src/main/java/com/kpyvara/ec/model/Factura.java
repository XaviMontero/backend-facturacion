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
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "identificacion", nullable = false, length = 50)
	private String identificacion;
	@Column()
	private Double subTotal;
	@Column()
	private Double subTotaliva;
	@Column()
	private Double iva;
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

	public Factura() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getSubTotaliva() {
		return subTotaliva;
	}

	public void setSubTotaliva(Double subTotaliva) {
		this.subTotaliva = subTotaliva;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
