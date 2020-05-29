package com.kpyvara.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpyvara.ec.model.Empresa;

@Repository
public interface IEmpresa  extends JpaRepository<Empresa, String>{

}
