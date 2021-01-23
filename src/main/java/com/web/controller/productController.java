package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.constants.constants;
import com.web.converted.productsConverted;
import com.web.dto.paginateDto;
import com.web.entity.categories;
import com.web.entity.products;
import com.web.service.colorsService;
import com.web.service.paginatesService;
import com.web.service.productsService;
import com.web.service.sizesService;

@Controller
@RequestMapping(value = { "/product" })
public class productController extends baseController {

	@Autowired
	private productsService prodService;
	@Autowired
	private paginatesService pagService;
	@Autowired
	private sizesService sizesService;
	@Autowired
	private colorsService colorsService;

	@GetMapping(value = { "/category" })
	public ModelAndView pageProducts(@RequestParam(value = "categoryId") int categoryId,
			@RequestParam(value = "orderBy", defaultValue = constants.ORDER_BY_PRODUCT_HIGHLIGHT
					+ "", required = false) int orderBy,
			@RequestParam(value = "page", defaultValue = 1 + "", required = false) int page,
			@RequestParam(value = "pageSize", defaultValue = constants.PAGE_SIZE_LIST
					+ "", required = false) int pageSize,
			@RequestParam(value = "productStatus", defaultValue = true + "", required = false) boolean productStatus,
			@RequestParam(value = "keywordSearch", defaultValue = "", required = false) String keywordSearch,
			HttpServletRequest req, HttpServletResponse resp) {
		_mav.setViewName("shop_gird");
		getCart(req, resp);
		/* =========LINK ====== */
		List<categories> parentCategory = prodService.getParentCategories(categoryId);
		_mav.addObject("parentCategory", parentCategory);

		/* =======LẤY DANH MỤC CON 1 CỦA categoryId ====== */
		List<categories> subCategories = categoriesService.findByParentId(categoryId);

		/* ===== thong tin của dannh mục cha ===== */
		categories parent = parentCategory.size() > 0 ? parentCategory.get(parentCategory.size() - 1) : null;
		/* NẾU BẰNG NULL CÓ NGHĨA : ĐÓ LÀ DANH MỤC CHA ĐẦU TIÊN */
		if (parent != null) {
			/*
			 * =======NẾU DANH MỤC con 1 RỖNG (NGHĨA LÀ : ID CUỐI CÙNG CỦA DANH MỤC) THÌ LẤY
			 * LẠI DANH MỤC CHA CỦA NÓ (BẰNG PARENT_iD)=====
			 */
			if (subCategories.size() == 0)
				subCategories = categoriesService.findByParentId(parent.getParentId());
		}
		_mav.addObject("categorySelect", subCategories);
		/*
		 * TỔNG SỐ SẢN PHẨM (NẾU TRẠNG THÁI SẢN PHẨM = NULL THÌ BỎ QUA ĐIỀU KIỆN STATUS)
		 * keywordSearch 
		 */
		long totalProduct = prodService.count(categoryId, productStatus ,keywordSearch);
		_mav.addObject("totalProduct", totalProduct);

		/* =========THÔNG TIN PHÂN TRANG ======== */
		paginateDto pag = pagService.getInfo(totalProduct, page, pageSize, orderBy, constants.NUMBER_PAGE_VIEW);
		_mav.addObject("paginate", pag);

		/* =========DANH SÁCH SẢN PHẨM ========= */
		_mav.addObject("product_select_by_category",
				prodService.getProducts(pag.getPage(), pag.getPageSize(), pag.getOrderBy(), categoryId, productStatus ,keywordSearch));

		return _mav;
	}

	@GetMapping(value = { "/info/{productId}" })
	public ModelAndView singelProductPage(@PathVariable(value = "productId") long productId, HttpServletRequest req,
			HttpServletResponse resp) {
		_mav.setViewName("single_product");
		/* LẤY GIỞ HÀNG */
		getCart(req, resp);

		/* KIỂM TRA SẢN PHẨM TỒN TẠI */
		products prod = prodService.findById(productId);
		if (prod == null) {
			_mav.setViewName("common/error");
			return _mav;
		}
		/* THÔNG TIN SẢN PHẨM */
		prod.setSizes(sizesService.findByProductId(productId));
		prod.setColors(colorsService.findByProductId(productId));
		_mav.addObject("product", productsConverted.entityToDto(prod));

		/* CÁC SẢN PHẨM LIÊN QUAN */
		_mav.addObject("productRelated", prodService.getProducts(1, constants.PAGE_SIZE_HOME, constants.ORDER_BY_RANDOM,
				prod.getCategory().getCategoryId(), true, ""));

		/* THÔNG TIN ĐƯỜNG DẪN */
		_mav.addObject("link", prodService.getParentCategories(prod.getCategory().getCategoryId()));
		return _mav;
	}
}
