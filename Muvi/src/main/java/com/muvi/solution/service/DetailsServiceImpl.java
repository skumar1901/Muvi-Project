package com.muvi.solution.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.muvi.solution.repository.DetailsRepository;
@Service
public class DetailsServiceImpl implements DetailsService {

	@Inject
	private DetailsRepository detailsRepository;


	@Override
	public void submitData(String email, long phone, String passport) {
		detailsRepository.addDataToDB(email,phone,passport);
		
	}
}
