package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.constants.constants;
import com.web.entity.products;
import com.web.entity.slides;
import com.web.service.productsService;
import com.web.service.slidesService;

@Controller
public class homeController extends baseController {

	@Autowired
	private productsService prodService;

	@Autowired
	private slidesService slidesService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView pageHome(HttpServletRequest req ,HttpServletResponse resp) {
		_mav.setViewName("home");
		// CART
		getCart(req, resp);
		// ========slides============
		List<slides> slideAll = slidesService.findAll();
		_mav.addObject("slideAll", slideAll);

		List<products> products_select_new = prodService.getProducts(1, constants.PAGE_SIZE_HOME,
				constants.ORDER_BY_PRODUCT_NEW, 0, true ,"");
		_mav.addObject("products_select_new", products_select_new);

		List<products> products_select_highlight = prodService.getProducts(1, constants.PAGE_SIZE_HOME * 2,
				constants.ORDER_BY_PRODUCT_HIGHLIGHT, 0, true ,"");
		_mav.addObject("products_select_highlight", products_select_highlight);

		List<products> products_select_discount = prodService.getProducts(1, constants.PAGE_SIZE_HOME,
				constants.ORDER_BY_PRODUCT_DISCOUNT, 0, true ,"");
		_mav.addObject("products_select_discount", products_select_discount);

		return _mav;
	}
}
