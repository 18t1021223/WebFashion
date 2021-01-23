package com.web.service;

import com.web.dto.cartDto;
import com.web.dto.mapKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

public interface cartService {
	/**
	 * LẤY GIỞ HÀNG Ở COOKIE VỚI KHÁCH CHƯA ĐĂNG NHẬP HỆ THỐNG VALUE LƯU DƯỚI DẠNG :
	 * 1001-20-1-0|1523-1-0-0|20-2-5-3
	 * 
	 * @param req
	 * @return
	 */
	Map<mapKey, cartDto> getCart(HttpServletRequest req);

	Map<mapKey, cartDto> getCart();

	Map<mapKey, cartDto> addCart(long productId, int quantity, long size, long color, Map<mapKey, cartDto> cart);

	Map<mapKey, cartDto> editCart(long productId, int quantity, long sizeId, long colorId, Map<mapKey, cartDto> cart);
	
	void removeCart(HttpServletRequest req , HttpServletResponse resp);
	/**
	 * DÙNG CHO CẢ 2 TRƯỜNG HỢP (COOKIE / DATABASE)
	 * 
	 * @param productId
	 * @param sizeId
	 * @param colorId
	 * @param cart
	 * @return
	 */
	Map<mapKey, cartDto> deleteCart(long productId, long sizeId, long colorId, Map<mapKey, cartDto> cart);

	/**
	 * ĐỊNH DẠNG : ID-QUANTITY-SIZE-COLOR
	 * 
	 * @param cart
	 * @return : TRẢ VỀ 1 CHUỖI GỒM ID VÀ QIANTITY DÙNG ĐỂ LƯU VÀO COOKIE
	 * 
	 */
	String saveCart(Map<mapKey, cartDto> cart);

	double totalPriceCart(Map<mapKey, cartDto> cart);

	/**
	 * SẢN PHẨM THÊM ĐẦU SẼ HIỂN THỊ PHÍA ĐẦU TIÊN
	 * 
	 * @param cart
	 * @return TRẢ VỀ MAP ĐÃ ĐẢO NGƯỢC
	 */
	Map<mapKey, cartDto> reverseCart(Map<mapKey, cartDto> cart);
}
