package com.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.payments;
import com.web.repository.paymentsRepository;
import com.web.service.paymentsService;

@Service
public class paymentsServiceImpl implements paymentsService {

	@Autowired
	private paymentsRepository paymentsRepository;

	@Override
	public List<payments> findAll() {
		// TODO Auto-generated method stub
		return paymentsRepository.findAll();
	}

	@Override
	public payments findById(int paymentId) {
		Optional<payments> temp = paymentsRepository.findById(paymentId);
		return temp.isPresent() ? temp.get() : null;
	}
}
