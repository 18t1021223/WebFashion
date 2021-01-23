package com.web.service;

import com.web.entity.categories;
import com.web.entity.products;

import java.util.List;

public interface productsService {

	/**
	 * @param page          -trang muốn hiển thị
	 * @param pageSize      -tổng sản phẩm trên 1 trang
	 * @param orderBy       -sắp xếp theo
	 * @param categoryId    -tim dựa vào parentId (=0 nếu muốn tìm trên tất cả dữ
	 *                      liệu)
	 * @param productStatus -trạng thái của sản phẩm (0-1)
	 * @param keywordSearch -tìm kiếm sản phẩm theo tên. (= null nếu không tìm)
	 * @return -trả về danh sách các sản phẩm
	 */
	List<products> getProducts(int page, int pageSize, int orderBy, int categoryId, boolean productStatus,
			String keywordSearch);

	/**
	 * @param status : trạng thái của sản phẩm ( 0 - 1)
	 * @return trả về danh sách có status
	 */

	long getTotalProduct(Boolean status);

	/**
	 * @param categoryId
	 * @param categoryStatus trạng thái sản phẩm ( 0 - 1)
	 * @param keywordSearch
	 * @return trả về số lượng sp có mã là categoryId
	 */
	long count(int categoryId, Boolean categoryStatus, String keywordSearch);

	/**
	 * LẤY CÁC DANH MỤC CHA CỦA CATEGORY_ID
	 *
	 * @param categoryId
	 * @return
	 */
	List<categories> getParentCategories(int categoryId);

	/**
	 *
	 * @param productId
	 * @return - TRẢ VỀ THONG TIN SẢN PHẨM , NẾU KHÔNG TỒN TẠI THÌ TRẢ VỀ NULL
	 */
	products findById(long productId);

	/**
	 * kiểm tra thông tin sản phẩm tồn tại hay không
	 * 
	 * @param productId
	 * @param sizeId
	 * @param colorId
	 * @return trả về trues nếu sản phẩm tồn tại
	 */
	boolean productExists(long productId, long sizeId, long colorId);
}
