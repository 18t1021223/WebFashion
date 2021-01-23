package com.web.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.converted.productsConverted;
import com.web.dto.cartDto;
import com.web.dto.mapKey;
import com.web.dto.productsDto;
import com.web.entity.colors;
import com.web.entity.products;
import com.web.entity.sizes;
import com.web.service.cartService;
import com.web.service.colorsService;
import com.web.service.productsService;
import com.web.service.sizesService;

@Service
public class cartServiceImpl implements cartService {

	@Autowired
	private productsService prodService;
	@Autowired
	private colorsService colorsService;
	@Autowired
	private sizesService sizesService;

	@Override
	public Map<mapKey, cartDto> getCart(HttpServletRequest req) {
		Map<mapKey, cartDto> cart = new LinkedHashMap<>();
		Cookie cookieArr[] = req.getCookies();
		for (Cookie ck : cookieArr) {
			if (ck.getName().equals("cart")) {
				cart = getValue(ck.getValue().split("[|]"));
				break;
			}
		}
		return cart;
	}

	/**
	 * 
	 * @param value - VALUE CỦA COOKIE
	 * @return -TRẢ VỀ 1 MAP CHỨA KHÓA LÀ key.class , GIÁ TRỊ LÀ cartDto.class
	 */
	private Map<mapKey, cartDto> getValue(String[] value) {
		Map<mapKey, cartDto> result = new LinkedHashMap<>();
		for (String temp : value) {
			String data[] = temp.split("[-]");
			try {
				long productId = Long.parseLong(data[0]);
				int quantity = Integer.parseInt(data[1]);
				long sizeId = Long.parseLong(data[2]);
				long colorId = Long.parseLong(data[3]);
				if (prodService.productExists(productId, sizeId, colorId) == true && quantity > 0) {
					products prod = prodService.findById(productId);
					List<sizes> listSize = new ArrayList<>();
					listSize.add(sizesService.findById(sizeId));
					prod.setSizes(listSize);
					List<colors> listColor = new ArrayList<>();
					listColor.add(colorsService.findById(colorId));
					prod.setColors(listColor);
					productsDto prodConvert = productsConverted.entityToDto(prod);
					result.put(new mapKey(productId, sizeId, colorId), new cartDto(quantity,
							quantity * (prod.getProductPrice() - prod.getProductDiscount()), prodConvert));
				}
			} catch (Exception e) {
			}
		}
		return result;
	}

	@Override
	public Map<mapKey, cartDto> getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double totalPriceCart(Map<mapKey, cartDto> cart) {
		double total = 0;
		Set<mapKey> key = cart.keySet();
		for (mapKey mapKey : key) {
			total += cart.get(mapKey).getTotalPrice();
		}
		return total;
	}

	@Override
	public Map<mapKey, cartDto> addCart(long productId, int quantity, long sizeId, long colorId,
			Map<mapKey, cartDto> cart) {
		cartDto cartdto = new cartDto();
		// ĐÃ KIỂM TRA ĐẦU VÀO ĐỊNH DẠNG HỢP LỆ Ở JS
		if (prodService.productExists(productId, sizeId, colorId) == true && quantity > 0) {
			mapKey mapkey = new mapKey(productId, sizeId, colorId);
			if (cart.containsKey(mapkey)) {
				cartdto = cart.get(mapkey);
				cartdto.setProd(productsConverted.entityToDto(prodService.findById(productId)));
				cartdto.setQuantity(quantity + cartdto.getQuantity());
				cartdto.setTotalPrice(cartdto.getQuantity()
						* (cartdto.getProd().getProductPrice() - cartdto.getProd().getProductDiscount()));
			} else {
				cartdto.setProd(productsConverted.entityToDto(prodService.findById(productId)));
				cartdto.setQuantity(quantity);
				cartdto.setTotalPrice(cartdto.getQuantity()
						* (cartdto.getProd().getProductPrice() - cartdto.getProd().getProductDiscount()));
			}
			cart.put(mapkey, cartdto);
		} else {
			return null;
		}
		return cart;
	}

	@Override
	public String saveCart(Map<mapKey, cartDto> cart) {
		String value = "";
		Set<mapKey> key = cart.keySet();
		for (mapKey id : key) {
			cartDto temp = cart.get(id);
			value += id.getProductId() + "-" + temp.getQuantity();
			value += "-" + id.getSizeId();
			value += "-" + id.getColorId();
			value += "|";
		}
		if (value.isEmpty())
			return null;
		return value.substring(0, value.lastIndexOf("|"));
	}

	@Override
	public Map<mapKey, cartDto> reverseCart(Map<mapKey, cartDto> cart) {
		Map<mapKey, cartDto> reverse = new LinkedHashMap<>();
		Set<mapKey> key = cart.keySet();
		mapKey[] arrKey = new mapKey[key.size()];
		key.toArray(arrKey);
		for (int i = arrKey.length - 1; i >= 0; i--) {
			reverse.put(arrKey[i], cart.get(arrKey[i]));
		}
		return reverse;
	}

	@Override
	public Map<mapKey, cartDto> deleteCart(long productId, long sizeId, long colorId, Map<mapKey, cartDto> cart) {
		if (cart != null) {
			cart.remove(new mapKey(productId, sizeId, colorId));
		}
		return cart;
	}

	@Override
	public Map<mapKey, cartDto> editCart(long productId, int quantity, long sizeId, long colorId,
			Map<mapKey, cartDto> cart) {
		cartDto cartdto = cart.get(new mapKey(productId, sizeId, colorId));
		if (cartdto != null) {
			cartdto.setQuantity(quantity);
			cartdto.setTotalPrice(cartdto.getQuantity()
					* (cartdto.getProd().getProductPrice() - cartdto.getProd().getProductDiscount()));
		}
		return cart;
	}

	@Override
	public void removeCart(HttpServletRequest req, HttpServletResponse resp) {
		Cookie cookie[] = req.getCookies();
		for (Cookie c : cookie) {
			if (c.getName().equals("cart")) {
				c.setValue("");
				c.setPath("/");
				c.setMaxAge(0);
				resp.addCookie(c);
				break;
			}
		}
	}

}
