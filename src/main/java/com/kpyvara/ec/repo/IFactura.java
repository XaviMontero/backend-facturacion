package com.kpyvara.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpyvara.ec.model.Factura;

@Repository
public interface IFactura extends JpaRepository<Factura, Integer> {

}
