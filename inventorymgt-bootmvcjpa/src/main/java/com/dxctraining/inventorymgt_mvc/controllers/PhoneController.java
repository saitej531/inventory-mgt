package com.dxctraining.inventorymgt_mvc.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt_mvc.item.entities.Item;
import com.dxctraining.inventorymgt_mvc.phone.entities.Phone;
import com.dxctraining.inventorymgt_mvc.phone.service.IPhoneService;
import com.dxctraining.inventorymgt_mvc.supplier.entities.Supplier;
import com.dxctraining.inventorymgt_mvc.supplier.service.ISupplierService;

@Controller
public class PhoneController extends Item{
	
	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private IPhoneService phoneService;
	
	@PostConstruct
	public void init() {

		Supplier supplier1 = new Supplier("rajesh", "rebel");
		supplier1 = supplierService.save(supplier1);

		Supplier supplier2 = new Supplier("chiru", "tej");
		supplier2 = supplierService.save(supplier2);


		Phone phone1 = new Phone("Realme", 45);
		phone1 = phoneService.save(phone1);
		Phone phone2 = new Phone("Apple", 12);
		phone1 = phoneService.save(phone2);

}
	@GetMapping("/phone")
	public ModelAndView phoneDetails(@RequestParam("id") int id) {
		Phone phone = phoneService.findPhoneById(id);
		ModelAndView modelAndView = new ModelAndView("phonedetails", "phone", phone);
		return modelAndView;
	}
	@GetMapping("/allphones")
	public ModelAndView allPhones() {
		List<Phone> values = phoneService.allPhones();
		ModelAndView modelAndView = new ModelAndView("phonelist", "phones", values);
		return modelAndView;
	}
	@GetMapping("/phoneregister")
	public ModelAndView registerSupplier() {
		ModelAndView mv = new ModelAndView("phoneregister");
		return mv;
	}

	@GetMapping("/phoneprocessregister")
	public ModelAndView processRegister(@RequestParam("name") String name, @RequestParam("storageSize") int storageSize) {
		System.out.println("inside processregister method, name=" + name);
		Phone phone = new Phone(name,storageSize);
		phone = phoneService.save(phone);
		ModelAndView mv = new ModelAndView("phonedetails", "phone", phone);
		return mv;
	}
}