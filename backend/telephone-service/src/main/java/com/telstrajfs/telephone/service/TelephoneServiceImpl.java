package com.telstrajfs.telephone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telstrajfs.telephone.model.Telephone;
import com.telstrajfs.telephone.repository.TelephoneRepository;



@Service
public class TelephoneServiceImpl  implements TelephoneService{

	@Autowired
	private TelephoneRepository telephoneRepository;
	
	public TelephoneServiceImpl(TelephoneRepository telephoneRepository) {
		super();
		this.telephoneRepository = telephoneRepository;
	}
	
	@Override
	public Optional<Telephone> getTelephoneById(int telephoneId) {
		// TODO Auto-generated method stub
		return telephoneRepository.findById(telephoneId);
	}

	@Override
	public List<Telephone> getAllTelephones() {
		// TODO Auto-generated method stub
		return (List<Telephone>) telephoneRepository.findAll();
	}

	@Override
	public void addTelephone(Telephone telephone) {
		// TODO Auto-generated method stub
		telephoneRepository.save(telephone);
		
	}

	@Override
	public void deleteTelephoneById(int telephoneId) {
		// TODO Auto-generated method stub
		telephoneRepository.deleteById(telephoneId);
		
	}

	@Override
	public void updateTelephone(long telephoneNumber, int countryCode, int telephoneId) {
		// TODO Auto-generated method stub
		telephoneRepository.updateTelephone(telephoneNumber, countryCode, telephoneId);
		
	}

	

}
