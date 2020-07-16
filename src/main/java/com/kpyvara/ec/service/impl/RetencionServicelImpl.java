package com.kpyvara.ec.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kpyvara.ec.dto.RetencionDTO;
import com.kpyvara.ec.model.Empresa;
import com.kpyvara.ec.model.Retencion;
import com.kpyvara.ec.repo.IRetencion;
import com.kpyvara.ec.service.ICrud;

@Service
public class RetencionServicelImpl implements ICrud<Retencion> {
	@Autowired 
	private IRetencion repo; 
	@Override
	public Retencion save(Retencion obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Retencion> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Retencion getOneEmpresa(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	   public List<RetencionDTO> getEmpresas(String cedula){
			 List<RetencionDTO> datos = new ArrayList<>(); 
			 repo.listarResumen(cedula).forEach(obj -> {
				 Empresa empre = new Empresa(); 
				 RetencionDTO axu = new RetencionDTO() ; 
				 axu.setId((Integer) obj[0]); 
				 axu.setBaseImponible((Double) obj[1]);
				 axu.setCodigo((String) obj[2]);
				 axu.setEmpresa(empre);
				 String fecha =  obj[3].toString();
				 DateTimeFormatter formatter = null;
				 formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	             LocalDate local = LocalDate.parse(fecha, formatter);
	             axu.setFecha(local);
	             axu.setRucProvedor((String) obj[4]);
	             axu.setValor((Double) obj[5]);
 				 empre.setRuc((String) obj[6]);
				 empre.setNombre((String) obj[7]);
				 datos.add(axu); 
			 });
			return datos;
	   }
	   
	   public List<RetencionDTO> getEmpresasRuc(String cedula, String ruc){
			 List<RetencionDTO> datos = new ArrayList<>(); 
			 repo.listarResumenRuc(cedula,ruc).forEach(obj -> {
				 Empresa empre = new Empresa(); 
				 RetencionDTO axu = new RetencionDTO() ; 
				 axu.setId((Integer) obj[0]); 
				 axu.setBaseImponible((Double) obj[1]);
				 axu.setCodigo((String) obj[2]);
				 axu.setEmpresa(empre);
				 String fecha =  obj[3].toString();
				 DateTimeFormatter formatter = null;
				 formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	             LocalDate local = LocalDate.parse(fecha, formatter);
	             axu.setFecha(local);
	             axu.setRucProvedor((String) obj[4]);
	             axu.setValor((Double) obj[5]);
 				 empre.setRuc((String) obj[6]);
				 empre.setNombre((String) obj[7]);
				 datos.add(axu); 
			 });
			return datos;
	   }
	   public List<RetencionDTO> getEmpresasRucFecha(String cedula,String fechaIni,String fechaFin){
		     DateTimeFormatter formatterr = null;
			 formatterr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		     String fechar =  fechaIni.toString();
	         LocalDate locals = LocalDate.parse(fechar, formatterr);
	         String fecha1 =  fechaFin.toString();
	          LocalDate local1 = LocalDate.parse(fecha1, formatterr);
	       
			 List<RetencionDTO> datos = new ArrayList<>(); 
			 repo.listarResumenFecha(cedula,locals,local1).forEach(obj -> {
				 Empresa empre = new Empresa(); 
				 RetencionDTO axu = new RetencionDTO() ; 
				 axu.setId((Integer) obj[0]); 
				 axu.setBaseImponible((Double) obj[1]);
				 axu.setCodigo((String) obj[2]);
				 axu.setEmpresa(empre);
				 String fecha =  obj[3].toString();
				 DateTimeFormatter formatter = null;
				 formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	             LocalDate local = LocalDate.parse(fecha, formatter);
	             axu.setFecha(local);
	             axu.setRucProvedor((String) obj[4]);
	             axu.setValor((Double) obj[5]);
 				 empre.setRuc((String) obj[6]);
				 empre.setNombre((String) obj[7]);
				 datos.add(axu); 
			 });
			return datos;
	   }

		public  int  deletFactura(String codigo){
		try {
			repo.deleteById(codigo);
			return 1;
		}catch (Exception psqlException) {
			return 2;
		}
		}
	   
	   public List<RetencionDTO> getEmpresasRucFecha(String cedula,String ruc,String fechaIni,String fechaFin){
		     DateTimeFormatter formatterr = null;
			 formatterr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		     String fechar =  fechaIni.toString();
		     LocalDate locals = LocalDate.parse(fechar, formatterr);
		     String fecha1 =  fechaFin.toString();
		     LocalDate local1 = LocalDate.parse(fecha1, formatterr);
	     
			 List<RetencionDTO> datos = new ArrayList<>(); 
			 repo.listarResumenRucFecha(cedula,ruc,locals,local1).forEach(obj -> {
				 Empresa empre = new Empresa(); 
				 RetencionDTO axu = new RetencionDTO() ; 
				 axu.setId((Integer) obj[0]); 
				 axu.setBaseImponible((Double) obj[1]);
				 axu.setCodigo((String) obj[2]);
				 axu.setEmpresa(empre);
				 String fecha =  obj[3].toString();
				 DateTimeFormatter formatter = null;
				 formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	             LocalDate local = LocalDate.parse(fecha, formatter);
	             axu.setFecha(local);
	             axu.setRucProvedor((String) obj[4]);
	             axu.setValor((Double) obj[5]);
 				 empre.setRuc((String) obj[6]);
				 empre.setNombre((String) obj[7]);
				 datos.add(axu); 
			 });
			return datos;
	 }

	public List<RetencionDTO> getEmpresasRucContador(String ruc,String fechaIni,String fechaFin){
		DateTimeFormatter formatterr = null;
		formatterr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechar =  fechaIni.toString();
		LocalDate locals = LocalDate.parse(fechar, formatterr);
		String fecha1 =  fechaFin.toString();
		LocalDate local1 = LocalDate.parse(fecha1, formatterr);

		List<RetencionDTO> datos = new ArrayList<>();
		repo.listarResumenRucContador(ruc,locals,local1).forEach(obj -> {
			Empresa empre = new Empresa();
			RetencionDTO axu = new RetencionDTO() ;
			axu.setId((Integer) obj[0]);
			axu.setBaseImponible((Double) obj[1]);
			axu.setCodigo((String) obj[2]);
			axu.setEmpresa(empre);
			String fecha =  obj[3].toString();
			DateTimeFormatter formatter = null;
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate local = LocalDate.parse(fecha, formatter);
			axu.setFecha(local);
			axu.setRucProvedor((String) obj[4]);
			axu.setValor((Double) obj[5]);
			empre.setRuc((String) obj[6]);
			empre.setNombre((String) obj[7]);
			datos.add(axu);
		});
		return datos;
	}
		public byte[] getOneByte(String id) {
			Integer axu = Integer.valueOf(id); 
			return repo.getOne(axu).getDocumento();
		}

}
