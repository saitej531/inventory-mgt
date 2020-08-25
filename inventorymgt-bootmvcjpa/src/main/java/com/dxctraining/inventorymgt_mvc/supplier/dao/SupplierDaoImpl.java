package com.dxctraining.inventorymgt_mvc.supplier.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt_mvc.exception.*;
import com.dxctraining.inventorymgt_mvc.supplier.entities.Supplier;

@Repository
public class SupplierDaoImpl implements ISupplierDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Supplier save(Supplier supplier) {
		em.persist(supplier);
		return supplier;
	}

	@Override
	public Supplier findSupplierById(int id) {
		Supplier supplier = em.find(Supplier.class, id);
		if (supplier == null) {
			throw new SupplierNotFoundException("Supplier not found");
		}
		return supplier;
	}

	@Override
	public Supplier remove(int id) {
		Supplier supplier = findSupplierById(id);
		em.remove(supplier);
		return supplier;
	}

	@Override
	 public List<Supplier> allSuppliers() {
        String jpaql="from Supplier";
        TypedQuery<Supplier>query=em.createQuery(jpaql,Supplier.class);
        List<Supplier>suppliersList=query.getResultList();
        return suppliersList;
    }
	
	@Override
	public Supplier update(Supplier supplier) {
		em.merge(supplier);
		return supplier;

	}
	
	@Override
	public void add(Supplier supplier) {
		em.persist(supplier);

	}
}
