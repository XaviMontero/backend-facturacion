package com.kpyvara.ec.service;

import java.util.List;

 

public interface ICrud <T> {
	T save (T obj); 
	List<T> list(); 
	T getOneEmpresa(String id);
}
