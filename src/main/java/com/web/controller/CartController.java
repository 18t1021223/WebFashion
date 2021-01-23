package com.web.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.dto.cartDto;
import com.web.dto.mapKey;
import com.web.dto.toAddressDto;
import com.web.entity.orders;
import com.web.entity.payments;
import com.web.service.districtService;
import com.web.service.ordersService;
import com.web.service.paymentsService;
import com.web.service.provinceService;
import com.web.service.shippingCostService;
import com.web.service.toAddressService;
import com.web.service.wardService;

@Controller
@RequestMapping("/cart")
public class CartController extends baseController {

	@GetMapping(value = { "/", "" })
	public ModelAndView cartPage(HttpServletRequest req, HttpServletResponse resp) {
		_mav.setViewName("cart");
		getCart(req, resp);
		return _mav;
	}

	@GetMapping("/addCart")
	public ResponseEntity<Map<mapKey, cartDto>> addCart(@RequestParam(value = "productId") long productId,
			@RequestParam(value = "quantity", defaultValue = 1 + "", required = false) int quantity,
			@RequestParam(value = "sizeId", defaultValue = 0 + "", required = false) long sizeId,
			@RequestParam(value = "colorId", defaultValue = 0 + "", required = false) long colorId,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<mapKey, cartDto> cart = new LinkedHashMap<>();

		cart = cartService.getCart(req);
		cart = cartService.addCart(productId, quantity, sizeId, colorId, cart);
		if (cart == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		Cookie cookie = new Cookie("cart", cartService.saveCart(cart));
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 60);
		resp.addCookie(cookie);

		return new ResponseEntity<Map<mapKey, cartDto>>(cartService.reverseCart(cart), HttpStatus.OK);
	}

	@RequestMapping(value = { "/deleteCart" })
	public ResponseEntity<?> deleteCart(@RequestParam(value = "productId") long productId,
			@RequestParam(value = "sizeId", defaultValue = 0 + "", required = false) long sizeId,
			@RequestParam(value = "colorId", defaultValue = 0 + "", required = false) long colorId,
			HttpServletRequest req, HttpServletResponse resp) {

		Map<mapKey, cartDto> cart = new LinkedHashMap<>();

		cart = cartService.getCart(req);
		cart = cartService.deleteCart(productId, sizeId, colorId, cart);
		Cookie cookie = new Cookie("cart", cartService.saveCart(cart));
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 60);
		resp.addCookie(cookie);

