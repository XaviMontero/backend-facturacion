package com.kpyvara.ec.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kpyvara.ec.model.Factura;

@Repository
public interface IFactura extends JpaRepository<Factura, Integer> {
	@Query(value = " SELECT F.id, F.sub_total, F.codigo, F.fecha, F.identificacion, F.total, A.ruc,A.nombre FROM public.factura F inner join public.empresa A on A.ruc = F.ruc where F.identificacion=?1", nativeQuery = true)
	List<Object[]> listarResumen(String cedula);
	
	@Query(value = " SELECT F.id, F.sub_total, F.codigo, F.fecha, F.identificacion, F.total, A.ruc,A.nombre FROM public.factura F inner join public.empresa A on A.ruc = F.ruc where F.identificacion=?1 and A.ruc=?2", nativeQuery = true)
	List<Object[]> listarResumenRuc(String cedula , String ruc );
	
	@Query(value = " SELECT F.id, F.sub_total, F.codigo, F.fecha, F.identificacion, F.total, A.ruc,A.nombre FROM public.factura F inner join public.empresa A on A.ruc = F.ruc where F.identificacion=?1 and F.fecha BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Object[]> listarResumenFecha(String cedula, LocalDate fechaIni, LocalDate fechaFin);
	
	@Query(value = " SELECT F.id, F.sub_total, F.codigo, F.fecha, F.identificacion, F.total, A.ruc,A.nombre FROM public.factura F inner join public.empresa A on A.ruc = F.ruc where F.identificacion=?1 and A.ruc=?2 and F.fecha BETWEEN ?3 AND ?4", nativeQuery = true)
	List<Object[]> listarResumenRucFecha(String cedula , String ruc, LocalDate fechaIni, LocalDate fechaFin );
}
