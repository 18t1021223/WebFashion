package com.web.service;

import java.util.Map;

import com.web.dto.cartDto;
import com.web.dto.mapKey;
import com.web.dto.toAddressDto;
import com.web.entity.orders;
import com.web.entity.payments;

public interface ordersService {
	public orders saveAll(Map<mapKey, cartDto> cart, payments payment, toAddressDto address);
	orders findById(long orderId);
}
