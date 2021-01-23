package com.web.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.web.dto.cartDto;
import com.web.dto.mapKey;
import com.web.entity.categories;
import com.web.service.cartService;
import com.web.service.categoriesService;
import com.web.service.contactService;

@Controller
public class baseController {
	protected ModelAndView _mav = new ModelAndView();

	@Autowired
	protected categoriesService categoriesService;
	@Autowired
	protected cartService cartService;
	@Autowired
	protected contactService contactService;

	@PostConstruct
	public ModelAndView categorySearch() {
		List<categories> data = categoriesService.findAll();
		_mav.addObject("categorySearch", categoriesService.getSubCategories(data, 0, 0));
		_mav.addObject("contact", contactService.findTop1());
		return _mav;
	}

	protected void getCart(HttpServletRequest req, HttpServletResponse resp) {
		Map<mapKey, cartDto> cart = new LinkedHashMap<>();
		cart = cartService.getCart(req);
		cart = cartService.reverseCart(cart);
//			Cookie cookie = new Cookie("cart", cartService.saveCart(cart));
//			cookie.setPath("/");
//			cookie.setMaxAge(60 * 60 * 24 * 60);
//			resp.addCookie(cookie);

		_mav.addObject("cart", cart);
		// TỔNG TIỀN HÀNG
		_mav.addObject("totalPriceCart", cartService.totalPriceCart(cart));
	}
}
