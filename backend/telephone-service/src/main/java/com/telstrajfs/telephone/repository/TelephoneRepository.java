package com.telstrajfs.telephone.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telstrajfs.telephone.model.Telephone;


@Repository
public interface TelephoneRepository extends CrudRepository<Telephone, Integer> {
	
	@Transactional
	@Modifying
	@Query("update Telephone t set t.telephoneNumber=?1 , t.countryCode=?2 where"
			+ " t.telephoneId=?3")
	int updateTelephone(long telephoneNumber, int countryCode,  int telephoneId);

}