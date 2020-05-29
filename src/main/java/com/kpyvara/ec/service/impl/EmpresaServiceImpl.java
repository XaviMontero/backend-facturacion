package com.kpyvara.ec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpyvara.ec.model.Empresa;
import com.kpyvara.ec.repo.IEmpresa;
import com.kpyvara.ec.service.ICrud;

@Service
public class EmpresaServiceImpl implements ICrud<Empresa>{
	@Autowired
	private IEmpresa repo; 
	@Override
	public Empresa save(Empresa obj) {
		
		return repo.save(obj);
	}

	@Override
	public List<Empresa> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Empresa getOneEmpresa(String id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

}
