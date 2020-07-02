package com.kpyvara.ec.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kpyvara.ec.dto.FacturacionDTO;
import com.kpyvara.ec.model.Empresa;
import com.kpyvara.ec.model.Factura;
import com.kpyvara.ec.repo.IFactura;
import com.kpyvara.ec.service.ICrud;

@Service
public class FacturaServiceImpl implements ICrud<Factura>{
	@Autowired 
	private IFactura repo; 
	@Override
	public Factura save(Factura obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Factura> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

 
	public byte[] getOneByte(String id) {
		Integer axu = Integer.valueOf(id); 
		return repo.getOne(axu).getDocumento();
	}

	@Override
	public Factura getOneEmpresa(String id) {
		// TODO Auto-generated method stub
		return null;
	}


   public List<FacturacionDTO> getEmpresas(String cedula){
		 List<FacturacionDTO> datos = new ArrayList<>(); 
		 repo.listarResumen(cedula).forEach(obj -> {
			 Empresa empre = new Empresa(); 
			 FacturacionDTO axu = new FacturacionDTO() ; 
			 axu.setId((Integer) obj[0]); 
			 axu.setSubTotal((Double) obj[1]);
			 axu.setCodigo((String) obj[2]);

			 axu.setIdentificacion((String) obj[4]);
			 axu.setTotal((Double) obj[5]);
			 empre.setRuc((String) obj[6]);
			 empre.setNombre((String) obj[7]);
			 axu.setIva((Double) obj[8]);
			 axu.setSubTotaliva((Double) obj[9]);
			 axu.setEmpresa(empre);
			 String fecha =  obj[3].toString();
			 DateTimeFormatter formatter = null;
			 formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate local = LocalDate.parse(fecha, formatter);
             axu.setFecha(local);
			 datos.add(axu); 
		 });
		return datos;
   }
   
   public List<FacturacionDTO> getEmpresasRuc(String cedula, String ruc){
		 List<FacturacionDTO> datos = new ArrayList<>(); 
		 repo.listarResumenRuc(cedula,ruc).forEach(obj -> {
			 Empresa empre = new Empresa(); 
			 FacturacionDTO axu = new FacturacionDTO() ; 
			 axu.setId((Integer) obj[0]); 
			 axu.setSubTotal((Double) obj[1]);
			 axu.setCodigo((String) obj[2]);
			
			 axu.setIdentificacion((String) obj[4]);
			 axu.setTotal((Double) obj[5]);
			 empre.setRuc((String) obj[6]);
			 empre.setNombre((String) obj[7]);
			 axu.setIva((Double) obj[8]);
			 axu.setSubTotaliva((Double) obj[9]);
			 axu.setEmpresa(empre);
			 String fecha =  obj[3].toString();
			 DateTimeFormatter formatter = null;
			 formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate local = LocalDate.parse(fecha, formatter);
             axu.setFecha(local);
			 datos.add(axu); 
		 });
		return datos;
   }
   public List<FacturacionDTO> getEmpresasRucFecha(String cedula,String fechaIni,String fechaFin){
	     DateTimeFormatter formatterr = null;
		 formatterr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     String fechar =  fechaIni.toString();
         LocalDate locals = LocalDate.parse(fechar, formatterr);
         String fecha1 =  fechaFin.toString();
          LocalDate local1 = LocalDate.parse(fecha1, formatterr);
       
		 List<FacturacionDTO> datos = new ArrayList<>(); 
		 repo.listarResumenFecha(cedula,locals,local1).forEach(obj -> {
			 Empresa empre = new Empresa(); 
			 FacturacionDTO axu = new FacturacionDTO() ; 
			 axu.setId((Integer) obj[0]); 
			 axu.setSubTotal((Double) obj[1]);
			 axu.setCodigo((String) obj[2]);
			
			 axu.setIdentificacion((String) obj[4]);
			 axu.setTotal((Double) obj[5]);
			 empre.setRuc((String) obj[6]);
			 empre.setNombre((String) obj[7]);
			 axu.setIva((Double) obj[8]);
			 axu.setSubTotaliva((Double) obj[9]);
			 axu.setEmpresa(empre);
			 String fecha =  obj[3].toString();
			 DateTimeFormatter formatter = null;
			 formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate local = LocalDate.parse(fecha, formatter);
             axu.setFecha(local);
			 datos.add(axu); 
		 });
		return datos;
   }
   
   public List<FacturacionDTO> getEmpresasRucFecha(String cedula,String ruc,String fechaIni,String fechaFin){
	     DateTimeFormatter formatterr = null;
		 formatterr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     String fechar =  fechaIni.toString();
       LocalDate locals = LocalDate.parse(fechar, formatterr);
       String fecha1 =  fechaFin.toString();
        LocalDate local1 = LocalDate.parse(fecha1, formatterr);
     
		 List<FacturacionDTO> datos = new ArrayList<>(); 
		 repo.listarResumenRucFecha(cedula,ruc,locals,local1).forEach(obj -> {
			 Empresa empre = new Empresa(); 
			 FacturacionDTO axu = new FacturacionDTO() ; 
			 axu.setId((Integer) obj[0]); 
			 axu.setSubTotal((Double) obj[1]);
			 axu.setCodigo((String) obj[2]);
			 axu.setIdentificacion((String) obj[4]);
			 axu.setTotal((Double) obj[5]);
			 empre.setRuc((String) obj[6]);
			 empre.setNombre((String) obj[7]);
			 axu.setIva((Double) obj[8]);
			 axu.setSubTotaliva((Double) obj[9]);
			 axu.setEmpresa(empre);
			 String fecha =  obj[3].toString();
			 DateTimeFormatter formatter = null;
			 formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           LocalDate local = LocalDate.parse(fecha, formatter);
           axu.setFecha(local);
			 datos.add(axu); 
		 });
		return datos;
 }

	public List<FacturacionDTO> getEmpresasRucContador(String ruc,String fechaIni,String fechaFin){
		DateTimeFormatter formatterr = null;
		formatterr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechar =  fechaIni.toString();
		LocalDate locals = LocalDate.parse(fechar, formatterr);
		String fecha1 =  fechaFin.toString();
		LocalDate local1 = LocalDate.parse(fecha1, formatterr);

		List<FacturacionDTO> datos = new ArrayList<>();
		repo.listarResumenRucContador(ruc,locals,local1).forEach(obj -> {
			Empresa empre = new Empresa();
			FacturacionDTO axu = new FacturacionDTO() ;
			axu.setId((Integer) obj[0]);
			axu.setSubTotal((Double) obj[1]);
			axu.setCodigo((String) obj[2]);
			axu.setIdentificacion((String) obj[4]);
			axu.setTotal((Double) obj[5]);
			empre.setRuc((String) obj[6]);
			empre.setNombre((String) obj[7]);
			axu.setIva((Double) obj[8]);
			axu.setSubTotaliva((Double) obj[9]);
			axu.setEmpresa(empre);
			String fecha =  obj[3].toString();
			DateTimeFormatter formatter = null;
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate local = LocalDate.parse(fecha, formatter);
			axu.setFecha(local);
			datos.add(axu);
		});
		return datos;
	}
}
