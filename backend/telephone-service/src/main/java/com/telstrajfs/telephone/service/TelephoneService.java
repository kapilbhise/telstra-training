package com.telstrajfs.telephone.service;

import java.util.List;
import java.util.Optional;

import com.telstrajfs.telephone.model.Telephone;

public interface TelephoneService {

	public Optional<Telephone> getTelephoneById(int telephoneId);
	public List<Telephone> getAllTelephones();
	public void addTelephone(Telephone telephone);
	public void deleteTelephoneById(int telephoneId);
	public void updateTelephone(long telephoneNumber, int countryCode,  int telephoneId);
	
}
