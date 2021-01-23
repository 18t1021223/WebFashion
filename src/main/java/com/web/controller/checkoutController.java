package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/checkout")
public class checkoutController extends baseController {
	@GetMapping(value = { "/", "" })
	public ModelAndView checkoutPage() {
		_mav.setViewName("checkout-address");

		return _mav;
	}
}
