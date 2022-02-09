package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public void addAddress(Address address) {
		addressRepository.save(address);
	}
	
	public Address getAddress(Long id) {
		return addressRepository.findById(id).get();
	}
	
	
	
	public Address updateAddress(Long id, Address address) {
		Address address1 = addressRepository.findById(id).get();
		address1.setAddress(address.getAddress());
		addressRepository.save(address1);
		return address1;
		
	}
	
	public Address deleteAddress(Long id) {
		Address address1 = addressRepository.findById(id).get();
		if(address1 != null) {
			addressRepository.deleteById(id);
		}		
		return address1;
		
	}

}
