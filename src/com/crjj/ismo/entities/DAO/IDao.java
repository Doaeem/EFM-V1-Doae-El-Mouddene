package com.crjj.ismo.entities.DAO;

import java.util.List;

import com.crjj.ismo.entities.Appartement;

public interface IDao<T> {

	List<T> getAll();
	
	T getOne(int id);
	
	boolean update(T obj);
	
	boolean delete(T obj);


}