		return ResponseEntity.ok(cartService.reverseCart(cart));
	}

	@RequestMapping(value = { "/editCart" })
	public ResponseEntity<?> editCart(@RequestParam(value = "productId") long productId,
			@RequestParam(value = "sizeId", defaultValue = 0 + "", required = false) long sizeId,
			@RequestParam(value = "colorId", defaultValue = 0 + "", required = false) long colorId,
			@RequestParam(value = "quantity") int quantity, HttpServletRequest req, HttpServletResponse resp) {

		Map<mapKey, cartDto> cart = new LinkedHashMap<>();

		cart = cartService.getCart(req);
		cart = cartService.editCart(productId, quantity, sizeId, colorId, cart);
		Cookie cookie = new Cookie("cart", cartService.saveCart(cart));
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 60);
		resp.addCookie(cookie);

		return ResponseEntity.ok(cartService.reverseCart(cart));
	}

	@Autowired
	private provinceService provinceService;
	@Autowired
	private districtService districtService;
	@Autowired
	private wardService wardService;
	@Autowired
	private shippingCostService shippingCostService;
	@Autowired
	private paymentsService paymentsService;
	@Autowired
	private toAddressService toAddressService;
	@Autowired
	private ordersService ordersService;

	@GetMapping(value = { "/checkout-address" })
	public ModelAndView checkout_addressPage(Model model, HttpServletRequest req, HttpServletResponse resp) {
		Map<mapKey, cartDto> cart = new LinkedHashMap<>();
		cart = cartService.getCart(req);
		if (cart.size() <= 0) {
			_mav.setViewName("redirect:/cart");
			return _mav;
		}
		cart = cartService.reverseCart(cart);
		_mav.addObject("cart", cart);
		// TỔNG TIỀN HÀNG
		_mav.addObject("totalPriceCart", cartService.totalPriceCart(cart));

		_mav.setViewName("checkout-address");
		model.addAttribute("toAddress", new toAddressDto());
		_mav.addObject("province", provinceService.findbyAll());
		return _mav;
	}

	@RequestMapping(value = { "/checkout-details" })
	public ModelAndView checkoutPage(@ModelAttribute(name = "toAddress") @Valid toAddressDto address, BindingResult b,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		Map<mapKey, cartDto> cart = new LinkedHashMap<>();
		cart = cartService.getCart(req);
		if (cart.size() <= 0) {
			_mav.setViewName("redirect:/cart");
			return _mav;
		}
		cart = cartService.reverseCart(cart);
		_mav.addObject("cart", cart);
		// TỔNG TIỀN HÀNG
		_mav.addObject("totalPriceCart", cartService.totalPriceCart(cart));

		if (b.hasErrors()) {
			_mav.setViewName("checkout-address");
			_mav.addObject("province", provinceService.findbyAll());
			try {
				_mav.addObject("provinceSelected", Integer.parseInt(address.getProvince()));
			} catch (Exception e) {
			}

			if (b.hasFieldErrors("province") == false) {
				_mav.addObject("district", districtService.findByProvinceId(Integer.parseInt(address.getProvince())));
				_mav.addObject("districtSelected", Integer.parseInt(address.getDistrict()));
			}
			if (b.hasFieldErrors("district") == false) {
				_mav.addObject("ward", wardService.findByDistrictId(Integer.parseInt(address.getDistrict())));
				_mav.addObject("wardSelected", Integer.parseInt(address.getWard()));
			}
			return _mav;
		}
		_mav.addObject("shippingCost", shippingCostService.getTop1());
		toAddressDto temp = toAddressService.getToAddressDto(address);
		if (temp == null) {
			_mav.setViewName("common/error");
			return _mav;
		}
		HttpSession session = req.getSession();
		session.setAttribute("addressSession", temp);
		_mav.addObject("payments", paymentsService.findAll());
		_mav.setViewName("checkout-details");
		return _mav;
	}

	@GetMapping("/district")
	public ResponseEntity<?> getProvince(@RequestParam(value = "provinceId") int provinceId) {
		return ResponseEntity.ok(districtService.findByProvinceId(provinceId));
	}

	@GetMapping("/ward")
	public ResponseEntity<?> getWard(@RequestParam(value = "districtId") int districtId) {
		return ResponseEntity.ok(wardService.findByDistrictId(districtId));
	}

	// xóa địa chỉ
	@GetMapping("/order")
	public ModelAndView orderPage(@RequestParam(value = "payment") int payment, HttpServletRequest req,
			HttpServletResponse resp) {
		// LƯU HÓA ĐƠN VÀ XÓA GIỞ HÀNG
		try {

			Map<mapKey, cartDto> cart = new LinkedHashMap<>();
			cart = cartService.getCart(req);
			if (cart.size() <= 0) {
				_mav.setViewName("redirect:/cart");
				return _mav;
			}
			cart = cartService.reverseCart(cart);
			_mav.addObject("cart", cart);
			_mav.addObject("totalPriceCart", cartService.totalPriceCart(cart));

			payments temp = paymentsService.findById(payment);

			HttpSession session = req.getSession();
			// NẾU TẠO HÓA ĐƠN THÀNH CÔNG THÌ XÓA GIỞ HÀNG
			orders rs = ordersService.saveAll(cart, temp, (toAddressDto) session.getAttribute("addressSession"));

			cartService.removeCart(req, resp);
			_mav.addObject("order", rs);
			_mav.addObject("payment", temp);
			_mav.setViewName("order");

		} catch (Exception e) {
			_mav.setViewName("common/error");
			return _mav;
		}
		return _mav;
	}

}
