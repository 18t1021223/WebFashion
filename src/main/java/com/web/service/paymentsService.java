package com.web.service;

import java.util.List;

import com.web.entity.payments;

public interface paymentsService {
	List<payments> findAll();

	payments findById(int paymentId);
}
