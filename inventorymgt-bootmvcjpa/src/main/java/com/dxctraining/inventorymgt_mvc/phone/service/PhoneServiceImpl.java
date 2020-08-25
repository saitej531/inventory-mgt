package com.dxctraining.inventorymgt_mvc.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt_mvc.exception.*;
import com.dxctraining.inventorymgt_mvc.item.entities.Item;
import com.dxctraining.inventorymgt_mvc.phone.dao.IPhoneDao;
import com.dxctraining.inventorymgt_mvc.phone.entities.Phone;
import com.dxctraining.inventorymgt_mvc.supplier.entities.Supplier;

@Transactional
@Service
public class PhoneServiceImpl implements IPhoneService {

	@Autowired
	private IPhoneDao phoneDao;

	@Override
	public void validate(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("Argument is null");
		}
	}

	@Override
	public Phone save(Phone phone) {
		validate(phone);
		phoneDao.save(phone);
		return phone;
	}
	
	@Override
	public Phone add(Phone phone) {
		validate(phone);
		phone = phoneDao.add(phone);
		return phone;
	}

	@Override
	public Phone findPhoneById(int id) {
		validate(id);
		Phone phone = phoneDao.findPhoneById(id);
		return phone;
	}

	@Override
	public Phone remove(int id) {
		validate(id);
		Phone phone = phoneDao.remove(id);
		return phone;
	}

	@Override
	public List<Phone> allPhones() {
		List<Phone> allphones = phoneDao.allPhones();
		return allphones;
	}
	
	@Override
	public Phone update(Phone phone) {
		validate(phone);
		phoneDao.update(phone);
		return phone;
	}
}
