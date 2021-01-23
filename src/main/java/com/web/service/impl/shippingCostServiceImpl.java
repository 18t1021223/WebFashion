package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.shippingCost;
import com.web.repository.shippingCostRepository;
import com.web.service.shippingCostService;

@Service
public class shippingCostServiceImpl implements shippingCostService {
	@Autowired
	private shippingCostRepository shippingCostRepository;

	@Override
	public shippingCost getTop1() {
		List<shippingCost> list = shippingCostRepository.findAll();
		return list.size() < 0 ? new shippingCost() : list.get(0);
	}

}
