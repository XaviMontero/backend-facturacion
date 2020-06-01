package com.kpyvara.ec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
