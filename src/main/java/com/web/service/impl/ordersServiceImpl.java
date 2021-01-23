package com.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.converted.productsConverted;
import com.web.dto.cartDto;
import com.web.dto.mapKey;
import com.web.dto.productsDto;
import com.web.dto.toAddressDto;
import com.web.entity.colors;
import com.web.entity.orderDetails;
import com.web.entity.orders;
import com.web.entity.payments;
import com.web.entity.sizes;
import com.web.repository.ordersRepository;
import com.web.service.ordersService;

@Service
public class ordersServiceImpl implements ordersService {
	@Autowired
	private ordersRepository ordersRepository;

	public orders saveAll(Map<mapKey, cartDto> cart, payments payment, toAddressDto address) {
		orders order = new orders();
		order.setName(address.getName());
		order.setPhone(address.getPhone());
		if (address.getWard().equals(""))
			order.setAddress(address.getStreet() + ", " + address.getDistrict() + ", " + address.getProvince());
		else
			order.setAddress(address.getStreet() + ", " + address.getWard() + ", " + address.getDistrict() + ", "
					+ address.getProvince());
		order.setPayment(payment);
		order.setStatus(0);
		order.setCreateTime(new Date());

		List<orderDetails> orderDetails_list = new ArrayList<>();
		cart.forEach((k, v) -> {
			orderDetails temp = new orderDetails();
			productsDto pDto = v.getProd();

			temp.setProduct(productsConverted.dtoToEntity(pDto));
			temp.setQuantity(v.getQuantity());
			List<sizes> sizes = pDto.getSizes();
			if (sizes.size() > 0 && sizes.get(0) != null)
				temp.setSize(sizes.get(0).getSizeName());
			List<colors> colors = pDto.getColors();
			if (colors.size() > 0 && colors.get(0) != null)
				temp.setColor(colors.get(0).getColorName());
			temp.setDiscount(pDto.getProductDiscount());
			temp.setSalePrice(pDto.getProductPrice());
			temp.setProductName(pDto.getProductName());
			temp.setOrder(order);
			orderDetails_list.add(temp);
		});
		order.setOrderDetails(orderDetails_list);
		ordersRepository.saveAndFlush(order);
		return order;
	}

	@Override
	public orders findById(long orderId) {
		Optional<orders> order = ordersRepository.findById(orderId);
		return order.isPresent() ? order.get() : null;
	}
}
